package kr.co.kmarket.controller.member;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.co.kmarket.dto.TermsDTO;
import kr.co.kmarket.service.TermsService;
/*
 * 	날짜 : 2023/09/13
 *  이름 : 이현정
 * 	내용 : Terms 약관 페이지 내용 출력 및 약관 동의 기능 추가 
 * 
 * */
@WebServlet("/member/signup.do")
public class SignUpController extends HttpServlet{
	
	private static final long serialVersionUID = 1L;
	
	private TermsService service = TermsService.INSTANCE;
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String type = req.getParameter("type");
		
		TermsDTO dto = service.selectTerm(type);
		req.setAttribute("dto", dto);
		req.setAttribute("type", type);
		logger.debug("signUpController... dto : "+ dto);
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/member/signup.jsp");
		dispatcher.forward(req, resp);	
		
		
	}
	


}
