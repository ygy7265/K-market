package kr.co.kmarket.controller.admin;

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

import kr.co.kmarket.dto.NoticeDTO;
import kr.co.kmarket.service.NoticeService;
import kr.co.kmarket.service.pageService;
@WebServlet("/admin/cs/notice/list.do")
public class AdminNoticeListController extends HttpServlet{
	private static final long serialVersionUID = 661371223453L;
	private Logger logger = LoggerFactory.getLogger(getClass());
	private NoticeService nService = NoticeService.INSTANCE;
	private pageService pgService= pageService.INSTANCE;
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
 		int total = nService.selectCountTotal(cate);
// 		logger.debug("NoticeListController.. total : "+total);
 		
 		// 마지막 페이지 번호
 		int lastPageNum = pgService.setLastPageNum(total);
 		
 		// 페이지 그룹 계산
 		int [] pageGroupCurrent = pgService.getPageGroupNum(currentPage,lastPageNum);
 		
 		// 페이지 시작번호 계산
 		int pageStartNum = pgService.getPageStart(currentPage);
 		
// 		logger.debug("NoticesList...pg :"+pg);
// 		logger.debug("NoticesList...currentPage :"+currentPage);
// 		logger.debug("NoticesList...start :"+start);
// 		logger.debug("NoticesList...total :"+total);
// 		logger.debug("NoticesList...lastPageNum :"+lastPageNum);
// 		logger.debug("NoticesList...pageGroupStart :"+pageGroupCurrent[0]);
// 		logger.debug("NoticesList...pageGroupEnd :"+pageGroupCurrent[1]);
// 		logger.debug("NoticesList...pageStartNum :"+pageStartNum);
		
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
		
		List<NoticeDTO> notices = nService.selectNotices(cate, start);
		logger.debug("관리자/공지사항 error : " + notices);
		req.setAttribute("notices", notices);
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/admin/cs/notice/list.jsp");
		dispatcher.forward(req, resp);
	}
}
