package kr.co.kmarket.controller.member;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
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
			
			
			RequestDispatcher dispatcher = req.getRequestDispatcher("/member/login.jsp");
			dispatcher.forward(req, resp);	
		}
		@Override
		protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			String uid = req.getParameter("uid");
			String pass = req.getParameter("pass");
			
			MemberDTO dto = service.selectMemberLogin(uid, pass);
			logger.debug("user = "+ dto);
			if(dto != null) {
				HttpSession session = req.getSession();
				session.setAttribute("user", dto);
				resp.sendRedirect("/K-market/index.do?success=101");
			}
			else {
				resp.sendRedirect("/K-market/member/login.do?success=102");
			}
			
		}
}
