<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript"
		src="resources/script/jquery/jquery-1.12.4.min.js"></script>
<script type="text/javascript"
		src="resources/script/ckeditor/ckeditor.js"></script>
<script type="text/javascript">
$(document).ready(function() {
	CKEDITOR.replace("boardCon", { // bcon이라는 객체를 CKEDITOR로 변환하겠다.
		resize_enabled : false, // 크기변환 가능 : 불가능
		language : "ko", // 언어 : 한국어
		enterMode : "2", // 엔터를 줄바꿈으로 사용하겠다
		width : "600",
		height : "400"
	});
	
	$("#cancelBtn").on("click", function() {
		history.back();
	});
	
	$("#updateBtn").on("click", function() {
		              // CKEDITOR객체 중 bcon의 내용을 가져오겠다.
		$("#boardCon").val(CKEDITOR.instances['boardCon'].getData());
		
		if($.trim($("#boardTitle").val()) == "") {
			alert("제목을 입력해 주세요.");
			$("#boardTitle").focus();
		} else if($.trim($("#boardCon").val()) == "") {
			alert("내용을 입력해 주세요.");
			$("#boardCon").focus();
		} else {
			$("#actionForm").submit();
		}
	});
	
	$("#actionForm").on("keypress", "input", function(e) {
		if(e.keyCode == 13) {
			return false;
		}
	});
});
</script>
</head>
<body>
<form action="boardUpdates" method="post" id="actionForm">
<input type="hidden" name="boardNo" value="${param.boardNo}" />
<input type="hidden" name="page" value="${param.page}" />
<input type="hidden" name="searchGbn" value="${param.searchGbn}" />
<input type="hidden" name="searchTxt" value="${param.searchTxt}" />
글번호 : ${board.BOARD_NO}<br/>
제목 <input type="text" name="boardTitle" id="boardTitle" value="${board.BOARD_TITLE}" /><br/>
작성자 : ${board.MNM}<br/>
내용
<div>
	<textarea rows="20" cols="40" name="boardCon" id="boardCon">${board.BOARD_CON}</textarea>
</div>
</form>
<input type="button" value="수정" id="updateBtn" />
<input type="button" value="취소" id="cancelBtn" />
</body>
</html>









