/**
 * 아이디, 이메일, 휴대폰 번호 중복 체크
 */

 
// 중복 검사
$(function(){
	
	// 아이디 중복 검사
	$('input[name=km_uid]').focusout(function(){
		const uid = $(this).val();
		
		console.log(uid);
		
		const jsonData = {
			"uid": uid	
		};
		
		$.ajax({
			url : '/K-market/member/checkUid.do',
			type: 'GET',
			data: jsonData,
			dataType: 'json',
			success:function(data){
				
				if(data.result >= 1){
					$(".msgId").css('color','red').text('이미 사용중인 아이디 입니다.');
				}else{
					$(".msgId").css('color','green').text('사용가능한 아이디 입니다.');
				}
				
			}
			
			
		}); // ajax end
	});
	
	// 이메일 중복 검사
	$('input[name=km_email]').focusout(function(){
		const email = $(this).val();
		
		console.log(email);
		
		const jsonData = {
			"email": email	
		};
		
		$.ajax({
			url : '/K-market/member/checkEmail.do',
			type: 'GET',
			data: jsonData,
			dataType: 'json',
			success:function(data){
				
				if(data.result >= 1){
					$(".msgEmail").css('color','red').text('이미 사용중인 이메일 입니다.');
				}else{
					$(".msgEmail").css('color','green').text('사용가능한 이메일 입니다.');
				}
				
			}
			
			
		}); // ajax end
	});
	
	// 휴대폰 중복 검사
	$('input[name=km_hp]').focusout(function(){
		const hp = $(this).val();
		
		console.log(hp);
		
		const jsonData = {
			"hp": hp	
		};
		
		$.ajax({
			url : '/K-market/member/checkHp.do',
			type: 'GET',
			data: jsonData,
			dataType: 'json',
			success:function(data){
				
				if(data.result >= 1){
					$(".msgHp").css('color','red').text('이미 사용중인 휴대폰번호 입니다.');
				}else{
					$(".msgHp").css('color','green').text('사용가능한 휴대폰번호 입니다.');
				}
				
			}
			
			
		}); // ajax end
	});
});