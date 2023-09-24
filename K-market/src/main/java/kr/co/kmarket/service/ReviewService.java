package kr.co.kmarket.service;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import kr.co.kmarket.dao.ProductDAO;
import kr.co.kmarket.dao.ReviewDAO;
import kr.co.kmarket.dto.Cate1DTO;
import kr.co.kmarket.dto.Cate2DTO;
import kr.co.kmarket.dto.ProductDTO;
import kr.co.kmarket.dto.ReviewDTO;

public enum ReviewService {

	INSTANCE;
	
	private ReviewDAO dao = ReviewDAO.getInstance();
	
	public void insertReview(ReviewDTO dto) {
		dao.insertReview(dto);
	}
	
	public List<ReviewDTO> selectReviews(String prodNo, int start) {
		return dao.selectReviews(prodNo,start);
	}
	
	public void deleteReview(int revNo) {
		dao.deleteReview(revNo);
	}
	// 추가 
	public int selectReviewCountTotal(String prodNo){
		
		return dao.selectReviewCountTotal(prodNo);
	}
	
}
