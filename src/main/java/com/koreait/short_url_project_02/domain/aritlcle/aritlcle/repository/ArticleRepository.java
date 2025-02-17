package com.koreait.short_url_project_02.domain.aritlcle.aritlcle.repository;


import com.koreait.short_url_project_02.domain.aritlcle.aritlcle.entity.Article;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ArticleRepository extends JpaRepository<Article, Long> {
    List<Article> findByIdInOrderByTitleDescIdAsc(List<Long> ids);

    List<Article> findByTitleContaining(String title);

    List<Article> findByTitleAndBody(String title, String body);

}
