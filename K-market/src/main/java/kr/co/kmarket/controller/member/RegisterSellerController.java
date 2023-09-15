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

@WebServlet("/member/registerSeller.do")
public class RegisterSellerController extends HttpServlet{
	
	private static final long serialVersionUID = -3369534036649019245L;
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	private MemberService service = MemberService.INSTANCE;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RequestDispatcher dispatcher = req.getRequestDispatcher("/member/registerSeller.jsp");
		dispatcher.forward(req, resp);	
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		logger.info("RegisterSellerController info...1");
		
		// 데이터 수신
		String uid		= req.getParameter("km_uid");
		String pass		= req.getParameter("km_pass1");
		String company	= req.getParameter("kms_company");
		String ceo		= req.getParameter("km_name");
		String bizRegNum= req.getParameter("kms_corp_reg");
		String comRegNum= req.getParameter("kms_online_reg");
		String tel		= req.getParameter("km_hp");
		String fax		= req.getParameter("kms_fax");
		String email	= req.getParameter("kms_email");
		String zip		= req.getParameter("km_zip");
		String addr1	= req.getParameter("km_addr1");
		String addr2	= req.getParameter("km_addr2");
		String manager	= req.getParameter("kms_manager");
		String managerHp= req.getParameter("kms_managerHp");
		String regip	= req.getRemoteAddr();
		
		// DTO 객체 생성
		MemberDTO dto = new MemberDTO();
		dto.setUid(uid);
		dto.setPass(pass);
		dto.setEmail(email);
		dto.setZip(zip);
		dto.setAddr1(addr1);
		dto.setAddr2(addr2);
		dto.setCompany(company);
		dto.setName(ceo);
		dto.setBizRegNum(bizRegNum);
		dto.setComRegNum(comRegNum);
		dto.setHp(tel);
		dto.setManager(manager);
		dto.setManagerHp(managerHp);
		dto.setFax(fax);
		dto.setRegip(regip);
		
		logger.debug("dto : "+dto.toString());
		
		// 기능 구현
		service.insertMemberSeller(dto);
		
		resp.sendRedirect("/K-market/member/login.do");
	}
}
