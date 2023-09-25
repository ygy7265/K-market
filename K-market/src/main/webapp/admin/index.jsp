<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="./_header.jsp" %>
<%@ include file="./_aside.jsp" %>

    <section id="admin-index">
        <nav>
            <h3>관리자 메인</h3>
            <p>
                HOME > <strong>메인</strong>
            </p>
        </nav>

        <h4>쇼핑몰 운영현황</h4>
        <article>
            <table>	
                <tr>
                    <td>
                        <strong>주문건수(건)</strong>
                        <span>${total}건</span>
                    </td>
                    <td>
                        <strong>주문금액(원)</strong>
                        <span>${sumtotal} 원</span>
                    </td>
                    <td>
                        <strong>회원가입(명)</strong>
                        <span>${cmember} 명</span>
                    </td>
                    <td>
                        <strong>쇼핑몰 방문(명)</strong>
                        <span>1014</span>
                    </td>
                    <td>
                        <strong>신규게시물(건)</strong>
                        <span>${weekProd} 건</span>
                    </td>
                </tr>
                <tr>
                    <td>
                        <p>
                            <span>PC</span>
                            <span>60</span>
                        </p>
                        <p>
                            <span>Mobile</span>
                            <span>71</span>
                        </p>
                    </td>
                    <td>
                        <p>
                            <span>PC</span>
                            <span>60</span>
                        </p>
                        <p>
                            <span>Mobile</span>
                            <span>71</span>
                        </p>
                    </td>
                    <td>
                        <p>
                            <span>PC</span>
                            <span>60</span>
                        </p>
                        <p>
                            <span>Mobile</span>
                            <span>71</span>
                        </p>
                    </td>
                    <td>
                        <p>
                            <span>PC</span>
                            <span>60</span>
                        </p>
                        <p>
                            <span>Mobile</span>
                            <span>71</span>
                        </p>
                    </td>
                    <td>
                        <p>
                            <span>PC</span>
                            <span>60</span>
                        </p>
                        <p>
                            <span>Mobile</span>
                            <span>71</span>
                        </p>
                    </td>
                </tr>
                <!-- 주문건수 -->
                <tr>
                    <td>
                        <p>
                            <span>어제</span>
                            <span>${dayOrder} 건</span>
                        </p>
                        <p>
                            <span>주간</span>
                            <span>${weekOrder} 건</span>
                        </p>
                        <p>
                            <span>월간</span>
                            <span>${monthOrder} 건</span>
                        </p>
                    </td>
                    <!-- 주문금액 -->
                    <td>
                        <p>
                            <span>어제</span>
                            <span>${dayOrderToPrice} 원</span>
                        </p>
                        <p>
                            <span>주간</span>
                            <span>${weekOrderToPrice} 원</span>
                        </p>
                        <p>
                            <span>월간</span>
                            <span>${monthOrderToPrice} 원</span>
                        </p>
                    </td>
                    <!-- 회원가입 -->
                    <td>
                        <p>
                            <span>어제</span>
                            <span>${dayMember} 명</span>
                        </p>
                        <p>
                            <span>주간</span>
                            <span>${weekMember} 명</span>
                        </p>
                        <p>
                            <span>월간</span>
                            <span>${monthMember} 명</span>
                        </p>
                    </td>
                    <!-- 방문자 -->
                    <td>
                        <p>
                            <span>어제</span>
                            <span>4 명</span>
                        </p>
                        <p>
                            <span>주간</span>
                            <span>10 명</span>
                        </p>
                        <p>
                            <span>월간</span>
                            <span>30 명</span>
                        </p>
                    </td>
                    <!-- 새로 등록된 상품 -->
                    <td>
                        <p>
                            <span>어제</span>
                            <span>${dayProd} 건</span>
                        </p>
                        <p>
                            <span>주간</span>
                            <span>${weekProd} 건</span>
                        </p>
                        <p>
                            <span>월간</span>
                            <span>${monthProd} 건</span>
                        </p>
                    </td>		
                </tr>
            </table>
        </article>

        <h4>주문 업무현황</h4>
        <article>
            <table>
                <tr>
                    <td>
                        <strong>입금대기(건)</strong>
                        <span>100</span>
                    </td>
                    <td>
                        <strong>배송준비(건)</strong>
                        <span>100</span>
                    </td>
                    <td>
                        <strong>취소요청(건)</strong>
                        <span>100</span>
                    </td>
                    <td>
                        <strong>교환요청(건)</strong>
                        <span>100</span>
                    </td>
                    <td>
                        <strong>반품요청(건)</strong>
                        <span>100</span>
                    </td>
                </tr>
            </table>                    
        </article>
        <div>
            <div>
                <h4>공지사항</h4>
                <article>
					<c:forEach var="noti" items="${notiAdmin}">
                    <p>
                        <span><a href="${ctxPath}/admin/cs/notice/view.do?noticeNo=${noti.noticeNo}">${noti.title}</a></span>
                        <span>${noti.formatDate()}</span>
                    </p>
                    </c:forEach>
                </article>
            </div>
            <div>
                <h4>고객문의</h4>
                <article>
					<c:forEach var="qna" items="${qnaAdmin}">
                    <p>
                        <span>${qna.title}</span>
                        <span>${qna.formatDate()}</span>
                    </p>
                    </c:forEach>
                </article>
            </div>
        </div>
    </section>
</main>
<%@ include file="./_footer.jsp" %>