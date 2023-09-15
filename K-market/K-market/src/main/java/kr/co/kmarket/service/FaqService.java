package kr.co.kmarket.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.co.kmarket.dao.FaqDAO;
import kr.co.kmarket.dto.FaqDTO;

public enum FaqService {
	
	INSTANCE;
	
	private FaqDAO dao = FaqDAO.getInstance();
	
	// 로그 설정
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	

	public void insertFaq(FaqDTO dto) {
		dao.insertFaq(dto);
	}
	
	public FaqDTO selectFaq(String faqNo) { // 편의를 위해서 int faqNo 가 아닌 String 으로 설정해둠 
		return dao.selectFaq(faqNo);
	}
	
	public List<FaqDTO> selectFaqs() {
		return dao.selectFaqs();
	}
	
	public void updateFaq(FaqDTO dto) {
		dao.updateFaq(dto);
	}
	
	public void deleteFaq(String faqNo) {
		dao.deleteFaq(faqNo);
	}

}
