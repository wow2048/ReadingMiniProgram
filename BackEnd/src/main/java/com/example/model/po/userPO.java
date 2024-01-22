package com.example.model.po;

import java.io.Serializable;

public class userPO implements Serializable {

    private String userID;

    private String name;

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getUserID() {
        return userID;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

}
