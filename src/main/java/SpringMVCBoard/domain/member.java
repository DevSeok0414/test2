package SpringMVCBoard.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

@Getter @Setter
@ToString @NoArgsConstructor
public class member {
    private String id;
    private String password;
    private String password_check;
    private String name;
    private String gender;
    private Date birth;
    private String email;
    private String phone;
    private Date signup_date;
}
