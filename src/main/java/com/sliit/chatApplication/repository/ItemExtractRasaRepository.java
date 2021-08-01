package com.sliit.chatApplication.repository;

import com.sliit.chatApplication.repository.entity.ItemExtractRasa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface ItemExtractRasaRepository extends JpaRepository<ItemExtractRasa, Integer> {

    Optional<ItemExtractRasa> findAllBySessionId(String sessionId);

    Optional<ItemExtractRasa> findByUserIdAndSessionId(float userId, String sessionId);

    @Query(value = "select * from item_extract_rasa ier where ier.user_id =?1 and ier.session_id !=?2 ORDER BY ier.item_extract_id DESC limit 1", nativeQuery = true)
    ItemExtractRasa findByUserIdAndSessionIdPrevious(float userId, String sessionId);
}
