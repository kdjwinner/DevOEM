<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ include file="../include/header.jsp"%>
	<title>[olleh 링투유]</title>
<script type="text/javascript" src="js/sms/sms.js"></script>
<script type="text/javascript">
	$(function() {
		common.invoker.invoke("sms");				
	});	
</script>	
</head>
<body>
	 <div>
		<img src = "images/sms/title_sms.gif" style="width:100%;" class="top" alt="링투유 SMS 인증">
		<img src = "images/sms/notice.png" style="width:100%;" alt="링투유는 KT 고객님만이 사용 가능 합니다">

		<div style="padding:3%;border-top: 1px solid blue;margin-top:1%;">
			<p class="topText" style="font-size: 15px;">Kt 고객님 확인을 위해</p>
			<p class="topText"><B style="color:red;font-size: 15px;">인증번호를 SMS로 보내 드립니다.</B></p>
		</div>

		<div class="phoneArea">

			<div class="phoneIn">
				<select id="num" name="num" class="inputTag" style="width: 60px;margin-right: 1px;font-size: 15px;">
					<option value="010">010</option>
					<option value="011">011</option>
					<option value="016">016</option>
					<option value="018">018</option>
				</select>
				<input type="text" maxlength = "8" placeholder = "휴대폰 번호를 입력해주세요" id="myphone" name="myphone" class="inputTag" style="font-size:12px;width: 156px;text-align:center;">
				<img src = "images/sms/btn_sms_certify.gif" style="height: 34px;vertical-align: middle;width:80px;cursor:pointer;" onclick="javascript:sms.fn.send();" alt="인증번호 발송">
			</div>
			<div class="phoneIn">
				<input type="text" id="certify" placeholder = "SMS 인증번호를 입력하세요." name="certify" class="inputTag" style="width: 300px;vertical-align: bottom;text-align:center;margin-left: 5px;margin-right: 5px;">
			</div>
			<div style="border-bottom: 1px solid blue;padding-bottom: 20px;">
				<p style="font-size: 12px;text-align: center;">인증 번호 발송은 최대 1분 가량 소요될 수 있습니다</p>
			</div>		
		</div>	


		<div class="phoneArea" style="margin-left: 4%;margin-right: 4%;margin-top:5%;margin-bottom:5%;">
			<span style="font-size: 12px;">(주) kt가 제공하는 링투유 서비스를 이용하시기 위해서 이용 약관 및 개인정보 수집/제공 동의가 필요합니다.</span>
		</div>
		<div style="margin:2%;overflow:hidden;clear:both;padding-left: 1%;padding-right: 1%;">
			<div style="float:left;padding-top:10px;">
				<span style="font-size:12px;vertical-align: middle;" >
					<input type="checkbox" id="chk1" />
						서비스 이용약관에 동의 합니다.
					</span>
			</div>
			<div style="float:right;padding-top:10px;">
				<img src = "images/sms/btn_terms.gif" style="width:70px;height:20px;vertical-align: bottom;" alt="약관보기" onClick="javascript:sms.ui.openDivPopup('layer1');">
			</div>
		</div>
		<div style="margin:2%;overflow:hidden;clear:both;padding-left: 1%;padding-right: 1%;">
			<div style="float:left;padding-top:10px;">
				<span style="font-size:12px;vertical-align: middle;" >
					<input type="checkbox" id="chk2" />
					개인정보 수집 및 이용에 동의 합니다.
				</span>
			</div>
			<div style="float:right;padding-top:10px;">
				<img src = "images/sms/btn_terms.gif" style="width:70px;height:20px;vertical-align: bottom;" alt="약관보기" onClick="javascript:sms.ui.openDivPopup('layer2');">
			</div>
		</div>

		<div align="center" style="margin-top: 30px;padding-bottom: 30px;border-bottom: 1px solid blue;">
			<img src = "images/sms/btn_cancel.gif" style="height: 30px;vertical-align: middle;width:80px;margin-right:30px;cursor:pointer;" onclick="javascript:location.href='/';" alt="취소">
			<img src = "images/sms/btn_confirm.gif" style="height: 30px;vertical-align: middle;width:80px;cursor:pointer;" onclick="javascript:sms.fn.confirm();" alt="확인">
		</div>

		<div class="phoneArea" style="margin-left: 5%;margin-right: 5%;text-align:left;margin-top: 4%;">
			<div style="margin:3% 0;">
				<span style="font-size: 11px;">* 본서비스는 SMS 수신이 가능한 휴대폰에 한해 이용이 가능합니다</span>
			</div>
			<div style="margin:3% 0;">
				<span style="font-size: 11px;">* 현재 사용중인 휴대폰이 USIM 단독 상태이거나 휴대폰과 USIM이 분리된 상태에서는 SMS 인증을 받으실 수 없습니다.</span>
			</div>
		</div>
	</div> 
	<!-- popup 영역 start -->
	<div class="bg"></div>	
	<div class="layer">
		<div id="layer1" class="pop-layer" style="border: 2px solid #2d2d2d;">
			<div class="pop-container">
				<!--content //-->
				<div class="pop-conts">
					<img src = "images/terms/detail01.gif" style="width:100%;" class="top" alt="링투유 이용 약관">
					<img src = "images/terms/title01.gif" style="width:100%;" class="top" alt="링투유 이용 약관">
					<div class="popupTextDiv1" style="height:380px;overflow-y:scroll;font-size:11px;padding-left:10px;padding-right:10px;" >
						<div>
							<%@include file="../include/terms1.jsp"%>				
						</div>
					</div>
					<div class="btn-r" style="margin-top:10px;margin-bottom: 10px;text-align:center;">
						<a href="#" class="cbtn"><img src = "images/terms/btn.gif" style="height: 24px;"alt="팝업 닫기"></a>
					</div>
				</div>
				<!--// content-->
			</div>
		</div>
		<div id="layer2" class="pop-layer" style="border: 2px solid #2d2d2d;">
			<div class="pop-container">
				<!--content //-->
				<div class="pop-conts">
					<img src = "images/notice/detail02.gif" style="width:100%;" class="top" alt="개인 정보 취급 방침">
					<img src = "images/notice/title02.gif" style="width:100%;" class="top" alt="개인 정보 취급 방침">
					<div class="popupTextDiv1" style="height:380px;overflow-y:scroll;font-size:11px;padding-left:10px;padding-right:10px;" >
						<%@include file="../include/terms2.jsp"%>				
					</div>
					<div class="btn-r" style="margin-top:20px;margin-bottom: 10px;text-align:center;">
						<a href="#" class="cbtn"><img src = "images/terms/btn.gif" style="height: 24px;"alt="팝업 닫기"></a>
					</div>
				</div>
				<!--// content-->
			</div>
		</div>
	</div>
	<!-- popup 영역 end -->
	<form name="sform" id="sform" method="post" action="/event/smsCheck">
		<input type="hidden" name="ctn" id="ctn" /> 
		<input type="hidden" name="certinum" id="certinum" />
	</form>
</body>