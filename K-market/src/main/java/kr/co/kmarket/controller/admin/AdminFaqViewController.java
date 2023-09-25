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

import kr.co.kmarket.dto.FaqDTO;
import kr.co.kmarket.dto.NoticeDTO;
import kr.co.kmarket.service.FaqService;
import kr.co.kmarket.service.NoticeService;
@WebServlet("/admin/cs/faq/view.do")
public class AdminFaqViewController extends HttpServlet{
	private static final long serialVersionUID = 13111768L;
	private Logger logger = LoggerFactory.getLogger(getClass());
	private FaqService fService = FaqService.INSTANCE;
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String faqNo = req.getParameter("faqNo");
		logger.debug("faqNo() : " + faqNo);
		
		FaqDTO faq = fService.selectFaq(faqNo);
		logger.debug("자주묻는질문 뷰 : "+faq.toString());
		req.setAttribute("faq", faq);
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/admin/cs/faq/view.jsp");
		dispatcher.forward(req, resp);	
	}
}
