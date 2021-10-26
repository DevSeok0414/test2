package com.springmvcboard.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

@Getter @Setter
@ToString @NoArgsConstructor
public class Reply {
    private String id;
    private String board_id;
    private String comment_id;
    private String reply_id;
    private String content;
    private Date reply_date;

}
