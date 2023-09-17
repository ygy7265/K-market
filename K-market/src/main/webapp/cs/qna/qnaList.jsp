<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../_header.jsp" %>
<!-- 
  	날짜 : 2023/09/17
   	이름 : 이현정
  	내용 : 문의하기-리스트 (QnA/list) 기능 구현
 -->
<script>
	const success = new URL(location.href).searchParams.get('success');
	
	if(success == 102){
		alert('글 작성에 실패하셨습니다. 다시 시도하십시오');
	}else if(success == 200){
		alert('성공적으로 글이 등록 되었습니다.');
	}

</script>
<section id="cs">
  <div class="qna">
    <nav>
      <div>
        <p>
	       	홈<span>></span>문의하기<span>></span>
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
     <jsp:include page="../_asideQna.jsp"/>
      <article>
        <nav>
           <c:choose>
           	<c:when test="${param.cate1 == null}">
       			<h1>전체</h1>
	    	</c:when>
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
          <h2>관련 문의 내용입니다.</h2>
        </nav>
        <table>
        <c:forEach var="qna" items="${qnas}">
          <tr>
            <td><a href="/K-market/cs/qna/qnaView.do">[가입] ${qna.title}</a></td>
            <td>${qna.writer}</td>
            <td>${qna.rdate}</td>
          </tr>
		</c:forEach>
        </table>

 		<div class="page">
       		<c:if test="${pageGroupStart > 1}">
          		<a href="/K-market/cs/qna/qnaList.do?cate1=${cate1}&pg=${pageGroupStart - 1}" class="prev">이전</a>
	        </c:if>
	        <c:if test="${pageGroupStart eq 1 }">
                <a href="/K-market/cs/qna/qnaList.do?cate1=${cate1}&pg=1" class="prevOff">이전</a>
            </c:if>
	        <c:forEach var="i" begin="${pageGroupStart}" end="${pageGroupEnd}" step="1">
	        	<c:set var="isOn" value="${currentPage == i}"/>
         		<a href="/K-market/cs/qna/qnaList.do?cate1=${cate1}&pg=${i}" 
         		class="num ${isOn ? 'on' : ''}">${i}</a>
	       </c:forEach>
	       <c:if test="${pageGroupEnd < lastPageNum}">
          		<a href="/K-market/cs/qna/qnaList.do?cate1=${cate1}&pg=${pageGroupEnd + 1}" class="next">다음</a>
          </c:if>
        </div>

        <a href="/K-market/cs/qna/qnaWrite.do?cate1=${cate1}" class="btnWrite">문의하기</a>

      </article>
    </section>
  </div>
</section>
<%@ include file="../../_footer.jsp" %>
