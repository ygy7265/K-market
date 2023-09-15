package kr.co.kmarket.controller.cs;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.kmarket.dto.FaqDTO;
import kr.co.kmarket.service.FaqService;

@WebServlet("/cs/faq/faqList.do")
public class FaqListController extends HttpServlet{
	
	private static final long serialVersionUID = 1L;
	
	private FaqService service = FaqService.INSTANCE;
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String cate1 = req.getParameter("cate1");
		String end = req.getParameter("end");
		
		List<FaqDTO> faqs = service.selectFaqscate(cate1);
		
		req.setAttribute("cate1", faqs);
		
		
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/cs/faq/faqList.jsp");
		dispatcher.forward(req, resp);	
		
	}
}
