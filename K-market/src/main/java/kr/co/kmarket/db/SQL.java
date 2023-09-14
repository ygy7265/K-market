package kr.co.kmarket.db;

public class SQL {
	
	// Terms
	public static final String SELECT_TERMS = "SELECT * FROM `km_member_terms` WHERE type =?";


	//product
	public static final String SELECT_PRODUCT = "SELECT * FROM `km_product` WHERE `prodNo` = ?";
	public static final String SELECT_PRODUCTS = "SELECT * FROM `km_product` WHERE `cate1` = ? and `cate2` = ?";
	
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


	
	
	// cs_notice
	public static final String SELECT_NOTICES = "SELECT * FROM `km_cs_notice` ORDER BY `noticeNo` LIMIT ?,10";
	public static final String SELECT_NOTICES_FOR_CATE = "SELECT * FROM `km_cs_notice` WHERE `cate`=?";
	public static final String SELECT_COUNT_TOTAL = "SELECT COUNT(*) FROM `km_cs_notice`";




}
