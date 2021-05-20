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
	CKEDITOR.replace("bcon", { // bcon이라는 객체를 CKEDITOR로 변환하겠다.
		resize_enabled : false, // 크기변환 가능 : 불가능
		language : "ko", // 언어 : 한국어
		enterMode : "2", // 엔터를 줄바꿈으로 사용하겠다.
		width : "600",
		height : "400"
	});
	
	$("#cancelBtn").on("click", function() {
		history.back();
	});

	$("#updateBtn").on("click", function() {
						// CKEDITOR개체 중 bcon의 내용을 가져오겠다.
		$("#bcon").val(CKEDITOR.instances['bcon'].getData());
		
		if($.trim($("#btitle").val()) == "") {
			alert("제목을 입력해주세요.");
			$("#btitle").focus();
		} else if($.trim($("#bwriter").val()) == "") {
			alert("작성자를 입력해주세요.");
			$("#bwriter").focus();
		} else if($.trim($("#bcon").val()) == "") {
			alert("내용을 입력해주세요.");
			$("#bcon").focus();
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
<form action="test2Updates" method="post" id="actionForm">
<input type="hidden" name="bno" value="${data.B_NO}" />
<input type="hidden" name="searchGbn" value="${param.searchGbn}" />
<input type="hidden" name="searchTxt" value="${param.searchTxt}" />
<input type="hidden" name="page" value="${param.page}" />
제목 <input type="text" name="btitle" id="btitle" value="${data.B_TITLE}" /> <br/>
작성자 <input type="text" name="bwriter" id="bwriter" value="${data.B_WRITER}" /> <br/>
내용 
<div>
	<textarea rows="20" cols="40" name="bcon" id="bcon">${data.B_CON}</textarea>
</div>
</form>
<input type="button" value="수정" id="updateBtn" />
<input type="button" value="취소" id="cancelBtn" />
</body>
</html>

