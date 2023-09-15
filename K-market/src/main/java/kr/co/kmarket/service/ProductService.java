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
	public ProductDTO selectProduct(int prodNo) {
		return dao.selectProduct(prodNo);
	}
	public List<ProductDTO> selectProducts(String cate1,String cate2) {
		return dao.selectProducts(cate1,cate2);
	}
	public void updateProduct(ProductDTO dto) {
		dao.updateProduct(dto);
	}
	public void deleteProduct(int prodNo) {
		dao.deleteProduct(prodNo);
	}
	// admin 추가
	public List<Cate1DTO> selectCate1s() {
		return dao.selectCate1s();
	}
	public List<Cate2DTO> selectCate2s() {
		return dao.selectCate2s();
	}
	public int selectProductCountTotal() {
		return dao.selectProductCountTotal();
	}
	// INDEX
	public List<ProductDTO> selectBestProducts() {
		return dao.selectBestProducts();
	}
	public List<ProductDTO> selectHitProducts() {
		return dao.selectHitProducts();
	}
	public List<ProductDTO> selectScoreProducts() {
		return dao.selectScoreProducts();
	}
	public List<ProductDTO> selectDiscountProducts() {
		return dao.selectDiscountProducts();
	}
	public List<ProductDTO> selectNewProducts() {
		return dao.selectNewProducts();
	}
	public List<ProductDTO> selectProductsTotal(int start) {
		return dao.selectProductsTotal(start);
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
			logger.error("uploadFile erro : " + e.getMessage());
		}
		return mr;
	} // uploadFile END
}
