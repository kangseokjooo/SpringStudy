package com.crud.crudtest.domain;

import jakarta.persistence.*;

@Entity
@Table(name = "Seoul")
public class PersonEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO) //AUTO INCREMENT
    private long id;
    @Column(length = 255,nullable = false)
    private String name;

    @Column(length = 255,nullable = false)
    private String password;

    @Column(length = 255,nullable = false)
    private String userid;

    private  String email;

    //기본 생성자
    public PersonEntity(){};

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
