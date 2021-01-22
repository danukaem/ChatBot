package com.sliit.chatApplication.model;

import lombok.*;

import java.util.Date;

//@Data
//@AllArgsConstructor
//@NoArgsConstructor
//@Getter
//@Setter
public class UserDTO extends SuperDTO {
    private long userId;
    private String userName;
    private String email;
    private String password;
    private Gender gender;
    private Date birthDay;
    private String country;
    private String city;


    public UserDTO() {
    }

    public UserDTO(long userId, String userName, String email, String password, Gender gender, Date birthDay, String country, String city) {
        this.userId = userId;
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

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
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

    @Override
    public String toString() {
        return "UserDTO{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", gender=" + gender +
                ", birthDay=" + birthDay +
                ", country='" + country + '\'' +
                ", city='" + city + '\'' +
                '}';
    }

    public enum Gender {
        MALE, FEMALE
    }
}
