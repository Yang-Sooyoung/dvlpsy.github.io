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
		$("#actionForm").attr("action", "test2");
		$("#actionForm").submit();
	});
	
	$("#updateBtn").on("click", function() {
		$("#actionForm").attr("action", "test2Update");
		$("#actionForm").submit();
	});
	
	$("#deleteBtn").on("click", function() {
		if(confirm("삭제하시겠습니까?")) {
			$("#actionForm").attr("action", "test2Delete");
			$("#actionForm").submit();
		}
	});
});
</script>
</head>
<body>
<form action="#" method="post" id="actionForm">
	<input type="hidden" name="bno" value="${data.B_NO}" />
	<input type="hidden" name="searchGbn" value="${param.searchGbn}" />
	<input type="hidden" name="searchTxt" value="${param.searchTxt}" />
	<input type="hidden" name="page" value="${param.page}" />
</form>
회원번호 : ${data.B_NO}<br/>
제목 : ${data.B_TITLE}<br/>
내용 : ${data.B_CON}<br/>
작성자 : ${data.B_WRITER}<br/>
작성일 : ${data.B_DT}<br/>
<input type="button" value="수정" id="updateBtn" />
<input type="button" value="삭제" id="deleteBtn" />
<input type="button" value="목록" id="listBtn" />
</body>
</html>


