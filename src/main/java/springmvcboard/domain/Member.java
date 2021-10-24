package springmvcboard.domain;

import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.util.Date;

@Component
@Getter @Setter @ToString
@NoArgsConstructor
@AllArgsConstructor
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
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date birth;
    @Email
    @NotBlank
    private String email;
    private String phone;
    private Date signupDate;

    public Member(String userId) {
        this.userId = userId;
    }

}
