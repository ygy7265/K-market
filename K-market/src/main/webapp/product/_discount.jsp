<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<!--
	이름 : 윤경엽
	내용 : 할인율 계산
	날짜 : 2023/09/15
  -->
<script>
	$(function(){
		 <c:forEach var="product" items="${bestList}" varStatus="loopStatus">
	      // 함수를 사용하여 새로운 스코프를 생성합니다.
	      (function() {
	        let price = ${product.price};
	        let delivery = ${product.delivery};
	        let discountPrice = Math.round(price - (price * ${product.discount}/100));
	        if(discountPrice < 100){
	        	discountPrice = 100;
	        }
	        $('.dis_price:eq(${loopStatus.index}) .product-row').text(discountPrice);
	      })();
	    </c:forEach>
	    <c:forEach var="product" items="${newList}" varStatus="loopStatus">
	      // 함수를 사용하여 새로운 스코프를 생성합니다.
	      (function() {
	        let price = ${product.price};
	        let delivery = ${product.delivery};
	        let discountPrice = Math.round(price - (price * ${product.discount}/100));
	        if(discountPrice < 100){
	        	discountPrice = 100;
	        }
	        $('.new .dis_price:eq(${loopStatus.index}) .product-row').text(discountPrice);

	      })();
	    </c:forEach>
	    <c:forEach var="product" items="${discountList}" varStatus="loopStatus">
	      // 함수를 사용하여 새로운 스코프를 생성합니다.
	      (function() {
	        let price = ${product.price};
	        let delivery = ${product.delivery};
	        let discountPrice = Math.round(price - (price * ${product.discount}/100));
	        if(discountPrice < 100){
	        	discountPrice = 100;
	        }
	        $('.discount .dis_price:eq(${loopStatus.index}) .product-row').text(discountPrice);
	        
	      })();
	    </c:forEach>
	    <c:forEach var="product" items="${hitList}" varStatus="loopStatus">
	      // 함수를 사용하여 새로운 스코프를 생성합니다.
	      (function() {
	        let price = ${product.price};
	        let delivery = ${product.delivery};
	        let discountPrice = Math.round(price - (price * ${product.discount}/100));
	        if(discountPrice < 100){
	        	discountPrice = 100;
	        }
	        $('.hit .dis_price:eq(${loopStatus.index}) .product-row').text(discountPrice);
	      })();
	    </c:forEach>
	    <c:forEach var="product" items="${scoreList}" varStatus="loopStatus">
	      // 함수를 사용하여 새로운 스코프를 생성합니다.
	      (function() {
	        let price = ${product.price};
	        let delivery = ${product.delivery};
	        let discountPrice = Math.round(price - (price * ${product.discount}/100));
	        if(discountPrice < 100){
	        	discountPrice = 100;
	        }
	        $('.recommend .dis_price:eq(${loopStatus.index}) .product-row').text(discountPrice);
	      })();
	    </c:forEach>
	})
</script>