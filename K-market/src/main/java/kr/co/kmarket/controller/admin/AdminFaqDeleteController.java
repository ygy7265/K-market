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

import com.google.gson.JsonObject;

import kr.co.kmarket.dto.NoticeDTO;
import kr.co.kmarket.service.FaqService;
import kr.co.kmarket.service.NoticeService;
import kr.co.kmarket.service.pageService;
@WebServlet("/admin/cs/faq/delete.do")
public class AdminFaqDeleteController extends HttpServlet{
	private static final long serialVersionUID = 5223453L;
	private Logger logger = LoggerFactory.getLogger(getClass());
	private FaqService fService = FaqService.INSTANCE;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String faqNo = req.getParameter("faqNo");
		
		logger.debug("Admin_Cs_Faq : "+faqNo);
		
		fService.admin_cs_faq_delete(faqNo);
		
		resp.sendRedirect("/K-market/admin/cs/faq/list.do");
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		int result = 0;
		String faqNo = req.getParameter("faqNo");
		
		if(faqNo != null) {
			result = fService.admin_cs_faq_delete(faqNo);
			resp.setContentType("text/html;charset=UTF-8"); 
		    // JSON 객체 생성 및 JSON 배열을 속성 값으로 설정
		    JsonObject json = new JsonObject();
		    json.addProperty("result", result);
		    // JSON 응답을 클라이언트에게 출력
		    resp.getWriter().print(json);
		};
	
	}
	
}
