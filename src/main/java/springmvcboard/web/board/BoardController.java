package springmvcboard.web.board;

import lombok.RequiredArgsConstructor;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.web.bind.annotation.ResponseBody;
import springmvcboard.image.ImageStore;
import springmvcboard.service.board.BoardServiceImpl;

import java.util.Random;

@Controller
@RequestMapping("/board")
@RequiredArgsConstructor
public class BoardController {

    private final BoardServiceImpl boardService;
    private final ImageStore imageStore;
    private final JavaMailSenderImpl mailSender;

    @RequestMapping("/list")
    public String list() {

        return "board/list";
    }



    @ResponseBody
    @RequestMapping("/sendMail")
    public String sendMail(@RequestBody SimpleMailMessage msg) {
        Random random = new Random();
        int key = random.nextInt(8999) + 1000;
        msg.setSubject("devseok0414");
        msg.setText("인증번호 : " + String.valueOf(key) + "를 입력해주세요.");
        mailSender.send(msg);
        return String.valueOf(key);
    }
}
