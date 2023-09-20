<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../_header.jsp" %>
<!-- 
	날짜 : 2023/09/17
	이름 : 윤경엽, 이현정
	내용 : FaqList 구현
 -->
<script>
$(function(){
	   var cate1 = '${param.cate1}';
    const jsondata1 = {
        jsondatavalue: [] // cate2 값을 저장할 배열
    };

    // jsondata 객체를 출력하여 확인
    console.log(jsondata1);
    console.log(typeof JSON.stringify(jsondata1));
    const array =  [];
    <c:forEach var="cate" items="${cates}">
      array.push("${cate.cate2}");
    </c:forEach>;
    const categoryid =  [];
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
                $(".catename").eq(i).attr("id",data.result2[i]);
                console.log("data = "+ data.result[i]);
                console.log("data = "+ data.result2);
                categoryid.push($(".catename").eq(i).attr("id"));
                console.log("categoryid = "+ categoryid);
            }
            for(let i = 0; i < categoryid.length; i++) {
            	var category = categoryid[i];
            	console.log("end");
                $.ajax({
                    url:'/K-market/cs/faq/faqList.do',
                    type:'POST',
                    traditional : true,
                    data: {"categoryid":category,
                            "cata1" : cate1
                    },
                    contentType: "application/x-www-form-urlencoded; charset=UTF-8",
                    dataType:'json',
                    success:function(data){
                        var jsonData = JSON.stringify(data);
                            for (var j = 0; j < data.result.length; j++) {
                                // 새로운 li 요소 생성
                                var newLi = $("<li class='newli'>");
                                var newA = $("<a>").attr("href", "/K-market/cs/qna/qnaView.do?faqNo="+faqField1);
                                var newSpan = $("<span>").text("Q.");
								
                                
                                var item = data.result[j]; // 현재 반복 중인 객체
                                // 객체의 속성에 접근하여 데이터 추출
                                var faqField1 = item.faqField1;
                                var faqField2 = item.faqField2;
                               
                               $(".subcontent").eq(i).prepend(newLi.prepend(newA.append(newSpan).append(faqField2)));
                                console.log("faqField1 = "+ faqField1);
                                console.log("faqField2 = "+ faqField2);
                                console.log("jsonData = "+ jsonData);    
                            }
                    }
                });
             } 
        }
    });
  
    $(".catelink").each(function(e) {
        var cateId = $(this).data("mydata"); 
        $(this).on("click", function() {
            // 여기에 클릭 이벤트 핸들러 내용 작성
            var targetSelector = "[data-mydata='" + cateId + "']";
            $(targetSelector).toggleClass("display-block"); // 클래스를 토글하여 스타일을 변경
        });
    });

    // 더보기 링크를 클릭했을 때 이벤트 핸들러를 등록
   $(".more a").on("click", function(e) {
        e.preventDefault();
     	
     	
     var cssSelector = "#cs > .faq > .list > article > div > ul > li:nth-child(n+4)";

     // 적용할 스타일
     var newStyle = "display: block"; // 원하는 스타일로 변경

     // CSS 선택자를 이용하여 요소를 선택하고 스타일을 변경
     var elements = document.querySelectorAll(cssSelector);
     for (var i = 0; i < elements.length; i++) {
         elements[i].style.cssText = newStyle;
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
      	<h3 class="catename" id="${cate.cate2}"></h3>
		    <ul class="subcontent">
		        <li class="more"><a href="#" class="catelink" data-mydata="${cate.cate2}">더보기</a></li>
		    </ul>
		</c:forEach>
        </div>
      </article>
    </section>
  </div>
</section>
<%@ include file="../../_footer.jsp" %>
      
