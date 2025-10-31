package com.starkindustries.lostandfound.dto;

import com.starkindustries.lostandfound.util.ItemStatus;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Getter;

import java.time.LocalDate;
import java.util.Date;

//@Getter
public class RequestItemDTO {
    private String name;
    private String description;
    private String location;
    private LocalDate date;
    private String contactName;
    private String contactEmail;
    private String contactPhone;

    public String getContactEmail() {
        return contactEmail;
    }

    public String getContactName() {
        return contactName;
    }

    public String getContactPhone() {
        return contactPhone;
    }

    public LocalDate getDate() {
        return date;
    }

    public String getDescription() {
        return description;
    }

    public String getLocation() {
        return location;
    }

    public String getName() {
        return name;
    }
}
