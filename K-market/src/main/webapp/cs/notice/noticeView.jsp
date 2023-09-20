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
           <br/>
     		<p>
		    ※ 피싱 관련 피해신고<br/>
		    ▶ <a href="http://cyberbureau.police.go.kr" target="_blank">경찰청 사이버수사국 (국번없이)182 : http://cyberbureau.police.go.kr</a><br/>
		    ▶ <a href="http://www.krcert.or.kr" target="_blank">KISA 인터넷침해대응센터 (국번없이)118 : http://www.krcert.or.kr</a><br/>
		    감사합니다.<br/>
			</p>
        </div>
        <a href="/K-market/cs/notice/noticeList.do?cate=${cate}" class="btnList">목록보기</a>
      </article>
    </section>
  </div>
</section>
<%@ include file="../../_footer.jsp" %>