package com.example.mapper;

import com.example.model.po.userPO;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface loginMapper {

    @Select("select * from user WHERE userID = #{userID}")
    public userPO sign(@Param("userID")String userID);

    @Insert("insert into user(userID, name) values (#{userID},#{name})")
    public void login(@Param("userID")String userID, @Param("name")String name);

}
