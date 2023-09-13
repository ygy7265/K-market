package kr.co.kmarket.service;

import java.util.List;
import kr.co.kmarket.dao.MemberDAO;

public enum MemberService {
	
	INSTANCE;
	
	private MemberDAO dao = MemberDAO.getInstance();
	
	
	public void insertMember(MemberDAO dto) {
		dao.insertMember(dto);
	}
	
	public MemberDAO selectMember(String uid) {
		return dao.selectMember(uid);
	}
	
	public List<MemberDAO> selectMembers() {
		return dao.selectMembers();
	}
	
	public void updateMember(MemberDAO dto) {
		dao.updateMember(dto);
	}
	
	public void deleteMember(String uid) {
		dao.deleteMember(uid);
	}
	
	
}
