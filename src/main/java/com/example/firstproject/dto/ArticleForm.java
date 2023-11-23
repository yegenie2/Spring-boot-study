package com.example.firstproject.dto;

import com.example.firstproject.entity.Article;

public class ArticleForm {
    private String title;   // 제목을 받을 필드
    private String content; // 내용을 받을 필드

    // 생성자 추가
    public ArticleForm(String title, String content) {
        this.title = title;
        this.content = content;
    }

    // toString() 메서드 추가 ( 데이터를 잘 받았는지 확인 )
    @Override
    public String toString() {
        return "ArticleForm{" +
                "title='" + title + '\'' +
                ", content='" + content + '\'' +
                '}';
    }

    public Article toEntity() {
        return new Article(null, title, content);       // 생성자 입력 양식에 맞게 작성..
                                                            // ArticleForm 객체에 id 정보가 없기 때문에. id는 null 이 들어간다.
    }
}
