package com.springmvcboard.web.login;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import com.springmvcboard.domain.Member;
import com.springmvcboard.service.member.MemberServiceImpl;
import com.springmvcboard.web.vo.MemberInfo;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Slf4j
@Controller
@RequiredArgsConstructor
public class LoginController {

    private final MemberServiceImpl memberService;

    @GetMapping("/login")
    public String loginForm(@ModelAttribute("memberInfo") MemberInfo memberInfo,
                            @RequestParam(value = "error", required = false) String error,
                            Model model) {
        if(error != null){
            model.addAttribute("error", 1);
        }
        return "member/loginForm";
    }

    @GetMapping("/signup")
    public String signupForm(@ModelAttribute("member") MemberInfo member) {

        return "member/signupForm";
    }

    @PostMapping("/signup")
    public String signup(@Validated @ModelAttribute Member member,
                         BindingResult bindingResult,
                         HttpServletRequest request,
                         HttpServletResponse response) throws ParseException, IOException {
        if(member.getGender() == null) {
            member.setGender("");
        }
        if(member.getPhone() == null) {
            member.setPhone("");
        }
        String tempDate= "1800-01-01";
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        Date tempBirth = df.parse(tempDate);

        if(member.getBirth() == null) {
            member.setBirth(tempBirth);
        }

        List<Member> memberList = memberService.getMemberList();
        for (Member members : memberList) {
            if (member.getUserId().equals(members.getUserId())) {
                System.out.println("member.getUserId() = " + member.getUserId());
                System.out.println("members.getUserId() = " + members.getUserId());
                bindingResult.rejectValue("userId", "existed");
                return "member/signupForm";
            }
        }

        if (bindingResult.hasErrors()) {
            log.info("errors = {}", bindingResult);
            return "member/signupForm";
        }
        try {
            memberService.signup(member);
        } catch (Exception e) {
            e.printStackTrace();
            return "member/signupForm";
        }

        HttpSession session = request.getSession();
        session.setAttribute("loginUser", member);

        response.setContentType("text/html; charset=euc-kr");
        PrintWriter out = response.getWriter();
        out.println("<script>alert('회원가입을 성공했습니다.'); </script>");
        out.flush();

        return "member/loginForm";
    }

    @GetMapping("/logout")
    public String logout(HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        if (session != null) {
            session.invalidate();
        }
        return "redirect:/member/login";
    }
}
