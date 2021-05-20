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
	$("#cancelBtn").on("click", function() {
		history.back();
	});
	
	$("#updateBtn").on("click", function() {
		
			$("#actionForm").submit();
		}
	});

	$("#actionForm").on("keypress", "input", function(e) {
		if(e.keyCode == 13) {
			return false;
		}
	});
});
</script>
</head>
<body>
<form action="bookUpdates" method="post" id="actionForm">
<input type="hidden" name="bookno" value="${data.BOOK_NO}" />
책제목 <input type="text" name="bookname" id="bookname" value="${data.BOOK_NAME}" /><br/>
저자 <input type="text" name="bookwriter" id="bookwriter" value="${data.BOOK_WRITER}" /><br/>
출판사 <input type="text" name="bookpb" id="bookpb" value="${data.BOOK_PB}" /><br/>
출판일 <input type="date" name="bookpbdt" id="bookpbdt" value="${data.BOOK_PBDT}"  /><br/>
</form>
<input type="button" value="수정" id="updateBtn" />
<input type="button" value="취소" id="cancelBtn" />
</body>
</html>









