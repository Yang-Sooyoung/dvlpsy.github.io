<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="shortcut icon" href="resources/favicon/favicon.ico">
<title>Normal Board Test</title>
<style type="text/css">
tbody tr {
	cursor: pointer;
}
tbody tr:HOVER {
	background-color: yellow;
}
.a {
	background-color: orange;
}
.now_p {
	font-weight: bold;
	color: orange;
}
</style>
<!-- jQuery Script -->
<script type="text/javascript" 
		src="resources/script/jquery/jquery-1.12.4.min.js"></script>
<script type="text/javascript">
$(document).ready(function(){
	$("tbody").on("click","tr",function(){
		$("#boardNo").val($(this).attr("id"));
		$("#sendForm").attr("action", "normalDetail");
		$("#sendForm").submit();
	});
	
	$("#searchBtn").on("click", function(){
		$("[name='searchGbn']").val($("#searchGbn").val());
		$("[name='searchText']").val($("#searchText").val());
		$("[name='page']").val(1);
		$("#sendForm").attr("action", "normalList");
		$("#sendForm").submit();
	});
	
	$(".paging_area").on("click", "span", function(){
		$("[name='page']").val($(this).attr("name"));
		$("#sendForm").attr("action", "normalList");
		$("#sendForm").submit();
	});
	
	$("#writeBtn").on("click", function(){
		$("#sendForm").attr("action", "normalWrite");
		$("#sendForm").submit();
	});
});
</script>
</head>
<body>
<form action="#" method="post" id="sendForm">
	<input type="hidden" name="boardNo" id="boardNo" />
	<input type="hidden" name="page" value="${page}" />
	<input type="hidden" name="searchGbn" value="${param.searchGbn}" />
	<input type="hidden" name="searchText" value="${param.searchText}" />
</form>
<select id="searchGbn">
	<c:choose>
		<c:when test="${param.searchGbn eq 0}">
			<option value="0" selected="selected">제목</option>
		</c:when>
		<c:otherwise>
			<option value="0">제목</option>
		</c:otherwise>
	</c:choose>
	<c:choose>
		<c:when test="${param.searchGbn eq 1}">
			<option value="1" selected="selected">작성자</option>
		</c:when>
		<c:otherwise>
			<option value="1">작성자</option>
		</c:otherwise>
	</c:choose>
	<c:choose>
		<c:when test="${param.searchGbn eq 2}">
			<option value="2" selected="selected">제목+작성자</option>
		</c:when>
		<c:otherwise>
			<option value="2">제목+작성자</option>
		</c:otherwise>
	</c:choose>
</select>
<input type="text" id="searchText" value="${param.searchText}" placeholder="검색" />
<input type="button" value="검색" id="searchBtn"/>
<input type="button" value="글쓰기" id="writeBtn"/>
<br/>
<table border="1" cellspacing="0">
	<thead>
		<tr>
			<th>번호</th>
			<th>제목</th>
			<th>작성자</th>
			<th>작성일</th>
			<th>조회수</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach var="data" items="${list}" varStatus="status">
			<c:choose>
				<c:when test="${status.count % 2 ne 1}">
					<tr id="${data.BOARD_NO}" class="a">
						<td>${data.BOARD_NO}</td>
						<td>${data.TITLE}</td>
						<td>${data.WRITER}</td>
						<td>${data.WRITE_DATE}</td>
						<td>${data.HIT_CNT}</td>
					</tr>
				</c:when>
				<c:otherwise>
					<tr id="${data.BOARD_NO}">
						<td>${data.BOARD_NO}</td>
						<td>${data.TITLE}</td>
						<td>${data.WRITER}</td>
						<td>${data.WRITE_DATE}</td>
						<td>${data.HIT_CNT}</td>
					</tr>
				</c:otherwise>
			</c:choose>
		</c:forEach>
	</tbody>
</table>
<div class="paging_area">
	<span name="1">처음</span>
	<c:choose>
		<c:when test="${page eq 1}">
			<span name="1">이전</span>
		</c:when>
		<c:otherwise>
			<span name="${page - 1}">이전</span>
		</c:otherwise>
	</c:choose>
	
	<c:forEach var="i" begin="${pb.startPcount}" 
					   end="${pb.endPcount}" step="1">
		<c:choose>
			<c:when test="${i eq page}">
				<span name="${i}" class="now_p">${i}</span>
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
	<span name="${pb.maxPcount}">맨끝</span>
</div>


</body>
</html>
















