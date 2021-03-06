package com.springmvcboard.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

@Getter @Setter
@ToString @NoArgsConstructor
public class Recommend {
    private String id;
    private String board_id;
    private String member_id;
    private String content;
    private Date comment_date;
}
