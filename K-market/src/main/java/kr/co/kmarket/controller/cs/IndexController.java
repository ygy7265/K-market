package kr.co.kmarket.controller.cs;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
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
import kr.co.kmarket.etc.MapUtil;
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

		    List<String> latestsList = new ArrayList<>();
		    logger.debug("latests = " + latests1.toString());
		    for (NoticeDTO latestnotice : latests1) {
		        String catename = MapUtil.getCateName(latestnotice.getCate());
		        latestnotice.setCatename(catename); // NoticeDTO 객체에 catename 설정
		        latestsList.add(catename);
		    }
		    
		    List<String> latestsList2 = new ArrayList<>();
		    logger.debug("latests2 = " + latests2.toString());
		    
		    for (QnaDTO latestQna : latests2) {
		        String catename = MapUtil.getCateName(latestQna.getCate1());
		        latestQna.setCatename(catename); // QnaDTO 객체에 catename 설정
		        latestsList2.add(catename);
		        String cate1Value = latestQna.getCate1();
		        System.out.println("cate1Value = " + cate1Value);
		        
		        System.out.println("catename = "+ catename);
	            System.out.println("latestsList2 = "+ latestsList2);
		    }
		    

		    req.setAttribute("latests1", latests1);
		    req.setAttribute("latests2", latests2);

		    RequestDispatcher dispatcher = req.getRequestDispatcher("/cs/index.jsp");
		    dispatcher.forward(req, resp);
	}
} 
