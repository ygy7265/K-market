package kr.co.kmarket.dao;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class NoticeDAO {
	
	// 싱글톤 생성
	private static NoticeDAO instance = new NoticeDAO();
	public static NoticeDAO getInstance() {
		return instance;
	}
	private NoticeDAO() {}
	
	// 로그 설정
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	
	
	// 기본 CRUD
	public void insertNotice(NoticeDAO dto) {
		
	}
	
	public NoticeDAO selectNotice(String noticeNo) { // 편의를 위해서 int noticeNo 가 아닌 String 으로 설정해둠 
		return null;
	}
	
	public List<NoticeDAO> selectNotices() {
		return null;
	}
	
	public void updateNotice(NoticeDAO dto) {
		
	}
	
	public void deleteNotice(String noticeNo) {
		
	}


	
	
	
	
	
}
