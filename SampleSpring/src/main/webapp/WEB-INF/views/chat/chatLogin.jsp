<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Chat Login</title>
<!-- jQuery Script -->
<script type="text/javascript" 
		src="resources/script/jquery/jquery-1.12.4.min.js"></script>
<script type="text/javascript">
$(document).ready(function(){
	$("#joinBtn").on("click", function(){
		if($.trim($("#userNick").val()) == null) {
			alert("사용자 별칭을 입력해 주세요.");
		} else {
			$("#joinForm").submit();
		}
	});
});
</script>
</head>
<body>
	<form action="joinChat" method="post" id="joinForm">
		<table>
			<tr>
				<td>Nick</td>
				<td>
					<input type="text" id="userNick" name="userNick" />
				</td>
				<td rowspan="2">
					<input type="button" value="입장" id="joinBtn"/>
				</td>
			</tr>
		</table>
	</form>
</body>
</html>