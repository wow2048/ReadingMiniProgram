package com.example.service.impl;

import com.example.mapper.bookMapper;
import com.example.model.po.bookPO;
import com.example.model.vo.bookVO;
import com.example.service.bookService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;


@Service
public class bookServiceImpl implements bookService {

    // 将mapper层注入service层
    @Resource
    private bookMapper bookMapper;

    public bookVO getBook(String bookID) {
        bookPO bookPO = bookMapper.getBook(bookID);
        return new bookVO(bookPO);
    }

    @Override
    public ArrayList<bookVO> getCollectedBooks() {
        ArrayList<bookVO> bookVOList = new ArrayList<bookVO>();
        for(int i = 0; i < 15; i++) {
            bookVOList.add(getBook(String.valueOf(i)));
        }
        return bookVOList;
    }


    public ArrayList<bookVO> searchBooks(String information) {
        ArrayList<bookPO> bookPOList = bookMapper.searchBooks(information);
        ArrayList<bookVO> bookVOList = new ArrayList<>();
        for(bookPO bookPO : bookPOList) {
            bookVOList.add(new bookVO(bookPO));
        }
        return bookVOList;
    }

    public boolean isCollected(String userID, String bookID) {
        return bookMapper.isCollected(userID, bookID) != null;
    }

}
