<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="./_header.jsp" %>
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
    <!-- 결제완료 페이지 시작 -->
    <section class="complete">
        <!-- 제목, 페이지 네비게이션 -->
        <nav>
            <h1>주문완료</h1>
            <p>
            HOME > 장바구니 > 주문결제 > <strong>주문완료</strong>
            </p>
        </nav>

        <!-- 완료 멘트 -->
        <article class="message">
            <h2>고객님의 주문이 정상적으로 완료되었습니다.<i class="far fa-smile"></i></h2>
            <p>
            즐거운 쇼핑이 되셨습니까? 항상 고객님을 최우선으로 생각하는 케이마켓이 되겠습니다.
            </p>
        </article>

        <!-- 상품정보 -->
        <article class="info">
            <h1>상품정보</h1>
            <table border="0">
            <tr>
                <th>상품명</th>
                <th>상품금액</th>
                <th>할인금액</th>
                <th>수량</th>
                <th>주문금액</th>
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
              <td><fmt:formatNumber value="${list.price}" pattern="#,###"/></td>
              <td><fmt:formatNumber value="${list.price * list.discount / 100}" pattern="#,###"/></td>
              <td><fmt:formatNumber value="${list.count}" pattern="#,###"/></td>
              <td><fmt:formatNumber value="${list.count * list.price  - ((list.count * list.price) * (list.discount / 100))}" pattern="#,###"/></td>
            </tr>
             <input type="hidden" class="listpoint" value="${list.point}"/>
             <input type="hidden" class="listcount" value="${list.count}"/>
             <input type="hidden" class="listprice" value="${list.price}"/>
             <input type="hidden" class="listdelivery" value="${list.delivery}"/>
             <input type="hidden" class="listtotal" value="${list.total}"/>
             
            </c:forEach>
         
            
            <tr class="total">
                <td colspan="4"></td>
                <td>
                <table border="0">
                    <tr>
                    <td>총 상품금액</td>
                    <td><span><fmt:formatNumber value="${ordto.ordPrice}" pattern="#,###"/></span>원</td>
                    </tr>
                    <tr>
                    <td>총 할인금액</td>
                    <td><span><fmt:formatNumber value="${ordto.ordDelivery+ordto.usedPoint}" pattern="#,###"/></span>원</td>
                    </tr>
                    <tr>
                    <td>배송비</td>
                    <td><span><fmt:formatNumber value="${ordto.ordDiscount}" pattern="#,###"/></span>원</td>
                    </tr>
                    <tr>
                    <td>총 결제금액</td>
                    <td><span><fmt:formatNumber value="${ordto.ordTotPrice+1000}" pattern="#,###"/></span>원</td>
                    </tr>
                </table>                      
                </td>
            </tr>
            </table>
        </article>

        <!-- 주문정보 -->
        <article class="order">
            <h1>주문정보</h1>          
            <table border="0">
            <tr>
                <td>주문번호</td>
                <td><fmt:formatNumber value="${ordto.ordNo}" pattern="#,###"/></td>
                <td rowspan="3">총 결제금액</td>
                <td rowspan="3"><span><fmt:formatNumber value="${ordto.ordTotPrice}" pattern="#,###"/></span>원</td>
            </tr>
            <tr>
                <td>결제방법</td>
                
                <c:choose>
				    <c:when test="${ordto.ordPayment eq 1}">
				        <td>신용카드</td>
				    </c:when>
				    <c:when test="${ordto.ordPayment eq 2}">
				        <td>체크카드</td>
				    </c:when>
				    <c:when test="${ordto.ordPayment eq 3}">
				        <td>실시간 계좌이체</td>
				    </c:when>
				    <c:when test="${ordto.ordPayment eq 4}">
				        <td>무통장 입금</td>
				    </c:when>
				    <c:when test="${ordto.ordPayment eq 5}">
				        <td>휴대폰 결제</td>
				    </c:when>
				    <c:when test="${ordto.ordPayment eq 6}">
				        <td>카카오 페이</td>
				    </c:when>
				    <c:otherwise>
				        <td>결제 실패</td>
				    </c:otherwise>
				</c:choose>
                
            </tr>
            <tr>
                <td>주문자/연락처</td>
                <td>${ordto.recipName}/${ordto.recipHp}</td>
            </tr>
            </table>
        </article>

        <!-- 배송정보 -->
        <article class="delivery">
            <h1>배송정보</h1>
            <table border="0">
            <tr>
                <td>수취인</td>
                <td>${ordto.recipName}</td>                    
                <td>주문자 정보</td>
            </tr>
            <tr>
                <td>연락처</td>
                <td>${ordto.recipHp}</td>
                <td rowspan="2">
                ${ordto.recipName}<br/>
                ${ordto.recipHp}
                </td>
            </tr>
            <tr>
                <td>배송지 주소</td>
                <td>${ordto.recipAddr2}</td>
            </tr>
            </table>
        </article>

        <!-- 꼭 알아두세요. -->
        <article class="alert">
            <h1>꼭 알아두세요.</h1>
            <ul>
            <li><span>케이마켓은 통신판매중개자이며 통신판매의 당사자가 아닙니다. 따라서 케이마켓은 상품, 거래정보 및 거래에 대하여 책임을 지지 않습니다.</span></li>
            <li><span>구매주문내역, 배송상태 확인, 구매영수증 출력, 구매취소/반품/교환은 사이트 상단의 주문/배송조회에서 확인 할 수 있습니다.</span></li>
            <li><span>고객님의 주문이 체결된 후 상품품절 및 단종 등에 의해 배송이 불가능할 경우, 전자상거래등에서의 소비자 보호에 관한 법률 제15조 2항에 의거하여 3영업일(공휴일 제외) 이내에 자동으로 취소될 수 있으며, 이 경우 취소 안내 메일이 고객님께 발송되오니 양지 바랍니다.</span></li>
            <li><span>극히 일부 상품에 대해 수량부족, 카드결제승인 오류등의 사례가 간혹 있을 수 있으니 `나의쇼핑정보`에서 다시 한번 확인해 주세요.</span></li>
            <li><span>현금잔고로 구매하셨을 경우, 나의 쇼핑정보에서 입금확인이 되었는지를 다시 한번 확인해 주세요.</span></li>
            <li><span>배송주소를 추가하거나 변경, 삭제 등의 관리는 `나의쇼핑정보 > 나의정보` 에서 가능합니다.</span></li>
            </ul>
        </article>
    </section>
</main>
<%@ include file="../_footer.jsp" %>