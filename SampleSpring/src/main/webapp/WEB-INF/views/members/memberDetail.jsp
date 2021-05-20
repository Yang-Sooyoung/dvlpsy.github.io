<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
		$("#actionForm").attr("action", "memberList");
		$("#actionForm").submit();
	});
	
	$("#updateBtn").on("click", function() {
		$("#actionForm").attr("action", "memberUpdate");
		$("#actionForm").submit();
	});
	
	$("#deleteBtn").on("click", function() {
		if(confirm("삭제하시겠습니까?")) {
			$("#actionForm").attr("action", "memberDelete");
			$("#actionForm").submit();
		}
	});
});
</script>
</head>
<body>
<form action="#" method="post" id="actionForm">
<input type="hidden" name="mno" value="${param.mno}" />
<input type="hidden" name="page" value="${param.page}" />
<input type="hidden" name="searchGbn" value="${param.searchGbn}" />
<input type="hidden" name="searchTxt" value="${param.searchTxt}" />
</form>
<table>
	<tbody>
		<tr>
			<td>회원번호</td>
			<td>${member.MNO}</td>
		</tr>
		<tr>
			<td>아이디</td>
			<td>${member.MID}</td>
		</tr>
		<tr>
			<td>비밀번호</td>
			<td>${member.MPW}</td>
		</tr>
		<tr>
			<td>이름</td>
			<td>${member.MNM}</td>
		</tr>
		<tr>
			<td>생년월일</td>
			<td>${member.MBIRTH}</td>
		</tr>
		<tr>
			<td>취미</td>
			<td>${member.MHOBBY}</td>
		</tr>
		<tr>
			<td>가입일</td>
			<td>${member.JOINDT}</td>
		</tr>
	</tbody>
	<tfoot>
		<tr>
			<td colspan="2">
				<input type="button" value="수정" id="updateBtn" />
				<input type="button" value="삭제" id="deleteBtn" />
				<input type="button" value="목록" id="listBtn" />
			</td>
		</tr>
	</tfoot>
</table>
</body>
</html>




