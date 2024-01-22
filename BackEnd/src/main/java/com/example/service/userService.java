package com.example.service;

import com.example.model.vo.bookVO;

import java.util.ArrayList;

public interface userService {

    public ArrayList<bookVO> getCollections(String userID);

    public void addCollection(String id, String bookID);

    public void removeCollection(String userID, String bookID);

}
