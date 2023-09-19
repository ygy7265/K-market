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
		
		if(pg == null) {
			pg = "1";
		}
		
		// 현재 페이지 번호
		int currentPage = pgService.setCurrentPage(pg);
		
		// 전체 게시물 갯수
		int total = service.selectProductCateTotal(cate1, cate2);
		
		// 마지막 페이지 번호
		int lastPageNum = pgService.setLastPageNum(total);
		
		// 페이지 그룹계산
		int[] result = pgService.getPageGroupNum(currentPage, lastPageNum);
		
		// 페이지 시작점
		int start = pgService.setStart(currentPage);
		
		// 페이지 시작번호 계산
		int pageStartNum = service.getPageStartNum(total,currentPage);
		
		List<ProductDTO> list = service.selectProducts(cate1,cate2,start);
		
		logger.debug("currentPage :"+currentPage);
		logger.debug("pg : "+pg);
		logger.debug("total : "+total);
		logger.debug("lastPageNum : "+lastPageNum);
		
		req.setAttribute("list", list);
		logger.debug("list = "+list.toString());
		
		
		req.setAttribute("cate1", cate1);
		req.setAttribute("cate2", cate2);
		req.setAttribute("currentPage", currentPage);
		req.setAttribute("lastPageNum", lastPageNum);
		req.setAttribute("pageGroupStart", result[0]);
		req.setAttribute("pageGroupEnd", result[1]);
		req.setAttribute("pageStartNum", pageStartNum+1);
		
		
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/product/productList.jsp");
		dispatcher.forward(req, resp);	
	}
}
