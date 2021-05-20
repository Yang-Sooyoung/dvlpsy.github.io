<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>http://localhost:8090/SampleSpring/test1</title>
<style type="text/css">
div {
	cursor: pointer;
}

div:hover {
	background-color: orange;
}
</style>
<script type="text/javascript"
		src="resources/script/jquery/jquery-1.12.4.min.js"></script>
<script type="text/javascript">
$(document).ready(function() {
	$("body").on("click", "div", function () {
		$("#memno").val($(this).attr("name"));
		/* id 있는거만 #붙임 */
		$("#actionForm").submit();
	});
	
	$("#addBtn").on("click", function() {
		location.href = "test1Add";
	});
	
	$("#searchBtn").on("click", function() {
		$("#page").val("1");
		$("#searchForm").submit();
	});
	
	$("#p").on("click", "span", function() {
		$("#page").val($(this).attr("name"));
		$("#searchForm").submit();
	});
});
</script>
</head>
<body>
<form action="test1Detail" method="post" id="actionForm">
	<input type="hidden" name="memno" id="memno" />
	<input type="hidden" name="searchGbn" value="${param.searchGbn}" />
	<input type="hidden" name="searchTxt" value="${param.searchTxt}" />
	<input type="hidden" name="page" value="${page}" />
</form>
<!-- 서버 우클릭, 에드 앤 리무브, 샘플스프링만 넣고 다 빼기, 서버 재시작 -->
잘보이는지 확인용입니다.<br/>
<form action="test1" method="post" id="searchForm">
	<input type="hidden" name="page" id="page" value="${page}" />
	<select name="searchGbn">
		<c:choose>
			<c:when test="${param.searchGbn eq 0}">
				<option value="0" selected="selected">번호</option>
			</c:when>
			<c:otherwise>
				<option value="0">번호</option>
			</c:otherwise>
		</c:choose>
		<c:choose>
			<c:when test="${param.searchGbn eq 1}">
				<option value="1" selected="selected">이름</option>
			</c:when>
			<c:otherwise>
				<option value="1">이름</option>
			</c:otherwise>
		</c:choose>
	</select>
	<input type="text" name="searchTxt" value="${param.searchTxt}" />
	<input type="button" value="검색" id="searchBtn" />
	<input type="button" value="추가" id="addBtn" />
</form>
<c:forEach var="data" items="${list}">
<div name="${data.MEMNO}">${data.MEMNO},${data.MEMNAME}</div>
</c:forEach>
<span id="p">
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
		<span name="${page + 1}">다음</span> <!-- 처음 1, 마지막 maxCount -->
	</c:otherwise>
</c:choose>
</span>
</body>
</html>