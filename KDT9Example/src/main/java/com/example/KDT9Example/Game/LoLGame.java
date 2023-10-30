package com.example.KDT9Example.Game;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class LoLGame implements GameConsole {
    public void up(){
        System.out.println("LoL Up!");
    }
    public void down(){
        System.out.println("LoL Back!");
    }
    public void right(){
        System.out.println("LoL Right!");
    }
    public void left(){
        System.out.println("LoL Left!");
    }

}
