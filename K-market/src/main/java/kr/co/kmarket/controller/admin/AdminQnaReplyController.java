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

import kr.co.kmarket.dto.QnaDTO;
import kr.co.kmarket.service.QnaService;
@WebServlet("/admin/cs/qna/reply.do")
public class AdminQnaReplyController extends HttpServlet{
	private static final long serialVersionUID = 68L;
	private Logger logger = LoggerFactory.getLogger(getClass());
	private QnaService qService = QnaService.INSTANCE;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String qnaNo = req.getParameter("qnaNo");
		logger.debug("faqNo() : " + qnaNo);

		QnaDTO qna = qService.selectQna(qnaNo);
		logger.debug("QnA View : "+qna.toString());
		req.setAttribute("qna", qna);
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/admin/cs/qna/reply.jsp");
		dispatcher.forward(req, resp);	
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String qnaNo = req.getParameter("qnaNo");
		String reply = req.getParameter("reply");

		logger.debug("Comment() : "+qnaNo);
		logger.debug("Comment() : "+reply.toString());
		
		QnaDTO dto = new QnaDTO();
		dto.setReply(reply);
		dto.setQnaNo(qnaNo);
		
		qService.admin_Update_Qna_Comment(dto);
		
		resp.sendRedirect("/K-market/admin/cs/qna/view.do?qnaNo="+qnaNo);
	
	}
	
}
