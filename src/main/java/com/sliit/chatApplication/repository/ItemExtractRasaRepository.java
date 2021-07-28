package com.sliit.chatApplication.repository;

import com.sliit.chatApplication.repository.entity.ItemExtractRasa;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ItemExtractRasaRepository extends JpaRepository<ItemExtractRasa, Integer> {

    Optional<ItemExtractRasa> findAllBySessionId(String sessionId);

    Optional<ItemExtractRasa> findByUserIdAndSessionId(float userId,String sessionId);

}
