package kr.co.kmarket.service;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import kr.co.kmarket.dao.ProductDAO;
import kr.co.kmarket.dto.Cate1DTO;
import kr.co.kmarket.dto.Cate2DTO;
import kr.co.kmarket.dto.ProductDTO;

public enum ProductService {
	
	INSTANCE;
	
	// productDAO
	private ProductDAO dao = ProductDAO.getInstance();
	// Logger
	private Logger logger = LoggerFactory.getLogger(getClass());
	
	// service
	public void insertProduct(ProductDTO dto) {
		dao.insertProduct(dto);
	}
	public ProductDTO selectProduct(String prodNo) {
		return dao.selectProduct(prodNo);
	}
	public List<ProductDTO> selectProducts(String cate1,String cate2, int start) {
		return dao.selectProducts(cate1, cate2, start);
	}
	public List<ProductDTO> selectProductsSearch(String search) {
		return dao.selectProductsSearch(search);
	}
	public List<ProductDTO> selectProductsType(String cate1,String cate2, int start, String type2) {
		return dao.selectProductsType(cate1, cate2, start, type2);
	}
	public void updateProduct(ProductDTO dto) {
		dao.updateProduct(dto);
	}
	public void deleteProduct(String prodNo) {
		dao.deleteProduct(prodNo);
	}
	// admin 추가
	public List<Cate1DTO> selectCate1s() {
		return dao.selectCate1s();
	}
	public List<Cate2DTO> selectCate2s(String cate1) {
		return dao.selectCate2s(cate1);
	}
	public int selectProductCountTotal() {
		return dao.selectProductCountTotal();
	}
	// INDEX, PRODUCT
	public List<ProductDTO> selectBestProducts(int start,int end) {
		return dao.selectBestProducts(start,end);
	}
	public List<ProductDTO> selectHitProducts(int start,int end) {
		return dao.selectHitProducts(start,end);
	}
	public List<ProductDTO> selectScoreProducts(int start,int end) {
		return dao.selectScoreProducts(start,end);
	}
	public List<ProductDTO> selectDiscountProducts(int start,int end) {
		return dao.selectDiscountProducts(start,end);
	}
	public List<ProductDTO> selectNewProducts(int start,int end) {
		return dao.selectNewProducts(start,end);
	}
	public List<ProductDTO> selectProductsTotal(int start) {
		return dao.selectProductsTotal(start);
	}
	public int selectProductCateTotal(String cate1, String cate2) {
		return dao.selectProductCateTotal(cate1, cate2);
	}
	public int selectProductSearchTotal(String search) {
		return dao.selectProductSearchTotal(search);
	}
	
	// admin_indexPage 운영 현황
	public int selectProductTotalDay() {
		return dao.selectProductTotalDay();
	}
	public int selectProductTotalWeek() {
		return dao.selectProductTotalWeek();
	}
	public int selectProductTotalMonth() {
		return dao.selectProductTotalMonth();
	}
	
	// admin_product_file 2023/09/15
	public String getFilePath(HttpServletRequest req) {
		ServletContext ctx = req.getServletContext();
		String path = ctx.getRealPath("/admin/thumbAll");
		return path;
	} // getFilePath END
	
	public String renameToFile(HttpServletRequest req, String oName) {
		String path = getFilePath(req);
		
		int i = oName.lastIndexOf(".");
		String ext = oName.substring(i);
		
		String uuid = UUID.randomUUID().toString();
		String sName = uuid + ext;
		
		File f1 = new File(path+"/"+oName);
		File f2 = new File(path+"/"+sName);
		
		// File명 수정
		f1.renameTo(f2);

		return sName;
	} // renameToFile END
	
	public MultipartRequest uploadFile(HttpServletRequest req) {
		// 파일 경로 구하기
		String path = getFilePath(req);
		// Max Upload File Size
		int maxsize = 1024 * 1024 * 10;
		
		// File Upload
		MultipartRequest mr = null;
		try {
			mr = new MultipartRequest(req, path, maxsize, "UTF-8", new DefaultFileRenamePolicy());
		} catch (IOException e) {
			logger.error("uploadFile error : " + e.getMessage());
		}
		return mr;
	} // uploadFile END
	
	// 페이지 시작번호
	public int getPageStartNum(int total, int currentPage) {
		int start = (currentPage - 1) * 10;
		return total - start;
	}
	public Cate2DTO selectCate(String cate1, String cate2) {
		return dao.selectCate(cate1, cate2);
	}
	
	public void selectUpdateRating(String prodNo) {
		dao.selectUpdateRating(prodNo);
	}
}
