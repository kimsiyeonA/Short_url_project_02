package com.koreait.short_url_project_02.global.initData;

import com.koreait.short_url_project_02.domain.aritlcle.aritlcle.entity.Article;
import com.koreait.short_url_project_02.domain.aritlcle.aritlcle.service.AritcleService;
import com.koreait.short_url_project_02.domain.member.member.entity.Member;
import com.koreait.short_url_project_02.domain.member.member.service.MemberService;
import com.koreait.short_url_project_02.global.exceptions.GlobalException;
import com.koreait.short_url_project_02.global.rsData.RsData;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Profile;

import java.util.List;
import java.util.Optional;

@Profile("!prod") // dev test에서만 실행함 > 운영모드에서는 실행 안됨
@Configuration
@RequiredArgsConstructor
public class NotProd {

    @Lazy
    @Autowired
    private NotProd self;
    // 빈으로 등록하는 this랑 self랑
    // this를 통한 객체 내부에서의 매서드 호출은 트랜젝션을 작동시키지 않아
    // 외부객체에 의한 매서드 호출은 트랜젝션 작동해
    // @Lazy @Autowired 조합은 this의 외부 호출 모드 버전의 self를 얻을 수 있어
    // self

    //private final ArticleRepository articleRepository;

    private final AritcleService articleService;
    private final MemberService memberService;


    @Bean // 등록 개발자가 new 하지 않아도 스프링부트가 직접 관리하는 객체
    public ApplicationRunner initDataProd() {
        return args -> {
            self.work1(); // self.를 붙이면 트렌젝션이 부텽짐
 //           self.work2();

        };
    }

    @Transactional
    public void work1() {
        if (articleService.count() > 0) return;
//        Article article1 = Article.builder().
//                title("제목1")
//                .body("내용1").build();
//        Article article2 = Article.builder().
//                title("제목2")
//                .body("내용2").build();

//        Member member1 = memberService.join("user1", "1234", "유저 1").getData();
//        Member member2 = memberService.join("user2", "1234", "유저 2").getData();
//        try {
//            RsData<Member> joinRs = memberService.join("user2", "1234", "유저 2");
//        } catch (GlobalException e) {
//            System.out.println("e.getMsg() : " + e.getRsData().getMsg());
//            System.out.println("e.getStatusCode() : " + e.getRsData().getStatusCode());
//        }
        Member member1 = memberService.findByUsername("user1").get();
        Member member2 = memberService.findByUsername("user2").get();

        Article article1 = articleService.write(member1, "제목 1", "내용 1").getData();
        Article article2 = articleService.write(member1, "제목 2", "내용 2").getData();
        Article article3 = articleService.write(member2, "제목 3", "내용 3").getData();
        Article article4 = articleService.write(member2, "제목 4", "내용 4").getData();
//        article2.setTitle("제목 2-2");
//
//        aritcleService.delete(article1);

        //articleRepository.deleteAll(articleFirst); // 지워야 하는데 지워지지 않음 왜냐하면 묶음단위로 실행되기 때문
        // truncate > 초기화 / delet from > 테이블 삭제

    }

//    @Transactional
//    public void work2() {
        // list : 0~n
        // Optional : 0~1
//        Optional<Article> opArticle = aritcleService.findById(2L); // jpa 기본제공
//
//        List<Article> articles = aritcleService.findAll(); // jpa 기본제공 select * from Article

//        List<Article> articlesByIn = articleRepository.findByIdInOrderByTitleDescIdAsc(List.of(1L, 2L));
//
//        System.out.println(articlesByIn.get(0).getTitle());
//
//        List<Article> articlesByLIKE = articleRepository.findByTitleContaining("제목");
//
//        articleRepository.findByTitleAndBody("제목", "내용");
//    }

}
