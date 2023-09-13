package kr.co.kmarket.dao;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.co.kmarket.db.DBHelper;

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
	public void insertMember(MemberDAO dto) {
		
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
}

