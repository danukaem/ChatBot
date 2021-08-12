package com.sliit.chatApplication.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.sliit.chatApplication.model.ItemCategory;
import com.sliit.chatApplication.model.ItemDTO;
import com.sliit.chatApplication.repository.entity.Item;
import com.sliit.chatApplication.repository.entity.ItemExtractRasa;
import com.sliit.chatApplication.service.ItemService;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.ArrayList;
import java.util.List;

@CrossOrigin("*")

@RestController
@RequestMapping("/item")
public class ItemController {

    @Autowired
    private ItemService itemService;

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

    @GetMapping("/getCategoryList")
    List<ItemCategory> getCategoryList() {
        return itemService.getCategoryList();
    }

    @GetMapping("/getRecommendItems")
    List<Item> getRecommendItems(@RequestParam("userId") float userId, @RequestParam("sessionId") String sessionId, @RequestParam("advancedSearch") boolean advancedSearch, @RequestParam("sqlSearch") boolean sqlSearch) throws JsonProcessingException {
        return itemService.getRecommendItems(userId, sessionId, advancedSearch, sqlSearch);
    }


    @GetMapping("/findAllByBrand")
    List<Item> findAllByBrand(@RequestParam("brand") String brand) {
        return itemService.findAllByBrand(brand);
    }

    @GetMapping("/getChatItemRequirements")
    public ItemExtractRasa getChatItemRequirements(@RequestParam("user_id") String userId, @RequestParam("session_id") String sessionId) {

        ItemExtractRasa chatItemRequirement = itemService.getChatItemRequirements(userId, sessionId);
        System.out.println(chatItemRequirement);
        return chatItemRequirement;
    }

    @GetMapping("/recommendItemsLoadHomePage")
    List<Item> recommendItemsLoadHomePage(@RequestParam("userId") float userId, @RequestParam("sessionId") String sessionId) throws JsonProcessingException {
        ItemExtractRasa extractRasa = itemService.findByUserIdAndSessionIdPrevious(userId, sessionId);
        if (extractRasa != null) {
            return itemService.getRecommendItems(userId, extractRasa.getSessionId(), true, true);

        } else {
            return itemService.getRecommendItemsForNewUser(userId);

        }
    }

}
