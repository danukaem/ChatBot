package com.sliit.chatApplication.service;

import com.sliit.chatApplication.model.ItemDTO;

import java.util.List;

public interface ItemService {
    ItemDTO addItem(ItemDTO itemDTO);
    List<ItemDTO> getItemList();
}
