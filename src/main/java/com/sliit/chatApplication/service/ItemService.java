package com.sliit.chatApplication.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.sliit.chatApplication.model.ItemCategory;
import com.sliit.chatApplication.model.ItemDTO;
import com.sliit.chatApplication.repository.entity.Item;
import com.sliit.chatApplication.repository.entity.ItemExtractRasa;

import java.util.List;

public interface ItemService {
    ItemDTO addItem(ItemDTO itemDTO);

    List<ItemDTO> getItemList();

    List<ItemDTO> getItemLimitedList(int itemLimit);

    List<ItemCategory> getCategoryList();

    List<Item> getRecommendItems(float userId, String sessionId,boolean advancedSearch) throws JsonProcessingException;

    List<Item> findAllByBrand(String brand);

    ItemExtractRasa getChatItemRequirements(String userId, String sessionId);

    List<Item> getForecastedItems(float userId, String sessionId) throws JsonProcessingException;
}
