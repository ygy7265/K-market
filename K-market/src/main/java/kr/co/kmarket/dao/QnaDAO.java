package kr.co.kmarket.dao;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.co.kmarket.db.DBHelper;
import kr.co.kmarket.db.SQL;
import kr.co.kmarket.dto.FaqDTO;
import kr.co.kmarket.dto.NoticeDTO;
import kr.co.kmarket.dto.QnaDTO;

public class QnaDAO extends DBHelper{
	
	// 싱글톤 생성
	private static QnaDAO instance = new QnaDAO();
	public static QnaDAO getInstance() {
		return instance;
	}
	private QnaDAO() {}
	
	// 로그 설정
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	
	
	// 기본 CRUD
	public int insertQna(QnaDTO dto) {
		
		int result = 0;
		
		try {
			conn = getConnection();
			psmt = conn.prepareStatement(SQL.INSERT_QNA);
			psmt.setInt(1, dto.getQnaNo());
			psmt.setString(2, dto.getCate1());
			psmt.setString(3, dto.getCate2());
			psmt.setString(4, dto.getTitle());
			psmt.setString(5, dto.getContent());
			psmt.setString(6, dto.getWriter());
			psmt.setString(7, dto.getStatus());
			psmt.setString(8, dto.getReply());
			psmt.setString(9, dto.getIp());
			
			result= psmt.executeUpdate();
			
			logger.debug("QnaDAO insertQna dto : "+dto.toString());
			
			close();
			
		}catch(Exception e) {
			logger.error("QnaDAO insertQna error : "+e.getMessage());
		}
		return result;
		
	}
	
	public QnaDTO selectQna(String qnaNo) { // 편의를 위해서 int qnaNo 가 아닌 String 으로 설정해둠 
		QnaDTO dto = new QnaDTO();
		try {
			conn = getConnection();
			psmt = conn.prepareStatement(SQL.SELECT_QNA);
			psmt.setString(1, qnaNo);
			rs = psmt.executeQuery();
			if(rs.next()) {
				dto.setQnaNo(rs.getInt(1));
				dto.setCate1(rs.getString(2));
				dto.setCate2(rs.getString(3));
				dto.setTitle(rs.getString(4));
				dto.setContent(rs.getString(5));
				dto.setWriter(rs.getString(6));
				dto.setStatus(rs.getString(7));
				dto.setReply(rs.getString(8));
				dto.setRdate(rs.getString(9));
			}
			logger.debug("QnaDAO dto ... : "+dto.toString());
			close();
		}catch(Exception e) {
			logger.error("QnaDAO selectQna error : "+e.getMessage());
			e.printStackTrace();
		}
		return dto;
	} // selectQna END
	
	public List<QnaDTO> selectQnas(String cate1, int start) {
		
		List<QnaDTO> qnas = new ArrayList<>();
		
		try {
			conn = getConnection();
			psmt = conn.prepareStatement(SQL.ADMIN_SELECT_QNAS);
			psmt.setString(1, cate1);
			psmt.setString(2, cate1);
			psmt.setInt(3, start);
			rs = psmt.executeQuery();
			
			logger.debug("cate1 : "+cate1);
			logger.debug("start : "+start);
			
			while(rs.next()) {
				
				QnaDTO dto = new QnaDTO();
				dto.setQnaNo(rs.getInt(1));
				dto.setCate1(rs.getString(2));
				dto.setCate2(rs.getString(3));
				dto.setTitle(rs.getString(4));
				dto.setContent(rs.getString(5));
				dto.setWriter(rs.getString(6));
				dto.setStatus(rs.getString(7));
				dto.setReply(rs.getString(8));
				dto.setRdate(rs.getString(9));
				
				qnas.add(dto);
			}
			
			logger.debug("QnaDAO selectQnas qnas : "+qnas);
			close();
			 
		}catch(Exception e) {
			logger.error("QnaDAO selectQnas error : "+e.getMessage());
		}
		return qnas;

	}
	
	public void updateQna(QnaDTO dto) {
		try {
			conn = getConnection();
			psmt = conn.prepareStatement(SQL.UPDATE_QNA);
			psmt.setString(1, dto.getContent());
			psmt.setInt(2, dto.getQnaNo());
			psmt.executeUpdate();
			
			close();
			
		}catch(Exception e) {
			logger.error("QnaDAO updateQna error... :"+e.getMessage());
		}
	}
	
	public int deleteQna(String qnaNo) {
		int result = 0;
		
		try {
			conn = getConnection();
			psmt = conn.prepareStatement(SQL.ADMIN_QNA_DELETE);
			psmt.setString(1, qnaNo);
			result = psmt.executeUpdate();
			close();
			
		} catch (Exception e) {
			logger.error("QnaDAO deleteQna error... :"+e.getMessage());
		}
		
		return result;
	}
	
	// 추가
	public int selectCountTotal(String cate) {
		int total = 0;
		
		try {
			
			conn = getConnection();
			psmt = conn.prepareStatement(SQL.SELECT_COUNT_TOTAL_QNA);
			psmt.setString(1, cate);
			psmt.setString(2, cate);
			rs = psmt.executeQuery();
			
			if(rs.next()) {
				total = rs.getInt(1);
			}
			
			logger.debug("QnaDAO selectCountTotal total : "+total);
			close();
			
		}catch(Exception e) {
			logger.error("QnaDAO selectCountTotal error : "+ e.getMessage());
		}
		return total;
	}
	
	
	public List<QnaDTO> selectQnasCate(String cate) {
		
		List<QnaDTO> cates = new ArrayList<>();
		
			try {
				conn = getConnection();
				psmt = conn.prepareStatement(SQL.SELECT_QNA_CATE);
				psmt.setString(1, cate);
				rs = psmt.executeQuery();
				
				while(rs.next()) {
					
					QnaDTO dto = new QnaDTO();
					dto.setCate2(rs.getString(1));
					cates.add(dto);
				}
				
				logger.debug("QnaDAO selectQnasCate cates : "+cates);
				close();
				 
			}catch(Exception e) {
				logger.error("QnaDAO selectQnasCate error : "+e.getMessage());
			}
			return cates;
	}
	
	public List<QnaDTO> selectLatests(int size) {
		
		List<QnaDTO> latests = new ArrayList<>();
		
		try {
			
			conn = getConnection();
			psmt = conn.prepareStatement(SQL.SELECT_QNAS_LATESTS);
			psmt.setInt(1, size);
			rs = psmt.executeQuery();
			
			while(rs.next()) {
				
				QnaDTO dto = new QnaDTO();
				dto.setQnaNo(rs.getInt(1));
				dto.setCate1(rs.getString(2));
				dto.setCate2(rs.getString(3));
				dto.setTitle(rs.getString(4));
				dto.setWriter(rs.getString(5));
				dto.setRdate(rs.getString(6));
				
				latests.add(dto);
			}
			logger.debug("QnaDAO selectLatests latests... : "+latests);
			close();
			
		}catch(Exception e) {
			logger.error("QnaDAO selectLatests error : "+ e.getMessage());
		}
		
		return latests;
	}
	
	//admin_index_notice
	public List<QnaDTO> selectAdminIndexQna() {
		List<QnaDTO> qnas = new ArrayList<>();
		try {
			conn = getConnection();
			psmt = conn.prepareStatement(SQL.SELECT_ADMIN_INDEX_QNA);
			rs = psmt.executeQuery();
			
			while(rs.next()) {
				QnaDTO dto = new QnaDTO();
				dto.setQnaNo(rs.getInt(1));
				dto.setCate1(rs.getString(2));
				dto.setCate2(rs.getString(3));
				dto.setTitle(rs.getString(4));
				dto.setContent(rs.getString(5));
				dto.setWriter(rs.getString(6));
				dto.setStatus(rs.getString(7));
				dto.setReply(rs.getString(8));
				dto.setRdate(rs.getString(9));
				dto.setIp(rs.getString(10));
				qnas.add(dto);
			}			
			logger.debug("QnaDAO dto ... : "+qnas.toString());
			close();
		}catch(Exception e) {
			logger.error("QnaDAO selectQna error : "+e.getMessage());
			e.printStackTrace();
		}
		return qnas;
	} // selectAdminIndexQna END
	
	public List<QnaDTO> selectAdminListQna() {
		List<QnaDTO> adminqna = new ArrayList<>();
		try {
			conn = getConnection();
			psmt = conn.prepareStatement(SQL.SELECT_ADMIN_LIST_QNA);
			rs = psmt.executeQuery();
			
			while(rs.next()) {
				QnaDTO dto = new QnaDTO();
				dto.setQnaNo(rs.getInt(1));
				dto.setCate1(rs.getString(2));
				dto.setCate2(rs.getString(3));
				dto.setTitle(rs.getString(4));
				dto.setContent(rs.getString(5));
				dto.setWriter(rs.getString(6));
				dto.setStatus(rs.getString(7));
				dto.setReply(rs.getString(8));
				dto.setRdate(rs.getString(9));
				dto.setIp(rs.getString(10));
				
				adminqna.add(dto);
				
			}
			close();
		} catch (Exception e) {
			logger.error("QnaDAO selectListQna error : "+e.getMessage());
		}
		
		return adminqna;
	} // selectAdminListQna END
	
	public void admin_Update_Qna_Comment(QnaDTO dto) {
		String success = "답변완료";
		try {
			conn = getConnection();
			psmt = conn.prepareStatement(SQL.ADMIN_UPDATE_QNA_COMMENT);
			psmt.setString(1, dto.getReply());
			psmt.setString(2, success);
			psmt.setInt(3, dto.getQnaNo());
			psmt.executeUpdate();
			close();
		} catch (Exception e) {
			logger.error("QnaDAO admin_Update_Qna_Comment error : "+e.getMessage());
		}
	} // admin_Update_Qna_Comment END

}
