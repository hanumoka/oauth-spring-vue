package com.zeeemeee.oauthspring.member.service;

import com.zeeemeee.oauthspring.member.domain.Member;
import com.zeeemeee.oauthspring.member.dto.MemberCreateDto;
import com.zeeemeee.oauthspring.member.dto.MemberLoginDto;
import com.zeeemeee.oauthspring.member.repository.MemberRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Transactional
@Service
public class MemberService {

    private final MemberRepository memberRepository;

    private final PasswordEncoder passwordEncoder;

    public MemberService(MemberRepository memberRepository, PasswordEncoder passwordEncoder) {
        this.memberRepository = memberRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public Member create(MemberCreateDto memberCreateDto) {
        Member member = Member.builder()
                .email(memberCreateDto.getEmail())
                .password(passwordEncoder.encode(memberCreateDto.getPassword()))
                .build();

        memberRepository.save(member);
        return member;
    }

    public Member login(MemberLoginDto memberLoginDto) {
        Optional<Member> optMember = memberRepository.findByEmail(memberLoginDto.getEmail());
        if (optMember.isEmpty()) {
            throw new IllegalArgumentException("존재하지 않는 회원입니다.");
        }

        Member member = optMember.get();
        if (!passwordEncoder.matches(memberLoginDto.getPassword(), member.getPassword())) {
            throw new IllegalArgumentException("비밀번호가 일치하지 않습니다.");
        }

        return member;
    }
}
