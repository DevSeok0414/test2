package com.springmvcboard.domain;

import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;

@Component
public class Board {
    private int id;
    private String memberId;
    private String title;
    private String content;
    private String writeDate;
    private int hit;
    private int commentCount;

    public Board() {

    }

    public Board(int id, String memberId, String title, String content, String writeDate, int hit, int commentCount) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy.MM.dd HH:mm:ss");
        this.id = id;
        this.memberId = memberId;
        this.title = title;
        this.content = content;
        this.writeDate = dateFormat.format(writeDate);
        this.hit = hit;
        this.commentCount = commentCount;
    }
}
