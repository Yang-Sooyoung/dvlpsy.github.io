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
		$("#actionForm").attr("action", "test1");
		$("#actionForm").submit();
	});
	
	$("#updateBtn").on("click", function() {
		$("#actionForm").attr("action", "test1Update");
		$("#actionForm").submit();
	});
	
	$("#deleteBtn").on("click", function() {
		if(confirm("삭제하시겠습니까?")) {
			$("#actionForm").attr("action", "test1Delete");
			$("#actionForm").submit();
		}
	});
});
</script>		
</head>
<body>
<form action="#" method="post" id="actionForm">
	<input type="hidden" name="memno" value="${data.MEMNO}" />
	<input type="hidden" name="searchGbn" value="${param.searchGbn}" />
	<input type="hidden" name="searchTxt" value="${param.searchTxt}" />
	<input type="hidden" name="page" value="${param.page}" />
</form>
회원번호 : ${data.MEMNO}<br/>
이름 : ${data.MEMNAME}<br/>
생년월일 : ${data.MEMBIRTH}<br/>
전화번호 : ${data.MEMPHONE}<br/>
<input type="button" value="수정" id="updateBtn" />
<input type="button" value="삭제" id="deleteBtn" />
<input type="button" value="목록" id="listBtn" />
</body>
</html>