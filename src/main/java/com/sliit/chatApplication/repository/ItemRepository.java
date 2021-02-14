package com.sliit.chatApplication.repository;

import com.sliit.chatApplication.repository.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ItemRepository extends JpaRepository<Item, Long> {

    @Query(value = "select * from item limit ?1", nativeQuery = true)
    List<Item> getItemLimitedList(int itemLimit);
}
