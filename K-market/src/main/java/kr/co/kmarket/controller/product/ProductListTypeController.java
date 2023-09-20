package kr.co.kmarket.controller.product;

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
import kr.co.kmarket.service.pageService;

@WebServlet("/product/productlistSpecial.do")
public class ProductListTypeController extends HttpServlet{
	
	private static final long serialVersionUID = 3490281049441440845L;
	private ProductService service = ProductService.INSTANCE;
	private pageService pgService = pageService.INSTANCE;
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		logger.info("ProductListController doGet...2");
		
		String pg = req.getParameter("pg");
		String type1 = req.getParameter("type1");
		String type2 = req.getParameter("type2");
		
		// 현재 페이지 번호
		int currentPage = pgService.setCurrentPage(pg);
		
		// 전체 게시물 갯수
		int total = service.selectProductCountTotal();
		
		// 마지막 페이지 번호
		int lastPageNum = pgService.setLastPageNum(total);
		
		// 페이지 그룹계산
		int[] result = pgService.getPageGroupNum(currentPage, lastPageNum);
		
		// 페이지 시작점
		int start = pgService.setStart(currentPage);
		
		// 페이지 시작번호 계산
		int pageStartNum = service.getPageStartNum(total,currentPage);
		
		
		// 상품 조회, _header 카테고리
		List<ProductDTO> list = null;
		
		if(type2 == null) {
			// _header 카테고리
			switch (type1) {
				case "hit" : {
					logger.info("selectHitProducts...1");
					list = service.selectHitProducts(start, 10);
					break;
				}
				case "score" : {
					logger.info("selectScoreProducts...2");
					list = service.selectScoreProducts(start, 10);
					break;
				}
				case "new" : {
					logger.info("selectNewProducts...3");
					list = service.selectNewProducts(start, 10);
					break;
				}
				case "best" : {
					logger.info("selectBestProducts...4");
					list = service.selectBestProducts(start, 10);
					break;
				}
				case "discount" : {
					logger.info("selectDiscountProducts...5");
					list = service.selectDiscountProducts(start, 10);
					break;
				}
			}
		} else {
			
		}
		req.setAttribute("list", list);
		logger.debug("list = "+list.toString());
		
		
		req.setAttribute("currentPage", currentPage);
		req.setAttribute("lastPageNum", lastPageNum);
		req.setAttribute("pageGroupStart", result[0]);
		req.setAttribute("pageGroupEnd", result[1]);
		req.setAttribute("pageStartNum", pageStartNum+1);
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/product/productList.jsp");
		dispatcher.forward(req, resp);
	}
}
