package kr.co.kmarket.controller.admin;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@WebServlet("/admin/product/productregister.do")
public class ProductRegisterController extends HttpServlet{
	private static final long serialVersionUID = 1231231L;
	private Logger logger = LoggerFactory.getLogger(getClass());
	

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		
		
		logger.debug("cate_list() : ");
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/admin/product/register.jsp");
		dispatcher.forward(req, resp);	
	}
}
