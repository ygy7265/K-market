<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="./_header.jsp"%>
		<!-- 
			날짜 : 2023/09/13
			이름 : 이현정
			내용 : Terms 약관 페이지 내용 출력 및 약관 동의 기능 추가 
		 -->
<script>
	window.onload = function(){
		
		const agree1 = document.getElementsByName('agree1')[0];
		const agree2 = document.getElementsByName('agree2')[0];
		const agree3 = document.getElementsByName('agree3')[0];
		const agree4 = document.getElementsByName('agree4')[0];
		
		const typeInput = document.getElementsByName('type')[0];
		const type = typeInput.value;
		
		// 모두 동의 체크
		$('input[name=all]').change(function(){
			const isChecked = $(this).is(':checked');
			
			if(isChecked){
				$('input[type=checkbox]').prop('checked',true);
			}else{
				$('input[type=checkbox]').prop('checked',false);
			}
		});
		
		// 약관 동의
		const agree = document.querySelector('.agree');
		agree.addEventListener('click', function(e){
			e.preventDefault();
			
			if(!agree1.checked){
				alert('이용약관에 동의하셔야 합니다.');
				return;
			}else if(!agree2.checked){
				alert('전자금융거래 이용약관에 동의하셔야 합니다.');
				return;
			}else if(!agree3.checked){
				alert('개인정보 수집동의에 동의하셔야 합니다.');
				return;
			}else{
				
				// 일반 회원, 판매 회원 구분
				if(type == 'normal'){
					location.href ="/K-market/member/register.do";
				}else{
					location.href ="/K-market/member/registerSeller.do";
				}
			}
		})
	}
</script>
<main id="member">
	<div class="signup">
		<nav>
			<h1>약관동의</h1>
		</nav>
		<input type="hidden" name="type" value="${type}" />
		<section>
			<h3>
				<span class="essential">(필수)</span>케이마켓 이용약관
			</h3>
			<textarea class="terms" readonly>${type eq 'normal' ? dto.terms : dto.tax}"</textarea>
			<label><input type="checkbox" name="agree1" />동의합니다.</label>
			<h3>
				<span class="essential">(필수)</span>전자금융거래 이용약관
			</h3>
			<textarea class="financial" readonly>${dto.finance}</textarea>
			<label><input type="checkbox" name="agree2" />동의합니다.</label>

			<h3>
				<span class="essential">(필수)</span>개인정보 수집동의
			</h3>
			<textarea class="privacy" readonly>${dto.privacy}</textarea>
			<label><input type="checkbox" name="agree3" />동의합니다.</label>
		</section>

		<section>
			<h3>
				<span class="optional">(선택)</span>위치정보 이용약관
			</h3>
			<textarea class="location" readonly>${dto.location}</textarea>
			<label><input type="checkbox" name="agree4" />동의합니다.</label>
		</section>
		
		<div class="allCheck">
			<label><input type="checkbox" name="all"/>모두 동의합니다.</label>
		</div>
		
		<div>
			<input type="button" class="agree" value="동의하기" />
		</div>
	</div>
</main>
<%@ include file="../_footer.jsp"%>