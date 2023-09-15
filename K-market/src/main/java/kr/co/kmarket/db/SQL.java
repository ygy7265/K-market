package kr.co.kmarket.db;

public class SQL {
	
	// Terms
	public static final String SELECT_TERMS = "SELECT * FROM `km_member_terms` WHERE type =?";

	//product
	public static final String INSERT_PRODUCT = "INSERT INTO `km_product` SET "
												+ "cate1=?, "
												+ "cate2=?, "
												+ "prodName=?, "
												+ "descript=?, "
												+ "company=?, "
												+ "price=?, "
												+ "discount=?, "
												+ "point=?, "
												+ "stock=?, "
												+ "delivery=?, "
												+ "thumb1=?, "
												+ "thumb2=?, "
												+ "thumb3=?, "
												+ "detail=?, "
												+ "status=?, "
												+ "duty=?, "
												+ "receipt=?, "
												+ "bizType=?, "
												+ "origin=? "
												+ "rdate=NOW()";
	
	public static final String SELECT_PRODUCT = "SELECT * FROM `km_product` WHERE `prodNo` = ?";
	public static final String SELECT_PRODUCTS = "SELECT * FROM `km_product` WHERE `cate1` = ? and `cate2` = ?";
	
	// member_insert
	public static final String INSERT_MEMBER_NORMAR = "INSERT INTO `km_member` SET "
													+ "`uid`=?, "
													+ "`pass`=SHA2(?, 256), "
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
  
	public static final String INSERT_MEMBER_SELLER = "INSERT INTO `km_member` SET "
													+ "`uid`=?, "
													+ "`pass`=?, "
													+ "`gender`=0, "
													+ "`type`=2, "
													+ "`company`=?, "
													+ "`Name`=?, "
													+ "`bizRegNum`=?, "
													+ "`comRegNum`=?, "
													+ "`hp`=?, "
													+ "`fax`=?, "
													+ "`email`=?, "
													+ "`zip`=?, "
													+ "`addr1`=?, "
													+ "`addr2`=?, "
													+ "`manager`=?, "
													+ "`managerHp`=?, "
													+ "`regip`=?, "
													+ "`rdate`=NOW() ";
	
	public static final String SELECT_COUNT_UID = "SELECT COUNT(*) FROM `km_member` WHERE `uid`=?";
	public static final String SELECT_COUNT_EMAIL = "SELECT COUNT(*) FROM `km_member` WHERE `email`=?";
	public static final String SELECT_COUNT_HP = "SELECT COUNT(*) FROM `km_member` WHERE `hp`=?";	
	
	
	// cs_notice
	public static final String SELECT_NOTICES = "SELECT * FROM `km_cs_notice` ORDER BY `noticeNo` LIMIT ?,10";
	public static final String SELECT_NOTICES_FOR_CATE = "SELECT * FROM `km_cs_notice` WHERE `cate`=?";
	public static final String SELECT_COUNT_TOTAL = "SELECT COUNT(*) FROM `km_cs_notice`";

	
	//cart
	public static final String INSERT_PRODUCT_CART= "INSERT INTO `km_product_cart` SET "
			+ "`uid`=?, "
			+ "`prodNo`=?, "
			+ "`count`=?, "
			+ "`price`=?, "
			+ "`discount`=?, "
			+ "`point`=?, "
			+ "`delivery`=?, "
			+ "`total`=?, "
			+ "`rdate`=NOW() ";


	// admin_register 
	public static final String SELECT_CATE1S = "SELECT * FROM `km_product_cate1` ORDER BY `cate1` ASC";
	public static final String SELECT_CATE2S = "SELECT * FROM `km_product_cate2` ORDER BY `cate1` ASC";
}
