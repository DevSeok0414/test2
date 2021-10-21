package SpringMVCBoard.domain.member;

import lombok.*;
import org.springframework.stereotype.Component;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.util.Date;

@Component
@Getter @Setter @ToString
public class Member {

    @NotBlank
    private String userId;
    @NotBlank
    private String password;
    @NotBlank
    private String passwordCheck;
    @NotBlank
    private String name;
    private String gender;
    private Date birth;
    @Email
    @NotBlank
    private String email;
    private String phone;
    private Date signupDate;

    public Member(String userId) {
        this.userId = userId;
    }

    public Member(String userId, String password, String passwordCheck, String name, String gender, Date birth, String email, String phone, Date signupDate) {
        this.userId = userId;
        this.password = password;
        this.passwordCheck = passwordCheck;
        this.name = name;
        this.gender = gender;
        this.birth = birth;
        this.email = email;
        this.phone = phone;
        this.signupDate = signupDate;
    }
}
