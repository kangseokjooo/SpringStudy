package com.mybatis.kdt9.mapper;

import com.mybatis.kdt9.domain.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper {
    //xml 파일 참고해라.
    //xml은 동적 쿼리가 가능하다.
    List<User> retrieveAll();
    @Insert("insert into user(name,nickname) values(#{name},#{nickname})")
    void insertUser(User user);

}
