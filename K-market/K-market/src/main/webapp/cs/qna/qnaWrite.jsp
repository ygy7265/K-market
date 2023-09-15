<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../_header.jsp" %>
<section id="cs">
  <div class="qna">
    <nav>
      <div>
        <p>홈<span>></span>문의하기</p>
      </div>
    </nav>
    <section class="write">
  	<jsp:include page="../_asideQna.jsp"/>
      <article>
        <form action="#">
          <table>
            <tr>
              <td>문의유형</td>
              <td>
                <select name="type">
                  <option value="0">선택</option>
                  <option>가입</option>
                  <option>탈퇴</option>
                  <option>회원정보</option>
                  <option>로그인</option>
                </select>
              </td>
            </tr>
            <tr>
              <td>문의제목</td>                  
              <td>
                <input type="text" name="title" placeholder="제목을 입력하세요."/>
              </td>
            </tr>                
            <tr>
              <td>문의내용</td>                  
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