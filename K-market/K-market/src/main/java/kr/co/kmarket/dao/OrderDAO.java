package kr.co.kmarket.dao;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.co.kmarket.dto.OrderDTO;

public class OrderDAO {
	
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
	
	public List<OrderDTO> selectOrders() {
		return null;
	}
	
	public void updateOrder(OrderDTO dto) {
		
	}
	
	public void deleteOrder(String ordNo) {
		
	}
}
