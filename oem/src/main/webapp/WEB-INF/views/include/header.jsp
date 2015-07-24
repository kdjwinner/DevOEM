<%@ page language="java" contentType="text/html; charset=EUC-KR"  pageEncoding="EUC-KR"%>
<%
	// 캐쉬를 없애줘야 이전키를 누를때..재 로딩된다.
	response.setDateHeader("Expires", 0); 
	response.setHeader("pragma", "no-cache");
	response.setHeader("Cache-Control", "no-cache");
%>
<!DOCTYPE html> 
<head>
	<base href="http://ringtoyou.olleh.com/">
	<meta name="viewport" content="width=device-width, minimum-scale=1.0, maximum-scale=1.0" />
	<meta http-equiv="content-Type" content="text/html; charset=euc-kr" />
	<meta name="format-detection" content="telephone=no" />
	<meta name="author" content="이만규" />
	<meta name="Description" content="[폰서비스] 전체 링투유 - 전화를 건 상대방에게 다양한 음악이나 효과음을 들려주는 KT 통화연결음 서비스입니다." />
	<meta name="keywords" content="올레, 올레닷컴, olleh, 통화연결음, 링투유, 컬러링, ring, 오토, 벨소리, 벨링, bell, 롱투유, 필링, 인기링, 최신링" />
	<meta name="Publisher" content="이만규" />
	<meta name="Other Agent" content="이만규" />
	<meta name="Distribution" content="이만규" />
	<meta name="Author-Date(Date)" content="20150703" />
	<link href="css/molleh.css" type="text/css" rel="stylesheet" />
	<link href="css/guide.css" type="text/css" rel="stylesheet" />
	<link href="css/oem.css" type="text/css" rel="stylesheet" />
	<script type="text/javascript" src="js/jquery/jquery-1.8.min.js"></script>	
	<script type="text/javascript" src="js/jquery/jquery.json-2.4.js"></script>
	<script type="text/javascript" src="js/common/common.js"></script>	
	<script type="text/javascript" src="js/common/gnb.js"></script>	