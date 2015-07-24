var	myringbell = {

	init: function() {		
		this.beforeBind();
		this.bind();
		this.afterBind();
	},

	beforeBind: function() {
		
	},

	bind: function() {		
		myringbell.fn.loginCheck();	
	},

	afterBind: function() {
		/******tab 클릭 등의 EVENT 성 function***********/
	},

	fn: {		
		/**가져오는 Function**/
		loginCheck : function() {
			var	param = {};
			var	opts = {
				url		: "/oem/loginCheck",
				data	: param,
				type	: "post",
				sendDataType	: "json",
				success	: function(resJSON, resCode) {
					if (resCode == "success") {
						console.log(resJSON);
						console.log(resCode);						
					}else{	
						alert("오류가 발생하였습니다.");
					}
					
				}
				
			};
			common.http.ajax(opts);
		}	
		
	},
	event: {
		
		loginCheck : function() {
			
		}			
		
	}
	
};
