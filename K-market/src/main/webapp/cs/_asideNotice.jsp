<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
      <aside>
        <h2>공지사항</h2>
		<ul>
		    <li class="<c:if test='${cate == null}'>on</c:if>"><a href="/K-market/cs/notice/noticeList.do">전체</a></li>
		    <li class="<c:if test='${cate eq "customer"}'>on</c:if>"><a href="/K-market/cs/notice/noticeList.do?cate=customer">고객서비스</a></li>
		    <li class="<c:if test='${cate eq "safety"}'>on</c:if>"><a href="/K-market/cs/notice/noticeList.do?cate=safety">안전거래</a></li>
		    <li class="<c:if test='${cate eq "product"}'>on</c:if>"><a href="/K-market/cs/notice/noticeList.do?cate=product">위해상품</a></li>
		    <li class="<c:if test='${cate eq "event"}'>on</c:if>"><a href="/K-market/cs/notice/noticeList.do?cate=event">이벤트당첨</a></li>
		</ul>
      </aside>
      
    
      