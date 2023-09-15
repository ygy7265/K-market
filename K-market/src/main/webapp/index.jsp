<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
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
      <ol>
      	<c:forEach var="bestList" items="${bestList}" varStatus="loopStatus">
    
        <li>
          <a href="/K-market/product/productview.do?prodNo=${bestList.prodNo}">
            <div class="thumb">
              <i>${loopStatus.index + 1}</i>
              <img src="./images/product/301.jpeg" alt="item1" />
            </div>
            <h2>${bestList.prodName}</h2>
            <div class="org_price">
              <del>${bestList.price}</del>
              <span>${bestList.discount}%</span>
            </div>
            <div class="dis_price">
              <ins class="product-row">${bestList.price}</ins>
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
      <ul>
        <li>
          <a href="#"
            ><img src="./images/977e463a0eac4249.jpg" alt="item1"
          /></a>
        </li>
         <li>
          <a href="#"><img src="./images/eaef5e849af44f1b.jpg" alt="item1"/></a>
        </li>
         <li>
          <a href="#"><img src="./images/64f78d70f729468a.jpg" alt="item2"/></a>
        </li>
         <li>
          <a href="#"><img src="./images/3484b119be884292.jpg" alt="item3"/></a>
        </li>
         <li>
          <a href="#"><img src="./images/6476792d613d460a.jpg" alt="item4"/></a>
        </li>
        
       	
      </ul>
    </section>
    <!-- 히트상품 영역 -->
    <section class="hit">
      <h3><span>히트상품</span></h3>
      <c:forEach var="hitList" items="${hitList}">
      <article>
        <a href="/K-market/product/productview.do?prodNo=${hitList.prodNo}">
          <div class="thumb">
            <img src="./images/product/300 (1).jpeg" alt="t1" />
          </div>
          <h2>${hitList.prodName}</h2>
          <p>${hitList.descript}</p>
          <div class="org_price">
            <del>${hitList.price}</del>
            <span>${hitList.discount}%</span>
          </div>
          <div class="dis_price">
            <ins>${hitList.price}</ins>
            <span class="free">${hitList.delivery}</span>
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
            <img src="./images/product/302.jpeg" alt="t1" />
          </div>
          <h2>${scoreList.prodName}</h2>
          <p>${scoreList.descript}</p>
          <div class="org_price">
            <del>${scoreList.price}</del>
            <span>${scoreList.discount}%</span>
          </div>
          <div class="dis_price">
            <ins class="product-row">${scoreList.price}</ins>
            <span class="free">${scoreList.delivery}</span>
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
            <img src="./images/product/303.jpeg" alt="t1" />
          </div>
          <h2>${newList.prodName}</h2>
          <p>${newList.descript}</p>
          <div class="org_price">
            <del>${newList.price}</del>
            <span>${newList.discount}%</span>
          </div>
          <div class="dis_price">
            <ins class="product-row">${newList.price}</ins>
            <span class="free">${newList.delivery}</span>
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
            <img src="./images/product/280.jpeg" alt="t1" />
          </div>
          <h2>${discountList.prodName}</h2>
          <p>${discountList.descript}</p>
          <div class="org_price">
            <del>${discountList.price}</del>
            <span>${discountList.discount}%</span>
          </div>
          <div class="dis_price">
            <ins class="product-row">${discountList.price}</ins>
            <c:choose>
  			  <c:when test="0 < ${discountList.delivery}">
        		 <span class="nofree">${discountList.delivery}</span>
   			  </c:when>
   			 <c:otherwise>
        		 <span class="free">${discountList.delivery}</span>
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