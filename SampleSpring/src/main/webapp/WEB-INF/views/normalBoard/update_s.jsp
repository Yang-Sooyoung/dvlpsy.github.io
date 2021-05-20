<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<!-- jQuery Script -->
<script type="text/javascript" 
		src="resources/script/jquery/jquery-1.12.4.min.js"></script>
<script type="text/javascript">
$(document).ready(function() {
	if('${check}' == 'FALSE') {
		alert("비밀번호가 틀렸습니다.");
		$("#actionForm").attr("action", "normalUpdate");
		$("#actionForm").submit();
	} else {
		if('${result}' > 0) {
			$("#actionForm").attr("action", "normalDetail");
			$("#actionForm").submit();
		} else {
			alert("수정 중 문제가 발생하였습니다.");
			$("#actionForm").attr("action", "normalUpdate");
			$("#actionForm").submit();
		}
	}
});
</script>
</head>
<body>
<form action="#" id="actionForm" method="post">
<input type="hidden" name="page" value="${param.page}" />
<input type="hidden" name="searchGbn" value="${param.searchGbn}" />
<input type="hidden" name="searchText" value="${param.searchText}" />
<input type="hidden" name="boardNo" value="${param.boardNo}" />
</form>
</body>
</html>
















