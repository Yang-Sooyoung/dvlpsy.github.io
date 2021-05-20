<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>http://localhost:8090/SampleSpring/memberList</title>
<style type="text/css">
.member_table {
	border-collapse: collapse;
}

.member_table thead tr {
	border: 1px solid #444444;
	background-color: #55ACAC;
}

.member_table tbody tr {
	border: 1px solid #444444;
	cursor: pointer;
}

.member_table tbody tr:hover {
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
		location.href = "memberAdd";
	});
	
	$("#searchBtn").on("click", function() {
		$("#actionForm").attr("action", "memberList");
		$("#actionForm").submit();
	});
	
	$("#paging_area").on("click", "span", function() {
		$("#page").val($(this).attr("name"));
		
		$("#actionForm").attr("action", "memberList");
		$("#actionForm").submit();
	});
	
	$(".mb").on("click", "tr", function() {
		$("#mno").val($(this).attr("name"));
		
		$("#actionForm").attr("action", "memberDetail");
		$("#actionForm").submit();
	});
	
	$("#logoutBtn").on("click", function() {
		location.href = "memberLogout";
	});
	
});
</script>
</head>
<body>
${sMnm}님 어서오십시오. <input type="button" value="로그아웃" id="logoutBtn" />
<form action="#" method="post" id="actionForm">
<input type="hidden" name="mno" id="mno" />
<input type="hidden" name="page" id="page" value="${page}" />
<select name="searchGbn" id="searchGbn">
	<option value="0">아이디</option>
	<option value="1">이름</option>
</select>
<input type="text" name="searchTxt" value="${param.searchTxt}" />
<input type="button" value="검색" id="searchBtn" />
<input type="button" value="추가" id="addBtn" />
</form>
총${cnt}명
<table class="member_table">
	<thead>
		<tr>
			<th>회원번호</th>
			<th>아이디</th>
			<th>이름</th>
			<th>가입일</th>
		</tr>
	</thead>
	<tbody class="mb">
		<c:forEach var="member" items="${list}" >
		<tr name="${member.MNO}">
			<td>${member.MNO}</td>
			<td>${member.MID}</td>
			<td>${member.MNM}</td>
			<td>${member.JOINDT}</td>
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





