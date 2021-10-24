package springmvcboard.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import springmvcboard.domain.Member;
import springmvcboard.web.vo.MemberInfo;

@Mapper
public interface MemberMapper {

    @Select("SELECT * FROM MEMBER WHERE user_id = #{userId}")
    MemberInfo findById(String userId);

    @Insert("INSERT INTO MEMBER(user_id, password, name, gender, birth, email, phone) VALUES(#{userId}, #{password}, #{name}, #{gender}, #{birth}, #{email}, #{phone})")
    void signup(Member member);
}
