package com.springmvcboard.service.member;

import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import com.springmvcboard.domain.Member;
import com.springmvcboard.mapper.MemberMapper;
import com.springmvcboard.web.vo.MemberInfo;

import java.util.List;

@Service
public class MemberServiceImpl implements MemberService, UserDetailsService {

    private final MemberMapper memberMapper;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    public MemberServiceImpl(MemberMapper memberMapper, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.memberMapper = memberMapper;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    @Override
    public MemberInfo getMember(String userId) {
        MemberInfo member = memberMapper.findById(userId);
        return member;
    }

    @Override
    public void signup(Member member) {
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        member.setPassword(bCryptPasswordEncoder.encode(member.getPassword()));
        memberMapper.signup(member);
    }

    @Override
    public List<Member> getMemberList() {
        List<Member> members = memberMapper.allMembers();
        return members;
    }

    @Override
    public MemberInfo loadUserByUsername(String username) throws UsernameNotFoundException {
        MemberInfo member = getMember(username);
        if(member == null){
            throw new UsernameNotFoundException("ID : "+username + "는 존재하지 않습니다.");
        }
        return member;
    }
}
