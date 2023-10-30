package com.example.KDT9Example.Game;

import org.springframework.stereotype.Component;

@Component
public class DiabloGame implements GameConsole {
    public void up(){
        System.out.println("Diablo Up!");
    }
    public void down(){
        System.out.println("Diablo Back!");
    }
    public void right(){
        System.out.println("Diablo Right!");
    }
    public void left(){
        System.out.println("Diablo Left!");
    }

}
