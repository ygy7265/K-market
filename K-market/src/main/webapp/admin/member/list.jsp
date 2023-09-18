<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../_header.jsp" %>
<%@ include file="../_aside.jsp" %>
    <section id="admin-product-list">
        <nav>
            <h3>회원목록</h3>
            <p>
                HOME > 회원관리 > <strong>회원목록</strong>
            </p>
        </nav>
        <!-- 멤버목록 컨텐츠 시작 -->                                
        <section>
            <div>
                <select name="search">
                    <option value="search1">회원이름</option>
                    <option value="search1">회원등급</option>
	              </select>
                <input type="text" name="search">
            </div>
            <table>
                <tr>
                    <th><input type="checkbox" name="all"/></th>
                    <th>이름</th>
                    <th>성별</th>
                    <th>회원등급</th>
                    <th>이메일</th>
                    <th>전화번호</th>
                    <th>구매건수</th>
                    <th>가입일자</th>
                    <th>회원관리</th>
                </tr>
				<c:forEach var="member" items="${members}">
                <tr>
                    <td><input type="checkbox" name="회원"/></td>
                    <td>${member.name}</td>
                    <td>
                    <c:choose>
	                    <c:when test="${member.gender == 1}">남자</c:when>
	                    <c:when test="${member.gender == 2}">여자</c:when>
	                    <c:otherwise>선택되지 않음</c:otherwise>
                    </c:choose>
                    </td>
                    <td>
                    <c:choose>
                    	<c:when test="${member.type == 0}">탈퇴</c:when>
                    	<c:when test="${member.type == 1}">일반회원</c:when>
                    	<c:when test="${member.type == 2}">실버회원</c:when>
                    	<c:when test="${member.type == 3}">골드회원</c:when>
                    	<c:when test="${member.type == 5}">판매자</c:when>
                    	<c:when test="${member.type == 100}">최고관리자</c:when>
                    </c:choose>
                    </td>
                    <td>${member.email}</td>
                    <td>${member.hp}</td>
                    <td>0건</td>
                    <td>${member.rdate}</td>
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
                    <a href="/K-market/admin/product/list.do"><&nbsp;이전</a>
                </c:if>
                </span>
				<c:forEach var="i" begin="${pageGroupStart}" end="${pageGroupEnd}" step="1">
                <span class="num">
					<c:set var="on" value="${currentPage == i}"/>
                    <a href="/K-market/admin/product/list.do?pg=${i}" class="on">${i}</a>
                </span>
				</c:forEach>
                <span class="next">
    			<c:if test="${pageGroupEnd < lastPageNum}">
                    <a href="/K-market/admin/product/list.do">다음&nbsp;></a>
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
<%@ include file="../_footer.jsp" %>