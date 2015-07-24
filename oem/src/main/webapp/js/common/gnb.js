	function gnbMenuOpen(){
		if ( $('#menuSide').hasClass('menuSide_on') ) {
			$("#bg").hide();
			$("#menuSide").attr('class','menuSide');
			$("#mOllehGnb").css( 'margin-left', 0);
			$("#mOllehContainer").css( 'margin-left', 0);
			document.removeEventListener('DOMContentLoaded', loaded2, false);
		} else{
			$("#bg").show();
			var menuSide = $("#menuSide").outerHeight(true);
			var bodyHeight = $("body").outerHeight(true);
			$("#menuSide").attr('class','menuSide_on');
			if(menuSide > bodyHeight){
				$("body").height(menuSide);
			}
			$("#mOllehGnb").css( 'margin-left', $("#menuSide").width() );
			$("#mOllehContainer").css( 'margin-left', $("#menuSide").width() ); 

			function loaded2() {
				var myScroll2 = new iScroll('wrapper2', {
					 hScroll:false
					
				 });

			}

			document.addEventListener('DOMContentLoaded', loaded2, false);
		}
	}
	//공지사항 이용안내 등 이미지 변경 로직
	$(document).ready(function() {  
		var link =  document.location.href;
		if(link.indexOf("notice.jsp") > -1){
			$("#mOllehGnbIn").css('background-image',"url(images/notice/title_notice.gif)");
		}
		if(link.indexOf("help/info.jsp") > -1){
			$("#mOllehGnbIn").css('background-image',"url(images/notice/title_call.gif)");
		}
		if(link.indexOf("myring/") > -1){
			$("#mOllehGnbIn").css('background-image',"url(images/myring/title_myringtoyou.gif)");
		}
	});