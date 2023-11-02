package com.example.mybatis.Mybatistest.mapper;

import com.example.mybatis.Mybatistest.domain.Users;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface MainMapper {
    //mapper.xml참고하는 방법
    List<Users> findAll();
    //mapper.xml을 참고 안하는 것
    @Insert("insert into users(name,address) values(#{name},#{address})")
    void insertUser(Users user);

    @Update("update users set name = #{name}, address = #{address} where id = #{id}")
    void updateUser(Users user);

    @Delete("delete from users where id=#{id}")
    void deleUser(int id);

}
