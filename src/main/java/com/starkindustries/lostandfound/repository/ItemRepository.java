package com.starkindustries.lostandfound.repository;

import com.starkindustries.lostandfound.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<Item,Long> {
}
