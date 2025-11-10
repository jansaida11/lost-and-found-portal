package com.starkindustries.lostandfound.repository;

import com.starkindustries.lostandfound.entity.Item;
import com.starkindustries.lostandfound.util.ItemStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ItemRepository extends JpaRepository<Item,Long> {

    List<Item> findByStatus(ItemStatus status);

    @Query(value = "SELECT * FROM items WHERE `type` = :type", nativeQuery = true)
    List<Item> findByType(@Param("type") String type);
}
