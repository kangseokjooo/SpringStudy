package com.example.KDT9Example.Controller;

import com.example.KDT9Example.dto.UserDTO;
import com.example.KDT9Example.vo.UserVO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@Controller
public class PracMainController {
    ArrayList<UserDTO> userDTOS=new ArrayList<>();
    @GetMapping("/prac")
    public String getPracMain(){
        return  "Practice1";
    }
    @PostMapping("/prac")
    @ResponseBody
    public ArrayList<UserDTO> postVoPrac(@RequestBody UserDTO userDTO){
        userDTOS.add((userDTO));
        return userDTOS;
    }
    @PostMapping("/login")
    @ResponseBody
    public String Login(@RequestBody UserDTO userDTO){
        for(UserDTO user: userDTOS){
            if(user.getName().equals((userDTO.getName()))){
                return userDTO.getName()+"님 로그인 성공";
            }
        }
        return "그런이름은 존재하지 않습니다.";
    }
    @DeleteMapping("/delete/{name}")
    @ResponseBody
    public String deleteUser(@PathVariable String name) {
        for (UserDTO user : userDTOS) {
            if (user.getName().equals(name)) {
                userDTOS.remove(user);
                return name + "님 탈퇴 성공";
            }

        }
        return "회원목록에 없음";
    }


    }

