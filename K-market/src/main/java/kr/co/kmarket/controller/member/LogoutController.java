package kr.co.kmarket.controller.member;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/member/logout.do")
public class LogoutController extends HttpServlet{

	private static final long serialVersionUID = -5922397494151458422L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		HttpSession session = req.getSession();
		
		// 세션해제
		session.invalidate();

		// 쿠키해제
		Cookie cookie = new Cookie("keepLogin", null);
		cookie.setPath(req.getContextPath());
		cookie.setMaxAge(0); // 쿠키 유효기간
		resp.addCookie(cookie);
		
		// 리다이렉트
		resp.sendRedirect("/K-market/");
	}
}
