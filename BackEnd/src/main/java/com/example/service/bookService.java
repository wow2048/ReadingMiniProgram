package com.example.service;

import com.example.model.vo.bookVO;

import java.util.ArrayList;

public interface bookService {

    public bookVO getBook(String bookID);

    public ArrayList<bookVO> getCollectedBooks();

    public ArrayList<bookVO> searchBooks(String information);

    public boolean isCollected(String userID, String bookID);

}
