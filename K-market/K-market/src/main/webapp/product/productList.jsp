<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="./_header.jsp" %>

<main id="product">
<%@ include file="../_aside.jsp" %>   
</aside>
    <section class="list">
    <!-- 제목, 페이지 네비게이션 -->
    <nav>
        <h1>상품목록</h1>
        <p>HOME > <span>패션·의류·뷰티</span> > <strong>남성의류</strong></p>
      </nav>

      <!-- 정렬 메뉴 -->
      <ul class="sort">
          <li><a href="/K-market/product/productlist.do" class="on">판매많은순</a></li>
          <li><a href="/K-market/product/productlist.do">낮은가격순</a></li>
          <li><a href="/K-market/product/productlist.do">높은가격순</a></li>
          <li><a href="/K-market/product/productlist.do">평점높은순</a></li>
          <li><a href="/K-market/product/productlist.do">후기많은순</a></li>
          <li><a href="/K-market/product/productlist.do">최근등록순</a></li>
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
              <li><ins class="dis-price">${product.price}</ins></li>
              <li>
                <del class="org-price">${product.price}</del>
                <span class="discount">${product.prodName}%</span>
              </li>
              <li><span class="free-delivery">무료배송</span></li>
            </ul>
          </td>
          <td>
            <h4 class="seller"><i class="fas fa-home"></i>&nbsp;${product.seller}</h4>
            <h5 class="badge power">${product.seller}</h5>
            <h6 class="rating star1">상품평</h6>
          </td>
        </tr>
        </c:forEach>
      </table>            
	  
      <!-- 상품목록 페이지번호 -->
      <div class="paging">
        <span class="prev">
          <a href="/K-market/product/productlist.do"><&nbsp;이전</a>
        </span>
        <span class="num">
          <a href="/K-market/product/productlist.do" class="on">1</a>
          <a href="/K-market/product/productlist.do">2</a>
          <a href="/K-market/product/productlist.do">3</a>
          <a href="/K-market/product/productlist.do">4</a>
          <a href="/K-market/product/productlist.do">5</a>
          <a href="/K-market/product/productlist.do">6</a>
          <a href="/K-market/product/productlist.do">7</a>
        </span>
        <span class="next">
          <a href="/K-market/product/productlist.do">다음&nbsp;></a>
        </span>
      </div>
    </section>
</main>
<%@ include file="../_footer.jsp" %>