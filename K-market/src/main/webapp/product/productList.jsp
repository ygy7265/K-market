<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="./_header.jsp" %>
<script>
	$(function(){
		 <c:forEach var="product" items="${list}" varStatus="loopStatus">
	      // 함수를 사용하여 새로운 스코프를 생성합니다.
	      (function() {
	        let price = ${product.price};
	        let delivery = ${product.delivery};
	        let discountPrice = price - (price * ${product.discount}/100);
	        $('.product-row:eq(${loopStatus.index}) .dis-price').text(Math.round(discountPrice).toLocaleString());
	        // ...
	      })();
	    </c:forEach>
	    
	 	/* 스페셜 페이지 제목 변경하기 */
	    let currentURL = window.location.href;// 현재 URL을 가져오기
	    let paramsString = currentURL.split('?')[1]; // URL을 '?'로 분할하여 파라미터 부분을 가져옴
	    let paramsArray = paramsString.split('&');  // 파라미터를 '&'로 분할하여 배열 생성
	    
	    // 파라미터 배열을 순회하면서 변수명과 값을 가져옴
	    paramsArray.forEach(function(param) {
	        let paramParts = param.split('=');
	        let paramName = decodeURIComponent(paramParts[0]); // 변수명 디코딩
	        let paramValue = decodeURIComponent(paramParts[1]); // 값 디코딩
	        
	        console.log('변수명: ' + paramName);
	        console.log('값: ' + paramValue);
	        
	        const h1Name = {
	        		'hit':'히트상품',
	        		'score':'추천상품',
	        		'new':'최신상품',
	        		'best':'인기상품',
	        		'discount':'할인상품'
	        	};
	        
	        // type1 파라미터가 존재할시
	        if(paramName == 'type1'){
	        	// type1 파라미터 값 구분
	        	if(h1Name.hasOwnProperty(paramValue)){
	        		const TypeName = h1Name[paramValue];
	        		$('nav > h1').text(TypeName);
	        	}
	        	$('nav > p').text('');
	        	$('.sort').css('display','none');
	        	$('.paging').css('display','none');
	        }
	        
	     	// 검색 기능
	        if(paramName == 'search'){
	        	$('nav > h1').text('\'${search}\'의 검색결과');
	        	$('nav > p').text('');
	        	$('.paging').css('display','none');
	        }
	        
	    });
	    
	 	
	})
</script>
<main id="product">
<%@ include file="../_aside.jsp" %>   
</aside>
    <section class="list">
    <!-- 제목, 페이지 네비게이션 -->
    <nav>
        <h1>상품목록</h1>
        <p>HOME > <span>${CateName.c1Name}</span> > <strong>${CateName.c2Name}</strong></p>
      </nav>

      <!-- 정렬 메뉴 -->
      <ul class="sort">
          <li><a href="/K-market/product/productlist.do?cate1=${cate1}&cate2=${cate2}&type2=sold" 
          	class="${type2 == 'sold'? 'on':''}">판매많은순</a></li>
          <li><a href="/K-market/product/productlist.do?cate1=${cate1}&cate2=${cate2}&type2=lowPrice" 
          	class="${type2 == 'lowPrice'? 'on':''}">낮은가격순</a></li>
          <li><a href="/K-market/product/productlist.do?cate1=${cate1}&cate2=${cate2}&type2=highPrice" 
          	class="${type2 == 'highPrice'? 'on':''}">높은가격순</a></li>
          <li><a href="/K-market/product/productlist.do?cate1=${cate1}&cate2=${cate2}&type2=highScore" 
          	class="${type2 == 'highScore'? 'on':''}">평점높은순</a></li>
          <li><a href="/K-market/product/productlist.do?cate1=${cate1}&cate2=${cate2}&type2=review" 
          	class="${type2 == 'review'? 'on':''}">후기많은순</a></li>
          <li><a href="/K-market/product/productlist.do?cate1=${cate1}&cate2=${cate2}&type2=latest" 
          	class="${type2 == 'latest'? 'on':''}">최근등록순</a></li>
      </ul>

	  
      <!-- 상품목록 -->              
      <table border="0">
      	<c:forEach var="product" items="${list}">
        <tr>
          <td><a href="/K-market/product/productview.do?prodNo=${product.prodNo}" class="thumb"><img src="../admin/thumbAll/${product.thumb1}" alt="상품이미지"/></a></td>
          <td>
            <h3 class="name">${product.prodName}</h3>
            <a href="/K-market/product/productview.do" class="desc">${product.descript}</a>
          </td>
          <td>
            <ul>
              <li class="product-row"><ins class="dis-price"></ins></li>
              <li>
                <del class="org-price"><fmt:formatNumber value="${product.price}" pattern="#,###"/></del>
                <span class="discount">${product.discount}%</span>
              </li>
              <li>
	          <c:choose>
	              <c:when test="${product.delivery gt 0}">
	              <span class="delivery">배송비 <fmt:formatNumber value="${product.delivery}" pattern="#,###"/>원</span>
	              </c:when>
	              <c:otherwise>
	              <span class="free-delivery">무료배송</span>
	              </c:otherwise>
	          </c:choose>
              </li>
            </ul>
          </td>
          <td>
            <h4 class="seller"><i class="fas fa-home"></i>&nbsp;${product.seller}</h4>
            <h5 class="badge ${product.level eq '6'? 'great':'normal'}">${product.seller}</h5>
            <h6 class="rating star${product.score}">상품평</h6>
          </td>
        </tr>
        </c:forEach>
      </table>            
	  <c:if test="${empty list}">
		  <div class="no-product">
		  	<h1>조회하신 상품이 존재하지 않습니다.</h1>
		  </div>
	  </c:if>
      <!-- 상품목록 페이지번호 -->
      <div class="paging">
      	<c:if test="${pageGroupStart > 1}">
        <span class="prev">
          <a href="/K-market/product/productlist.do?cate1=${cate1}&cate2=${cate2}&pg=${pageGroupStart - 1}"><&nbsp;이전</a>
        </span>
        </c:if>
        <span class="num">
        <c:forEach var="i" begin="${pageGroupStart}" end="${pageGroupEnd}">
          <a href="/K-market/product/productlist.do?cate1=${cate1}&cate2=${cate2}&pg=${i}" 
          class="${currentPage == i ? 'on':'' }">${i}</a>
        </c:forEach>
        </span>
        <c:if test="${pageGroupEnd < lastPageNum}">
        <span class="next">
          <a href="/K-market/product/productlist.do?cate1=${cate1}&cate2=${cate2}&pg=${pageGroupEnd + 1}">다음&nbsp;></a>
        </span>
        </c:if>
      </div>
    </section>
</main>
<%@ include file="../_footer.jsp" %>