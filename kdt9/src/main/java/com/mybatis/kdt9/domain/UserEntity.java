package com.mybatis.kdt9.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "user")
@Getter
@Setter
public class UserEntity {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY) //auto_increment
    private int id;
    @Column(name = "name",nullable = false, length = 20)
    private String name;
    @Column(columnDefinition = "TEXT")
    private String nickname;

    //ENUM 타입을 만들수있다
//    @Column
//    @Enumerated(EnumType.STRING)
//    private UserType type;
//    public enum UserType{
//        Student,Teacher
//    }
}
