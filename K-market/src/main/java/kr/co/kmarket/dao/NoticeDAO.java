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
	// admin_notice_insert 0917
	public void insertNotice(NoticeDTO dto) {
		try {
			
			conn = getConnection();
			psmt = conn.prepareStatement(SQL.INSERT_NOTICE);
			psmt.setString(1, dto.getCate());
			psmt.setString(2, dto.getTitle());
			psmt.setString(3, dto.getContent());
			psmt.setString(4, dto.getWriter());
			psmt.executeUpdate();
			
			close();
			
		} catch (Exception e) {
			// TODO: handle exception
			logger.error("NoticeDAO insertNotice error : "+e.getMessage());
		}
	} // insertNotice END
	
	public NoticeDTO selectNotice(String noticeNo) { // 편의를 위해서 int noticeNo 가 아닌 String 으로 설정해둠
		
		NoticeDTO dto = new NoticeDTO();
		
		try {
			
			conn = getConnection();
			psmt = conn.prepareStatement(SQL.SELECT_NOTICE);
			psmt.setString(1, noticeNo);
			rs = psmt.executeQuery();
			
			if(rs.next()) {
				dto.setNoticeNo(rs.getInt(1));
				dto.setCate(rs.getString(2));
				dto.setTitle(rs.getString(3));
				dto.setContent(rs.getString(4));
				dto.setWriter(rs.getString(5));
				dto.setHit(rs.getInt(6));
				dto.setRdate(rs.getString(7));
			}			
			
			logger.debug("NoticeDAO dto ... : "+dto.toString());
			close();
			
			
			
		}catch(Exception e) {
			logger.error("NoticeDAO selectNotice error : "+e.getMessage());
			e.printStackTrace();
		}
		
		return dto;
	}
	
	
	
	public List<NoticeDTO> selectNotices(String cate, int start){
		
		List<NoticeDTO> notices = new ArrayList<>();
		
		try {
			conn = getConnection();
			psmt = conn.prepareStatement(SQL.SELECT_NOTICES);
			psmt.setString(1, cate);
			psmt.setString(2, cate);
			psmt.setInt(3, start);
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
	
	// 0919 admin_UpdateNotice
	public void updateNotice(NoticeDTO dto) {
		
		try {
			
			conn = getConnection();
			psmt = conn.prepareStatement(SQL.UPDATE_NOTICE);
			psmt.setString(1, dto.getCate());
			psmt.setString(2, dto.getTitle());
			psmt.setString(3, dto.getContent());
			psmt.setInt(4, dto.getNoticeNo());
			psmt.executeUpdate();
			
			close();
			
		} catch (Exception e) {
			// TODO: handle exception
			logger.error("NoticeDAO updateNotice error : "+e.getMessage());
		}
		
	} // updateNotice END
	
	public int deleteNotice(String noticeNo) {
		
		int result = 0;
		
		try {
			conn = getConnection();
			psmt = conn.prepareStatement(SQL.DELETE_NOTICE);
			psmt.setString(1, noticeNo);
			result = psmt.executeUpdate();
			
			close();
			
		} catch (Exception e) {
			logger.error("NoticeDAO deleteNotice error : "+e.getMessage());
		}
		return result;
	} // 0923 noticeDelete END
	
	// 추가 
	public int selectCountTotal(String cate) {
		int total = 0;
		try {
			
			conn = getConnection();
			psmt = conn.prepareStatement(SQL.SELECT_COUNT_TOTAL_NOTICE);
			psmt.setString(1, cate);
			psmt.setString(2, cate);
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
	
	public List<NoticeDTO> selectLatests(int size) {
		
		List<NoticeDTO> latests = new ArrayList<>();
		
		try {
			
			conn = getConnection();
			psmt = conn.prepareStatement(SQL.SELECT_NOTICES_LATESTS);
			psmt.setInt(1, size);
			rs = psmt.executeQuery();
			
			while(rs.next()) {
				
				NoticeDTO dto = new NoticeDTO();
				dto.setNoticeNo(rs.getInt(1));
				dto.setCate(rs.getString(2));
				dto.setTitle(rs.getString(3));
				dto.setRdate(rs.getString(4));
				
				latests.add(dto);
			}
			logger.debug("NoticeDAO selectLatests latests... : "+latests);
			close();
			
		}catch(Exception e) {
			logger.error("NoticeDAO selectLatests error : "+ e.getMessage());
		}
		
		return latests;
	}
	
	//admin_index_notice
	public List<NoticeDTO> selectAdminIndexNotice() {
		List<NoticeDTO> notices = new ArrayList<>();
		
		try {
			
			conn = getConnection();
			psmt = conn.prepareStatement(SQL.SELECT_ADMIN_INDEX_NOTICE);
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
			
			logger.debug("NoticeDAO dto ... : "+notices.toString());
			close();
			
		}catch(Exception e) {
			logger.error("NoticeDAO selectNotice error : "+e.getMessage());
			e.printStackTrace();
		}
		
		return notices;
	}
	
	
	
}
