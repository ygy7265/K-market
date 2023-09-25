package kr.co.kmarket.controller.product;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.co.kmarket.dto.MemberDTO;
import kr.co.kmarket.dto.ProductDTO;
import kr.co.kmarket.service.ProductService;

@WebServlet("/product/productview.do")
public class ProductViewController extends HttpServlet{
	
	private static final long serialVersionUID = -7749251008944886791L;
	ProductService service = ProductService.INSTANCE;
	private Logger logger = LoggerFactory.getLogger(this.getClass());
		@Override
		protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			
			HttpSession session = req.getSession();
			MemberDTO memberdto = (MemberDTO) session.getAttribute("user");
			
			
			String prodNo = req.getParameter("prodNo");
			req.setAttribute("memberdto", memberdto);
			
			int parseNo = Integer.parseInt(prodNo);
			ProductDTO dto = service.selectProduct(prodNo);
			req.setAttribute("proddto", dto);
			logger.debug("Product View = " + dto);
			
			Date currentDate = new Date();

			// 3일을 더한 날짜 계산
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(currentDate);
			calendar.add(Calendar.DAY_OF_MONTH, 3);
			Date threeDaysLater = calendar.getTime();

			// 요일 계산 (예: 월요일)
			SimpleDateFormat dayFormat = new SimpleDateFormat("EEE");
			String dayOfWeek = dayFormat.format(threeDaysLater);

			req.setAttribute("currentDate", currentDate);
			req.setAttribute("threeDaysLater", threeDaysLater);
			req.setAttribute("dayOfWeek", dayOfWeek);
			RequestDispatcher dispatcher = req.getRequestDispatcher("/product/productView.jsp");
			dispatcher.forward(req, resp);	
		}
}
