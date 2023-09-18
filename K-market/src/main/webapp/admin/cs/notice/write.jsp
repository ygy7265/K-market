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
        <form action="${ctxPath}/admin/cs/notice/write.do" method="POST">
        <input type="text" name="writer" value="admin">
          <table>
            <tr>
              <td>공지유형</td>
              <td>
                <select name="cate">
                  <option value="0">선택</option>
                  <option value="customer">고객서비스</option>
                  <option value="safety">안전거래</option>
                  <option value="product">위해상품</option>
                  <option value="event">이벤트</option>
                </select>
              </td>
            </tr>
            <tr>
              <td>공지제목</td>                  
              <td>
                <input type="text" name="title" placeholder="제목을 입력하세요."/>
              </td>
            </tr>                
            <tr>
              <td>공지내용</td>                  
              <td>
                <textarea name="content" placeholder="내용을 입력하세요."></textarea>
              </td>
            </tr>
          </table>
          <div>
            <a href="/K-market/cs/qna/qnaList.do" class="btnList">취소하기</a>
            <input type="submit" class="btnSubmit" value="등록하기"/>
          </div>
        </form>
      </article>
    </section>
  </div>
</section>
<%@ include file="../../_footer.jsp" %>