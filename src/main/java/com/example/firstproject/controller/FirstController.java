package com.example.firstproject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class FirstController {

    @GetMapping("/hi")      //URL 요청 접수 (내맘대로 지정)
    public String niceToMeetYou(Model model) {      // model 객체를 받아온다. Model 클래스 패키지 임포트.
        model.addAttribute("username", "핑구");
        return "greetings";     // greetings.mustache 파일 반환 ( 파일 이름만 적어준다.)
    }

    @GetMapping("/bye")
    public String seeYouNext(Model model) {
        model.addAttribute("nickname", "기영이");
        return "goodbye";
    }
}
