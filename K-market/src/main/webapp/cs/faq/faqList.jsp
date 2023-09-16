<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../_header.jsp" %>
<section id="cs">
  <div class="faq">
    <nav>
      <div>
        <p>
        	홈<span>></span>자주묻는 질문<span>></span>
        	<c:choose>
        		<c:when test="${param.cate1 == '10'}">
		    		회원
		    	</c:when>
			    <c:when test="${param.cate1 == '20'}">
			        쿠폰/이벤트
			    </c:when>
			    <c:when test="${param.cate1 == '30'}">
			        주문/결제
			    </c:when>
			    <c:when test="${param.cate1 == '40'}">
			        배송
			    </c:when>
			    <c:when test="${param.cate1 == '50'}">
			        취소/반품/교환
			    </c:when>
			    <c:when test="${param.cate1 == '60'}">
			        여행/숙박/항공
			    </c:when>
			    <c:when test="${param.cate1 == '70'}">
			        안전거래
			    </c:when>
			</c:choose>
        </p>
      </div>
    </nav>
    <section class="list">
	<jsp:include page="../_asideFaq.jsp"/>
     <article>   
        <nav>
          <c:choose>
       		<c:when test="${param.cate1 == '10'}">
       			<h1>회원</h1>
	    	</c:when>
		    <c:when test="${param.cate1 == '20'}">
		        <h1>쿠폰/이벤트</h1>
		    </c:when>
		    <c:when test="${param.cate1 == '30'}">
		        <h1>주문/결제</h1>
		    </c:when>
		    <c:when test="${param.cate1 == '40'}"> 
		        <h1>배송</h1>
		    </c:when>
		    <c:when test="${param.cate1 == '50'}">
		        <h1>취소/반품/교환</h1>
		    </c:when>
		    <c:when test="${param.cate1 == '60'}">
		        <h1>여행/숙박/항공</h1>
		    </c:when>
		    <c:when test="${param.cate1 == '70'}">
		        <h1>안전거래</h1>
		    </c:when>
		</c:choose>
          <h2>가장 자주 묻는 질문입니다.</h2>
        </nav>
        <div>
        <c:forEach var ="cate1" items="${cate1}">
          <h3>${cate1.cate2}</h3>
          	<ul>
	          	<li><a href="/K-market/cs/faq/faqview.do?cate1=${faqs.cate1}&cate2=${faqs.cate2}"><span>Q.</span>${faq.title}</a></li>
            	<li class="more"><a href="#">더보기</a></li>
            </ul>
        </c:forEach>
        </div>
        <div>
          <h3>탈퇴</h3>
          <ul>
            <li><a href="/K-market/cs/faq/faqview.do"><span>Q.</span>회원탈퇴 후 재가입이 가능한가요?</a></li>
            <li><a href="/K-market/cs/faq/faqview.do"><span>Q.</span>회원탈퇴 후 재가입이 가능한가요?</a></li>
            <li><a href="/K-market/cs/faq/faqview.do"><span>Q.</span>회원탈퇴 후 재가입이 가능한가요?</a></li>
            <li><a href="/K-market/cs/faq/faqview.do"><span>Q.</span>회원탈퇴 후 재가입이 가능한가요?</a></li>
            <li><a href="/K-market/cs/faq/faqview.do"><span>Q.</span>회원탈퇴 후 재가입이 가능한가요?</a></li>
            <li class="more"><a href="#">더보기</a></li>
          </ul>
        </div>
        <div>
          <h3>회원정보</h3>
          <ul>
            <li><a href="/K-market/cs/faq/faqview.do"><span>Q.</span>회원정보를 수정하고 싶어요.</a></li>
            <li><a href="/K-market/cs/faq/faqview.do"><span>Q.</span>회원정보를 수정하고 싶어요.</a></li>
            <li><a href="/K-market/cs/faq/faqview.do"><span>Q.</span>회원정보를 수정하고 싶어요.</a></li>
            <li><a href="/K-market/cs/faq/faqview.do"><span>Q.</span>회원정보를 수정하고 싶어요.</a></li>
            <li><a href="/K-market/cs/faq/faqview.do"><span>Q.</span>회원정보를 수정하고 싶어요.</a></li>
            <li class="more"><a href="#">더보기</a></li>
          </ul>
        </div>
        <div>
          <h3>로그인</h3>
          <ul>
            <li><a href="/K-market/cs/faq/faqview.do"><span>Q.</span>로그인에 문제가 있어요.</a></li>
            <li><a href="/K-market/cs/faq/faqview.do"><span>Q.</span>로그인에 문제가 있어요.</a></li>
            <li><a href="/K-market/cs/faq/faqview.do"><span>Q.</span>로그인에 문제가 있어요.</a></li>
            <li><a href="/K-market/cs/faq/faqview.do"><span>Q.</span>로그인에 문제가 있어요.</a></li>
            <li><a href="/K-market/cs/faq/faqview.do"><span>Q.</span>로그인에 문제가 있어요.</a></li>
            <li class="more"><a href="#">더보기</a></li>
          </ul>
        </div>

      </article>
    </section>
  </div>
</section>
<%@ include file="../../_footer.jsp" %>
      
