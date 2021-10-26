package com.springmvcboard.web.vo;

import com.springmvcboard.domain.Board;
import com.springmvcboard.service.board.BoardServiceImpl;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@RequiredArgsConstructor
@Getter
public class Pagination {

    private final BoardServiceImpl boardService;

    private int pageNumber;

    /**
     * 직접 정해야하는 값
     * 아래의 두 변수 모두 0보다 큰 자연수여야 한다.
     * pageSize: 한 페이지에 출력할 최대 레코드 수
     * rangeSize: 한 화면에 보여줄 최대 페이지 수
     */
    private int pageSize = 15;
    private int rangeSize = 5;

    /**
     * totalRecord: DB에 저장된 총 레코드 수
     * startRecord: 현재 페이지의 시작 레코드 번호
     * lastRecord: 현재 페이지의 마지막 레코드 번호
     */
    private int totalRecord = getTotalRecord();
    private int startRecord = pageSize * (pageNumber - 1) + 1;
    private int lastRecord = selectLastRecord();

    /**
     * totalPage: 전체 페이지 갯수
     * startPage: 한 화면의 페이지 시작 번호
     * lastPage: 한 화면의 페이지 마지막 번호
     */
    private int totalPage = (totalRecord / pageSize) + (totalRecord % pageSize == 0 ? 0 : 1);
    private int startPage = (pageNumber / rangeSize - (pageNumber % rangeSize != 0 ? 0 : 1)) * rangeSize + 1;
    private int lastPage = selectLastPage();

    //화면 출력 번호
    private int outputNumber = totalRecord - pageSize * (pageNumber - 1);


    private int getTotalRecord() {
        List<Board> temp = boardService.getBoardList();
        int tempTotalRecord = temp.size();
        return tempTotalRecord;
    }


    //마지막 페이지 마지막 레코드 번호
    private int selectLastRecord() {
        int tempLastRecord = pageSize * pageNumber;
        if (tempLastRecord > totalRecord) {
            return totalRecord;
        }
        return tempLastRecord;
    }

    //마지막 페이지 화면의 마지막 페이지 번호
    private int selectLastPage() {
        int tempLastPage = startPage + rangeSize - 1;
        if (tempLastPage > totalPage) {
            return totalPage;
        }
        return tempLastPage;
    }




}
