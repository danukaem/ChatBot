package com.sliit.chatApplication.service.impl;

import com.sliit.chatApplication.model.Converter;
import com.sliit.chatApplication.model.ItemCategory;
import com.sliit.chatApplication.model.ItemDTO;
import com.sliit.chatApplication.repository.ItemExtractRasaRepository;
import com.sliit.chatApplication.repository.ItemRepository;
import com.sliit.chatApplication.repository.entity.Item;
import com.sliit.chatApplication.repository.entity.ItemExtractRasa;
import com.sliit.chatApplication.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ItemServiceImpl implements ItemService {

    @Autowired
    ItemRepository itemRepository;
    @Autowired
    ItemExtractRasaRepository rasaRepository;
    @Autowired
    HttpService httpService;

    public ItemServiceImpl() {
    }

    @Autowired
    public ItemServiceImpl(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    @Override
    public ItemDTO addItem(ItemDTO itemDTO) {
        Item item = itemRepository.save(Converter.getEntity(itemDTO));
        return Converter.getDTO(item);
    }

    @Override
    public List<ItemDTO> getItemList() {
        return Converter.getDTOList(itemRepository.findAll());
    }

    @Override
    public List<ItemDTO> getItemLimitedList(int itemLimit) {
        return Converter.getDTOList(itemRepository.getItemLimitedList(itemLimit));
    }

    @Override
    public List<ItemCategory> getCategoryList() {

        List<ItemCategory> categoryList = new ArrayList<>();
        categoryList.add(ItemCategory.LAPTOP);
        categoryList.add(ItemCategory.PHONE);
        return categoryList;
    }

    @Override
    public List<Item> getRecommendItems(float userId, String sessionId, boolean advancedSearch) {
        Optional<ItemExtractRasa> extractRasa = rasaRepository.findByUserIdAndSessionId(userId, sessionId);

        if (extractRasa.isPresent()) {
            ItemExtractRasa rasa = extractRasa.get();

            String color = "%" + rasa.getColor().trim() + "%";
            String brand = "%" + rasa.getBrand().trim() + "%";
            String category;
            if (rasa.getItemCategory().trim().equals("phone") || rasa.getItemCategory().trim().equals("laptop")) {
                category = "%" + rasa.getItemCategory().trim() + "%";

            } else {
                category = "%%";
            }
            double price = 0;
            double ram = 0;
            double screen = 0;

            if (!rasa.getPrice().equals("")) {
                price = Double.parseDouble(rasa.getPrice().trim());
            }
            if (!rasa.getRam().equals("")) {
                ram = Double.parseDouble(rasa.getRam().trim());
            }
            if (!rasa.getScreen().equals("")) {
                screen = Double.parseDouble(rasa.getScreen().trim());
            }
            List<Item> recommendItemsQuery;
            if (price != 0) {
                recommendItemsQuery = itemRepository.getRecommendItems(color, brand, category, price, ram, screen);

            } else {
                recommendItemsQuery = itemRepository.getRecommendItemswithoutPrice(color, brand, category, ram, screen);

            }

            if (advancedSearch) {
                List<Item> forecastedItems = getForecastedItems();
                forecastedItems.forEach(i -> {
                    if (i.getCategory().equals(category)) {
                        recommendItemsQuery.add(i);
                    }
                });
            }
            return recommendItemsQuery;
        }
        return null;
    }

    @Override
    public List<Item> findAllByBrand(String brand) {
        return itemRepository.findAllByBrand(brand);

    }

    @Override
    public ItemExtractRasa getChatItemRequirements(String userId, String sessionId) {
        Optional<ItemExtractRasa> rasa = rasaRepository.findByUserIdAndSessionId(Float.parseFloat(userId), sessionId);
        if (rasa.isPresent()) {
            ItemExtractRasa itemExtractRasa = rasa.get();
            return itemExtractRasa;
        } else {
            return new ItemExtractRasa();
        }
    }

    @Override
    public List<Item> getForecastedItems() {

        String urlItem = "http://localhost:5000/getForecastedItems";
        String urlItemCode = "http://localhost:5000/getForecastedItemsCodes";
        ResponseEntity responseEntityItem = this.httpService.sendHttpGetUrlConnection(urlItem);
        List<Double> probabilities = filterItemProbabilities(responseEntityItem);
        ResponseEntity responseEntityCode = this.httpService.sendHttpGetUrlConnection(urlItemCode);
        List<String> itemCodes = filterItemCodes(responseEntityCode);

        Map<Double, String> itemCodeProbability = new HashMap<>();
        for (int i = 0; i < itemCodes.size(); i++) {
            itemCodeProbability.put(probabilities.get(i), itemCodes.get(i));
        }
        Map<Double, String> treeMap = new TreeMap<>(
                new Comparator<Double>() {
                    @Override
                    public int compare(Double o1, Double o2) {
                        return o2.compareTo(o1);
                    }
                });
        treeMap.putAll(itemCodeProbability);
        List<Item> items = new ArrayList<>();
        treeMap.forEach((k, v) -> {
            if (k > 0) {
                Optional<Item> byItemCode = itemRepository.findByItemCode(v);
                if (byItemCode.isPresent()) {
                    Item item = byItemCode.get();
                    item.setItemName(item.getItemName() + " ***");
                    items.add(byItemCode.get());
                }
            }
        });
        return items;
    }

    List<Double> filterItemProbabilities(ResponseEntity responseEntity) {
        String res = responseEntity.getBody().toString();
        res = res.replaceAll("[{}]", "");
        res = res.split(":")[1];
        res = res.replaceAll("[\"\\[\\]\"]", "");
        String[] itemValues = res.split(",");
        List<Double> probabilities = new ArrayList<>();
        for (int i = 0; i < itemValues.length; i++) {
            probabilities.add(Double.parseDouble(itemValues[i]));
        }
        return probabilities;
    }

    List<String> filterItemCodes(ResponseEntity responseEntity) {
        String res = responseEntity.getBody().toString();
        res = res.replaceAll("[{}\"\\[\\]\\\\]", "");
        String resCodes = res.split(":")[1];
        resCodes = resCodes.replaceAll("item_code_", "");
        String[] resCodesArray = resCodes.split(",");
        List<String> itemCodes = new ArrayList<>();
        for (int i = 0; i < resCodesArray.length; i++) {
            itemCodes.add(resCodesArray[i].trim());
        }
        return itemCodes;
    }

}
