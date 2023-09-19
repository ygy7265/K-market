/*main_index*/
$(document).ready(function () {
    $(".slider > ul").bxSlider({
      easing: "linear",
    });
  });

function scrollToTop() {
    window.scrollTo({
        top: 0,
        behavior: 'smooth'
    });
}
  $(function () {
    var best = $("aside > .best");
    const btnTop = $(".btnTop");

    $(window).scroll(function () {
      var t = $(this).scrollTop();

      if (t > 620) {
        best.css({
          position: "fixed",
          top: "0",
        });
      } else {
        best.css({ position: "static" });
      }
      
      // 버튼 Top
      if(t > 650) {
		  btnTop.css({
			  position: "fixed",
			  display: "block",
		  });
		  
	  } else {
		  btnTop.css({
			  position: "absolute",
			  display: "none",
		});
	  }
		
    });
    
    // 맨위로 가기
	$("#gotoTop").click(function(){
		scrollToTop();
	});

});

