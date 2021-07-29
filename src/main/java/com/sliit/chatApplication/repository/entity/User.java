package com.sliit.chatApplication.repository.entity;

import com.sliit.chatApplication.model.UserDTO;
import lombok.*;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
public class User extends SuperEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long userId;
    private String userName;
    private  String email;
    private  String password;
    private  UserDTO.Gender gender;
    private  String country;
    private  String city;
    private  float age;
    private  String sessionId;
    private  String occupation;


    public User() {
    }

    public User(long userId, String userName, String email, String password, UserDTO.Gender gender, String country, String city, float age, String sessionId, String occupation) {
        this.userId = userId;
        this.userName = userName;
        this.email = email;
        this.password = password;
        this.gender = gender;
        this.country = country;
        this.city = city;
        this.age = age;
        this.sessionId = sessionId;
        this.occupation = occupation;
    }

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public UserDTO.Gender getGender() {
        return gender;
    }

    public void setGender(UserDTO.Gender gender) {
        this.gender = gender;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public float getAge() {
        return age;
    }

    public void setAge(float age) {
        this.age = age;
    }
}
