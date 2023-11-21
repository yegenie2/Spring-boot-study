package com.example.firstproject.dto;

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
}
