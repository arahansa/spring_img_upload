package com.example.repository;

import com.example.domain.BoardArticle;

import org.springframework.data.jpa.repository.JpaRepository;


// 이거 하나로 왠만한 CRUD 동작이 모두 자동으로 만들어집니다^^;
public interface ArticleRepository extends JpaRepository<BoardArticle, Long> {

}
