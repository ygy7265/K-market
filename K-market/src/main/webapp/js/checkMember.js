/**
 * 아이디, 이메일, 휴대폰 번호 중복 체크
 */

// 중복 검사
$(function(){
	
	// 아이디 중복 검사
	$('#btnId').click(function(){
		const uid = $('input[name=km_uid]').val();
		
		// 아이디 유효성 검증
		if(!uid.match(reUid)){
			$('.msgId1').css('color', 'red').text('유효한 아이디가 아닙니다.');
			isUidOk = false;
			return; // 종료
		}
		
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
					$(".msgId1").css('color','red').text('이미 사용중인 아이디 입니다.');
					isUidOk = false;
				}else{
					$(".msgId1").css('color','green').text('사용가능한 아이디 입니다.');
					isUidOk = true;
				}
				
			}
			
			
		}); // ajax end
	});
	
	// 이메일 중복 검사
	$('input[name=km_email]').focusout(function(){
		const email = $(this).val();
		
		if(!email.match(reEmail)){
			$('.msgEmail').css('color', 'red').text('유효한 이메일이 아닙니다.');
			isEmailOk = false;
			return; // 종료
		}
		
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
					isEmailOk = false;
				}else{
					$(".msgEmail").css('color','green').text('사용가능한 이메일 입니다.');
					isEmailOk = true;
				}
				
			}
			
			
		}); // ajax end
	});
	
	
	// 휴대폰 중복 검사(일반, 회사 전화번호)
	$('input[name=km_hp]').focusout(function(){
		const hp = $(this).val();
		
		if(!hp.match(reHp)){
			$('.msgHp1').css('color', 'red').text('유효한 번호가 아닙니다.');
			isHpOk = false;
			return;
		}
		
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
					$(".msgHp1").css('color','red').text('이미 사용중인 번호 입니다.');
					isHpOk = false;
				}else{
					$(".msgHp1").css('color','green').text('사용가능한 번호 입니다.');
					isHpOk = true;
				}
				
			}

		}); // ajax end
		
	});
	
});