var	login = {

	init: function() {		
		this.beforeBind();
		this.bind();
		this.afterBind();
	},

	beforeBind: function() {
		
	},

	bind: function() {		
		login.fn.auth();	
	},

	afterBind: function() {
		
	},

	fn: {		
		/**가져오는 Function**/
		auth : function() {
			var	param = {};
			var	opts = {
				url		: "/ringbell/login/auth",
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
		
	}
};
