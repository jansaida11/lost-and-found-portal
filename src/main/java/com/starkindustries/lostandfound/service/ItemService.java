package com.starkindustries.lostandfound.service;

import com.starkindustries.lostandfound.dto.ItemMapper;
import com.starkindustries.lostandfound.dto.RequestItemDTO;
import com.starkindustries.lostandfound.dto.ResponseItemDTO;
import com.starkindustries.lostandfound.dto.UpdateReqDTO;
import com.starkindustries.lostandfound.entity.FoundItem;
import com.starkindustries.lostandfound.entity.Item;
import com.starkindustries.lostandfound.entity.LostItem;
import com.starkindustries.lostandfound.exceptions.BadRequestException;
import com.starkindustries.lostandfound.exceptions.ResourceNotFoundException;
import com.starkindustries.lostandfound.repository.ItemRepository;
import com.starkindustries.lostandfound.util.ItemStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    //Retrieving by Status of items
    public List<ResponseItemDTO> getByStatus(ItemStatus status) {
        List<Item> items = itemRepository.findByStatus(status);
        if(items.isEmpty()){
            throw new ResourceNotFoundException("No Item was found with status: "+status);
        }
        List<ResponseItemDTO> responseItemDTOS = new ArrayList<>();

        for(Item item : items){
            responseItemDTOS.add(ItemMapper.toResponseDTO(item));
        }
        return responseItemDTOS;
    }

    //Retrieving by type of items
    public List<ResponseItemDTO> getByType(String type) {

        List<ResponseItemDTO> responseItemDTOS = new ArrayList<>();

        String upperType = type.toUpperCase();

        if (!upperType.equals("LOST") && !upperType.equals("FOUND")) {
            throw new BadRequestException("Invalid type. Allowed values are LOST or FOUND.");
        }

        List<Item> items = itemRepository.findByType(upperType);
        if (items.isEmpty()) {
            throw new ResourceNotFoundException("No found items available in the system yet.");
        }

        for(Item item : items){
            responseItemDTOS.add(ItemMapper.toResponseDTO(item));
        }
        return responseItemDTOS;
    }

    //Deleting an item by ID
    public String deleteItem(Long id) {
        if (!itemRepository.existsById(id)) {
            throw new ResourceNotFoundException("Item not found with ID: " + id);
        }
        itemRepository.deleteById(id);
        return "Item deleted successfully.";
    }

    //Updating an item by ID
    public ResponseItemDTO updateItem(Long id, UpdateReqDTO updateReqDTO) {
        Item item = itemRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Item not found with ID: " + id));

        Item updatedItem = ItemMapper.updateItemDetails(updateReqDTO, item);

        itemRepository.save(updatedItem);

        return ItemMapper.toResponseDTO(updatedItem);
    }


}
