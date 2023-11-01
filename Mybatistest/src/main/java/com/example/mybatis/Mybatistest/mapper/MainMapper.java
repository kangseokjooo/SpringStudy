package com.example.mybatis.Mybatistest.mapper;

import com.example.mybatis.Mybatistest.domain.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MainMapper {
    //mapper.xml참고하는 방법
    List<User> retrieveAll();
    //mapper.xml을 참고 안하는 것
    @Insert("insert into user(name,address) values(#{name},#{address})")
    void insertUser(User user);
}
