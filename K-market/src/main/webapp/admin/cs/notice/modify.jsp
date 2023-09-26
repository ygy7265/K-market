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
        <form action="${ctxPath}/admin/cs/notice/modify.do" method="POST">
        <input type="hidden" name="writer" value="${notice.writer}">
        <input type="hidden" name="noticeNo" value="${notice.noticeNo}">
          <table>
            <tr>
              <td>공지유형</td>
              <td>
                <select name="cate" style="width: auto;">
                  <option value="${cate}">
	                  <c:set var="cate" value="${cate}"/>
                        <c:choose>
                            <c:when test="${cate eq '01'}">고객서비스</c:when>
                            <c:when test="${cate eq '02'}">안전거래</c:when>
                            <c:when test="${cate eq '03'}">위해상품</c:when>
                            <c:when test="${cate eq '04'}">이벤트당첨</c:when>
                        </c:choose>
                  </option>
                </select>
              </td>
            </tr>
            <tr>
              <td>제목</td>                  
              <td>
                <input type="text" name="title" value="${title}"/>
              </td>
            </tr>                
            <tr>
              <td>내용</td>                  
              <td>
                <textarea name="content">${content}</textarea>
              </td>
            </tr>
          </table>
          <div>
            <a href="${ctxPath}/admin/cs/notice/list.do" class="btnList">취소하기</a>
            <input id="btnmodify" type="submit" class="btnSubmit" value="수정완료"/>
          </div>
        </form>
      </article>
    </section>
  </div>
</section>

<%@ include file="../../_footer.jsp" %>