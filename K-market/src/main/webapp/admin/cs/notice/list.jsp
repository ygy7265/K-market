<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../../_header.jsp" %>
<%@ include file="../../_aside.jsp" %>
    <section id="admin-product-list">
        <nav>
            <h3>공지사항</h3>
            <p>
                HOME > 공지사항 > <strong>공지목록</strong>
            </p>
        </nav>
        <!-- 공지목록 컨텐츠 시작 -->                                
        <section>
            <div>
                <select name="search">
                    <option value="0">전체</option>
                    <option value="customer">고객서비스</option>
                    <option value="safety">안전거래</option>
                    <option value="product">위해상품</option>                                    
                    <option value="event">이벤트</option>                                    
                </select>
                <input type="text" name="search">
            </div>
            <table>
                <tr>
                    <th><input type="checkbox" name="all"/></th>
                    <th>글번호</th>
                    <th>카테고리</th>
                    <th>제목</th>
                    <th>내용</th>
                    <th>작성자</th>
                    <th>조회수</th>
                    <th>작성일</th>
                    <th>관리</th>
                </tr>
				<c:forEach var="notice" items="${notices}">
                <tr>
                    <td><input type="checkbox" name="상품코드"/></td>
                    <td>${notice.noticeNo}</td>
                    <td>${notice.cate}</td>
                    <td><a href="${ctxPath}/admin/cs/notice/view.do?noticeNo=${notice.noticeNo}">${notice.title}</a></td>
                    <td>${notice.content}</td>
                    <td>${notice.writer}</td>
                    <td>${notice.hit}</td>
                    <td>${notice.rdate}</td>
                    <td>
                        <a href="#">[삭제]</a>
                        <a href="#">[수정]</a>
                    </td>
                </tr>
                </c:forEach>
            </table>
            
            <input type="button" value="선택삭제" />                          

            <div class="paging">
                <span class="prev">
            	<c:if test="${pageGroupStart > 1}">
                    <a href="${ctxPath}/admin/cs/notice/list.do"><&nbsp;이전</a>
                </c:if>
                </span>
				<c:forEach var="i" begin="${pageGroupStart}" end="${pageGroupEnd}" step="1">
                <span class="num">
					<c:set var="on" value="${currentPage == i}"/>
                    <a href="${ctxPath}/admin/cs/notice/list.do?pg=${i}" class="on">${i}</a>
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