package kr.co.kmarket.service;

import java.util.List;
import kr.co.kmarket.dao.MemberDAO;
import kr.co.kmarket.dto.MemberDTO;

public enum MemberService {
	
	INSTANCE;
	
	private MemberDAO dao = MemberDAO.getInstance();
	
	
	public void insertMember(MemberDTO dto) {
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
	
	// 추가
	public int selectCountUid(String uid) {
		return dao.selectCountUid(uid);
	}
	public int selectCountEmail(String email) {
		return dao.selectCountEmail(email);
	}
	public int selectCountHp(String hp) {
		return dao.selectCountHp(hp);
	}
}
