package com.koreait.short_url_project_02.domain.surl.surl.service;

import com.koreait.short_url_project_02.domain.member.member.entity.Member;
import com.koreait.short_url_project_02.domain.surl.surl.entity.Surl;
import com.koreait.short_url_project_02.domain.surl.surl.repository.SurlRepository;
import com.koreait.short_url_project_02.global.rsData.RsData;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class SurlService {

    private final SurlRepository surlRepository;

    public RsData add(Member author, String body, String url) {
        Surl surl = Surl.builder()
                .body(body)
                .url(url)
                .build();

        surlRepository.save(surl);

        return RsData.of("%d번 URL 등록 완료".formatted(surl.getId()), surl);

    }
    public List<Surl> findAll() {
        return surlRepository.findAll();
    }

    public Optional<Surl> findById(long id) {
        return surlRepository.findById(id);
    }

    @Transactional
    public void increaseCount(Surl surl) {
        surl.increaseCount();
    }
}


