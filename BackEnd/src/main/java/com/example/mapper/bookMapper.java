package com.example.mapper;

import com.example.model.po.bookPO;
import com.example.model.po.collectionMapPO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.ArrayList;

@Mapper
public interface bookMapper {

    @Select("select * from book WHERE bookID = #{bookID}")
    public bookPO getBook(String bookID);

    @Select("select * from book WHERE name LIKE CONCAT('%', #{information}, '%') OR author LIKE CONCAT('%', #{information}, '%')")
    public ArrayList<bookPO> searchBooks(String information);

    @Select("SELECT * from mapper WHERE userID = #{userID} AND bookID = #{bookID}")
    public collectionMapPO isCollected(String userID, String bookID);

}
