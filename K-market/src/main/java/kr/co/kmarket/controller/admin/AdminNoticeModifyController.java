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
@WebServlet("/admin/cs/notice/modify.do")
public class AdminNoticeModifyController extends HttpServlet{
	private static final long serialVersionUID = 13712323L;
	private Logger logger = LoggerFactory.getLogger(getClass());
	private NoticeService nService = NoticeService.INSTANCE;
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String noticeNo	= req.getParameter("noticeNo");
		String writer	= req.getParameter("writer");
		String cate		= req.getParameter("cate");
		String title	= req.getParameter("title");
		String content	= req.getParameter("content");
		
		NoticeDTO notice = nService.selectNotice(noticeNo);
		
//		logger.debug("writer : "+writer);
//		logger.debug("noticeNo : "+noticeNo);
//		logger.debug("cate : " + cate);
//		logger.debug("title : "+title);
//		logger.debug("content : "+content);
		
		req.setAttribute("notice", notice);
		logger.debug("noticeModifyToString"+notice.toString());
		req.setAttribute("writer", writer);
		req.setAttribute("noticeNo", noticeNo);
		req.setAttribute("cate", cate);
		req.setAttribute("title", title);
		req.setAttribute("content", content);
		
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/admin/cs/notice/modify.jsp");
		dispatcher.forward(req, resp);	
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String writer	= req.getParameter("writer");
		String noticeNo	= req.getParameter("noticeNo");
		String cate		= req.getParameter("cate");
		String title	= req.getParameter("title");
		String content	= req.getParameter("content");
		
		NoticeDTO dto = new NoticeDTO();
		dto.setCate(cate);
		dto.setTitle(title);
		dto.setContent(content);
		dto.setNoticeNo(noticeNo);
		
		logger.debug("updateNoticeService : "+dto.toString());
		
		nService.updateNotice(dto);
		
		resp.sendRedirect("/K-market/admin/cs/notice/view.do?noticeNo="+noticeNo);
		
	}
	
}
