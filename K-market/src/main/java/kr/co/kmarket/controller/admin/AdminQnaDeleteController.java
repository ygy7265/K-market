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

import com.google.gson.JsonObject;

import kr.co.kmarket.dto.FaqDTO;
import kr.co.kmarket.dto.NoticeDTO;
import kr.co.kmarket.dto.QnaDTO;
import kr.co.kmarket.service.FaqService;
import kr.co.kmarket.service.NoticeService;
import kr.co.kmarket.service.QnaService;
@WebServlet("/admin/cs/qna/delete.do")
public class AdminQnaDeleteController extends HttpServlet{
	private static final long serialVersionUID = 13111768L;
	private Logger logger = LoggerFactory.getLogger(getClass());
	private QnaService qService = QnaService.INSTANCE;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String qnaNo = req.getParameter("qnaNo");
		qService.deleteQna(qnaNo);
		resp.sendRedirect("K-market/admin/cs/qna/list.do");
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		int result = 0;
		String qnaNo = req.getParameter("qnaNo");
		
		if(qnaNo != null) {
			result = qService.deleteQna(qnaNo);
			resp.setContentType("text/html;charset=UTF-8"); 
		    // JSON 객체 생성 및 JSON 배열을 속성 값으로 설정
		    JsonObject json = new JsonObject();
		    json.addProperty("result", result);
		    // JSON 응답을 클라이언트에게 출력
		    resp.getWriter().print(json);
		};
		
	}
}
