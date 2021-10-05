package com.devseok0414.SpringMVCBoard.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter
@ToString @NoArgsConstructor
public class image {
    private String id;
    private String board_id;
    private int number;
    private String name;
    private String size;
}
