package com.example.mybatis.Mybatistest.controller;

import com.example.mybatis.Mybatistest.domain.Users;
import com.example.mybatis.Mybatistest.dto.UserDTO;
import com.example.mybatis.Mybatistest.service.MainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Controller
public class MainController {
    @Autowired
    private MainService mainService;

    @GetMapping("/users")
    public String getUsers(Model model){
        List<UserDTO> userList= mainService.getUserList();
        model.addAttribute("list",userList);
        return "user";
    }
    @GetMapping("/insert")
    public String getInsertUser(@RequestParam String name,@RequestParam String address,Model model){
        Users user=new Users();
        user.setName(name);
        user.setAddress(address);

        mainService.addUser(user);
        return "redirect:/users";
    }


    @GetMapping("/update")
    public String UpdateUser(@RequestParam int id,@RequestParam String name,@RequestParam String address) {
        Users user=new Users();
        user.setId(id);
        user.setName(name);
        user.setAddress(address);
        mainService.updateUser(user);
        return "redirect:/users";
    }
    @GetMapping("delete/{id}")
    public String delteUser(@PathVariable int id){
        mainService.deleteUser(id);
        return "user";
    }
}



