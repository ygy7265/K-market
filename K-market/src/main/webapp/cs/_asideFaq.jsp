<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
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
            
