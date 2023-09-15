package kr.co.kmarket.controller;

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
@WebServlet(value={"","/index.do"})
public class IndexController extends HttpServlet{

	private static final long serialVersionUID = 5783589879373746478L;
	private ProductService service = ProductService.INSTANCE;
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String[] listArray = {"best", "newList", "hitList","scoreList","discountList"};

		// 배열을 JSTL에 전달
		req.setAttribute("listArray", listArray);
		List<ProductDTO> bestList= service.selectBestProducts();
		List<ProductDTO> hitList= service.selectHitProducts();
		List<ProductDTO> discountList= service.selectDiscountProducts();
		List<ProductDTO> scoreList= service.selectScoreProducts();
		List<ProductDTO> newList= service.selectNewProducts();
		String success = req.getParameter("success");
		req.setAttribute("success", success);
		
		req.setAttribute("bestList", bestList);
		req.setAttribute("hitList", hitList);
		req.setAttribute("discountList", discountList);
		req.setAttribute("scoreList", scoreList);
		req.setAttribute("newList", newList);
		logger.debug("bestList = " + bestList.toString());
		RequestDispatcher dispatcher = req.getRequestDispatcher("/index.jsp");
		dispatcher.forward(req, resp);	
	}
}
