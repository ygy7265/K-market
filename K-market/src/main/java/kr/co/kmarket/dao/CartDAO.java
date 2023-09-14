package kr.co.kmarket.dao;

import java.sql.SQLException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.co.kmarket.db.DBHelper;
import kr.co.kmarket.db.SQL;
import kr.co.kmarket.dto.CartDTO;
import kr.co.kmarket.dto.OrderDTO;

public class CartDAO extends DBHelper{
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	CartDTO dto = null;
	// 싱글톤
	private static CartDAO instance = new CartDAO();
	
	public static CartDAO getInstance() {
		return instance;
	}
	private CartDAO() {}
	
	// 기본 CRUD
	public void insertCart(CartDTO dto) {
		conn = getConnection();

		try {
		
			psmt = conn.prepareStatement(SQL.INSERT_PRODUCT_CART);
			psmt.setString(1, dto.getUid());
			psmt.setInt(2, dto.getProdNo());
			psmt.setInt(3, dto.getCount());
			psmt.setInt(4, dto.getPrice());
			psmt.setInt(5, dto.getDiscount());
			psmt.setInt(6, dto.getPoint());
			psmt.setInt(7, dto.getDelivery());
			psmt.setInt(8, dto.getTotal());
			
			psmt.executeUpdate();
			
			close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	public CartDTO selectCart(String cartNo) { // 편의를 위해서 int ordNo 가 아닌 String 으로 설정해둠 
		return null;
	}
	
	public List<CartDTO> selectCarts() {
		return null;
	}
	
	public void updateCart(CartDTO dto) {
		
	}
	
	public void deleteCart(String cartNo) {
		
	}
	
}
