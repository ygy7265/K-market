package kr.co.kmarket.controller.cs;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.co.kmarket.dto.QnaDTO;
import kr.co.kmarket.service.QnaService;

@WebServlet("/cs/qna/qnaView.do")
public class QnaViewController extends HttpServlet{
	
	private static final long serialVersionUID = 1L;
	private QnaService service = QnaService.INSTANCE;
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String cate1 = req.getParameter("cate1");
		String cate2 = req.getParameter("cate2");
		String qnaNo = req.getParameter("qnaNo");
		
		logger.debug("QnaViewController ... cate1 : "+ cate1);
		logger.debug("QnaViewController ... cate1 : "+ cate2);
		logger.debug("QnaViewController ... cate1 : "+ qnaNo);
		
		QnaDTO dto = service.selectQna(qnaNo);
		logger.debug("QnaViewController Controller ... dto : "+ dto.toString());
		
		req.setAttribute("cate1", cate1);
		req.setAttribute("cate2", cate2);
		req.setAttribute("qnaNo", qnaNo);
		req.setAttribute("dto", dto);
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/cs/qna/qnaView.jsp");
		dispatcher.forward(req, resp);	
		
	}
	
	
	
	
	
	
	
}
