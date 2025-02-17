package com.koreait.short_url_project_02.domain.aritlcle.aritlcle.entity;

import com.koreait.short_url_project_02.domain.member.member.entity.Member;
import com.koreait.short_url_project_02.global.jpa.entity.BaseTime;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

import static jakarta.persistence.GenerationType.IDENTITY;
import static lombok.AccessLevel.PROTECTED;

@Entity // 데이터 베이스 만들거임
@Builder
@Getter
@Setter
@NoArgsConstructor(access = PROTECTED)
@AllArgsConstructor(access = PROTECTED)
public class Article extends BaseTime {
    private String title;
    @Column(columnDefinition = "TEXT")
    private String body;

    @ManyToOne
    private Member author;
}

//@AllArgsConstructor
//@NoArgsConstructor
//@EntityListeners(AuditingEntityListener.class) // 테이블 안에서 바뀌면 감지를 함, 언제 어디서 생성하고 수정했는지 잡아냄
//public class Article {
//    // 기본기 생성 주입권을 스프링에게 위임하겠다 == auto.increment
//    @Id // 이 필드를 기본키 주키 컬럼으로 만듬
//    @GeneratedValue(strategy = IDENTITY) // 기본키값을 자동으로 생성할 때 사용
//    private long id;
//    @CreatedDate
//    private LocalDateTime created;
//    @LastModifiedDate
//    private LocalDateTime modified;
//    private String title;
//    @Column(columnDefinition = "TEXT")
//    private String body;
//
//
//    // 추가 하면 컬럼 추가됨
//    // 삭제하고 추가하면 삭제한게 삭제되지 않음, 할려면 서버 켰다 다시 키면 만들어짐
//    // 불편한점 > 기본 컬럼이 유지된다는 점
//
//    // yml 수정 > 터미널에서 알 수 있음
//
//}
