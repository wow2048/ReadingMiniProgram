package com.example.controller;

import com.example.model.vo.bookVO;
import com.example.service.bookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
public class bookController {

    @Autowired
    private bookService bookService;

    @RequestMapping("/book/collectedBook")
    public ArrayList<bookVO> getCollectedBooks() {
        return bookService.getCollectedBooks();
    }

    @RequestMapping("/book/search")
    public ArrayList<bookVO> searchBooks(@RequestParam("information") String information) {
        return bookService.searchBooks(information);
    }

    @RequestMapping("/book/getBook")
    public bookVO getBook(@RequestParam("bookID") String bookID) {
        return bookService.getBook(bookID);
    }

    @RequestMapping("/book/isCollected")
    public boolean isCollected(@RequestParam("userID") String userID, @RequestParam("bookID") String bookID) {
        return bookService.isCollected(userID, bookID);
    }

}
