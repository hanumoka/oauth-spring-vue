package com.zeeemeee.oauthspring.member.repository;

import com.zeeemeee.oauthspring.member.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberRepository extends JpaRepository<Member, Long> {
}
