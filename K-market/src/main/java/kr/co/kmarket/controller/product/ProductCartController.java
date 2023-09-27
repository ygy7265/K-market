package kr.co.kmarket.controller.product;
/*
  이름 : 윤경엽
  내용 : 카트 담기 기능 구현
  날짜 : 2023/09/14 
 */
import java.io.IOException;
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

import kr.co.kmarket.dto.CartDTO;
import kr.co.kmarket.dto.MemberDTO;
import kr.co.kmarket.service.CartService;
import kr.co.kmarket.service.ProductService;
@WebServlet("/product/productcart.do")
public class ProductCartController extends HttpServlet{
	
	private static final long serialVersionUID = 266171712424303672L;
	CartService service = CartService.INSTANCE;
	CartService service2 = CartService.INSTANCE;
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	CartDTO dto = null;
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		HttpSession session = req.getSession();
		MemberDTO uid = (MemberDTO) session.getAttribute("user");
		String username = null;
		if (uid == null) {
		    resp.sendRedirect("/K-market/member/login.do?success=103");
		}
		else {
			username = uid.getUid();
		List<CartDTO> list = service.selectCarts(username);
		req.setAttribute("list", list);
		req.setAttribute("username", username);
		logger.debug("List"+list);
		logger.debug("username"+username);
		logger.debug("uid"+uid);
		RequestDispatcher dispatcher = req.getRequestDispatcher("/product/productCart.jsp");
		dispatcher.forward(req, resp);	
		}
	
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int result = 0;
		
		String uid = req.getParameter("uid");
		String cartNo = req.getParameter("cartNo");
		String prodNo = req.getParameter("prodNo");
		String prodName = req.getParameter("prodName");
		String descript = req.getParameter("descript");
		String price = req.getParameter("price");
		String point = req.getParameter("point");
		String discount = req.getParameter("discount");
		String delivery = req.getParameter("delivery");
		String total2 = req.getParameter("total2");
		String total3 = req.getParameter("total3");
		String nodiscount = req.getParameter("nodiscount");
		String count = req.getParameter("num");
		logger.debug("uid" + uid);
		logger.debug("count" + count);
		logger.debug("prodNo" + prodNo);
		
		int result1 = service2.selectDuplicationCart(prodNo,count,uid,total3);
		
		logger.debug("result1" + result1);
		
		if(cartNo != null) {
			result = service.deleteCart(cartNo);
			resp.setContentType("text/html;charset=UTF-8"); 
		    // JSON 객체 생성 및 JSON 배열을 속성 값으로 설정
		    JsonObject json = new JsonObject();
		    json.addProperty("result", result);
		    // JSON 응답을 클라이언트에게 출력
		    resp.getWriter().print(json);
		}else {
			if(result1 > 0) {
				 service2.selectDuplicationCart(cartNo,count,uid,total3);
			}else {
			int pacount = Integer.parseInt(count);
			int paprice = Integer.parseInt(price);
			int padiscount = Integer.parseInt(discount);
			int test = (pacount * paprice  - ((pacount * paprice) * (padiscount / 100)));
			logger.debug("total3" + total3);
			dto = new CartDTO();
			dto.setUid(uid);
			dto.setProdNo(prodNo);
			dto.setCount(count);
			dto.setPrice(price);
			dto.setDiscount(discount);
			dto.setPoint(point);
			dto.setDelivery(delivery);
			dto.setTotal(total3);
			service.insertCart(dto);
			}
			resp.sendRedirect("/K-market/product/productcart.do");
		}
		
	
		
	}
	
}
