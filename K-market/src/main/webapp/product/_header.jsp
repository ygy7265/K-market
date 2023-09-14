<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
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
                    <a href="/K-market/member/login.do">로그인</a>
                    <a href="/K-market/member/join.do">회원가입</a>
                    <a href="#">마이페이지</a>
                    <a href="/K-market/product/productcart.do">
                        <i class="fa fa-shopping-cart" aria-hidden="true">
                            &nbsp;장바구니
                        </i>
                    </a>
                </div>
            </div>
            <div class="logo">
                <div>
                    <a href="/K-market/"><img src="/K-market/images/header_logo.png" alt="로고"></a>
                    <form action="#">
                        <input type="text" name="keyword">
                        <button>
                            <i class="fa fa-search" aria-hidden="true"></i>
                        </button>
                    </form>
                </div>
            </div>
            <div class="menu">
                <div>
                    <ul>
                        <li><a href="/K-market/product/productlist.do">히트상품</a></li>
                        <li><a href="/K-market/product/productlist.do">추천상품</a></li>
                        <li><a href="/K-market/product/productlist.do">최신상품</a></li>
                        <li><a href="/K-market/product/productlist.do">인기상품</a></li>
                        <li><a href="/K-market/product/productlist.do">할인상품</a></li>
                    </ul>
                    <ul>
                        <li><a href="#">쿠폰존</a></li>
                        <li><a href="#">사용후기</a></li>
                        <li><a href="#">개인결제</a></li>
                        <li><a href="/K-market/cs/qna/qnaList.do">고객센터</a></li>
                        <li><a href="/K-market/cs/faq/faqList.do">FAQ</a></li>
                    </ul>
                   
                </div>
            </div>
        </header>