<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../../_header.jsp" %>
<%@ include file="../../_aside.jsp" %>
<section id="cs">
  <div class="notice">
    <nav>
      <div>
        <p>문의사항</p>
      </div>
    </nav>
    <section class="write">
      <article>
        <form action="${ctxPath}/admin/cs/faq/modify.do" method="GET">
        <input type="hidden" name="writer" value="${qna.writer}">
        <input type="hidden" name="faqNo" value="${qna.qnaNo}">
          <table>
            <tr>
              <td>문의유형</td>
              <td>
              <c:set var="cate1" value="${qna.cate1}"/>
	              <c:choose>
	                  <c:when test="${cate1 eq 10}">회원</c:when>
	                  <c:when test="${cate1 eq 20}">쿠폰/혜택/이벤트</c:when>
	                  <c:when test="${cate1 eq 30}">주문/결제</c:when>
	                  <c:when test="${cate1 eq 40}">배송</c:when>
	                  <c:when test="${cate1 eq 50}">취소/반품/교환</c:when>
	                  <c:when test="${cate1 eq 60}">여행/숙박/항공</c:when>
	                  <c:when test="${cate1 eq 70}">안전거래</c:when>
	              </c:choose>
	              - ${qna.cate2}
              </td>
            </tr>
            <tr>
              <td>제목</td>                  
              <td>
                <input type="text" name="title" readonly value="${qna.title}"/>
              </td>
            </tr>
            <tr>
              <td>내용</td>                  
              <td>
                <textarea name="content" readonly >${qna.content}</textarea>
              </td>
            </tr>
            <tr>
              <td>답변</td>
              <td>
                <textarea name="reply" readonly >${qna.reply}</textarea>
              </td>
            </tr>
          </table>
          <div>
            <a href="${ctxPath}/admin/cs/qna/delete.do?qnaNo=${qna.qnaNo}" class="btnList">삭제하기</a>
            <a href="${ctxPath}/admin/cs/qna/list.do" class="btnList">취소하기</a>
            <input id="btnmodify" type="submit" class="btnSubmit" value="수정하기"/>
          </div>
        </form>
      </article>
    </section>
  </div>
</section>
<%@ include file="../../_footer.jsp" %>