package com.devseok0414.SpringMVCBoard.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

@Getter @Setter
@ToString @NoArgsConstructor
public class comment {
    private String id;
    private String board_id;
    private String member_id;
    private String content;
    private Date comment_date;

}
