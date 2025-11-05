package com.starkindustries.lostandfound.dto;

import com.starkindustries.lostandfound.entity.FoundItem;
import com.starkindustries.lostandfound.entity.Item;
import com.starkindustries.lostandfound.entity.LostItem;

public class ItemMapper {

    public static LostItem toLostEntity(RequestItemDTO requestItemDTO){
        LostItem lostItem = new LostItem();

        lostItem.setName(requestItemDTO.getName());
        lostItem.setDate(requestItemDTO.getDate());
        lostItem.setContactEmail(requestItemDTO.getContactEmail());
        lostItem.setDescription(requestItemDTO.getDescription());
        lostItem.setContactName(requestItemDTO.getContactName());
        lostItem.setContactEmail(requestItemDTO.getContactEmail());
        lostItem.setContactPhone(requestItemDTO.getContactPhone());
        lostItem.setLocation(requestItemDTO.getLocation());

        return lostItem;
    }

    public static FoundItem toFoundEntity(RequestItemDTO requestItemDTO){
        FoundItem foundItem = new FoundItem();

        foundItem.setName(requestItemDTO.getName());
        foundItem.setDate(requestItemDTO.getDate());
        foundItem.setContactEmail(requestItemDTO.getContactEmail());
        foundItem.setDescription(requestItemDTO.getDescription());
        foundItem.setContactName(requestItemDTO.getContactName());
        foundItem.setContactEmail(requestItemDTO.getContactEmail());
        foundItem.setContactPhone(requestItemDTO.getContactPhone());
        foundItem.setLocation(requestItemDTO.getLocation());

        return foundItem;
    }

    public static ResponseItemDTO toResponseDTO(Item item){
        ResponseItemDTO responseItemDTO = new ResponseItemDTO();

        responseItemDTO.setId(item.getId());
        responseItemDTO.setName(item.getName());
        responseItemDTO.setDate(item.getDate());
        responseItemDTO.setContactEmail(item.getContactEmail());
        responseItemDTO.setCreatedAt(item.getCreatedAt());
        responseItemDTO.setContactName(item.getContactName());
        responseItemDTO.setDescription(item.getDescription());
        responseItemDTO.setLocation(item.getLocation());
        responseItemDTO.setUpdatedAt(item.getUpdatedAt());
        responseItemDTO.setStatus(item.getStatus());
        responseItemDTO.setItemType(item.getItemType());
        return responseItemDTO;
    }

    public static Item updateItemDetails(UpdateReqDTO updateReqDTO, Item item){
        if (updateReqDTO.getStatus() != null) {
            item.setStatus(updateReqDTO.getStatus());
        }
        if (updateReqDTO.getDescription() != null) {
            item.setDescription(updateReqDTO.getDescription());
        }
        if (updateReqDTO.getLocation() != null) {
            item.setLocation(updateReqDTO.getLocation());
        }
        if (updateReqDTO.getContactPhone() != null) {
            item.setContactPhone(updateReqDTO.getContactPhone());
        }
        if (updateReqDTO.getContactEmail() != null) {
            item.setContactEmail(updateReqDTO.getContactEmail());
        }

        return item;
    }

}
