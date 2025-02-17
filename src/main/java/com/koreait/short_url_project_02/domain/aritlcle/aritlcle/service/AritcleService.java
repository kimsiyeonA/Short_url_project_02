package com.koreait.short_url_project_02.domain.aritlcle.aritlcle.service;

import com.koreait.short_url_project_02.domain.aritlcle.aritlcle.entity.Article;
import com.koreait.short_url_project_02.domain.aritlcle.aritlcle.repository.ArticleRepository;
import com.koreait.short_url_project_02.domain.member.member.entity.Member;
import com.koreait.short_url_project_02.global.rsData.RsData;
import org.springframework.transaction.annotation.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class AritcleService{
    private  final ArticleRepository articleRepository;

    // service 메서드 안에서만 @Transactional를 쓸수 있는데 모든곳에 쓰면 성능이슈가 있음
    // 그래서 개별적으로 쓰기 위해서는 조건을 걸어주면됨
    //@Transactional()
    public long count() {
        return articleRepository.count();
    }



    // 리턴
    // - 이번에 생성된 게시글의 번호
    // - 게시글 생성 메세지
    // - 결과 코드
    @Transactional
    public RsData<Article> write(Member member, String title, String body) {
        Article article = Article.builder()
                .author(member)
                .title(title)
                .body(body)
                .build();

        articleRepository.save(article);

        return RsData.of("%d번 게시글 생성".formatted(article.getId()),article);
    }

    @Transactional
    public void delete(Article article) {
        articleRepository.delete(article);
    }

    // @Transactional
    public Optional<Article> findById(long id) {
        return articleRepository.findById(id);
    }

    // @Transactional
    public List<Article> findAll() {
        return articleRepository.findAll();
    }
}
