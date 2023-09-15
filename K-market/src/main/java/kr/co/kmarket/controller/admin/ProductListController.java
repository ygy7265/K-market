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
public class ProductListController extends HttpServlet{
	private static final long serialVersionUID = 1L;
	private Logger logger = LoggerFactory.getLogger(getClass());
	private ProductService pService = ProductService.INSTANCE;
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		// 0915_등록된 상품 출력 27~29
		List<ProductDTO> products = pService.selectProductsAll();
		logger.debug("Productlist : "+products);
		req.setAttribute("products", products);
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/admin/product/list.jsp");
		dispatcher.forward(req, resp);	
		}
}
