<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../_header.jsp" %>
	<!-- 
		날짜 : 2023/09/16
		이름 : 윤경엽, 이현정
		내용 : CS_QNA 기능구현
	-->
<script>
	/*window.onload = function(){
		let cate1 = document.getElementById("cate1");
		let cate2 = document.getElementById("cate2");
	
		let data = {
			 
	          "회원":["가입","탈퇴","회원정보","로그인"],
	          "쿠폰/이벤트":["쿠폰/할인혜택","포인트","제휴","이벤트"],
	          "주문/결제":["상품","결제","구매내역","영수증/증빙"],
	          "배송":["배송상태/기간", "배송정보확인/변경", "해외배송", "당일배송", "해외직구"],
	          "취소/반품/교환":["반품신청/철회", "반품정보확인/변경", "교환 AS신청/철회", "교환정보확인/변경", "취소신청/철회", "취소확인/환불정보"],
	          "여행/숙박/항공":["여행/숙박", "항공"],
	          "안전거래":["서비스 이용규칙 위반", "지식재산권침해", "법령 및 정책위반 상품", "게시물 정책위반", "직거래/외부거래유도", "표시광고", "청소년 위해상품/이미지"]
		}
		 cate1.addEventListener("change",(e)=>{
			 while(cate2.firstChild){
				 cate2.firstChild.remove();
			 }
			 let newOptionsString ="";
			 data[e.target.value].forEach(el => {
				 newOptionsString +="<option>"+el+"</option>";
				 console.log(el);
			 })
			cate2.innerHTML = newOptionsString;
		 })
	}*/
	var list = document.querySelector(".write");
	$(function(){
			
			let cate1 = document.getElementById("cate1");
			let cate2 = document.getElementById("cate2");
			
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
			console.log(array);
			console.log(JSON.stringify(array));
			
			$('#cate1').change(function(){
				
				var selectcate = $(this).val();
				$('#cate2').empty();
				console.log("cate1 = " + selectcate);
				
				$.ajax({
					url:'/K-market/cs/qna/qnaWrite.do',
					type:'GET',
					traditional : true,
					data: {"catelist":selectcate},
					contentType: "application/x-www-form-urlencoded; charset=UTF-8",
					dataType:'json',
					success:function(data){
					console.log(data.result);
					
						var selectElement = $("#cate2"); // jQuery를 사용하여 <select> 요소를 선택
		
		                for (var i = 0; i < data.result.length; i++) {
		                    var optionData = data.result[i];
		                    var optionValue = optionData; // 옵션의 값
		                    var optionText = optionData; // 옵션의 텍스트
		
		                    // <option> 요소를 생성하고 속성을 설정하여 추가
		                    $("<option>")
		                        .text(optionData) // 옵션의 텍스트 설정
		                        .appendTo(selectElement); // <select> 요소에 옵션 추가
		                    	console.log(data.result[0]);
		                }
					
				}
			});// ajax end
		});// #cate1.change end
	});// function() end
	
	
	
</script>
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
        <form action="/K-market/cs/qna/qnaWrite.do" method="post">
        <input type="hidden" name="writer" value="${user.uid}"/>
        <input type="hidden" name="status" value="검토중"/>
          <table>
            <tr>
              <td>문의유형</td>
              <td>
                <select id="cate1" name="cate1">
                  <option value="0">선택</option>
                  <option value="10">회원</option>
                  <option value="20">쿠폰/이벤트</option>
                  <option value="30">주문/결제</option>
                  <option value="40">배송</option>
                  <option value="50">취소/반품/교환</option>
                  <option value="60">여행/숙박/항공</option>
                  <option value="70">안전거래</option>
                </select>
                 <select id="cate2"name="cate2">
                 <option value="0">선택</option>
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
            <a href="/K-market/cs/qna/qnaList.do?cate1=10" class="btnList">취소하기</a>
            <input type="submit" class="btnSubmit" value="등록하기"/>
          </div>
        </form>
      </article>
    </section>
  </div>
</section>
<%@ include file="../../_footer.jsp" %>