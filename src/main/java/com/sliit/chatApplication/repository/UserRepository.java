package com.sliit.chatApplication.repository;

import com.sliit.chatApplication.repository.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    List<User> findByUserNameAndPassword(String userName, String password);

    User findByUserId(long userId);

}
