<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
      <aside>
        <h2>공지사항</h2>
		<ul>
		    <li class="${cate eq null ? 'on' : '' }"><a href="/K-market/cs/notice/noticeList.do">전체</a></li>
		    <li class="${cate eq '10' ? 'on' : '' }"><a href="/K-market/cs/notice/noticeList.do?cate=10">고객서비스</a></li>
		    <li class="${cate eq '70' ? 'on' : '' }"><a href="/K-market/cs/notice/noticeList.do?cate=70">안전거래</a></li>
		    <li class="${cate eq '50' ? 'on' : '' }"><a href="/K-market/cs/notice/noticeList.do?cate=50">위해상품</a></li>
		    <li class="${cate eq '20' ? 'on' : '' }"><a href="/K-market/cs/notice/noticeList.do?cate=20">이벤트당첨</a></li>
		</ul>
      </aside>
      
    
      