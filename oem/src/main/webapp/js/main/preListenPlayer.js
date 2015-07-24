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
						alert("������ �߻��Ͽ����ϴ�.");
					}					
				}
				
			};
			common.http.ajax(opts);
		}
	},
	ui: {
		playerOpen : function(code, title, singer, playType){
			/*playType�� ���� ���� ��ư �����ְ� �Ⱥ����ְ� ����*/
			if(playType =="myRing"){
				$("#pre_liste_set_div").hide();
			}else{
				$("#pre_liste_set_div").show();
			}

			var charge = "";
			var code2 = Number(code)+1 +"";
			var code3 = Number(code)+2 +"";

			/*���� ��Ȳ �߰� ���ڵ� �� �� �Ǿ��� �� 20150414 �̸��� Start*/
			if(code == "31440407111463"){
				code2 = "31440407111472";
				code3 = "31440407111479";
			}
			if(code == "31440407111464"){
				code2 = "31440407111473";
				code3 = "31440407111480";
			}
			/*���� ��Ȳ �߰� ���ڵ� �� �� �Ǿ��� �� 20150414 �̸��� End*/
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
				charge = "����";
				$("#pre_liste_present_div").hide();
			}
			else
			{
				charge = "1300��(VAT����)"
				$("#pre_liste_present_div").show();
			}
			if($("#pre_isFreeR2uPlus").val()=="true"){
				charge = "����(�������÷�������)";
			}

			$("#preListenTitle").empty();
			$("#preListenArtist").empty();
			$("#preListenCharge").empty();			
			$("#preListenTitle").append("��� : " + title);
			$("#preListenArtist").append("���� : " + singer);
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
		
		// ���ڵ带 �����ͼ� audio�±��� src�� �ְ� �ʱ�ȭ�Ѵ�.
		playerInit : function(xringurl){

			// â�� �ִ� ���λ���� ���Ѵ�.
			preListenPlayer.fullSizeX = preListenPlayer.ui.getFullsizeWidth();
			preListenPlayer.playbarEmptySize = preListenPlayer.ui.getplaybarEmptyWidth();

			// ��ġ �׼��� ����� ���� �ʱ�ȭ
			preListenPlayer.canvas = document.getElementById("touchCanvas");
			preListenPlayer.context = preListenPlayer.canvas.getContext("2d");
			
			preListenPlayer.canvas.addEventListener("touchstart",preListenPlayer.ui.touchStart);
			preListenPlayer.canvas.addEventListener("touchmove",preListenPlayer.ui.touchMove);
			preListenPlayer.canvas.addEventListener("touchend",preListenPlayer.ui.touchEnd);


			// ����� �±� ��ü ����
			preListenPlayer.audioPlayer = new Audio();
			preListenPlayer.audioPlayer.src = xringurl;

			// ����� �ϴ� ���߿� ���������� �߻��ϴ� �̺�Ʈ ������
			preListenPlayer.audioPlayer.addEventListener("timeupdate", 
				function(){
					// ���������� �� ����ð��� �������ش�.(��? �ε��� ���� �ٲ�����ִٴ� ������ �����)
					preListenPlayer.playTimeAll = preListenPlayer.audioPlayer.duration;
				
					// ���������� â�� ���� ����� ã�Ƴ���.(��? ����� ���θ��� �����Ұ�� ���)
					preListenPlayer.fullSizeX = preListenPlayer.ui.getFullsizeWidth();
					if(!preListenPlayer.barClickAction){
						preListenPlayer.ui.stateBarTouch(preListenPlayer.ui.getBarX(preListenPlayer.audioPlayer.currentTime,preListenPlayer.playTimeAll));
					}
				}
				, false
			);

			// ����� �Ϸ�Ǿ��� ��� ȣ��Ǵ� ������
			preListenPlayer.audioPlayer.addEventListener("ended", 
				function () {
					preListenPlayer.ui.stop();
				}
				, false
			);


			// ����� ������ �߻��� ��� ȣ��Ǵ� ������
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
		// ��ġ ���� �׼�
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
		// ��ġ �巡�� �׼�
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

		// ��ġ �� �׼�
		touchEnd : function(e){
			preListenPlayer.barClickAction = false;
			preListenPlayer.ui.selectLocationPlay(preListenPlayer.ui.getPlayTime(preListenPlayer.pointerX - (preListenPlayer.playbarEmptySize * 2) - 10, preListenPlayer.playTimeAll));
		},
		
		// ����� ���
		play : function(){
			preListenPlayer.nowPlaying = true;
			preListenPlayer.audioPlayer.play();
		},

		// ����� �Ͻ�����
		pause : function(){
			preListenPlayer.nowPlaying = false;
			preListenPlayer.audioPlayer.pause();
		},		

		// ����� ����
		stop : function(){
			preListenPlayer.nowPlaying = false;
			preListenPlayer.audioPlayer.currentTime = 0;
			document.getElementById("stateLeftArea").style.width = "0px";
			preListenPlayer.ui.pause();
		},	
		
		// ����� �ε��� �Ǵ� �ٸ� ��쿡 ������ �������(������ ���ų�...) �ٵ� ���������� ����������, ������ �ȵȴ�.
		playErr : function(){
			alert('�ش� ������ ����Ҽ� �����ϴ�.');
			preListenPlayer.ui.playerClose();
		},	
		// ������� ���ϴ� ��ġ�� �����Ŵ(��)
		selectLocationPlay : function(whereSecond){
			preListenPlayer.audioPlayer.currentTime = whereSecond;
			preListenPlayer.audioPlayer.play();
		},

		// ����1 - ������� ���� ���Ҷ� ����, ���� ����ð��� ���� �ٰ� �󸶳� ������������ �˾Ƴ���.
		getBarX : function(currentPlayTime, totalPlayTime){
			var positionX = Math.floor((currentPlayTime * preListenPlayer.fullSizeX) / totalPlayTime);

			// �ּҰ� 0���� ����
			if(positionX <= 0){
				positionX = 0;
			}else{
				positionX = positionX + preListenPlayer.playbarEmptySize;
			}

			// �ִ밪 ����(�ִ밪�� 0���� �س��� ������ IOS7 ������ �ʹ� �ε��� ���� ��� �ٽ� ���۵Ǳ� �����̴�.)
			if((preListenPlayer.fullSizeX - 10) < positionX){
				positionX = 0;
			}

			return positionX;
		},		

		// ����2 - ���� ���� ��ġ�� ����Ű�� ����ð��� ã�´�.
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
			if(tmp_free == "��� : ����"){
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
