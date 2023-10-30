package com.example.KDT9Example.Game;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;


@Configuration
@ComponentScan("com.example.KDT9Example.Game")
public class GameMain {
    public static void main(String[] args) {
       var context = new AnnotationConfigApplicationContext( GameMain.class );

       //결합: 무엇 인가를 변경 하는데 얼마나 많은 작업이 관련 되어 있는 지에 대한 측정
//       DiabloGame game=new DiabloGame();
//       LoLGame game2=new LoLGame();
//       GameEngine engine=new GameEngine(game2);
//       engine.run();
        context.getBean(GameConsole.class);
        context.getBean(GameEngine.class).run();
    }
}
