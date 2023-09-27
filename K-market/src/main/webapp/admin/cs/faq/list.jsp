<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../../_header.jsp" %>
<%@ include file="../../_aside.jsp" %>
<script>

$(document).ready(function() {
    // 전체 선택 체크박스가 클릭되었을 때
    $('#all').click(function() {
        // 전체 선택 체크박스의 상태를 가져옴
        var isChecked = $(this).prop('checked');

        // 개별 체크박스들의 상태를 전체 선택 체크박스와 동일하게 설정
        $('.Item').prop('checked', isChecked);
    });

    // 개별 체크박스 중 하나라도 선택 해제되었을 때
    $('.Item').click(function() {
        // 개별 체크박스들 중에서 하나라도 선택 해제된 것이 있는지 확인
        if ($('.Item:checked').length < $('.Item').length) {
            // 하나라도 선택 해제된 경우, 전체 선택 체크박스도 선택 해제
            $('#all').prop('checked', false);
        } else {
            // 모두 선택된 경우, 전체 선택 체크박스도 선택
            $('#all').prop('checked', true);
        }
    });
    
	 //선택삭제
    $('#deleteSelected').click(function() {
  	  var selectedItems = $('.Item:checked'); // 선택된 체크박스 아이템들을 가져옵니다.
        var faqNo = selectedItems.map(function() {
            return $(this).val(); // 선택된 아이템의 data-noticeNo 속성 값을 가져옵니다.
        }).get();
  	  
  	  console.log("faqNo"+faqNo);
      $('.Item:checked').closest('tr').remove();
      $.each(faqNo, function(index, faqNo) {
      	$.ajax({
				url:'/K-market/admin/cs/faq/delete.do',
				type:'POST',
				traditional : true,
				data: {"faqNo": faqNo},
				contentType: "application/x-www-form-urlencoded; charset=UTF-8",
				dataType:'json',
				success:function(data){
					console.log(data);
					console.log(data.result);
					if(data.result > 0){}
					}
			});
      });
    });
    
});


</script>
    <section id="admin-cs-list">
        <nav>
            <h3>자주묻는질문</h3>
            <p>
                HOME > 고객센터 ><strong>자주묻는질문</strong>
            </p>
        </nav>
        <!-- 공지목록 컨텐츠 시작 -->                                
        <section>
            <div>
                <select name="cate1" id="category1">
                  <option value="0">선택</option>
                  <option value="10">회원</option>
                  <option value="20">쿠폰/혜택/이벤트</option>
                  <option value="30">주문/결제</option>
                  <option value="40">배송</option>
                  <option value="50">취소/반품/교환</option>
                  <option value="60">여행/숙박/항공</option>
                  <option value="70">안전거래</option>
                </select>
                <select name="cate2" id="category2">
                  <option value="0">선택</option>
                  <option value="10">회원</option>
                  <option value="20">쿠폰/혜택/이벤트</option>
                  <option value="30">주문/결제</option>
                  <option value="40">배송</option>
                  <option value="50">취소/반품/교환</option>
                  <option value="60">여행/숙박/항공</option>
                  <option value="70">안전거래</option>
                </select>
                <input type="text" name="search" placeholder="제목 or 내용 검색">
            </div>
            <table>
                <tr>
                    <th><input type="checkbox" name="all" id="all"/></th>
                    <th>글번호</th>
                    <th>1차 카테고리</th>
                    <th>2차 카테고리</th>
                    <th>제목</th>
                    <th>조회수</th>
                    <th>작성일</th>
                    <th>관리</th>
                </tr>
				<c:forEach var="faqs" items="${faqs}">
                <tr>
                    <td><input type="checkbox" name="Item" class="Item" value="${faqs.faqNo}"/></td>
                    <td>${faqs.faqNo}</td>
                    <td>
	                  <c:set var="cate1" value="${faqs.cate1}"/>
                        <c:choose>
                            <c:when test="${cate1 eq 10}">회원</c:when>
                            <c:when test="${cate1 eq 20}">쿠폰/혜택/이벤트</c:when>
                            <c:when test="${cate1 eq 30}">주문/결제</c:when>
                            <c:when test="${cate1 eq 40}">배송</c:when>
                            <c:when test="${cate1 eq 50}">취소/반품/교환</c:when>
                            <c:when test="${cate1 eq 60}">여행/숙박/항공</c:when>
                            <c:when test="${cate1 eq 70}">안전거래</c:when>
                        </c:choose>
                    </td>
                    <td>
	                  <c:set var="cate2" value="${faqs.cate2}"/>
                        <c:choose>
                            <c:when test="${cate2 eq 1010}">가입</c:when>
                            <c:when test="${cate2 eq 1011}">탈퇴</c:when>
                            <c:when test="${cate2 eq 1012}">회원정보</c:when>
                            <c:when test="${cate2 eq 1013}">로그인</c:when>
                            <c:when test="${cate2 eq 2010}">쿠폰/할인혜택</c:when>
                            <c:when test="${cate2 eq 2011}">포인트</c:when>
                            <c:when test="${cate2 eq 2012}">제휴</c:when>
                            <c:when test="${cate2 eq 2013}">이벤트</c:when>
                            <c:when test="${cate2 eq 3010}">상품</c:when>
                            <c:when test="${cate2 eq 3011}">결제</c:when>
                            <c:when test="${cate2 eq 3012}">구매내역</c:when>
                            <c:when test="${cate2 eq 3013}">영수증/증빙</c:when>
                            <c:when test="${cate2 eq 4010}">배송상태/기간</c:when>
                            <c:when test="${cate2 eq 4011}">배송정보확인/변경</c:when>
                            <c:when test="${cate2 eq 4012}">해외배송</c:when>
                            <c:when test="${cate2 eq 4013}">당일배송</c:when>
                            <c:when test="${cate2 eq 4014}">해외직구</c:when>
                            <c:when test="${cate2 eq 5010}">반품신청/철회</c:when>
                            <c:when test="${cate2 eq 5011}">반품정보확인/변경</c:when>
                            <c:when test="${cate2 eq 5012}">교환 AS신청/철회</c:when>
                            <c:when test="${cate2 eq 5013}">교환정보확인/변경</c:when>
                            <c:when test="${cate2 eq 5014}">취소신청/철회</c:when>
                            <c:when test="${cate2 eq 5015}">취소확인/환불정보</c:when>
                            <c:when test="${cate2 eq 6010}">여행/숙박</c:when>
                            <c:when test="${cate2 eq 6011}">항공</c:when>
                            <c:when test="${cate2 eq 7010}">서비스 이용규칙 위반</c:when>
                            <c:when test="${cate2 eq 7011}">지식재산권침해</c:when>
                            <c:when test="${cate2 eq 7012}">법령 및 정책위반 상품</c:when>
                            <c:when test="${cate2 eq 7013}">게시물 정책위반</c:when>
                            <c:when test="${cate2 eq 7014}">직거래/외부거래유도</c:when>
                            <c:when test="${cate2 eq 7015}">표시광고</c:when>
                            <c:when test="${cate2 eq 7016}">청소년 위해상품/이미지</c:when>
                        </c:choose>
                    </td>
                    <td><a href="${ctxPath}/admin/cs/faq/view.do?faqNo=${faqs.faqNo}">${faqs.title}</a></td>
                    <td>${faqs.hit}</td>
                    <td>${faqs.rdate}</td>
                    <td>
                        <a href="#">[수정]</a>
                        <a href="${ctxPath}/admin/cs/faq/delete.do?faqNo=${faqs.faqNo}">[삭제]</a>
                    </td>
                </tr>
                </c:forEach>
            </table>
            
            <input type="button" value="선택삭제" id="deleteSelected"/>

            <div class="paging">
                <span class="prev">
            	<c:if test="${pageGroupStart > 1}">
                    <a href="${ctxPath}/admin/cs/faq/list.do"><&nbsp;이전</a>
                </c:if>
                </span>
				<c:forEach var="i" begin="${pageGroupStart}" end="${pageGroupEnd}" step="1">
                <span class="num">
					<c:set var="on" value="${currentPage == i}"/>
                    <a href="${ctxPath}/admin/cs/faq/list.do?pg=${i}" class="on">${i}</a>
                </span>
				</c:forEach>
                <span class="next">
    			<c:if test="${pageGroupEnd < lastPageNum}">
                    <a href="${ctxPath}/admin/cs/faq/list.do">다음&nbsp;></a>
	            </c:if>
                </span>
			</div>

        </section>

		<a href="${ctxPath}/admin/cs/notice/write.do" class="btnWrite">공지작성</a>		
        
        <p class="ico info">
            <strong>Tip!</strong>
            전자상거래 등에서의 상품 등의 정보제공에 관한 고시에 따라 총 35개 상품군에 대해 상품 특성 등을 양식에 따라 입력할 수 있습니다.
        </p>

        <!-- 상품목록 컨텐츠 끝 -->
    </section>
</main>
<%@ include file="../../_footer.jsp" %>