package com.example.firstproject.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor      // 기본 생성자 추가 어노테이션
@ToString
@Getter         // 롬복으로 getId() 게터 추가해줌.
@Entity         // 엔터티 선언 ( 이 어노테이션이 붙은 클래스를 기반으로 DB에 테이블이 생성 )
public class Article {

    @Id     // 엔터티의 대표값 지정
    @GeneratedValue(strategy = GenerationType.IDENTITY)         // 대표값 자동생성 ( 시퀀스 키? 숫자 자동으로 매겨짐...) DB 가 id 자동 생성
    private Long id;
    @Column     // 필드 선언, DB 테이블의 title 열과 연결
    private String title;
    @Column     // 필드 선언, DB 테이블의 content 열과 연결
    private String content;

/*
    public Long getId() {       // 데이터 타입을 String ->Long type으로 변경해줘야함.
        return id;
    }
    */
}
