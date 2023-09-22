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
	        $('.product-row:eq(${loopStatus.index}) .dis-price').text(discountPrice);
	        // ...
	      })();
	    </c:forEach>
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
          <td><a href="/K-market/product/productview.do?prodNo=${product.prodNo}" class="thumb"><img src="../images/product/300 (1).jpeg" alt="상품이미지"/></a></td>
          <td>
            <h3 class="name">${product.prodName}</h3>
            <a href="/K-market/product/productview.do" class="desc">상품설명</a>
          </td>
          <td>
            <ul>
              <li class="product-row"><ins class="dis-price"></ins></li>
              <li>
                <del class="org-price">${product.price}</del>
                <span class="discount">${product.discount}%</span>
              </li>
              <li>
              	<c:if test="${product.delivery eq 0}">
	            <span class="free-delivery">무료배송</span>
	            </c:if>
              </li>
            </ul>
          </td>
          <td>
            <h4 class="seller"><i class="fas fa-home"></i>&nbsp;${product.seller}</h4>
            <h5 class="badge ${product.level eq '6'? 'great':''}">${product.seller}</h5>
            <h6 class="rating star${product.score}">상품평</h6>
          </td>
        </tr>
        </c:forEach>
      </table>            
	  
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