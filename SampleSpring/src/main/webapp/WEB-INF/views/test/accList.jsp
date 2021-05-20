<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>http://localhost:8090/SampleSpring/accList</title>
<style type="text/css">
table {
	border-collapse: collapse;
}

tbody tr {
	border: 1px solid #444444;
	cursor: pointer;
}

tbody tr:hover {
	background-color: orange;
}
</style>
<script type="text/javascript"
		src="resources/script/jquery/jquery-1.12.4.min.js"></script>
<script type="text/javascript">
$(document).ready(function() {
	$("tbody").on("click", "tr", function() {
		$("#accNo").val($(this).attr("name"));
		
		$("#actionForm").submit();
	});
	
	$("#addBtn").on("click", function() {
		location.href = "accAdd";
	});
	
	$("#searchBtn").on("click", function() {
		$("#page").val("1");
		$("#searchForm").submit();
	});
	
	$("#paging_area").on("click", "span", function() {
		$("#page").val($(this).attr("name"));
		$("#searchForm").submit();
	});
});
</script>
</head>
<body>
<form action="accDetail" method="post" id="actionForm">
	<input type="hidden" name="accNo" id="accNo" />
	<input type="hidden" name="searchGbn" value="${param.searchGbn}" />
	<input type="hidden" name="searchTxt" value="${param.searchTxt}" />
	<input type="hidden" name="page" value="${page}" />
</form>
<form action="accList" method="post" id="searchForm">
	<input type="hidden" name="page" id="page" value="${page}" />
	<select name="searchGbn">
		<c:choose>
			<c:when test="${param.searchGbn eq 0}">
				<option value="0" selected="selected">가계번호</option>
			</c:when>
			<c:otherwise>
				<option value="0">가계번호</option>
			</c:otherwise>
		</c:choose>
		<c:choose>
			<c:when test="${param.searchGbn eq 1}">
				<option value="1" selected="selected">입출금내역</option>
			</c:when>
			<c:otherwise>
				<option value="1">입출금내역</option>
			</c:otherwise>
		</c:choose>
	</select>
	<input type="text" name="searchTxt" value="${param.searchTxt}" />
	<input type="button" value="검색" id="searchBtn" />
	<input type="button" value="추가" id="addBtn" />
</form>
<table>
	<thead>
		<tr>
			<th>가계번호</th>
			<th>입출금구분</th>
			<th>입출금내역</th>
			<th>입출금금액</th>
			<th>입출금일</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach var="data" items="${list}">
		<tr name="${data.ACC_NO}">
			<td>${data.ACC_NO}</td>
			<td>${data.ACC_TYPE_TXT}</td>
			<td>${data.ACC_TITLE}</td>
			<td>${data.ACC_PRICE}</td>
			<td>${data.ACC_DATE}</td>
		</tr>
		</c:forEach>
	</tbody>
</table>
<div id="paging_area">
<c:choose>
	<c:when test="${page eq 1}">
		<span name="1">이전</span>
	</c:when>
	<c:otherwise>
		<span name="${page - 1}">이전</span>
	</c:otherwise>
</c:choose>
<c:forEach var="i" begin="${pb.startPcount}" end="${pb.endPcount}" step="1">
	<c:choose>
		<c:when test="${page eq i}">
			<span name="${i}"><b>${i}</b></span>
		</c:when>
		<c:otherwise>
			<span name="${i}">${i}</span>
		</c:otherwise>
	</c:choose>
</c:forEach>
<c:choose>
	<c:when test="${page eq pb.maxPcount}">
		<span name="${pb.maxPcount}">다음</span>
	</c:when>
	<c:otherwise>
		<span name="${page + 1}">다음</span>
	</c:otherwise>
</c:choose>
</div>
</body>
</html>





