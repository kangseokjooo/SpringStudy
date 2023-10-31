package com.example.KDT9Example.dto;

import lombok.Getter;
import lombok.Setter;

//Getter
//Setter:모든 변수들에 대해서
public class UserDTO {
    private String name;

    private String age;

    //Getter,Setter 생성
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }
}
