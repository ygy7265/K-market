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
	public void insertMemberSeller(MemberDTO dto) {
		dao.insertMemberSeller(dto);
	}
	
	public MemberDTO selectMember(String uid) {
		return dao.selectMember(uid);
	}
	public MemberDTO selectMemberLogin(String uid,String pass) {
		return dao.selectMemberLogin(uid,pass);
	}
	
	public List<MemberDTO> selectMembers() {
		return dao.selectMembers();
	}
	
	public void updateMember(MemberDTO dto) {
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
	
	// admin_indexPage 운영 현황
	public int selectCountMember() {
		return dao.selectCountMember();
	}
	
	public int selectMemberTotalDay() {
		return dao.selectMemberTotalDay();
	}
	
	public int selectMemberTotalWeek() {
		return dao.selectMemberTotalWeek();
	}
	
	public int selectMemberTotalMonth() {
		return dao.selectMemberTotalMonth();
	}
	
}
