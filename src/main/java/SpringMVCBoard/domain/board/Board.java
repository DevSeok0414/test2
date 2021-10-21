package SpringMVCBoard.domain.board;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

@Getter  @Setter
@ToString @NoArgsConstructor
public class Board {
    private String id;
    private String member_id;
    private String title;
    private String content;
    private int hit;
    private Date write_date;
}