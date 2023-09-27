<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<!-- 
	이름 : 윤경엽
	내용 : 상품 담기 구현
	날짜 : 2023/09/14
 -->
<%@ include file="./_header.jsp" %>
<%-- <%@ include file="./_discount.jsp" %> --%>
<script>


$(document).ready(function() {
	
		let cartNo = null;
	    let count = 0; // 상품 수 초기화
	    let point = 0; // 포인트 초기화
	    let total = 0; // total 변수를 초기화합니다.
	    let delivery = 0; // 배송비 초기화
	    let discountPrice = 0; // 전체비용 초기화
		let orderdiscount = $('input.ordercount').val();
	    var listValues = [];
	    initialize();
	    
	    $(".ordergo").click(function(e) {
	        e.preventDefault();
	        JSON.stringify(listValues);
	        var formData = new FormData();
	        formData.append('jsonData', JSON.stringify(listValues));
	        $('.formbuy').submit();
	    });

	   
	    function initialize() {
	        $('.ordernodiscount').text("0");
	        $('.orderdiscount').text("0");
	        $('.ordercount').text("0");
	        $('.orderpoint').text("0");
	        $('.orderdelivery').text("0");
	        $('.ordertotal').text("0");
	        $('.ordertotal2').val("0");
	    }
	    
	    
	    // 전체 선택 체크박스가 클릭되었을 때
	    $('#all').click(function() {
	        // 전체 선택 체크박스의 상태를 가져옴
	        var isChecked = $(this).prop('checked');
   			
	  	 	 $('.Item').prop('checked', isChecked);
	
	   		
	        // 개별 체크박스들의 상태를 전체 선택 체크박스와 동일하게 설정
	  	   
		        if($('.Item:checked').length === 0){
		        	 initialize();
		        }
		        else{
		        	calculateSelectedItems(); // 업데이트된 선택 항목 계산	
		        }
	    });

	    // 개별 체크박스 중 하나라도 선택 해제되었을 때
	    $('.Item').click(function() {
	        // 개별 체크박스들 중에서 하나라도 선택 해제된 것이 있는지 확인
	        cartNo = $(this).val();
	        console.log("cartNo = " + cartNo);
	        if ($('.Item:checked').length < $('.Item').length) {
	            // 하나라도 선택 해제된 경우, 전체 선택 체크박스도 선택 해제
	            $('#all').prop('checked', false);
	        } else {
	            // 모두 선택된 경우, 전체 선택 체크박스도 선택
	            $('#all').prop('checked', true);
	        }
	        
	        if($('.Item:checked').length === 0){
	        	 initialize();
	        }
	        else{
	        	calculateSelectedItems(); // 업데이트된 선택 항목 계산	
	        }
	        
	    });
	    //할인금액계산
	    function calculateSelectedItems() {
	        var selectedItems = $('.Item:checked'); // 선택된 체크박스 아이템들을 가져옵니다.
	        count = selectedItems.length; // 선택된 상품 수 업데이트
	        total = 0; // 총 상품금액 초기화
	        var discount = 0; // 할인 총액 초기화
	        var selectedCheckbox = $(this); // 선택된 체크박스
	        var listCountValue = null;
	      
	        var listdeliveryValue = null;
	        var listpriceValue = null;
	        var listLastPriceValue = null;
	        var listNoDiscountPriceValue = null;
	        var listdiscountedPrice = null;
	        var listpointValue = null;
	        var listdiscountper = null;
	        
	        var listValues = [];
	        selectedItems.each(function() {
	            var row = $(this).closest('tr'); // 선택된 체크박스가 속한 행을 가져옵니다.
	            var listCount = parseFloat(row.find('.listcount').val());  // 선택된 체크박스의 .listcount 값을 더합니다.
	            var listpriceValue = parseFloat(row.find('.listprice').val());  // 선택된 체크박스의 .listprice 값을 더합니다.
	            var listdiscountValue = parseFloat(row.find('.listdiscount').val());  // 선택된 체크박스의 .listcount 값을 더합니다.
	            var listProdNo = parseFloat(row.find('.listprodNo').val());  // 선택된 체크박스의 .listprodNo 값을 더합니다.
	            var listUid = $('.listuid').val(); // 선택된 체크박스의 .listcount 값을 더합니다.
	            var listdelivery = parseFloat(row.find('.listdelivery').val());  // 선택된 체크박스의 .listdelivery 값을 더합니다.
	            var listpName = parseFloat(row.find('.listpName').val());  // 선택된 체크박스의 .listpName 값을 더합니다.
	            var listtotal = parseFloat(row.find('.listtotal').val());  // 선택된 체크박스의 .listtotal 값을 더합니다.
	            var listpoint = parseFloat(row.find('.listpoint').val());  // 선택된 체크박스의 .listpoint 값을 더합니다.
	            var cartNo = $('.cartNo').val();
	            var cartNo = $('.cartNo').val();
	            
	            console.log("listProdNo = " + listProdNo);
	            console.log("listUid = " + listUid);
	            console.log("listCount = " + listCount);
	            console.log("listpriceValue = " + listpriceValue);
	            console.log("listProdNo = " + listProdNo);
	            console.log("listtotal = " + listtotal);
	            console.log("listdelivery = " + listdelivery);
	            console.log("listpoint = " + listpoint);
	            console.log("cartNo = " + cartNo);
	            
	            
	            listValues.push({
	                listCount: listCount,
	                listpriceValue: listpriceValue,
	                listdiscountValue: listdiscountValue,
	                listProdNo: listProdNo,
	                listUid: listUid,
	                listdelivery: listdelivery,
	                listtotal: listtotal,
	                listpoint: listpoint,
	                cartNo: cartNo,
	                orderdiscount:Math.round(orderdiscount)
	               
	            });
	          
	            
	            $('.jsondata').val(JSON.stringify(listValues));
	            console.log("$('.jsondata').v = " + $('.jsondata').val());
	            
	           //데이터 값 저장
	            listdeliveryValue += parseFloat(row.find('.listdelivery').val());  // 선택된 체크박스의 .listdelivery 값을 더합니다.
	            listpointValue += parseFloat(row.find('.listpoint').val());  // 선택된 체크박스의 .listpoint 값을 더합니다.
	        	listCountValue += parseFloat(row.find('.listcount').val());  // 선택된 체크박스의 .listcount 값을 더합니다.
	        	listLastPriceValue = listCount * listpriceValue;
	        	listNoDiscountPriceValue += listLastPriceValue;
	        	
	        	
	        	
	            // 할인 적용된 가격 계산
	            var discountedPrice = listLastPriceValue - (listLastPriceValue * (listdiscountValue / 100));
	            var discountper = (listLastPriceValue * (listdiscountValue / 100));
	            //할인후 적용 금액
	            listdiscountedPrice += discountedPrice;
	            //할인금액
	            listdiscountper += discountper;
	            console.log('discountedPrice value: ' + Math.round(discountedPrice).toLocaleString());
	            
	            console.log('discountedPrice value: ' + Math.round(listdiscountedPrice).toLocaleString());
	        });
	     
	        // 업데이트된 값들을 화면에 표시
	        $('.ordernodiscount').text(listNoDiscountPriceValue.toLocaleString());
	        
	        $('.orderdiscount').text('- ' + Math.round(listdiscountper).toLocaleString());
	        // 업데이트된 상품 수량을 화면에 표시
	        $('.ordercount').text(listCountValue.toLocaleString());
	        $('.orderpoint').text(listpointValue.toLocaleString());
	        $('.orderdelivery').text(listdeliveryValue.toLocaleString());
	        $('.ordertotal').text(Math.round(listdiscountedPrice).toLocaleString());
	        $('.ordertotal2').val(Math.round(listdiscountedPrice).toLocaleString());
	    }
	    
	 //선택삭제
    $('#deleteSelected').click(function() {
  	  var selectedItems = $('.Item:checked'); // 선택된 체크박스 아이템들을 가져옵니다.
        var cartNos = selectedItems.map(function() {
            return $(this).val(); // 선택된 아이템의 data-cartno 속성 값을 가져옵니다.
        }).get();
  	  
  	  console.log("cartNos"+cartNos);
      $('.Item:checked').closest('tr').remove();
      $.each(cartNos, function(index, cartNos) {
      	$.ajax({
				url:'/K-market/product/productcart.do',
				type:'POST',
				traditional : true,
				data: {"cartNo": cartNos},
				contentType: "application/x-www-form-urlencoded; charset=UTF-8",
				dataType:'json',
				success:function(data){
					console.log(data);
					console.log(data.result);
					if(data.result > 0){}
						
					}
			
			});
      });	
    });
});
</script>
<main id="product">
<%@ include file="../_aside.jsp" %>  
    </aside>
    <!-- 장바구니 페이지 시작 -->
    <section class="cart">
      
      <!-- 제목, 페이지 네비게이션 -->
      <nav>
        <h1>장바구니</h1>
        <p>
          HOME > <span>패션·의류·뷰티</span> > <strong>장바구니</strong>
        </p>
      </nav>
                    
      <form action="/K-market/product/productorder.do" class="formbuy" method="POST">
        <!-- 장바구니 목록 -->
        <table>
          <thead>
            <tr>
              <th><input type="checkbox" id="all"></th>
              <th>상품명</th>
              <th>총수량</th>
              <th>판매가</th>
              <th>할인</th>
              <th>포인트</th>
              <th>배송비</th>
              <th>소계</th>
            </tr>
          </thead>
          <tbody>
          <c:if test="${empty list}">
            <tr class="empty">
              <td colspan="7">장바구니에 상품이 없습니다.</td>
            </tr>
          </c:if>
          <c:if test="${not empty list}">
            <c:forEach var="list" items="${list}">
            <input type="hidden" class="discountlist" value="${list.discount}"></input>
            <tr>
              <td><input type="checkbox" class="Item" value="${list.cartNo}"></td>
              <td>
                <article>
                  <a href="/K-market/product/"><img src="../admin/thumbAll/${list.thumb1}" alt=""></a>
                  <div>
                    <h2><a href="/K-market/product/">${list.pName}</a></h2>
                    <p>${list.descript}</p>
                  </div>
                </article>
              </td>
               
              <td><fmt:formatNumber value="${list.count}" pattern="#,###"/></td>
              <td><fmt:formatNumber value="${list.price}" pattern="#,###"/></td>
              <td><fmt:formatNumber value="${list.discount}" pattern="#,###"/>%</td>
              <td><fmt:formatNumber value="${list.point}" pattern="#,###"/></td>
              <td><fmt:formatNumber value="${list.delivery}" pattern="#,###"/></td>
              <td class="smallprice"><fmt:formatNumber value="${list.count * list.price  - ((list.count * list.price) * (list.discount / 100))}" pattern="#,###"/></td>
			 <td><input type="hidden" class="listpoint" value="${list.point}"/> </td>
             <td><input type="hidden" class="listcount" value="${list.count}"/> </td>
             <td><input type="hidden" class="listprice" value="${list.price}"/> </td>
             <td><input type="hidden" class="listdelivery" value="${list.delivery}"/> </td>
             <td><input type="hidden" class="listtotal" value="${list.count * list.price  - ((list.count * list.price) * (list.discount / 100))}"/> </td>
             <td><input type="hidden" class="listdiscount" value="${list.discount}"/></td>
             <td><input type="hidden" class="listdiscript" value="${list.descript}"/></td>
             <td><input type="hidden" class="listpoint" value="${list.point}"/></td>
             <td><input type="hidden" class="listprodNo" value="${list.prodNo}"/></td>
             <td><input type="hidden" class="listpName" value="${list.pName}"/></td>
             <td><input type="hidden" class="listuid" value="${username}"/></td>
             <td><input type="hidden" class="cartNo" value="${list.cartNo}"/></td>
            </tr>
          	</c:forEach>
          	</c:if>
          	
          </tbody>
          
        </table>
        
        <input type="button" id="deleteSelected" name="del" value="선택삭제">
		
        <!-- 장바구니 전체합계 -->
        <div class="total">
          <h2>전체합계</h2>
          <table border="0">
            <tr>
              <td>상품수</td>
              <td class="ordercount">0</td>
            </tr>
            <tr>
              <td>상품금액</td>
              <td class="ordernodiscount">0</td>
            </tr>
            <tr>
              <td>할인금액</td>
              <td class="orderdiscount">0</td>
            </tr>
            <tr>
              <td>배송비</td>
              <td class="orderdelivery">0</td>
            </tr>              
            <tr>
              <td>포인트</td>
              <td class="orderpoint">0</td>
            </tr>
            <tr>
              <td>전체주문금액</td>
              <td class="ordertotal">0</td>
            </tr>
            	
          </table>
          <input type="hidden" class="jsondata" name="jsonData"/>
          <input type="hidden" class="orderdiscount" name="orderdiscount"/>
          <input type="hidden" class="ordertotal2"/>
          <input type="submit" class="ordergo" value="주문하기">    
        </div>
      </form>
    </section>
    <!-- 장바구니 페이지 끝 -->
</main>
<%@ include file="../_footer.jsp" %>