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
				alert("��ȭ��ȣ�� �ùٸ��� �ʽ��ϴ�.");
				return false;
			}else{
				if(sms.smsBtnChk == true){
					sms.smsBtnChk = false;
					sms.fn.ajaxSend(phoneNum);
				}else{
					alert('������ ������ �Դϴ�.');
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
								alert('���� ��ȣ�� �߼��Ͽ����ϴ�');
								sms.smsBtnChk = true;
							}else{
								alert('������ ���� �Ͽ����ϴ�.\n��� �ڿ� �ٽ� �õ��� �ּ���');
								sms.smsBtnChk = true;								
							}
						}else{	
							alert('������ȣ �߼��� ���� �Ͽ����ϴ�\n��� �ڿ� �ٽ� �õ��� �ּ���');
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
				alert("������ȣ�� �ùٸ��� �ʽ��ϴ�.");
				return false; 
			}
			if(!document.getElementById("chk1").checked || !document.getElementById("chk2").checked)
			{
				alert("���� �׸��� üũ���� �ʾҽ��ϴ�.");
				return false;
			}
			var phoneNum = document.getElementById("num").value + document.getElementById("myphone").value;
			if(document.getElementById("myphone").value=="" || phoneNum.length < 9 || phoneNum.length > 11 || isNaN(phoneNum))
			{
				alert("��ȭ��ȣ�� �ùٸ��� �ʽ��ϴ�.");
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
