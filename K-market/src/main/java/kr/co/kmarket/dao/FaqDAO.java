package kr.co.kmarket.dao;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FaqDAO {
	// 싱글톤 생성
	private static FaqDAO instance = new FaqDAO();
	public static FaqDAO getInstance() {
		return instance;
	}
	private FaqDAO() {}
	
	// 로그 설정
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	
	
	// 기본 CRUD
	public void insertFaq(FaqDAO dto) {
		
	}
	
	public FaqDAO selectFaq(String faqNo) { // 편의를 위해서 int faqNo 가 아닌 String 으로 설정해둠 
		return null;
	}
	
	public List<FaqDAO> selectFaqs() {
		return null;
	}
	
	public void updateFaq(FaqDAO dto) {
		
	}
	
	public void deleteFaq(String faqNo) {
		
	}

}
