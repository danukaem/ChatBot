package com.sliit.chatApplication.repository;

import com.sliit.chatApplication.model.ItemDTO;
import com.sliit.chatApplication.repository.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Repository
public interface ItemRepository extends JpaRepository<Item, Long> {

    @Query(value = "select * from item limit ?1", nativeQuery = true)
    List<Item> getItemLimitedList(int itemLimit);

    @Query(value = "select * from item where color like ?1 and brand like ?2 and  processor like ?7 and category like ?3 and price <= ?4 and ram >= ?5 and screen >= ?6", nativeQuery = true)
    List<Item> getRecommendItems(String color,String brand,String category,Double price,Double ram ,Double screen,String processor);

    @Query(value = "select * from item where color like ?1 and brand like ?2 and processor like ?6 and category like ?3 and  ram >= ?4 and screen >= ?5", nativeQuery = true)
    List<Item> getRecommendItemswithoutPrice(String color,String brand,String category,Double ram ,Double screen,String processor);

    List<Item>  findAllByBrand(String brand);


    Optional<Item> findByItemCode(String code);

    @Query(value = "select brand,color,item_category,ram,price,screen,processor,age,gender,occupation,district from item_extract_rasa ier INNER JOIN `user` ur on ier.user_id = ur.user_id where  ier.user_id = ?1 and ier.session_id = ?2  limit 1", nativeQuery = true)
    List<String[]>  findModel2InputData(float userId, String sessionId);



    @Query(value = "select age,gender,occupation,district from `user` ur  where  ur.user_id = ?1  limit 1", nativeQuery = true)
    List<String[]>  findModel1InputData(float userId);

}
