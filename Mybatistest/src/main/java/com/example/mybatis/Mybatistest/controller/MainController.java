package com.example.mybatis.Mybatistest.controller;

import com.example.mybatis.Mybatistest.domain.User;
import com.example.mybatis.Mybatistest.dto.UserDTO;
import com.example.mybatis.Mybatistest.service.MainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;

@Controller
public class MainController {
    @Autowired
    private MainService mainService;

    @GetMapping("/users")
    public String getUsers(Model model){
        ArrayList<UserDTO> userList= (ArrayList<UserDTO>) mainService.getUserList();
        model.addAttribute("list",userList);
        return "user";
    }
    @GetMapping("/users/insert")
    public String getInsertUser(@RequestParam String name,@RequestParam String address,Model model){
        User user=new User();
        user.setName(name);
        user.setAddress(address);

        mainService.addUser(user);
        return "user";
    }

}
