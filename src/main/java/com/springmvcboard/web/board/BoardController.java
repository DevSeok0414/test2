package com.springmvcboard.web.board;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import com.springmvcboard.domain.Board;
import com.springmvcboard.image.ImageStore;
import com.springmvcboard.service.board.BoardServiceImpl;
import com.springmvcboard.web.vo.MemberInfo;

import java.util.List;
import java.util.Random;

@Slf4j
@Controller
@RequestMapping("/board")
@RequiredArgsConstructor
public class BoardController {

    private final BoardServiceImpl boardService;
    private final ImageStore imageStore;
    private final JavaMailSenderImpl mailSender;

    @RequestMapping("/list")
    public String list(Model model,
                       @RequestParam(value = "pageNumber", required = false, defaultValue = "1") int pageNumber,
                       @AuthenticationPrincipal MemberInfo loginMember) {
        List<Board> boards = getBoardList();

        if(loginMember != null) {
            model.addAttribute("loginMember", loginMember);
        }
        return "board/list";
    }

    private List<Board> getBoardList() {
        return boardService.getBoardList();
    }

    @ResponseBody
    @RequestMapping("/sendMail")
    public String sendMail(@RequestBody SimpleMailMessage msg) {
        Random random = new Random();
        int key = random.nextInt(8999) + 1000;
        msg.setSubject("devseok0414");
        msg.setText("인증번호 : " + key + "를 입력해주세요.");
        mailSender.send(msg);
        return String.valueOf(key);
    }
}
