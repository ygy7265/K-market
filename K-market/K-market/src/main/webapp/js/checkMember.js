/**
 * 아이디, 이메일, 휴대폰 번호 중복 체크
 */

/*	let isUidOk		= false;
	let isPassOk	= false;
	let isNameOk	= false;
	let isEmailOk	= false;
	let isHpOk		= false;
	
	let reUid   = /^[a-z]+[a-z0-9]{4,12}$/g;
	let rePass  = /^(?=.*[a-zA-z])(?=.*[0-9])(?=.*[$`~!@$!%*#^?&\\(\\)\-_=+]).{8,12}$/;
	let reName  = /^[가-힣]{2,10}$/ 
	let reEmail = /^[0-9a-zA-Z]([-_\.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_\.]?[0-9a-zA-Z])*\.[a-zA-Z]{2,3}$/i;
	let reHp    = /^01(?:0|1|[6-9])-(?:\d{4})-\d{4}$/;*/
 
// 중복 검사
$(function(){
	
	// 아이디 중복 검사
	$('input[name=km_uid]').focusout(function(){
		const uid = $(this).val();
		
		// 아이디 유효성 검증
		if(!uid.match(reUid)){
			$('.msgId').css('color', 'red').text('유효한 아이디가 아닙니다.');
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
					$(".msgId").css('color','red').text('이미 사용중인 아이디 입니다.');
					isUidOk = false;
				}else{
					$(".msgId").css('color','green').text('사용가능한 아이디 입니다.');
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
				}else{
					$(".msgEmail").css('color','green').text('사용가능한 이메일 입니다.');
				}
				
			}
			
			
		}); // ajax end
	});
	
	// 휴대폰 중복 검사
	$('input[name=km_hp]').focusout(function(){
		const hp = $(this).val();
		
		if(!hp.match(reHp)){
			$('.msgHp').css('color', 'red').text('유효한 휴대폰 번호가 아닙니다.');
			isHpOk = false;
			return; // 종료
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
					$(".msgHp").css('color','red').text('이미 사용중인 휴대폰번호 입니다.');
				}else{
					$(".msgHp").css('color','green').text('사용가능한 휴대폰번호 입니다.');
				}
				
			}
			
			
		}); // ajax end
	});
});