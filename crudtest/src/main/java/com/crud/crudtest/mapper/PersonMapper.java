package com.crud.crudtest.mapper;

import com.crud.crudtest.domain.Person;
import org.apache.ibatis.annotations.*;

@Mapper
public interface PersonMapper {
    //회원가입
    @Insert("insert into person (user_id,password,name) values (#{user_id},#{password},#{name})")
    void insertPerson(Person person);

    //Login
    @Select("select * from person where user_id=#{user_id} and password=#{password}")
    Person getPerson(String user_id, String password);

    //사용자 정보조회
    @Select("select * from person where id=#{id}")
    Person getPersonData(long id);

    @Update("update person set password=#{password}, name=#{name} where user_id=#{user_id}")
    void updatePerson(Person person);

    @Delete("delete from person where user_id=${user_id}")
    void deletePerson(String user_id);
}
