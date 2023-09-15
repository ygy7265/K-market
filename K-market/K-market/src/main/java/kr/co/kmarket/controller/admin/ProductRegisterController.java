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

import kr.co.kmarket.dto.Cate1DTO;
import kr.co.kmarket.dto.Cate2DTO;
import kr.co.kmarket.service.ProductService;

@WebServlet("/admin/product/register.do")
public class ProductRegisterController extends HttpServlet{
	private static final long serialVersionUID = 1231231L;
	private Logger logger = LoggerFactory.getLogger(getClass());
	private ProductService pService = ProductService.INSTANCE;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		List<Cate1DTO> cate1s = pService.selectCate1s();
		List<Cate2DTO> cate2s = pService.selectCate2s();
		
		logger.debug("cate_list() : " + cate1s);
		logger.debug("cate_list() : " + cate2s);
		
		req.setAttribute("cate1s", cate1s);
		req.setAttribute("cate2s", cate2s);
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/admin/product/register.jsp");
		dispatcher.forward(req, resp);	
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String cate1 = req.getParameter("cate1");
		String cate2 = req.getParameter("cate2");
		String prodName = req.getParameter("prodName");
		String descript = req.getParameter("descript");
		String company = req.getParameter("company");
		String price = req.getParameter("price");
		String discount = req.getParameter("discount");
		String point = req.getParameter("point");
		String stock = req.getParameter("stock");
		String delivery = req.getParameter("delivery");
		String thumb1 = req.getParameter("thumb1");
		String thumb2 = req.getParameter("thumb2");
		String thumb3 = req.getParameter("thumb3");
		String detail = req.getParameter("detail");
		String status = req.getParameter("status");
		String duty = req.getParameter("duty");
		String receipt = req.getParameter("receipt");
		String bizType = req.getParameter("bizType");
		String origin = req.getParameter("origin");
		
		
		
	}
}
