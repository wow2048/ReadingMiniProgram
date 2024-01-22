package com.example.model.vo;

import com.example.model.po.userPO;

import java.io.Serializable;

public class userVO implements Serializable {

    private String userID;

    private String name;

    public userVO(userPO userPO) {
        this.userID = userPO.getUserID();
        this.name = userPO.getName();
    }

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

