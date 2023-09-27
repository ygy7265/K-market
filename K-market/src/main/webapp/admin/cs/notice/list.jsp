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
        var noticeNo = selectedItems.map(function() {
            return $(this).val(); // 선택된 아이템의 data-noticeNo 속성 값을 가져옵니다.
        }).get();
  	  
  	  console.log("noticeNo"+noticeNo);
      $('.Item:checked').closest('tr').remove();
      $.each(noticeNo, function(index, noticeNo) {
      	$.ajax({
				url:'/K-market/admin/cs/notice/delete.do',
				type:'POST',
				traditional : true,
				data: {"noticeNo": noticeNo},
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

    let filter = document.querySelector("#noticeCate");
    filter.addEventListener("change", (e) => {
        let selectedCategory = e.target.value;
        // 페이지 리디렉션
        location.replace('${ctxPath}/admin/cs/notice/list.do?cate='+selectedCategory+"&pg=1");
    });

});

</script>
    <section id="admin-product-list">
        <nav>
            <h3>공지사항</h3>
            <p>
                HOME > 고객센터 > <strong>공지목록</strong>
            </p>
        </nav>
        <!-- 공지목록 컨텐츠 시작 -->                                
        <section>
            <div>
                <select name="cate" id="noticeCate">
                  <option value="">선택</option>
                  <option value="01">고객서비스</option>
                  <option value="02">안전거래</option>
                  <option value="03">위해상품</option>
                  <option value="04">이벤트당첨</option>
                </select>
                <input type="text" name="search" placeholder="제목 or 내용 검색">
            </div>
            <table>
                <tr>
                    <th><input type="checkbox" id="all" /></th>
                    <th>글번호</th>
                    <th>카테고리</th>
                    <th>제목</th>
                    <th>조회수</th>
                    <th>작성일</th>
                    <th>관리</th>
                </tr>
				<c:forEach var="notice" items="${notices}">
                <tr>
                    <td><input type="checkbox" name="Item" class="Item" value="${notice.noticeNo}"/></td>
                    <td>${notice.noticeNo}</td>
                    <td>
	                  <c:set var="cate" value="${notice.cate}"/>
                        <c:choose>
                            <c:when test="${cate eq '01'}">고객서비스</c:when>
                            <c:when test="${cate eq '02'}">안전거래</c:when>
                            <c:when test="${cate eq '03'}">위해상품</c:when>
                            <c:when test="${cate eq '04'}">이벤트당첨</c:when>
                        </c:choose>
                    </td>
                    <td><a href="${ctxPath}/admin/cs/notice/view.do?noticeNo=${notice.noticeNo}">${notice.title}</a></td>
                    <td>${notice.hit}</td>
                    <td>${notice.rdate}</td>
                    <td>
                        <a href="${ctxPath}/admin/cs/notice/modify.do?noticeNo=${notice.noticeNo}">[수정]</a>
                        <a href="${ctxPath}/admin/cs/notice/delete.do?noticeNo=${notice.noticeNo}">[삭제]</a>
                    </td>
                </tr>
                </c:forEach>
            </table>
            
            <input type="button" value="선택삭제" id="deleteSelected"/>

            <div class="paging">
                <span class="prev">
            	<c:if test="${pageGroupStart > 1}">
                    <a href="${ctxPath}/admin/cs/notice/list.do"><&nbsp;이전</a>
                </c:if>
                </span>
				<c:forEach var="i" begin="${pageGroupStart}" end="${pageGroupEnd}" step="1">
                <span class="num">
					<c:set var="on" value="${currentPage == i}"/>
                    <a href="${ctxPath}/admin/cs/notice/list.do?cate=${cate}&pg=${i}" class="on">${i}</a>
                </span>
				</c:forEach>
                <span class="next">
    			<c:if test="${pageGroupEnd < lastPageNum}">
                    <a href="${ctxPath}/admin/cs/notice/list.do">다음&nbsp;></a>
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