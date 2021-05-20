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
		$("#actionForm").attr("action", "aBoardList");
		$("#actionForm").submit();
	});
	
	$("#updateBtn").on("click", function() {
		$("#actionForm").attr("action", "aBoardUpdate");
		$("#actionForm").submit();
	});
	
	$("#deleteBtn").on("click", function() {
		if(confirm("삭제하시겠습니까?")) {
	var params = $("#actionForm").serialize();
			
			$.ajax({
				type : "post",
				url : "aBoardDeleteAjax",
				dataType : "json", // {키:값, 키:값}
				data : params, // 보낼데이터
				success : function(res) { // 성공 시 해당 함수 실행, 결과는 result로 받겠다.
					if(res.res == "SUCCESS") {
						location.href = "aBoardList";
					} else {
						$("#alert").attr("title", "알림");
						$("#alert p").html("삭제에 실패하였습니다.");
						$("#alert").dialog({
							buttons: {
								Ok: function() {
									$(this).dialog("close");
								}
							}
						});
					}
				},
				error : function(req, status, error) { // 결과, 상태값, 에러
					console.log("code : " + req.status);
					console.log("message : " + req.responseText);
				}
			});
		}
	});
});
</script>
</head>
<body>
<div id="alert" style="display: none;"><p></p></div>
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
		<c:if test="${!empty board.BOARD_FILE}">
		<tr>
			<td>첨부파일</td>
			<td><a href="resources/upload/${board.BOARD_FILE}" download>${board.BOARD_FILE}</a></td>
		</tr>
		</c:if>
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




