<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="./_header.jsp" %>
<script>
	
	$(function(){
		
		const btnLogin = document.getElementById("btnLogin");
		const uid = document.getElementsByName("uid")[0].value;
		const pass = document.getElementsByName("pass")[0].value;
		const autoCheck = document.getElementsByName("auto")[0];
		let isChecked = false;
		
		// 자동로그인 체크 여부
		autoCheck.addEventListener('change', function(){
			isChecked = this.checked;

			console.log('체크 여부 : ',isChecked);
			
			// 로그인 전송
			btnLogin.addEventListener('click',function(){
				
				const loginData = {
					"uid": uid,
					"pass": pass,
					"auto": isChecked
				};
				
				$.ajax({
					url : '/K-market/member/login.do',
					type: 'POST',
					contentType: 'text/plain',
					data: loginData,
					dataType: text,
					success:function(data){
						console.log(data);
					}
					
				}); // ajax end
			}); // btnLogin end
		}); // autoCheck end
		
	});
</script>
<main id="member">
	<div class="login">
		<nav>
		    <h1>로그인</h1>                    
		</nav>
		   
		<form action="#" method="POST">
		
			<table border="0">
				<tr>
				    <td>아이디</td>
				    <td><input type="text" name="uid" placeholder="아이디 입력"></td>
				</tr>
				<tr>
				    <td>비밀번호</td>
				    <td><input type="password" name="pass" placeholder="비밀번호 입력"></td>
				</tr>
			</table>					
			<input type="submit" id="btnLogin" value="로그인" />
			<span>
				<label><input type="checkbox" name="auto"/>자동 로그인</label>
				<a href="#">아이디찾기</a>
				<a href="#">비밀번호찾기</a>
				<a href="/K-market/member/join.do">회원가입</a>
			</span>
			
			<a href="https://safelogin.kr/sauth/regist?site_code=NA&sub_code=0" class="banner"><img src="/K-market/images/member_login_banner.jpg" alt="1만원 할인 쿠폰 받기"></a>
		
		</form>
		<img src="/K-market/images/member_certifi_logo.gif" alt="banner">
	</div>
</main>        
<%@ include file="../_footer.jsp" %>