package com.koreait.short_url_project_02.domain.surl.surl.controller;

import com.koreait.short_url_project_02.domain.member.member.entity.Member;
import com.koreait.short_url_project_02.domain.surl.surl.entity.Surl;
import com.koreait.short_url_project_02.domain.surl.surl.service.SurlService;
import com.koreait.short_url_project_02.global.exceptions.GlobalException;
import com.koreait.short_url_project_02.global.rq.rq.Rq;
import com.koreait.short_url_project_02.global.rsData.RsData;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
@RequiredArgsConstructor
@Slf4j
public class ShortUrlController {

    private final Rq rq;
    private final SurlService surlService;
//    private List<Surl> surls = new ArrayList<Surl>();
//    private long surlLastId;

    @GetMapping("/add")
    @ResponseBody
    public RsData<Surl> add(String body, String url) {
        Member member = rq.getMember(); // 현재 브라우저로 로그인 한 회원 정보
        System.out.println("before get id"); // 개발 운영이던 다 나옴
        member.getId();
        System.out.println("after get id");
        System.out.println("before get username");
        member.getUsername();
        System.out.println("after get username");

        return surlService.add(member, body, url);

        //return surlService.add(body,url);
    }

    @GetMapping("/s/{body}/**")
    @ResponseBody
    public RsData<Surl> add(
            @PathVariable String body,
            HttpServletRequest req
    ) {
        Member member = rq.getMember();

        String url = req.getRequestURI();

        if (req.getQueryString() != null) {
            url += "?" + req.getQueryString();
        }

        String[] urlBits = url.split("/", 4);

        //System.out.println("Arrays.toString(urlBits) : " + Arrays.toString(urlBits));

        url = urlBits[3];

//        Surl surl = Surl.builder()
//                .id(++surlLastId)
//                .body(body)
//                .url(url)
//                .build();
//
//        surls.add(surl);

        return surlService.add(member,body,url);
    }

    @GetMapping("/g/{id}")
    public String go(
            @PathVariable long id
    ) {
//        Surl surl = surls.stream()
//                .filter(_surl -> _surl.getId() == id)
//                .findFirst()
//                .orElse(null);
//
 //     if (surl == null) throw new RuntimeException("No such Surl : %d번 데이터를 찾을 수 없어".formatted(id));
//
        Surl surl = surlService.findById(id).orElseThrow(GlobalException.E404::new);
        surlService.increaseCount(surl);

        return "redirect:" + surl.getUrl();
    }

    @GetMapping("/all")
    @ResponseBody
    public List<Surl> getAll() {

        //return surls;
        return surlService.findAll();
    }
}
