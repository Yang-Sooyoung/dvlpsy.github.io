<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript"
		src="resources/script/jquery/jquery-1.12.4.min.js"></script>
<script type="text/javascript">
$(document).ready(function() {
	$("#listBtn").on("click", function() {
		history.back();
	});
	
	$("#addBtn").on("click", function() {
		if($.trim($("#bookname").val()) == "") {
			alert("책제목을 입력해 주세요.");
			$("#bookname").focus();
		} else if($.trim($("#bookwriter").val()) == "") {
			alert("저자를 입력해 주세요.");
			$("#bookwriter").focus();
		} else if($.trim($("#bookpb").val()) == "") {
			alert("출판사를 입력해 주세요.");
			$("#bookpb").focus();
		} else if($.trim($("#bookpbdt").val()) == "") {
			alert("출판일을 입력해 주세요.");
			$("#bookpbdt").focus();
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
<form action="bookAdds" method="post" id="actionForm">
책제목 <input type="text" name="bookname" id="bookname" /><br/>
저자 <input type="text" name="bookwriter" id="bookwriter" /><br/>
출판사 <input type="text" name="bookpb" id="bookpb" /><br/>
출판일 <input type="date" name="bookpbdt" id="bookpbdt" /><br/>
</form>
<input type="button" value="추가" id="addBtn" />
<input type="button" value="목록" id="listBtn" />
</body>
</html>
