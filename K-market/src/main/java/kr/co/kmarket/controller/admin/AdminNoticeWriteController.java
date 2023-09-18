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
@WebServlet("/admin/cs/notice/write.do")
public class AdminNoticeWriteController extends HttpServlet{
	private static final long serialVersionUID = 137121323L;
	private Logger logger = LoggerFactory.getLogger(getClass());
	private NoticeService nService = NoticeService.INSTANCE;
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/admin/cs/notice/write.jsp");
		dispatcher.forward(req, resp);	
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String writer = req.getParameter("writer");
		String cate = req.getParameter("cate");
		String title = req.getParameter("title");
		String content = req.getParameter("content");
		
		NoticeDTO dto = new NoticeDTO();
		dto.setWriter(writer);
		dto.setCate(cate);
		dto.setTitle(title);
		dto.setContent(content);
		
		nService.insertNotice(dto);
		
		logger.debug("NoticeDTO() : " + dto.toString());
		
		resp.sendRedirect("/K-market/admin/cs/notice/list.do");
		
	}
	
}
