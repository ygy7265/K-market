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

import com.oreilly.servlet.MultipartRequest;

import kr.co.kmarket.dto.Cate1DTO;
import kr.co.kmarket.dto.Cate2DTO;
import kr.co.kmarket.dto.ProductDTO;
import kr.co.kmarket.service.ProductService;

@WebServlet("/admin/product/register.do")
public class ProductRegisterController extends HttpServlet{
	private static final long serialVersionUID = 1231231L;
	private Logger logger = LoggerFactory.getLogger(getClass());
	private ProductService pService = ProductService.INSTANCE;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		List<Cate1DTO> cate1s = pService.selectCate1s();
		List<Cate2DTO> cate2s = pService.selectCate2s();
		
		logger.debug("cate_list() : " + cate1s);
		logger.debug("cate_list() : " + cate2s);
		
		req.setAttribute("cate1s", cate1s);
		req.setAttribute("cate2s", cate2s);
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/admin/product/register.jsp");
		dispatcher.forward(req, resp);	
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
		String thumb1	= mr.getFilesystemName("thumb1");
		String thumb2	= mr.getFilesystemName("thumb2");
		String thumb3	= mr.getFilesystemName("thumb3");
		String detail	= mr.getFilesystemName("detail");
		String status	= mr.getParameter("status");
		String duty		= mr.getParameter("duty");
		String receipt	= mr.getParameter("receipt");
		String bizType	= mr.getParameter("bizType");
		String origin	= mr.getParameter("origin");
		String seller	= mr.getParameter("seller1");
		String ip		= req.getRemoteAddr();
		
		String path = "/K-market/admin/thumbAll";
		
		logger.debug("cate 1 : "+cate1);
		logger.debug("cate 2 : "+cate2);
		logger.debug("prodName : "+prodName);
		logger.debug("descript : "+descript);
		logger.debug("company : "+company);
		logger.debug("price : "+price);
		logger.debug("discount : "+discount);
		logger.debug("point : "+point);
		logger.debug("stock : "+stock);
		logger.debug("delivery : "+delivery);
		logger.debug("thumb1 : "+thumb1);
		logger.debug("thumb2 : "+thumb2);
		logger.debug("thumb3 : "+thumb3);
		logger.debug("detail : "+detail);
		logger.debug("status : "+status);
		logger.debug("duty : "+duty);
		logger.debug("receipt : "+receipt);
		logger.debug("bizType : "+bizType);
		logger.debug("origin : "+origin);
		
		//파일명 수정
		int i1 = thumb1.lastIndexOf(".");
		int i2 = thumb2.lastIndexOf(".");
		int i3 = thumb3.lastIndexOf(".");
		int i4 = detail.lastIndexOf(".");
		
		String ext1 = thumb1.substring(i1);
		String ext2 = thumb1.substring(i2);
		String ext3 = thumb1.substring(i3);
		String ext4 = thumb1.substring(i4);
		
		String uuid1 = UUID.randomUUID().toString();
		String uuid2 = UUID.randomUUID().toString();
		String uuid3 = UUID.randomUUID().toString();
		String uuid4 = UUID.randomUUID().toString();
		
		String sName1 = uuid1+ext1;
		String sName2 = uuid2+ext2;
		String sName3 = uuid3+ext3;
		String sName4 = uuid4+ext4;
		
		File f1 = new File(path+"/"+thumb1);
		File f2 = new File(path+"/"+thumb2);
		File f3 = new File(path+"/"+thumb3);
		File f4 = new File(path+"/"+detail);
		
		File f21 = new File(path+"/"+sName1);
		File f22 = new File(path+"/"+sName2);
		File f23 = new File(path+"/"+sName3);
		File f24 = new File(path+"/"+sName4);
		
		f1.renameTo(f21);
		f2.renameTo(f22);
		f3.renameTo(f23);
		f4.renameTo(f24);
		
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
		
		logger.debug("dtoToString : " + dto.toString());
		
		pService.insertProduct(dto);
		
		resp.sendRedirect("/K-market/admin/product/register.do");
		
		
	}
}
