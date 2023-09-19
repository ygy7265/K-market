<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../../_header.jsp" %>
<%@ include file="../../_aside.jsp" %>
<section id="cs">
  <div class="notice">
    <nav>
      <div>
        <p>공지사항</p>
      </div>
    </nav>
    <section class="write">
      <article>
        <form action="${ctxPath}/admin/cs/notice/modify.do" method="get">
        <input type="hidden" name="writer" value="${notice.writer}">
        <input type="hidden" name="noticeNo" value="${notice.noticeNo}">
          <table>
            <tr>
              <td>공지유형</td>
              <td>
                <select name="cate">
                  <option value="${notice.cate}">
	                  <c:set var="cate" value="${notice.cate}"/>
                        <c:choose>
                            <c:when test="${cate == 10}">회원</c:when>
                            <c:when test="${cate == 20}">쿠폰/혜택/이벤트</c:when>
                            <c:when test="${cate == 30}">주문/결제</c:when>
                            <c:when test="${cate == 40}">배송</c:when>
                            <c:when test="${cate == 50}">취소/반품/교환</c:when>
                            <c:when test="${cate == 60}">여행/숙박/항공</c:when>
                            <c:when test="${cate == 70}">안전거래</c:when>
                        </c:choose>               
                  </option>
                </select>
              </td>
            </tr>
            <tr>
              <td>공지제목</td>                  
              <td>
                <input type="text" name="title" readonly value="${notice.title}"/>
              </td>
            </tr>                
            <tr>
              <td>공지내용</td>                  
              <td>
                <textarea name="content" readonly >${notice.content}</textarea>
              </td>
            </tr>
          </table>
          <div>
            <a href="${ctxPath}/admin/cs/notice/list.do" class="btnList">취소하기</a>
            <input type="submit" class="btnSubmit" value="수정하기"/>
          </div>
        </form>
      </article>
    </section>
  </div>
</section>
<%@ include file="../../_footer.jsp" %>