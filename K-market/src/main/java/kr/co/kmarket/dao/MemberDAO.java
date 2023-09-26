package kr.co.kmarket.dao;

import java.lang.reflect.Member;
import java.sql.SQLException;
import java.util.ArrayList;
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
	public void insertMemberSeller(MemberDTO dto) {
		
		try {
			conn = getConnection();
			psmt = conn.prepareStatement(SQL.INSERT_MEMBER_SELLER);
			psmt.setString(1, dto.getUid());
			psmt.setString(2, dto.getPass());
			psmt.setString(3, dto.getCompany());
			psmt.setString(4, dto.getName());
			psmt.setString(5, dto.getBizRegNum());
			psmt.setString(6, dto.getComRegNum());
			psmt.setString(7, dto.getHp());
			psmt.setString(8, dto.getFax());
			psmt.setString(9, dto.getEmail());
			psmt.setString(10, dto.getZip());
			psmt.setString(11, dto.getAddr1());
			psmt.setString(12, dto.getAddr2());
			psmt.setString(13, dto.getManager());
			psmt.setString(14, dto.getManagerHp());
			psmt.setString(15, dto.getRegip());
			
			psmt.executeUpdate();
			
			close();
			
		} catch(Exception e) {
			logger.error("insertMemberSeller() error : "+e.getMessage());
		}
	}
	
	public MemberDTO selectMember(String uid) {
		return null;
	}
	public MemberDTO selectMemberLogin(String uid,String pass) {
		MemberDTO dto = null;
		try {
			conn = getConnection();
			psmt = conn.prepareStatement(SQL.SELECT_MEMBER);
			psmt.setString(1, uid);
			psmt.setString(2, pass);
			rs = psmt.executeQuery();
			if(rs.next()) {
				dto = new MemberDTO();
				dto.setUid(rs.getString(1));
				dto.setName(rs.getString(3));
				dto.setGender(rs.getInt(4));
				dto.setHp(rs.getString(5));
				dto.setEmail(rs.getString(6));
				dto.setType(rs.getInt(7));
				dto.setPoint(rs.getInt(8));
				dto.setLevel(rs.getInt(9));
				dto.setZip(rs.getString(10));
				dto.setAddr1(rs.getString(11));
				dto.setAddr2(rs.getString(12));
				dto.setCompany(rs.getString(13));
				dto.setCeo(rs.getString(14));
				dto.setBizRegNum(rs.getString(15));
				dto.setComRegNum(rs.getString(16));
				dto.setTel(rs.getString(17));
				dto.setManager(rs.getString(18));
				dto.setFax(rs.getString(19));
				dto.setRegip(rs.getString(20));
				dto.setRdate(rs.getString(22));
			}
			
			close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return dto;
	}
	// 0917_admin_list 사용
	public List<MemberDTO> selectMembers() {
		
		List<MemberDTO> mList = new ArrayList<>();
		
		try {
			
			conn = getConnection();
			psmt = conn.prepareStatement(SQL.SELECT_MEMBERS_TOTAL);
			rs = psmt.executeQuery();
			
			while(rs.next()) {
				MemberDTO dto = new MemberDTO();
				dto.setUid(rs.getString(1));
				dto.setName(rs.getString(3));
				dto.setGender(rs.getInt(4));
				dto.setHp(rs.getString(5));
				dto.setEmail(rs.getString(6));
				dto.setType(rs.getInt(7));
				dto.setPoint(rs.getInt(8));
				dto.setLevel(rs.getInt(9));
				dto.setZip(rs.getString(10));
				dto.setAddr1(rs.getString(11));
				dto.setAddr2(rs.getString(12));
				dto.setCompany(rs.getString(13));
				dto.setCeo(rs.getString(14));
				dto.setBizRegNum(rs.getString(15));
				dto.setComRegNum(rs.getString(16));
				dto.setTel(rs.getString(17));
				dto.setManager(rs.getString(18));
				dto.setManagerHp(rs.getString(19));
				dto.setFax(rs.getString(20));
				dto.setRegip(rs.getString(21));
				dto.setRdate(rs.getString(23));
				
				mList.add(dto);
				
			}
			close();
		} catch (Exception e) {
			// TODO: handle exception
			logger.error("selectMembers() error : "+e.getMessage());
		}
		
		
		return mList;
	} // selectMembers END
	
	public void updateMember(MemberDTO dto) {
//		close();
	}
	
	public void deleteMember(String uid) {
//		close();
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
	
	public int selectCountMember() {
		int cmember = 0;
		try {
			
			conn = getConnection();
			psmt = conn.prepareStatement(SQL.SELECT_COUNT_MEMBER);
			rs = psmt.executeQuery();
			
			while(rs.next()) {
				cmember = rs.getInt(1);
				logger.debug("총 가입인원 : " + cmember);
			}
			
			close();
			
		} catch (Exception e) {
			// TODO: handle exception
			logger.error("MemberDAO - selectCountMember() error : "+e.getMessage());
		}
		return cmember;
	}
	// admin_indexPage 1일, 7일 30일 (신규가입자)
	public int selectMemberTotalDay() {
		int dayMember = 0;
		try {
			conn = getConnection();
			psmt = conn.prepareStatement(SQL.SELECT_MEMBERS_TOTAL_DAY);
			rs = psmt.executeQuery();
			if(rs.next()) {
				dayMember = rs.getInt(1);
				logger.debug("24이내 등록된 신규 제품 : "+dayMember);
			}
			close();
		} catch (Exception e) {
			logger.error("ProductDAO() - selectProductTotalDay error : "+e.getMessage());
		}
		return dayMember;
	}
	public int selectMemberTotalWeek() {
		int weekMember = 0;
		try {
			conn = getConnection();
			psmt = conn.prepareStatement(SQL.SELECT_MEMBERS_TOTAL_WEEK);
			rs = psmt.executeQuery();
			if(rs.next()) {
				weekMember = rs.getInt(1);
				//logger.debug("7일이내 등록된 신규 제품 : "+weekProd);
			}
			close();
		} catch (Exception e) {
			logger.error("ProductDAO() - selectProductTotalWeek error : "+e.getMessage());
		}
		return weekMember;
	}
	public int selectMemberTotalMonth() {
		int monthMember = 0;
		try {
			conn = getConnection();
			psmt = conn.prepareStatement(SQL.SELECT_MEMBERS_TOTAL_MONTH);
			rs = psmt.executeQuery();
			if(rs.next()) {
				monthMember = rs.getInt(1);
			logger.debug("30일이내 등록된 신규 제품 : "+monthMember);
			}
			close();
		} catch (Exception e) {
			logger.error("ProductDAO() - selectProductTotalMonth error : "+e.getMessage());
		}
		return monthMember;
	}
}

