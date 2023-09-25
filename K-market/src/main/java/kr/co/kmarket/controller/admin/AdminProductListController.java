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

import kr.co.kmarket.dto.ProductDTO;
import kr.co.kmarket.service.ProductService;
@WebServlet("/admin/product/list.do")
public class AdminProductListController extends HttpServlet{
	private static final long serialVersionUID = 4531L;
	private Logger logger = LoggerFactory.getLogger(getClass());
	private ProductService pService = ProductService.INSTANCE;
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String pg = req.getParameter("pg");
		
        logger.debug("pg : " + pg);
        
		// 현재 페이지 게시물 Limit 시작
		int start = 0;
		int currentPage = 1;
		int total = 0;
		int lastPageNum = 0;
		int pageGroupCurrent = 1;
		int pageGroupStart = 1;
		int pageGroupEnd = 0;
		int pageStartNum = 0;
		
		// 현재 페이지 계산
		if(pg != null){
			currentPage  = Integer.parseInt(pg);
		}
		
		// Limit 시작값 계산
		start = (currentPage - 1) * 10;
		
		// 전체 게시글 갯수 조회
		total = pService.selectProductCountTotal();
		logger.debug("ProductListController.. total : "+total);
		
		// 페이지 번호 계산
		if(total % 10 == 0){
			lastPageNum = (total/10);
		}else{
			lastPageNum = (total/10) +1 ;
		}
		
		// 페이지 그룹 계산
		pageGroupCurrent = (int)Math.ceil(currentPage / 10.0);
		pageGroupStart = (pageGroupCurrent -1) * 10 + 1;
		pageGroupEnd = pageGroupCurrent * 10;
		
		if(pageGroupEnd > lastPageNum){
			pageGroupEnd = lastPageNum;
		}
		
		// 페이지 시작번호 계산
		pageStartNum = total - start;

		// JSP페이지에서 사용할 데이터를 request 객체에 설정
		req.setAttribute("start", start);
		req.setAttribute("currentPage", currentPage);
		req.setAttribute("total", total);
		req.setAttribute("lastPageNum", lastPageNum);
		req.setAttribute("pageGroupCurrent", pageGroupCurrent);
		req.setAttribute("pageGroupStart", pageGroupStart);
		req.setAttribute("pageGroupEnd", pageGroupEnd);
		req.setAttribute("pageStartNum", pageStartNum);
		req.setAttribute("pg", pg);
		
		// 0915_등록된 상품 출력
		List<ProductDTO> products = pService.selectProductsTotal(start);
		logger.debug("Productlist : "+products);
		req.setAttribute("products", products);
        
		RequestDispatcher dispatcher = req.getRequestDispatcher("/admin/product/list.jsp");
		dispatcher.forward(req, resp);	
		}
}
