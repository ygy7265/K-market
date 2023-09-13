package kr.co.kmarket.dao;

import java.util.List;

import kr.co.kmarket.db.DBHelper;
import kr.co.kmarket.dto.ProductDTO;

public class ProductDAO extends DBHelper {
	
	// 싱글톤
	private static ProductDAO instance = new ProductDAO();
	public static ProductDAO getInstance() {
		return instance;
	}
	private ProductDAO() {}
	
	// 기본 CRUD
	public void insertProduct(ProductDTO dto) {}
	public ProductDTO selectProduct(int prodNo) {
		return null;
	}
	public List<ProductDTO> selectProducts() {
		return null;
	}
	public void updateProduct(ProductDTO dto) {}
	public void deleteProduct(int prodNo) {}
}
