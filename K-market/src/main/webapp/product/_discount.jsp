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
	        $('.dis_price:eq(${loopStatus.index}) .product-row').text(discountPrice.toLocaleString());
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
	        $('.new .dis_price:eq(${loopStatus.index}) .product-row').text(discountPrice.toLocaleString());

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
	        $('.discount .dis_price:eq(${loopStatus.index}) .product-row').text(discountPrice.toLocaleString());
	        
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
	        $('.hit .dis_price:eq(${loopStatus.index}) .product-row').text(discountPrice.toLocaleString());
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
	        $('.recommend .dis_price:eq(${loopStatus.index}) .product-row').text(discountPrice.toLocaleString());
	      })();
	    </c:forEach> 
	    
	    //최종결제정보
			 let count = 0; // 값들을 더하기 위한 변수를 초기화합니다.
			 let smcount = 0;
			 let total = 0;
			 let point = 0;
			 let delivery = 0;
			 let discountPrice = 0;
			 let discountp = 0;
			 let discount = 0;
			 let LastPrice = 0;

			 $('.listcount, .listtotal, .discountlist').each(function() {
			        let value = parseFloat($(this).val());// 현재 요소의 텍스트 값을 가져옴
			        
			        if (!isNaN(value)) {
			            if ($(this).hasClass('listcount')) {
			                count += value; // .listcount 클래스 요소일 경우 count 변수에 더함
			                smcount = count
			            }else if($(this).hasClass('discountlist')){
			            	discount = parseFloat($(this).val());
			            }
			            else if ($(this).hasClass('listtotal')) {
			                total += value;
			                // 할인 적용된 가격 계산
			                discountPrice += Math.round((value - (value * discount / 100)));
			                discountp += value * discount / 100;
			                LastPrice += discountPrice;
			                console.log("할인률 = " + discount);
			                console.log("원래가격 = " + total);			                
			                console.log("할인가격  = " + discountp);
			                console.log("할인 적용된 가격 = " + discountPrice);
			                
			                if(discountp > 0){
			                	$('td.orderdiscount').text("- "+Math.round(discountp).toLocaleString());
			                	$('input.orderdiscount').val(Math.round(discountp));
			                }
			                
			            }
			        }
			    });

			    $('.listpoint').each(function() {
			        let value = parseFloat($(this).val());
			        if (!isNaN(value)) {
			        	point += value;
			        }
			    });
			    
			    
			    $('.listdelivery').each(function() {
			        let value = parseFloat($(this).val());
			        if (!isNaN(value)) {
			        	delivery += value;
			        }
			    });
			    
			    var listpriceElements = $('.listprice');

			    if (listpriceElements.length === 1) {
			    	var oneprice = $('.listprice').val();
			    	$('td.ordernodiscount').text(oneprice.toLocaleString());
			    }
			    else{
			    	$('td.ordernodiscount').text(total.toLocaleString());
			    }
			    
		        console.log('test222 value: ' + oneprice);
				$('td.ordercount').text(count.toLocaleString());
			
				
				$('td.orderpoint').text(point.toLocaleString());
				$('td.orderdelivery').text(delivery.toLocaleString());
				$('td.ordertotal').text((discountPrice+delivery).toLocaleString());
				$('.ordertotal2').val(discountPrice+delivery);
				
				$('input.ordercount').val(count);
				$('input.ordernodiscount').val(total+delivery);
				
				$('input.orderpoint').val(point);
				$('input.orderdelivery').val(delivery);
				$('input.ordertotal').val(discountPrice);
				
				
				
				
				
				
		})
	
</script>