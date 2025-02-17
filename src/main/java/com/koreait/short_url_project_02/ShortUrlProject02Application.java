package com.koreait.short_url_project_02;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableJpaAuditing // 시간 자동으로 붙여줌 > 실행하는 메인 함수에서 있어야함
public class ShortUrlProject02Application {

    public static void main(String[] args) {
        SpringApplication.run(ShortUrlProject02Application.class, args);
    }

}
