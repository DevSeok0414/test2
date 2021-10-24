package springmvcboard.service.member;

import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import springmvcboard.domain.Member;
import springmvcboard.mapper.MemberMapper;
import springmvcboard.web.vo.MemberInfo;

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
    public MemberInfo loadUserByUsername(String username) throws UsernameNotFoundException {
        MemberInfo member = getMember(username);
        if(member == null){
            throw new UsernameNotFoundException("ID : "+username + "는 존재하지 않습니다.");
        }
        return member;
    }
}
