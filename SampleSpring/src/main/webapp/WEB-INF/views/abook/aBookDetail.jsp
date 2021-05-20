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
		$("#actionForm").attr("action", "aBookList");
		$("#actionForm").submit();
	});
	
	$("#updateBtn").on("click", function() {
		$("#actionForm").attr("action", "aBookUpdate");
		$("#actionForm").submit();
	});
	
	$("#deleteBtn").on("click", function() {
		if(confirm("삭제하시겠습니까?")) {
	var params = $("#actionForm").serialize();
			
			$.ajax({
				type : "post",
				url : "aBookDeleteAjax",
				dataType : "json", // {키:값, 키:값}
				data : params, // 보낼데이터
				success : function(res) { // 성공 시 해당 함수 실행, 결과는 result로 받겠다.
					if(res.res == "SUCCESS") {
						location.href = "aBookList";
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
<input type="hidden" name="bookno" value="${param.bookno}" />
<input type="hidden" name="page" value="${param.page}" />
<input type="hidden" name="searchGbn" value="${param.searchGbn}" />
<input type="hidden" name="searchTxt" value="${param.searchTxt}" />
</form>
<table>
	<tbody>
		<tr>
			<td>책번호</td>
			<td>${book.BOOK_NO}</td>
		</tr>
		<tr>
			<td>책제목</td>
			<td>${book.BOOK_NAME}</td>
		</tr>
		<tr>
			<td>저자</td>
			<td>${book.BOOK_WRITER}</td>
		</tr>
		<tr>
			<td>출판사</td>
			<td>${book.BOOK_PB}</td>
		</tr>
		<tr>
			<td>출판일</td>
			<td>${book.BOOK_PBDT}</td>
		</tr>
		<tr>
			<td>등록일</td>
			<td>${book.BOOK_RGDT}</td>
		</tr>
	</tbody>
	<tfoot>
		<tr>
			<td colspan="3">
				<input type="button" value="수정" id="updateBtn" />
				<input type="button" value="삭제" id="deleteBtn" />
				<input type="button" value="목록" id="listBtn" />
			</td>
		</tr>
	</tfoot>
</table>
</body>
</html>