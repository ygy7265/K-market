package kr.co.kmarket.db;

public class SQL {
	
	// SELECT
	public static final String SELECT_TERMS = "SELECT * FROM `km_member_terms`";
	
	
	
	
	// member_insert
	public static final String INSERT_MEMBER_NORMAR = "INSERT INTO `km_member` SET "
													+ "`uid`=?, "
													+ "`pass`=?, "
													+ "`name`=?, "
													+ "`gender`=?, "
													+ "`email`=?, "
													+ "`hp`=?, "
													+ "`type`=1, "
													+ "`zip`=?, "
													+ "`addr1`=?, "
													+ "`addr2`=?, "
													+ "`regip`=?, "
													+ "`rdate`=NOW() ";
	public static final String SELECT_COUNT_UID = "SELECT COUNT(*) FROM `km_member` WHERE `uid`=?";
	public static final String SELECT_COUNT_EMAIL = "SELECT COUNT(*) FROM `km_member` WHERE `email`=?";
	public static final String SELECT_COUNT_HP = "SELECT COUNT(*) FROM `km_member` WHERE `hp`=?";
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}