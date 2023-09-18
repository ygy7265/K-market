package kr.co.kmarket.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.co.kmarket.db.DBHelper;
import kr.co.kmarket.db.SQL;
import kr.co.kmarket.dto.CartDTO;
import kr.co.kmarket.dto.OrderDTO;
import kr.co.kmarket.dto.ReviewDTO;

public class ReviewDAO extends DBHelper{
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	ReviewDTO dto = null;
	// 싱글톤
	private static ReviewDAO instance = new ReviewDAO();
	
	public static ReviewDAO getInstance() {
		return instance;
	}
	private ReviewDAO() {}
	
	// 기본 CRUD
	public void insertReview(ReviewDTO dto) {

		try {
			conn = getConnection();
			
			psmt.executeUpdate();
			
			close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			logger.error("ReviewDAO insertReview error : "+e.getMessage());
		}
		
		
	}
	
	public ReviewDTO selectReview(int revNo) {
		return null;
	}
	
	public List<ReviewDTO> selectReviews() {
		
		List<ReviewDTO> reviews = new ArrayList<>();
		
		try {
			conn = getConnection();
			
			close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			logger.error("ReviewDAO selectReview error : "+e.getMessage());
		}
		return reviews;
	}
	
	public void updateReview(ReviewDTO dto) {
		
	}
	
	public void deleteReview(int revNo) {
		try {
			
			conn = getConnection();
			
		} catch (Exception e) {
			// TODO: handle exception
			logger.error("ReviewDAO deleteReview error : "+e.getMessage());
		}
	}
	
}
