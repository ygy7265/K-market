<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../_header.jsp"%>
<!--
  	날짜 : 2023/09/18
   	이름 : 이현정
  	내용 : 문의하기-보기 (QnA/View) 기능 구현
  
-->
<section id="cs">
	<div class="qna">
		<nav>
			<div>
				<p>
					홈<span>></span>문의하기
				</p>
			</div>
		</nav>
		<section class="view">
			<jsp:include page="../_asideQna.jsp" />
			<article>
				<nav>
					<h2 class="title">[${dto.cate2}]${dto.title}</h2>
					<p>
						<span><c:out value="${fn:substring(dto.writer, 0, fn:length(dto.writer) - 3)}"/>***</span>
						<span>${dto.rdate}</span>
					</p>
				</nav>

				<div class="content">
					<p>${dto.content}</p><br>
					<p>개인회원에서 법인회원(사업자 회원)으로 전환은 불가하므로 법인회원(사업자 회원) 전환은 신규 가입으로 진행을 해야 합니다.</p><br>
					<p>
				    ※ 피싱 관련 피해신고<br/>
				    ▶ <a href="http://cyberbureau.police.go.kr" target="_blank">경찰청 사이버수사국 (국번없이)182 : http://cyberbureau.police.go.kr</a><br/>
				    ▶ <a href="http://www.krcert.or.kr" target="_blank">KISA 인터넷침해대응센터 (국번없이)118 : http://www.krcert.or.kr</a><br/>
				    감사합니다.<br/>
					</p>
				</div>
				<a href="/K-market/cs/qna/qnaList.do?cate1=${dto.cate1}" class="btnList">목록보기</a>
				<!-- 댓글리스트 -->
			    <section class="commentList">
			        <h3>답변목록</h3>
				        <article class="comment">
								<textarea class="content" name="content" readonly>${dto.reply}</textarea>
				        </article>
			        <c:if test="${comments.isEmpty()}">
			        <p class="empty">등록된 댓글이 없습니다.</p>
			        </c:if>
			    </section>
			</article>
	
	</section>
	</div>
</section>
<%@ include file="../../_footer.jsp"%>
