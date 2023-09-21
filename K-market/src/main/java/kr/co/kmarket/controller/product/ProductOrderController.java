package kr.co.kmarket.controller.product;

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

import kr.co.kmarket.dto.CartDTO;
import kr.co.kmarket.dto.MemberDTO;
import kr.co.kmarket.service.CartService;

@WebServlet("/product/productorder.do")
public class ProductOrderController extends HttpServlet{
	
	CartService service = CartService.INSTANCE;
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		HttpSession session = req.getSession();
		MemberDTO sessiondto = (MemberDTO) session.getAttribute("user");
		String userid = null;


		if (sessiondto != null) {
		    userid = sessiondto.getUid();
		}
		List<CartDTO> list = service.selectCarts(userid);
		req.setAttribute("list", list);
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/product/productOrder.jsp");
		dispatcher.forward(req, resp);	
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	
	}
}
