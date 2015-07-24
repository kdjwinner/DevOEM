<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<script type="text/javascript" src="js/main/preListenPlayer.js"></script>
<script type="text/javascript">
	$(function() {
		common.invoker.invoke("preListenPlayer");				
	});	
</script>
<div class="layerOverlay" id="layerOverlay" style="display:none"></div>
<input type="hidden" id="pre_song_code1" value="" />
<input type="hidden" id="pre_song_code2" value="" />
<input type="hidden" id="pre_song_code3" value="" />
<input type="hidden" id="present_play_gugan" value="" />
<input type="hidden" id="present_play_song_code" value="" />
<input type="hidden" id="orginal_play_song_code" value="" />


<div class="layerPop01" id="layerPop01" style="display:none">
	<div class="inner" style="top:60px;">
		<div class="innerOverlay"></div>
		<p class="popTit">미리듣기 플레이어<span style="float:right;margin-right:10px;"><a href="javascript:preListenPlayer.ui.playerClose();" id="closeBtn" class="close"></a></span></p>
		<div class="popBody">

		
			<div style="width:100%">
				<img src="images/no_image.gif" width="90" height="90" style="position:absolute; padding:10px;" id="sing_image">
				<div style="padding-left:10px;background-color:#262727; padding-left:110px;">
					<font color="white"><b><p id="preListenTitle" style="padding-top:10px;"></p></b></font><BR>
					<font color="white"><b><p id="preListenArtist"></p></b></font><BR>
					<font color="white"><b><p id="preListenCharge"></p></b></font><BR>
				</div>
			</div>

			
			<!-- 재생바 영역 -->
			<table width="100%" border="0" cellspacing="0" cellpadding="0">
				<tr>
					<td height="7" bgcolor="#262727">
						<div>
							<div id="playbarEmptyArea1" style="width:5%;height:30px;float:left;background-color:#262727">&nbsp;</div>
							<div id="stateArea" style="width:90%;height:30px;background-color:#4d4d4d;float:left">
								<div style="width:100%;height:10px;background-color:#262727;"></div>
								<div style="width:100%;height:10px;">
									<div id="stateLeftArea" style="width:0px;height:10px;background-color:#f11100;float:left"></div>
									<div id="stateButtonArea" style="width:10px;height:10px;background-color:white;float:left"></div>
								</div>
								<div style="width:100%;height:10px;background-color:#262727;"></div>
							</div>
							<div style="width:90%;height:30px;z-index:2;position:absolute;">
								<canvas id="touchCanvas" style="width:100%;height:100%"></canvas>
							</div>
							<div id="playbarEmptyArea2" style="width:5%;height:30px;float:left;background-color:#262727">&nbsp;</div>
						</div>
					</td>
				</tr>
			</table>
			<!-- 재생바 영역 -->
			
			<!-- 구간 영역 -->
			<div style="background-color:#262727;">
				<table width="100%" border="0" cellspacing="0" cellpadding="0" style="text-align: center;">
					<tr>
						<td onclick="javascript:preListenPlayer.ui.chageMusic('1');"><img id="player_radio_img1" src="images/player/radio_off.png" style="width:8%;vertical-align: middle;">&nbsp;&nbsp;후렴</td>
						<td onclick="javascript:preListenPlayer.ui.chageMusic('2');"><img id="player_radio_img2" src="images/player/radio_off.png" style="width:8%;vertical-align: middle;">&nbsp;&nbsp;앞부분</td>
						<td onclick="javascript:preListenPlayer.ui.chageMusic('3');"><img id="player_radio_img3" src="images/player/radio_off.png" style="width:8%;vertical-align: middle;">&nbsp;&nbsp;뒷부분</td>
					</tr>
					<tr style="height: 10px;"></tr>
					<tr>
						<td><a href="javascript:preListenPlayer.ui.play();"><img src="images/player/btn_play.png" id="playBtn" style="width: 90%;" ></a></td>
						<td><a href="javascript:preListenPlayer.ui.pause();"><img src="images/player/btn_pause.png" id="pauseBtn" style="width: 90%;"></a></td>
						<td><a href="javascript:preListenPlayer.ui.stop();"><img src="images/player/btn_stop.png" style="width: 90%;"></a><span id="errorView"></span></td>
					</tr>
				</table>
			</div>
			<!-- 구간 영역 -->

			<table width="100%" border="0" cellspacing="0" cellpadding="0">
				<tr><td height="15" bgcolor="#262727"></td></tr>
			</table>

			<div style="background-color:#262727;" id="pre_liste_set_div">
				<table style="width:100%;text-align: center;">
					<tr>
						<td><div style="background-color:#262727; padding-bottom:10%;" onClick="javascript:preListenPlayer.ui.playerSetting('1');"><img src="images/player/btn01.png" style="width: 80%;"/></div></td>
						<td><div style="background-color:#262727; padding-bottom:10%;" onClick="javascript:preListenPlayer.ui.playerSetting('3');"><img src="images/player/btn02.png" style="width: 80%;"/></div></td>
					</tr>
					<tr>
						<td><div style="background-color:#262727; padding-bottom:10%;" onClick="javascript:preListenPlayer.ui.playerSetting('2');"><img src="images/player/btn03.png" style="width: 80%;"/></div></td>
						<td><div style="background-color:#262727; padding-bottom:10%;" onClick="javascript:preListenPlayer.ui.playerSetting('4');"><img src="images/player/btn04.png" style="width: 80%;"/></div></td>
					</tr>
					<tr id="pre_liste_present_div">
						<td colspan="2"><div style="background-color:#262727; padding-bottom:5%;" onClick="javascript:preListenPlayer.ui.playerSetting('5');"><img src="images/player/btn05.png" style="width: 40%;"/></div></td>
					</tr>
				</table>
			</div>

		</div>
	</div>
</div>