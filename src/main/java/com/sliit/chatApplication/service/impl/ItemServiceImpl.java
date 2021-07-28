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
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ItemServiceImpl implements ItemService {

    @Autowired
    ItemRepository itemRepository;
    @Autowired
    ItemExtractRasaRepository rasaRepository;

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
    public List<Item> getRecommendItems(float userId, String sessionId) {
        Optional<ItemExtractRasa> extractRasa = rasaRepository.findByUserIdAndSessionId(userId, sessionId);

        if (extractRasa.isPresent()) {
            ItemExtractRasa rasa = extractRasa.get();

            String color = "%" + rasa.getColor().trim() + "%";
            String brand = "%" + rasa.getBrand().trim() + "%";
            String category = "%" + rasa.getItemCategory().trim() + "%";
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

            return recommendItemsQuery;

        }
        return null;
    }

    @Override
    public List<Item> findAllByBrand(String brand) {
        return itemRepository.findAllByBrand(  brand );

    }
}
