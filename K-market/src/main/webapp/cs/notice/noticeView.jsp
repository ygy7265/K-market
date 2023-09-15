<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../_header.jsp" %>
<section id="cs">
  <div class="notice">
    <nav>
      <div>
        <p>홈<span>></span>공지사항</p>
      </div>
    </nav>
    <section class="view">
	<jsp:include page="../_asideNotice.jsp"/>
      <article>
        <nav>
          <h2 class="title">${dto.title}</h2>
          <span class="date">${dto.rdate}</span>
        </nav>

        <div class="content">
          <p>
          	${dto.content}
          </p>
        </div>
        <a href="/K-market/cs/notice/noticeList.do?cate=${cate}" class="btnList">목록보기</a>
      </article>
    </section>
  </div>
</section>
<%@ include file="../../_footer.jsp" %>