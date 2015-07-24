var	sms = {
	smsBtnChk : true,
	
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

		send : function(){
			var phoneNum = document.getElementById("num").value + document.getElementById("myphone").value;
			if(document.getElementById("myphone").value=="" || phoneNum.length < 9 || phoneNum.length > 11 || isNaN(phoneNum))
			{
				alert("전화번호가 올바르지 않습니다.");
				return false;
			}else{
				if(sms.smsBtnChk == true){
					sms.smsBtnChk = false;
					sms.fn.ajaxSend(phoneNum);
				}else{
					alert('전송이 진행중 입니다.');
					return false;
				}
			}
		}, 

		ajaxSend : function(phoneNum){
			var param = {
					"mdn":	phoneNum,
					"page_name" : "sendSMS"
			};
			
			var	opts = {
					url		: "/event/smsProcess",
					type	: "post",
					data	: param,					
					sendDataType	: "json",
					success	: function(resJSON, resCode) {
						if (resCode == "success") {
							console.log(resJSON.data);
							if(resJSON.data.smsresult == "success"){
								alert('인증 번호를 발송하였습니다');
								sms.smsBtnChk = true;
							}else{
								alert('전송이 실패 하였습니다.\n잠시 뒤에 다시 시도해 주세요');
								sms.smsBtnChk = true;								
							}
						}else{	
							alert('인증번호 발송이 실패 하였습니다\n잠시 뒤에 다시 시도해 주세요');
							sms.smsBtnChk = true;							
						}	
					}
			};						

			common.http.ajax(opts);						
		},
		confirm : function(){ 
			var certify =document.getElementById("certify").value;
			if(document.getElementById("certify").value=="" || certify.length != 6 || isNaN(certify))
			{
				alert("인증번호가 올바르지 않습니다.");
				return false; 
			}
			if(!document.getElementById("chk1").checked || !document.getElementById("chk2").checked)
			{
				alert("동의 항목이 체크되지 않았습니다.");
				return false;
			}
			var phoneNum = document.getElementById("num").value + document.getElementById("myphone").value;
			if(document.getElementById("myphone").value=="" || phoneNum.length < 9 || phoneNum.length > 11 || isNaN(phoneNum))
			{
				alert("전화번호가 올바르지 않습니다.");
				return false;
			}

			document.getElementById("certinum").value = certify;
			document.getElementById("ctn").value = phoneNum;
			document.getElementById("sform").submit();

		}		
		
		
		
	},
	ui: {
		openDivPopup : function openDivPopup(el) {
			$(".bg").show();
			$('#' + el).show();
			$('.layer').show();

			$('.bg').click(function(e){
				$('.layer').hide();
				$('#' + el).hide();
				$(".bg").hide();
				e.preventDefault();
			});
			$('.cbtn').click(function(e){
				$('.layer').hide();
				$('#' + el).hide();
				$(".bg").hide();
				e.preventDefault();
			});
		}		
		
	}
	
};
