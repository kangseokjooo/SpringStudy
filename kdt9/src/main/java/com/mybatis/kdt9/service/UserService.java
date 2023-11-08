package com.mybatis.kdt9.service;

import com.mybatis.kdt9.domain.User;
import com.mybatis.kdt9.dto.UserDTO;
import com.mybatis.kdt9.dto.UserDTOBuilder;
import com.mybatis.kdt9.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {
    //mapper실행 그 결과 값을 dto에 담에서 controller로 return
    @Autowired
    private UserMapper userMapper;
    public List<UserDTO> getUserList(){
        List<User> result=userMapper.retrieveAll();
        List<UserDTO> users=new ArrayList<UserDTO>();
        for(int i=0;i<result.size();i++){
            User u=result.get(i);
            UserDTO user=UserDTO.builder()
                    .id(u.getId())
                    .name(u.getName())
                    .nickname(u.getNickname())
                    .no(i+1)
                    .build();
            users.add(user);
            /*UserDTO user=new UserDTO();
            user.setId(u.getId());
            user.setName(u.getName());
            user.setNickname(u.getNickname());
            user.setNo(i+1);
            users.add(user);*/
//            UserDTOBuilder userDTOBuilder=UserDTOBuilder.builder()
//                    .id(u.getId())
//                    .name(u.getName())
//                    .build();
        }
        return users;
    }

    public void insertUser(String name,String nickname){
        User user=new User();
        user.setName(name);
        user.setNickname(nickname);

        userMapper.insertUser(user);
    }
}
