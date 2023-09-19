<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<!-- 
	이름 : 윤경엽
	내용 : 상품 담기 구현
	날짜 : 2023/09/14
 -->
<%@ include file="./_header.jsp" %>
<%@ include file="./_discount.jsp" %>
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
                    
      <form action="/K-market/product/productorder.do">
        <!-- 장바구니 목록 -->
        <table>
          <thead>
            <tr>
              <th><input type="checkbox" name="all"></th>
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
              <td><input type="checkbox" name=""></td>
              <td>
                <article>
                  <a href="/K-market/product/"><img src="/K-market/images/product/301.jpeg" alt=""></a>
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
              <td><fmt:formatNumber value="${list.total}" pattern="#,###"/></td>
            </tr>
             <input type="hidden" class="listpoint" value="${list.point}"/>
             <input type="hidden" class="listcount" value="${list.count}"/>
             <input type="hidden" class="listprice" value="${list.price}"/>
             <input type="hidden" class="listdelivery" value="${list.delivery}"/>
             <input type="hidden" class="listtotal" value="${list.total}"/>
          	</c:forEach>
          	</c:if>
          </tbody>
        </table>
        <input type="button" name="del" value="선택삭제">

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
          <input type="hidden" class="ordertotal2"/>
          <input type="submit" name="" value="주문하기">    
        </div>
      </form>
    </section>
    <!-- 장바구니 페이지 끝 -->
</main>
<%@ include file="../_footer.jsp" %>