package kr.co.kmarket.controller.cs;

import java.io.IOException;
import java.util.Arrays;
import java.util.Base64;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;

import kr.co.kmarket.dto.QnaDTO;
import kr.co.kmarket.etc.MapUtil;
import kr.co.kmarket.service.QnaService;

@WebServlet("/cs/qna/qnaWrite.do")
public class QnaWriteController extends HttpServlet{
	
	private QnaService service = QnaService.INSTANCE;
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	private static final long serialVersionUID = 1L;
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String cate1 = req.getParameter("cate1");
		String cate2 = req.getParameter("cate2");
		String array = req.getParameter("array");
		logger.debug("array : "+array);
		
		do{
			
			List<QnaDTO> cates = service.selectQnasCate(cate1);
			req.setAttribute("cates", cates);
			

			RequestDispatcher dispatcher = req.getRequestDispatcher("/cs/qna/qnaWrite.jsp");
			dispatcher.forward(req, resp);	
			
		}while (array != null && !array.isEmpty());
			String[] jsondatavalue = array.split(",");
			
		    MapUtil map = new MapUtil();
		    int size = jsondatavalue.length;
		    for(int i=0; i<size; i++) {
		        System.out.println("JSP에서 받은 MSG : "+map.getCateName(jsondatavalue[i]));
		    }

		    JsonArray jsonArray = new JsonArray();
		    for (String value : jsondatavalue) {
		        String cateName = map.getCateName(value);
		        if (cateName != null) {
		            jsonArray.add(new JsonPrimitive(cateName));
		        };
		    };

		    resp.setContentType("application/json;charset=UTF-8");
		    JsonObject json = new JsonObject();
		    json.add("result", jsonArray);

		    // JSON 응답을 클라이언트에게 출력
		    resp.getWriter().print(json);

		    // 반복문을 언제 종료할 것인지 결정하는 로직 추가 필요
		};
		
		
	
	
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
			//[memo 업데이트 필요] 목록에서 본인이 작성한 글 view 로 변경하기 (09/17/23)
			resp.sendRedirect("/K-market/cs/qna/qnaView.do?cate1="+Base64.getEncoder().encodeToString(cate1.getBytes())+"&cate2="+Base64.getEncoder().encodeToString(cate2.getBytes())+"&success=200");
		}else {
			//[memo 업데이트 필요] redirect 1) 로그인 O && 어떠한 오류 발생으로 글 작성 실패시 보고 있던 글 목록 페이지로 이동 (09/19/23)
			resp.sendRedirect("/K-market/member/login.do?success=102");
		}//[memo 업데이트 필요] redirect 2) 로그인 X 로그인 페이지로 이동 (09/19/23) - 로그인 성공 시 보고 있던 페이지로 이동 
		
		
	
	
	}
	
	
	
}
