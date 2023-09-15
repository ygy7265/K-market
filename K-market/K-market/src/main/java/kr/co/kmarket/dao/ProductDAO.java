package kr.co.kmarket.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.jsp.tagext.TryCatchFinally;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.co.kmarket.db.DBHelper;
import kr.co.kmarket.db.SQL;
import kr.co.kmarket.dto.Cate1DTO;
import kr.co.kmarket.dto.Cate2DTO;
import kr.co.kmarket.dto.ProductDTO;

public class ProductDAO extends DBHelper {
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	// 싱글톤
	private static ProductDAO instance = new ProductDAO();
	
	public static ProductDAO getInstance() {
		return instance;
	}
	private ProductDAO() {}
	
	// 기본 CRUD
	public void insertProduct(ProductDTO dto) {
		
		try {
			
			conn = getConnection();
			psmt = conn.prepareStatement(SQL.INSERT_PRODUCT);
			psmt.setInt(1, dto.getCate1());
			psmt.setInt(2, dto.getCate2());
			psmt.setString(3, dto.getProdName());
			psmt.setString(4, dto.getDescript());
			psmt.setString(5, dto.getCompany());
			psmt.setInt(6, dto.getPrice());
			psmt.setString(1, null);
			psmt.setString(1, null);
			psmt.setString(1, null);
			psmt.setString(1, null);
			psmt.setString(1, null);
			psmt.setString(1, null);
			psmt.setString(1, null);
			psmt.setString(1, null);
			psmt.setString(1, null);
			psmt.setString(1, null);
			psmt.setString(1, null);
			psmt.setString(1, null);
			psmt.setString(1, null);
			psmt.setString(1, null);
			psmt.setString(1, null);
			psmt.setString(1, null);
			psmt.setString(1, null);
			
			close();
			
		} catch (Exception e) {
			logger.error("insertProduct Error = "+e.getMessage());
		}
		
	} //insertProduct END
	public ProductDTO selectProduct(int prodNo) {
		ProductDTO dto = null;
		conn = getConnection();
		try {
			psmt = conn.prepareStatement(SQL.SELECT_PRODUCT);
			psmt.setInt(1, prodNo);
			rs = psmt.executeQuery();
			
			while(rs.next()) {
				dto = new ProductDTO();
				dto.setProdNo(rs.getInt(1));
				dto.setCate1(rs.getInt(2));
				dto.setCate2(rs.getInt(3));
				dto.setProdName(rs.getString(4));
				dto.setDescript(rs.getString(5));
				dto.setCompany(rs.getString(6));
				dto.setSeller(rs.getString(7));
				dto.setPrice(rs.getInt(8));
				dto.setDiscount(rs.getInt(9));
				dto.setPoint(rs.getInt(10));
				dto.setStock(rs.getInt(11));
				dto.setSold(rs.getInt(12));
				dto.setDelivery(rs.getInt(13));
				dto.setHit(rs.getInt(14));
				dto.setScore(rs.getInt(15));
				dto.setReview(rs.getInt(16));
				dto.setThumb1(rs.getString(17));
				dto.setThumb2(rs.getString(18));
				dto.setThumb3(rs.getString(19));
				dto.setDetail(rs.getString(20));
				dto.setStatus(rs.getString(21));
				dto.setDuty(rs.getString(22));
				dto.setReceipt(rs.getString(23));
				dto.setBizType(rs.getString(24));
				dto.setOrigin(rs.getString(25));
				dto.setIp(rs.getString(26));
				dto.setRdate(rs.getString(27));
			}
			
			logger.debug(dto.toString());
			close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			logger.error("Product View Error = "+e.getMessage());
		}
		return dto;
	}
	
	public List<ProductDTO> selectProducts(String cate1,String cate2) {
		List<ProductDTO> list = new ArrayList<>();
		conn = getConnection();
		try {
			psmt = conn.prepareStatement(SQL.SELECT_PRODUCTS);
			psmt.setString(1, cate1);
			psmt.setString(2, cate2);
			rs = psmt.executeQuery();
			
			while(rs.next()) {
				ProductDTO dto = new ProductDTO();
				dto.setProdNo(rs.getInt(1));
				dto.setCate1(rs.getInt(2));
				dto.setCate2(rs.getInt(3));
				dto.setProdName(rs.getString(4));
				dto.setDescript(rs.getString(5));
				dto.setCompany(rs.getString(6));
				dto.setSeller(rs.getString(7));
				dto.setPrice(rs.getInt(8));
				dto.setDiscount(rs.getInt(9));
				dto.setPoint(rs.getInt(10));
				dto.setStock(rs.getInt(11));
				dto.setSold(rs.getInt(12));
				dto.setDelivery(rs.getInt(13));
				dto.setHit(rs.getInt(14));
				dto.setScore(rs.getInt(15));
				dto.setReview(rs.getInt(16));
				dto.setThumb1(rs.getString(17));
				dto.setThumb2(rs.getString(18));
				dto.setThumb3(rs.getString(19));
				dto.setDetail(rs.getString(20));
				dto.setStatus(rs.getString(21));
				dto.setDuty(rs.getString(22));
				dto.setReceipt(rs.getString(23));
				dto.setBizType(rs.getString(24));
				dto.setOrigin(rs.getString(25));
				dto.setIp(rs.getString(26));
				dto.setRdate(rs.getString(27));
				
				list.add(dto);	
			}
			
			logger.debug(list.toString());
			close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			logger.error("Product List Error = "+e.getMessage());
		}
		return list;
	}
	public void updateProduct(ProductDTO dto) {}
	public void deleteProduct(int prodNo) {}
	
	// admin_Product_Register
	
	public List<Cate1DTO> selectCate1s() {
		
		List<Cate1DTO> cate1s = new ArrayList<>();
		
		try {
			
			conn = getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(SQL.SELECT_CATE1S);
			
			while(rs.next()) {
				Cate1DTO dto = new Cate1DTO();
				dto.setCate1(rs.getInt(1));
				dto.setC1Name(rs.getString(2));
				cate1s.add(dto);
			}
			close();
		} catch (Exception e) {
			logger.error("admin Cate1 List Error = "+e.getMessage());
		}
		return cate1s;
	} // selectCate1s() END
	
	public List<Cate2DTO> selectCate2s() {
		List<Cate2DTO> cate2s = new ArrayList<>();

		try {
		
			conn = getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(SQL.SELECT_CATE2S);
			
			while(rs.next()) {
				Cate2DTO dto = new Cate2DTO();
				dto.setCate1(rs.getInt(1));
				dto.setCate2(rs.getInt(2));
				dto.setC2Name(rs.getString(3));
				cate2s.add(dto);
			}
			close();
		} catch (Exception e) {
			logger.error("admin Cate2 List Error = "+e.getMessage());
		}
		return cate2s;
	} // selectCate2s() END
	
	//INDEX SELECT
		//BEST
	public List<ProductDTO> selectBestProducts() {
		List<ProductDTO> list = new ArrayList<>();
		conn = getConnection();
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(SQL.SELECT_BEST_PRODUCT);
			
			while(rs.next()) {
				ProductDTO dto = new ProductDTO();
				dto.setProdNo(rs.getInt(1));
				dto.setCate1(rs.getInt(2));
				dto.setCate2(rs.getInt(3));
				dto.setProdName(rs.getString(4));
				dto.setDescript(rs.getString(5));
				dto.setCompany(rs.getString(6));
				dto.setSeller(rs.getString(7));
				dto.setPrice(rs.getInt(8));
				dto.setDiscount(rs.getInt(9));
				dto.setPoint(rs.getInt(10));
				dto.setStock(rs.getInt(11));
				dto.setSold(rs.getInt(12));
				dto.setDelivery(rs.getInt(13));
				dto.setHit(rs.getInt(14));
				dto.setScore(rs.getInt(15));
				dto.setReview(rs.getInt(16));
				dto.setThumb1(rs.getString(17));
				dto.setThumb2(rs.getString(18));
				dto.setThumb3(rs.getString(19));
				dto.setDetail(rs.getString(20));
				dto.setStatus(rs.getString(21));
				dto.setDuty(rs.getString(22));
				dto.setReceipt(rs.getString(23));
				dto.setBizType(rs.getString(24));
				dto.setOrigin(rs.getString(25));
				dto.setIp(rs.getString(26));
				dto.setRdate(rs.getString(27));
				
				list.add(dto);	
			}
			
			logger.debug("bestdao = " + list.toString());
			close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			logger.error("Product List Error = "+e.getMessage());
		}
		return list;
	}
	//Discount
	public List<ProductDTO> selectDiscountProducts() {
		List<ProductDTO> list = new ArrayList<>();
		conn = getConnection();
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(SQL.SELECT_DISCOUNT_PRODUCT);
			
			while(rs.next()) {
				ProductDTO dto = new ProductDTO();
				dto.setProdNo(rs.getInt(1));
				dto.setCate1(rs.getInt(2));
				dto.setCate2(rs.getInt(3));
				dto.setProdName(rs.getString(4));
				dto.setDescript(rs.getString(5));
				dto.setCompany(rs.getString(6));
				dto.setSeller(rs.getString(7));
				dto.setPrice(rs.getInt(8));
				dto.setDiscount(rs.getInt(9));
				dto.setPoint(rs.getInt(10));
				dto.setStock(rs.getInt(11));
				dto.setSold(rs.getInt(12));
				dto.setDelivery(rs.getInt(13));
				dto.setHit(rs.getInt(14));
				dto.setScore(rs.getInt(15));
				dto.setReview(rs.getInt(16));
				dto.setThumb1(rs.getString(17));
				dto.setThumb2(rs.getString(18));
				dto.setThumb3(rs.getString(19));
				dto.setDetail(rs.getString(20));
				dto.setStatus(rs.getString(21));
				dto.setDuty(rs.getString(22));
				dto.setReceipt(rs.getString(23));
				dto.setBizType(rs.getString(24));
				dto.setOrigin(rs.getString(25));
				dto.setIp(rs.getString(26));
				dto.setRdate(rs.getString(27));
				
				list.add(dto);	
			}
			
			logger.debug(list.toString());
			close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			logger.error("Product List Error = "+e.getMessage());
		}
		return list;
	}
	//Hit
	public List<ProductDTO> selectHitProducts() {
		List<ProductDTO> list = new ArrayList<>();
		conn = getConnection();
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(SQL.SELECT_HIT_PRODUCT);
			
			while(rs.next()) {
				ProductDTO dto = new ProductDTO();
				dto.setProdNo(rs.getInt(1));
				dto.setCate1(rs.getInt(2));
				dto.setCate2(rs.getInt(3));
				dto.setProdName(rs.getString(4));
				dto.setDescript(rs.getString(5));
				dto.setCompany(rs.getString(6));
				dto.setSeller(rs.getString(7));
				dto.setPrice(rs.getInt(8));
				dto.setDiscount(rs.getInt(9));
				dto.setPoint(rs.getInt(10));
				dto.setStock(rs.getInt(11));
				dto.setSold(rs.getInt(12));
				dto.setDelivery(rs.getInt(13));
				dto.setHit(rs.getInt(14));
				dto.setScore(rs.getInt(15));
				dto.setReview(rs.getInt(16));
				dto.setThumb1(rs.getString(17));
				dto.setThumb2(rs.getString(18));
				dto.setThumb3(rs.getString(19));
				dto.setDetail(rs.getString(20));
				dto.setStatus(rs.getString(21));
				dto.setDuty(rs.getString(22));
				dto.setReceipt(rs.getString(23));
				dto.setBizType(rs.getString(24));
				dto.setOrigin(rs.getString(25));
				dto.setIp(rs.getString(26));
				dto.setRdate(rs.getString(27));
				
				list.add(dto);	
			}
			
			logger.debug(list.toString());
			close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			logger.error("Product List Error = "+e.getMessage());
		}
		return list;
	}
	//socore
	public List<ProductDTO> selectScoreProducts() {
		List<ProductDTO> list = new ArrayList<>();
		conn = getConnection();
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(SQL.SELECT_SCORE_PRODUCT);
			
			while(rs.next()) {
				ProductDTO dto = new ProductDTO();
				dto.setProdNo(rs.getInt(1));
				dto.setCate1(rs.getInt(2));
				dto.setCate2(rs.getInt(3));
				dto.setProdName(rs.getString(4));
				dto.setDescript(rs.getString(5));
				dto.setCompany(rs.getString(6));
				dto.setSeller(rs.getString(7));
				dto.setPrice(rs.getInt(8));
				dto.setDiscount(rs.getInt(9));
				dto.setPoint(rs.getInt(10));
				dto.setStock(rs.getInt(11));
				dto.setSold(rs.getInt(12));
				dto.setDelivery(rs.getInt(13));
				dto.setHit(rs.getInt(14));
				dto.setScore(rs.getInt(15));
				dto.setReview(rs.getInt(16));
				dto.setThumb1(rs.getString(17));
				dto.setThumb2(rs.getString(18));
				dto.setThumb3(rs.getString(19));
				dto.setDetail(rs.getString(20));
				dto.setStatus(rs.getString(21));
				dto.setDuty(rs.getString(22));
				dto.setReceipt(rs.getString(23));
				dto.setBizType(rs.getString(24));
				dto.setOrigin(rs.getString(25));
				dto.setIp(rs.getString(26));
				dto.setRdate(rs.getString(27));
				
				list.add(dto);	
			}
			
			logger.debug(list.toString());
			close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			logger.error("Product List Error = "+e.getMessage());
		}
		return list;
	}
	//New
	public List<ProductDTO> selectNewProducts() {
		List<ProductDTO> list = new ArrayList<>();
		conn = getConnection();
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(SQL.SELECT_NEW_PRODUCT);
			
			while(rs.next()) {
				ProductDTO dto = new ProductDTO();
				dto.setProdNo(rs.getInt(1));
				dto.setCate1(rs.getInt(2));
				dto.setCate2(rs.getInt(3));
				dto.setProdName(rs.getString(4));
				dto.setDescript(rs.getString(5));
				dto.setCompany(rs.getString(6));
				dto.setSeller(rs.getString(7));
				dto.setPrice(rs.getInt(8));
				dto.setDiscount(rs.getInt(9));
				dto.setPoint(rs.getInt(10));
				dto.setStock(rs.getInt(11));
				dto.setSold(rs.getInt(12));
				dto.setDelivery(rs.getInt(13));
				dto.setHit(rs.getInt(14));
				dto.setScore(rs.getInt(15));
				dto.setReview(rs.getInt(16));
				dto.setThumb1(rs.getString(17));
				dto.setThumb2(rs.getString(18));
				dto.setThumb3(rs.getString(19));
				dto.setDetail(rs.getString(20));
				dto.setStatus(rs.getString(21));
				dto.setDuty(rs.getString(22));
				dto.setReceipt(rs.getString(23));
				dto.setBizType(rs.getString(24));
				dto.setOrigin(rs.getString(25));
				dto.setIp(rs.getString(26));
				dto.setRdate(rs.getString(27));
				
				list.add(dto);	
			}
			
			logger.debug(list.toString());
			close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			logger.error("Product List Error = "+e.getMessage());
		}
		return list;
	}
	
}
