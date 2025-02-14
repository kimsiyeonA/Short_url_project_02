package com.koreait.short_url_project_02;

import jakarta.persistence.*;

import static jakarta.persistence.GenerationType.IDENTITY;

@Entity // 데이터 베이스 만들거임
public class Article {

    // 기본기 생성 주입권을 스프링에게 위임하겠다 == auto.increment
    @Id // 이 필드를 기본키 주키 컬럼으로 만듬
    @GeneratedValue(strategy = IDENTITY) // 기본키값을 자동으로 생성할 때 사용
    private long id;
    private String title;
    @Column(columnDefinition = "TEXT")
    private String body;
    private String body2;

    // 추가 하면 컬럼 추가됨
    // 삭제하고 추가하면 삭제한게 삭제되지 않음, 할려면 서버 켰다 다시 키면 만들어짐
    // 불편한점 > 기본 컬럼이 유지된다는 점

    // yml 수정 > 터미널에서 알 수 있음

}
