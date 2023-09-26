<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<!--
	이름 : 윤경엽
	내용 : 상품별리스트 출력
	날짜 : 2023/09/15
  -->
<%@ include file="./_header.jsp" %>
<%@ include file="./product/_discount.jsp" %>
<main>
<%@ include file="./_aside.jsp" %>

    <!-- 베스트상품 배너 -->
    <article class="best">
      <h1><i class="fas fa-crown"></i>베스트상품</h1>
      <h3>방문자 수 : <c:out value="${applicationScope.visitorCount}" /> 명</h3>
      <ol>
      	<c:forEach var="bestList" items="${bestList}" varStatus="loopStatus">
    
        <li>
          <a href="/K-market/product/productview.do?prodNo=${bestList.prodNo}">
            <div class="thumb">
              <i>${loopStatus.index + 1}</i>
              <img src="./admin/thumbAll/${bestList.thumb1}" alt="item1" />
            </div>
            <h2>${bestList.prodName}</h2>
            <div class="org_price">
              <del><fmt:formatNumber value="${bestList.price}" pattern="#,###"/></del>
              <span>${bestList.discount}%</span>
            </div>
            <div class="dis_price">
              <ins class="product-row"><fmt:formatNumber value="${bestList.price}" pattern="#,###"/></ins>
            </div>
          </a>
        </li>
       </c:forEach>
      </ol>
    </article>
  </aside>
  <section>
    <!-- 슬라이더 영역 -->
    <section class="slider">
		<ul id="mainbanner">
	        <li>
	          <a href="#"><img src="./images/mainbanner555.jpg" alt="item1"/></a>
	        </li>
	         <li>
	          <a href="#"><img src="./images/mainbanner111.jpg" alt="item1"/></a>
	        </li>
	         <li>
	          <a href="#"><img src="./images/mainbanner222.jpg" alt="item2"/></a>
	        </li>
	         <li>
	          <a href="#"><img src="./images/mainbanner333.jpg" alt="item3"/></a>
	        </li>
	         <li>
	          <a href="#"><img src="./images/mainbanner444.jpg" alt="item4"/></a>
	        </li>
      </ul>
    </section>
    <div class="btnTop">
		<span id="gotoTop"><img src="/K-market/images/btnTop.png" alt="btnTop"></span>
	</div>
    <!-- 히트상품 영역 -->
    <section class="hit">
      <h3><span>히트상품</span></h3>
      <c:forEach var="hitList" items="${hitList}">
      <article>
        <a href="/K-market/product/productview.do?prodNo=${hitList.prodNo}">
          <div class="thumb">
            <img src="./admin/thumbAll/${hitList.thumb1}" alt="t1" />
          </div>
          <h2>${hitList.prodName}</h2>
          <p>${hitList.descript}</p>
          <div class="org_price">
            <del><fmt:formatNumber value="${hitList.price}" pattern="#,###"/></del>
            <span>${hitList.discount}%</span>
          </div>
          <div class="dis_price"> 
            <ins class="product-row">${hitList.price}</ins>
            <c:if test="${hitList.delivery gt 0}">
            <span class="free">${hitList.delivery}</span>
            </c:if>
          </div>
        </a>
      </article>
      </c:forEach>
    
    </section>
    <!-- 추천상품 영역 -->
    <section class="recommend">
      <h3><span>추천상품</span></h3>
     <c:forEach var="scoreList" items="${scoreList}">
      <article>
        <a href="/K-market/product/productview.do?prodNo=${scoreList.prodNo}">
          <div class="thumb">
            <img src="./admin/thumbAll/${scoreList.thumb1}" alt="t1" />
          </div>
          <h2>${scoreList.prodName}</h2>
          <p>${scoreList.descript}</p>
          <div class="org_price">
            <del><fmt:formatNumber value="${scoreList.price}" pattern="#,###"/></del>
            <span>${scoreList.discount}%</span>
          </div>
          <div class="dis_price">
            <ins class="product-row">${scoreList.price}</ins>
            <c:if test="${scoreList.delivery eq 0}">
            <span class="free">${scoreList.delivery}</span>
            </c:if>
          </div>
        </a>
      </article>
      </c:forEach>
    </section>
    <!-- 최신상품 영역 -->
    <section class="new">
      <h3><span>최신상품</span></h3>
       <c:forEach var="newList" items="${newList}">
      <article>
        <a href="/K-market/product/productview.do?prodNo=${newList.prodNo}">
          <div class="thumb">
            <img src="./admin/thumbAll/${newList.thumb1}" alt="t1" />
          </div>
          <h2>${newList.prodName}</h2>
          <p>${newList.descript}</p>
          <div class="org_price">
            <del><fmt:formatNumber value="${newList.price}" pattern="#,###"/></del>
            <span>${newList.discount}%</span>
          </div>
          <div class="dis_price">
            <ins class="product-row"><fmt:formatNumber value="${newList.price}" pattern="#,###"/></ins>
            <c:if test="${newList.delivery eq 0}">
            <span class="free">${newList.delivery}</span>
            </c:if>
          </div>
        </a>
      </article>
     </c:forEach>
    </section>
    <!-- 할인상품 영역 -->
    <section class="discount">
      <h3><span>할인상품</span></h3>
      <c:forEach var="discountList" items="${discountList}">
      <article>
        <a href="/K-market/product/productview.do?prodNo=${discountList.prodNo}">
          <div class="thumb">
            <img src="./admin/thumbAll/${discountList.thumb1}" alt="t1" />
          </div>
          <h2>${discountList.prodName}</h2>
          <p>${discountList.descript}</p>
          <div class="org_price">
            <del><fmt:formatNumber value="${discountList.price}" pattern="#,###"/></del>
            <span>${discountList.discount}%</span>
          </div>
          <div class="dis_price">
            <ins class="product-row"><fmt:formatNumber value="${discountList.price}" pattern="#,###"/></ins>
            <c:choose>
  			  <c:when test="${discountList.delivery gt 0}">
        		 <span class="nofree"><fmt:formatNumber value="${discountList.delivery}" pattern="#,###"/></span>
   			  </c:when>
   			 <c:otherwise>
        		 <span class="free"><fmt:formatNumber value="${discountList.delivery}" pattern="#,###"/></span>
  			  </c:otherwise>
			</c:choose>
          </div>
        </a>
      </article>
      </c:forEach>
    </section>
  </section>
</main>
<%@ include file="./_footer.jsp"%>