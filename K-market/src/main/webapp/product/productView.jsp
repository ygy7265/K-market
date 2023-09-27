<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.Date"%>
<%@ page import="java.text.SimpleDateFormat"%>
<!-- 
	이름 : 윤경엽
	내용 : 상품 주문하기 구현
	날짜 : 2023/09/14
 -->
<%@ include file="./_header.jsp" %>
<main id="product">
<%@ include file="../_aside.jsp" %>
<script>
$(function(){
	$('.cart').click(function(e){
		e.preventDefault();
		
		var userSession = sessionStorage.getItem("memberdto");
	    var result = confirm("장바구니에 담으시겠습니까?");
			if (result === true) {
			    // 확인 버튼이 클릭된 경우
				 $('.buy').submit();
			} else {
			    // 취소 버튼이 클릭된 경우
			}	
		  
	})
	$('.order').click(function(e){
		e.preventDefault();
		
		var userSession = sessionStorage.getItem("memberdto");
	    var result = confirm("구매하시겠습니까?");
			if (result === true) {
				var input = $("<input>")
			    .attr("type", "hidden")
			    .attr("name", "buytype")
			    .val("buytype");
				$('.buy').append(input);

			    // 확인 버튼이 클릭된 경우
				 $('.buy').attr('action', '/K-market/product/productorder.do');
				 $('.buy').submit();
			} else {
			    // 취소 버튼이 클릭된 경우
			}	
		  
	})
    let num = 1;
    let price = ${proddto.price};
    let delivery = ${proddto.delivery};
    let discount = ${proddto.discount};
    let discountPrice = price - (price * discount/100) 
    // 초기 토탈 값 설정
    updateTotal();

    $('.increase').click(function(){
        num++;
        $('input[name=num]').val(num);
        updateTotal(); // num이 증가할 때마다 total 업데이트
    });

    $('.decrease').click(function(){
        if(num > 1){
            num--;
            $('input[name=num]').val(num);
            updateTotal(); // num이 감소할 때마다 total 업데이트
        }
    });

    function updateTotal() {
        let count = num;
        let total = discountPrice * count;
        let nodiscount = price * count;
        $('.total2').text(Math.round(total).toLocaleString());
        $('.total3').val(Math.round(total));
        $('.nodiscount').text(total.toLocaleString());
        $('.nodiscount').val(nodiscount);
    }

    $('.btnOrder').click(function(e){
        e.preventDefault();
        $('#formOrder').submit();
    });
    
    $('.btnOrder').click(function(e){
        e.preventDefault();
        $('#formOrder').submit();
    });
    
    $('.discount_price').text(Math.round(discountPrice).toLocaleString());
    
});
</script>
    </aside>
      <!-- 상품 상세페이지 시작 -->
      <section class="view">

        <!-- 제목, 페이지 네비게이션 -->
        <nav>
            <h1>상품보기</h1>
            <p>
                HOME > <span>패션·의류·뷰티</span> > <strong>남성의류</strong>
            </p>
        </nav>

        <!-- 상품 전체 정보 내용 -->
        
        <article class="info">
            <div class="image">
                <img src="../admin/thumbAll/${proddto.thumb3}" alt="상품이미지"/>
            </div>
            <div class="summary">
                <nav>
                    <h1>${proddto.seller}</h1>
                    <h2>상품번호&nbsp;:&nbsp;<span>${proddto.prodNo}</span></h2>
                </nav>                        
                <nav>
                    <h3>${proddto.prodName}</h3>
                    <p>${proddto.descript}</p>
                    <h5 class="rating star${proddto.score}"><a href="#">상품평보기</a></h5>
                </nav>
                <nav>
                    <div class="org_price">
                        <del><fmt:formatNumber value="${proddto.price}" pattern="#,###"/></del>
                        <span><fmt:formatNumber value="${proddto.discount}" pattern="#,###"/>%</span>
                    </div>
                    <div class="dis_price">
                        <ins class="discount_price"><fmt:formatNumber value="${proddto.price}" pattern="#,###" /></ins>
                    </div>
                   
                </nav>
                <nav>
				<%-- 현재 날짜 가져오기 --%>
				<c:set var="currentDate" value="${currentDate}"/>
				
				<%-- 3일을 더한 날짜 --%>
				<c:set var="threeDaysLater" value="${threeDaysLater}"/>
				
				<%-- 요일을 계산 --%>
				<fmt:formatDate var="dayOfWeek" value="${threeDaysLater}" pattern="EEE"/>
				
				<c:set var="dateFormat" value="dd "/>
				<c:set var="dateFormatMM" value="MM "/>
				<c:set var="formattedDate">
				    <fmt:formatDate value="${currentDate}" pattern="${dateFormat}"/>
				</c:set>
				<c:set var="formattedDateMM">
				    <fmt:formatDate value="${currentDate}" pattern="${dateFormatMM}"/>
				</c:set>
				
				<span class="delivery"><fmt:formatNumber value="${proddto.delivery}" pattern="#,###"/></span>
				<span class="arrival">모레(<c:out value="${dayOfWeek}" />)  <c:out value="${formattedDateMM}/${formattedDate+3}"/> 도착예정</span>
                    <span class="desc">본 상품은 국내배송만 가능합니다.</span>
                </nav>
                <nav>
                    <span class="card cardfree"><i>아이콘</i>무이자할부</span>&nbsp;&nbsp;
                    <span class="card cardadd"><i>아이콘</i>카드추가혜택</span>
                </nav>
                <nav>
                    <span class="origin">원산지-상세설명 참조</span>
                </nav>
                <img src="/K-market/images/vip_plcc_banner.png" alt="100원만 결제해도 1만원 적립!" class="banner" />
                
                <div class="count">
                    <button type="button" class="decrease">-</button>
                    <input type="number" name="num" value="1" readonly/>
                    <button type="button" class="increase">+</button>
                </div>
                
                <div class="total">
                    <span class="total2">${proddto.price}</span>
                    <em>총 상품금액</em>
                </div>
				<form action="/K-market/product/productcart.do" method="POST" class="buy">
				    <input type="hidden" name="uid" value="${memberdto.uid }" />
				    <input type="hidden" name="prodNo" value="${proddto.prodNo}" />
				    <input type="hidden" name="prodName" value="${proddto.prodName}" />
				    <input type="hidden" name="descript" value="${proddto.descript}" />
				    <input type="hidden" name="price" value="${proddto.price}" />
				    <input type="hidden" name="point" value="${proddto.point}" />
				    <input type="hidden" name="num" value="1" readonly/>
				    <input type="hidden" name="discount" value="${proddto.discount}" />
				    <input type="hidden" name="delivery" value="${proddto.delivery}" />
				    <input type="hidden" class="total3" name="total3"/>
				    <input type="hidden" class="nodiscount" name="nodiscount"/>
    				<div class="button">
       					<input type="submit" class="cart"  value="장바구니"/>
        				<input type="submit" class="order" value="구매하기"/>
   				 	</div>
				</form>
            </div>
        </article>
		
        <!-- 상품 정보 내용 -->
        <article class="detail">
            <nav>
                <h1>상품정보</h1>
            </nav>
            <!-- 상품상세페이지 이미지 -->
            <img src="../admin/thumbAll/${proddto.detail}" alt="상세페이지1">

        </article>

        <!-- 상품 정보 제공 고시 내용 -->
        <article class="notice">
            <nav>
                <h1>상품 정보 제공 고시</h1>
                <p>[전자상거래에 관한 상품정보 제공에 관한 고시] 항목에 의거 등록된 정보입니다.</p>
            </nav>
            <table border="0">
                <tr>
                    <td>상품번호</td>
                    <td>${proddto.prodNo}</td>
                </tr>
                <tr>
                    <td>상품상태</td>
                    <td>${proddto.status}</td>
                </tr>
                <tr>
                    <td>부가세 면세여부</td>
                    <td>${proddto.duty}</td>
                </tr>
                <tr>
                    <td>영수증발행</td>
                    <td>${proddto.receipt}</td>
                </tr>
                <tr>
                    <td>사업자구분</td>
                    <td>${proddto.bizType}</td>
                </tr>
                <tr>
                    <td>브랜드</td>
                    <td>블루포스</td>
                </tr>
                <tr>
                    <td>원산지</td>
                    <td>국내생산</td>
                </tr>
            </table>
            <table border="0">
                <tr>
                    <td>제품소재</td>
                    <td>상세정보 직접입력</td>
                </tr>
                <tr>
                    <td>색상</td>
                    <td>상세정보 직접입력</td>
                </tr>
                <tr>
                    <td>치수</td>
                    <td>상세정보 직접입력</td>
                </tr>
                <tr>
                    <td>제조자/수입국</td>
                    <td>상세정보 직접입력</td>
                </tr>
                <tr>
                    <td>제조국</td>
                    <td>상세정보 직접입력</td>
                </tr>
                <tr>
                    <td>취급시 주의사항</td>
                    <td>상세정보 직접입력</td>
                </tr>
                <tr>
                    <td>제조연월</td>
                    <td>상세정보 직접입력</td>
                </tr>
                <tr>
                    <td>품질보증기준</td>
                    <td>상세정보 직접입력</td>
                </tr>
                <tr>
                    <td>A/S 책임자와 전화번호</td>
                    <td>상세정보 직접입력</td>
                </tr>
                <tr>
                    <td>주문후 예상 배송기간</td>
                    <td>상세정보 직접입력</td>
                </tr>
                <tr>
                <td colspan="2">구매, 교환, 반품, 배송, 설치 등과 관련하여 추가비용, 제한조건 등의 특이사항이 있는 경우</td>
                </tr>
            </table>
            <p class="notice">
                소비자가 전자상거래등에서 소비자 보호에 관한 법률 제 17조 제1항 또는 제3항에 따라 청약철회를 하고
                동법 제 18조 제1항 에 따라 청약철회한 물품을 판매자에게 반환하였음에도 불구 하고 결제 대금의
                환급이 3영업일을 넘게 지연된 경우, 소비자 는 전자상거래등에서 소비자보호에 관한 법률 제18조
                제2항 및 동법 시행령 제21조 2에 따라 지연일수에 대하여 전상법 시행령으로 정하는 이율을 곱하여
                산정한 지연이자(“지연배상금”)를 신청할 수 있습니다. 아울러, 교환∙반품∙보증 및 결제대금의
                환급신청은 [나의쇼핑정보]에서 하실 수 있으며, 자세한 문의는 개별 판매자에게 연락하여 주시기 바랍니다.
            </p>
        </article>
        
        <!-- 상품 리뷰 내용 -->
        <article class="review">
            <nav>
                <h1>상품리뷰</h1>
            </nav>
			<ul>
			    <c:choose>
			        <c:when test="${empty reviews}">
			            <li>
			                <p>아직 리뷰가 존재하지 않습니다.</p>
			            </li>
			        </c:when>
			        <c:otherwise>
			            <c:forEach var="review" items="${reviews}">
			                <li>
			                    <div>
			                        <h5 class="rating star${review.rating}"></h5>
			                        <span>
			                            <c:out value="${fn:substring(review.uid, 0, fn:length(review.uid) - 3)}"/>***&nbsp;${review.formatDate()}
			                        </span>
			                    </div>
			                    <h3>${review.prodName}</h3>
			                    <p>
			                        ${review.content}
			                    </p>
			                </li>
			            </c:forEach>
			        </c:otherwise>
			    </c:choose>
			</ul>
			<div class="paging">
            	<c:if test="${pageGroupStart > 1}">
          		<span class="prev"><a href="/K-market/product/productview.do?prodNo=${prodNo}&pg=${pageGroupStart - 1}"><&nbsp;이전</a></span>
	        </c:if>
	        <c:forEach var="i" begin="${pageGroupStart}" end="${pageGroupEnd}" step="1">
	        	<c:set var="isOn" value="${currentPage == i}"/>
         		<span class="num ${isOn ? 'on' : ''}"><a href="/K-market/product/productview.do?prodNo=${prodNo}&pg=${i}" 
         		 >${i}</a></span>
	       </c:forEach>
	       <c:if test="${pageGroupEnd < lastPageNum}">
          		<span  class="next"><a href="/K-market/product/productview.do?prodNo=${prodNo}&pg=${pageGroupEnd + 1}">다음&nbsp;></a></span>
          </c:if>
        </div>
        </article>
    </section>
    <!-- 상품 상세페이지 끝 -->
</main>
<%@ include file="../_footer.jsp" %>