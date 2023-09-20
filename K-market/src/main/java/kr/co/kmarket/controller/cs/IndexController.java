package kr.co.kmarket.controller.cs;

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

import kr.co.kmarket.dto.NoticeDTO;
import kr.co.kmarket.dto.QnaDTO;
import kr.co.kmarket.service.NoticeService;
import kr.co.kmarket.service.QnaService;

@WebServlet("/cs/index.do")
public class IndexController extends HttpServlet{
	private static final long serialVersionUID = 1L;
	private NoticeService nService = NoticeService.INSTANCE;
	private QnaService qService = QnaService.INSTANCE;
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		List<NoticeDTO> latests1 = nService.selectLatests(5);
		List<QnaDTO> latests2 = qService.selectLatests(5);
		
		req.setAttribute("latests1", latests1);
		req.setAttribute("latests2", latests2);
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/cs/index.jsp");
		dispatcher.forward(req, resp);	
		
		
		
		
		
	}
}
