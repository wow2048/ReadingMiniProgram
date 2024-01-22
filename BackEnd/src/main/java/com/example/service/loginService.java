package com.example.service;

import com.example.model.vo.userVO;

import java.io.IOException;

public interface loginService {

    public userVO sign(String userID);

    public void login(String userID, String name);

    public String getUserID(String code) throws IOException;

}
