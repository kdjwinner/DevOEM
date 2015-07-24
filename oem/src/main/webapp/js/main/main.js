var	main = {

	bestList : [],
	newList  : [],	
	weekList  : [],	
	tempbestList : null,
	tempnewList  : null,	
	tempweekList  : null,	
	bestRecommand : null,
	newRecommand : null,
	weekRecommand : null,
		
	init: function() {		
		this.beforeBind();
		this.bind();
		this.afterBind();
	},

	beforeBind: function() {
		main.ui.boxslider();
	},

	bind: function() {		
		//main.fn.getMainList();	
		main.fn.getRecommandSongList();	
	},

	afterBind: function() {
	},

	fn: {		
		/**main list**/
		getMainList : function() {
			var	param = {
				"test" : "test"
			};
			var	opts = {
				url		: "/data/main/getMainList",
				data	: param,
				type	: "post",
				sendDataType	: "json",
				success	: function(resJSON, resCode) {
					if (resCode == "success") {
						console.log(resJSON.data);
						main.tempbestList 	= resJSON.data.bestList;
						main.tempnewList  	= resJSON.data.newList;	
						main.tempweekList  	= resJSON.data.weekList;	
						for(var i=0; i<main.tempbestList.length; i++){
							main.bestList.push(main.tempbestList[i]);
							main.newList.push(main.tempnewList[i]);
							main.weekList.push(main.tempweekList[i]);									
						}
						console.log(main.bestList);
						main.fn.drawBestList();
						main.fn.drawNewList();												
						main.fn.drawWeekList();												
					}else{	
						alert("������ �߻��Ͽ����ϴ�.");
					}					
				}
				
			};
			common.http.ajax(opts);
		},
		/**��õ ������**/
		getRecommandSongList : function() {
			var	param = {
					"test" : "test"
			};
			var	opts = {
					url		: "/data/main/getRecommandSongList",
					data	: param,
					type	: "post",
					sendDataType	: "json",
					success	: function(resJSON, resCode) {
						if (resCode == "success") {
							main.bestRecommand 	= resJSON.data.best_song;
							main.newRecommand  	= resJSON.data.new_song;	
							main.weekRecommand 	= resJSON.data.week_song;		
							main.bestList.push(main.bestRecommand);
							main.newList.push(main.newRecommand);
							main.weekList.push(main.weekRecommand);
							main.fn.getMainList();
							console.log(resJSON.data);											
						}else{	
							alert("������ �߻��Ͽ����ϴ�.");
						}					
					}
			
			};
			common.http.ajax(opts);
		},
		drawBestList : function(v_pagenum){
			$("#best_tbody").empty();			
			var html		=	"";
			if(main.bestList.length > 0){			
				for(var i=0; i<101; i++){
					html	=   "";
					if(i<11){
						html	+=	"<tr class=\"bestMore\">";						
					}else{
						html	+=	"<tr class=\"bestMoreNone\">";						
					}
					if(i==0){
						html	+=	"<td class=\"nums\"><img src=\"images/main/recommand.png\" alt=\"��õ\"></td>";									
					}else{
						html	+=	"<td class=\"nums\">"+i+"</td>";						
					}
					html	+=	"<td class=\"tits\">";
					html	+=	"<span style=\"position:absolute;\">";
					html	+=	"<img src=\""+main.bestList[i].album+"\" width=\"38\" height=\"38\">";
					html	+=	"</span>";
					html	+=	"<span class=\"tit\" style=\"margin-left:42px\">";
					html	+=	"<img src=\"images/main/hd_ring_icon.gif\" width=\"24\" height=\"17\">";
					if("X" == main.bestList[i].r19_LICENCE_TF){
						html += "<img src=\"images/main/music_19.gif\" width=\"17\" height=\"17\">";
					}				
					
					html	+=	main.bestList[i].title;
					html	+=	"</span>";
					html	+=	"<span class=\"artist\" style=\"margin-left:42px\">"+main.bestList[i].singer+"</span>";
					html	+=	"</td>";
					html	+=	"<td>";
					html	+=	"<a href=\"javascript:preListenPlayer.ui.playerOpen('"+main.bestList[i].xRingCode+"','"+main.bestList[i].title+"','"+main.bestList[i].singer+"');\">";
					html	+=	"<img src=\"images/main/ring_prelisten_button.gif\" width=\"31\" height=\"31\" alt=\"�̸����\">";
					html	+=	"</a>";
					html	+=	"</td>";
					html	+=	"<td>";
					html	+=	"<a href=\"javascript:main.ui.openSetup('best_song','"+i+"','"+main.bestList[i].title+"','"+main.bestList[i].singer+"');\">";
					html	+=	"<img src=\"images/main/btn_buy.gif\" width=\"31\" height=\"31\" alt=\"����\">";
					html	+=	"</a>";
					html	+=	"</td>";
					html	+=	"</tr>";
					html	+=  "<tr class=\"guganChkTr\" id=\"best_song"+i+"\" name=\"guganChkTr\"></tr>";						
			
					$("#best_tbody").append(html);				
				}			
			}								
			
		},	
		
		
		drawNewList : function(v_pagenum){
			$("#new_tbody").empty();			
			var html	=	"";			
			
			if(main.newList.length > 0){			
				for(var i=0; i<101; i++){		
					html	=   "";
					if(i<11){
						html	+=	"<tr class=\"newMore\">";						
					}else{
						html	+=	"<tr class=\"newMoreNone\">";						
					}					
					if(i==0){
						html	+=	"<td class=\"nums\"><img src=\"images/main/recommand.png\" alt=\"��õ\"></td>";									
					}else{
						html	+=	"<td class=\"nums\">"+i+"</td>";						
					}
					html	+=	"<td class=\"tits\">";
					html	+=	"<span style=\"position:absolute;\">";
					html	+=	"<img src=\""+main.newList[i].album+"\" width=\"38\" height=\"38\">";
					html	+=	"</span>";
					html	+=	"<span class=\"tit\" style=\"margin-left:42px\">";
					html	+=	"<img src=\"images/main/hd_ring_icon.gif\" width=\"24\" height=\"17\">";
					if("X" == main.newList[i].r19_LICENCE_TF){
						html += "<img src=\"images/main/music_19.gif\" width=\"17\" height=\"17\">";
					}				
					
					html	+=	main.newList[i].title;
					html	+=	"</span>";
					html	+=	"<span class=\"artist\" style=\"margin-left:42px\">"+main.newList[i].singer+"</span>";
					html	+=	"</td>";
					html	+=	"<td>";
					html	+=	"<a href=\"javascript:preListenPlayer.ui.playerOpen('"+main.newList[i].xRingCode+"','"+main.newList[i].title+"','"+main.newList[i].singer+"');\">";
					html	+=	"<img src=\"images/main/ring_prelisten_button.gif\" width=\"31\" height=\"31\" alt=\"�̸����\">";
					html	+=	"</a>";
					html	+=	"</td>";
					html	+=	"<td>";
					html	+=	"<a href=\"javascript:main.ui.openSetup('new_tr','"+i+"','"+main.newList[i].title+"','"+main.newList[i].singer+"');\">";
					html	+=	"<img src=\"images/main/btn_buy.gif\" width=\"31\" height=\"31\" alt=\"����\">";
					html	+=	"</a>";
					html	+=	"</td>";
					html	+=	"</tr>";
					html	+=  "<tr class=\"guganChkTr\" id=\"new_tr"+i+"\" name=\"guganChkTr\"></tr>";
					$("#new_tbody").append(html);						
				}			
			}								
			
		},			
		drawWeekList : function(v_pagenum){
			$("#week_tbody").empty();			
			var html	=	"";			
			
			if(main.weekList.length > 0){			
				for(var i=0; i<101; i++){		
					html	=   "";
					if(i<11){
						html	+=	"<tr class=\"weekMore\">";						
					}else{
						html	+=	"<tr class=\"weekMoreNone\">";						
					}						

					if(i==0){
						html	+=	"<td class=\"nums\"><img src=\"images/main/recommand.png\" alt=\"��õ\"></td>";									
					}else{
						html	+=	"<td class=\"nums\">"+i+"</td>";						
					}
					html	+=	"<td class=\"tits\">";
					html	+=	"<span style=\"position:absolute;\">";
					html	+=	"<img src=\""+main.weekList[i].album+"\" width=\"38\" height=\"38\">";
					html	+=	"</span>";
					html	+=	"<span class=\"tit\" style=\"margin-left:42px\">";
					html	+=	"<img src=\"images/main/hd_ring_icon.gif\" width=\"24\" height=\"17\">";
					if("X" == main.weekList[i].r19_LICENCE_TF){
						html += "<img src=\"images/main/music_19.gif\" width=\"17\" height=\"17\">";
					}				
					
					html	+=	main.weekList[i].title;
					html	+=	"</span>";
					html	+=	"<span class=\"artist\" style=\"margin-left:42px\">"+main.weekList[i].singer+"</span>";
					html	+=	"</td>";
					html	+=	"<td>";
					html	+=	"<a href=\"javascript:preListenPlayer.ui.playerOpen('"+main.weekList[i].xRingCode+"','"+main.weekList[i].title+"','"+main.weekList[i].singer+"');\">";
					html	+=	"<img src=\"images/main/ring_prelisten_button.gif\" width=\"31\" height=\"31\" alt=\"�̸����\">";
					html	+=	"</a>";
					html	+=	"</td>";
					html	+=	"<td>";
					html	+=	"<a href=\"javascript:main.ui.openSetup('week_tr','"+i+"','"+main.weekList[i].title+"','"+main.weekList[i].singer+"');\">";
					html	+=	"<img src=\"images/main/btn_buy.gif\" width=\"31\" height=\"31\" alt=\"����\">";
					html	+=	"</a>";
					html	+=	"</td>";
					html	+=	"</tr>";
					html	+=  "<tr class=\"guganChkTr\" id=\"week_tr"+i+"\" name=\"guganChkTr\"></tr>";
					$("#week_tbody").append(html);						
				}			
			}								
			
		}
	},
	ui: {
		boxslider : function() {
			$('.bxslider').bxSlider({
				auto: true, 
				autoControls: true,
				controls: false
			});		
		},
		
		tabControl : function(a) {
			var tab = a;
			if(a == "1"){
				$("#tab2").removeClass("active");
				$("#tab3").removeClass("active");
				$("#tab4").removeClass("active");
				$("#tab1").addClass("active");
				$("#newRingArea").hide();
				$("#freeRingArea").hide();
				$("#weekRingArea").hide();
				$("#bestRingArea").show();
			}else if(a == "2"){
				$("#tab1").removeClass("active");
				$("#tab3").removeClass("active");
				$("#tab4").removeClass("active");
				$("#tab2").addClass("active");
				$("#bestRingArea").hide();
				$("#freeRingArea").hide();
				$("#weekRingArea").hide();				
				$("#newRingArea").show();
			}
			else if(a == "3"){
				$("#tab1").removeClass("active");
				$("#tab2").removeClass("active");
				$("#tab4").removeClass("active");
				$("#tab3").addClass("active");
				$("#bestRingArea").hide();
				$("#newRingArea").hide();
				$("#freeRingArea").hide();
				$("#weekRingArea").show();				
			}else if(a == "4"){
				$("#tab1").removeClass("active");
				$("#tab2").removeClass("active");
				$("#tab3").removeClass("active");
				$("#tab4").addClass("active");
				$("#bestRingArea").hide();
				$("#newRingArea").hide();
				$("#weekRingArea").hide();						
				$("#freeRingArea").show();
			}			
			
		},
		
		openSetup : function(category, index, ring_code, title, singer){
			var open_tr		= category+index;
			var gugan_name	= "gugan" + open_tr;
			var gugan_id	= "gugan" + open_tr + "id"; 
			var music_name	= "music" + open_tr; 
			var music_id	= "music" + open_tr + "id"; 
			console.log(open_tr);
			console.log(gugan_name);
			console.log(gugan_id);
			console.log(music_name);
			console.log(music_id);
			var html	=	"";
				html	+=	"<td colspan=\"4\" style=\"padding: 0px;\">" ;
				html	+=	"<table style=\"font-size: 12px;\">" ;
				html	+=	"<tbody>" ;
				html	+=	"<tr>" ;
				html	+=	"<td style=\"border-bottom:0px;border-right: 1px solid #D0D0D1;background-color: #FAFAFA;width:80px;\">" ;
				html	+=	"<ul class=\"checkSettingUl\">" ;
				html	+=	"<li>" ;
				html	+=	"<img src=\"images/main/radio_on.gif\" name=\""+gugan_name+"\" id=\""+gugan_id+"_1\" onclick=radioChk(this.id) class=\"chkRadio\">" ;
				html	+=	"<span class=\"textSpanClass\">�ķ�</span>" ;
				html	+=	"</li>" ;
				html	+=	"<li>" ;
				html	+=	"<img src=\"images/main/radio_off.gif\" name=\""+gugan_name+"\" id=\""+gugan_id+"_2\" onclick=radioChk(this.id) class=\"chkRadio\">" ;
				html	+=	"<span class=\"textSpanClass\">�պκ�</span>" ;                              
				html	+=	"</li>" ;                              
				html	+=	"<li>" ;
				html	+=	"<img src=\"images/main/radio_off.gif\" name=\""+gugan_name+"\" id=\""+gugan_id+"_3\" onclick=radioChk(this.id) class=\"chkRadio\">" ;
				html	+=	"<span class=\"textSpanClass\">�޺κ�</span>" ;
				html	+=	"</li>" ;
				html	+=	"</ul>" ;
				html	+=	"</td>" ;
				html	+=	"<td style=\"border-bottom:0px;;border-right: 0px solid #D0D0D1;background-color: #FAFAFA;\">" ;
				html	+=	"<ul class=\"checkSettingUl\">" ;
				html	+=	"<li>" ;
				html	+=	"<img src=\"images/main/radio_on.gif\" name=\""+music_name+"\" id=\""+music_id+"_default\" onclick=radioChk(this.id) class=\"chkRadio\">" ;
				html	+=	"<span class=\"textSpanClass\">�⺻��</span>" ;
				html	+=	"</li>" ;
				html	+=	"<li>" ;
				html	+=	"<img src=\"images/main/radio_off.gif\" name=\""+music_name+"\" id=\""+music_id+"_day\" onclick=radioChk(this.id) class=\"chkRadio\">" ;
				html	+=	"<span class=\"textSpanClass\">����/�ð���</span>" ;
				html	+=	"</li>" ;
				html	+=	"</ul>" ;
				html	+=	"</td>" ;
				html	+=	"<td style=\"border-bottom:0px;;border-right: 1px solid #D0D0D1;background-color: #FAFAFA;width:92px;\">" ;
				html	+=	"<ul class=\"checkSettingUl\">" ;
				html	+=	"<li>" ;
				html	+=	"<img src=\"images/main/radio_off.gif\" name=\""+music_name+"\" id=\""+music_id+"_caller\" onclick=radioChk(this.id) class=\"chkRadio\">" ;
				html	+=	"<span class=\"textSpanClass\">�߽��ں�</span>" ;
				html	+=	"</li>" ;
				html	+=	"<li>" ;
				html	+=	"<img src=\"images/main/radio_off.gif\" name=\""+music_name+"\" id=\""+music_id+"_anniversary\" onclick=radioChk(this.id) class=\"chkRadio\">" ;
				html	+=	"<span class=\"textSpanClass\">����Ϻ�</span>" ;
				html	+=	"</li>" ;
				html	+=	"</ul>" ;
				html	+=	"</td>" ;
				html	+=	"<td style=\"border-bottom:0px;padding:0px;width:80px;\">" ;
				html	+=	"<table style=\"font-size:12px;\">" ;
				html	+=	"<tr>" ;
				if(category == "free_song"){
					html	+=	"<td style=\"background-color:#474747;color: #FFFFFF;padding-top:7px;padding-bottom:7px;padding-right:2px;\" onClick=\"javascript:openDivPopup('"+ring_code+"','"+title+"','"+singer+"','"+open_tr+"', 'Y', 'setting');\">" ;
				}else{
					html	+=	"<td style=\"background-color:#474747;color: #FFFFFF;padding-top:7px;padding-bottom:7px;padding-right:2px;\" onClick=\"javascript:openDivPopup('"+ring_code+"','"+title+"','"+singer+"','"+open_tr+"', 'N', 'setting');\">" ;
				}


				html	+=	"<img src=\"images/main/settingBtn.gif\" style=\"width:12px;vertical-align: middle;margin-right:5px;\">�����ϱ�" ;
				html	+=	"<input type=\"hidden\" id=\""+gugan_name+"_radio\" value=\"\" /> " ;
				html	+=	"<input type=\"hidden\" id=\""+music_name+"_radio\" value=\"\" />" ;
				html	+=	"</td>" ;
				html	+=	"</tr>" ;
				html	+=	"<tr>" ;
				if(category == "free_song"){
					html	+=	"<td style=\"background-color:#474747;color: #FFFFFF;padding-top:7px;padding-bottom:7px;padding-right:2px;\" onClick=\"javascript:openDivPopup('"+ring_code+"','"+title+"','"+singer+"','"+open_tr+"', 'Y', 'present');\">" ;
				}else{
					html	+=	"<td style=\"background-color:#474747;color: #FFFFFF;padding-top:7px;padding-bottom:7px;padding-right:2px;\" onClick=\"javascript:openDivPopup('"+ring_code+"','"+title+"','"+singer+"','"+open_tr+"', 'N', 'present');\">" ;
				}
				html	+=	"<img src=\"images/main/giftBtn.gif\" style=\"width:12px;vertical-align: middle;margin-right:5px;\">�����ϱ�" ;
				html	+=	"</td>" ;
				html	+=	"</tr>" ;
				html	+=	"</table>" ;
				html	+=	"</td>" ;
				html	+=	"</tr>" ;
				html	+=	"</tbody>" ;
				html	+=	"</table>" ;
				html	+=	"</td>" ;
				
				var a = $("#"+open_tr+"").children();
				if(a.length != 0){
					//�ڽ��� ���� ��
					$("#"+open_tr+"").empty();
				}else{
					//�ڽ��� ���� ��
					//��� ���� �� ���
					$("tr[name='guganChkTr']").empty();
					
					//���� ä��
					$("#"+open_tr+"").append(html);
					$("#"+open_tr+"").show();

					//defaul�� ���õ� ���� �־� �ش�
					$("#"+gugan_name+"_radio").val(gugan_id+"_1");
					$("#"+music_name+"_radio").val(music_id+"_default");
					
				}			
		},
		
		radioChk : function(index){
			var radio_name = $("#"+index)[0].name;
			//img�� ��� off�� ����
			var radio = $("img[name="+radio_name+"]");
			for( var i=0; i<radio.length; i++) {
				radio[i].src = "images/main/radio_off.gif";
			}
			//���õ� radio img�� on���� ����. 
			$("#"+index).attr("src", "images/main/radio_on.gif");
			
			//hidden�� ���� �־� �ش�.
			$("#"+radio_name+"_radio").val(index);
		},
		
		viewMore : function(cate){
			var cate_name   = cate + "MoreNone";
			var change_cate_name = cate + "More";
			var change_list = $("."+cate_name+"");
			if(change_list.length>0){
				for(var i=0; i<30; i++){
					change_list[i].className = cate + "More";
				}							
			}			
		},		
		
		viewTop : function(v_index){
			window.scrollTo(0,0);
		}		
		
	}
	
};
