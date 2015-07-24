<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ include file="../include/header.jsp"%>
	<title>[olleh ������]</title>
<script type="text/javascript" src="js/sms/sms.js"></script>
<script type="text/javascript">
	$(function() {
		common.invoker.invoke("sms");				
	});	
</script>	
</head>
<body>
	 <div>
		<img src = "images/sms/title_sms.gif" style="width:100%;" class="top" alt="������ SMS ����">
		<img src = "images/sms/notice.png" style="width:100%;" alt="�������� KT ���Ը��� ��� ���� �մϴ�">

		<div style="padding:3%;border-top: 1px solid blue;margin-top:1%;">
			<p class="topText" style="font-size: 15px;">Kt ���� Ȯ���� ����</p>
			<p class="topText"><B style="color:red;font-size: 15px;">������ȣ�� SMS�� ���� �帳�ϴ�.</B></p>
		</div>

		<div class="phoneArea">

			<div class="phoneIn">
				<select id="num" name="num" class="inputTag" style="width: 60px;margin-right: 1px;font-size: 15px;">
					<option value="010">010</option>
					<option value="011">011</option>
					<option value="016">016</option>
					<option value="018">018</option>
				</select>
				<input type="text" maxlength = "8" placeholder = "�޴��� ��ȣ�� �Է����ּ���" id="myphone" name="myphone" class="inputTag" style="font-size:12px;width: 156px;text-align:center;">
				<img src = "images/sms/btn_sms_certify.gif" style="height: 34px;vertical-align: middle;width:80px;cursor:pointer;" onclick="javascript:sms.fn.send();" alt="������ȣ �߼�">
			</div>
			<div class="phoneIn">
				<input type="text" id="certify" placeholder = "SMS ������ȣ�� �Է��ϼ���." name="certify" class="inputTag" style="width: 300px;vertical-align: bottom;text-align:center;margin-left: 5px;margin-right: 5px;">
			</div>
			<div style="border-bottom: 1px solid blue;padding-bottom: 20px;">
				<p style="font-size: 12px;text-align: center;">���� ��ȣ �߼��� �ִ� 1�� ���� �ҿ�� �� �ֽ��ϴ�</p>
			</div>		
		</div>	


		<div class="phoneArea" style="margin-left: 4%;margin-right: 4%;margin-top:5%;margin-bottom:5%;">
			<span style="font-size: 12px;">(��) kt�� �����ϴ� ������ ���񽺸� �̿��Ͻñ� ���ؼ� �̿� ��� �� �������� ����/���� ���ǰ� �ʿ��մϴ�.</span>
		</div>
		<div style="margin:2%;overflow:hidden;clear:both;padding-left: 1%;padding-right: 1%;">
			<div style="float:left;padding-top:10px;">
				<span style="font-size:12px;vertical-align: middle;" >
					<input type="checkbox" id="chk1" />
						���� �̿����� ���� �մϴ�.
					</span>
			</div>
			<div style="float:right;padding-top:10px;">
				<img src = "images/sms/btn_terms.gif" style="width:70px;height:20px;vertical-align: bottom;" alt="�������" onClick="javascript:sms.ui.openDivPopup('layer1');">
			</div>
		</div>
		<div style="margin:2%;overflow:hidden;clear:both;padding-left: 1%;padding-right: 1%;">
			<div style="float:left;padding-top:10px;">
				<span style="font-size:12px;vertical-align: middle;" >
					<input type="checkbox" id="chk2" />
					�������� ���� �� �̿뿡 ���� �մϴ�.
				</span>
			</div>
			<div style="float:right;padding-top:10px;">
				<img src = "images/sms/btn_terms.gif" style="width:70px;height:20px;vertical-align: bottom;" alt="�������" onClick="javascript:sms.ui.openDivPopup('layer2');">
			</div>
		</div>

		<div align="center" style="margin-top: 30px;padding-bottom: 30px;border-bottom: 1px solid blue;">
			<img src = "images/sms/btn_cancel.gif" style="height: 30px;vertical-align: middle;width:80px;margin-right:30px;cursor:pointer;" onclick="javascript:location.href='/';" alt="���">
			<img src = "images/sms/btn_confirm.gif" style="height: 30px;vertical-align: middle;width:80px;cursor:pointer;" onclick="javascript:sms.fn.confirm();" alt="Ȯ��">
		</div>

		<div class="phoneArea" style="margin-left: 5%;margin-right: 5%;text-align:left;margin-top: 4%;">
			<div style="margin:3% 0;">
				<span style="font-size: 11px;">* �����񽺴� SMS ������ ������ �޴����� ���� �̿��� �����մϴ�</span>
			</div>
			<div style="margin:3% 0;">
				<span style="font-size: 11px;">* ���� ������� �޴����� USIM �ܵ� �����̰ų� �޴����� USIM�� �и��� ���¿����� SMS ������ ������ �� �����ϴ�.</span>
			</div>
		</div>
	</div> 
	<!-- popup ���� start -->
	<div class="bg"></div>	
	<div class="layer">
		<div id="layer1" class="pop-layer" style="border: 2px solid #2d2d2d;">
			<div class="pop-container">
				<!--content //-->
				<div class="pop-conts">
					<img src = "images/terms/detail01.gif" style="width:100%;" class="top" alt="������ �̿� ���">
					<img src = "images/terms/title01.gif" style="width:100%;" class="top" alt="������ �̿� ���">
					<div class="popupTextDiv1" style="height:380px;overflow-y:scroll;font-size:11px;padding-left:10px;padding-right:10px;" >
						<div>
							<%@include file="../include/terms1.jsp"%>				
						</div>
					</div>
					<div class="btn-r" style="margin-top:10px;margin-bottom: 10px;text-align:center;">
						<a href="#" class="cbtn"><img src = "images/terms/btn.gif" style="height: 24px;"alt="�˾� �ݱ�"></a>
					</div>
				</div>
				<!--// content-->
			</div>
		</div>
		<div id="layer2" class="pop-layer" style="border: 2px solid #2d2d2d;">
			<div class="pop-container">
				<!--content //-->
				<div class="pop-conts">
					<img src = "images/notice/detail02.gif" style="width:100%;" class="top" alt="���� ���� ��� ��ħ">
					<img src = "images/notice/title02.gif" style="width:100%;" class="top" alt="���� ���� ��� ��ħ">
					<div class="popupTextDiv1" style="height:380px;overflow-y:scroll;font-size:11px;padding-left:10px;padding-right:10px;" >
						<%@include file="../include/terms2.jsp"%>				
					</div>
					<div class="btn-r" style="margin-top:20px;margin-bottom: 10px;text-align:center;">
						<a href="#" class="cbtn"><img src = "images/terms/btn.gif" style="height: 24px;"alt="�˾� �ݱ�"></a>
					</div>
				</div>
				<!--// content-->
			</div>
		</div>
	</div>
	<!-- popup ���� end -->
	<form name="sform" id="sform" method="post" action="/event/smsCheck">
		<input type="hidden" name="ctn" id="ctn" /> 
		<input type="hidden" name="certinum" id="certinum" />
	</form>
</body>