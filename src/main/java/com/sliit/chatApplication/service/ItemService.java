package com.sliit.chatApplication.service;

import com.sliit.chatApplication.model.ItemCategory;
import com.sliit.chatApplication.model.ItemDTO;
import com.sliit.chatApplication.repository.entity.Item;

import java.util.List;

public interface ItemService {
    ItemDTO addItem(ItemDTO itemDTO);
    List<ItemDTO> getItemList();
    List<ItemDTO> getItemLimitedList(int itemLimit);
    List<ItemCategory> getCategoryList();

    List<Item> getRecommendItems(float userId, String sessionId);

    List<Item> findAllByBrand(String brand);
}
