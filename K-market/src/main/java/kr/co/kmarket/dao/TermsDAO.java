package kr.co.kmarket.dao;

import java.util.List;

import kr.co.kmarket.db.DBHelper;
import kr.co.kmarket.dto.TermsDTO;

public class TermsDAO extends DBHelper {
	
	// 싱글톤
	private static TermsDAO instance = new TermsDAO();
	public static TermsDAO getInstance() {
		return instance;
	}
	private TermsDAO() {}
	
	// 기본 CRUD
	public TermsDTO selectTerm() {
		return null;
	}
}
