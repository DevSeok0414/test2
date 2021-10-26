package com.springmvcboard.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import com.springmvcboard.domain.Member;
import com.springmvcboard.web.vo.MemberInfo;

import java.util.List;

@Mapper
public interface MemberMapper {

    @Select("SELECT * FROM MEMBER")
    List<Member> allMembers();

    @Select("SELECT * FROM MEMBER WHERE user_id = #{userId}")
    MemberInfo findById(String userId);

    @Insert("INSERT INTO MEMBER(user_id, password, name, gender, birth, email, phone) VALUES(#{userId}, #{password}, #{name}, #{gender}, #{birth}, #{email}, #{phone})")
    void signup(Member member);


}
