package springmvcboard.web.login;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import springmvcboard.domain.Member;
import springmvcboard.service.member.MemberServiceImpl;
import springmvcboard.web.vo.MemberInfo;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@RequiredArgsConstructor
public class LoginController {

    private final MemberServiceImpl memberService;

    @GetMapping("/login")
    public String loginForm(@ModelAttribute LoginForm form,
                            Model model) {

        return "member/loginForm";
    }

    @RequestMapping("/login/success")
    public String loginSuccess(){
        return null;
    }

    @GetMapping("/signup")
    public String signupForm(@ModelAttribute("member") MemberInfo member) {
        return "member/signupForm";
    }

    @PostMapping("/signup")
    public String signup(@Validated @ModelAttribute Member member) {
        memberService.signup(member);
        return "redirect:/board/list";
    }
}
