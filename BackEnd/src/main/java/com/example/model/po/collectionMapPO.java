package com.example.model.po;

import java.io.Serializable;

public class collectionMapPO implements Serializable {

    private String userID;

    private String bookID;

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getBookID() {
        return bookID;
    }

    public void setBookID(String bookID) {
        this.bookID = bookID;
    }
}
