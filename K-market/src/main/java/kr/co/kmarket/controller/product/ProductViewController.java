package kr.co.kmarket.controller.product;

import java.io.IOException;

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

@WebServlet("/product/productview.do")
public class ProductViewController extends HttpServlet{
	
	private static final long serialVersionUID = -7749251008944886791L;
	ProductService service = ProductService.INSTANCE;
	private Logger logger = LoggerFactory.getLogger(this.getClass());
		@Override
		protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			
			String prodNo = req.getParameter("prodNo");
			int parseNo = Integer.parseInt(prodNo);
			ProductDTO dto = service.selectProduct(parseNo);
			req.setAttribute("proddto", dto);
			RequestDispatcher dispatcher = req.getRequestDispatcher("/product/productView.jsp");
			dispatcher.forward(req, resp);	
		}
}
