<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../_header.jsp" %>
<script>

$(function(){
	/* const jsondata1 = {
			jsondatavalue: [] // cate2 값을 저장할 배열
			};

			// jsondata 객체를 출력하여 확인
			console.log(jsondata1);
			console.log(typeof JSON.stringify(jsondata1));
			const array =  [];
			<c:forEach var="cate" items="${cates}">
			  array.push("${cate.cate2}");
			</c:forEach>;
			console.log(typeof array);
			console.log(typeof JSON.stringify(array)); */
/* 	$.ajax({
		url:'/K-market/cs/faq/faqList.do',
		type:'POST',
		traditional : true,
		data: {array:array},
		contentType: "application/x-www-form-urlencoded; charset=UTF-8",
		dataType:'json',
		success:function(data){
			for (var i = 0; i < array.length; i++) {
				$(".catename").eq(i).text(data.result[i]);
				console.log("data = "+ data.result[i]);
			}
		}
	});
			 */
	$('#category1').change(function(){
		 var selectedValue = $(this).val();
		 console.log('1차 분류 선택 값:', selectedValue);
		  $('#category2').empty();
		 const jsonData = {
				 "jsondata" : selectedValue
		 }
		 $.ajax({
				url:'/K-market/admin/product/modify.do',   
				type:'GET',
				traditional : true,
				data: jsonData,
				contentType: "application/x-www-form-urlencoded; charset=UTF-8",
				dataType:'json',
				success:function(data){
					console.log(data.jsonArray);
					var selectElement = $("#category2"); // jQuery를 사용하여 <select> 요소를 선택

				    for (var i = 0; i < data.jsonArray.length; i++) {
				        var optionData = data.jsonArray[i];
				        var optionValue = optionData.cate2; // 옵션의 값
				        var optionText = optionData.c2Name; // 옵션의 텍스트
						console.log(optionData.propertycate1);
				        // <option> 요소를 생성하고 속성을 설정하여 추가
				        $("<option>")
				            .text(optionData.propertyName1) // 옵션의 텍스트 설정
				            .val(optionData.propertycate1)
				            .appendTo(selectElement); // <select> 요소에 옵션 추가
				        console.log(data.jsonArray[0].propertyName1);
				    }
				}
		});
	})
	 
});

</script>
<%@ include file="../_aside.jsp" %>
    <section id="admin-product-register">
        <nav>
            <h3>상품등록</h3>
            <p>
                HOME > 상품관리 > <strong>상품수정</strong>
            </p>
        </nav>
        <!-- 상품등록 컨텐츠 시작 -->
        <!-- file 수정 해야함 0921 현재 수정페이지는 등록된 상품 select 해서 data불러오기만 된 상태 -->
        <article>
            <form action="${ctxPath}/admin/product/modify.do" method="POST" enctype="multipart/form-data">
            <!-- seller 로그인정보 받아올 수 있게 수정 필요_insert완료/09_15 -->
			<input type="hidden" value="seller1" name="seller1"/>
                <!-- 상품분류 -->
                <section>
                    <h4>상품분류</h4>
                    <p>
                        기본분류는 반드시 선택하셔야 합니다. 하나의 상품에 1개의 분류를 지정 합니다.
                    </p>
                    <table>
                        <tr>
                            <td>1차 분류</td>
                            <td>
                           		<select name="cate1" id="category1">
                            		<c:forEach var="cate1s" items="${cate1s}">
	                                    <option value="${cate1s.cate1}">${cate1s.c1Name}</option>
                                    </c:forEach>                                           
                                </select>
                            
                            </td>
                        </tr>
                        <tr>
                            <td>2차 분류</td>
                            <td>
				                <select name="cate2" id="category2">
				                        <option value="#">${cate2s.c2Name}</option>
				                </select>
                            </td>
                        </tr>
                    </table>
                </section>
                
                <!-- 기본정보 -->
                <section>
                    <h4>기본정보</h4>
                    <p>
                        기본정보는 반드시 입력해야 합니다.
                    </p>
                    <table>
                        <tr>
                            <td>상품명</td>
                            <td><input type="text" name="prodName" value="${pDTO.prodName}"/></td>
                        </tr>
                        <tr>
                            <td>기본설명</td>
                            <td>
                                <span>상품명 하단에 상품에 대한 추가적인 설명이 필요한 경우에 입력</span>
                                <input type="text" name="descript" value="${pDTO.descript}"/>
                            </td>
                        </tr>
                        <tr>
                            <td>제조사</td>
                            <td><input type="text" name="company" value="${pDTO.company}"/></td>
                        </tr>
                        <tr>
                            <td>판매가격</td>
                            <td><input type="text" name="price" value="${pDTO.price}"/>원</td>
                        </tr>                                    
                        <tr>
                            <td>할인율</td>
                            <td>
                                <span>0을 입력하면 할인율 없음</span>
                                <input type="text" name="discount" value="${pDTO.discount}"/>%
                            </td>
                        </tr>
                        <tr>
                            <td>포인트</td>
                            <td>
                                <span>0을 입력하면 포인트 없음</span>
                                <input type="text" name="point" value="${pDTO.point}"/>점
                            </td>
                        </tr>
                        <tr>
                            <td>재고수량</td>
                            <td><input type="text" name="stock" value="${pDTO.stock}"/>개</td>
                        </tr>
                        <tr>
                            <td>배송비</td>
                            <td>
                                <span>0을 입력하면 배송비 무료</span>
                                <input type="text" name="delivery" value="${pDTO.delivery}"/>원
                            </td>
                        </tr>
                        <tr>
                            <td>상품 썸네일</td>
                            <td>
                                <span>크기 190 x 190, 상품 목록에 출력될 이미지 입니다. </span>
                                <input type="file" name="thumb1" value="${pDTO.thumb1}"/>

                                <span>크기 230 x 230, 상품 메인에 출력될 이미지 입니다. </span>
                                <input type="file" name="thumb2" value="${pDTO.thumb2}"/>

                                <span>크기 456 x 456, 상품 상세에 출력될 이미지 입니다. </span>
                                <input type="file" name="thumb3" value="${pDTO.thumb3}"/>
                            </td>
                        </tr>
                        <tr>
                            <td>상세 상품정보</td>
                            <td>
                                <span>크기 가로 940px 높이 제약없음, 크기 최대 1MB, 상세페이지 상품정보에 출력될 이미지 입니다.</span>
                                <input type="file" name="detail" value="${pDTO.detail}"/>
                            </td>
                        </tr>
                    </table>                                
                </section>

                <!-- 상품정보 제공 고시 -->
                <section>
                    <h4>상품정보 제공고시</h4>
                    <p>
                        [전자상거래에 관한 상품정보 제공에 관한 고시] 항목에 의거 등록해야 되는 정보입니다.
                    </p>
                    <table>
                        <tr>
                            <td>상품상태</td>
                            <td><input type="text" name="status" value="${pDTO.status}"/></td>
                        </tr>
                        <tr>
                            <td>부가세 면세여부</td>
                            <td><input type="text" name="duty" value="${pDTO.duty}"/></td>
                        </tr>
                        <tr>
                            <td>영수증발행</td>
                            <td><input type="text" name="receipt" value="${pDTO.receipt}"/></td>
                        </tr>
                        <tr>
                            <td>사업자구분</td>
                            <td><input type="text" name="bizType" value="${pDTO.bizType}"/></td>
                        </tr>                                
                        <tr>
                            <td>원산지</td>
                            <td><input type="text" name="origin" value="${pDTO.origin}"/></td>
                        </tr>                                
                    </table>                                
                </section>
                
                <input type="submit" value="수정하기"/>
            </form>
        </article>

        <p class="ico alert">
            <strong>Warning!</strong>
            전자상거래 등에서의 상품 등의 정보제공에 관한 고시에 따라 총 35개 상품군에 대해 상품 특성 등을 양식에 따라 입력할 수 있습니다.
        </p>
        <!-- 상품등록 컨텐츠 끝 -->
    </section>
</main>
<%@ include file="../_footer.jsp" %>