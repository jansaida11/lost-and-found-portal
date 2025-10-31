package com.starkindustries.lostandfound.controller;

import com.starkindustries.lostandfound.dto.RequestItemDTO;
import com.starkindustries.lostandfound.dto.ResponseItemDTO;
import com.starkindustries.lostandfound.entity.Item;
import com.starkindustries.lostandfound.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ItemController {

    @Autowired
    private ItemService itemService;

    @PostMapping("/lost")
    public ResponseItemDTO postLostItem(@RequestBody RequestItemDTO requestItemDTO){
        return itemService.postLostItem(requestItemDTO);
    }

    @PostMapping("/found")
    public ResponseItemDTO postFoundItem(@RequestBody RequestItemDTO requestItemDTO){
        return itemService.postFoundItem(requestItemDTO);
    }

    @GetMapping("/getAllItems")
    public List<Item> getAllItems(){
        return itemService.getAllItems();
    }
}
