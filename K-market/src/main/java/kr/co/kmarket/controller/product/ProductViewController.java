package kr.co.kmarket.controller.product;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.gson.JsonObject;

import kr.co.kmarket.dto.MemberDTO;
import kr.co.kmarket.dto.ProductDTO;
import kr.co.kmarket.dto.ReviewDTO;
import kr.co.kmarket.service.ProductService;
import kr.co.kmarket.service.ReviewService;
import kr.co.kmarket.service.pageService;

@WebServlet("/product/productview.do")
public class ProductViewController extends HttpServlet{
	
	private static final long serialVersionUID = -7749251008944886791L;
	ProductService service = ProductService.INSTANCE;
	private ReviewService reService = ReviewService.INSTANCE;
	private pageService pgService = pageService.INSTANCE;
	private Logger logger = LoggerFactory.getLogger(this.getClass());
		@Override
		protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			
			HttpSession session = req.getSession();
			MemberDTO memberdto = (MemberDTO) session.getAttribute("user");
			
			String prodNo = req.getParameter("prodNo");
			// 페이지 가져오기 
			String pg = req.getParameter("pg");
			
	        logger.debug("prodNo : " + prodNo);
	        logger.debug("pg : " + pg);
	        
	        if(pg == null) {
	        	pg = "1";

	        };
	        	
	        // 현제 페이지 번호 
	 		int currentPage = pgService.setCurrentPage(pg);
	 		
	 		// 현재 페이지 게시물 Limit 시작
	 		int start = pgService.setStart(currentPage);
	 		
	 		// 전체 게시글 갯수 조회
	 		int total = reService.selectReviewCountTotal(prodNo);
	 		logger.debug("NoticeListController.. total : "+total);
	 		
	 		// 마지막 페이지 번호
	 		int lastPageNum = pgService.setLastPageNum(total);
	 		
	 		// 페이지 그룹 계산
	 		int [] pageGroupCurrent = pgService.getPageGroupNum(currentPage,lastPageNum);
	 		
	 		// 페이지 시작번호 계산
	 		int pageStartNum = pgService.getPageStart(currentPage);
	 		
	 		logger.debug("NoticesList...pg :"+pg);
	 		logger.debug("NoticesList...currentPage :"+currentPage);
	 		logger.debug("NoticesList...start :"+start);
	 		logger.debug("NoticesList...total :"+total);
	 		logger.debug("NoticesList...lastPageNum :"+lastPageNum);
	 		logger.debug("NoticesList...pageGroupStart :"+pageGroupCurrent[0]);
	 		logger.debug("NoticesList...pageGroupEnd :"+pageGroupCurrent[1]);
	 		logger.debug("NoticesList...pageStartNum :"+pageStartNum);
	 		
			// JSP페이지에서 사용할 데이터를 request 객체에 설정
	 		req.setAttribute("pg", pg);
			req.setAttribute("prodNo", prodNo);
	 		req.setAttribute("start", start);
			req.setAttribute("currentPage", currentPage);
			req.setAttribute("total", total);
			req.setAttribute("lastPageNum", lastPageNum);
			req.setAttribute("pageGroupStart", pageGroupCurrent[0]);
			req.setAttribute("pageGroupEnd", pageGroupCurrent[1]);
			req.setAttribute("pageStartNum", pageStartNum);
			req.setAttribute("memberdto", memberdto);
			
			
			
			// Reviews 목록 출력 
			List<ReviewDTO> reviews = reService.selectReviews(prodNo, start);
			logger.debug("productView reviews....",reviews.toString());
			
			req.setAttribute("reviews", reviews);
			
			int parseNo = Integer.parseInt(prodNo);
			ProductDTO dto = service.selectProduct(prodNo);
			req.setAttribute("proddto", dto);
			logger.debug("Product View = " + dto);
			
			// 별점 합산 평균
	 		service.selectUpdateRating(prodNo);
	 		logger.debug("rating star : "+dto.getScore());
	 		
			Date currentDate = new Date();

			// 3일을 더한 날짜 계산
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(currentDate);
			calendar.add(Calendar.DAY_OF_MONTH, 3);
			Date threeDaysLater = calendar.getTime();

			// 요일 계산 (예: 월요일)
			SimpleDateFormat dayFormat = new SimpleDateFormat("EEE");
			String dayOfWeek = dayFormat.format(threeDaysLater);

			req.setAttribute("currentDate", currentDate);
			req.setAttribute("threeDaysLater", threeDaysLater);
			req.setAttribute("dayOfWeek", dayOfWeek);
			RequestDispatcher dispatcher = req.getRequestDispatcher("/product/productView.jsp");
			dispatcher.forward(req, resp);	
		}
}
