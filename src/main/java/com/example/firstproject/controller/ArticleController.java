package com.example.firstproject.controller;

import com.example.firstproject.dto.ArticleForm;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
/**
 * 폼 컨트롤러 !!
 *
 * action :  어디에 보낼지 정하는 것
 * method :  어떻게 보낼지 정하는 것 (get, post)
 *
 * **/
@Controller
public class ArticleController {
    @GetMapping("/articles/new")
    public String newArticleForm() {
        return "articles/new";
    }

    @PostMapping("/articles/create")
    public String createArticle(ArticleForm form) {     // 폼 데이터를 DTO 로 받기
        System.out.println(form.toString());        // DTO 에 폼 데이터가 잘 담겼는지 확인
        return "";
    }
}
