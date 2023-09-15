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
        <p>홈<span>></span>공지사항</p>
      </div>
    </nav>
    <section class="list">
     <jsp:include page="../_asideNotice.jsp"/>
      <article>
        <nav>
          <h1>전체</h1>
          <h2>공지사항 전체 내용입니다.</h2>
        </nav>

        <table>
        <c:forEach var ="notice" items="${notices}">
          <tr>
            <td><a href="/K-market/cs/notice/noticeView.do?cate=${cate}">[안내]${notice.title}</a></td>
            <td>${notice.rdate}</td>
          </tr>
        <c:set var="pageStartNum" value="${pageStartNum - 1}" />
		</c:forEach>
        </table>
		<!-- 페이지 네비게이션 -->
        <div class="page">
       		<c:if test="${pageGroupStart > 1}">
          		<a href="/K-market/cs/notice/noticeList.do?cate=${cate}&pg=${pageGroupStart - 1}" class="prev">이전</a>
	        </c:if>
	        <c:forEach var="i" begin="${pageGroupStart}" end="${pageGroupEnd}" step="1">
	        	<c:set var="isOn" value="${currentPage == i}"/>
         		<a href="/K-market/cs/notice/noticeList.do?cate=${cate}&pg=${i}" class="num ${isOn ? 'on' : ''}">${i}</a>
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