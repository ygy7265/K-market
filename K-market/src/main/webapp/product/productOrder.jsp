<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<!-- 
	날짜 : 2023/09/24
	이름 : 윤경엽
	내용 : 구매하기 기능 구현
 -->
<%@ include file="./_header.jsp" %>
<%@ include file="./_discount.jsp" %>
<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script src="/K-market/js/zipcode.js"></script>
<script>
$(function(){
	
	 // 세션 스토리지에서 "user" 세션 확인
	  var userSession = "${userid}";
	  console.log("userid = " + userSession);

	  // "user" 세션이 없으면 로그인 페이지로 리디렉션
	  if (!userSession) {
		alert("로그인이 필요한 서비스입니다.");
	    window.location.href = "/K-market/member/login.do"; // 로그인 페이지 URL로 변경
	  }
	const total2 = $('.ordertotal2').val();
	console.log('total2 = '+ total2);
	const nowpoint = ${user.point};
	var pointval = 0;
	$('.nowpoint').text(nowpoint.toLocaleString());
	
	$('input[name=point]').change(function(){
		var pointval = $(this).val();
		var psnowpoint = parseFloat(nowpoint);
	
		
		if(pointval > psnowpoint){
			$(this).val(psnowpoint);
		}
		
	
		
	});
	
	//포인트 적용
	$('#pointbtn').click(function(e){
		e.preventDefault();
		console.log(${user.point});
		var totalprice = parseFloat($('.ordertotal').text().replace(/,/g, ''));

		const point = $('input[name=point]').val();
		var pspoint = parseFloat(point);
		if(pspoint > totalprice){
			alert("전체 금액 이상 할인할수없습니다. 다시 확인 해주십시요.");
			return;
		}
		if(point >= 5000 || point == 0){
			const pointDiscount = total2 - point;
			$('.orderpointdiscount').val(point);
			console.log(total2);
			console.log(pointDiscount);
			const pointnus = nowpoint - point;
			console.log(pointnus);
			$('.ordertotal').text(pointDiscount.toLocaleString());
			$('input[name=ordertotal3]').val(pointDiscount);
			console.log($("input[name='ordertotal3']").val());

			
			$('.orderpointdiscount').text("- "+point.toLocaleString());
			$('.nowpoint').text(pointnus.toLocaleString());
		}else{
			alert("5000포인트부터 사용가능합니다");
		}
		
		
	});
	
	//구매하기버튼
	$('.buybtn').click(function(e){
		e.preventDefault();
		 // 사용자에게 구매 여부를 묻는 확인 대화상자를 띄웁니다.
	    
		//결제방법 체크여부
        var selectedPayment = $('input[name="payment"]:checked').val();

        // 선택된 항목이 없는 경우 경고 메시지를 표시합니다.
        if (!selectedPayment) {
            alert('결제 옵션을 선택해주세요.');
            return;
        } 
        else{
        	var confirmation = confirm("구매하시겠습니까?");
        	if (confirmation) { 
    	        $('#buyform').submit();
    	    }    	
        }

	    });
});
</script>
<main id="product">
    <aside>
        <ul class="category">
            <li><i class="fa fa-bars" aria-hidden="true"></i>카테고리</li>
            <li>
                <a href="#"><i class="fas fa-tshirt" aria-hidden="true"></i>패션·의류·뷰티</a>
                <ol>
                    <li><a href="/K-market/product/productlist.do">남성의류</a></li>
                    <li><a href="/K-market/product/productlist.do">여성의류</a></li>
                    <li><a href="/K-market/product/productlist.do">잡화</a></li>
                    <li><a href="/K-market/product/productlist.do">뷰티</a></li>
                </ol>
            </li>
            <li>
                <a href="#"><i class="fas fa-laptop" aria-hidden="true"></i>가전·디지털</a>
                <ol>
                    <li><a href="/K-market/product/productlist.do">노트북</a></li>
                    <li><a href="/K-market/product/productlist.do">가전</a></li>
                    <li><a href="/K-market/product/productlist.do">휴대폰</a></li>
                    <li><a href="/K-market/product/productlist.do">기타</a></li>
                </ol>
            </li>
            <li>
                <a href="#"><i class="fas fa-utensils" aria-hidden="true"></i>식품·생필품</a>
                <ol>
                    <li><a href="/K-market/product/productlist.do">신선식품</a></li>
                    <li><a href="/K-market/product/productlist.do">가공식품</a></li>
                    <li><a href="/K-market/product/productlist.do">건강식품</a></li>
                    <li><a href="/K-market/product/productlist.do">생필품</a></li>
                </ol>
            </li>
            <li>
                <a href="#"><i class="fas fa-home" aria-hidden="true"></i>홈·문구·취미</a>
                <ol>
                    <li><a href="/K-market/product/productlist.do">가구/DIY</a></li>
                    <li><a href="/K-market/product/productlist.do">침구·커튼</a></li>
                    <li><a href="/K-market/product/productlist.do">생활용품</a></li>
                    <li><a href="/K-market/product/productlist.do">사무용품</a></li>
                </ol>
            </li>
        </ul>
    </aside>
    <!-- 주문 페이지 시작-->
    <section class="order">

      <!-- 제목, 페이지 네비게이션 -->
      <nav>
        <h1>주문결제</h1>
        <p>
          HOME > 장바구니 > <strong>주문결제</strong>
        </p>
      </nav>

      <form action="/K-market/product/productcomplete.do" id="buyform" method="POST">
        <!-- 주문 상품 목록 -->                  
        <table>
          <thead>
            <tr>
              <th>상품명</th>
              <th>총수량</th>
              <th>판매가</th>
              <th>배송비</th>
              <th>소계</th>
            </tr>
          </thead>
          <tbody>
          
            <tr class="empty">
              <td colspan="7">장바구니에 상품이 없습니다.</td>
            </tr>
            <c:forEach var="list" items="${list}">
            <input type="hidden" class="discountlist" value="${list.discount}"></input>
            <tr>
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
              <td><fmt:formatNumber value="${list.delivery}" pattern="#,###"/></td>
              <td><fmt:formatNumber value="${list.count * list.price  - ((list.count * list.price) * (list.discount / 100))}" pattern="#,###"/></td>
            </tr>
             <input type="hidden" class="listpoint" value="${list.point}"/>
             <input type="hidden" class="listcount" value="${list.count}"/>
             <input type="hidden" class="listprice" value="${list.price}"/>
             <input type="hidden" class="listdelivery" value="${list.delivery}"/>
             <input type="hidden" class="listtotal" value="${list.total}"/>
             
            </c:forEach>
          </tbody>
        </table>                 
        
        <!-- 최종 결제 정보 -->
         <div class="final">
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
              <td>포인트 할인</td>
              <td class="orderpointdiscount">0</td>
            </tr>
            <tr>
              <td>배송비</td>
              <td class="orderdelivery">0</td>
            </tr>              
            <tr>
              <td>적립포인트</td>
              <td class="orderpoint">0</td>
            </tr>
          
            <tr>
              <td>전체주문금액</td>
              <td class="ordertotal">0</td>
            </tr>                           
          </table>
          <input type="button" name="" class="buybtn" value="결제하기">             
          <input type="hidden" class="ordercount" name="ordercount">            
          <input type="hidden" class="ordernodiscount" name="ordernodiscount">    
          <input type="hidden" class="orderdiscount" name="orderdiscount">    
          <input type="hidden" class="orderpointdiscount" name="orderpointdiscount" >    
          <input type="hidden" class="orderdelivery" name="orderdelivery">    
          <input type="hidden" class="orderpoint" name="orderpoint" >    
          <input type="hidden" class="ordertotal" name="ordertotal">    
          <input type="hidden" class="ordertotal2" name="ordertotal">    
          <input type="hidden" class="ordertotal3" name="ordertotal3">    
        </div>
          
        <!-- 배송정보 -->
        <article class="delivery">
          <h1>배송정보</h1>                          
          <table>
            <tr>
              <td>주문자</td>
              <td><input type="text" name="orderer" value="${user.name}"/></td>
            </tr>
            <tr>
              <td>휴대폰</td>
              <td>
                <input type="text" name="hp" value="${user.hp}"/>
                <span>- 포함 입력</span>
              </td>
            </tr>
            <tr>
              <td>우편번호</td>
              <td>
                <input type="text" name="km_zip" value="${user.zip}" />
                <input type="button" value="검색" onclick="zipcode()"/>
              </td>
            </tr>
            <tr>
              <td>기본주소</td>
              <td>
                <input type="text" name="km_addr1" value="${user.addr2}"/>
              </td>
            </tr>
            <tr>
              <td>상세주소</td>
              <td>
                <input type="text" name="km_addr2" value="${user.addr1}"/>
              </td>
            </tr>
          </table>
        </article>

        <!-- 할인정보 -->
        <article class="discount">
          <h1>할인정보</h1>

          <div>
            <p>현재 포인트 : <span class="nowpoint">/</span>점</p>
            <label>
                <input type="text" name="point" >점
                <input type="button" id="pointbtn" value="적용"/>
            </label>
            <span>포인트 5,000점 이상이면 현금처럼 사용 가능합니다.</span>
          </div>
        </article>

        <!-- 결제방법 -->
        <article class="payment">
            <h1>결제방법</h1>
            <div>
                <span>신용카드</span>
                <p>
                    <label><input type="radio" name="payment" value="1"/>신용카드 결제</label>
                    <label><input type="radio" name="payment" value="2"/>체크카드 결제</label>                                
                </p>
            </div>
            <div>
                <span>계좌이체</span>
                <p>
                    <label><input type="radio" name="payment" value="3"/>실시간 계좌이체</label>
                    <label><input type="radio" name="payment" value="4"/>무통장 입금</label>                                
                </p>
            </div>
            <div>
                <span>기타</span>
                <p>
                    <label><input type="radio" name="payment" value="5"/>휴대폰결제</label>
                    <label>
                        <input type="radio" name="payment" value="6"/>카카오페이
                        <img src="/K-market/images/ico_kakaopay.gif" alt="카카오페이"/>
                    </label>                                
                </p>
            </div>
        </article>

        <!-- 경고 -->
        <article class="alert">
          <ul>
              <li><span>케이마켓의 모든 판매자는 안전거래를 위해 구매금액, 결제수단에 상관없이 모든거래에 대하여 케이마켓 유한책임회사의 구매안전서비스(에스크로)를 제공하고 있습니다.</span></li>
              <li><span>케이마켓 유한책임회사의 전자금융거래법에 의해 결제대금예치업 등록번호는 02-006-00008 입니다.</span></li>
              <li><span>등록여부는 금융감독원 홈페이지(www.fss.or.kr)의 업무자료>인허가업무안내>전자금융업등록현황에서 확인하실수 있습니다.</span></li>
          </ul>
        </article>
      </form>
    </section>
     <!-- 주문 페이지 끝-->
</main>
<%@ include file="../_footer.jsp" %>