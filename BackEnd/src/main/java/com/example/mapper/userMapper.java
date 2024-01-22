package com.example.mapper;

import com.example.model.po.bookPO;
import org.apache.ibatis.annotations.*;

import java.util.ArrayList;

@Mapper
public interface userMapper {

    @Select("select * from book WHERE bookID in (select bookID from mapper WHERE userID = #{userID})")
    public ArrayList<bookPO> getCollections(@Param("userID")String userID);

    @Insert("insert into mapper(userID, bookID) values (#{userID},#{bookID})")
    public void addCollection(@Param("userID")String userID, @Param("bookID")String bookID);

    @Delete("delete from mapper WHERE userID = #{userID} AND bookID = #{bookID}")
    public void removeCollection(@Param("userID")String userID, @Param("bookID")String bookID);

}
