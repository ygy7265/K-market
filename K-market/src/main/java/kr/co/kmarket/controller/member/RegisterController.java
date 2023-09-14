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

import kr.co.kmarket.dto.MemberDTO;
import kr.co.kmarket.service.MemberService;

@WebServlet("/member/register.do")
public class RegisterController extends HttpServlet{
	
	private static final long serialVersionUID = 910359876733017164L;
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	private MemberService service = MemberService.INSTANCE;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RequestDispatcher dispatcher = req.getRequestDispatcher("/member/register.jsp");
		dispatcher.forward(req, resp);	
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		logger.info("RegisterController info...1");
		
		
		// 데이터 수신
		String uid		= req.getParameter("km_uid");
		String pass1	= req.getParameter("km_pass1");
		String name		= req.getParameter("km_name");
		String gender	= req.getParameter("km_gender");
		String email	= req.getParameter("km_email");
		String hp		= req.getParameter("km_hp");
		String zip		= req.getParameter("km_zip");
		String addr1	= req.getParameter("km_addr1");
		String addr2	= req.getParameter("km_addr2");
		String regip	= req.getRemoteAddr();
		
		
		MemberDTO dto = new MemberDTO();
		dto.setUid(uid);
		dto.setPass(pass1);
		dto.setName(name);
		dto.setGender(gender);
		dto.setEmail(email);
		dto.setHp(hp);
		dto.setZip(zip);
		dto.setAddr1(addr1);
		dto.setAddr2(addr2);
		dto.setRegip(regip);
		
		
		// 정보 저장
		service.insertMember(dto);
		
		logger.debug("MemberDto : "+dto.toString());
		
		resp.sendRedirect("/K-market/member/login.do");
	}
}
