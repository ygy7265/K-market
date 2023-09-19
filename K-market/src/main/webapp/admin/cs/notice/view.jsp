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
        <input type="text" name="${notice.writer}" value="${notice.writer}">
          <table>
            <tr>
              <td>공지유형</td>
              <td>
                <select name="cate">
                  <option value="${notice.cate}">${notice.cate}</option>
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