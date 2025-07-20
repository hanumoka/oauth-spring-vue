package com.zeeemeee.oauthspring.member.controller;

import com.zeeemeee.oauthspring.member.domain.Member;
import com.zeeemeee.oauthspring.member.dto.MemberCreateDto;
import com.zeeemeee.oauthspring.member.dto.MemberLoginDto;
import com.zeeemeee.oauthspring.member.service.MemberService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/member")
@RestController
public class MemberController {

    private final MemberService memberService;

    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @PostMapping("/create")
    public ResponseEntity<?> createMember(@RequestBody MemberCreateDto memberCreateDto) {
        Member member = memberService.create(memberCreateDto);
        return new ResponseEntity<>(member.getId(), HttpStatus.CREATED);
    }


    @PostMapping("/doLogin")
    public ResponseEntity<?> doLogin(@RequestBody MemberLoginDto memberLoginDto) {
        //email, password 일치하는지 검증
        Member member = memberService.login(memberLoginDto);

        //일치할 경우 jwt accesstoken 생성


//        Member member = memberService.create(memberCreateDto);
//        return new ResponseEntity<>(member.getId(), HttpStatus.OK);
    }

}
