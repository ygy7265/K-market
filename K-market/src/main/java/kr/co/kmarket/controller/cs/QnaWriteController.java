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

import com.mysql.cj.Session;

import kr.co.kmarket.dto.QnaDTO;
import kr.co.kmarket.service.QnaService;

@WebServlet("/cs/qna/qnaWrite.do")
public class QnaWriteController extends HttpServlet{
	
	private QnaService service = QnaService.INSTANCE;
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	private static final long serialVersionUID = 1L;
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RequestDispatcher dispatcher = req.getRequestDispatcher("/cs/qna/qnaWrite.jsp");
		dispatcher.forward(req, resp);	
	}
	
	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		// 폼 데이터 수신
		String title = req.getParameter("title");
		String cate1 = req.getParameter("cate1");
		String cate2 = req.getParameter("cate2");
		String content = req.getParameter("content");
		String writer = req.getParameter("writer");
		String ip = req.getRemoteAddr();
		
		logger.debug("QnaWrite title : "+title);
		logger.debug("QnaWrite cate1 : "+cate1);
		logger.debug("QnaWrite cate2 : "+cate2);
		logger.debug("QnaWrite content : "+content);
		logger.debug("QnaWrite writer : "+writer);
		logger.debug("QnaWrite ip : "+ip);
		
		QnaDTO dto = new QnaDTO();
		dto.setCate1(cate1);
		dto.setCate2(cate2);
		dto.setContent(content);
		dto.setTitle(title);
		dto.setIp(ip);
		dto.setWriter(writer);
		
		logger.debug("QnaWrite dto : "+dto.toString());
		
		
		int result = service.insertQna(dto);
		
		
		if(result > 0) {
			//[memo(09/17/23)] 목록에서 본인이 작성한 글 view 로 변경하기 
			resp.sendRedirect("/K-market/cs/qna/qnaList.do?cate1=10&success=200");
		}else {
			resp.sendRedirect("/K-market/cs/qna/qnaList.do?success=102");
		}
		
		
	
	
	}
	
	
	
}
