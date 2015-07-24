var	sendSms = {

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
		sendSms.event.click();
	},

	fn: {			
		send : function(){
			var phoneNum = document.getElementById("num").value + document.getElementById("myphone").value;
			if(document.getElementById("myphone").value=="" || phoneNum.length < 9 || phoneNum.length > 11 || isNaN(phoneNum))
			{
				alert("전화번호가 올바르지 않습니다.");
				return false;
			}
			
			var	param = {
					"ctn" : phoneNum
			};
			var	opts = {
				url		: "/oem/login/smsProcess",
				data	: param,
				type	: "post",
				sendDataType	: "json",
				success	: function(resJSON, resCode) {					
					if (resCode == "success") {
						if(resJSON.data == "0"){
							alert('인증번호를 발송 하였습니다');
						}else{
							alert('인증번호 발송에 실패 하였습니다');
						}	
					}else{	
						alert("오류가 발생하였습니다.");
					}
					
				}				
			};
			common.http.ajax(opts);						
		},

		confirm : function(){
			var certify =document.getElementById("certify").value;
			var phoneNum = document.getElementById("num").value + document.getElementById("myphone").value;
			
			if(document.getElementById("myphone").value=="" || phoneNum.length < 9 || phoneNum.length > 11 || isNaN(phoneNum))
			{
				alert("전화번호가 올바르지 않습니다.");
				return false;
			}			
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

			var	param = {
					"certinum" : certify,
					"ctn" : phoneNum					
			};
			var	opts = {
				url		: "/oem/login/smsCheck",
				data	: param,
				type	: "post",
				sendDataType	: "json",
				success	: function(resJSON, resCode) {
					if (resCode == "success") {
						if(resJSON.data == "1"){
							alert('인증에 성공 하였습니다');							
						}else{
							alert('인증에 실패 하였습니다');
						}	
					}else{	
						alert("오류가 발생하였습니다.");
					}
					
				}				
			};
			common.http.ajax(opts);							
			
		},

		openDivPopup : function(el) {
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
		
	},
	
	event: {	
		click : function() {
			$('#smsSendBtn').click(function() {
				sendSms.fn.send();
			});
			$('#smsConfirm').click(function() {
				sendSms.fn.confirm();
			});			
		}	
	}
	
};
