package com.example.controller;

import com.example.model.vo.userVO;
import com.example.service.loginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
public class loginController {

    @Autowired
    private loginService loginService;


    @RequestMapping("/login/login")
    public void login(@RequestParam("userID")String userID, @RequestParam("name")String name) {
        loginService.login(userID, name);
    }

    @RequestMapping("/login/sign")
    public userVO sign(@RequestParam("code")String code, @RequestParam("name")String name) {
        String userID = null;
        try {
            userID = loginService.getUserID(code);
        } catch (IOException e) {
            e.printStackTrace();
        }
        userVO user = loginService.sign(userID);
        if(user == null) {
            loginService.login(userID, name);
            user = loginService.sign(userID);
        }
        return user;
    }

}
