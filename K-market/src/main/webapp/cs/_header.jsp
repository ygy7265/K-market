<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>케이마켓 고객센터</title>
    <link rel="stylesheet" href="/K-market/cs/css/style.css" />
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
</head>
<body>
    <div id="container">
        <header>
            <div class="top">
                <div>
                    <p>
                    	<a href="/K-market/index.do">HOME</a>
                    	<c:if test="${empty user}">
                        <a href="/K-market/member/login.do">로그인</a>
                        <a href="/K-market/member/join.do">회원가입</a>
                        </c:if>
                        <c:if test="${not empty user}">
                        	<!-- 판매자, 관리자 링크 -->
			            	<c:if test="${user.type eq 5}">
				            <a href="/K-market/admin/index.do">판매자</a>
			            	</c:if>
			            	<a class="loginUser" href="/K-market/member/myPage.do">${user.uid}</a>
			            	<c:if test="${user.type eq 100}">
			            	<a href="/K-market/admin/index.do">관리자</a>
			            	</c:if>
                        <a href="/K-market/member/logout.do">로그아웃</a>
                        <a href="#">마이페이지</a>
                        <a href="/K-market/product/productcart.do">장바구니</a>
                        </c:if>
                    </p>
                </div>
            </div>
            <div class="logo">
                <div>
                    <a href="/K-market/cs/index.do">
                        <img src="/K-market/images/logo.png" alt="Kmarket">고객센터
                    </a>
                </div>
            </div>
        </header>