package com.example.KDT9Example.helloworld;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

//record: getter,setter,생성자 등을 자동 으로 생성
record Person(String name,int age){}
record Address(String address, int postcode){}

record Information(String name,int age, Address address){}

//Configuration:빈(Bean) 정의를 포함 하는 클래스
@Configuration
public class HelloWorldConfiguration {
    //Bean이라는 Annotation은 메소드 위에서만 사용가능
    @Bean
    public String name(){
        return  "KDT9";
    }
    @Bean
    public int age(){
        return 28;
    }

    @Bean
    public Person person(){
        return new Person("Kang",28);
    }

    @Bean
    public Person person2(){
        return new Person( name(), age() );
    }

    @Bean(name = "myAddress")
    public Address address(){
        return new Address("Ilsan Goyang",12345);
    }
    @Bean
    public Information information(String name,int age, Address myAddress){
        return new Information(name,age,myAddress);
    }

    @Bean
    @Primary
    public Address address2(){
        return new Address("Seoul Yongsan",47584);
    }
    @Bean
    //한정자 특정 메소드를 불러오고 싶을 때
    @Qualifier("addressQualifier")
    public Address address3(){
        return new Address("Seoul Mapo",1232435);
    }

    @Bean
    @Primary
    public Information info2(String name,int age,@Qualifier("addressQualifier") Address myAddress){
        return new Information(name,age,myAddress);
    }
}
