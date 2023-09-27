package kr.co.kmarket.controller.member;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.co.kmarket.dto.MemberDTO;
import kr.co.kmarket.service.MemberService;

@WebServlet("/member/login.do")
public class LoginController extends HttpServlet{

	private static final long serialVersionUID = 8754969193095230764L;
	MemberService service = MemberService.INSTANCE;
	private Logger logger = LoggerFactory.getLogger(this.getClass());
		@Override
		protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			String success = req.getParameter("success");
			req.setAttribute("success", success);
			
			// 자동 로그인 체크여부에 따라 로그인 처리
			Cookie[] cookies = req.getCookies();
			HttpSession session = req.getSession();
			
			for(Cookie cookie : cookies) {
				if(cookie.getName().equals("keepLogin")){
					String id = cookie.getValue();
					
					session.setAttribute("sessid", id);
				}
			}
			// 로그인 여부
			String sessid = (String) session.getAttribute("sessid");
			
			
			if(sessid != null) {
				resp.sendRedirect("/K-market/");
				return;
			}
			
			RequestDispatcher dispatcher = req.getRequestDispatcher("/member/login.jsp");
			dispatcher.forward(req, resp);	
		}
		@Override
		protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			String uid = req.getParameter("uid");
			String pass = req.getParameter("pass");
			String auto = req.getParameter("auto");
			
			logger.debug("auto : "+auto);
			
			MemberDTO dto = service.selectMemberLogin(uid, pass);
			logger.debug("user = "+ dto);
			
			// 자동 로그인 설정
			String sessUid = null;
			Cookie cookie = null;
			
			if(dto != null) { // 로그인 여부
				HttpSession session = req.getSession();
				
				session.setMaxInactiveInterval(30 * 60); // 회원 로그인 30분 유지
				// 자동 로그인 체크를 했을 시
				if(auto != null) { 
					sessUid = req.getSession().getId(); 
					
					logger.debug("sessUid : "+sessUid);
					
					cookie = new Cookie("keepLogin", sessUid);
					cookie.setMaxAge(60 * 60 * 24 * 30); // 30일 유지
					cookie.setPath(req.getContextPath());
					resp.addCookie(cookie);
					session.setMaxInactiveInterval(30 * 24 * 60 * 60); // 회원 자동로그인 30일 유지
				}
				session.setAttribute("user", dto);
				logger.debug("login user : "+dto.toString());
				
				resp.sendRedirect("/K-market/index.do?success=101");
				
			}
			else {
				resp.sendRedirect("/K-market/member/login.do?success=102");
			}
			
		}
}
