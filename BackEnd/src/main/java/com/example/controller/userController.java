package com.example.controller;

import com.example.model.vo.bookVO;
import com.example.service.userService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
public class userController {

    @Autowired
    private userService userService;

    @RequestMapping("/user/showCollection")
    public ArrayList<bookVO> showCollection(@RequestParam("userID")String userID) {
        return userService.getCollections(userID);
    }


    @RequestMapping("/user/addCollection")
    public void addCollection(@RequestParam("userID")String userID, @RequestParam("bookID")String bookID) {
        userService.addCollection(userID, bookID);
    }

    @RequestMapping("/user/removeCollection")
    public void removeCollection(@RequestParam("userID")String userID, @RequestParam("bookID")String bookID) {
        userService.removeCollection(userID, bookID);
    }

}
