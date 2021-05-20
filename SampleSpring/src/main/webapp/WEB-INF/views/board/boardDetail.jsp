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
		$("#actionForm").attr("action", "boardList");
		$("#actionForm").submit();
	});
	
	$("#updateBtn").on("click", function() {
		$("#actionForm").attr("action", "boardUpdate");
		$("#actionForm").submit();
	});
	
	$("#deleteBtn").on("click", function() {
		if(confirm("삭제하시겠습니까?")) {
			$("#actionForm").attr("action", "boardDelete");
			$("#actionForm").submit();
		}
	});
});
</script>
</head>
<body>
<form action="#" method="post" id="actionForm">
<input type="hidden" name="boardNo" value="${param.boardNo}" />
<input type="hidden" name="page" value="${param.page}" />
<input type="hidden" name="searchGbn" value="${param.searchGbn}" />
<input type="hidden" name="searchTxt" value="${param.searchTxt}" />
</form>
<table>
	<tbody>
		<tr>
			<td>글번호</td>
			<td>${board.BOARD_NO}</td>
		</tr>
		<tr>
			<td>제목</td>
			<td>${board.BOARD_TITLE}</td>
		</tr>
		<tr>
			<td>작성자</td>
			<td>${board.MNM}</td>
		</tr>
		<tr>
			<td>작성일</td>
			<td>${board.BOARD_DT}</td>
		</tr>
		<tr>
			<td>조회수</td>
			<td>${board.BOARD_HIT}</td>
		</tr>
		<tr>
			<td colspan="2">내용</td>
		</tr>
		<tr>
			<td colspan="2">${board.BOARD_CON}</td>
		</tr>
	</tbody>
	<tfoot>
		<tr>
			<td colspan="2">
				<c:if test="${board.MNO eq sMno}">
				<input type="button" value="수정" id="updateBtn" />
				<input type="button" value="삭제" id="deleteBtn" />
				</c:if>
				<input type="button" value="목록" id="listBtn" />
			</td>
		</tr>
	</tfoot>
</table>
</body>
</html>




