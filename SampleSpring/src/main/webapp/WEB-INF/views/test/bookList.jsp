<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>http://localhost:8090/SampleSpring/bookList</title>
<style type="text/css">
table {
	border-collapse: collapse;
}

tbody tr {
	border: 1px solid #444444;
	cursor: pointer;
}

tbody tr:hover {
	width: 170px;
	background-color: orange;
}
</style>
<script type="text/javascript"
		src="resources/script/jquery/jquery-1.12.4.min.js"></script>
<script type="text/javascript">
$(document).ready(function() {
	$("tbody").on("click", "tr", function() {
		$("#bookno").val($(this).attr("name"));
		
		$("#actionForm").submit();
	});
	
	$("#addBtn").on("click", function() {
		location.href = "bookAdd";
	});
	
});
</script>
</head>
<body>
<form action="bookDetail" method="post" id="actionForm">
	<input type="hidden" name="bookno" id="bookno" />
	<input type="button" value="추가" id="addBtn" />
</form>
<table>
	<thead>
		<tr>
			<th>책번호</th>
			<th>책제목</th>
			<th>저자</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach var="data" items="${list}">
		<tr name="${data.BOOK_NO}">
			<td>${data.BOOK_NO}</td>
			<td>${data.BOOK_NAME}</td>
			<td>${data.BOOK_WRITER}</td>
		</tr>
		</c:forEach>
	</tbody>
</table>
</body>
</html>