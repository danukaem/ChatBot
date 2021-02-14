package com.sliit.chatApplication.controller;

import com.sliit.chatApplication.model.ItemDTO;
import com.sliit.chatApplication.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;

@CrossOrigin("*")

@RestController
@RequestMapping("/item")
public class ItemController {

    ItemService itemService;

    @Autowired
    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }

    @PostMapping("/addItem")
    ItemDTO addItem(@RequestBody ItemDTO itemDTO) {
        return itemService.addItem(itemDTO);
    }

    @GetMapping("/getItemList")
    List<ItemDTO> getItemList() {
        return itemService.getItemList();
    }

    @GetMapping("/getItemList/{itemLimit}")
    List<ItemDTO> getItemLimitedList(@PathVariable("itemLimit") int itemLimit) {
        return itemService.getItemLimitedList(itemLimit);
    }


}
