package com.example.JDBC.JDBC;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class UserCommandRun implements CommandLineRunner {
    @Autowired
    private  UserJdbcRepository userJdbcRepository;
    @Override
    public void run(String... args) throws Exception {
        userJdbcRepository.insert(new Users(1,"hong","서울시 마포구"));
        userJdbcRepository.insert(new Users(2,"kang","고양시 일산서구"));
        userJdbcRepository.insert(new Users(3,"jung","서울시 용산구"));
        userJdbcRepository.delete(1);
        System.out.println(userJdbcRepository.findId(2));
        System.out.println(userJdbcRepository.findId(3));
    }
}
