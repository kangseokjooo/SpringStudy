package com.SpringProject.demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Controller
public class HelloController {
    class Hello{

    }
    @GetMapping("/hi")
    public  String getHi(Model model){ //Model model:컨트롤러 클래스 안의 메서드가 파라미터로 받을 수 있는 객체

        Hello hello=new Hello();
        List<Integer> list=new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        model.addAttribute("msg","hi~");
        model.addAttribute("hello","Spring world");
        model.addAttribute("uText","<strong>Hello</strong>");
        model.addAttribute("value","name input");
        model.addAttribute("with","Hello with");
        model.addAttribute("link","hi");
        model.addAttribute("img","Hotdog.png");
        model.addAttribute("userRole","admin");
        model.addAttribute("isAdmin","false");
        model.addAttribute("names",list);
        //${}:변수 표현 방식
        //@{..}:URL 링크 표현식
        //*{..}:선택 변수 표현식 *{msg} 단 , th:object
        //컨트롤러 클래스에서 private String msg="hi"
        //model.addAttribute("Msg",new HelloController());
        //템플릿에서 <div th:object=${Msg}><h1 th:text=*{msg}></h1></div>
        return "hi";
    }
    @PostMapping("/checkAge")
    public String checkAge(@RequestParam("age") int age, Model model) {
        String result = "나이: " + age + "세, ";
        if (age >= 20) {
            result += "성인";
        } else {
            result += "미성년자";
        }
        model.addAttribute("result", result);
        return "hi";
    }

    @GetMapping("/people")
    public String People(Model model){
        Map<String,Integer> map=new HashMap<>();
            map.put("kang",19);
            map.put("hong",21);
            map.put("kwon",22);
            map.put("lee",28);
        model.addAttribute("map",map);
        return "hi";
    }
}

