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

@WebServlet("/product/productlist.do")
public class ProductListController extends HttpServlet{
	
	private static final long serialVersionUID = 1L;
	ProductService service = ProductService.INSTANCE;
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String cate1 = req.getParameter("cate1");
		String cate2 = req.getParameter("cate2");
		List<ProductDTO> list = service.selectProducts(cate1,cate2); 
		req.setAttribute("list", list);
		logger.debug("list = "+list.toString());
		RequestDispatcher dispatcher = req.getRequestDispatcher("/product/productList.jsp");
		dispatcher.forward(req, resp);	
	}
}
