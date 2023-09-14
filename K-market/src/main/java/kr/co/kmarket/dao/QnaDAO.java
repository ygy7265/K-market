package kr.co.kmarket.dao;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class QnaDAO {
	
	// 싱글톤 생성
	private static QnaDAO instance = new QnaDAO();
	public static QnaDAO getInstance() {
		return instance;
	}
	private QnaDAO() {}
	
	// 로그 설정
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	
	
	// 기본 CRUD
	public void insertQna(QnaDAO dto) {
		
	}
	
	public QnaDAO selectQna(String qnaNo) { // 편의를 위해서 int qnaNo 가 아닌 String 으로 설정해둠 
		return null;
	}
	
	public List<QnaDAO> selectQnas() {
		return null;
	}
	
	public void updateQna(QnaDAO dto) {
		
	}
	
	public void deleteQna(String qnaNo) {
		
	}

}
