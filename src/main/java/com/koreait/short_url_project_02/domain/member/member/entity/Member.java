package com.koreait.short_url_project_02.domain.member.member.entity;

import com.koreait.short_url_project_02.global.jpa.entity.BaseTime;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import java.time.LocalDateTime;
import static jakarta.persistence.GenerationType.IDENTITY;
import static lombok.AccessLevel.PROTECTED;

@Entity
@Builder
@Getter
@Setter
@AllArgsConstructor(access = PROTECTED)
@NoArgsConstructor(access = PROTECTED)
public class Member  extends BaseTime {
    @Column(unique = true)
    private String username;
    private String password;

    @ManyToOne
    private Member author; // 누가 썼는지 폴인키 넣는것
}
//@AllArgsConstructor
//@NoArgsConstructor
//@EntityListeners(AuditingEntityListener.class)
//public class Member {
//    @Id
//    @GeneratedValue(strategy = IDENTITY)
//    private Long id;
//    @CreatedDate
//    private LocalDateTime createDate;
//    @LastModifiedDate
//    private LocalDateTime modifyDate;
//    @Column(unique = true)
//    private String username;
//    private String password;
//    private String nickname;
//}
