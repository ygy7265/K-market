package kr.co.kmarket.controller.cs;
/*
 *  날짜 : 2023/09/18
 *  이름 : 윤경엽, 이현정
 *  내용 : Map으로 전달받은 Cate1/2 내용 출력(챡임자: doGet_이현정/ doPost_윤경엽)
 * 
 * 
 * */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLDecoder;
import java.util.Arrays;
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
import com.google.gson.JsonParser;
import com.google.gson.JsonPrimitive;

import kr.co.kmarket.dto.FaqDTO;
import kr.co.kmarket.etc.MapUtil;
import kr.co.kmarket.service.FaqService;

@WebServlet("/cs/faq/faqList.do")
public class FaqListController extends HttpServlet{
	
	private static final long serialVersionUID = 1L;
	
	private FaqService service = FaqService.INSTANCE;
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String cate1 = req.getParameter("cate1");
		String endParam = req.getParameter("end");
		
		int end = 10;
		
		// end 파라미터 값이 전달된 경우 파싱하여 설정
	    if (endParam != null && !endParam.isEmpty()) {
	        try {
	            end = Integer.parseInt(endParam);
	        } catch (NumberFormatException e) {
	            end = 10; 
	        }
	    } else {
	        end = 10; 
	    }
		
		
		logger.debug("FaqListController cate1 ... " +cate1);
		logger.debug("FaqListController end ... " +end);
		
		List<FaqDTO> cates = service.selectFaqsCate(cate1);
		List<FaqDTO> faqs = service.selectFaqs(cate1, end);
		req.setAttribute("cates", cates);
		req.setAttribute("faqs", faqs);
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/cs/faq/faqList.jsp");
		dispatcher.forward(req, resp);	
	
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String[] jsondatavalue = req.getParameterValues("array");
		MapUtil map = new MapUtil();
		int size = jsondatavalue.length;
//		    for(int i=0; i<size; i++) {
//		        System.out.println("JSP에서 받은 MSG : "+map.getCateName(jsondatavalue[i]));
//		    }
//		    
		    JsonArray jsonArray = new JsonArray();
		    for (String value : jsondatavalue) {
		    	  String cateName = map.getCateName(value);
		    	    if (cateName != null) {
		    	        jsonArray.add(new JsonPrimitive(cateName));
		    	    };
		    	    //System.out.println("json array"+jsonArray);
		    }
		    resp.setContentType("text/html;charset=UTF-8"); 
		    // JSON 객체 생성 및 JSON 배열을 속성 값으로 설정
		    System.out.println("json array 2"+jsonArray);
		    JsonObject json = new JsonObject();
		    json.add("result", jsonArray);
		    // JSON 응답을 클라이언트에게 출력
		    resp.getWriter().print(json);
		    
		
	}
}
