<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%> 
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>product</title>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jqueryui/1.12.1/jquery-ui.min.js"></script>
    <script src="https://kit.fontawesome.com/20962f3e4b.js" crossorigin="anonymous"></script>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/bxslider/4.2.12/jquery.bxslider.css">
    <link rel="stylesheet" href="https://ajax.googleapis.com/ajax/libs/jqueryui/1.12.1/themes/smoothness/jquery-ui.css">
    <script src="https://cdn.jsdelivr.net/bxslider/4.2.12/jquery.bxslider.min.js"></script>
    <link rel="stylesheet" href="/K-market/css/style.css" />
    
    
</head>
<style>

</style>
<body>
    <div id=" wrapper">
        <header>
            <div class="top">
                <div>
                	<c:if test="${empty user}">
                    <a href="/K-market/member/login.do">로그인</a>
                    <a href="/K-market/member/join.do">회원가입</a>
                    </c:if>
                    <c:if test="${not empty user}">
                    	<!-- 판매자, 관리자 링크 -->
		            	<c:if test="${user.type eq 5}">
			            <a href="/K-market/admin/index.do">판매자</a>
		            	</c:if>
	            		<c:if test="${user.type eq 100}">
		            	<a href="/K-market/admin/index.do">관리자</a>
		            	</c:if>
                    <a href="/K-market/member/logout.do">로그아웃</a>
                    <a href="#">마이페이지</a>
                    <a href="/K-market/product/productcart.do">
                        <i class="fa fa-shopping-cart" aria-hidden="true">
                            &nbsp;장바구니
                        </i>
                    </a>
                    </c:if>
                </div>
            </div>
            <div class="logo">
                <div>
                    <a href="/K-market/"><img src="/K-market/images/header_logo.png" alt="로고"></a>
                    <form action="/K-market/product/productlist.do" method="get">
                        <input type="text" name="search">
                        <button>
                            <i class="fa fa-search" aria-hidden="true"></i>
                        </button>
                    </form>
                </div>
            </div>
            <div class="menu">
                <div>
                    <ul>
                        <li class=""><a href="/K-market/product/productlistSpecial.do?type1=hit">히트상품</a></li>
                        <li class=""><a href="/K-market/product/productlistSpecial.do?type1=score">추천상품</a></li>
                        <li class=""><a href="/K-market/product/productlistSpecial.do?type1=new">최신상품</a></li>
                        <li class=""><a href="/K-market/product/productlistSpecial.do?type1=best">인기상품</a></li>
                        <li class=""><a href="/K-market/product/productlistSpecial.do?type1=discount">할인상품</a></li>
                    </ul>
                    <ul>
                        <li><a href="#">쿠폰존</a></li>
                        <li><a href="#">사용후기</a></li>
                        <li><a href="#">개인결제</a></li>
                    	<li><a href="/K-market/cs/index.do">고객센터</a></li>
                        <li><a href="/K-market/cs/faq/faqList.do?cate1=10">FAQ</a></li>
                    </ul>
                   
                </div>
            </div>
        </header>