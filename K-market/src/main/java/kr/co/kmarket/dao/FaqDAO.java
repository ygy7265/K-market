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
		
		FaqDTO dto = new FaqDTO();
		try {
			conn = getConnection();
			psmt = conn.prepareStatement(SQL.SELECT_FAQ);
			psmt.setString(1, faqNo);
			rs = psmt.executeQuery();

			if(rs.next()) {
				dto.setFaqNo(rs.getInt(1));
				dto.setCate1(rs.getString(2));
				dto.setCate2(rs.getString(3));
				dto.setTitle(rs.getString(4));
				dto.setContent(rs.getString(5));
				dto.setHit(rs.getInt(6));
				dto.setWriter(rs.getString(7));
				dto.setRdate(rs.getString(8));
				
			}	
			logger.debug("List<FaqDTO> selectFaqs dto : "+dto.toString());
			close();
			
		}catch(Exception e) {
			logger.error("FaqDAO selectFaq error : "+e.getMessage());
			e.printStackTrace();
		}
		return dto;
	}
	
	public List<FaqDTO> selectFaqs(String cate1, int end) {
		
		List<FaqDTO> faqs = new ArrayList<>();
		
			try {
				conn = getConnection();
				psmt = conn.prepareStatement(SQL.SELECT_FAQS);
				psmt.setString(1, cate1);
				psmt.setInt(2, end);
				rs = psmt.executeQuery();
				
				logger.debug("List<FaqDTO> selectFaqs cate1 : "+cate1);
				logger.debug("List<FaqDTO> selectFaqs end : "+end);
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
	
	public List<FaqDTO> selectFaqsubs(String cate1,String cate2,int end) {
		
		List<FaqDTO> faqs = new ArrayList<>();
		
		try {
			conn = getConnection();
			psmt = conn.prepareStatement(SQL.SELECT_FAQS_SUB);
			psmt.setString(1, cate1);
			psmt.setString(2, cate2);
			psmt.setInt(3, end);
			rs = psmt.executeQuery();
			
			logger.debug("List<FaqDTO> selectFaqsubs cate1 : "+cate1);
			logger.debug("List<FaqDTO> selectFaqsubs cate2 : "+cate2);
			logger.debug("List<FaqDTO> selectFaqsubs end : "+end);
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
			logger.debug("List<FaqDTO> selectFaqsubs faqs : "+faqs);
			close();
			
		}catch(Exception e) {
			logger.error("List<FaqDTO> selectFaqsubs error : "+e.getMessage());
		}
		return faqs;
		
	}
	 
	public List<FaqDTO> selectFaqsCate(String cate) {
		
		List<FaqDTO> cates = new ArrayList<>();
		
			try {
				conn = getConnection();
				psmt = conn.prepareStatement(SQL.SELECT_FAQ_CATE);
				psmt.setString(1, cate);
				rs = psmt.executeQuery();
				
				while(rs.next()) {
					
					FaqDTO dto = new FaqDTO();
					dto.setCate2(rs.getString(1));
					cates.add(dto);
				}
				
				logger.debug("List<FaqDTO> selectFaqsCate cates : "+cates);
				close();
				 
			}catch(Exception e) {
				logger.error("List<FaqDTO> selectFaqs error : "+e.getMessage());
			}
			return cates;
	}
	//admin_Cs_Faq_list
//	public List<FaqDTO> adminselectFaqs(String cate1, int start) {
//		
//		List<FaqDTO> adminfaqs = new ArrayList<>();
//			try {
//				conn = getConnection();
//				psmt = conn.prepareStatement(SQL.ADMIN_SELECT_FAQS);
//				psmt.setString(1, cate1);
//				psmt.setInt(2, start);
//				rs = psmt.executeQuery();
//				
////				logger.debug("List<FaqDTO> admin_selectFaqs cate1 : "+cate1);
//				logger.debug("List<FaqDTO> admin_selectFaqs end : "+start);
//				while(rs.next()) {
//					FaqDTO dto = new FaqDTO();
//					dto.setFaqNo(rs.getInt(1));
//					dto.setCate1(rs.getString(2));
//					dto.setCate2(rs.getString(3));
//					dto.setTitle(rs.getString(4));
//					dto.setContent(rs.getString(5));
//					dto.setHit(rs.getInt(6));
//					dto.setWriter(rs.getString(7));
//					dto.setRdate(rs.getString(8));
//					adminfaqs.add(dto);
//				}
//				logger.debug("List<FaqDTO> selectFaqs faqs : "+adminfaqs);
//				close();
//			}catch(Exception e) {
//				logger.error("List<FaqDTO> selectFaqs error : "+e.getMessage());
//			}
//			return adminfaqs;
//	}
	public List<FaqDTO> admin_cs_fqa_list(){
		List<FaqDTO> faqs = new ArrayList<>();
		try {
			conn = getConnection();
			psmt = conn.prepareStatement(SQL.SELECT_FAQ_LIST_ALL);
			
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
			close();
			logger.debug("faqDAO() admin_cs_fqa_list() : " + faqs);
		} catch (Exception e) {
			logger.error("List<FaqDTO> selectFaqs error : "+e.getMessage());
		}
		
		return faqs;
	}// admin_cs_fqa_list() END
	
	//Admin_cs_faq_update
	public void admin_cs_faq_update(FaqDTO dto) {
		try {
			conn = getConnection();
			psmt = conn.prepareStatement(SQL.UPDATE_FAQ);
			psmt.setString(1, dto.getCate1());
			psmt.setString(2, dto.getCate2());
			psmt.setString(3, dto.getTitle());
			psmt.setString(4, dto.getContent());
			psmt.setInt(5, dto.getFaqNo());

			close();
		
		} catch (Exception e) {
			logger.debug("faqDAO() updateFaq() : " + e.getMessage());
		}
	}// admin_cs_faq_update END
	
	public int admin_cs_faq_delete(String faqNo) {
		int result = 0;
		
		try {
			
			conn = getConnection();
			psmt = conn.prepareStatement(SQL.DELETE_FAQ);
			psmt.setString(1, faqNo);
			result = psmt.executeUpdate();
			
			close();
		
		} catch (Exception e) {
			logger.debug("faqDAO() deleteFaq() : " + e.getMessage());
		}
		
		return result;
		
	}// admin_cs_faq_delete END
	
	public int adminselectFaqs(String cate) {
		int total = 0;
		
		try {
			
			conn = getConnection();
			psmt = conn.prepareStatement(SQL.SELECT_COUNT_TOTAL_FAQ);
			psmt.setString(1, cate);
			psmt.setString(2, cate);
			rs = psmt.executeQuery();
			
			if(rs.next()) {
				total = rs.getInt(1);
			}
			logger.debug("FaqDAO adminselectFaqs total : "+total);
			close();
		} catch (Exception e) {
			logger.debug("faqDAO() adminselectFaqs() : " + e.getMessage());
		}
		return total;
	}

}
