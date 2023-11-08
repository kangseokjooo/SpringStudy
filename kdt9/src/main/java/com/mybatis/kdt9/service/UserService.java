package com.mybatis.kdt9.service;


import com.mybatis.kdt9.domain.UserEntity;
import com.mybatis.kdt9.dto.UserDTO;
import com.mybatis.kdt9.mapper.UserMapper;
import com.mybatis.kdt9.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    //mapper실행 그 결과 값을 dto에 담에서 controller로 return
    @Autowired
    private UserMapper userMapper;
    @Autowired
    UserRepository userRepository;

    public String searchid(int id){
        //orElse() null이면 ()안에 객체 리턴
        UserEntity result=userRepository.findById(id).orElseThrow(()->new RuntimeException("user no"));


            //Optional: null 일수도 있는 객체를 감싸기 위해 있는 친구
            //isPresent():객체의 여부를 boolean 으로 반환
            //isEmpty():isPresent의 반대
            //get():Optional 내부 객체를 반환
            //Optional<T>
        return result.getName();
    }
    public boolean searchUser(String name){
        List<UserEntity> result=userRepository.findByName(name);
        return !result.isEmpty();

    }
    public String serarchNameAndNickname(String name,String nickname){
        List<UserEntity> result=userRepository.findByNameOrNickname(name,nickname);
        System.out.println(result.size()+"명");
        return "";
    }
    public List<UserDTO> getUserList(){
        List<UserEntity> result = userRepository.findAll();
        List<UserDTO> users=new ArrayList<>();
        for(UserEntity user:result){
            UserDTO userDTO=UserDTO.builder()
                    .id(user.getId())
                    .name(user.getName())
                    .nickname(user.getNickname())
                    .build();
            users.add(userDTO);
        }
        return users;
//        List<User> result=userMapper.retrieveAll();
//        List<UserDTO> users=new ArrayList<UserDTO>();
//        for(int i=0;i<result.size();i++){
//            User u=result.get(i);
//            UserDTO user=UserDTO.builder()
//                    .id(u.getId())
//                    .name(u.getName())
//                    .nickname(u.getNickname())
//                    .no(i+1)
//                    .build();
//            users.add(user);
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
//        }
//        return users;
    }

    public void insertUser(String name,String nickname){
        UserEntity userEntity=new UserEntity();
        userEntity.setName(name);
        userEntity.setNickname(nickname);

       userRepository.save(userEntity);
    }
}
