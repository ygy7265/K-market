<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../_header.jsp" %>
<script>
	// faqList
  $(function(){
    $('.more').click(function(e){
      e.preventDefault();
      
      /*
      let item = $(this).parent().find('> li:nth-child(n+4)');
      let isVisible = item.is(':visible');

      console.log('isVisible : ' + isVisible);

      if(isVisible){
        item.slideUp(100);
      }else{
        item.slideDown(100);
      }
      */

    });
  });


</script>
<section id="cs">
  <div class="faq">
    <nav>
      <div>
        <p>홈<span>></span>자주묻는 질문</p>
      </div>
    </nav>
    <section class="list">
      <aside>
        <h2>자주묻는 질문</h2>
        <ul>
          <li class="on"><a href="/K-market/cs/faq/faqList.do">회원</a></li>
          <li><a href="/K-market/cs/faq/faqList.do">쿠폰/이벤트</a></li>
          <li><a href="/K-market/cs/faq/faqList.do">주문/결제</a></li>
          <li><a href="/K-market/cs/faq/faqList.do">배송</a></li>
          <li><a href="/K-market/cs/faq/faqList.do">취소/반품/교환</a></li>
          <li><a href="/K-market/cs/faq/faqList.do">여행/숙박/항공</a></li>
          <li><a href="/K-market/cs/faq/faqList.do">안전거래</a></li>
        </ul>
      </aside>
      <article>              
        <nav>
          <h1>회원</h1>
          <h2>가장 자주 묻는 질문입니다.</h2>
        </nav>

        <div>
          <h3>가입</h3>
          <ul>
            <li><a href="/K-market/cs/faq/faqview.do"><span>Q.</span>개인회원과 법인회원에 차이가 있나요?</a></li>
            <li><a href="/K-market/cs/faq/faqview.do"><span>Q.</span>개인회원과 법인회원에 차이가 있나요?</a></li>
            <li><a href="/K-market/cs/faq/faqview.do"><span>Q.</span>개인회원과 법인회원에 차이가 있나요?</a></li>
            <li><a href="/K-market/cs/faq/faqview.do"><span>Q.</span>개인회원과 법인회원에 차이가 있나요?</a></li>
            <li><a href="/K-market/cs/faq/faqview.do"><span>Q.</span>개인회원과 법인회원에 차이가 있나요?</a></li>
            <li class="more"><a href="#">더보기</a></li>
          </ul>
        </div>
        <div>
          <h3>탈퇴</h3>
          <ul>
            <li><a href="/K-market/cs/faq/faqview.do"><span>Q.</span>회원탈퇴 후 재가입이 가능한가요?</a></li>
            <li><a href="/K-market/cs/faq/faqview.do"><span>Q.</span>회원탈퇴 후 재가입이 가능한가요?</a></li>
            <li><a href="/K-market/cs/faq/faqview.do"><span>Q.</span>회원탈퇴 후 재가입이 가능한가요?</a></li>
            <li><a href="/K-market/cs/faq/faqview.do"><span>Q.</span>회원탈퇴 후 재가입이 가능한가요?</a></li>
            <li><a href="/K-market/cs/faq/faqview.do"><span>Q.</span>회원탈퇴 후 재가입이 가능한가요?</a></li>
            <li class="more"><a href="#">더보기</a></li>
          </ul>
        </div>
        <div>
          <h3>회원정보</h3>
          <ul>
            <li><a href="/K-market/cs/faq/faqview.do"><span>Q.</span>회원정보를 수정하고 싶어요.</a></li>
            <li><a href="/K-market/cs/faq/faqview.do"><span>Q.</span>회원정보를 수정하고 싶어요.</a></li>
            <li><a href="/K-market/cs/faq/faqview.do"><span>Q.</span>회원정보를 수정하고 싶어요.</a></li>
            <li><a href="/K-market/cs/faq/faqview.do"><span>Q.</span>회원정보를 수정하고 싶어요.</a></li>
            <li><a href="/K-market/cs/faq/faqview.do"><span>Q.</span>회원정보를 수정하고 싶어요.</a></li>
            <li class="more"><a href="#">더보기</a></li>
          </ul>
        </div>
        <div>
          <h3>로그인</h3>
          <ul>
            <li><a href="/K-market/cs/faq/faqview.do"><span>Q.</span>로그인에 문제가 있어요.</a></li>
            <li><a href="/K-market/cs/faq/faqview.do"><span>Q.</span>로그인에 문제가 있어요.</a></li>
            <li><a href="/K-market/cs/faq/faqview.do"><span>Q.</span>로그인에 문제가 있어요.</a></li>
            <li><a href="/K-market/cs/faq/faqview.do"><span>Q.</span>로그인에 문제가 있어요.</a></li>
            <li><a href="/K-market/cs/faq/faqview.do"><span>Q.</span>로그인에 문제가 있어요.</a></li>
            <li class="more"><a href="#">더보기</a></li>
          </ul>
        </div>

      </article>
    </section>
  </div>
</section>
<%@ include file="../../_footer.jsp" %>
      
