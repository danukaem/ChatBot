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

    @Query(value = "select * from item where color like ?1 and brand like ?2 and category like ?3 and price <= ?4 and ram >= ?5 and screen >= ?6", nativeQuery = true)
    List<Item> getRecommendItems(String color,String brand,String category,Double price,Double ram ,Double screen);

    @Query(value = "select * from item where color like ?1 and brand like ?2 and category like ?3 and  ram >= ?4 and screen >= ?5", nativeQuery = true)
    List<Item> getRecommendItemswithoutPrice(String color,String brand,String category,Double ram ,Double screen);

    List<Item>  findAllByBrand(String brand);


    Optional<Item> findByItemCode(String code);

    @Query(value = "select brand,color,item_category,ram,price,screen,age,gender,occupation,item_id,itm_ordr.item_code,district  from item_extract_rasa ier INNER JOIN `user` ur on ur.user_id = ier.user_id LEFT JOIN order_details od on ier.session_id = od.session_id  LEFT JOIN (select ord.order_id order_id ,ord.session_id  session_id,ord.state_of_order state_of_order ,im.item_id item_id , im.item_code from order_details ord INNER JOIN cart_item ci on  ord.order_id = ci.order_detail_id INNER JOIN item im on ci.item_id = im.item_id) itm_ordr on itm_ordr.session_id = ier.session_id where itm_ordr.state_of_order =0 and ur.user_id = ?1 AND ur.session_id = ?2 LIMIT 1", nativeQuery = true)
    List<String[]>  findModel2InputData(float userId, String sessionId);

}
