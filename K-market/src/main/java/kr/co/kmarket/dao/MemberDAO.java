package kr.co.kmarket.dao;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.co.kmarket.db.DBHelper;
import kr.co.kmarket.db.SQL;
import kr.co.kmarket.dto.MemberDTO;

public class MemberDAO extends DBHelper{
	
	// 싱글톤 생성
	private static MemberDAO instance = new MemberDAO();
	public static MemberDAO getInstance() {
		return instance;
	}
	private MemberDAO() {}
	
	// 로그 설정
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	
	
	// 기본 CRUD
	public void insertMember(MemberDTO dto) {
		
		try {
			conn = getConnection();
			psmt = conn.prepareStatement(SQL.INSERT_MEMBER_NORMAR);
			psmt.setString(1, dto.getUid());
			psmt.setString(2, dto.getPass());
			psmt.setString(3, dto.getName());
			psmt.setInt(4, dto.getGender());
			psmt.setString(5, dto.getEmail());
			psmt.setString(6, dto.getHp());
			psmt.setString(7, dto.getZip());
			psmt.setString(8, dto.getAddr1());
			psmt.setString(9, dto.getAddr2());
			psmt.setString(10, dto.getRegip());
			psmt.executeUpdate();
			
			close();
			
		} catch(Exception e) {
			logger.error("insertMember() error : "+e.getMessage());
		}
	}
	
	public MemberDAO selectMember(String uid) {
		return null;
	}
	
	public List<MemberDAO> selectMembers() {
		return null;
	}
	
	public void updateMember(MemberDAO dto) {
		
	}
	
	public void deleteMember(String uid) {
		
	}
	
	// 추가
	public int selectCountUid(String uid) {
		
		int result = 0;
		try {
			conn = getConnection();
			psmt = conn.prepareStatement(SQL.SELECT_COUNT_UID);
			psmt.setString(1, uid);
			rs = psmt.executeQuery();
			
			if(rs.next()) {
				result = rs.getInt(1);
			}
			close();
		} catch(Exception e) {
			logger.error("selectCountUid() error : "+e.getMessage());
		}
		return result;
	}
	public int selectCountEmail(String email) {
		
		int result = 0;
		try {
			conn = getConnection();
			psmt = conn.prepareStatement(SQL.SELECT_COUNT_EMAIL);
			psmt.setString(1, email);
			rs = psmt.executeQuery();
			
			if(rs.next()) {
				result = rs.getInt(1);
			}
			close();
		} catch(Exception e) {
			logger.error("selectCountEmail() error : "+e.getMessage());
		}
		return result;
	}
	public int selectCountHp(String hp) {
		
		int result = 0;
		try {
			conn = getConnection();
			psmt = conn.prepareStatement(SQL.SELECT_COUNT_HP);
			psmt.setString(1, hp);
			rs = psmt.executeQuery();
			
			if(rs.next()) {
				result = rs.getInt(1);
			}
			close();
		} catch(Exception e) {
			logger.error("selectCountHp() error : "+e.getMessage());
		}
		return result;
	}
}

