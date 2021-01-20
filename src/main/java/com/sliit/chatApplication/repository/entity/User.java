package com.sliit.chatApplication.repository.entity;

import com.sliit.chatApplication.model.UserDTO;
import lombok.*;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

//@Getter
//@Setter
@Entity
//@AllArgsConstructor
//@NoArgsConstructor
public class User extends SuperEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long userId;
    String userName;

    String email;
    String password;
    UserDTO.Gender gender;
    Date birthDay;
    String country;
    String city;



//    @OneToMany(mappedBy = "user")
//    private List<OrderDetails> orderList;


    public User() {
    }

    public User(String userName, String email, String password, UserDTO.Gender gender, Date birthDay, String country, String city) {
        this.userName = userName;
        this.email = email;
        this.password = password;
        this.gender = gender;
        this.birthDay = birthDay;
        this.country = country;
        this.city = city;
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

    public Date getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(Date birthDay) {
        this.birthDay = birthDay;
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
}
