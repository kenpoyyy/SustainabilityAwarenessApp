package com.example.sustainabilityapp;

public class Users {

    String userID, name, profile;

    public Users(String userID, String name, String profile) {
        this.userID = userID;
        this.name = name;
        this.profile = profile;
    }

    public Users(){

    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProfile() {
        return profile;
    }

    public void setProfile(String profile) {
        this.profile = profile;
    }
}
