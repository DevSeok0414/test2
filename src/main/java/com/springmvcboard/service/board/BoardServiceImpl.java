package com.springmvcboard.service.board;

import org.springframework.stereotype.Service;
import com.springmvcboard.domain.Board;
import com.springmvcboard.mapper.BoardMapper;

import java.util.List;

@Service
public class BoardServiceImpl implements BoardService{

    private final BoardMapper boardMapper;

    public BoardServiceImpl(BoardMapper boardMapper) {
        this.boardMapper = boardMapper;
    }

    @Override
    public List<Board> getBoardList() {
        List<Board> boards = boardMapper.allBoard();
        return boards;
    }
}
