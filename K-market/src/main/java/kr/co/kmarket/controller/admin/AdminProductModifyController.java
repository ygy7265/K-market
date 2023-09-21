package kr.co.kmarket.controller.admin;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

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
import com.oreilly.servlet.MultipartRequest;

import kr.co.kmarket.dto.Cate1DTO;
import kr.co.kmarket.dto.Cate2DTO;
import kr.co.kmarket.dto.ProductDTO;
import kr.co.kmarket.service.FileService;
import kr.co.kmarket.service.ProductService;

@WebServlet("/admin/product/modify.do")
public class AdminProductModifyController extends HttpServlet{
	private static final long serialVersionUID = 123551231L;
	private Logger logger = LoggerFactory.getLogger(getClass());
	private ProductService pService = ProductService.INSTANCE;
	private FileService fService = FileService.INSTANCE;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		

		
		//String prodNo = req.getParameter("prodNo");
		// logger.debug("리스트에서 prodNo 받아오기 "+prodNo);
		//ProductDTO pDTO = pService.selectProduct(prodNo);
		// logger.debug("SelectProduct : "+pDTO.toString());

		String jsondata  = req.getParameter("jsondata");
		if(jsondata == null) {
			String prodNo = req.getParameter("prodNo");
			ProductDTO pDTO = pService.selectProduct(prodNo);

		List<Cate1DTO> cate1s = pService.selectCate1s();

		logger.debug("cate_list() : " + cate1s);
		
		req.setAttribute("cate1s", cate1s);
		req.setAttribute("pDTO", pDTO);
		RequestDispatcher dispatcher = req.getRequestDispatcher("/admin/product/modify.jsp");
		dispatcher.forward(req, resp);
		
		}
		else {
			List<Cate2DTO> cate2s = pService.selectCate2s(jsondata);
			logger.info("json = " + cate2s);
		    System.out.println("json2"+cate2s);
		    JsonArray jsonArray = new JsonArray();
		    for (Cate2DTO cate2 : cate2s) {
		        JsonObject cate2Json = new JsonObject();
		        cate2Json.addProperty("propertyName1", cate2.getC2Name()); // 예: cate2 객체의 속성 이름1
		        cate2Json.addProperty("propertycate1", cate2.getCate2()); // 예: cate2 객체의 속성 이름1
		        jsonArray.add(cate2Json);
		    }
		    resp.setContentType("text/html;charset=UTF-8"); 
		    JsonObject json = new JsonObject();
		    json.add("jsonArray", jsonArray);
		    // JSON 응답을 클라이언트에게 출력
		    resp.getWriter().print(json);
		    

		    
		}

	
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
		
		MultipartRequest mr = pService.uploadFile(req);
		
		// seller는 register.jsp에 임시로 input Hidden 만들어놓음 수정필요
		String cate1	= mr.getParameter("cate1");
		String cate2	= mr.getParameter("cate2");
		String prodName	= mr.getParameter("prodName");
		String descript	= mr.getParameter("descript");
		String company	= mr.getParameter("company");
		String price	= mr.getParameter("price");
		String discount = mr.getParameter("discount");
		String point	= mr.getParameter("point");
		String stock	= mr.getParameter("stock");
		String delivery = mr.getParameter("delivery");
		
		String thumb1	= mr.getOriginalFileName("thumb1");
		String thumb2	= mr.getOriginalFileName("thumb2");
		String thumb3	= mr.getOriginalFileName("thumb3");
		String detail	= mr.getOriginalFileName("detail");
		
		String status	= mr.getParameter("status");
		String duty		= mr.getParameter("duty");
		String receipt	= mr.getParameter("receipt");
		String bizType	= mr.getParameter("bizType");
		String origin	= mr.getParameter("origin");
		String seller	= mr.getParameter("seller1");
		String ip		= req.getRemoteAddr();
		
		String path = "admin/thumbAll";
		
		//파일명 수정
		String sName1= fService.renameToFile(req, thumb1);
		String sName2= fService.renameToFile(req, thumb2);
		String sName3= fService.renameToFile(req, thumb3);
		String sName4= fService.renameToFile(req, detail);
		
		logger.debug("sName1 : " + sName1.toString());
		logger.debug("sName2 : " + sName2.toString());
		logger.debug("sName3 : " + sName3.toString());
		logger.debug("sName4 : " + sName4.toString());
		
		ProductDTO dto = new ProductDTO();
		dto.setCate1(cate1);
		dto.setCate2(cate2);
		dto.setProdName(prodName);
		dto.setDescript(descript);
		dto.setCompany(company);
		dto.setPrice(price);
		dto.setDiscount(discount);
		dto.setPoint(point);
		dto.setStock(stock);
		dto.setDelivery(delivery);
		dto.setThumb1(sName1);
		dto.setThumb2(sName2);
		dto.setThumb3(sName3);
		dto.setDetail(sName4);
		dto.setStatus(status);
		dto.setDuty(duty);
		dto.setReceipt(receipt);
		dto.setBizType(bizType);
		dto.setOrigin(origin);
		dto.setSeller(seller);
		dto.setIp(ip);
		dto.setPath(path);
		
		logger.debug("dtoToString : " + dto.toString());
		
		pService.updateProduct(dto);
		
		resp.sendRedirect("/K-market/admin/product/register.do");
		
		
	}
}
