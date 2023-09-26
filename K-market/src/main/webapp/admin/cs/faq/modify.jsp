<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../../_header.jsp" %>
<%@ include file="../../_aside.jsp" %>
<section id="cs">
  <div class="notice">
    <nav>
      <div>
        <p>수정사항</p>
      </div>
    </nav>
    <section class="write">
      <article>
        <form action="${ctxPath}/admin/cs/faq/modify.do" method="POST">
        <input type="hidden" name="writer" value="${faq.writer}">
        <input type="hidden" name="faqNo" value="${faq.faqNo}">
          <table>
            <tr>
              <td>공지유형</td>
              <td>
                <select name="cate1">
                  <option value="${faq.cate1}">
	                  <c:set var="cate1" value="${faq.cate1}"/>
                        <c:choose>
                            <c:when test="${cate1 eq 10}">회원</c:when>
                            <c:when test="${cate1 eq 20}">쿠폰/혜택/이벤트</c:when>
                            <c:when test="${cate1 eq 30}">주문/결제</c:when>
                            <c:when test="${cate1 eq 40}">배송</c:when>
                            <c:when test="${cate1 eq 50}">취소/반품/교환</c:when>
                            <c:when test="${cate1 eq 60}">여행/숙박/항공</c:when>
                            <c:when test="${cate1 eq 70}">안전거래</c:when>
                        </c:choose>
                  </option>
                </select>
              </td>
              <td>
                <select name="cate2">
                  <option value="${faq.cate2}">
	                  <c:set var="cate2" value="${faq.cate2}"/>
                        <c:choose>
                            <c:when test="${cate2 eq 1010}">가입</c:when>
                            <c:when test="${cate2 eq 1011}">탈퇴</c:when>
                            <c:when test="${cate2 eq 1012}">회원정보</c:when>
                            <c:when test="${cate2 eq 1013}">로그인</c:when>
                            <c:when test="${cate2 eq 2010}">쿠폰/할인혜택</c:when>
                            <c:when test="${cate2 eq 2011}">포인트</c:when>
                            <c:when test="${cate2 eq 2012}">제휴</c:when>
                            <c:when test="${cate2 eq 2013}">이벤트</c:when>
                            <c:when test="${cate2 eq 3010}">상품</c:when>
                            <c:when test="${cate2 eq 3011}">결제</c:when>
                            <c:when test="${cate2 eq 3012}">구매내역</c:when>
                            <c:when test="${cate2 eq 3013}">영수증/증빙</c:when>
                            <c:when test="${cate2 eq 4010}">배송상태/기간</c:when>
                            <c:when test="${cate2 eq 4011}">배송정보확인/변경</c:when>
                            <c:when test="${cate2 eq 4012}">해외배송</c:when>
                            <c:when test="${cate2 eq 4013}">당일배송</c:when>
                            <c:when test="${cate2 eq 4014}">해외직구</c:when>
                            <c:when test="${cate2 eq 5010}">반품신청/철회</c:when>
                            <c:when test="${cate2 eq 5011}">반품정보확인/변경</c:when>
                            <c:when test="${cate2 eq 5012}">교환 AS신청/철회</c:when>
                            <c:when test="${cate2 eq 5013}">교환정보확인/변경</c:when>
                            <c:when test="${cate2 eq 5014}">취소신청/철회</c:when>
                            <c:when test="${cate2 eq 5015}">취소확인/환불정보</c:when>
                            <c:when test="${cate2 eq 6010}">여행/숙박</c:when>
                            <c:when test="${cate2 eq 6011}">항공</c:when>
                            <c:when test="${cate2 eq 7010}">서비스 이용규칙 위반</c:when>
                            <c:when test="${cate2 eq 7011}">지식재산권침해</c:when>
                            <c:when test="${cate2 eq 7012}">법령 및 정책위반 상품</c:when>
                            <c:when test="${cate2 eq 7013}">게시물 정책위반</c:when>
                            <c:when test="${cate2 eq 7014}">직거래/외부거래유도</c:when>
                            <c:when test="${cate2 eq 7015}">표시광고</c:when>
                            <c:when test="${cate2 eq 7016}">청소년 위해상품/이미지</c:when>
                        </c:choose>
                  </option>
                </select>
              </td>
            </tr>
            <tr>
              <td>제목</td>                  
              <td>
                <input type="text" name="title" value="${faq.title}"/>
              </td>
            </tr>                
            <tr>
              <td>내용</td>                  
              <td>
                <textarea name="content">${faq.content}</textarea>
              </td>
            </tr>
          </table>
          <div>
            <a href="${ctxPath}/admin/cs/faq/list.do" class="btnList">취소하기</a>
            <input id="btnmodify" type="submit" class="btnSubmit" value="수정완료"/>
          </div>
        </form>
      </article>
    </section>
  </div>
</section>
<%@ include file="../../_footer.jsp" %>