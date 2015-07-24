<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ include file="include/header.jsp"%>
	<title>[olleh 링투유]</title>
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
	<!-----------------------------------------// 컨텐츠 영역 ---------------------------------------------------------->
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
<!----------------------------------------- 추천 링투유 영역 일단 생략 Start-------------------------------------------->
<!----------------------------------------- 추천 링투유 영역 일단 생략 End---------------------------------------------->

					<div id="container">
						<ul class="tab">
							<li id="tab1" class="active" style="width:25%;"><a href="javascript:main.ui.tabControl(1)" style="text-align:center;"><font size="3" color="black"><b>실시간차트</b></font></a></li>
							<li id="tab2" style="width:25%;"><a href="javascript:main.ui.tabControl(2)" style="text-align:center;"><font size="3" color="black"><b>최신 차트</b></font></a></li>
							<li id="tab3" style="width:25%;"><a href="javascript:main.ui.tabControl(3)" style="text-align:center;"><font size="3" color="black"><b>주간인기</b></font></a></li>
							<li id="tab4" style="width:25%;"><a href="javascript:main.ui.tabControl(4)" style="text-align:center;"><font size="3" color="black"><b>무료 링</b></font></a></li>
						</ul>
						<div class="tab_container">
							<div id="bestRingArea">
								<div class="musicList01">
									<table summary="인기곡 순위 차트">
										<caption>인기곡 순위</caption>
										<colgroup>
											<col width="35" />
											<col width="*" />
											<col width="45" />
											<col width="45" />
										</colgroup>
										<thead>
											<tr>
												<th>N O</th>
												<th>곡 명</th>
												<th>듣기</th>
												<th>설정</th>
											</tr>
										</thead>
										<tbody id="best_tbody">
										</tbody>
									</table>
								</div>
				<!-- 더보기 Start-->
					<span class="mOllehBtnWhiteBig" style="width:100%;padding:0px 0px 0px 0px;text-align:cetner;border:0px">
						<span id="bestViewMore" style="font-size:15px;font-weight:bold;margin-left: 5%;" onClick="javascript:main.ui.viewMore('best');">
							더보기+
						</span>
						<span style="font-size:15px;font-weight:bold;float: right;" onClick="javascript:main.ui.viewTop('best');">
							<img src="images/main/btn_top.gif" style="width: 50%;vertical-align: middle;">
						</span>
					</span>

				<!-- 더보기 End-->								
<!-- 
								<div class="pagings page5" id="bestRingPagingDiv">
									<a href="#" class="prev"><img src="images/paging/pagingFirst_off.gif" width="25" height="25" alt="처음목록"></a>
									<a href="#" class="prev"><img src="images/paging/pagingPrev_off.gif" width="25" height="25" alt="이전목록"></a>
									<span class="loca"><strong>1</strong> / 10</span>
									<a href="javascript:main.fn.paging('2', 'best')" class="next"><img src="images/paging/pagingNext.gif" width="25" height="25" alt="다음목록"></a>
									<a href="javascript:main.fn.paging('10', 'best')" class="next"><img src="images/paging/pagingLast.gif" width="25" height="25" alt="마지막목록"></a>
								</div>
-->																	
							</div>
						
							<div id="newRingArea" style="display:none;">
								<div class="musicList01">
									<table summary="최신곡 리스트">
										<caption>최신곡</caption>
										<colgroup>
											<col width="35" />
											<col width="*" />
											<col width="45" />
											<col width="45" />
										</colgroup>
										<thead>
											<tr>
												<th>N O</th>
												<th>곡 명</th>
												<th>듣기</th>
												<th>설정</th>
											</tr>
										</thead>
										<tbody id="new_tbody">
										</tbody>
									</table>
								</div>
							<!-- 더보기 Start-->
								<span class="mOllehBtnWhiteBig" style="width:100%;padding:0px 0px 0px 0px;text-align:cetner;border:0px">
									<span id="newViewMore" style="font-size:15px;font-weight:bold;margin-left: 5%;" onClick="javascript:main.ui.viewMore('new');">
										더보기+
									</span>
									<span style="font-size:15px;font-weight:bold;float: right;" onClick="javascript:main.ui.viewTop('new');">
										<img src="images/main/btn_top.gif" style="width: 50%;vertical-align: middle;">
									</span>
								</span>
			
							<!-- 더보기 End-->								
<!-- 								
								<div class="pagings page5" id="newRingPagingDiv">
									<a href="#" class="prev"><img src="images/paging/pagingFirst_off.gif" width="25" height="25" alt="처음목록"></a>
									<a href="#" class="prev"><img src="images/paging/pagingPrev_off.gif" width="25" height="25" alt="이전목록"></a>
									<span class="loca"><strong>1</strong> / 10</span>
									<a href="javascript:main.fn.paging('2', 'new')" class="next"><img src="images/paging/pagingNext.gif" width="25" height="25" alt="다음목록"></a>
									<a href="javascript:main.fn.paging('10', 'new')" class="next"><img src="images/paging/pagingLast.gif" width="25" height="25" alt="마지막목록"></a>
								</div>		
 -->																							
							</div>
					
							<div id="weekRingArea" style="display:none;">
								<div class="musicList01">
									<table summary="인기곡 순위 차트">
										<caption>인기곡 순위</caption>
										<colgroup>
											<col width="35" />
											<col width="*" />
											<col width="45" />
											<col width="45" />
										</colgroup>
										<thead>
											<tr>
												<th>N O</th>
												<th>곡 명</th>
												<th>듣기</th>
												<th>설정</th>
											</tr>
										</thead>
										<tbody id="week_tbody">
										</tbody>
									</table>
								</div>
							<!-- 더보기 Start-->
								<span class="mOllehBtnWhiteBig" style="width:100%;padding:0px 0px 0px 0px;text-align:cetner;border:0px">
									<span id="weekViewMore" style="font-size:15px;font-weight:bold;margin-left: 5%;" onClick="javascript:main.ui.viewMore('week');">
										더보기+
									</span>
									<span style="font-size:15px;font-weight:bold;float: right;" onClick="javascript:main.ui.viewTop('week');">
										<img src="images/main/btn_top.gif" style="width: 50%;vertical-align: middle;">
									</span>
								</span>
			
							<!-- 더보기 End-->										
<!-- 								
								<div class="pagings page5" id="weekRingPagingDiv">
									<a href="#" class="prev"><img src="images/paging/pagingFirst_off.gif" width="25" height="25" alt="처음목록"></a>
									<a href="#" class="prev"><img src="images/paging/pagingPrev_off.gif" width="25" height="25" alt="이전목록"></a>
									<span class="loca"><strong>1</strong> / 10</span>
									<a href="javascript:main.fn.paging('2', 'week')" class="next"><img src="images/paging/pagingNext.gif" width="25" height="25" alt="다음목록"></a>
									<a href="javascript:main.fn.paging('10', 'week')" class="next"><img src="images/paging/pagingLast.gif" width="25" height="25" alt="마지막목록"></a>
								</div>			
 -->															
							</div>			
																	
							<div id="freeRingArea" style="display: none;">
								<div class="musicList01">
									<table summary="무료링 차트">
										<caption>무료링</caption>
										<colgroup>
											<col width="35">
											<col width="*">
											<col width="45">
											<col width="45">
										</colgroup>
										<thead>
											<tr>
												<th>N O</th>
												<th>곡 명</th>
												<th>듣기</th>
												<th>설정</th>
											</tr>
										</thead>
										<tbody>
											<tr>
												<td class="nums">1</td>
												<td class="tits">
												<span class="tit">
													<img src="images/main/hd_ring_icon.gif" width="24" height="17">
													캐논 D장조
												</span>
												<span class="artist">파헬벨</span>
												</td>
												<td><a href="javascript:preListenPlayer.ui.playerOpen('31440416093914','캐논 D장조','파헬벨');"><img src="images/main/ring_prelisten_button.gif" width="31" height="31" alt="미리듣기"></a></td>
												<td><a href="javascript:main.ui.openSetup('free_song','1','31440416093914', '캐논 D장조', '파헬벨');"><img src="images/main/btn_buy.gif" width="31" height="31" alt="설정"></a></td>
				
											</tr>
											<tr class="guganChkTr" id="free_song1" name="guganChkTr"></tr>
											<tr>
												<td class="nums">2</td>
												<td class="tits">
												<span class="tit">
													<img src="images/main/hd_ring_icon.gif" width="24" height="17">
													봄의 노래
												</span>
												<span class="artist">멘델스존</span>
												</td>
												<td><a href="javascript:preListenPlayer.ui.playerOpen('31440416093917','봄의 노래','멘델스존');"><img src="images/main/ring_prelisten_button.gif" width="31" height="31" alt="미리듣기"></a></td>
												<td><a href="javascript:main.ui.openSetup('free_song','2','31440416093917', '봄의 노래', '멘델스존');"><img src="images/main/btn_buy.gif" width="31" height="31" alt="설정"></a></td>
				
											</tr>
											<tr class="guganChkTr" id="free_song2" name="guganChkTr"></tr>
											<tr>
												<td class="nums">3</td>
												<td class="tits">
												<span class="tit">
													<img src="images/main/hd_ring_icon.gif" width="24" height="17">
													첼로 조곡 1번 중 프렐류드
												</span>
												<span class="artist">바흐</span>
												</td>
												<td><a href="javascript:preListenPlayer.ui.playerOpen('31440416093920','첼로 조곡 1번 중 프렐류드','바흐');"><img src="images/main/ring_prelisten_button.gif" width="31" height="31" alt="미리듣기"></a></td>
												<td><a href="javascript:main.ui.openSetup('free_song','3','31440416093920', '첼로 조곡 1번 중 프렐류드', '바흐');"><img src="images/main/btn_buy.gif" width="31" height="31" alt="설정"></a></td>
				
											</tr>
											<tr class="guganChkTr" id="free_song3" name="guganChkTr"></tr>
											<tr>
												<td class="nums">4</td>
												<td class="tits">
												<span class="tit">
													<img src="images/main/hd_ring_icon.gif" width="24" height="17">
													사계, 겨울 - 2악장
												</span>
												<span class="artist">비발디</span>
												</td>
												<td><a href="javascript:preListenPlayer.ui.playerOpen('31440416093923','사계, 겨울 - 2악장','비발디');"><img src="images/main/ring_prelisten_button.gif" width="31" height="31" alt="미리듣기"></a></td>
												<td><a href="javascript:main.ui.openSetup('free_song','4','31440416093923', '사계, 겨울 - 2악장', '비발디');"><img src="images/main/btn_buy.gif" width="31" height="31" alt="설정"></a></td>
				
											</tr>
											<tr class="guganChkTr" id="free_song4" name="guganChkTr"></tr>
											<tr>
												<td class="nums">5</td>
												<td class="tits">
												<span class="tit">
													<img src="images/main/hd_ring_icon.gif" width="24" height="17">
													숭어
												</span>
												<span class="artist">슈베르트</span>
												</td>
												<td><a href="javascript:preListenPlayer.ui.playerOpen('31440416093926','숭어','슈베르트');"><img src="images/main/ring_prelisten_button.gif" width="31" height="31" alt="미리듣기"></a></td>
												<td><a href="javascript:main.ui.openSetup('free_song','5','31440416093926', '숭어', '슈베르트');"><img src="images/main/btn_buy.gif" width="31" height="31" alt="설정"></a></td>
				
											</tr>
											<tr class="guganChkTr" id="free_song5" name="guganChkTr"></tr>
											<tr style="" class="freeview">
												<td class="nums">6</td>
												<td class="tits">
												<span class="tit">
													<img src="images/main/hd_ring_icon.gif" width="24" height="17">
													힐링자연음(봄의 하모니)
												</span>
												<span class="artist">KT</span>
												</td>
												<td><a href="javascript:preListenPlayer.ui.playerOpen('31440416094568','힐링자연음(봄의 하모니)','KT');"><img src="images/main/ring_prelisten_button.gif" width="31" height="31" alt="미리듣기"></a></td>
												<td><a href="javascript:main.ui.openSetup('free_song','6','31440416094568', '힐링자연음(봄의 하모니)', 'KT');"><img src="images/main/btn_buy.gif" width="31" height="31" alt="설정"></a></td>
				
											</tr>
											<tr class="guganChkTr" id="free_song6" name="guganChkTr"></tr>
											<tr style="" class="freeview">
												<td class="nums">7</td>
												<td class="tits">
												<span class="tit">
													<img src="images/main/hd_ring_icon.gif" width="24" height="17">
													일반 전화 통화 연결음
												</span>
												<span class="artist">KT</span>
												</td>
												<td><a href="javascript:preListenPlayer.ui.playerOpen('31440416094571','일반 전화 통화 연결음','KT');"><img src="images/main/ring_prelisten_button.gif" width="31" height="31" alt="미리듣기"></a></td>
												<td><a href="javascript:main.ui.openSetup('free_song','7','31440416094571', '일반 전화 통화 연결음', 'KT');"><img src="images/main/btn_buy.gif" width="31" height="31" alt="설정"></a></td>
				
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