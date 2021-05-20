<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="shortcut icon" href="resources/favicon/favicon.ico">
<title>Normal Board Test</title>
<!-- jQuery Script -->
<script type="text/javascript" 
		src="resources/script/jquery/jquery-1.12.4.min.js"></script>
<script type="text/javascript">
$(document).ready(function(){
	$("#updateBtn").on("click", function(){
		$("#actionForm").attr("action", "normalUpdate");
		$("#actionForm").submit();
	});
	
	$("#deleteBtn").on("click", function(){
		if(confirm("삭제하시겠습니까?")) {
			if($.trim($("#pass").val()) == "") {
				alert("비밀번호를 입력하세요.");
				$("#pass").focus();
			} else {
				
				$("input[name='pass']").val($("#pass").val());
				$("#actionForm").attr("action", "normalDeleteS");
				$("#actionForm").submit();
			}
		}
	});
	
	$("#backBtn").on("click", function(){
		$("#actionForm").attr("action", "normalList");
		$("#actionForm").submit();
	});
});
</script>
</head>
<body>
<form action="#" id="actionForm" method="post">
	<input type="hidden" name="boardNo" value="${data.BOARD_NO}" />
	<input type="hidden" name="page" value="${param.page}" />
	<input type="hidden" name="searchGbn" value="${param.searchGbn}" />
	<input type="hidden" name="searchText" value="${param.searchText}" />
	<input type="hidden" name="pass" />
</form>
<table border="1" cellspacing="0">
	<tr>
		<th>번호</th>
		<td>${data.BOARD_NO}</td>
	</tr>
	<tr>
		<th>제목</th>
		<td>${data.TITLE}</td>
	</tr>
	<tr>
		<th>작성자</th>
		<td>${data.WRITER}</td>
	</tr>
	<tr>
		<th>작성일</th>
		<td>${data.WRITE_DATE}</td>
	</tr>
	<tr>
		<th>조회수</th>
		<td>${data.HIT_CNT}</td>
	</tr>
	<tr>
		<th>내용</th>
		<td>${data.CONTENTS}</td>
	</tr>
</table>
삭제비밀번호<input type="password" id="pass" />
<input type="button" value="수정" id="updateBtn" />
<input type="button" value="삭제" id="deleteBtn" />
<input type="button" value="뒤로가기" id="backBtn" />
</body>
</html>








