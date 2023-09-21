package kr.co.kmarket.etc;

import java.util.HashMap;
import java.util.Map;
/**
 *	날짜 : 2023/09/18
 *	이름 : 이현정
 *	내용 : Cate1/2 관련 MapUtil 생성
 *
 */
public class MapUtil {
	public static final Map<String, String> map = new HashMap<String, String>();
		
      static {
	    	   // Notice_Cate
	      	   map.put("01","고객서비스");
	      	   map.put("02","안전거래");
	      	   map.put("03","위해상품");
	      	   map.put("04","이벤트당첨");
    	   	
    		  // FAQ_Cate1
	       	   map.put("10","가입");
	       	   map.put("20","쿠폰/이벤트");
	       	   map.put("30","주문/결제");
	       	   map.put("40","배송");
	       	   map.put("50","취소/반품/교환");
	       	   map.put("60","여행/숙박/항공");
	       	   map.put("70","안전거래");
	       	   
	       	   // FAQ_10_Cate2
	       	   map.put("1010","가입");
	       	   map.put("1011","탈퇴");
	       	   map.put("1012","회원정보");
	       	   map.put("1013","쿠폰");
      
	       	  // FAQ_20_Cate2
	       	   map.put("2010","쿠폰/할인혜택");
	       	   map.put("2011","포인트");
	       	   map.put("2012","제휴");
	       	   map.put("2013","이벤트");
      
	       	  // FAQ_30_Cate2
	       	   map.put("3010","상품");
	       	   map.put("3011","결제");
	       	   map.put("3012","구매내역");
	       	   map.put("3013","영수증/증빙");
	       	 
	       	   // FAQ_40_Cate2
	       	   map.put("4010","배송상태/기간");
	       	   map.put("4011","배송정보확인/변경");
	       	   map.put("4012","해외배송 ");
	       	   map.put("4013","당일배송 ");
	       	   map.put("4014","해외직구");
	       	  
	       	   // FAQ_50_Cate2
	       	   map.put("5010","반품신청/철회");
	       	   map.put("5011","반품정보확인/변경");
	       	   map.put("5012","교환 AS신청/철회");
	       	   map.put("5013","교환정보확인/변경");
	       	   map.put("5014","취소신청/철회");
	       	   map.put("5015","취소확인/환불정보");
	       	   
	       	   // FAQ_60_Cate2
	       	   map.put("6010","여행/숙박");
	       	   map.put("6011","항공");
	       	   
	       	   // FAQ_70_Cate2
	       	   map.put("7010","서비스 이용규칙 위반");
	       	   map.put("7011","지식재산권침해");
	       	   map.put("7012","법령 및 정책위반 상품");
	       	   map.put("7013","게시물 정책위반");
	       	   map.put("7014","직거래/외부거래유도");
	       	   map.put("7015","표시광고");
	       	   map.put("7016","청소년 위해상품/이미지");
	       	   
      } 
      
   public static String getCateName(String cate) {
       return map.get(cate);
   }

	
}
