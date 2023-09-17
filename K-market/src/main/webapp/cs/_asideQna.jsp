<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
      <aside>
        <h2>문의하기</h2>
        <ul>
         	<li class="${param.cate1 == '10' ? 'on' : '' }"><a href="/K-market/cs/qna/qnaList.do?cate1=10">회원</a></li>
         	<li class="${param.cate1 == '20' ? 'on' : '' }"><a href="/K-market/cs/qna/qnaList.do?cate1=20">쿠폰/이벤트</a></li>
          	<li class="${param.cate1 == '30' ? 'on' : '' }"><a href="/K-market/cs/qna/qnaList.do?cate1=30">주문/결제</a></li>
          	<li class="${param.cate1 == '40' ? 'on' : '' }"><a href="/K-market/cs/qna/qnaList.do?cate1=40">배송</a></li>
          	<li class="${param.cate1 == '50' ? 'on' : '' }"><a href="/K-market/cs/qna/qnaList.do?cate1=50">취소/반품/교환</a></li>
          	<li class="${param.cate1 == '60' ? 'on' : '' }"><a href="/K-market/cs/qna/qnaList.do?cate1=60">여행/숙박/항공</a></li>
          	<li class="${param.cate1 == '70' ? 'on' : '' }"><a href="/K-market/cs/qna/qnaList.do?cate1=70">안전거래</a></li>
        </ul>
      </aside>
 