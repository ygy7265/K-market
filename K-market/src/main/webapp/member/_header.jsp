<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<script>
	const success = ${success};
	 var userUid = "${user.uid}";
	switch (success) {
	case 101:
		alert(user+' 님 환영합니다. ');
		break;
	case 102:
		alert('로그인 실패');
		break;
	case 103:
		alert('로그인이 필요한 서비스입니다.');
		break;
	case 200:
		alert('정상적으로 로그아웃 되었습니다.');
		break;
	default:
		break;
	}
</script>
<head>
    <meta charset="UTF-8">    
    <title>케이마켓::대한민국 1등 온라인 쇼핑몰</title>    
    <link rel="shortcut icon" type="image/x-icon" href="../images/favicon.ico" />
    <link rel="stylesheet" href="https://ajax.googleapis.com/ajax/libs/jqueryui/1.12.1/themes/smoothness/jquery-ui.css">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css"/>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/bxslider/4.2.12/jquery.bxslider.css">
    <link rel="stylesheet" href="/K-market/css/style.css"/>
    <link rel="stylesheet" href="/K-market/member/css/member.css"/>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jqueryui/1.12.1/jquery-ui.min.js"></script>
    <script src="https://kit.fontawesome.com/20962f3e4b.js" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/bxslider/4.2.12/jquery.bxslider.min.js"></script>
</head>
<body>
    <div id="wrapper">
        <header>
            <div class="top">
                <div>
                    <a href="/K-market/member/login.do">로그인</a>
                    <a href="/K-market/member/join.do">회원가입</a>
                    <c:if test="${not empty user}">
                    <a href="#">마이페이지</a>
                    <a href="/K-market/product/productcart.do"><i class="fa fa-shopping-cart" aria-hidden="true"></i>&nbsp;장바구니</a>
                    </c:if>
                </div>
            </div>
            <div class="logo">
                <div>
                    <a href="/K-market/"><img src="/K-market/images/header_logo.png" alt="로고"/></a>
                </div>
            </div>
        </header>