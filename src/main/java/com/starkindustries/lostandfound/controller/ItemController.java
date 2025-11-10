package com.starkindustries.lostandfound.controller;

import com.starkindustries.lostandfound.dto.RequestItemDTO;
import com.starkindustries.lostandfound.dto.ResponseItemDTO;
import com.starkindustries.lostandfound.dto.UpdateReqDTO;
import com.starkindustries.lostandfound.service.ItemService;
import com.starkindustries.lostandfound.util.ItemStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;


@RestController
@RequestMapping("/api/items")
public class ItemController {

    @Autowired
    private ItemService itemService;

    @PostMapping("/lost")
    public ResponseEntity<ResponseItemDTO> postLostItem(@RequestBody RequestItemDTO requestItemDTO){
        return ResponseEntity.status(HttpStatus.CREATED).body(itemService.postLostItem(requestItemDTO));
    }

    @PostMapping("/found")
    public ResponseEntity<ResponseItemDTO> postFoundItem(@RequestBody RequestItemDTO requestItemDTO){
        return ResponseEntity.status(HttpStatus.CREATED).body(itemService.postFoundItem(requestItemDTO));
    }

    @GetMapping()
    public ResponseEntity<List<ResponseItemDTO>> getAllItems(){
        List<ResponseItemDTO> items = itemService.getAllItems();
        return ResponseEntity.ok(items); // 200 OK
    }

    @GetMapping("/status/{status}")
    public ResponseEntity<List<ResponseItemDTO>> getByStatus(@PathVariable ItemStatus status){
        return ResponseEntity.ok(itemService.getByStatus(status));
    }

    @GetMapping("/type/{type}")
    public ResponseEntity<List<ResponseItemDTO>> getByType(@PathVariable String type){
        return ResponseEntity.ok(itemService.getByType(type));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteItem(@PathVariable Long id) {
        String response = itemService.deleteItem(id);
        if (response.contains("not found")) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
        }
        return ResponseEntity.ok(response); //200 OK
    }

    @PatchMapping("/{id}")
    public ResponseEntity<ResponseItemDTO> updateItem(@PathVariable Long id, @RequestBody UpdateReqDTO updateReqDTO){

            ResponseItemDTO updatedItem = itemService.updateItem(id,updateReqDTO);
            return ResponseEntity.ok(updatedItem);

    }




}
