package kr.co.kmarket.dao;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.co.kmarket.db.DBHelper;
import kr.co.kmarket.db.SQL;
import kr.co.kmarket.dto.OrderDTO;

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
	public void insertOrder(OrderDTO dto) {
		
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
	
	public List<OrderDTO> selectOrders() {
		return null;
	}
	
	public void updateOrder(OrderDTO dto) {
		
	}
	
	public void deleteOrder(String ordNo) {
		
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
				logger.debug("30일이내 등록된 신규 제품 : "+dayOrderToPrice);
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
				logger.debug("30일이내 등록된 신규 제품 : "+weekOrderToPrice);
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
				logger.debug("30일이내 등록된 신규 제품 : "+monthOrderToPrice);
			}
			close();
		} catch (Exception e) {
			logger.error("ProductDAO() - selectProductTotalMonth error : "+e.getMessage());
		}
		return monthOrderToPrice;
	} // END
	
}
