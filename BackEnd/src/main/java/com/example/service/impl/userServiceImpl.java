package com.example.service.impl;

import com.example.mapper.userMapper;
import com.example.model.po.bookPO;
import com.example.model.vo.bookVO;
import com.example.service.userService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;

@Service
public class userServiceImpl implements userService {

    // 将mapper层注入service层
    @Resource
    private userMapper userMapper;

    public ArrayList<bookVO> getCollections(String userID) {
        ArrayList<bookPO> bookPOList = userMapper.getCollections(userID);
        ArrayList<bookVO> bookVOList = new ArrayList<>();
        for(bookPO bookPO : bookPOList) {
            bookVOList.add(new bookVO(bookPO));
        }
        return bookVOList;
    }

    public void addCollection(String id, String bookID) {
        userMapper.addCollection(id, bookID);
    }

    public void removeCollection(String userID, String bookID) {
        userMapper.removeCollection(userID, bookID);
    }

}
