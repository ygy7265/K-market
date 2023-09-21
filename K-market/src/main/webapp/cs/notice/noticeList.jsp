<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../_header.jsp" %>  
		<!-- 
			날짜 : 2023/09/14
			이름 : 이현정
			내용 : CS_Notice 기능구현
		 -->
<section id="cs">
  	<div class="notice">
 	<nav>
      <div>
        <p>
        	홈<span>></span>공지사항<span>></span>
        	<c:choose>
        		<c:when test="${cate == null}">
        			전체
		    	</c:when>
			    <c:when test="${cate eq '01'}">
			        고객서비스
			    </c:when>
			    <c:when test="${cate eq '02'}">
			        안전거래
			    </c:when>
			    <c:when test="${cate eq '03'}">
			        위해상품
			    </c:when>
			    <c:when test="${cate eq '04'}">
			        이벤트당첨
			    </c:when>
			</c:choose>
        </p>
      </div>
    </nav>
  	<section class="list">	
     <jsp:include page="../_asideNotice.jsp"/>
     <article>
    	<nav>
    	<c:choose>
         	 	<c:when test="${cate == null}">
			        <h1>공지사항</h1>
			    </c:when>
			    <c:when test="${cate eq '01'}">
			        <h1>고객서비스</h1>
			    </c:when>
			    <c:when test="${cate eq '02'}">
			       <h1>안전거래</h1>
			    </c:when>
			    <c:when test="${cate eq '03'}">
			        <h1>위해상품</h1>
			    </c:when>
			    <c:when test="${cate eq '04'}">
			        <h1>이벤트당첨</h1>
			    </c:when>
			</c:choose>
          <h2>
         	<c:choose>
         	 	<c:when test="${cate == null}">
			        공지사항
			    </c:when>
			    <c:when test="${cate eq '01'}">
			        고객서비스
			    </c:when>
			    <c:when test="${cate eq '02'}">
			        안전거래
			    </c:when>
			    <c:when test="${cate eq '03'}">
			        위해상품
			    </c:when>
			    <c:when test="${cate eq '04'}">
			        이벤트당첨
			    </c:when>
			</c:choose>
          	전체 내용입니다.
          </h2>
        </nav>
        <table>
        <c:forEach var ="notice" items="${notices}">
          <tr>
            <td><a href="/K-market/cs/notice/noticeView.do?cate=${cate}&noticeNo=${notice.noticeNo}">[안내]${notice.title}</a></td>
            <td>${notice.formatDate()}</td>
          </tr>
		</c:forEach>
        </table>
		<!-- 페이지 네비게이션 -->
        <div class="page">
       		<c:if test="${pageGroupStart > 1}">
          		<a href="/K-market/cs/notice/noticeList.do?cate=${cate}&pg=${pageGroupStart - 1}" class="prev">이전</a>
	        </c:if>
	        <c:forEach var="i" begin="${pageGroupStart}" end="${pageGroupEnd}" step="1">
	        	<c:set var="isOn" value="${currentPage == i}"/>
         		<a href="/K-market/cs/notice/noticeList.do?cate=${cate}&pg=${i}" 
         		class="num ${isOn ? 'on' : ''}">${i}</a>
	       </c:forEach>
	       <c:if test="${pageGroupEnd < lastPageNum}">
          		<a href="/K-market/cs/notice/noticeList.do?cate=${cate}&pg=${pageGroupEnd + 1}" class="next">다음</a>
          </c:if>
        </div>
      </article>
    </section>
  </div>
</section>
  
<%@ include file="../../_footer.jsp" %>