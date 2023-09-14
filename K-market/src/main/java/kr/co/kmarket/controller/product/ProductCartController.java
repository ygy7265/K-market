package kr.co.kmarket.controller.product;
/*
  이름 : 윤경엽
  내용 : 카트 담기 기능 구현
  날짜 : 2023/09/14 
 */
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.co.kmarket.dto.CartDTO;
import kr.co.kmarket.service.CartService;
import kr.co.kmarket.service.ProductService;
@WebServlet("/product/productcart.do")
public class ProductCartController extends HttpServlet{
	
	private static final long serialVersionUID = 266171712424303672L;
	CartService service = CartService.INSTANCE;
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	CartDTO dto = null;
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RequestDispatcher dispatcher = req.getRequestDispatcher("/product/productCart.jsp");
		dispatcher.forward(req, resp);	
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		dto = new CartDTO();
		
		String uid = req.getParameter("uid");
		String prodNo = req.getParameter("prodNo");
		String prodName = req.getParameter("prodName");
		String descript = req.getParameter("descript");
		String price = req.getParameter("price");
		String point = req.getParameter("point");
		String discount = req.getParameter("discount");
		String delivery = req.getParameter("delivery");
		String total2 = req.getParameter("total2");
		String count = req.getParameter("num");
		logger.debug("uid" + uid);
		logger.debug("prodName" + prodName);
		logger.debug("total2" + total2);
		
		dto.setUid(uid);
		dto.setProdNo(prodNo);
		dto.setCount(count);
		dto.setPrice(price);
		dto.setDiscount(discount);
		dto.setPoint(point);
		dto.setDelivery(delivery);
		dto.setTotal(total2);
		service.insertCart(dto);
		
		
	
		
	}
	
}
