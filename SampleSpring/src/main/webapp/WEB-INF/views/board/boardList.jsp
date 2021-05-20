<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>http://localhost:8090/SampleSpring/boardList</title>
<style type="text/css">
.board_table {
	border-collapse: collapse;
}

.board_table thead tr {
	border: 1px solid #444444;
	background-color: #55ACAC;
}

.board_table tbody tr {
	border: 1px solid #444444;
	cursor: pointer;
}

.board_table tbody tr:hover {
	background-color: orange;
}
</style>
<script type="text/javascript"
		src="resources/script/jquery/jquery-1.12.4.min.js"></script>
<script type="text/javascript">
$(document).ready(function() {
	if('${param.searchGbn}' != '') {
		$("#searchGbn").val('${param.searchGbn}');
	}
	
	$("#addBtn").on("click", function() {
		location.href = "boardAdd";
	});
	
	$("#searchBtn").on("click", function() {
		$("#page").val("1");
		$("#actionForm").attr("action", "boardList");
		$("#actionForm").submit();
	});
	
	$("#paging_area").on("click", "span", function() {
		$("#page").val($(this).attr("name"));
		
		$("#actionForm").attr("action", "boardList");
		$("#actionForm").submit();
	});
	
	$(".board_table").on("click", "tr", function() {
		$("#boardNo").val($(this).attr("name"));
		
		$("#actionForm").attr("action", "boardDetail");
		$("#actionForm").submit();
	});
	
	$("#logoutBtn").on("click", function() {
		location.href = "memberLogout";
	});
	
	$("#loginBtn").on("click", function() {
		location.href = "memberLogin";
	});
});
</script>
</head>
<body>
<!-- session을 jsp에서 취득 시 el활용 -->
<c:choose>
<c:when test="${!empty sMno}">
${sMnm}님 어서오십시오.<input type="button" value="로그아웃" id="logoutBtn" />
</c:when>
<c:otherwise>
<input type="button" value="로그인" id="loginBtn" />
</c:otherwise>
</c:choose>
<form action="#" method="post" id="actionForm">
<input type="hidden" name="boardNo" id="boardNo" />
<input type="hidden" name="page" id="page" value="${page}" />
<select name="searchGbn" id="searchGbn">
	<option value="0">제목</option>
	<option value="1">작성자</option>
</select>
<input type="text" name="searchTxt" value="${param.searchTxt}" />
<input type="button" value="검색" id="searchBtn" />
<c:if test="${!empty sMno}">
	<input type="button" value="추가" id="addBtn" />
</c:if>
</form>
<table class="board_table">
	<thead>
		<tr>
			<th>글번호</th>
			<th>제목</th>
			<th>작성자</th>
			<th>작성일</th>
			<th>조회수</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach var="board" items="${list}" >
		<tr name="${board.BOARD_NO}">
			<td>${board.BOARD_NO}</td>
			<td>${board.BOARD_TITLE}</td>
			<td>${board.MNM}</td>
			<td>${board.BOARD_DT}</td>
			<td>${board.BOARD_HIT}</td>
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





