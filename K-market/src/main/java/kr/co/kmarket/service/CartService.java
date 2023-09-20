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
	
	public CartDTO selectCart(String cartNo) {  
		return dao.selectCart(cartNo);
	}
	
	public int selectDuplicationCart(String prodNo,String count,String uid) {  
		return dao.selectDublicationCart(prodNo,count,uid);
	}
	
	public List<CartDTO> selectCarts(String uid) {
		return dao.selectCarts(uid);
	}
	
	public void updateCart(String prodNo,String count,String uid) {
		dao.updateCart(prodNo,count,uid);
	}
	
	public int deleteCart(String cartNo) {
		return dao.deleteCart(cartNo);
	}
}
