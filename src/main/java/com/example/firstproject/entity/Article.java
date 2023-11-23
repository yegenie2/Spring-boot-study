package com.example.firstproject.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity         // 엔터티 선언 ( 이 어노테이션이 붙은 클래스를 기반으로 DB에 테이블이 생성 )
public class Article {

    @Id     // 엔터티의 대표값 지정
    @GeneratedValue         // 대표값 자동생성 ( 시퀀스 키? 숫자 자동으로 매겨짐...)
    private Long id;
    @Column     // 필드 선언, DB 테이블의 title 열과 연결
    private String title;
    @Column     // 필드 선언, DB 테이블의 content 열과 연결
    private String content;

    // 생성자
    public Article(Long id, String title, String content) {
        this.id = id;
        this.title = title;
        this.content = content;
    }

    // toString() 메서드 추가
    @Override
    public String toString() {
        return "Article{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                '}';
    }
}
