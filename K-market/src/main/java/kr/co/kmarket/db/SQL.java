package kr.co.kmarket.db;

public class SQL {
	
	// Terms
	public static final String SELECT_TERMS = "SELECT * FROM `km_member_terms` WHERE type =?";
	
	// Index
	/*판매건수 (베스트상품)*/
	public static final String SELECT_BEST_PRODUCT = "SELECT * FROM `km_product` ORDER BY `sold` DESC LIMIT ?,?";
	/*조회순 (히트상품)*/
	public static final String SELECT_HIT_PRODUCT = "SELECT * FROM `km_product` ORDER BY `hit` DESC LIMIT ?,?";
	/*상품평점 (추천상품)*/
	public static final String SELECT_SCORE_PRODUCT = "SELECT * FROM `km_product` ORDER BY `score` DESC LIMIT ?,?";
	/*할인율 (할인상품)*/
	public static final String SELECT_DISCOUNT_PRODUCT = "SELECT * FROM `km_product` ORDER BY `discount` DESC LIMIT ?,?";
	/*최신순 (최신상품)*/
	public static final String SELECT_NEW_PRODUCT = "SELECT * FROM `km_product` ORDER BY `rdate` DESC LIMIT ?,?";
	
	
	
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
	
	public static final String UPDATE_PRODUCT = "UPDATE `km_product` SET "
												+ "`cate1`=?, "
												+ "`cate2`=?, "
												+ "`prodName`=?, "
												+ "`descript`=?, "
												+ "`company`=?, "
												+ "`price`=?, "
												+ "`discount`=?, "
												+ "`point`=?, "
												+ "`stock`=?, "
												+ "`delivery`=?, "
												+ "`thumb1`=?, "
												+ "`thumb2`=?, "
												+ "`thumb3`=?, "
												+ "`detail`=?, "
												+ "`status`=?, "
												+ "`duty`=?, "
												+ "`receipt`=?, "
												+ "`bizType`=?, "
												+ "`origin`=? ";
	
	public static final String SELECT_PRODUCT	= "SELECT * FROM `km_product` WHERE `prodNo` = ?";
	public static final String SELECT_CATE2	= "SELECT * FROM `km_product_cate2` WHERE `cate2` = ?";
	public static final String SELECT_PRODUCTS	= "SELECT a.*, b.`level` FROM `km_product` AS a JOIN `km_member` AS b ON a.seller = b.uid WHERE `cate1` = ? and `cate2` = ? ORDER BY `prodNo` DESC LIMIT ?, 10";
	public static final String SELECT_PRODUCTS_FOR_SEARCH	= "SELECT a.*, b.`level` FROM `km_product` AS a JOIN `km_member` AS b ON a.seller = b.uid WHERE `prodName` LIKE ? ORDER BY `prodNo` DESC ";
	public static final String SELECT_PRODUCTS_TOTAL_CATE = "SELECT COUNT(*) FROM `km_product` WHERE `cate1`=? AND `cate2`=?";
	public static final String SELECT_PRODUCTS_TOTAL_SEARCH = "SELECT COUNT(*) FROM `km_product` WHERE `prodName` LIKE ?";
	public static final String SELECT_CATE = "SELECT * FROM `km_product_cate1` AS a JOIN `km_product_cate2` AS b ON a.cate1 = b.cate1 WHERE a.`cate1`=? AND `cate2`=?";
	
	// product OrderBy
	public static final String SELECT_SOLD_PRODUCT_CATE = "SELECT a.*, b.`level` FROM `km_product` AS a JOIN `km_member` AS b ON a.seller = b.uid WHERE `cate1` = ? and `cate2` = ? ORDER BY `sold` DESC LIMIT ?,10";
	public static final String SELECT_HIGH_PRICE_PRODUCT_CATE = "SELECT a.*, b.`level` FROM `km_product` AS a JOIN `km_member` AS b ON a.seller = b.uid WHERE `cate1` = ? and `cate2` = ? ORDER BY `price` DESC LIMIT ?,10";
	public static final String SELECT_LOW_PRICE_PRODUCT_CATE = "SELECT a.*, b.`level` FROM `km_product` AS a JOIN `km_member` AS b ON a.seller = b.uid WHERE `cate1` = ? and `cate2` = ? ORDER BY `price` ASC LIMIT ?,10";
	public static final String SELECT_HIGH_SCORE_PRODUCT_CATE = "SELECT a.*, b.`level` FROM `km_product` AS a JOIN `km_member` AS b ON a.seller = b.uid WHERE `cate1` = ? and `cate2` = ? ORDER BY `score` DESC LIMIT ?,10";
	public static final String SELECT_REVIEW_PRODUCT_CATE = "SELECT a.*, b.`level` FROM `km_product` AS a JOIN `km_member` AS b ON a.seller = b.uid WHERE `cate1` = ? and `cate2` = ? ORDER BY `review` DESC LIMIT ?,10";
	public static final String SELECT_LATEST_PRODUCT_CATE = "SELECT a.*, b.`level` FROM `km_product` AS a JOIN `km_member` AS b ON a.seller = b.uid WHERE `cate1` = ? and `cate2` = ? ORDER BY `rdate` DESC LIMIT ?,10";
	
	/* REVIEW */
	// DELETE_PRODUCT시 Review ALL Delete
	public static final String SELECT_REVIEWS = "SELECT "
												+ "a.*, b.`name`, c.`prodName` "
												+ "FROM `km_member_review` AS a "
												+ "JOIN `km_member` AS b "
												+ "ON a.uid = b.uid "
												+ "JOIN `km_product` AS c "
												+ "ON a.prodNo = c.prodNo "
												+ "WHERE a.prodNo=? "
												+ "ORDER BY `revNo` DESC LIMIT ?, 5";
	public static final String DELETE_PRODUCT	 = "DELETE FROM `km_product` WHERE `prodNo`=?";
	public static final String DELETE_REVIEW_ALL = "DELETE FROM `km_member_review` WHERE `prodNo`=?";
	public static final String SELECT_REVIEWS_COUNT_TOTAL = "SELECT COUNT(*) FROM `km_member_review` WHERE `prodNo`=?";
	public static final String SELECT_UPDATE_RATING = "UPDATE `km_product` a "
													+"JOIN (SELECT AVG(`rating`) AS ratingAvg FROM `km_member_review` WHERE `prodNo`=?) b "
													+"SET a.`score` = b.ratingAvg WHERE a.`prodNo`=? ";
	
	
	/* admin_index */
	public static final String SELECT_ORDERS_COUNT_TOTAL = "SELECT COUNT(*) FROM `km_product_order`";
	public static final String SELECT_ORDERS_SUM_TOTAL = "SELECT SUM(`ordTotPrice`) FROM `km_product_order`";
	public static final String SELECT_COUNT_MEMBER = "SELECT COUNT(*) FROM `km_member`";
	// admin_index 신규제품 통합 
	public static final String SELECT_PRODUCTS_TOTAL_DAY = "SELECT COUNT(*) AS day_count "
															+ "FROM `km_product` "
															+ "WHERE `rdate` BETWEEN DATE_SUB(NOW(), INTERVAL 1 DAY) "
															+ "AND NOW()";
	public static final String SELECT_PRODUCTS_TOTAL_WEEK = "SELECT COUNT(*) AS week_count "
															+ "FROM `km_product` "
															+ "WHERE `rdate` BETWEEN DATE_SUB(NOW(), INTERVAL 1 WEEK) "
															+ "AND NOW()";
	public static final String SELECT_PRODUCTS_TOTAL_MONTH = "SELECT COUNT(*) AS month_count "
															+ "FROM `km_product` "
															+ "WHERE `rdate` BETWEEN DATE_SUB(NOW(), INTERVAL 1 MONTH) "
															+ "AND NOW()";
	public static final String SELECT_PRODUCTS_TOTAL_PERIOD = "SELECT COUNT(*) AS month_count "
															+ "FROM `km_product` "
															+ "WHERE `rdate` BETWEEN DATE_SUB(NOW(), INTERVAL 1 ?) "
															+ "AND NOW()";
	
	// admin_index 신규가입자
	public static final String SELECT_MEMBERS_TOTAL_DAY = "SELECT COUNT(*) AS day_count "
														+ "FROM `km_member` "
														+ "WHERE `rdate` BETWEEN DATE_SUB(NOW(), INTERVAL 1 DAY) "
														+ "AND NOW()";
	public static final String SELECT_MEMBERS_TOTAL_WEEK = "SELECT COUNT(*) AS week_count "
														+ "FROM `km_member` "
														+ "WHERE `rdate` BETWEEN DATE_SUB(NOW(), INTERVAL 1 WEEK) "
														+ "AND NOW()";
	public static final String SELECT_MEMBERS_TOTAL_MONTH = "SELECT COUNT(*) AS month_count "
														+ "FROM `km_member` "
														+ "WHERE `rdate` BETWEEN DATE_SUB(NOW(), INTERVAL 1 MONTH) "
														+ "AND NOW()";
	
	// admin_index 신규주문
	public static final String SELECT_ORDERS_TOTAL_DAY = "SELECT COUNT(*) AS day_count "
														+ "FROM `km_product_order` "
														+ "WHERE `ordDate` BETWEEN DATE_SUB(NOW(), INTERVAL 1 DAY) "
														+ "AND NOW()";
	public static final String SELECT_ORDERS_TOTAL_WEEK = "SELECT COUNT(*) AS week_count "
														+ "FROM `km_product_order` "
														+ "WHERE `ordDate` BETWEEN DATE_SUB(NOW(), INTERVAL 1 WEEK) "
														+ "AND NOW()";
	public static final String SELECT_ORDERS_TOTAL_MONTH = "SELECT COUNT(*) AS month_count "
														+ "FROM `km_product_order` "
														+ "WHERE `ordDate` BETWEEN DATE_SUB(NOW(), INTERVAL 1 MONTH) "
														+ "AND NOW()";
	// admin_index 일 총 주문금액 합산
	public static final String SELECT_ORDERS_TOTAL_DAY_TO_PRICE = "SELECT SUM(ordTotPrice) AS total_order_price "
																+ "FROM km_product_order "
																+ "WHERE ordDate BETWEEN DATE_SUB(NOW(), INTERVAL 1 DAY) AND NOW()";
	// admin_index 주간 총 주문금액 합산
	public static final String SELECT_ORDERS_TOTAL_WEEK_TO_PRICE = "SELECT SUM(ordTotPrice) AS total_order_price "
																+ "FROM km_product_order "
																+ "WHERE ordDate BETWEEN DATE_SUB(NOW(), INTERVAL 1 WEEK) AND NOW()";
	// admin_index 월간 총 주문금액 합산
	public static final String SELECT_ORDERS_TOTAL_MONTH_TO_PRICE = "SELECT SUM(ordTotPrice) AS total_order_price "
																+ "FROM km_product_order "
																+ "WHERE ordDate BETWEEN DATE_SUB(NOW(), INTERVAL 1 MONTH) AND NOW()";
	// admin_index 공지사항
	public static final String SELECT_ADMIN_INDEX_NOTICE ="SELECT * FROM `km_cs_notice` ORDER BY `noticeNo` DESC LIMIT 5";
	// admin_index 문의사항
	public static final String SELECT_ADMIN_INDEX_QNA ="SELECT * FROM `km_cs_qna` ORDER BY `qnaNo` DESC LIMIT 5";
	
	/* admin_product_list */
	public static final String SELECT_PRODUCTS_TOTAL = "SELECT * FROM `km_product` ORDER BY `rdate` DESC LIMIT ?,10";
	public static final String SELECT_PRODUCTS_COUNT_TOTAL = "SELECT COUNT(*) FROM `km_product`";
	/* admin_cs */
	public static final String SELECT_FAQ_LIST_ALL = "SELECT * FROM `km_cs_faq` ORDER BY `rdate` DESC LIMIT 0,10";
	public static final String INSERT_NOTICE = "INSERT INTO `km_cs_notice` SET "
												+ "`cate`=?, "
												+ "`title`=?, "
												+ "`content`=?, "
												+ "`writer`=?, "
												+ "`rdate`=NOW()";
	
	public static final String UPDATE_NOTICE = "UPDATE `km_cs_notice` SET `cate`=?, `title`=?, `content`=?, `rdate`=CURRENT_DATE "
												+ "WHERE `noticeNo`=?";
	
	public static final String DELETE_NOTICE = "DELETE FROM `km_cs_notice` WHERE `noticeNo` = ?";
	
	public static final String ADMIN_SELECT_FAQS = "SELECT * "
													+ "FROM `km_cs_faq` "
													+ "WHERE `cate1`=? "
													+ "ORDER BY `faqNo` DESC "
													+ "LIMIT ?,10";
	
	public static final String UPDATE_FAQ = "UPDATE `km_cs_faq` SET `cate1`=?, `cate2`=?, `title`=?, `content`=?, `rdate`=CURRENT_DATE "
											+ "WHERE `faqNo`=?";
	
	public static final String DELETE_FAQ = "DELETE FROM `km_cs_faq` WHERE `faqNo` = ?";
	
	public static final String SELECT_ADMIN_LIST_QNA ="SELECT * FROM `km_cs_qna` ORDER BY `qnaNo` DESC LIMIT 10";
	
	public static final String ADMIN_UPDATE_QNA_COMMENT = "UPDATE `km_cs_qna` SET `reply`=?, `status`=? WHERE `qnaNo`=?";
	
	public static final String ADMIN_SELECT_QNAS = "SELECT * "
											+ "FROM `km_cs_qna` "
											+ "WHERE ISNULL(cate1 = ?) OR `cate1`=? AND `qnaNo`>=566 "
											+ "ORDER BY `qnaNo` DESC "
											+ "LIMIT ?,10";
	
	public static final String ADMIN_QNA_DELETE = "DELETE FROM `km_cs_qna` WHERE `qnaNo`=?";
	
	
	//Member
	//member_Login
	public static final String SELECT_MEMBER = "SELECT * FROM `km_member` WHERE `uid` = ? and `pass` = SHA2(?,256)";
	public static final String UPDATE_MEMBER_POINT = "UPDATE `km_member` SET `point` = `point`- ? WHERE `uid` = ?";
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
	
	/**********CS************/
	// cs_notice
	public static final String SELECT_NOTICE = "SELECT * FROM `km_cs_notice` WHERE `noticeNo`=?";
	public static final String SELECT_NOTICES = "SELECT * "
												+ "FROM `km_cs_notice` "
												+ "WHERE ISNULL(cate = ?) OR `cate`=? "
												+ "ORDER BY `noticeNo` DESC "
												+ "LIMIT ?,10";
	public static final String SELECT_NOTICES_FOR_CATE = "SELECT * FROM `km_cs_notice` WHERE `cate`=?";
	public static final String SELECT_COUNT_TOTAL_NOTICE = "SELECT COUNT(*) FROM `km_cs_notice` WHERE ISNULL(cate = ?) OR cate=?";
	public static final String SELECT_NOTICES_LATESTS = "SELECT `noticeNo`, `cate`, `title`, `rdate` "
														+ "FROM `km_cs_notice` "
														+ "ORDER BY `noticeNo` DESC LIMIT ?";
	
	// cs_faq
	public static final String SELECT_FAQ = "SELECT * FROM `km_cs_faq` WHERE `faqNo`=?";
	public static final String SELECT_FAQS = "SELECT * "
											+ "FROM `km_cs_faq` "
											+ "WHERE `cate1`=? "
											+ "ORDER BY `faqNo` DESC "
											+ "LIMIT ?";
	public static final String SELECT_FAQS_SUB = "SELECT * "
												+ "FROM `km_cs_faq` "
												+ "WHERE `cate1`= ? AND `cate2` = ?"
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
	
	public static final String SELECT_QNA = "SELECT * FROM `km_cs_qna` WHERE `qnaNo`=? AND `qnaNo`>=566";
	public static final String SELECT_QNAS = "SELECT * "
											+ "FROM `km_cs_qna` "
											+ "WHERE `cate1`=? AND `qnaNo`>=566 "
											+ "ORDER BY `qnaNo` DESC "
											+ "LIMIT ?,10";
	
	public static final String SELECT_COUNT_TOTAL_QNA = "SELECT COUNT(*) FROM `km_cs_qna` WHERE ISNULL(cate1 = ?) OR cate1=? ";
	
	public static final String SELECT_COUNT_TOTAL_FAQ = "SELECT COUNT(*) FROM `km_cs_faq` WHERE ISNULL(cate1 = ?) OR cate1=? ";
	
	public static final String SELECT_QNA_CATE = "SELECT DISTINCT `cate2` FROM `km_cs_qna` WHERE `cate1` = ? ORDER BY `cate2`";
	public static final String SELECT_QNAS_LATESTS = "SELECT `qnaNo`, `cate1`,`cate2`, `title`, `writer`, `rdate` "
													+ "FROM `km_cs_qna` "
													+ "ORDER BY `qnaNo` DESC LIMIT ?";

	public static final String UPDATE_QNA ="UPDATE `km_cs_qna` SET `content`=? WHERE `qnaNo`=?";
	
	/**************************/
	
	
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
	public static final String INSERT_PRODUCT_ORDER= "INSERT INTO `km_product_order_item` SET "
													+ "`prodNo` = ?, "
													+ "`uid`=?, "
													+ "`count` = ?,"
													+ "`price` = ?, "
													+ "`discount` = ?, "
													+ "`point`= ?, "
													+ "`delivery` = ?, "
													+ "`total` = ?";
	public static final String INSERT_PRODUCT_ORDER_COMPLITE = "INSERT INTO `km_product_order` SET "
													+ "`uid` = ?,"
													+ "`ordCount` = ?,"
													+ "`ordPrice` = ?,"
													+ "`ordDiscount` = ?,"
													+ "`ordDelivery` = ?,"
													+ "`savePoint` = ?,"
													+ "`usedPoint` = ?,"
													+ "`ordTotPrice` = ?,"
													+ "`recipName`=?,"
													+ "`recipHp`=?,"
													+ "`recipZip`=?,"
													+ "`recipAddr1`=?,"
													+ "`recipAddr2`=?,"
													+ "`ordPayment` = ?,"
													+ "`ordComplete`= ?,"
													+ "`ordDate` = NOW()";
											

	public static final String SELECT_CARTS = "SELECT a.*,b.prodName,b.descript,b.thumb1 FROM `km_product_cart` AS a JOIN `km_product` AS b ON a.prodNo = b.prodNo WHERE `uid` = ?";
	public static final String SELECT_CARTS_ITEM = "SELECT a.*,b.prodName,b.descript,b.thumb1 FROM `km_product_order_item` AS a JOIN `km_product` AS b ON a.prodNo = b.prodNo WHERE `uid` = ?";
	public static final String SELECT_CARTS_ORDER_COMPLITE = "SELECT * FROM `km_product_order` WHERE `uid` = ? ORDER BY `ordNo` DESC LIMIT 1;";
	public static final String SELECT_COUNT_CART = "SELECT COUNT(*) FROM `km_product_cart`";	
	public static final String SELECT_DUPLICATION_CART = "SELECT * FROM `km_product_cart` WHERE `prodNo`= ? AND `uid` = ?";	
	public static final String DELETE_CART = "DELETE FROM `km_product_cart` WHERE `cartNo` = ?";	
	public static final String DELETE_ORDER = "DELETE FROM `km_product_order_item` WHERE `uid` = ?";
	public static final String UPDATE_CART = "UPDATE `km_product_cart` SET `count` = `count` + ?,`total` = `total` + ? WHERE `prodNo` = ? AND `uid` = ?";	
	// admin_register 
	public static final String SELECT_CATE1S = "SELECT * FROM `km_product_cate1` ORDER BY `cate1` ASC";
	public static final String SELECT_CATE2S = "SELECT * FROM `km_product_cate2` WHERE `cate1` = ? ORDER BY `cate1` ASC";
}
