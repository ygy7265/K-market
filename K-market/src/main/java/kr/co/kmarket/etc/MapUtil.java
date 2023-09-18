package kr.co.kmarket.etc;

import java.util.HashMap;
import java.util.Map;

/**
 *
 */
public class MapUtil {
	public static final Map<String, String> map = new HashMap<String, String>();
		
      static {
    	   	
    		  // FAQ_Cate1
	       	   map.put("10","가입");
	       	   map.put("20","쿠폰/이벤트");
	       	   map.put("30","주문/결제");
	       	   map.put("40","배송");
	       	   map.put("50","취소/반품/교환");
	       	   map.put("60","여행/숙박/항공");
	       	   map.put("70","안전거래");
	       	   
	       	   // FAQ_Cate2
	       	   map.put("1010","가입");
	       	   map.put("1011","탈퇴");
	       	   map.put("1012","회원정보");
	       	   map.put("2010","쿠폰");
       } 
   

   public static String getCateName(String cate) {
       return map.get(cate);
   }

	
}
