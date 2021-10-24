package springmvcboard.domain;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;
import springmvcboard.domain.Member;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@Repository
public class MemberRepository {

    private static Map<String, Member> store = new HashMap<>();   //static 사용

    public Member save(Member member) {
        log.info("save: member={}", member);
        store.put(member.getUserId(), member);
        return member;
    }

    public Member findById(String userId) {
        return store.get(userId);
    }

    public List<Member> findAll() {
        return new ArrayList<>(store.values());
    }
}
