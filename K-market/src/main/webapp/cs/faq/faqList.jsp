<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../_header.jsp" %>
<script>

	var list = document.querySelector(".list");
	/* var cate2Name = list.querySelectorAll("h3");
	
	for (var i = 0; i < cate2Name.length; i++) {
	    var cate2 = cate2Name[i].textContent; // h3 요소의 텍스트 값을 가져옴
	
	    // cate2 값을 원하는 방식으로 변경
	    switch (cate2) {
	        case "1010":
	        	cate2Name[i].textContent = "회원가입";
	            break;
	        case "1011":
	        	cate2Name[i].textContent = "탈퇴";
	            break;
	        case "1012":
	        	cate2Name[i].textContent = "회원정보";
	            break;
	        case "1013":
	        	cate2Name[i].textContent = "로그인";
	            break;
	        // 다른 cate2 값에 대한 변경 로직 추가
	    }
	} */
	
	
		
		// 서버 결과 가져오기
		

		// 콘솔에 출력
		
		
		// 서버에서 데이터를 가져오는 함수
		
		$(function(){
		/* 	$.ajax({
			    url: '/K-market/cs/faq/faqList.do',
			    type: 'GET',
			    data: { 'cate': '1010' },
			    dataType: 'json',
			    success: function (data) {
			        // 서버에서 받은 JSON 응답을 파싱하여 원하는 데이터 추출
			        var result = data.result;
			        
			    },
			 
			}); */
			const jsondata1 = {
					jsondatavalue: [] // cate2 값을 저장할 배열
					};

					// cate2 값을 배열에 추가
					

					// jsondata 객체를 출력하여 확인
					console.log(jsondata1);
					console.log(typeof JSON.stringify(jsondata1));
					const array =  [];
					<c:forEach var="cate" items="${cates}">
					  array.push("${cate.cate2}");
					</c:forEach>;
					console.log(typeof array);
					console.log(typeof JSON.stringify(array));

			$.ajax({
				url:'/K-market/cs/faq/faqList.do',
				type:'POST',
				traditional : true,
				data: {array:array},
				contentType: "application/x-www-form-urlencoded; charset=UTF-8",
				dataType:'json',
				success:function(data){
					for (var i = 0; i < array.length; i++) {
						$(".catename").eq(i).text(data.result[i]);
						console.log("data = "+ data.result[i]);
					}
					
					
				}
			});
		});
	</script>
	<c:forEach var="cate" items="${cates}">
	
	</c:forEach>
<section id="cs">
  <div class="faq">
    <nav>
      <div>
        <p>
        	홈<span>></span>자주묻는 질문<span>></span>
        	<c:choose>
        		<c:when test="${param.cate1 == '10'}">회원</c:when>
			    <c:when test="${param.cate1 == '20'}">쿠폰/이벤트</c:when>
			    <c:when test="${param.cate1 == '30'}">주문/결제</c:when>
			    <c:when test="${param.cate1 == '40'}">배송</c:when>
			    <c:when test="${param.cate1 == '50'}">취소/반품/교환</c:when>
			    <c:when test="${param.cate1 == '60'}">여행/숙박/항공</c:when>
			    <c:when test="${param.cate1 == '70'}">안전거래</c:when>
			</c:choose>
        </p>
      </div>
    </nav>
    <section class="list">
	<jsp:include page="../_asideFaq.jsp"/>
     <article>   
        <nav>
          <c:choose>
       		<c:when test="${param.cate1 == '10'}">
       			<h1>회원</h1>
	    	</c:when>
		    <c:when test="${param.cate1 == '20'}">
		        <h1>쿠폰/이벤트</h1>
		    </c:when>
		    <c:when test="${param.cate1 == '30'}">
		        <h1>주문/결제</h1>
		    </c:when>
		    <c:when test="${param.cate1 == '40'}"> 
		        <h1>배송</h1>
		    </c:when>
		    <c:when test="${param.cate1 == '50'}">
		        <h1>취소/반품/교환</h1>
		    </c:when>
		    <c:when test="${param.cate1 == '60'}">
		        <h1>여행/숙박/항공</h1>
		    </c:when>
		    <c:when test="${param.cate1 == '70'}">
		        <h1>안전거래</h1>
		    </c:when>
		</c:choose>
          <h2>가장 자주 묻는 질문입니다.</h2>
        </nav>
        <div>
		<c:forEach var="cate" items="${cates}">
      <h3 class="catename"></h3>
		    <ul>
		        <c:forEach var="faq" items="${faqs}">
		            <c:if test="${faq.cate1 == cate.cate1 && faq.cate2 == cate.cate2}">
		                <li><a href="/K-market/cs/faq/faqView.do?cate1=${faq.cate1}&cate2=${faq.cate2}">
		                    <span>Q.</span>${faq.title}</a></li>
		            </c:if>
		        </c:forEach>
		        <li class="more"><a href="#">더보기</a></li>
		    </ul>
		</c:forEach>
        </div>
      </article>
    </section>
  </div>
</section>
<%@ include file="../../_footer.jsp" %>
      
