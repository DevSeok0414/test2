package com.springmvcboard.service.member;

import com.springmvcboard.domain.Member;
import com.springmvcboard.web.vo.MemberInfo;

import java.util.List;

public interface MemberService {

    MemberInfo getMember(String userId);

    void signup(Member member);

    List<Member> getMemberList();
}
