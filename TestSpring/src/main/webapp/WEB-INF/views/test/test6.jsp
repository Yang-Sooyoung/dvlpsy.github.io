<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>http://localhost:8090/spring/test6</title>
<script type="text/javascript"
		src="resources/jquery/jquery-1.12.4.js"></script>
<script type="text/javascript">
$(document).ready(function() {
	$("#sendBtn").on("click", function() {
		if($.trim($("#jang").val()) == "") {
			alert("구입 장수를 입력해 주세요.");
		} else {
			$("#sendForm").submit();
		}		
	});
});
</script>
</head>
<body>
<form action="test7" id="sendForm" method="post">
	<input type="number" name="jang" id="jang"/>
	<input type="button" value="전송" id="sendBtn"/>
</form>
</body>
</html>




