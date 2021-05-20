<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>http://localhost:8090/spring/test4</title>
<script type="text/javascript"
		src="resources/jquery/jquery-1.12.4.js"></script>
<script type="text/javascript">
$(document).ready(function() {
 	$("#sendBtn").on("click", function() {
 		if($.trim($("#dan").val()) == "") {
 			alert("단을 입력해 주세요.");
 		} else {
 			$("#sendForm").submit();	
 		}
	});
});
</script>
</head>
<body>
<!-- action : 데이터를 보내며 이동할 곳  -->
<form action="test5" id="sendForm" method="post">
	<input type="number" name="dan" id="dan"/>
	<input type="button" value="전송" id="sendBtn" />
</form>
</body>
</html>