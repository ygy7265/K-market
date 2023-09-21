<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
      <aside>
        <h2>공지사항</h2>
		<ul>
		    <li class="${cate eq null ? 'on' : '' }"><a href="/K-market/cs/notice/noticeList.do">전체</a></li>
		    <li class="${cate eq '01' ? 'on' : '' }"><a href="/K-market/cs/notice/noticeList.do?cate=01">고객서비스</a></li>
		    <li class="${cate eq '02' ? 'on' : '' }"><a href="/K-market/cs/notice/noticeList.do?cate=02">안전거래</a></li>
		    <li class="${cate eq '03' ? 'on' : '' }"><a href="/K-market/cs/notice/noticeList.do?cate=03">위해상품</a></li>
		    <li class="${cate eq '04' ? 'on' : '' }"><a href="/K-market/cs/notice/noticeList.do?cate=04">이벤트당첨</a></li>
		</ul>
      </aside>
      
    
      