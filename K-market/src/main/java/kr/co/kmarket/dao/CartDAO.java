package kr.co.kmarket.dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
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
	
	public CartDTO selectCart(String cartNo) { 
		return null;
	}
	public int selectDublicationCart(String prodNo,String count,String uid,String total) {
		conn = getConnection();
		CartDTO dto = null;
		int result = 0;
		try {
			psmt = conn.prepareStatement(SQL.SELECT_DUPLICATION_CART);
			psmt.setString(1, prodNo);
			psmt.setString(2, uid);
			rs = psmt.executeQuery();
			logger.debug("select du = " + rs);
			if(rs.next()) {
				result = 1;
				updateCart(count, prodNo, rs.getString(2),total);
			}
			
			close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return result;
	}
	
	public List<CartDTO> selectCarts(String uid) {
		conn = getConnection();
		CartDTO dto = null;
		List<CartDTO> list = null;
		try {
		
			psmt = conn.prepareStatement(SQL.SELECT_CARTS);
			psmt.setString(1, uid);
			rs = psmt.executeQuery();
			list = new ArrayList<>();
			while(rs.next()) {
				dto = new CartDTO();
				dto.setCartNo(rs.getInt(1));
				dto.setUid(rs.getString(2));
				dto.setProdNo(rs.getInt(3));
				dto.setCount(rs.getInt(4));
				dto.setPrice(rs.getInt(5));
				dto.setDiscount(rs.getInt(6));
				dto.setPoint(rs.getInt(7));
				dto.setDelivery(rs.getInt(8));
				dto.setTotal(rs.getInt(9));
				dto.setRdate(rs.getString(10));
				dto.setpName(rs.getString(11));
				dto.setDescript(rs.getString(12));
				dto.setThumb1(rs.getString(13));
				list.add(dto);
			}
			
			close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	
	public void updateCart(String count,String prodNo,String uid,String total) {
		conn = getConnection();
		
		try {
			psmt = conn.prepareStatement(SQL.UPDATE_CART);
			psmt.setString(1, count);
			psmt.setString(2, total);
			psmt.setString(3, prodNo);
			psmt.setString(4, uid);
			
			logger.debug("updatecart = " + psmt.executeUpdate());
			close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public int deleteCart(String cartNo) {
		int result = 0;
		conn = getConnection();
		try {
			 psmt = conn.prepareStatement(SQL.DELETE_CART);
			 psmt.setString(1, cartNo);
			 result = psmt.executeUpdate();
			 close();
			 
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return result;
	}
	
}
