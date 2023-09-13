package kr.co.kmarket.dao;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.co.kmarket.db.DBHelper;
import kr.co.kmarket.dto.TermsDTO;

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
	public TermsDTO selectTerm() {
		
		TermsDTO dto = new TermsDTO();
		logger.debug("TermsDAO dto... 1 : "+dto);
		
	
		
		
		return null;
	}
}
