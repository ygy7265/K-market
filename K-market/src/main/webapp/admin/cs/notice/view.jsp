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
        <form action="${ctxPath}/admin/cs/notice/modify.do" method="GET">
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
                <input type="text" name="title" readonly value="${notice.title}"/>
              </td>
            </tr>                
            <tr>
              <td>내용</td>                  
              <td>
                <textarea name="content" readonly >${notice.content}</textarea>
              </td>
            </tr>
          </table>
          <div>
            <a href="${ctxPath}/admin/cs/notice/delete.do?noticeNo=${notice.noticeNo}" class="btnList">삭제하기</a>
            <a href="${ctxPath}/admin/cs/notice/list.do" class="btnList">취소하기</a>
            <input style="padding: 0;" type="submit" class="btnSubmit" value="수정하기"/>
          </div>
        </form>
      </article>
    </section>
  </div>
</section>
<%@ include file="../../_footer.jsp" %>