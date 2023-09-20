package kr.co.kmarket.service;
/*
 * 	날짜 : 2023/09/17
 *  이름 : 이현정
 * 	내용 : pageSerive 구현
 * 
 * */
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.co.kmarket.dao.QnaDAO;
import kr.co.kmarket.dto.QnaDTO;

public enum pageService {
	
	INSTANCE;
	private Logger logger = LoggerFactory.getLogger(this.getClass());

    // 현재 페이지 게시물 Limit 시작
    private int start = 0;
    private int currentPage = 1;
    private int total = 0;
    private int lastPageNum = 0;
    private int pageGroupCurrent = 1;
    private int pageGroupStart = 1;
    private int pageGroupEnd = 0;
    private int pageStartNum = 0;

    // 현재 페이지 계산_pg를 int로 변경하는 작업
    public int setCurrentPage(String pg) {
        if (pg != null) {
            currentPage = Integer.parseInt(pg);
        }
        return currentPage;
    }
    
    // Limit 시작값 계산
    public int setStart(int currentPage) {
        start = (currentPage - 1) * 10;
        return start;
    }


    // 페이지 번호 계산
    public int setLastPageNum(int total) {
        if (total % 10 == 0) {
            lastPageNum = (total / 10);
        } else {
            lastPageNum = (total / 10) + 1;
        }
        return lastPageNum;
    }

    // 페이지 그룹 계산
    public int[] getPageGroupNum(int currentPage, int lastPageNum) {
        pageGroupCurrent = (int) Math.ceil(currentPage / 10.0);
        pageGroupStart = (pageGroupCurrent - 1) * 10 + 1;
        pageGroupEnd = pageGroupCurrent * 10;

	    if (pageGroupEnd > lastPageNum) {
	        pageGroupEnd = lastPageNum;
	    }

        return new int[]{pageGroupStart, pageGroupEnd};
    }
    
    // 페이지 시작번호 계산
    public int getPageStart(int total) {
        pageStartNum = total - start;
        return pageStartNum;
    }

	

}
