<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
      <aside>
        <h2>공지사항</h2>
		<ul>
		    <li class="${cate eq null ? 'on' : '' }"><a href="/K-market/cs/notice/noticeList.do">전체</a></li>
		    <li class="${cate eq 'customer' ? 'on' : '' }"><a href="/K-market/cs/notice/noticeList.do?cate=customer">고객서비스</a></li>
		    <li class="${cate eq 'safety' ? 'on' : '' }"><a href="/K-market/cs/notice/noticeList.do?cate=safety">안전거래</a></li>
		    <li class="${cate eq 'product' ? 'on' : '' }"><a href="/K-market/cs/notice/noticeList.do?cate=product">위해상품</a></li>
		    <li class="${cate eq 'event' ? 'on' : '' }"><a href="/K-market/cs/notice/noticeList.do?cate=event">이벤트당첨</a></li>
		</ul>
      </aside>
      
    
      