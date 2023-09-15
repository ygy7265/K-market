package kr.co.kmarket.service;

import java.util.List;

import kr.co.kmarket.dao.CartDAO;
import kr.co.kmarket.dto.CartDTO;

public enum CartService {
	INSTANCE;
	
	private CartDAO dao = CartDAO.getInstance();
	
	
	public void insertCart(CartDTO dto) {
		dao.insertCart(dto);
	}
	
	public CartDTO selectCart(String cartNo) { // 편의를 위해서 int ordNo 가 아닌 String 으로 설정해둠 
		return dao.selectCart(cartNo);
	}
	
	public List<CartDTO> selectCarts() {
		return dao.selectCarts();
	}
	
	public void updateCart(CartDTO dto) {
		dao.updateCart(dto);
	}
	
	public void deleteCart(String cartNo) {
		dao.deleteCart(cartNo);
	}
}
