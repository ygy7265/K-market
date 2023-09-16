package kr.co.kmarket.controller.cs;
/*
 * 	날짜 : 2023/09/15
 *  이름 : 이현정
 * 	내용 : 공지사항-리스트 (Notice/View) 기능 구현
 * 
 * */
import java.io.IOException;

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

@WebServlet("/cs/notice/noticeView.do")
public class NoticeViewController extends HttpServlet{
	
	private static final long serialVersionUID = 1L;
	private NoticeService service = NoticeService.INSTANCE;
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String noticeNo = req.getParameter("noticeNo");
		String cate = req.getParameter("cate");
		
		logger.debug("NoticeView Controller ... noticeNo : "+ noticeNo);
		logger.debug("NoticeView Controller ... cate : "+ cate);
		
		NoticeDTO dto = service.selectNotice(noticeNo);
		logger.debug("NoticeView Controller ... dto : "+ dto.toString());
		
		req.setAttribute("noticeNo", noticeNo);
		req.setAttribute("cate", cate);
		req.setAttribute("dto", dto);
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/cs/notice/noticeView.jsp");
		dispatcher.forward(req, resp);	
		
	
	}
	
	
	
	
	
	
}
