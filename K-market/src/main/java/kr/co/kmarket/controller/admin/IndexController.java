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

import kr.co.kmarket.etc.Utils;
import kr.co.kmarket.service.MemberService;
import kr.co.kmarket.service.OrderService;
import kr.co.kmarket.service.ProductService;
@WebServlet("/admin/index.do")
public class IndexController extends HttpServlet{
	private static final long serialVersionUID = 137124123L;
	private Logger logger = LoggerFactory.getLogger(getClass());
	private OrderService oService = OrderService.INSTANCE;
	private MemberService mService = MemberService.INSTANCE;
	private ProductService pService = ProductService.INSTANCE;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		int total = oService.selectOrdersCount(); // 총 주문건수
		int sumtotal = oService.selectOrdersCountSum(); // 총 주문금액
		int cmember = mService.selectCountMember(); // 총 가입인원
		// 1,7,30 일 이내 신규 업데이트
		int dayProd = pService.selectProductTotalDay(); //24시간 이내 등록된 신규 product
		int weekProd = pService.selectProductTotalWeek(); //일주일 이내 등록된 신규 product
		int monthProd = pService.selectProductTotalMonth(); //한달 이내 등록된 신규 product
		// 1,7,30 일 이내 신규 업데이트
		int dayMember = mService.selectMemberTotalDay(); //24시간 이내 등록된 신규 product
		int weekMember = mService.selectMemberTotalWeek(); //일주일 이내 등록된 신규 product
		int monthMember = mService.selectMemberTotalMonth(); //한달 이내 등록된 신규 product
		// 1,7,30 일 이내 신규 업데이트
		int dayOrder = oService.selectOrderTotalDay(); //24시간 이내 등록된 신규 product
		int weekOrder = oService.selectOrderTotalWeek(); //일주일 이내 등록된 신규 product
		int monthOrder = oService.selectOrderTotalMonth(); //한달 이내 등록된 신규 product
		
		
		
		req.setAttribute("total", total);
		req.setAttribute("sumtotal", sumtotal);
		req.setAttribute("cmember", cmember);
		// 신규 멤버
		req.setAttribute("dayMember", dayMember);
		req.setAttribute("weekMember", weekMember);
		req.setAttribute("monthMember", monthMember);
		// 신규 상품
		req.setAttribute("dayProd", dayProd);
		req.setAttribute("weekProd", weekProd);
		req.setAttribute("monthProd", monthProd);
		// 신규 주문
		req.setAttribute("dayOrder", dayOrder);
		req.setAttribute("weekOrder", weekOrder);
		req.setAttribute("monthOrder", monthOrder);
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/admin/index.jsp");
		dispatcher.forward(req, resp);
	}
}
