package kr.co.kmarket.dao;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.co.kmarket.db.DBHelper;
import kr.co.kmarket.db.SQL;
import kr.co.kmarket.dto.FaqDTO;
import kr.co.kmarket.dto.NoticeDTO;

public class FaqDAO extends DBHelper{
	// 싱글톤 생성
	private static FaqDAO instance = new FaqDAO();
	public static FaqDAO getInstance() {
		return instance;
	}
	private FaqDAO() {}
	
	// 로그 설정
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	
	
	// 기본 CRUD
	public void insertFaq(FaqDTO dto) {
		
	}
	
	public FaqDTO selectFaq(String faqNo) { // 편의를 위해서 int faqNo 가 아닌 String 으로 설정해둠 
		return null;
	}
	
	public List<FaqDTO> selectFaqs(String cate, int end) {
		
		List<FaqDTO> faqs = new ArrayList<>();
		
			try {
				conn = getConnection();
				psmt = conn.prepareStatement(SQL.SELECT_NOTICES);
				psmt.setString(1, cate);
				psmt.setString(2, cate);
				psmt.setInt(3, end);
				rs = psmt.executeQuery();
				
				while(rs.next()) {
					
					FaqDTO dto = new FaqDTO();
					dto.setFaqNo(rs.getInt(1));
					dto.setCate1(rs.getString(2));
					dto.setCate2(rs.getString(3));
					dto.setTitle(rs.getString(4));
					dto.setContent(rs.getString(5));
					dto.setHit(rs.getInt(6));
					dto.setWriter(rs.getString(7));
					dto.setRdate(rs.getString(8));
					
					faqs.add(dto);
				}
				logger.debug("List<FaqDTO> selectFaqs faqs : "+faqs);
				close();
				 
			}catch(Exception e) {
				logger.error("List<FaqDTO> selectFaqs error : "+e.getMessage());
			}
			return faqs;
			
	}
	
	public List<FaqDTO> selectFaqscate(String cate) {
		
		List<FaqDTO> faqs = new ArrayList<>();
		
			try {
					conn = getConnection();
					psmt = conn.prepareStatement(SQL.SELECT_FAQ_CATE);
					psmt.setString(1, cate);
					rs = psmt.executeQuery();
					
					while(rs.next()) {
						
						FaqDTO dto = new FaqDTO();;
						dto.setCate2(rs.getString(1));
	
						
						faqs.add(dto);
				}
					logger.debug("List<FaqDTO> selectFaqs faqs : "+faqs);
					close();
					 
			}catch(Exception e) {
				logger.error("List<FaqDTO> selectFaqs error : "+e.getMessage());
			}
			return faqs;
	}
	
	
	public void updateFaq(FaqDTO dto) {
		
	}
	
	public void deleteFaq(String faqNo) {
		
	}

}
