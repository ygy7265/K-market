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
        <form action="${ctxPath}/admin/cs/notice/modify.do" method="POST">
        <input type="hidden" name="writer" value="${writer}">
        <input type="hidden" name="noticeNo" value="${noticeNo}">
          <table>
            <tr>
              <td>공지유형</td>
              <td>
                <select name="cate">
                  <option>선택</option>
                  <option value="10">회원</option>
                  <option value="20">쿠폰/혜택/이벤트</option>
                  <option value="30">주문/결제</option>
                  <option value="40">배송</option>
                  <option value="50">취소/반품/교환</option>
                  <option value="60">여행/숙박/항공</option>
                  <option value="70">안전거래</option>
                </select>
              </td>
            </tr>
            <tr>
              <td>공지제목</td>                  
              <td>
                <input type="text" name="title" value="${title}"/>
              </td>
            </tr>                
            <tr>
              <td>공지내용</td>                  
              <td>
                <textarea name="content">${content}</textarea>
              </td>
            </tr>
          </table>
          <div>
            <a href="${ctxPath}/admin/cs/notice/list.do" class="btnList">취소하기</a>
            <input type="submit" class="btnSubmit" value="수정완료"/>
          </div>
        </form>
      </article>
    </section>
  </div>
</section>

<%@ include file="../../_footer.jsp" %>