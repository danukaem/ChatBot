package com.sliit.chatApplication.service.impl;

import com.sliit.chatApplication.model.Converter;
import com.sliit.chatApplication.model.ItemCategory;
import com.sliit.chatApplication.model.ItemDTO;
import com.sliit.chatApplication.repository.ItemRepository;
import com.sliit.chatApplication.repository.entity.Item;
import com.sliit.chatApplication.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ItemServiceImpl implements ItemService {
    ItemRepository itemRepository;

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
        categoryList.add(ItemCategory.ELECTRONIC);
        categoryList.add(ItemCategory.APPAREL);
        categoryList.add(ItemCategory.VEHICLE_AND_ACCESSORIES);
        categoryList.add(ItemCategory.MACHINERY);
        categoryList.add(ItemCategory.HOMEANDGARDEN);
        categoryList.add(ItemCategory.BEAUTY_AND_PERSONALCARE);
        return categoryList;
    }
}
