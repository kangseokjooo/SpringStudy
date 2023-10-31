package com.example.KDT9Example.Controller;

import com.example.KDT9Example.dto.UserDTO;
import com.example.KDT9Example.vo.UserVO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
//@RestController
public class MainController {
    @GetMapping("/")
    public String getMain(){
        return "request";
    }
    @GetMapping("/get/response1")
    //?key=value
    //기본값으로 required=true
    public String getResponse1(@RequestParam(value = "name") String n, Model model){
        model.addAttribute("name",n);
        return "response";
    }
    @GetMapping("/get/response2")
    //검색 검색어는 필수 +해시 태그 , 상세 설정 선택
    //?key=value
    public String getResponse2(@RequestParam(value = "name",required = false) String n, Model model){
        model.addAttribute("name",n);
        return "response";
    }
    @GetMapping("/get/response3/{name}/{age}")
    public String getResponse3(@PathVariable String name,@PathVariable("age") String abc,Model model){
        model.addAttribute("name",name);
        model.addAttribute("age",abc);
        return "response";
    }
    @GetMapping({"/get/response4/{name}","/get/response4/{name}/{age}"})
    //PathVariable도 RequestParam이랑 동일함
    public String getResponse4(@PathVariable String name,@PathVariable(required = false) String age,Model model){
        model.addAttribute("name",name);
        model.addAttribute("age",age);
        return "response";
    }
//    @GetMapping("/")
//    public String getPrac(){
//        return "Practice1";
//    }
//    @GetMapping("/introduce")
//    public String getPracResponse(@RequestParam(value = "name") String name,Model model){
//        model.addAttribute("name",name);
//        return "response";
//    }
//    @GetMapping("/introduce/{name}/{age}")
//    public String getPracResponse2(@PathVariable String name,@PathVariable String age,Model model){
//        model.addAttribute("name",name);
//        model.addAttribute("age",age);
//        return "response";
//    }

    @PostMapping("/post/response1")
    public String postResponse1(@RequestParam String name,Model model){
        //@RequestBody:전달받은 body데이터를 json형태의 객체로 만들어 준다.
        model.addAttribute("name",name);
        return "response";
    }
    @PostMapping("/post/response2")
    public String postResponse2(@RequestParam(required = false) String name,Model model){
        //@RequestBody:전달받은 body데이터를 json형태의 객체로 만들어 준다.
        model.addAttribute("name",name);
        return "response";
    }
    @PostMapping("/post/response3")
    @ResponseBody
    //@ResponseBody:response 데이터를 전달한다.
    public String postResponse3(@RequestParam(required = false) String name,Model model){
        //@RequestBody:전달받은 body데이터를 json형태의 객체로 만들어 준다.
        model.addAttribute("name",name);
        return "response";
    }

//    @GetMapping("/")
//    public String getPrac(){
//        return "Practice1";
//    }
//    @PostMapping("/hobby")
//    public String PostPrac(@RequestParam String name,@RequestParam String age,@RequestParam int phone,@RequestParam String hobby,Model model){
//        model.addAttribute("name",name);
//        model.addAttribute("age",age);
//        model.addAttribute("phone",phone);
//        model.addAttribute("hobby",hobby);
//        return "response";
//    }
    @GetMapping("/dto/response1")
    @ResponseBody
    public String dtoResponse1(@ModelAttribute UserDTO userDTO){
        //ModelAttribute:html에서 보내오는 form데이터를 컨트롤러로 전달 할 때 매핑해주는 친구
        //@RequestBody 사용 가능?
        String msg=userDTO.getName()+" "+userDTO.getAge();
        return msg;
    }
    @GetMapping("/dto/response11")
    public String dtoResponse11(@RequestBody UserDTO userDTO){
        //ModelAttribute:html 에서 보내 오는 form 데이터를 컨트 롤러로 전달 할 때 매핑해주는 친구
        //@RequestBody 사용 가능? Get 방식으로 @RequestBody로 받으면 오류가 난다.
        //RequestBody:요청의 본문에 있는 데이터(body)
        //매핑->같은 이름끼리 set함수를 실행한다.
        String msg=userDTO.getName()+" "+userDTO.getAge();
        return msg;
    }
    @PostMapping("/dto/response3")
    public String dtoResponse3(@RequestBody UserDTO userDTO){
        String msg=userDTO.getName()+" "+userDTO.getAge();
        return msg;
    }
    //일반 폼 전송 - DTO
    //1)아무것도 적지 않고  dTO로 바로 받으면 ->O
    //2)ModelAttribute로 받으면 ->O
    //3)@RequestBody로 받으면 오류가 난다.

    //RequestBody는 요청의 본문에 있는 데이터를 받아서 객체에 매핑 단 , 전달받은 요청의 데이터 형식
    //json 또는 xml 일 때만 실행이 가능

    @GetMapping("/vo/response1")
    @ResponseBody
    public String voResponse1(@ModelAttribute UserVO userVO){
        //ModelAttribute:html에서 보내오는 form데이터를 컨트롤러로 전달 할 때 매핑해주는 친구
        //객체의 set함수를 이용해 값을 넣어준다.
        //@RequestBody 사용 가능?
        String msg=userVO.getName()+" "+userVO.getAge();
        return msg;
    }

    @PostMapping("/vo/response2")
    @ResponseBody
    public String voResponse2(UserVO userVO){
        String msg=userVO.getName()+" "+userVO.getAge();
        return msg;
    }


}
