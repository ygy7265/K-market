package kr.co.kmarket.dao;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.co.kmarket.db.DBHelper;
import kr.co.kmarket.db.SQL;
import kr.co.kmarket.dto.TermsDTO;
/*
 * 	날짜 : 2023/09/13
 *  이름 : 이현정
 * 	내용 : Terms 약관 페이지 내용 출력 및 약관 동의 기능 추가 
 * 
 * */
public class TermsDAO extends DBHelper {
	
	// 싱글톤
	private static TermsDAO instance = new TermsDAO();
	public static TermsDAO getInstance() {
		return instance;
	}
	private TermsDAO() {}
	
	// logger
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	
	// 기본 CRUD
	public TermsDTO selectTerm(String type) {
		
		TermsDTO dto = new TermsDTO();
		logger.debug("TermsDAO dto... 1 : "+dto);
		
		try {
			conn = getConnection();
			psmt = conn.prepareStatement(SQL.SELECT_TERMS);
			psmt.setString(1, type);
			rs = psmt.executeQuery();
			
			if(rs.next()) {
				dto.setTerms(rs.getString(1));
				dto.setPrivacy(rs.getString(2));
				dto.setLocation(rs.getString(3));
				dto.setFinance(rs.getString(4));
				dto.setTax(rs.getString(5));
			}
			close();
			logger.debug("TermsDAO dto... 2 : "+dto);
			
		}catch(Exception e) {
			logger.error("TermsDAO selectTerm...error: "+e.getMessage());
		}
		
		
		return dto;
	}
	
	
	
}
