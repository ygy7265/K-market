package kr.co.kmarket.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.co.kmarket.dao.QnaDAO;

public enum QnaService {
	
	INSTANCE;
	
	private QnaDAO dao = QnaDAO.getInstance();
	// 로그 설정
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	

	public void insertQna(QnaDAO dto) {
		dao.insertQna(dto);
	}
	
	public QnaDAO selectQna(String qnaNo) { // 편의를 위해서 int qnaNo 가 아닌 String 으로 설정해둠 
		return dao.selectQna(qnaNo);
	}
	
	public List<QnaDAO> selectQnas() {
		return dao.selectQnas();
	}
	
	public void updateQna(QnaDAO dto) {
		dao.updateQna(dto);
	}
	
	public void deleteQna(String qnaNo) {
		dao.deleteQna(qnaNo);
	}

}
