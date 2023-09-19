package kr.co.kmarket.controller.admin;

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
@WebServlet("/admin/cs/notice/view.do")
public class AdminNoticeViewController extends HttpServlet{
	private static final long serialVersionUID = 13111768L;
	private Logger logger = LoggerFactory.getLogger(getClass());
	private NoticeService nService = NoticeService.INSTANCE;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String noticeNo = req.getParameter("noticeNo");
		logger.debug("noticeNo() : " + noticeNo);
		
		NoticeDTO notice = nService.selectNotice(noticeNo);
		logger.debug("notice : " + notice.toString());
		
		req.setAttribute("notice", notice);
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/admin/cs/notice/view.jsp");
		dispatcher.forward(req, resp);	
	}
}
