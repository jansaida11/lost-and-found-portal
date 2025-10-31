package com.starkindustries.lostandfound.service;

import com.starkindustries.lostandfound.dto.ItemMapper;
import com.starkindustries.lostandfound.dto.RequestItemDTO;
import com.starkindustries.lostandfound.dto.ResponseItemDTO;
import com.starkindustries.lostandfound.entity.FoundItem;
import com.starkindustries.lostandfound.entity.Item;
import com.starkindustries.lostandfound.entity.LostItem;
import com.starkindustries.lostandfound.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    public List<Item> getAllItems() {
        return itemRepository.findAll();
    }
}
