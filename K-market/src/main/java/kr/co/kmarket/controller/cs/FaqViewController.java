package kr.co.kmarket.controller.cs;

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
import kr.co.kmarket.service.FaqService;
import kr.co.kmarket.service.NoticeService;

@WebServlet("/cs/faq/faqView.do")
public class FaqViewController extends HttpServlet{
	private static final long serialVersionUID = 1L;
	private FaqService service = FaqService.INSTANCE;
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String cate1 = req.getParameter("cate1");
		String cate2 = req.getParameter("cate2");
		String faqNo = req.getParameter("faqNo");
		
		logger.debug("FaqViewController Controller ... cate1 : "+ cate1);
		logger.debug("FaqViewController Controller ... cate2 : "+ cate2);
		logger.debug("FaqViewController Controller ... faqNo : "+ faqNo);
		
		FaqDTO dto = service.selectFaq(faqNo);
		logger.debug("FaqView Controller ... dto : "+ dto.toString());
		
		req.setAttribute("cate1", cate1);
		req.setAttribute("cate2", cate2);
		req.setAttribute("faqNo", faqNo);
		req.setAttribute("dto", dto);
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/cs/faq/faqView.jsp");
		dispatcher.forward(req, resp);	
		
		
	
	
	
	
	
	
	
	
	
	
	
	}
}
