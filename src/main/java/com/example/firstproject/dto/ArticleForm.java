package com.example.firstproject.dto;

import com.example.firstproject.entity.Article;
import lombok.AllArgsConstructor;
import lombok.ToString;

@AllArgsConstructor         // 생성자 어노테이션
@ToString                   // toString() 메서드 효과 어노테이션
public class ArticleForm {
    private Long id;        // id 필드 추가
    private String title;   // 제목을 받을 필드
    private String content; // 내용을 받을 필드

    public Article toEntity() {
        return new Article(id, title, content);       // 생성자 입력 양식에 맞게 작성..
                                                            // ArticleForm 객체에 id 정보가 없기 때문에. id는 null 이 들어간다.
    }
}
