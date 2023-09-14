package kr.co.kmarket.service;

import java.util.List;

import kr.co.kmarket.dao.TermsDAO;
import kr.co.kmarket.dto.TermsDTO;

public enum TermsService {
	
	INSTANCE;
	
	// termsDAO
	private TermsDAO dao = TermsDAO.getInstance();
	
	// service
	public TermsDTO selectTerm(String type) {
		return dao.selectTerm(type);
	}
	
	
	
}
