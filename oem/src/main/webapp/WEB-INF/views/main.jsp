<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ include file="include/header.jsp"%>
	<title>[olleh ������]</title>
<link href="css/jquery.bxslider.css" type="text/css" rel="stylesheet" />	
<script type="text/javascript" src="js/jquery/jquery.bxslider.js"></script>
<script type="text/javascript" src="js/jquery/iscroll.js"></script>	
<script type="text/javascript" src="js/main/main.js"></script>
<script type="text/javascript">
	$(function() {
		common.invoker.invoke("main");				
	});	
</script>
</head>
<body style="overflow-x:hidden;">
	<div id="wrapper2">
		<div id="mOllehWrap">
<%@include file="include/gnb.jsp"%>	
	<!-----------------------------------------// ������ ���� ---------------------------------------------------------->
			<div id="mOllehContainer">				
				<div id="mollehContentAll">
					<div id="searchArea">
						<%@include file="include/bodySearch.jsp"%>
					</div>	
 
					<div id="VoLTEBar">
				 		<table width="100%" border="0" cellspacing="0" cellpadding="0">
				 		</table>
						<table width="100%" border="0" cellspacing="0" cellpadding="0">
							<tr><td height="5"></td></tr>
						</table>				 		
				 	</div>
					<table width="100%" border="0" cellspacing="0" cellpadding="0">
						<tr><td height="1" bgcolor="#c9c9c9"></td></tr>
					</table>				
					<div>
						<ul class="bxslider">
							<li><a href="#" target="_blank"><img src="http://ktfring2youp.magicn.com/oem/image/22.png" style="width:100%;" class="slideImg"/></a></li>	
							<li><a href="#" target="_blank"><img src="http://ktfring2youp.magicn.com/oem/image/22.png" style="width:100%;" class="slideImg"/></a></li>
						</ul>
					</div>
<!----------------------------------------- ��õ ������ ���� �ϴ� ���� Start-------------------------------------------->
<!----------------------------------------- ��õ ������ ���� �ϴ� ���� End---------------------------------------------->

					<div id="container">
						<ul class="tab">
							<li id="tab1" class="active" style="width:25%;"><a href="javascript:main.ui.tabControl(1)" style="text-align:center;"><font size="3" color="black"><b>�ǽð���Ʈ</b></font></a></li>
							<li id="tab2" style="width:25%;"><a href="javascript:main.ui.tabControl(2)" style="text-align:center;"><font size="3" color="black"><b>�ֽ� ��Ʈ</b></font></a></li>
							<li id="tab3" style="width:25%;"><a href="javascript:main.ui.tabControl(3)" style="text-align:center;"><font size="3" color="black"><b>�ְ��α�</b></font></a></li>
							<li id="tab4" style="width:25%;"><a href="javascript:main.ui.tabControl(4)" style="text-align:center;"><font size="3" color="black"><b>���� ��</b></font></a></li>
						</ul>
						<div class="tab_container">
							<div id="bestRingArea">
								<div class="musicList01">
									<table summary="�α�� ���� ��Ʈ">
										<caption>�α�� ����</caption>
										<colgroup>
											<col width="35" />
											<col width="*" />
											<col width="45" />
											<col width="45" />
										</colgroup>
										<thead>
											<tr>
												<th>N O</th>
												<th>�� ��</th>
												<th>���</th>
												<th>����</th>
											</tr>
										</thead>
										<tbody id="best_tbody">
										</tbody>
									</table>
								</div>
				<!-- ������ Start-->
					<span class="mOllehBtnWhiteBig" style="width:100%;padding:0px 0px 0px 0px;text-align:cetner;border:0px">
						<span id="bestViewMore" style="font-size:15px;font-weight:bold;margin-left: 5%;" onClick="javascript:main.ui.viewMore('best');">
							������+
						</span>
						<span style="font-size:15px;font-weight:bold;float: right;" onClick="javascript:main.ui.viewTop('best');">
							<img src="images/main/btn_top.gif" style="width: 50%;vertical-align: middle;">
						</span>
					</span>

				<!-- ������ End-->								
<!-- 
								<div class="pagings page5" id="bestRingPagingDiv">
									<a href="#" class="prev"><img src="images/paging/pagingFirst_off.gif" width="25" height="25" alt="ó�����"></a>
									<a href="#" class="prev"><img src="images/paging/pagingPrev_off.gif" width="25" height="25" alt="�������"></a>
									<span class="loca"><strong>1</strong> / 10</span>
									<a href="javascript:main.fn.paging('2', 'best')" class="next"><img src="images/paging/pagingNext.gif" width="25" height="25" alt="�������"></a>
									<a href="javascript:main.fn.paging('10', 'best')" class="next"><img src="images/paging/pagingLast.gif" width="25" height="25" alt="���������"></a>
								</div>
-->																	
							</div>
						
							<div id="newRingArea" style="display:none;">
								<div class="musicList01">
									<table summary="�ֽŰ� ����Ʈ">
										<caption>�ֽŰ�</caption>
										<colgroup>
											<col width="35" />
											<col width="*" />
											<col width="45" />
											<col width="45" />
										</colgroup>
										<thead>
											<tr>
												<th>N O</th>
												<th>�� ��</th>
												<th>���</th>
												<th>����</th>
											</tr>
										</thead>
										<tbody id="new_tbody">
										</tbody>
									</table>
								</div>
							<!-- ������ Start-->
								<span class="mOllehBtnWhiteBig" style="width:100%;padding:0px 0px 0px 0px;text-align:cetner;border:0px">
									<span id="newViewMore" style="font-size:15px;font-weight:bold;margin-left: 5%;" onClick="javascript:main.ui.viewMore('new');">
										������+
									</span>
									<span style="font-size:15px;font-weight:bold;float: right;" onClick="javascript:main.ui.viewTop('new');">
										<img src="images/main/btn_top.gif" style="width: 50%;vertical-align: middle;">
									</span>
								</span>
			
							<!-- ������ End-->								
<!-- 								
								<div class="pagings page5" id="newRingPagingDiv">
									<a href="#" class="prev"><img src="images/paging/pagingFirst_off.gif" width="25" height="25" alt="ó�����"></a>
									<a href="#" class="prev"><img src="images/paging/pagingPrev_off.gif" width="25" height="25" alt="�������"></a>
									<span class="loca"><strong>1</strong> / 10</span>
									<a href="javascript:main.fn.paging('2', 'new')" class="next"><img src="images/paging/pagingNext.gif" width="25" height="25" alt="�������"></a>
									<a href="javascript:main.fn.paging('10', 'new')" class="next"><img src="images/paging/pagingLast.gif" width="25" height="25" alt="���������"></a>
								</div>		
 -->																							
							</div>
					
							<div id="weekRingArea" style="display:none;">
								<div class="musicList01">
									<table summary="�α�� ���� ��Ʈ">
										<caption>�α�� ����</caption>
										<colgroup>
											<col width="35" />
											<col width="*" />
											<col width="45" />
											<col width="45" />
										</colgroup>
										<thead>
											<tr>
												<th>N O</th>
												<th>�� ��</th>
												<th>���</th>
												<th>����</th>
											</tr>
										</thead>
										<tbody id="week_tbody">
										</tbody>
									</table>
								</div>
							<!-- ������ Start-->
								<span class="mOllehBtnWhiteBig" style="width:100%;padding:0px 0px 0px 0px;text-align:cetner;border:0px">
									<span id="weekViewMore" style="font-size:15px;font-weight:bold;margin-left: 5%;" onClick="javascript:main.ui.viewMore('week');">
										������+
									</span>
									<span style="font-size:15px;font-weight:bold;float: right;" onClick="javascript:main.ui.viewTop('week');">
										<img src="images/main/btn_top.gif" style="width: 50%;vertical-align: middle;">
									</span>
								</span>
			
							<!-- ������ End-->										
<!-- 								
								<div class="pagings page5" id="weekRingPagingDiv">
									<a href="#" class="prev"><img src="images/paging/pagingFirst_off.gif" width="25" height="25" alt="ó�����"></a>
									<a href="#" class="prev"><img src="images/paging/pagingPrev_off.gif" width="25" height="25" alt="�������"></a>
									<span class="loca"><strong>1</strong> / 10</span>
									<a href="javascript:main.fn.paging('2', 'week')" class="next"><img src="images/paging/pagingNext.gif" width="25" height="25" alt="�������"></a>
									<a href="javascript:main.fn.paging('10', 'week')" class="next"><img src="images/paging/pagingLast.gif" width="25" height="25" alt="���������"></a>
								</div>			
 -->															
							</div>			
																	
							<div id="freeRingArea" style="display: none;">
								<div class="musicList01">
									<table summary="���ḵ ��Ʈ">
										<caption>���ḵ</caption>
										<colgroup>
											<col width="35">
											<col width="*">
											<col width="45">
											<col width="45">
										</colgroup>
										<thead>
											<tr>
												<th>N O</th>
												<th>�� ��</th>
												<th>���</th>
												<th>����</th>
											</tr>
										</thead>
										<tbody>
											<tr>
												<td class="nums">1</td>
												<td class="tits">
												<span class="tit">
													<img src="images/main/hd_ring_icon.gif" width="24" height="17">
													ĳ�� D����
												</span>
												<span class="artist">���ﺧ</span>
												</td>
												<td><a href="javascript:preListenPlayer.ui.playerOpen('31440416093914','ĳ�� D����','���ﺧ');"><img src="images/main/ring_prelisten_button.gif" width="31" height="31" alt="�̸����"></a></td>
												<td><a href="javascript:main.ui.openSetup('free_song','1','31440416093914', 'ĳ�� D����', '���ﺧ');"><img src="images/main/btn_buy.gif" width="31" height="31" alt="����"></a></td>
				
											</tr>
											<tr class="guganChkTr" id="free_song1" name="guganChkTr"></tr>
											<tr>
												<td class="nums">2</td>
												<td class="tits">
												<span class="tit">
													<img src="images/main/hd_ring_icon.gif" width="24" height="17">
													���� �뷡
												</span>
												<span class="artist">�൨����</span>
												</td>
												<td><a href="javascript:preListenPlayer.ui.playerOpen('31440416093917','���� �뷡','�൨����');"><img src="images/main/ring_prelisten_button.gif" width="31" height="31" alt="�̸����"></a></td>
												<td><a href="javascript:main.ui.openSetup('free_song','2','31440416093917', '���� �뷡', '�൨����');"><img src="images/main/btn_buy.gif" width="31" height="31" alt="����"></a></td>
				
											</tr>
											<tr class="guganChkTr" id="free_song2" name="guganChkTr"></tr>
											<tr>
												<td class="nums">3</td>
												<td class="tits">
												<span class="tit">
													<img src="images/main/hd_ring_icon.gif" width="24" height="17">
													ÿ�� ���� 1�� �� ��������
												</span>
												<span class="artist">����</span>
												</td>
												<td><a href="javascript:preListenPlayer.ui.playerOpen('31440416093920','ÿ�� ���� 1�� �� ��������','����');"><img src="images/main/ring_prelisten_button.gif" width="31" height="31" alt="�̸����"></a></td>
												<td><a href="javascript:main.ui.openSetup('free_song','3','31440416093920', 'ÿ�� ���� 1�� �� ��������', '����');"><img src="images/main/btn_buy.gif" width="31" height="31" alt="����"></a></td>
				
											</tr>
											<tr class="guganChkTr" id="free_song3" name="guganChkTr"></tr>
											<tr>
												<td class="nums">4</td>
												<td class="tits">
												<span class="tit">
													<img src="images/main/hd_ring_icon.gif" width="24" height="17">
													���, �ܿ� - 2����
												</span>
												<span class="artist">��ߵ�</span>
												</td>
												<td><a href="javascript:preListenPlayer.ui.playerOpen('31440416093923','���, �ܿ� - 2����','��ߵ�');"><img src="images/main/ring_prelisten_button.gif" width="31" height="31" alt="�̸����"></a></td>
												<td><a href="javascript:main.ui.openSetup('free_song','4','31440416093923', '���, �ܿ� - 2����', '��ߵ�');"><img src="images/main/btn_buy.gif" width="31" height="31" alt="����"></a></td>
				
											</tr>
											<tr class="guganChkTr" id="free_song4" name="guganChkTr"></tr>
											<tr>
												<td class="nums">5</td>
												<td class="tits">
												<span class="tit">
													<img src="images/main/hd_ring_icon.gif" width="24" height="17">
													����
												</span>
												<span class="artist">������Ʈ</span>
												</td>
												<td><a href="javascript:preListenPlayer.ui.playerOpen('31440416093926','����','������Ʈ');"><img src="images/main/ring_prelisten_button.gif" width="31" height="31" alt="�̸����"></a></td>
												<td><a href="javascript:main.ui.openSetup('free_song','5','31440416093926', '����', '������Ʈ');"><img src="images/main/btn_buy.gif" width="31" height="31" alt="����"></a></td>
				
											</tr>
											<tr class="guganChkTr" id="free_song5" name="guganChkTr"></tr>
											<tr style="" class="freeview">
												<td class="nums">6</td>
												<td class="tits">
												<span class="tit">
													<img src="images/main/hd_ring_icon.gif" width="24" height="17">
													�����ڿ���(���� �ϸ��)
												</span>
												<span class="artist">KT</span>
												</td>
												<td><a href="javascript:preListenPlayer.ui.playerOpen('31440416094568','�����ڿ���(���� �ϸ��)','KT');"><img src="images/main/ring_prelisten_button.gif" width="31" height="31" alt="�̸����"></a></td>
												<td><a href="javascript:main.ui.openSetup('free_song','6','31440416094568', '�����ڿ���(���� �ϸ��)', 'KT');"><img src="images/main/btn_buy.gif" width="31" height="31" alt="����"></a></td>
				
											</tr>
											<tr class="guganChkTr" id="free_song6" name="guganChkTr"></tr>
											<tr style="" class="freeview">
												<td class="nums">7</td>
												<td class="tits">
												<span class="tit">
													<img src="images/main/hd_ring_icon.gif" width="24" height="17">
													�Ϲ� ��ȭ ��ȭ ������
												</span>
												<span class="artist">KT</span>
												</td>
												<td><a href="javascript:preListenPlayer.ui.playerOpen('31440416094571','�Ϲ� ��ȭ ��ȭ ������','KT');"><img src="images/main/ring_prelisten_button.gif" width="31" height="31" alt="�̸����"></a></td>
												<td><a href="javascript:main.ui.openSetup('free_song','7','31440416094571', '�Ϲ� ��ȭ ��ȭ ������', 'KT');"><img src="images/main/btn_buy.gif" width="31" height="31" alt="����"></a></td>
				
											</tr>
											<tr class="guganChkTr" id="free_song7" name="guganChkTr"></tr>
										</tbody>
									</table>
								</div>
							</div>
						</div>
					</div>
					<table width="100%" border="0" cellspacing="0" cellpadding="0"><tbody><tr><td height="2"></td></tr></tbody></table>					
				</div>
			</div>
<%@include file="include/footer.jsp"%>			
		</div>
<%@include file="include/preListenPlayer.jsp"%>		
	</div>
</body>