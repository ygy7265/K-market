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
@WebServlet("/admin/cs/notice/delete.do")
public class AdminNoticeDeleteController extends HttpServlet{
	private static final long serialVersionUID = 661223453L;
	private Logger logger = LoggerFactory.getLogger(getClass());
	private NoticeService nService = NoticeService.INSTANCE;
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String noticeNo = req.getParameter("noticeNo");
		logger.debug("Admin_Cs_Notice : "+noticeNo);
		
		nService.deleteNotice(noticeNo);
		
		resp.sendRedirect("/K-market/admin/cs/notice/list.do");
	}
}
