<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>http://localhost:8090/spring/test2</title>
<!--
	jsp경로 : /WEB-INF/views/test/test2.jsp
	웹주소 : /test2
	상대경로는 웹주소를 기준으로 동작
 -->
<script type="text/javascript"
		src="resources/jquery/jquery-1.12.4.js"></script>
<script type="text/javascript">
$(document).ready(function() {
	$("#sendBtn").on("click", function(){
		// submit() : 폼을 실행 하겠다.
		$("#sendForm").submit();
	});
});
</script>
</head>
<body>
<!-- action : 데이터를 보내며 이동할 곳  -->
<form action="test3" id="sendForm" method="post">
	<input type="text" name="msg" />
	<input type="button" value="전송" id="sendBtn" />
</form>
</body>
</html>