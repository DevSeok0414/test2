package com.springmvcboard.mapper;

import com.springmvcboard.domain.Board;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface BoardMapper {

    @Select("SELECT id, write_id, title, content, write_date, hit, commentcount FROM board ORDER BY id DESC")
    List<Board> allBoard();
}
