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
import kr.co.kmarket.service.ReviewService;

public class ReviewDAO extends DBHelper{
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	ReviewDTO dto = null;
	// 싱글톤
	private static ReviewDAO instance = new ReviewDAO();
	
	public static ReviewDAO getInstance() {
		return instance;
	}
	private ReviewService service = ReviewService.INSTANCE;
	private ReviewDAO() {}
	
	// 기본 CRUD
	public void insertReview(ReviewDTO dto) {
		
	}
	
	public ReviewDTO selectReview(int revNo) {
		return null;
	}
	
	public List<ReviewDTO> selectReviews(String prodNo, int start){
		
		List<ReviewDTO> reviews = new ArrayList<>();
		
		try {
			conn = getConnection();
			psmt = conn.prepareStatement(SQL.SELECT_REVIEWS);
			psmt.setString(1, prodNo);
			psmt.setInt(2, start);
			rs = psmt.executeQuery();
			
			while(rs.next()) {
				
				ReviewDTO dto = new ReviewDTO();
				dto.setRevNo(rs.getInt(1));
				dto.setProdNo(rs.getString(2));
				dto.setContent(rs.getString(3));
				dto.setUid(rs.getString(4));
				dto.setRating(rs.getInt(5));
				dto.setRegip(rs.getString(6));
				dto.setRdate(rs.getString(7));
				dto.setName(rs.getString(8));
				dto.setProdName(rs.getString(9));
				
				reviews.add(dto);
			}
			logger.debug("ReviewDAO selectReviews reviews : "+reviews);
			close();
			 
		}catch(Exception e) {
			logger.error("ReviewDAO selectReviews error : "+e.getMessage());
		}
		return reviews;
	}
	
	public void updateReview(ReviewDTO dto) {
//		close();
	}
	
	public void deleteReview(int revNo) {
		try {
			
			conn = getConnection();
			close();
			
		} catch (Exception e) {
			// TODO: handle exception
			logger.error("ReviewDAO deleteReview error : "+e.getMessage());
		}
	}
	// 추가 
	public int selectReviewCountTotal(String prodNo){
		int total = 0;
		try {
			conn = getConnection();
			psmt = conn.prepareStatement(SQL.SELECT_REVIEWS_COUNT_TOTAL);
			psmt.setString(1, prodNo);
			rs = psmt.executeQuery();
			
			if(rs.next()) {
				total = rs.getInt(1);
			}
			logger.debug("ReviewDAO selectReviewCountTotal total : "+total);
			close();
		}catch(Exception e) {
			logger.error("ReviewDAO selectReviewCountTotal error : "+ e.getMessage());
		}
		return total;
	}
	
}
