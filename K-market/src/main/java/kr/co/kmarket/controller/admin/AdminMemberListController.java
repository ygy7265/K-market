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

import kr.co.kmarket.dto.MemberDTO;
import kr.co.kmarket.service.MemberService;
@WebServlet("/admin/member/list.do")
public class AdminMemberListController extends HttpServlet{
	private static final long serialVersionUID = 661373245123L;
	private Logger logger = LoggerFactory.getLogger(getClass());
	private MemberService mService = MemberService.INSTANCE;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		// 0917 admin_memberList
		List<MemberDTO> members = mService.selectMembers();
		logger.debug("membersList : " + members);
		req.setAttribute("members", members);
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/admin/member/list.jsp");
		dispatcher.forward(req, resp);	
	}
}
