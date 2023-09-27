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

import kr.co.kmarket.dto.NoticeDTO;
import kr.co.kmarket.dto.QnaDTO;
import kr.co.kmarket.etc.Utils;
import kr.co.kmarket.service.MemberService;
import kr.co.kmarket.service.NoticeService;
import kr.co.kmarket.service.OrderService;
import kr.co.kmarket.service.ProductService;
import kr.co.kmarket.service.QnaService;
@WebServlet("/admin/index.do")
public class IndexController extends HttpServlet{
	private static final long serialVersionUID = 137124123L;
	private Logger logger = LoggerFactory.getLogger(getClass());
	private OrderService oService = OrderService.INSTANCE;
	private MemberService mService = MemberService.INSTANCE;
	private ProductService pService = ProductService.INSTANCE;
	private NoticeService nService = NoticeService.INSTANCE;
	private QnaService qService = QnaService.INSTANCE;
	
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
		int dayMember = mService.selectMemberTotalDay(); //24시간 이내 등록된 신규 member
		int weekMember = mService.selectMemberTotalWeek(); //일주일 이내 등록된 신규 member
		int monthMember = mService.selectMemberTotalMonth(); //한달 이내 등록된 신규 member
		// 1,7,30 일 이내 신규 업데이트
		int dayOrder = oService.selectOrderTotalDay(); //24시간 이내 등록된 신규 order
		int weekOrder = oService.selectOrderTotalWeek(); //일주일 이내 등록된 신규 order
		int monthOrder = oService.selectOrderTotalMonth(); //한달 이내 등록된 신규 order
		// 기간 별 총 주문금액
		int dayOrderToPrice = oService.selectOrderTotalDayToPrice();
		int weekOrderToPrice = oService.selectOrderTotalWeekToPrice();
		int monthOrderToPrice = oService.selectOrderTotalMonthToPrice();
		// 공지,문의 최신글
		List<NoticeDTO> notiAdmin = nService.selectAdminIndexNotice();
		List<QnaDTO> qnaAdmin = qService.selectAdminIndexQna();
		
		// 콤마
		String commasumtotal = Utils.comma(sumtotal);
		String commadayOrderToPrice = Utils.comma(dayOrderToPrice);
		String commaweekOrderToPrice = Utils.comma(weekOrderToPrice);
		String commamonthOrderToPrice = Utils.comma(monthOrderToPrice);
		
		
		
		req.setAttribute("total", total);
		req.setAttribute("sumtotal", commasumtotal);
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
		// 기간별 총 주문금액
		req.setAttribute("dayOrderToPrice", commadayOrderToPrice);
		req.setAttribute("weekOrderToPrice", commaweekOrderToPrice);
		req.setAttribute("monthOrderToPrice", commamonthOrderToPrice);
		// 공지, 문의 최신글
		req.setAttribute("notiAdmin", notiAdmin);
		req.setAttribute("qnaAdmin", qnaAdmin);
		
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/admin/index.jsp");
		dispatcher.forward(req, resp);
	}
}
