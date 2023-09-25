package kr.co.kmarket.controller.cs;

import java.io.IOException;
import java.util.Base64;

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

@WebServlet("/cs/qna/qnaModify.do")
public class QnaModifyController extends HttpServlet{
	
	private static final long serialVersionUID = 1L;
	private QnaService service = QnaService.INSTANCE;
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String cate1 = req.getParameter("cate1");
		String cate2 = req.getParameter("cate2");
		String qnaNo = req.getParameter("qnaNo");
		
		logger.debug("QnaModifyController ... cate1 : "+ cate1);
		logger.debug("QnaModifyController ... cate2 : "+ cate2);
		logger.debug("QnaModifyController ... qnaNo : "+ qnaNo);
		
		QnaDTO dto = service.selectQna(qnaNo);
		logger.debug("QnaModifysController Controller ... dto : "+ dto.toString());
		
		req.setAttribute("cate1", cate1);
		req.setAttribute("cate2", cate2);
		req.setAttribute("qnaNo", qnaNo);
		req.setAttribute("dto", dto);
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/cs/qna/qnaModify.jsp");
		dispatcher.forward(req, resp);	
		
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String cate1 = req.getParameter("cate1");
		String cate2 = req.getParameter("cate2");
		String qnaNo = req.getParameter("qnaNo");
		String content = req.getParameter("content");
		
		QnaDTO dto = new QnaDTO();
		dto.setCate1(cate1);
		dto.setCate2(cate2);
		dto.setQnaNo(qnaNo);
		dto.setContent(content);
		
		logger.debug("QnAModify cate1..."+cate1);
		logger.debug("QnAModify cate2..."+cate2);
		logger.debug("QnAModify qnaNo..."+qnaNo);
		logger.debug("QnAModify content..."+content);
		
		service.updateQna(dto);
		logger.debug("QnAModify dto..."+dto.toString());
		resp.sendRedirect("/K-market/cs/qna/qnaView.do?cate1="+cate1+"&cate2="+Base64.getEncoder().encodeToString(cate2.getBytes())+"&qnaNo="+qnaNo);
		
		
	}
	
	
	
	
	
	
	
}
