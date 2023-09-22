/**
 * 데이터 유효성 검사
 */

//폼 데이터 검증 상태변수
let isUidOk		= false;
let isPassOk	= false;
let isNameOk	= false;
let isEmailOk	= false;
let isHpOk		= false;
let isFaxOk		= false;
let isCompanyOk	= false;
let isBizOk		= false;
let isManagerOk	= false;
let isManagerHpOk= false;

// 데이터 검증에 사용하는 정규표현식
let reUid   = /^[a-z]+[a-z0-9]{4,12}$/g;
let rePass  = /^(?=.*[a-zA-z])(?=.*[0-9])(?=.*[$`~!@$!%*#^?&\\(\\)\-_=+]).{8,12}$/;
let reName  = /^[가-힣]{2,10}$/ 
let reEmail = /^[0-9a-zA-Z]([-_\.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_\.]?[0-9a-zA-Z])*\.[a-zA-Z]{2,3}$/i;
let reHp    = /^01(?:0|1|[6-9])-(?:\d{4})-\d{4}$/;
let reFax	= /^(0[2-8][0-5]?)-?([1-9]{1}[0-9]{2,3})-?([0-9]{4})$/;
let reCompany = /^\(주\)[a-zA-Z가-힣]{2,}$/;
let reBiz = /^[0-9]{3}-[0-9]{2}-[0-9]{5}$/;

// 유효성 검사(Validation)
$(function(){
	
	// 아이디 검사
	$('input[name=km_uid]').keydown(function(){ // 유효한 아이디를 검사한 후 다시 아이디 값을 조작할 시
		$('.msgId1').text('');
		isUidOk = false;
	});
	
	// 비밀번호 검사
	$('input[name=km_pass2]').focusout(function(){
		
		const pass1 = $('input[name=km_pass1]').val();
		const pass2 = $('input[name=km_pass2]').val();
		
		if(pass1 == pass2){
			
			if(pass1.match(rePass)){ // 유효성 검사
				$('.msgPass1').css('color','green').text('사용할 수 있는 비밀번호 입니다.');
				isPassOk = true;
			} else {
				$('.msgPass1').css('color', 'red').text('비밀번호는 숫자, 영문, 특수문자 조합 8자리 이상이어야 합니다.');
				isPassOk = false;
			}
			
		} else { // 두 비밀번호가 일치하지 않을 시
			$('.msgPass1').css('color', 'red').text('비밀번호가 일치하지 않습니다.');
			isPassOk = false;
		}
		
	});
	
	// 이름 검사(일반 회원, 대표자)
	$('input[name=km_name]').focusout(function(){
		
		const name = $(this).val();
		
		if(name.match(reName)){
			$('.msgName').text('');
			$('.msgCeo').text('');
			isNameOk = true;
		}else{
			$('.msgName').css('color', 'red').text('유효한 이름이 아닙니다.');
			$('.msgCeo').css('color', 'red').text('유효한 대표자명이 아닙니다.');
			isNameOk = false;
		}
		
	});
	// 이름 검사(담당자)
	$('input[name=kms_manager]').focusout(function(){
		
		const manager = $(this).val();
		
		if(manager.match(reName)){
			$('.msgManager').text('');
			isManagerOk = true;
		} else {
			$('.msgManager').css('color', 'red').text('유효한 이름이 아닙니다.');
			isManagerOk = false;
		}
		
	});
	
	// 회사명 검사
	$('input[name=kms_company]').focusout(function(){
		const company = $(this).val();
		
		if(company.match(reCompany)){
			$('.msgCompany1').text('');
			isCompanyOk = true;
		} else {
			$('.msgCompany1').css('color', 'red').text('(주)포함하여 다시 입력해주십시오.');
			isCompanyOk = false;
		}
		
	});
	
	// 사업자등록번호 검사
	$('input[name=kms_corp_reg]').focusout(function(){
		const bizNum = $(this).val();
		
		if(bizNum.match(reBiz)){
			$('.msgCorp1').text('');
			isBizOk = true;
		} else {
			$('.msgCorp1').css('color', 'red').text('유효하지 않은 사업자등록번호입니다.');
			isBizOk = false;
		}
	});
	
	// 팩스번호 검사
	$('input[name=kms_fax]').focusout(function(){
		const fax = $(this).val();
		
		if(fax.match(reFax)){
			$('.msgFax1').text('');
			isFaxOk = true;
		} else {
			$('.msgFax1').css('color', 'red').text('유효하지 않은 번호입니다.');
			isFaxOk = false;
		}
	});
	
	// 회사 이메일 검사
	$('input[name=kms_email]').focusout(function(){
		const email = $(this).val();
		
		if(email.match(reEmail)){
			$('.msgEmail').text('');
			isEmailOk = true;
		} else {
			$('.msgEmail').css('color', 'red').text('유효하지 않은 이메일입니다.');
			isEmailOk = false;
		}
	});
	
	// 담당자 번호 검사
	$('input[name=kms_managerHp]').focusout(function(){
		const managerHp = $(this).val();
		
		if(managerHp.match(reHp)){
			$('.msgManagerHp1').text('');
			isManagerHpOk = true;
		} else {
			$('.msgManagerHp1').css('color', 'red').text('유효하지 않은 번호입니다.');
			isManagerHpOk = false;
		}
	});
	
	// 최종 전송
	$('#formMember').submit(function(){
		
		if(!isUidOk){
			alert('아이디를 확인 하십시요.');
			return false; // 폼 전송 취소	
		}
		
		if(!isPassOk){
			alert('비밀번호를 확인 하십시요.');
			return false; // 폼 전송 취소	
		}
		
		if(!isNameOk){
			alert('이름를 확인 하십시요.');
			return false; // 폼 전송 취소	
		}
		
		if(!isEmailOk){
			alert('이메일을 확인 하십시요.');
			return false; // 폼 전송 취소	
		}
		
		if(!isHpOk){
			alert('번호를 확인 하십시요.');
			return false; // 폼 전송 취소	
		}
		
		// 판매회원 전용
		if ($('input[name=kms_fax]').length > 0){
			if(!isFaxOk){
				alert('팩스 번호를 확인 하십시요.');
				return false; // 폼 전송 취소	
			}
			
			if(!isCompanyOk){
				alert('회사명을 확인 하십시요.');
				return false; // 폼 전송 취소	
			}
			
			if(!isBizOk){
				alert('사업자등록번호를 확인 하십시요.');
				return false; // 폼 전송 취소	
			}
			
			if(!isManagerOk){
				alert('담당자 이름을 확인 하십시요.');
				return false; // 폼 전송 취소	
			}
			
			if(!isManagerHpOk){
				alert('담당자 번호를 확인 하십시요.');
				return false; // 폼 전송 취소	
			}
		}
						
		return true; // 폼 전송 시작
	});
});