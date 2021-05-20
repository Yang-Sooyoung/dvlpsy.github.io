<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="shortcut icon" href="resources/favicon/favicon.ico">
<title>Normal Board Test</title>
<!-- jQuery Script -->
<script type="text/javascript" 
		src="resources/script/jquery/jquery-1.12.4.min.js"></script>
<script type="text/javascript">
$(document).ready(function() {
	/* $("#backBtn").on("click", function(){
		history.back();
	}); */
	
	if('${result}' > 0) {
		location.href = "normalList";
	} else {
		alert("작성 중 문제가 발생하였습니다.");
		$("#backForm").submit();
	}
});
</script>
</head>
<body>
<form action="normalWrite" id="backForm" method="post">
<input type="hidden" name="page" value="${param.page}" />
<input type="hidden" name="searchGbn" value="${param.searchGbn}" />
<input type="hidden" name="searchText" value="${param.searchText}" />
<input type="hidden" name="title" value="${param.title}" />
<input type="hidden" name="writer" value="${param.writer}" />
<input type="hidden" name="pass" value="${param.pass}" />
<input type="hidden" name="contents" value="${param.contents}" />
</form>
<form action="normalList" id="actionForm" method="post">
	<input type="hidden" name="msg" value="success" />
</form>

<%--
작성중 문제가 발생하였습니다.
<br/>
<input type="button" value="뒤로가기" id="backBtn" /> --%>
</body>
</html>
















