package kr.co.kmarket.db;

public class SQL {
	
	// Terms
	public static final String SELECT_TERMS = "SELECT * FROM `km_member_terms` WHERE type =?";
	
	// Index
	/*판매건수 (베스트상품)*/
	public static final String SELECT_BEST_PRODUCT = "SELECT * FROM `km_product` ORDER BY `sold` DESC LIMIT 0,5";
	/*조회순 (히트상품)*/
	public static final String SELECT_HIT_PRODUCT = "SELECT * FROM `km_product` ORDER BY `hit` DESC LIMIT 0,8";
	/*상품평점 (추천상품)*/
	public static final String SELECT_SCORE_PRODUCT = "SELECT * FROM `km_product` ORDER BY `score` DESC LIMIT 0,8";
	/*할인율 (할인상품)*/
	public static final String SELECT_DISCOUNT_PRODUCT = "SELECT * FROM `km_product` ORDER BY `discount` DESC LIMIT 0,8";
	/*최신순 (최신상품)*/
	public static final String SELECT_NEW_PRODUCT = "SELECT * FROM `km_product` ORDER BY `rdate` DESC LIMIT 0,8";
	
	
	// Product
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
												+ "origin=?, "
												+ "seller=?, "
												+ "ip=?, "
												+ "rdate=NOW()";
	
	public static final String SELECT_PRODUCT	= "SELECT * FROM `km_product` WHERE `prodNo` = ?";
	public static final String SELECT_PRODUCTS	= "SELECT * FROM `km_product` WHERE `cate1` = ? and `cate2` = ?";
	// DELETE_PRODUCT시 Review ALL Delete
	public static final String DELETE_PRODUCT	 = "DELETE FROM `km_product` WHERE `prodNo`=?";
	public static final String DELETE_REVIEW_ALL = "DELETE FROM `km_member_review` WHERE `prodNo`=?";
	/* admin_product_list */
	public static final String SELECT_PRODUCTS_TOTAL = "SELECT * FROM `km_product` ORDER BY `rdate` DESC LIMIT ?,10";
	public static final String SELECT_PRODUCTS_COUNT_TOTAL = "SELECT COUNT(*) FROM `km_product`";
	/* admin_cs */
	public static final String INSERT_NOTICE = "INSERT INTO `km_cs_notice` SET "
												+ "`cate`=?, "
												+ "`title`=?, "
												+ "`content`=?, "
												+ "`writer`=?, "
												+ "`rdate`=NOW()";
	
	public static final String ADMIN_SELECT_FAQS = "SELECT * "
													+ "FROM `km_cs_faq` "
													+ "WHERE `cate1`=? "
													+ "ORDER BY `faqNo` DESC "
													+ "LIMIT ?,10";
	
	public static final String UPDATE_NOTICE = "UPDATE `km_cs_notice` SET `cate`=?, `title`=?, `content`=? WHERE `noticeNo`=?";
	//Member
	//member_Login
	public static final String SELECT_MEMBER = "SELECT * FROM `km_member` WHERE `uid` = ? and `pass` = SHA2(?,256)";
	
	//member_Insert
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
													+ "`pass`=SHA2(?, 256), "
													+ "`gender`=0, "
													+ "`type`=5, "
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
	
	public static final String SELECT_COUNT_UID	= "SELECT COUNT(*) FROM `km_member` WHERE `uid`=?";
	public static final String SELECT_COUNT_EMAIL = "SELECT COUNT(*) FROM `km_member` WHERE `email`=?";
	public static final String SELECT_COUNT_HP	= "SELECT COUNT(*) FROM `km_member` WHERE `hp`=?";	

	// member_Admin
	public static final String SELECT_MEMBERS_TOTAL = "SELECT * FROM `km_member`ORDER BY `rdate` DESC LIMIT 0,10";
	
	
	// cs_notice
	public static final String SELECT_NOTICE = "SELECT * FROM `km_cs_notice` WHERE `noticeNo`=?";
	public static final String SELECT_NOTICES = "SELECT * "
												+ "FROM `km_cs_notice` "
												+ "WHERE ISNULL(cate = ?) OR `cate`=? "
												+ "ORDER BY `noticeNo` DESC "
												+ "LIMIT ?,10";
	public static final String SELECT_NOTICES_FOR_CATE = "SELECT * FROM `km_cs_notice` WHERE `cate`=?";
	public static final String SELECT_COUNT_TOTAL_NOTICE = "SELECT COUNT(*) FROM `km_cs_notice` WHERE ISNULL(cate = ?) OR cate=?";
	
	// cs_faq
	public static final String SELECT_FAQ = "SELECT * FROM `km_cs_faq` WHERE `faqNo`=?";
	public static final String SELECT_FAQS = "SELECT * "
											+ "FROM `km_cs_faq` "
											+ "WHERE `cate1`=? "
											+ "ORDER BY `faqNo` DESC "
											+ "LIMIT ?";
	public static final String SELECT_FAQ_CATE = "SELECT DISTINCT `cate2` FROM `km_cs_faq` WHERE `cate1` = ? ORDER BY `cate2`";
	
	// cs_Qna
	public static final String INSERT_QNA= "INSERT INTO `km_cs_qna` SET "
											+ "`qnaNo`=?, "
											+ "`cate1`=?, "
											+ "`cate2`=?, "
											+ "`title`=?, "
											+ "`content`=?, "
											+ "`writer`=?, "
											+ "`status`=?, "
											+ "`reply`=?, "
											+ "`rdate`=NOW(), "
											+ "`ip`=? ";
	
	public static final String SELECT_QNA = "SELECT * FROM `km_cs_qna` WHERE `qnaNo`=?";
	public static final String SELECT_QNAS = "SELECT * "
											+ "FROM `km_cs_qna` "
											+ "WHERE `cate1`=? "
											+ "ORDER BY `qnaNo` DESC "
											+ "LIMIT ?,10";
	
	public static final String SELECT_COUNT_TOTAL_QNA = "SELECT COUNT(*) FROM `km_cs_qna` WHERE `cate1`=?";
	
	
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

	public static final String SELECT_CARTS = "SELECT a.*,b.prodName,b.descript FROM `km_product_cart` AS a JOIN `km_product` AS b ON a.prodNo = b.prodNo;";
	public static final String SELECT_COUNT_CART = "SELECT COUNT(*) FROM `km_product_cart`";	
	// admin_register 
	public static final String SELECT_CATE1S = "SELECT * FROM `km_product_cate1` ORDER BY `cate1` ASC";
	public static final String SELECT_CATE2S = "SELECT * FROM `km_product_cate2` ORDER BY `cate1` ASC";
}
