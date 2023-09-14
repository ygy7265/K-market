package kr.co.kmarket.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.co.kmarket.db.DBHelper;
import kr.co.kmarket.db.SQL;
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
	public void insertProduct(ProductDTO dto) {}
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
				dto.setDelivery(rs.getInt(14));
				dto.setHit(rs.getInt(15));
				dto.setScore(rs.getInt(16));
				dto.setReview(rs.getInt(17));
				dto.setThumb1(rs.getString(18));
				dto.setThumb2(rs.getString(19));
				dto.setThumb3(rs.getString(20));
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
				dto.setDelivery(rs.getInt(14));
				dto.setHit(rs.getInt(15));
				dto.setScore(rs.getInt(16));
				dto.setReview(rs.getInt(17));
				dto.setThumb1(rs.getString(18));
				dto.setThumb2(rs.getString(19));
				dto.setThumb3(rs.getString(20));
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
}
