package com.example.firstproject.repository;

import com.example.firstproject.entity.Article;
import org.springframework.data.repository.CrudRepository;

/**
 * CrudRepository 는 JPA에서 제공하는 인터페이스
 * 상속받으면 엔터티를 관리 (생성, 조회, 수정, 삭제) 할 수 있다.
 * <> 제네릭 요소...
 * -> Article : 관리 대상 엔터티의 클래스 타입
 * -> Long : 관리 대상 엔터티의 대표값 타입. id 가 대표값으로 지정되어있음.
 *
 * */
public interface ArticleRepository extends CrudRepository<Article, Long> {

}
