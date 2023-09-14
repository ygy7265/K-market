package kr.co.kmarket.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.co.kmarket.dao.FaqDAO;

public enum FaqService {
	
	INSTANCE;
	
	private FaqDAO dao = FaqDAO.getInstance();
	
	// 로그 설정
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	

	public void insertFaq(FaqDAO dto) {
		dao.insertFaq(dto);
	}
	
	public FaqDAO selectFaq(String faqNo) { // 편의를 위해서 int faqNo 가 아닌 String 으로 설정해둠 
		return dao.selectFaq(faqNo);
	}
	
	public List<FaqDAO> selectFaqs() {
		return dao.selectFaqs();
	}
	
	public void updateFaq(FaqDAO dto) {
		dao.updateFaq(dto);
	}
	
	public void deleteFaq(String faqNo) {
		dao.deleteFaq(faqNo);
	}

}
