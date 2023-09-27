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

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import kr.co.kmarket.dto.CartDTO;
import kr.co.kmarket.dto.MemberDTO;
import kr.co.kmarket.service.CartService;
import kr.co.kmarket.service.OrderService;

@WebServlet("/product/productorder.do")
public class ProductOrderController extends HttpServlet{
	private Gson gson = new Gson();
	CartService service = CartService.INSTANCE;
	OrderService orservice = OrderService.INSTANCE;
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		HttpSession session = req.getSession();
		MemberDTO sessiondto = (MemberDTO) session.getAttribute("user");
		String userid = sessiondto.getUid();
		if (userid == null) {
		    resp.sendRedirect("/K-market/member/login.do?success=103");
		}else {

		List<CartDTO> list = orservice.selectOrdersItem(userid);
		req.setAttribute("list", list);
		req.setAttribute("userid", userid);
	
		System.out.println("uid"+userid);
		RequestDispatcher dispatcher = req.getRequestDispatcher("/product/productOrder.jsp");
		dispatcher.forward(req, resp);	
		}
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		 HttpSession session = req.getSession();
		 String jsonData = req.getParameter("jsonData");
		 MemberDTO sessiondto = (MemberDTO) session.getAttribute("user");
		 String userid = sessiondto.getUid();
		 CartDTO dto = null;
		 orservice.deleteOrder(userid);
		 String prodNo = req.getParameter("prodNo");
		 String count = req.getParameter("num");
		 String price = req.getParameter("price");
		 String discount = req.getParameter("discount");
		 String point = req.getParameter("point");
		 String delivery = req.getParameter("delivery");
		 String total3 = req.getParameter("total3");
		 String buytype = req.getParameter("buytype");
		 logger.debug("buyOrder");
		 if(buytype != null) {
			 logger.debug("buyOrder buy");
		 dto = new CartDTO();
		 dto.setProdNo(prodNo);
         dto.setUid(userid);
         dto.setCount(count);
         dto.setPrice(price);
         dto.setDiscount(discount);
         dto.setPoint(point);
         dto.setDelivery(delivery);
         dto.setTotal(total3);
         
         orservice.insertOrder(dto);
		 }
		 else {
		    try {
		        // JSON 문자열을 JsonElement로 파싱합니다.
		        JsonElement jsonElement = JsonParser.parseString(jsonData);

		        // JsonElement가 JSON 배열인지 확인합니다.
		        if (jsonElement.isJsonArray()) {
		            // JsonArray로 변환합니다.
		            JsonArray jsonArray = jsonElement.getAsJsonArray();

		            // 배열의 각 원소를 처리합니다.
		            for (JsonElement item : jsonArray) {
		            	dto = new CartDTO();
		            	
		                JsonObject itemObject = item.getAsJsonObject();
		                int listCount = itemObject.get("listCount").getAsInt();
		                int listProdNo = itemObject.get("listProdNo").getAsInt();
		                int listpriceValue = itemObject.get("listpriceValue").getAsInt();
		                int listdelivery = itemObject.get("listdelivery").getAsInt();
		                int listdiscountValue = itemObject.get("listdiscountValue").getAsInt();
		                int listpoint = itemObject.get("listpoint").getAsInt();
		                String listUid = itemObject.get("listUid").getAsString();
		                int totalprice = listpriceValue * listCount;
		                dto.setProdNo(listProdNo);
		                dto.setUid(listUid);
		                dto.setCount(listCount);
		                dto.setPrice(listpriceValue);
		                dto.setDiscount(listdiscountValue);
		                dto.setPoint(listpoint);
		                dto.setDelivery(listdelivery);
		                dto.setTotal(totalprice);
		                
		                orservice.insertOrder(dto);

		            }
		            	
		         
		            
		        } else {
		            resp.sendError(HttpServletResponse.SC_BAD_REQUEST, "Invalid JSON data format: Expected JSON array.");
		        }
		    } catch (Exception e) {
		        e.printStackTrace();
		        resp.sendError(HttpServletResponse.SC_BAD_REQUEST, "Invalid JSON data.");
		    }
		 }
		 
		  resp.sendRedirect("/K-market/product/productorder.do");
	
	}
}
