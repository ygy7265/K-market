<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../_header.jsp" %>
<%@ include file="../_aside.jsp" %>
<script>
	function deleteSelected() {
		var checkboxes = document.querySelectorAll('input[name="productNo"]:checked');
		
		if(checkboxes.length == 0){
			alert("선택된 상품이 없습니다.");
			return;
		}
		
		var selectedProductNos = [];
		
        checkboxes.forEach(function (checkbox) {
            selectedProductNos.push(checkbox.value);
        });
        
        
		
	} // deleteSelected END
</script>
    <section id="admin-product-list">
        <nav>
            <h3>상품목록</h3>
            <p>
                HOME > 상품관리 > <strong>상품목록</strong>
            </p>
        </nav>
        <!-- 상품목록 컨텐츠 시작 -->                                
        <section>
            <div>
                <select name="search">
                    <option value="search1">상품명</option>
                    <option value="search1">상품코드</option>
                    <option value="search1">제조사</option>
                    <option value="search1">판매자</option>                                    
                </select>
                <input type="text" name="search">
            </div>
            <table>
                <tr>
                    <th><input type="checkbox" name="all"/></th>
                    <th>이미지</th>
                    <th>상품코드</th>
                    <th>상품명</th>
                    <th>판매가격</th>
                    <th>할인율</th>
                    <th>포인트</th>
                    <th>재고</th>
                    <th>판매자</th>
                    <th>조회</th>
                    <th>관리</th>
                </tr>
				<c:forEach var="product" items="${products}">
                <tr>
                    <td><input type="checkbox" name="productNo" value="${product.prodNo}"/></td>

                    <td><img src="/K-market/admin/thumbAll/${product.thumb1}" class="thumb"></td>
                    <td>${product.prodNo}</td>
                    <td>${product.prodName}</td>
                    <td>${product.price}</td>
                    <td>${product.discount}%</td>
                    <td>${product.point}</td>
                    <td>${product.stock}</td>
                    <td>${product.seller}</td>
                    <td>${product.hit}</td>
                    <td>
                        <a href="${ctxPath}/admin/product/modify.do?prodNo=${product.prodNo}">[수정]</a>
                        <a href="${ctxPath}/admin/product/delete.do?prodNo=${product.prodNo}">[삭제]</a>
                    </td>
                </tr>
                </c:forEach>
            </table>
            
            <input type="button" value="선택삭제" />

            <!-- admin_ProductList_paging 구현중 -->
			
            <div class="paging">
                <span class="prev">
            	<c:if test="${pageGroupStart > 1}">
                    <a href="${ctxPath}/admin/product/list.do"><&nbsp;이전</a>
                </c:if>
                </span>
				<c:forEach var="i" begin="${pageGroupStart}" end="${pageGroupEnd}" step="1">
                <span class="num">
					<c:set var="on" value="${currentPage == i}"/>
                    <a href="${ctxPath}/admin/product/list.do?pg=${i}" class="on">${i}</a>
                </span>
				</c:forEach>
                <span class="next">
    			<c:if test="${pageGroupEnd < lastPageNum}">
                    <a href="${ctxPath}/admin/product/list.do">다음&nbsp;></a>
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