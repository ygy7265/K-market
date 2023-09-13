package kr.co.kmarket.service;

import java.util.List;

import kr.co.kmarket.dao.OrderDAO;

public enum OrderService {
	INSTANCE;
	
	private OrderDAO dao = OrderDAO.getInstance();
	
	
	public void insertOrder(OrderDAO dto) {
		dao.insertOrder(dto);
	}
	
	public OrderDAO selectOrder(String ordNo) { // 편의를 위해서 int ordNo 가 아닌 String 으로 설정해둠 
		return dao.selectOrder(ordNo);
	}
	
	public List<OrderDAO> selectOrders() {
		return dao.selectOrders();
	}
	
	public void updateOrder(OrderDAO dto) {
		dao.updateOrder(dto);
	}
	
	public void deleteOrder(String ordNo) {
		dao.deleteOrder(ordNo);
	}
}
