var	preListenPlayer = {

	fullSizeX : null,
	playbarEmptySize : null,
	pointerX : null,
	playTimeAll : null,
	canvas : null,
	context : null,
	audioPlayer : null,
	barClickAction : false,
	nowPlaying : false,
	
	init: function() {		
		this.beforeBind();
		this.bind();
		this.afterBind();
	},

	beforeBind: function() {
	},

	bind: function() {		

	},

	afterBind: function() {
	},

	fn: {		
		/**main list**/
		getImageAjax : function(code) {
			var	param = {
				"file_xring" : code
			};
			var	opts = {
				url		: "/data/getImageAjax",
				data	: param,
				type	: "post",
				async	: false,
				sendDataType	: "form",
				success	: function(resJSON, resCode) {
					if (resCode == "success") {
						$("#sing_image").attr("src", resJSON.data);
					}else{	
						alert("오류가 발생하였습니다.");
					}					
				}
				
			};
			common.http.ajax(opts);
		}
	},
	ui: {
		playerOpen : function(code, title, singer, playType){
			/*playType에 따라 설정 버튼 보여주고 안보여주고 세팅*/
			if(playType =="myRing"){
				$("#pre_liste_set_div").hide();
			}else{
				$("#pre_liste_set_div").show();
			}

			var charge = "";
			var code2 = Number(code)+1 +"";
			var code3 = Number(code)+2 +"";

			/*예외 상황 추가 링코드 잘 못 되었을 때 20150414 이만규 Start*/
			if(code == "31440407111463"){
				code2 = "31440407111472";
				code3 = "31440407111479";
			}
			if(code == "31440407111464"){
				code2 = "31440407111473";
				code3 = "31440407111480";
			}
			/*예외 상황 추가 링코드 잘 못 되었을 때 20150414 이만규 End*/
			var xringUrl  = "";
			var xringUrl2 = "";
			var xringUrl3 = "";
			$("#player_radio_img1").attr("src", "images/player/radio_off.png");
			$("#player_radio_img2").attr("src", "images/player/radio_off.png");
			$("#player_radio_img3").attr("src", "images/player/radio_off.png");

			$("#player_radio_img1").attr("src", "images/player/radio_on.png");

			var image_url = preListenPlayer.fn.getImageAjax(code);
			


			$("#layerOverlay").show();
			$("#layerPop01").show();

			if("31440416093914"==code || "31440416093917"==code || "31440416093920"==code || "31440416093923"==code || "31440416093926"==code || "31440416094568"==code || "31440416094571"==code || "31440409110090"==code || "31440409110093"==code)
			{
				charge = "무료";
				$("#pre_liste_present_div").hide();
			}
			else
			{
				charge = "1300원(VAT별도)"
				$("#pre_liste_present_div").show();
			}
			if($("#pre_isFreeR2uPlus").val()=="true"){
				charge = "무료(링투유플러스무료)";
			}

			$("#preListenTitle").empty();
			$("#preListenArtist").empty();
			$("#preListenCharge").empty();			
			$("#preListenTitle").append("곡명 : " + title);
			$("#preListenArtist").append("가수 : " + singer);
			$("#preListenCharge").append(" ");

			xringUrl  = "http://ktfring2youp.magicn.com:11000/" + code.substring(0, 4) + "/" + code.substring(4, 5) + "/" + code.substring(5, 8) + "/" + code.substring(13, 14) + "/mp3/"+ code +".mp3";
			xringUrl2 = "http://ktfring2youp.magicn.com:11000/" + code2.substring(0, 4) + "/" + code2.substring(4, 5) + "/" + code2.substring(5, 8) + "/" + code2.substring(13, 14) + "/mp3/"+ code2 +".mp3";
			xringUrl3 = "http://ktfring2youp.magicn.com:11000/" + code3.substring(0, 4) + "/" + code3.substring(4, 5) + "/" + code3.substring(5, 8) + "/" + code3.substring(13, 14) + "/mp3/"+ code3 +".mp3";

			preListenPlayer.ui.playerInit(xringUrl);
			$("#pre_song_code1").val(xringUrl);
			$("#pre_song_code2").val(xringUrl2);
			$("#pre_song_code3").val(xringUrl3);
			$("#present_play_gugan").val("1");
			$("#present_play_song_code").val(code);
			$("#orginal_play_song_code").val(code);
			
			document.body.scrollTop = 0;
			
			preListenPlayer.ui.play();
		},		
		playerClose : function(){
			$("#layerOverlay").hide();
			$("#layerPop01").hide();
			$("#stateLeftArea").css('width',0);
			try
			{
				preListenPlayer.audioPlayer.currentTime = 0;
			}catch(err){}
			preListenPlayer.ui.pause();
		},		

		chageMusic : function(index){
			preListenPlayer.ui.stop();
			$("#player_radio_img1").attr("src", "images/player/radio_off.png");
			$("#player_radio_img2").attr("src", "images/player/radio_off.png");
			$("#player_radio_img3").attr("src", "images/player/radio_off.png");

			$("#player_radio_img"+index+"").attr("src", "images/player/radio_on.png");
			preListenPlayer.ui.playerInit($("#pre_song_code"+index+"").val());
			$("#present_play_gugan").val(index);
			var code = "";
			var tmp_code = $("#orginal_play_song_code").val();

			if(index == "1"){			
				code = tmp_code;
			}else if(index =="2"){
				code = Number(tmp_code)+1 +"";
			}else{
				code = Number(tmp_code)+2 +"";
			}
			$("#present_play_song_code").val(code);
			document.body.scrollTop = 0;
			preListenPlayer.ui.play();
		},		
		
		// 링코드를 가져와서 audio태그의 src에 넣고 초기화한다.
		playerInit : function(xringurl){

			// 창의 최대 가로사이즈를 구한다.
			preListenPlayer.fullSizeX = preListenPlayer.ui.getFullsizeWidth();
			preListenPlayer.playbarEmptySize = preListenPlayer.ui.getplaybarEmptyWidth();

			// 터치 액션을 담당할 변수 초기화
			preListenPlayer.canvas = document.getElementById("touchCanvas");
			preListenPlayer.context = preListenPlayer.canvas.getContext("2d");
			
			preListenPlayer.canvas.addEventListener("touchstart",preListenPlayer.ui.touchStart);
			preListenPlayer.canvas.addEventListener("touchmove",preListenPlayer.ui.touchMove);
			preListenPlayer.canvas.addEventListener("touchend",preListenPlayer.ui.touchEnd);


			// 오디오 태그 객체 선언
			preListenPlayer.audioPlayer = new Audio();
			preListenPlayer.audioPlayer.src = xringurl;

			// 재생을 하는 도중에 지속적으로 발생하는 이벤트 리스너
			preListenPlayer.audioPlayer.addEventListener("timeupdate", 
				function(){
					// 지속적으로 총 재생시간은 상기시켜준다.(왜? 로딩에 따라 바뀔수도있다는 생각이 들었음)
					preListenPlayer.playTimeAll = preListenPlayer.audioPlayer.duration;
				
					// 지속적으로 창의 가로 사이즈를 찾아낸다.(왜? 재생중 가로모드로 변경할경우 대비)
					preListenPlayer.fullSizeX = preListenPlayer.ui.getFullsizeWidth();
					if(!preListenPlayer.barClickAction){
						preListenPlayer.ui.stateBarTouch(preListenPlayer.ui.getBarX(preListenPlayer.audioPlayer.currentTime,preListenPlayer.playTimeAll));
					}
				}
				, false
			);

			// 재생이 완료되었을 경우 호출되는 리스너
			preListenPlayer.audioPlayer.addEventListener("ended", 
				function () {
					preListenPlayer.ui.stop();
				}
				, false
			);


			// 재생중 에러가 발생할 경우 호출되는 리스너
			preListenPlayer.audioPlayer.addEventListener("error", 
				function () {
					preListenPlayer.ui.playErr();
				}
				, false
			);
		},
		getFullsizeWidth : function(){
			return document.getElementById("stateArea").clientWidth;
		},
		getplaybarEmptyWidth : function(){
			return document.getElementById("playbarEmptyArea1").clientWidth;
		},				
		stateBarTouch : function(val){
			document.getElementById("stateLeftArea").style.width = (val - 10) + "px";
		},		
		// 터치 시작 액션
		touchStart : function(e){
			preListenPlayer.barClickAction = true;
			e.preventDefault();
			var touch = e.touches[0];
			preListenPlayer.pointerX = touch.pageX;
			if(touch.pageX >= (preListenPlayer.playbarEmptySize + preListenPlayer.fullSizeX)){
				preListenPlayer.pointerX = preListenPlayer.playbarEmptySize + preListenPlayer.fullSizeX + 10;
			}
			preListenPlayer.ui.stateBarTouch(preListenPlayer.pointerX - (preListenPlayer.playbarEmptySize * 2));
		},
		// 터치 드래그 액션
		touchMove : function(e){
			preListenPlayer.barClickAction = true;
			e.preventDefault();
			var touch = e.touches[0];
			preListenPlayer.pointerX = touch.pageX;
			if(touch.pageX >= (preListenPlayer.playbarEmptySize + preListenPlayer.fullSizeX)){
				preListenPlayer.pointerX = preListenPlayer.playbarEmptySize + preListenPlayer.fullSizeX + 10;
			}
			preListenPlayer.ui.stateBarTouch(preListenPlayer.pointerX - (preListenPlayer.playbarEmptySize * 2));
		},	

		// 터치 끝 액션
		touchEnd : function(e){
			preListenPlayer.barClickAction = false;
			preListenPlayer.ui.selectLocationPlay(preListenPlayer.ui.getPlayTime(preListenPlayer.pointerX - (preListenPlayer.playbarEmptySize * 2) - 10, preListenPlayer.playTimeAll));
		},
		
		// 오디오 재생
		play : function(){
			preListenPlayer.nowPlaying = true;
			preListenPlayer.audioPlayer.play();
		},

		// 오디오 일시정지
		pause : function(){
			preListenPlayer.nowPlaying = false;
			preListenPlayer.audioPlayer.pause();
		},		

		// 오디오 정지
		stop : function(){
			preListenPlayer.nowPlaying = false;
			preListenPlayer.audioPlayer.currentTime = 0;
			document.getElementById("stateLeftArea").style.width = "0px";
			preListenPlayer.ui.pause();
		},	
		
		// 오디오 로딩중 또는 다른 경우에 에러가 났을경우(파일이 없거나...) 근데 브라우저에선 동작하지만, 폰에선 안된다.
		playErr : function(){
			alert('해당 음원은 재생할수 없습니다.');
			preListenPlayer.ui.playerClose();
		},	
		// 오디오의 원하는 위치를 재생시킴(초)
		selectLocationPlay : function(whereSecond){
			preListenPlayer.audioPlayer.currentTime = whereSecond;
			preListenPlayer.audioPlayer.play();
		},

		// 계산식1 - 재생바의 값을 구할때 쓴다, 현재 재생시간에 따라서 바가 얼마나 움직여야할지 알아낸다.
		getBarX : function(currentPlayTime, totalPlayTime){
			var positionX = Math.floor((currentPlayTime * preListenPlayer.fullSizeX) / totalPlayTime);

			// 최소값 0으로 설정
			if(positionX <= 0){
				positionX = 0;
			}else{
				positionX = positionX + preListenPlayer.playbarEmptySize;
			}

			// 최대값 설정(최대값을 0으로 해놓는 이유는 IOS7 에서는 초반 로딩시 끝을 찍고 다시 시작되기 때문이다.)
			if((preListenPlayer.fullSizeX - 10) < positionX){
				positionX = 0;
			}

			return positionX;
		},		

		// 계산식2 - 현재 바의 위치가 가리키는 재생시간을 찾는다.
		getPlayTime : function(positionX, totalPlayTime){
			var nowPlayTime = Math.floor((totalPlayTime * positionX) / preListenPlayer.fullSizeX);
			return nowPlayTime;
		},
		playerSetting : function(v_type){

			var gugan		= $("#present_play_gugan").val();
			var code		= $("#present_play_song_code").val();
			var orgcode		= $("#orginal_play_song_code").val();
			var title		= $("#preListenTitle").text();
			var singer		= $("#preListenArtist").text();
			var tmp_free	= $("#preListenCharge").text();
			var free		= "N";
			var user		= "prelisten";
			var type		= v_type;
			if(v_type == "5"){
				user = "prelisten_present";
			}
			if(tmp_free == "요금 : 무료"){
				free = "Y";
			}
			if($("#pre_isFreeR2uPlus").val()=="true"){
				free = "R";
			}

			openDivPopup(orgcode, title, singer, gugan, free, user, type); 
			preListenPlayer.ui.playerClose();
		}			
		
	}
	
};
