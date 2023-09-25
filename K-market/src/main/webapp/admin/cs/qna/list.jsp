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
        var qnaNo = selectedItems.map(function() {
            return $(this).val(); // 선택된 아이템의 data-noticeNo 속성 값을 가져옵니다.
        }).get();
  	  
  	  console.log("qnaNo"+qnaNo);
      $('.Item:checked').closest('tr').remove();
      $.each(qnaNo, function(index, qnaNo) {
      	$.ajax({
				url:'/K-market/admin/cs/qna/delete.do',
				type:'POST',
				traditional : true,
				data: {"qnaNo": qnaNo},
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
            <h3>문의사항</h3>
            <p>
                HOME > 고객센터 > <strong>문의사항</strong>
            </p>
        </nav>
        <!-- 공지목록 컨텐츠 시작 -->                                
        <section>
            <div>
                <select name="cate1" id="category1">
                  <option>1차유형</option>
                  <option value="10">회원</option>
                  <option value="20">쿠폰/혜택/이벤트</option>
                  <option value="30">주문/결제</option>
                  <option value="40">배송</option>
                  <option value="50">취소/반품/교환</option>
                  <option value="60">여행/숙박/항공</option>
                  <option value="70">안전거래</option>
                </select>
                <select name="cate2" id="category2">
                  <option>2차유형</option>
                  <option value="#">2차유형</option>
                </select>
            </div>
            <table>
                <tr>
                    <th><input type="checkbox" id="all" /></th>
                    <th>글번호</th>
                    <th>1차유형</th>
                    <th>2차유형</th>
                    <th>제목</th>
                    <th>작성자</th>
                    <th>작성일</th>
                    <th>상태</th>
                </tr>
				<c:forEach var="qna" items="${qnas}">
                <tr>
                    <td><input type="checkbox" name="Item" class="Item" value="${qna.qnaNo}"/></td>
                    <td>${qna.qnaNo}</td>
                    <td>
                    <c:set var="cate1" value="${qna.cate1}"/>
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
                    <td>${qna.cate2}</td>
                    <c:choose>
	   	                <c:when test="${qna.status == '답변완료'}">
	    	                <td><a href="${ctxPath}/admin/cs/qna/view.do?qnaNo=${qna.qnaNo}">${qna.title}</a></td>
	                    </c:when>
	               		<c:otherwise>
				        	<td><a href="${ctxPath}/admin/cs/qna/reply.do?qnaNo=${qna.qnaNo}">${qna.title}</a></td>
				        </c:otherwise>
			        </c:choose>
                    <td>${qna.writer}</td>
                    <td>${qna.formatDate()}</td>
                    <td>
					    <c:choose>
					        <c:when test="${qna.status == '답변완료'}">
					            <span style="color: blue;">${qna.status}</span>
					        </c:when>
					        <c:otherwise>
					        	<span style="color: red;">${qna.status}</span>
					        </c:otherwise>
					    </c:choose>
					</td>
                </tr>
                </c:forEach>
            </table>
            
            <input type="button" value="선택삭제" id="deleteSelected"/>
            
            <div class="paging">
                <span class="prev">
            	<c:if test="${pageGroupStart > 1}">
                    <a href="${ctxPath}/admin/cs/qna/list.do"><&nbsp;이전</a>
                </c:if>
                </span>
				<c:forEach var="i" begin="${pageGroupStart}" end="${pageGroupEnd}" step="1">
                <span class="num">
					<c:set var="on" value="${currentPage == i}"/>
                    <a href="${ctxPath}/admin/cs/qna/list.do?pg=${i}" class="on">${i}</a>
                </span>
				</c:forEach>
                <span class="next">
    			<c:if test="${pageGroupEnd < lastPageNum}">
                    <a href="${ctxPath}/admin/cs/qna/list.do">다음&nbsp;></a>
	            </c:if>
                </span>
			</div>

        </section>
        
        <p class="ico info">
            <strong>Tip!</strong>
            전자상거래 등에서의 상품 등의 정보제공에 관한 고시에 따라 총 35개 상품군에 대해 상품 특성 등을 양식에 따라 입력할 수 있습니다.
        </p>

        <!-- 상품목록 컨텐츠 끝 -->
    </section>
</main>
<%@ include file="../../_footer.jsp" %>