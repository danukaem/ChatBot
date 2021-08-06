package com.sliit.chatApplication.service.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sliit.chatApplication.model.Converter;
import com.sliit.chatApplication.model.ItemCategory;
import com.sliit.chatApplication.model.ItemDTO;
import com.sliit.chatApplication.model.Model2Input;
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
    ItemRepository userRepository;

    @Autowired
    ItemRepository itemRepository;
    @Autowired
    ItemExtractRasaRepository rasaRepository;
    @Autowired
    HttpService httpService;
    @Autowired
    private ObjectMapper objectMapper;

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
    public List<Item> getRecommendItems(float userId, String sessionId, boolean advancedSearch) throws JsonProcessingException {
        Optional<ItemExtractRasa> extractRasa = rasaRepository.findByUserIdAndSessionId(userId, sessionId);

        if (extractRasa.isPresent()) {
            ItemExtractRasa rasa = extractRasa.get();

            String color = "%" + rasa.getColor().trim() + "%";
            String brand = "%" + rasa.getBrand().trim() + "%";
            String processor = "%" + rasa.getProcessor().trim() + "%";
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
                recommendItemsQuery = itemRepository.getRecommendItems(color, brand, category, price, ram, screen,processor);

            } else {
                recommendItemsQuery = itemRepository.getRecommendItemswithoutPrice(color, brand, category, ram, screen,processor);

            }

            if (advancedSearch) {
                List<Item> forecastedItems = getForecastedItems(userId, sessionId);
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
    public List<Item> getForecastedItems(float userId, String sessionId) throws JsonProcessingException {
//        String urlModel1InputColumn = "http://localhost:5000/getModel1InputNames";
//        String urlModel1OutPutColumn = "http://localhost:5000/getModel1OutPutNames";
//        String urlPrediction = "http://localhost:5000/getForecastedItemsNewUser";

        String urlModel2InputColumn = "http://localhost:5000/getModel2InputNames";
        String urlModel2OutputColumn = "http://localhost:5000/getModel2OutPutNames";
        String urlPrediction = "http://localhost:5000/getForecastedItemsByUserId";

        ResponseEntity model1InputColumns = this.httpService.sendHttpGetUrlConnection(urlModel2InputColumn);
        List<String> inputColumnNames = filterModelInputColumns(model1InputColumns);
        List<String[]> model2InputData = this.userRepository.findModel2InputData(userId, sessionId);
        if (model2InputData.size() == 0) {
            return new ArrayList<Item>();
        }
        String[] dataFromDB = model2InputData.get(0);
        String[] inputData = new String[inputColumnNames.size()];
        for (int i = 0; i < inputData.length; i++) {
            inputData[i] = "0";
        }

        for (int i = 0; i < dataFromDB.length; i++) {
            for (int j = 0; j < inputColumnNames.size(); j++) {
                if (dataFromDB[i].trim().equals(inputColumnNames.get(j).trim())) {
                    inputData[j] = "1";
                }
            }
        }

        for (int i = 0; i < inputColumnNames.size(); i++) {
            if (inputColumnNames.get(i).trim().equals("ram") && !dataFromDB[3].trim().equals("")) {
                inputData[i] = dataFromDB[3];
            }
            if (inputColumnNames.get(i).trim().equals("price") && !dataFromDB[4].trim().equals("")) {
                inputData[i] = dataFromDB[4];
            }
            if (inputColumnNames.get(i).trim().equals("screen") && !dataFromDB[5].trim().equals("")) {
                inputData[i] = dataFromDB[5];
            }
            if (inputColumnNames.get(i).trim().equals("age") && !dataFromDB[7].trim().equals("")) {
                inputData[i] = dataFromDB[7];
            }
        }

        List<Float> inputDataList = new ArrayList<>();
        for (int i = 0; i < inputData.length; i++) {
            inputDataList.add(Float.parseFloat(inputData[i]));
        }
        Model2Input model2Input = new Model2Input();
        model2Input.setArray(inputDataList);
        ResponseEntity model2OutPutNames = this.httpService.sendHttpGetUrlConnection(urlModel2OutputColumn);
        ResponseEntity responseEntityItem = this.httpService.sentHttpPostConnection(urlPrediction, model2Input);
        List<Double> probabilities = filterItemProbabilities(responseEntityItem);
        List<String> itemCodes = filterModeOutputColumns(model2OutPutNames);

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
//                    item.setItemName(item.getItemName() + " ***");
                    item.setForecasted(true);
                    items.add(byItemCode.get());
                }
            }
        });
        return items;
    }

    @Override
    public ItemExtractRasa findByUserIdAndSessionIdPrevious(float userId, String sessionId) {
        return rasaRepository.findByUserIdAndSessionIdPrevious(userId, sessionId);

    }

    @Override
    public List<Item> getRecommendItemsForNewUser(float userId) {
        String urlModel1InputColumn = "http://localhost:5000/getModel1InputNames";
        String urlModel1OutPutColumn = "http://localhost:5000/getModel1OutPutNames";
        String urlPrediction = "http://localhost:5000/getForecastedItemsNewUser";

        ///////////////////////////////////////////////////////////////////////////
//        String urlModel2InputColumn = "http://localhost:5000/getModel2InputNames";
//        String urlModel2OutputColumn = "http://localhost:5000/getModel2OutPutNames";
//        String urlPrediction = "http://localhost:5000/getForecastedItemsByUserId";

        ResponseEntity model1InputColumns = this.httpService.sendHttpGetUrlConnection(urlModel1InputColumn);
        List<String> inputColumnNames = filterModelInputColumns(model1InputColumns);
        List<String[]> model1InputData = this.userRepository.findModel1InputData(userId);
        if (model1InputData.size() == 0) {
            return new ArrayList<Item>();
        }
        String[] dataFromDB = model1InputData.get(0);
        String[] inputData = new String[inputColumnNames.size()];
        for (int i = 0; i < inputData.length; i++) {
            inputData[i] = "0";
        }

        for (int i = 0; i < dataFromDB.length; i++) {
            for (int j = 0; j < inputColumnNames.size(); j++) {
                if (dataFromDB[i].trim().equals(inputColumnNames.get(j).trim())) {
                    inputData[j] = "1";
                }
            }
        }

        for (int i = 0; i < inputColumnNames.size(); i++) {
            if (inputColumnNames.get(i).trim().equals("age") && !dataFromDB[0].trim().equals("")) {
                inputData[i] = dataFromDB[0];
            }
        }

        List<Float> inputDataList = new ArrayList<>();
        for (int i = 0; i < inputData.length; i++) {
            inputDataList.add(Float.parseFloat(inputData[i]));
        }
        Model2Input model1Input = new Model2Input();
        model1Input.setArray(inputDataList);
        ResponseEntity model1OutPutNames = this.httpService.sendHttpGetUrlConnection(urlModel1OutPutColumn);
        ResponseEntity responseEntityItem = this.httpService.sentHttpPostConnection(urlPrediction, model1Input);
        List<Double> probabilities = filterItemProbabilities(responseEntityItem);
        List<String> itemCodes = filterModeOutputColumns(model1OutPutNames);

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

        List<Item> limitedItems = new ArrayList<>();

        int limit = 6;
        items.forEach(i -> {
            if (limitedItems.size() < limit) {
                limitedItems.add(i);
            }
        });


        return limitedItems;
        ///////////////////////////////////////////////////////////////////////////


    }

    List<Double> filterItemProbabilities(ResponseEntity responseEntity) {
        String res = responseEntity.getBody().toString();
        res = res.replaceAll("[{\"}\\[\\]]", "");
        res = res.replaceAll("[n]", "");
        res = res.replaceAll("[\\\\]", "");
        System.out.println(res);
        res = res.split(":")[1];
        System.out.println(res);
        String[] itemValues = res.split(" ");
        List<Double> probabilities = new ArrayList<>();
        for (int i = 0; i < itemValues.length; i++) {
            if (!itemValues[i].trim().equals("")) {
                probabilities.add(Double.parseDouble(itemValues[i].trim()));
            }
        }
        return probabilities;
    }

    List<String> filterModeOutputColumns(ResponseEntity responseEntity) {
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

    List<String> filterModelInputColumns(ResponseEntity responseEntity) {
        List<String> itemCodes = new ArrayList<>();
        String code = responseEntity.getBody().toString();
        code = code.replaceAll("[{}\"\\[\\]\\\\]", "");
        code = code.split(":")[1];
        code = code.replaceAll("occupation_", "");
        code = code.replaceAll("district_", "");
        code = code.replaceAll("item_category_", "");
        code = code.replaceAll("color_", "");
        code = code.replaceAll("gender_", "");
        code = code.replaceAll("brand_", "");
        code = code.replaceAll("processor_", "");
        code = code.replaceAll(" ", "");
        String[] model1_input_columns = code.split(",");
        for (int i = 0; i < model1_input_columns.length; i++) {
            itemCodes.add(model1_input_columns[i].trim());
        }
        return itemCodes;
    }

}
