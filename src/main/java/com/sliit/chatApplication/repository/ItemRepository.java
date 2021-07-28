package com.sliit.chatApplication.repository;

import com.sliit.chatApplication.model.ItemDTO;
import com.sliit.chatApplication.repository.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ItemRepository extends JpaRepository<Item, Long> {

    @Query(value = "select * from item limit ?1", nativeQuery = true)
    List<Item> getItemLimitedList(int itemLimit);

    @Query(value = "select * from item where category=?1", nativeQuery = true)
    List<Item> findItemsbyCategory(int categoryNumber);

    @Query(value = "select * from item where color like ?1 and brand like ?2 and category like ?3 and price <= ?4 and ram >= ?5 and screen >= ?6", nativeQuery = true)
    List<Item> getRecommendItems(String color,String brand,String category,Double price,Double ram ,Double screen);

    @Query(value = "select * from item where color like ?1 and brand like ?2 and category like ?3 and  ram >= ?4 and screen >= ?5", nativeQuery = true)
    List<Item> getRecommendItemswithoutPrice(String color,String brand,String category,Double ram ,Double screen);

    @Query(value = "select * from item where color like ?1 ", nativeQuery = true)
    List<Item> aaa(String color);

    @Query(value = "?1", nativeQuery = true)
    List<Item> getRecommendItemsQuery(String query);
}
