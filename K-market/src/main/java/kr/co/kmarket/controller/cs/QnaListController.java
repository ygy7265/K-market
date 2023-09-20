package kr.co.kmarket.controller.cs;
/*
 * 	날짜 : 2023/09/17
 *  이름 : 이현정
 * 	내용 : 공지사항-리스트 (QnA/list) 기능 구현
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

import kr.co.kmarket.dto.QnaDTO;
import kr.co.kmarket.etc.MapUtil;
import kr.co.kmarket.service.QnaService;
import kr.co.kmarket.service.pageService;

@WebServlet("/cs/qna/qnaList.do")
public class QnaListController extends HttpServlet{
	private static final long serialVersionUID = 1L;
	
	private QnaService qService = QnaService.INSTANCE;
	private pageService pgService = pageService.INSTANCE;
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
        String cate1 = req.getParameter("cate1");
		String pg = req.getParameter("pg");
		logger.debug("cate1 : " + cate1);
		logger.debug("pg : " + pg);
		
		if(cate1 != null) {
            if(cate1.isEmpty()) {
            	cate1 = null;
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
		int total = qService.selectCountTotal(cate1);
		logger.debug("NoticeListController.. total : "+total);
		
		// 마지막 페이지 번호
		int lastPageNum = pgService.setLastPageNum(total);
		
		// 페이지 그룹 계산
		int [] pageGroupCurrent = pgService.getPageGroupNum(currentPage,lastPageNum);
		
		// 페이지 시작번호 계산
		int pageStartNum = pgService.getPageStart(currentPage);
		

		
		// JSP페이지에서 사용할 데이터를 request 객체에 설정
		req.setAttribute("pg", pg);
		req.setAttribute("cate", cate1);
		req.setAttribute("start", start);
		req.setAttribute("currentPage", currentPage);
		req.setAttribute("total", total);
		req.setAttribute("lastPageNum", lastPageNum);
		req.setAttribute("pageGroupCurrent", pageGroupCurrent);
		req.setAttribute("pageGroupStart", pageGroupCurrent[0]);
		req.setAttribute("pageGroupEnd", pageGroupCurrent[1]);
		req.setAttribute("pageStartNum", pageStartNum);

		
		List<QnaDTO> qnas = qService.selectQnas(cate1, start);
		req.setAttribute("qnas", qnas);
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/cs/qna/qnaList.jsp");
		dispatcher.forward(req, resp);	
		
	
		
		
	}
	
	
	
	
	
}
