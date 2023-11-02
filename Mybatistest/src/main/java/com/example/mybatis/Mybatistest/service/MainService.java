package com.example.mybatis.Mybatistest.service;

import com.example.mybatis.Mybatistest.domain.Users;
import com.example.mybatis.Mybatistest.dto.UserDTO;
import com.example.mybatis.Mybatistest.mapper.MainMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MainService {
    @Autowired
    private MainMapper mainMapper;

    //xml주입-SQL쿼리와 자바 객체간의 매핑

    public List<UserDTO> getUserList(){
        //실제데이터베이스에서 가져오는 users배열
        List<Users> result=mainMapper.findAll();
        //위에서 받은 Users배열을 UserDTO배열로 반환하기
        List<UserDTO> users=new ArrayList<>();

        for(int i=0;i<result.size();i++){
            UserDTO user=new UserDTO();
            user.setId(result.get(i).getId());
            user.setName(result.get(i).getName());
            user.setAddress(result.get(i).getAddress());

            users.add(user);
        }

        return users;
    }

    public void addUser(Users user){mainMapper.insertUser(user);}
    public void updateUser(Users user){mainMapper.updateUser(user);}

    public void deleteUser(int id){mainMapper.deleUser(id);}

}
