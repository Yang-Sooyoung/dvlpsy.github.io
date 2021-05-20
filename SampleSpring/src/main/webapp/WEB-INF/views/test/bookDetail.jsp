<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
		$("#actionForm").attr("action", "bookList");
		$("#actionForm").submit();
	});
	
	$("#updateBtn").on("click", function() {
		$("#actionForm").attr("action", "bookUpdate");
		$("#actionForm").submit();
	});
	
	$("#deleteBtn").on("click", function() {
		if(confirm("삭제하시겠습니까?")) {
			$("#actionForm").attr("action", "bookDelete");
			$("#actionForm").submit();
		}
	});
});
</script>
</head>
<body>
<form action="#" method="post" id="actionForm">
	<input type="hidden" name="bookno" value="${data.BOOK_NO}" />
</form>
책번호 : ${data.BOOK_NO}<br/>
책제목 : ${data.BOOK_NAME}<br/>
저자 : ${data.BOOK_WRITER}<br/>
출판사 : ${data.BOOK_PB}<br/>
출판일 : ${data.BOOK_PBDT}<br/>
등록일 : ${data.BOOK_RGDT}<br/>
<input type="button" value="수정" id="updateBtn" />
<input type="button" value="삭제" id="deleteBtn" />
<input type="button" value="목록" id="listBtn" />
</body>
</html>