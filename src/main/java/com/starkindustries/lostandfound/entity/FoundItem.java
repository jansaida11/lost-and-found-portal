package com.starkindustries.lostandfound.entity;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("FOUND")
public class FoundItem extends Item{

    @Override
    public String getItemType() {
        return "FOUND";
    }
}
