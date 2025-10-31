package com.starkindustries.lostandfound.entity;

import jakarta.persistence.DiscriminatorColumn;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@DiscriminatorValue("LOST")
@Data
public class LostItem extends Item {

    @Override
    public String getItemType() {
        return "LOST";
    }
}
