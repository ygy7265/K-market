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

import kr.co.kmarket.dto.FaqDTO;
import kr.co.kmarket.dto.NoticeDTO;
import kr.co.kmarket.dto.QnaDTO;
import kr.co.kmarket.service.FaqService;
import kr.co.kmarket.service.NoticeService;
import kr.co.kmarket.service.QnaService;
@WebServlet("/admin/cs/qna/view.do")
public class AdminQnaViewController extends HttpServlet{
	private static final long serialVersionUID = 13111768L;
	private Logger logger = LoggerFactory.getLogger(getClass());
	private QnaService qService = QnaService.INSTANCE;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String qnaNo = req.getParameter("qnaNo");
		logger.debug("faqNo() : " + qnaNo);

		QnaDTO qna = qService.selectQna(qnaNo);
		logger.debug("QnA View : "+qna.toString());
		req.setAttribute("qna", qna);
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/admin/cs/qna/view.jsp");
		dispatcher.forward(req, resp);	
	}
}
