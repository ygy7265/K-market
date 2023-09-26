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
import kr.co.kmarket.dto.ProductDTO;

public class OrderDAO extends DBHelper{
	
	// 싱글톤 생성
	private static OrderDAO instance = new OrderDAO();
	public static OrderDAO getInstance() {
		return instance;
	}
	private OrderDAO() {}
	
	// 로그 설정
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	
	
	// 기본 CRUD
	public void insertOrder(CartDTO dto) {
		conn = getConnection();
		
		try {
			psmt = conn.prepareStatement(SQL.INSERT_PRODUCT_ORDER);
			psmt.setInt(1, dto.getProdNo());
			psmt.setString(2, dto.getUid());
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
	public void updateUserPoint(String uid) {
		
		
	}
	public void updatePoint(int point,String uid) {
		conn = getConnection();
		try {
			psmt = conn.prepareStatement(SQL.UPDATE_MEMBER_POINT);
			psmt.setInt(1, point);
			psmt.setString(2,uid);
			psmt.executeUpdate();
			
			close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}
	public void insertOrderComplite(OrderDTO dto) {
		conn = getConnection();
		
		try { 
			
			psmt = conn.prepareStatement(SQL.INSERT_PRODUCT_ORDER_COMPLITE);
		
			psmt.setString(1, dto.getUid());
			psmt.setInt(2, dto.getOrdCount());
			psmt.setInt(3, dto.getOrdPrice());
			psmt.setInt(4, dto.getOrdDiscount());
			psmt.setInt(5, dto.getOrdDelivery());
			psmt.setInt(6, dto.getSavePoint());
			psmt.setInt(7, dto.getUsedPoint());
			psmt.setInt(8, dto.getOrdTotPrice());
			psmt.setString(9, dto.getRecipName());
			psmt.setString(10, dto.getRecipHp());
			psmt.setString(11, dto.getRecipZip());
			psmt.setString(12, dto.getRecipAddr1());
			psmt.setString(13, dto.getRecipAddr2());
			psmt.setInt(14, dto.getOrdPayment());
			psmt.setInt(15, dto.getOrdComplete());
			psmt.executeUpdate();

			close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public OrderDTO selectOrder(String ordNo) { // 편의를 위해서 int ordNo 가 아닌 String 으로 설정해둠 
		return null;
	}
	
	public int selectOrdersCount() {
		
		int total = 0;
		
		try {
			
			conn = getConnection();
			psmt = conn.prepareStatement(SQL.SELECT_ORDERS_COUNT_TOTAL);
			rs = psmt.executeQuery();
			
			if(rs.next()) {
				total = rs.getInt(1);
			}
			
			logger.debug("총 주문 건수 : " + total);
			close();
			
		} catch (Exception e) {
			// TODO: handle exception
			logger.error("OrderDAO() selectOrdersCount Error = "+e.getMessage());
		}
		
		return total;
	}
	
	public int selectOrdersCountSum() {
		
		int sumtotal = 0;
		
		try {
			
			conn = getConnection();
			psmt = conn.prepareStatement(SQL.SELECT_ORDERS_SUM_TOTAL);
			rs = psmt.executeQuery();
			
			if(rs.next()) {
				sumtotal = rs.getInt(1);
			}
			
			logger.debug("총 주문 금액 : " + sumtotal);
			close();
			
		} catch (Exception e) {
			// TODO: handle exception
			logger.error("OrderDAO() selectOrdersCountSum Error = "+e.getMessage());
		}
		
		return sumtotal;
	}
	
	public List<CartDTO> selectOrdersItem(String uid) {
		conn = getConnection();
		CartDTO dto = null;
		List<CartDTO> list = null;
		try {
		
			psmt = conn.prepareStatement(SQL.SELECT_CARTS_ITEM);
			psmt.setString(1, uid);
			rs = psmt.executeQuery();
			list = new ArrayList<>();
			while(rs.next()) {
				dto = new CartDTO();
				dto.setCartNo(rs.getInt(1));
				dto.setProdNo(rs.getInt(2));
				dto.setUid(rs.getString(3));
				dto.setCount(rs.getInt(4));
				dto.setPrice(rs.getInt(5));
				dto.setDiscount(rs.getInt(6));
				dto.setPoint(rs.getInt(7));
				dto.setDelivery(rs.getInt(8));
				dto.setTotal(rs.getInt(9));
				dto.setpName(rs.getString(10));
				dto.setDescript(rs.getString(11));
				dto.setThumb1(rs.getString(12));
				list.add(dto);
			}
			
			close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	public OrderDTO selectOrdersComplete(String uid) {
		conn = getConnection();
		OrderDTO dto = null;
		
		try {
			
			psmt = conn.prepareStatement(SQL.SELECT_CARTS_ORDER_COMPLITE);
			psmt.setString(1, uid);
			rs = psmt.executeQuery();
			dto = new OrderDTO();
			if(rs.next()) {
				dto.setOrdNo(rs.getInt(1));
				dto.setUid(rs.getString(2));
				dto.setOrdCount(rs.getInt(3));
				dto.setOrdPrice(rs.getInt(4));
				dto.setOrdDelivery(rs.getInt(5));
				dto.setOrdDiscount(rs.getInt(6));
				dto.setSavePoint(rs.getInt(7));
				dto.setUsedPoint(rs.getInt(8));
				dto.setOrdTotPrice(rs.getInt(9));
				dto.setRecipName(rs.getString(10));
				dto.setRecipHp(rs.getString(11));
				dto.setRecipZip(rs.getString(12));
				dto.setRecipAddr1(rs.getString(13));
				dto.setRecipAddr2(rs.getString(14));
				dto.setOrdPayment(rs.getInt(15));
				dto.setOrdComplete(rs.getInt(15));
				dto.setOrdDate(rs.getString(17));
			}
			
			close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return dto;
	}
	
	public void updateOrder(OrderDTO dto) {
		
	}
	
	public void deleteOrder(String uid) {
		conn = getConnection();
		try {
			psmt = conn.prepareStatement(SQL.DELETE_ORDER);
			psmt.setString(1, uid);
			psmt.executeUpdate();
			
			close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	// admin_indexPage 1일, 7일 30일 (신규오더)
	public int selectOrderTotalDay() {
		int dayOrder = 0;
		try {
			conn = getConnection();
			psmt = conn.prepareStatement(SQL.SELECT_ORDERS_TOTAL_DAY);
			rs = psmt.executeQuery();
			if(rs.next()) {
				dayOrder = rs.getInt(1);
				logger.debug("24이내 등록된 신규 제품 : "+dayOrder);
			}
			close();
		} catch (Exception e) {
			logger.error("ProductDAO() - selectProductTotalDay error : "+e.getMessage());
		}
		return dayOrder;
	}
	
	public int selectOrderTotalWeek() {
		int weekOrder = 0;
		try {
			conn = getConnection();
			psmt = conn.prepareStatement(SQL.SELECT_ORDERS_TOTAL_WEEK);
			rs = psmt.executeQuery();
			if(rs.next()) {
				weekOrder = rs.getInt(1);
				//logger.debug("7일이내 등록된 신규 제품 : "+weekProd);
			}
			close();
		} catch (Exception e) {
			logger.error("ProductDAO() - selectProductTotalWeek error : "+e.getMessage());
		}
		return weekOrder;
	}
	
	public int selectOrderTotalMonth() {
		int monthOrder = 0;
		try {
			conn = getConnection();
			psmt = conn.prepareStatement(SQL.SELECT_ORDERS_TOTAL_MONTH);
			rs = psmt.executeQuery();
			if(rs.next()) {
				monthOrder = rs.getInt(1);
			logger.debug("30일이내 등록된 신규 제품 : "+monthOrder);
			}
			close();
		} catch (Exception e) {
			logger.error("ProductDAO() - selectProductTotalMonth error : "+e.getMessage());
		}
		return monthOrder;
	}

	// 일간 총 주문 금액
	public int selectOrderTotalDayToPrice() {
		int dayOrderToPrice = 0;
		try {
			conn = getConnection();
			psmt = conn.prepareStatement(SQL.SELECT_ORDERS_TOTAL_DAY_TO_PRICE);
			rs = psmt.executeQuery();
			if(rs.next()) {
				dayOrderToPrice = rs.getInt(1);
				logger.debug("1일이내 신규 주문 : "+dayOrderToPrice);
			}
			close();
		} catch (Exception e) {
			logger.error("ProductDAO() - selectProductTotalMonth error : "+e.getMessage());
		}
		return dayOrderToPrice;
	} // END
	
	// 주간 총 주문 금액
	public int selectOrderTotalWeekToPrice() {
		int weekOrderToPrice = 0;
		try {
			conn = getConnection();
			psmt = conn.prepareStatement(SQL.SELECT_ORDERS_TOTAL_WEEK_TO_PRICE);
			rs = psmt.executeQuery();
			if(rs.next()) {
				weekOrderToPrice = rs.getInt(1);
				logger.debug("7일이내 신규 주문 : "+weekOrderToPrice);
			}
			close();
		} catch (Exception e) {
			logger.error("ProductDAO() - selectProductTotalMonth error : "+e.getMessage());
		}
		return weekOrderToPrice;
	} // END
	
	// 월간 총 주문 금액
	public int selectOrderTotalMonthToPrice() {
		int monthOrderToPrice = 0;
		try {
			conn = getConnection();
			psmt = conn.prepareStatement(SQL.SELECT_ORDERS_TOTAL_MONTH_TO_PRICE);
			rs = psmt.executeQuery();
			if(rs.next()) {
				monthOrderToPrice = rs.getInt(1);
				logger.debug("30일이내 신규 주문 : "+monthOrderToPrice);
			}
			close();
		} catch (Exception e) {
			logger.error("ProductDAO() - selectProductTotalMonth error : "+e.getMessage());
		}
		return monthOrderToPrice;
	} // END
	
}
