package kr.co.kmarket.controller.cs;
/*
 * 	날짜 : 2023/09/14
 *  이름 : 이현정
 * 	내용 : 공지사항-리스트 (Notice/list) 기능 구현
 * 
 * */
import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.co.kmarket.dao.NoticeDAO;
import kr.co.kmarket.dto.NoticeDTO;
import kr.co.kmarket.service.NoticeService;
import kr.co.kmarket.service.pageService;

@WebServlet("/cs/notice/noticeList.do")
public class NoticeListController extends HttpServlet{
	
	private static final long serialVersionUID = 1L;
	private NoticeService noService = NoticeService.INSTANCE;
	private pageService pgService= pageService.INSTANCE;
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
        String cate = req.getParameter("cate");
    	// 페이지 가져오기 
		String pg = req.getParameter("pg");
		
        logger.debug("cate : " + cate);
        logger.debug("pg : " + pg);
        
        if(cate != null) {
            if(cate.isEmpty()) {
            	cate = null;
            }

        };
        if(pg == null) {
        	pg = "1";

        };
        	
        // 현제 페이지 번호 
 		int currentPage = pgService.setCurrentPage(pg);
 		
 		// 현재 페이지 게시물 Limit 시작
 		int start = pgService.setStart(currentPage);
 		
 		// 전체 게시글 갯수 조회
 		int total = noService.selectCountTotal(cate);
 		logger.debug("NoticeListController.. total : "+total);
 		
 		// 마지막 페이지 번호
 		int lastPageNum = pgService.setLastPageNum(total);
 		
 		// 페이지 그룹 계산
 		int [] pageGroupCurrent = pgService.getPageGroupNum(currentPage,lastPageNum);
 		
 		// 페이지 시작번호 계산
 		int pageStartNum = pgService.getPageStart(currentPage);
 		
 		logger.debug("NoticesList...pg :"+pg);
 		logger.debug("NoticesList...currentPage :"+currentPage);
 		logger.debug("NoticesList...start :"+start);
 		logger.debug("NoticesList...total :"+total);
 		logger.debug("NoticesList...lastPageNum :"+lastPageNum);
 		logger.debug("NoticesList...pageGroupStart :"+pageGroupCurrent[0]);
 		logger.debug("NoticesList...pageGroupEnd :"+pageGroupCurrent[1]);
 		logger.debug("NoticesList...pageStartNum :"+pageStartNum);
 		
		
		// JSP페이지에서 사용할 데이터를 request 객체에 설정
 		req.setAttribute("pg", pg);
		req.setAttribute("cate", cate);
 		req.setAttribute("start", start);
		req.setAttribute("currentPage", currentPage);
		req.setAttribute("total", total);
		req.setAttribute("lastPageNum", lastPageNum);
		req.setAttribute("pageGroupStart", pageGroupCurrent[0]);
		req.setAttribute("pageGroupEnd", pageGroupCurrent[1]);
		req.setAttribute("pageStartNum", pageStartNum);
	
	
		// Notice 목록 출력 _ List 
		List<NoticeDTO> notices = noService.selectNotices(cate, start);
		
		logger.debug(notices.toString());
		
		req.setAttribute("notices", notices);
		
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/cs/notice/noticeList.jsp");
		dispatcher.forward(req, resp);	
	
	}
}
