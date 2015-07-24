<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<form method="get" name="searchForm" action="/oem/searchResult.jsp" class="localSearchWrap">
	<input type="hidden" name="new_keyword" value="">
	<input type="hidden" name="old_keyword" value="">
	<input type="hidden" name="typeone" value="0">
	<div id="search" class="localSearch" style="width: 70%;margin-left: 10%;margin-right: 3%;float: left;margin-bottom:2%;">
		<div id="search_form" class="textInputArea" style="padding-left:0px;">
			<span id="search_area">
				<input type="search" placeholder="곡명 or 가수명" id="keyword" name="keyword" class="search_input" style="border-left-width: 0px;text-align:center;" maxlength="255" value="" />
			</span>
		</div>
	</div>
	<div id="search_btn" class="btnArea" style="float: left; position: relative; top:0px;right: 0px;">
		<input type="image" src="images/include/btnLocalSearch.gif" alt="검색" onclick="javascript:goSearching();" />
	</div>
</form>
