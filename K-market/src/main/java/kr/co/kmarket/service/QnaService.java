package kr.co.kmarket.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.co.kmarket.dao.QnaDAO;
import kr.co.kmarket.dto.QnaDTO;

public enum QnaService {
	
	INSTANCE;
	
	private QnaDAO dao = QnaDAO.getInstance();
	// 로그 설정
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	

	public int insertQna(QnaDTO dto) {
		return dao.insertQna(dto);
	}
	
	public QnaDTO selectQna(String qnaNo) { // 편의를 위해서 int qnaNo 가 아닌 String 으로 설정해둠 
		return dao.selectQna(qnaNo);
	}
	
	public List<QnaDTO> selectQnas(String cate1, int start) {
		return dao.selectQnas(cate1,start);
	}
	
	public void updateQna(QnaDTO dto) {
		dao.updateQna(dto);
	}
	
	public void deleteQna(String qnaNo) {
		dao.deleteQna(qnaNo);
	}
	
	// 추가
	public int selectCountTotal(String cate) {
		return dao.selectCountTotal(cate);
	}
	

}
