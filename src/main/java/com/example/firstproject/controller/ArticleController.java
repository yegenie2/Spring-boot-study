package com.example.firstproject.controller;

import com.example.firstproject.dto.ArticleForm;
import com.example.firstproject.entity.Article;
import com.example.firstproject.repository.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
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
    @Autowired      // 스프링 부트가 미리 생성해 놓은 리포지토리 객체 주입(Dependency Injection)
    private ArticleRepository articleRepository;    // articleRepository 객체 선언
    @GetMapping("/articles/new")
    public String newArticleForm() {
        return "articles/new";
    }

    @PostMapping("/articles/create")
    public String createArticle(ArticleForm form) {     // 폼 데이터를 DTO 로 받기
        System.out.println(form.toString());        // DTO 에 폼 데이터가 잘 담겼는지 확인

        //  1. DTO를 엔티티로 변환
        Article article = form.toEntity();
        System.out.println(article.toString());

        //  2. 리포지토리로 엔터티를 DB에 저장
        Article saved = articleRepository.save(article);    // article 엔터티를 저장해서 saved 객체에 반환
        System.out.println(saved.toString());

        return "";
    }
}
