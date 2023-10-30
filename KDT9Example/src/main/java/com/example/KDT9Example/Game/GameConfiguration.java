//package com.example.KDT9Example.Game;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.Primary;
//
//@Configuration
//public class GameConfiguration {
//    @Bean
//    public GameConsole diabloGame(){
//        return new DiabloGame();
//    }
//    @Bean
//    @Primary
//    public GameConsole LolGame(){
//        return new LoLGame();
//    }
//    @Bean
//    public GameEngine gameEngine(GameConsole game){
//        return  new GameEngine(game);
//    }
//}
