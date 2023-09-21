package kr.co.kmarket.service;

import java.util.List;

import kr.co.kmarket.dao.OrderDAO;
import kr.co.kmarket.dto.OrderDTO;

public enum OrderService {
	INSTANCE;
	
	private OrderDAO dao = OrderDAO.getInstance();
	
	
	public void insertOrder(OrderDTO dto) {
		dao.insertOrder(dto);
	}
	
	public OrderDTO selectOrder(String ordNo) { // 편의를 위해서 int ordNo 가 아닌 String 으로 설정해둠 
		return dao.selectOrder(ordNo);
	}
	
	public List<OrderDTO> selectOrders() {
		return dao.selectOrders();
	}
	
	public void updateOrder(OrderDTO dto) {
		dao.updateOrder(dto);
	}
	
	public void deleteOrder(String ordNo) {
		dao.deleteOrder(ordNo);
	}

	// admin_indexPage 운영 현황
	public int selectOrdersCount() {
		return dao.selectOrdersCount();
	}
	public int selectOrdersCountSum() {
		return dao.selectOrdersCountSum();
	}
	
	public int selectOrderTotalDay() {
		return dao.selectOrderTotalDay();
	}
	
	public int selectOrderTotalWeek() {
		return dao.selectOrderTotalWeek();
	}
	
	public int selectOrderTotalMonth() {
		return dao.selectOrderTotalMonth();
	}
	public int selectOrderTotalDayToPrice() {
		return dao.selectOrderTotalDayToPrice();
	}
	public int selectOrderTotalWeekToPrice() {
		return dao.selectOrderTotalWeekToPrice();
	}
	public int selectOrderTotalMonthToPrice() {
		return dao.selectOrderTotalMonthToPrice();
	}

}
