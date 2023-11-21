package com.example.sustainabilityapp;

public class UserProfile {

    String name, email,password,phone,city;

    public UserProfile(String name, String email, String password, String phone, String city) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.phone = phone;
        this.city = city;
    }

    public UserProfile(){
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
