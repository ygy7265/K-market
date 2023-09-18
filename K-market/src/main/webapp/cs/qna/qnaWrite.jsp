<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../_header.jsp" %>
	<!-- 
			날짜 : 2023/09/16
			이름 : 이현정
			내용 : CS_QNA 기능구현
		 -->
<script>
	window.onload = function(){
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
	}
	
	
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
          <table>
            <tr>
              <td>문의유형</td>
              <td>
                <select id="cate1" name="cate1">
                  <option value="0">선택</option>
                  <option>회원</option>
                  <option>쿠폰/이벤트</option>
                  <option>주문/결제</option>
                  <option>배송</option>
                  <option>취소/반품/교환</option>
                  <option>여행/숙박/항공</option>
                  <option>안전거래</option>
                </select>
                 <select id="cate2"name="cate2">
                 <option value="0">선택</option>
                  <option selected>가입</option>
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
            <a href="/K-market/cs/qna/qnaList.do?cate1=${cate1}" class="btnList">취소하기</a>
            <input type="submit" class="btnSubmit" value="등록하기"/>
          </div>
        </form>
      </article>
    </section>
  </div>
</section>
<%@ include file="../../_footer.jsp" %>