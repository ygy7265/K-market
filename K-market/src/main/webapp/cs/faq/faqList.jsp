<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../_header.jsp" %>
<!-- 
	날짜 : 2023/09/17
	이름 : 윤경엽, 이현정
	내용 : FaqList 구현
 -->
<script>
$(function(){
   var cate1 = ${param.cate1};

    const jsondata1 = {
        jsondatavalue: [] // cate2 값을 저장할 배열
    };
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
                $(".subcontent").eq(i).addClass("a"+data.result2[i]);
                categoryid.push($(".catename").eq(i).attr("id"));
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
                                var newA = $("<a>").attr("href", "/K-market/cs/faq/faqView.do?cate1="+cate1+"&faqNo="+faqField1);
                                var newSpan = $("<span>").text("Q.");
                                var item = data.result[j]; // 현재 반복 중인 객체
                                // 객체의 속성에 접근하여 데이터 추출
                                var faqField1 = item.faqField1;
                                var faqField2 = item.faqField2;
                               $(".subcontent").eq(i).prepend(newLi.prepend(newA.append(newSpan).append(faqField2)));
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
/*     $(".more a").on("click", function(e) {
        e.preventDefault();
        var cateId = $(this).data("mydata"); 
        var cssSelector = "#cs > .faq > .list > article > div > ul.a" + cateId + " > li";
        // CSS 선택자를 이용하여 요소를 선택하고 스타일을 변경
        var elements = document.querySelectorAll(cssSelector);

        for (var i = 0; i < elements.length; i++) {
            var element = elements[i];
            	if(element.style.display == "block"){
            		 if (i > 2) {
            			 element.style.display = "none";
            		 }	 
            	}
            	else {
            	element.style.display = "block";
            }
        }
        var isVisible = elements[2].style.display === "block";
        if (isVisible) {
            $(this).text("더보기");
        } else {
            $(this).text("간단히보기");
        }
    });
 */

    $(".more a").on("click", function(e) {
        e.preventDefault();
        var cateId = $(this).data("mydata");
        var cssSelector = "#cs > .faq > .list > article > div > ul.a" + cateId + " > li";
        // CSS 선택자를 이용하여 요소를 선택하고 스타일을 변경
        var elements = document.querySelectorAll(cssSelector);
        
        // 토글 상태를 판단하기 위한 변수
        var isExpanded = false;

        for (var i = 0; i < elements.length; i++) {
            var element = elements[i];
            if (element.style.display == "block") {
                if (i > 2) {
                    element.style.display = "none";
                }
            } else {
                element.style.display = "block";
                // 하나라도 보이는 요소가 있으면 isExpanded를 true로 설정
                isExpanded = true;
            }
        }
        // isExpanded 값에 따라 텍스트를 변경
        if (isExpanded) {
            $(this).text("간단히보기");
        } else {
            $(this).text("더보기");
        }
    });

});

</script>
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
		    <ul class="subcontent " >
		        <li class="more" ><a href="#" class="catelink" data-mydata="${cate.cate2}">더보기</a></li>
		    </ul>
		</c:forEach>
        </div>
      </article>
    </section>
  </div>
</section>
<%@ include file="../../_footer.jsp" %>
      
