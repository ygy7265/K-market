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

import kr.co.kmarket.dto.Cate2DTO;
import kr.co.kmarket.dto.ProductDTO;
import kr.co.kmarket.service.ProductService;
import kr.co.kmarket.service.pageService;

@WebServlet("/product/productlist.do")
public class ProductListController extends HttpServlet{
	
	private static final long serialVersionUID = 28638471L;
	private ProductService service = ProductService.INSTANCE;
	private pageService pgService = pageService.INSTANCE;
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		logger.info("ProductListController doGet...1");
		
		String pg = req.getParameter("pg");
		String cate1 = req.getParameter("cate1");
		String cate2 = req.getParameter("cate2");
		String type2 = req.getParameter("type2");
		String search = req.getParameter("search");
		
		logger.debug("type2 : "+type2);
		logger.debug("search : "+search);
		
		if(pg == null) {
			pg = "1";
		}
		
		// 카테고리 표시
		Cate2DTO CateName = service.selectCate(cate1, cate2);
		
		// 현재 페이지 번호
		int currentPage = pgService.setCurrentPage(pg);
		
		// 전체 게시물 갯수
		int total = 0;
		
		if(search != null) {
			total = service.selectProductSearchTotal(search);
		} else {
			total = service.selectProductCateTotal(cate1, cate2);
		}
		
		// 마지막 페이지 번호
		int lastPageNum = pgService.setLastPageNum(total);
		
		// 페이지 그룹계산
		int[] result = pgService.getPageGroupNum(currentPage, lastPageNum);
		
		// 페이지 시작점
		int start = pgService.setStart(currentPage);
		
		// 페이지 시작번호 계산
		int pageStartNum = service.getPageStartNum(total,currentPage);
		
		// 상품 조회
		List<ProductDTO> list = null;
		
		// 정렬
		if(type2 != null) {
			logger.info("selectProductsType...1");
			list = service.selectProductsType(cate1,cate2, start, type2);
			
		} else {
			logger.info("selectProducts...2");
			
			if(search != null) {
				list = service.selectProductsSearch(search);
			} else {
				// cate1, cate2
				list = service.selectProducts(cate1,cate2,start);
			}
		}
		
		logger.debug("currentPage :"+currentPage);
		logger.debug("pg : "+pg);
		logger.debug("total : "+total);
		logger.debug("lastPageNum : "+lastPageNum);
		
		req.setAttribute("list", list);
		logger.debug("list = "+list.toString());
		
		
		req.setAttribute("cate1", cate1);
		req.setAttribute("cate2", cate2);
		req.setAttribute("type2", type2);
		req.setAttribute("search", search);
		req.setAttribute("CateName", CateName);
		req.setAttribute("currentPage", currentPage);
		req.setAttribute("lastPageNum", lastPageNum);
		req.setAttribute("pageGroupStart", result[0]);
		req.setAttribute("pageGroupEnd", result[1]);
		req.setAttribute("pageStartNum", pageStartNum+1);
		
		
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/product/productList.jsp");
		dispatcher.forward(req, resp);	
	}
}
