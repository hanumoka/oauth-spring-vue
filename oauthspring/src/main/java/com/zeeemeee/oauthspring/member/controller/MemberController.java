package com.zeeemeee.oauthspring.member.controller;

import com.zeeemeee.oauthspring.member.service.MemberService;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MemberController {

    private final MemberService memberService;

    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

}
