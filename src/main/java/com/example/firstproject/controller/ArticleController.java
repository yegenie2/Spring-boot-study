package com.example.firstproject.controller;

import com.example.firstproject.dto.ArticleForm;
import com.example.firstproject.entity.Article;
import com.example.firstproject.repository.ArticleRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;

/**
 * 폼 컨트롤러 !!
 * <p>
 * action :  어디에 보낼지 정하는 것
 * method :  어떻게 보낼지 정하는 것 (get, post)
 **/
@Slf4j      // 로깅 기능을 위한 어노테이션 추가
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
        log.info(form.toString());      // 로깅 코드 추가
//        System.out.println(form.toString());        // DTO 에 폼 데이터가 잘 담겼는지 확인

        //  1. DTO를 엔티티로 변환
        Article article = form.toEntity();
        log.info(article.toString());      // 로깅 코드 추가
//        System.out.println(article.toString());

        //  2. 리포지토리로 엔터티를 DB에 저장
        Article saved = articleRepository.save(article);    // article 엔터티를 저장해서 saved 객체에 반환
        log.info(saved.toString());      // 로깅 코드 추가
//        System.out.println(saved.toString());

        return "";
    }

    @GetMapping("/articles/{id}")    // 데이터 조회 요청 접수
    public String show(@PathVariable Long id, Model model) {     // 매개변수로 id 받아오기   + model 객체 받아오기
        log.info("id = " + id );        // id 로그 찍기
        //  1. id 조회해 데이터 가져오기
        Article articleEntity = articleRepository.findById(id).orElse(null);        //id 없으면 null 반환

        //  2. 모델에 데이터 등록하기
        model.addAttribute("article", articleEntity);

        //  3. 뷰 페이지 반환하기
        return "articles/show";     // show 파일 반환.

    }

    @GetMapping("/articles")
    public String index(Model model) {

        // 1. 모든 데이터 가져오기
        ArrayList<Article> articleEntityList = articleRepository.findAll();
        // 2. 모델에 데이터 등록
        model.addAttribute("articleList", articleEntityList);

        // 3. 뷰 페이지 설정
        return "articles/index";
    }
}
