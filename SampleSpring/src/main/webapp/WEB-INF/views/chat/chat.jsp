<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Chat Sample</title>
<!-- chat CSS -->
<link rel="stylesheet" type="text/css" href="resources/css/chat.css" />

<!-- jQuery Script -->
<script type="text/javascript" 
		src="resources/script/jquery/jquery-1.12.4.min.js"></script>

<script type="text/javascript">
var refreshInterval = null;

$(document).ready(function() {
	refreshInterval = setInterval(read,1000);
	
	$("#insertBtn").on("click", function(){
		if($.trim($("#message").val()) == null) {
			alert("내용을 입력해 주세요.");
		} else {
			insert();
		}
	});
});

function enterCheck(){
	if(event.keyCode == 13){
		if($.trim($("#message").val()) == "") {
			alert("내용을 입력해 주세요.");
		} else {
			insert();
		}
		return;
	}
}

function out() {
	location.href = "outChat";
}

function scrollDown() {
	$(".chatContents").animate({
		scrollTop: $(".chatContents").prop("scrollHeight") 
	}, 'slow', function () {});
}

function insert() {
	$("#contents").val($("#message").val());
	
	var params =  $("#insertForm").serialize();
	
	$.ajax({
		type : "post",
		url : "insertChat",
		dataType : "json",
		data : params,
		success : function(result) {
			$("#contents").val("");
			$("#message").val("");
		},
		error : function(result) {
			alert(result.errorMessage);
			$("#contents").val("");
			$("#message").val("");
		}
	});
}

function read() {
	clearInterval(refreshInterval);
	
	var params =  $("#readForm").serialize();
	
	$.ajax({
		type : "post",
		url : "getChatList",
		dataType : "json",
		data : params,
		success : function(result) {
			if(result.list.length != 0) {
				var html = "";
				for(var i = 0 ; i < result.list.length ; i++) {
					if(result.list[i].NICK == '${userNick}') {
						html += "<div class=\"chat_us\">";
						html += "<div class=\"chat_us_nick\">" + result.list[i].NICK + "[" + result.list[i].WRITEDATE + "]</div>";
						html += result.list[i].CONTENTS;
						html += "</div>";
					} else {
						html += "<div class=\"chat_ot\">";
						html += "<div class=\"chat_ot_nick\">" + result.list[i].NICK + "[" + result.list[i].WRITEDATE + "]</div>";
						html += result.list[i].CONTENTS;
						html += "</div>";
					}
				}
				
				$(".chatContents").append(html);
				$("#lastChatNo").val(result.list[result.list.length - 1].CHATNO);
				
				if($("#autoScroll").is(":checked")) {
					scrollDown();
				}
				
			}
			
			refreshInterval = setInterval(read,1000);
		},
		error : function(result) {
			alert(result.errorMessage);
			
			refreshInterval = setInterval(read,1000);
		}
	});
}
</script>
</head>
<body>
	<form method="post" id="readForm">
		<input type="hidden" id="lastChatNo" name="lastChatNo" value="${maxNo}"/>
	</form>
	<div class="settingArea">
		<input type="button" id="outBtn" value="나가기" onclick="out();" />
		<input type="checkbox" id="autoScroll" checked="checked" />자동스크롤
	</div><br/>
	<div class="chatContents">
	</div><br/>
	<div class="settingArea">
		<form method="post" id="insertForm">
			<input type="hidden" name="nick" value="${userNick}"/>
			<input type="hidden" id="contents" name="contents" value="${userNick}"/>
		</form>
		${userNick}
		<input type="text" id="message" size="50" onkeydown="enterCheck();"/>
		<input type="button" id="insertBtn" value="입력" />
	</div>
</body>
</html>