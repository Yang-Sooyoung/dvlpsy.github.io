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
	if("${res}" == "success") {
		location.href = "test2";
	} else {
		alert("삭제중 문제가 발생하였습니다.");
		history.back();
	}
});
</script>
</head>
<body>
</body>
</html>

