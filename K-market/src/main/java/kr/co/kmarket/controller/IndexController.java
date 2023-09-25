package kr.co.kmarket.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.co.kmarket.dto.MemberDTO;
import kr.co.kmarket.dto.ProductDTO;
import kr.co.kmarket.service.ProductService;
@WebServlet(value={"","/index.do"})
public class IndexController extends HttpServlet{

	private static final long serialVersionUID = 5783589879373746478L;
	private ProductService service = ProductService.INSTANCE;
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String[] listArray = {"best", "newList", "hitList","scoreList","discountList"};

		// 배열을 JSTL에 전달
		req.setAttribute("listArray", listArray);
		List<ProductDTO> bestList= service.selectBestProducts(0,5);
		List<ProductDTO> hitList= service.selectHitProducts(0,8);
		List<ProductDTO> discountList= service.selectDiscountProducts(0,8);
		List<ProductDTO> scoreList= service.selectScoreProducts(0,8);
		List<ProductDTO> newList= service.selectNewProducts(0,8);
		String success = req.getParameter("success");
		req.setAttribute("success", success);
		
		req.setAttribute("bestList", bestList);
		req.setAttribute("hitList", hitList);
		req.setAttribute("discountList", discountList);
		req.setAttribute("scoreList", scoreList);
		req.setAttribute("newList", newList);
		logger.debug("bestList = " + bestList.toString());
		ServletContext context = getServletContext();

		// 세션에서 로그인 사용자 정보를 가져옵니다.
		HttpSession session = req.getSession();
		MemberDTO loginUser = (MemberDTO) session.getAttribute("user");
		 session.setAttribute("user",loginUser);
		Integer visitorCount = 0;
		if (loginUser != null) {
		    // 로그인한 사용자인 경우 방문자 수를 증가합니다.
		     visitorCount = (Integer) context.getAttribute("visitorCount");

		    // 최초의 방문자일 경우 방문자 수를 1로 초기화합니다.
		    if (visitorCount == null) {
		        visitorCount = 30;
		    } else {
		        // 기존 방문자 수에 1을 추가합니다.
		        visitorCount++;
		    }

		    // 증가된 방문자 수를 application 객체에 저장합니다.
		    context.setAttribute("visitorCount", visitorCount);
		}
		
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/index.jsp");
		dispatcher.forward(req, resp);	
	}
}
