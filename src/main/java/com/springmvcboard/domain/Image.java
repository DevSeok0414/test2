package com.springmvcboard.domain;

import lombok.*;
import org.springframework.stereotype.Component;

@Component
@Data
public class Image {
    private int fileNum;
    private String boardId;
    private String uploadName;
    private String storeName;
    private String size;
}
