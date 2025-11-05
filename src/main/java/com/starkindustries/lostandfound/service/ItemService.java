package com.starkindustries.lostandfound.service;

import com.starkindustries.lostandfound.dto.ItemMapper;
import com.starkindustries.lostandfound.dto.RequestItemDTO;
import com.starkindustries.lostandfound.dto.ResponseItemDTO;
import com.starkindustries.lostandfound.dto.UpdateReqDTO;
import com.starkindustries.lostandfound.entity.FoundItem;
import com.starkindustries.lostandfound.entity.Item;
import com.starkindustries.lostandfound.entity.LostItem;
import com.starkindustries.lostandfound.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class ItemService {

    @Autowired
    private ItemRepository itemRepository;

    //Adding a Lost item
    public ResponseItemDTO postLostItem(RequestItemDTO requestItemDTO) {

        LostItem lostItem = ItemMapper.toLostEntity(requestItemDTO);
        Item item = itemRepository.save(lostItem);
        return ItemMapper.toResponseDTO(item);

    }

    //Adding a Found item
    public ResponseItemDTO postFoundItem(RequestItemDTO requestItemDTO) {
        FoundItem foundItem = ItemMapper.toFoundEntity(requestItemDTO);
        Item item = itemRepository.save(foundItem);
        return ItemMapper.toResponseDTO(item);
    }

    //Retrieving all items
    public List<ResponseItemDTO> getAllItems() {
        List<Item> items = itemRepository.findAll();
        List<ResponseItemDTO> itemDTOS = new ArrayList<>();
        for(Item item : items){
            itemDTOS.add(ItemMapper.toResponseDTO(item));
        }
        return itemDTOS;
    }

    //Deleting an item by ID
    public String deleteItem(Long id) {
        if (!itemRepository.existsById(id)) {
            return "Item not found with ID: " + id;
        }
        itemRepository.deleteById(id);
        return "Item deleted successfully.";
    }

    public ResponseItemDTO updateItem(Long id, UpdateReqDTO updateReqDTO) {
        Item item = itemRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Item not found with ID: " + id));

        Item updatedItem = ItemMapper.updateItemDetails(updateReqDTO, item);
//        updatedItem.setUpdatedAt(LocalDateTime.now());

        itemRepository.save(updatedItem);

        return ItemMapper.toResponseDTO(updatedItem);
    }

}
