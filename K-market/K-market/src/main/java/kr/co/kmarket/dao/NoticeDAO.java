package kr.co.kmarket.dao;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.co.kmarket.db.DBHelper;
import kr.co.kmarket.db.SQL;
import kr.co.kmarket.dto.NoticeDTO;

public class NoticeDAO extends DBHelper{
	
	// 싱글톤 생성
	private static NoticeDAO instance = new NoticeDAO();
	public static NoticeDAO getInstance() {
		return instance;
	}
	public NoticeDAO() {}
	
	// 로그 설정
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	
	
	// 기본 CRUD
	public void insertNotice(NoticeDAO dto) {
		
	}
	
	public NoticeDTO selectNotice(String noticeNo) { // 편의를 위해서 int noticeNo 가 아닌 String 으로 설정해둠 
		return null;
	}
	
	public List<NoticeDTO> selectNotices(int start){
		
		List<NoticeDTO> notices = new ArrayList<>();
		
		try {
			conn = getConnection();
			psmt = conn.prepareStatement(SQL.SELECT_NOTICES);
			psmt.setInt(1, start);
			rs = psmt.executeQuery();
			
			while(rs.next()) {
				
				NoticeDTO dto = new NoticeDTO();
				dto.setNoticeNo(rs.getInt(1));
				dto.setCate(rs.getString(2));
				dto.setTitle(rs.getString(3));
				dto.setContent(rs.getString(4));
				dto.setWriter(rs.getString(5));
				dto.setHit(rs.getInt(6));
				dto.setRdate(rs.getString(7));
				
				notices.add(dto);
			}
			logger.debug("NoticeDAO selectNotices notices : "+notices);
			close();
			 
		}catch(Exception e) {
			logger.error("NoticeDAO selectNotices error : "+e.getMessage());
		}
		return notices;
	}
	
	
	
	
	public void updateNotice(NoticeDTO dto) {
		
	}
	
	public void deleteNotice(String noticeNo) {
		
	}
	
	public int selectCountTotal() {
		
		int total = 0;
		
		try {
			
			conn = getConnection();
			psmt = conn.prepareStatement(SQL.SELECT_COUNT_TOTAL);
			rs = psmt.executeQuery();
			
			if(rs.next()) {
				total = rs.getInt(1);
			}
			
			logger.debug("NoticeDAO selectCountTotal total : "+total);
			close();
			
		}catch(Exception e) {
			logger.error("NoticeDAO selectCountTotal error : "+ e.getMessage());
		}
		
		return total;
	}

	
	
	
	
	
}
