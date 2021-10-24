package springmvcboard.service.member;

import springmvcboard.domain.Member;
import springmvcboard.web.vo.MemberInfo;

public interface MemberService {

    MemberInfo getMember(String userId);

    void signup(Member member);
}
