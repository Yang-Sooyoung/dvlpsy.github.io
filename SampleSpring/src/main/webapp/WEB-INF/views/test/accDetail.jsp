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
		$("#actionForm").attr("action", "accList");
		$("#actionForm").submit();
	});
	
	$("#updateBtn").on("click", function() {
		$("#actionForm").attr("action", "accUpdate");
		$("#actionForm").submit();
	});
	
	$("#deleteBtn").on("click", function() {
		if(confirm("삭제하시겠습니까?")) {
			$("#actionForm").attr("action", "accDelete");
			$("#actionForm").submit();
		}
	});
});
</script>
</head>
<body>
<form action="#" method="post" id="actionForm">
	<input type="hidden" name="accNo" value="${data.ACC_NO}" />
	<input type="hidden" name="searchGbn" value="${param.searchGbn}" />
	<input type="hidden" name="searchTxt" value="${param.searchTxt}" />
	<input type="hidden" name="page" value="${param.page}" />
</form>
가계번호 : ${data.ACC_NO}<br/>
입출금구분 : ${data.ACC_TYPE_TXT}<br/>
입출금내역 : ${data.ACC_TITLE}<br/>
입출금금액 : ${data.ACC_PRICE}<br/>
입출금일 : ${data.ACC_DATE}<br/>
<input type="button" value="수정" id="updateBtn" />
<input type="button" value="삭제" id="deleteBtn" />
<input type="button" value="목록" id="listBtn" />
</body>
</html>

















