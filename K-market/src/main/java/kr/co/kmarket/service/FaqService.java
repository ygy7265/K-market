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
	
	public List<FaqDTO> selectFaqs(String cate1, int end) {
		return dao.selectFaqs(cate1, end);
	}
	
	public List<FaqDTO> selectFaqsubs(String cate1,String cate2,int end) {
		return dao.selectFaqsubs(cate1,cate2,end);
	}
	

	public List<FaqDTO> selectFaqsCate(String cate) {
		return dao.selectFaqsCate(cate);
	}
	
	public void admin_cs_faq_update(FaqDTO dto) {
		dao.admin_cs_faq_update(dto);
	}
	
	public int admin_cs_faq_delete(String faqNo) {
		return dao.admin_cs_faq_delete(faqNo);
	}
	//0923 admin_cs_faq_list 게시물 조회
//	public List<FaqDTO> adminselectFaqs(String cate1, int start) {
//		return dao.adminselectFaqs(cate1, start);
//	}
	public List<FaqDTO> admin_cs_fqa_list(){
		return dao.admin_cs_fqa_list();
	}
	
	public int adminselectFaqs(String cate) {
		return dao.adminselectFaqs(cate);
	}
	
}
