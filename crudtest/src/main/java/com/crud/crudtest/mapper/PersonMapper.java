package com.crud.crudtest.mapper;

import com.crud.crudtest.domain.Person;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface PersonMapper {
    //회원가입
    @Insert("insert into person (user_id,password,name) values (#{user_id},#{password},#{name})")
    void insertPerson(Person person);

    //Login
    @Select("select * from person where user_id=#{user_id} and password=#{password}")
    Person getPerson(String user_id, String password);

}
