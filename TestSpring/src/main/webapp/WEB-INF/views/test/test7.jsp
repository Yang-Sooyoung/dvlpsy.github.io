<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>http://localhost:8090/spring/test7</title>
<script type="text/javascript"
		src="resources/jquery/jquery-1.12.4.js"></script>
<script type="text/javascript">
$(document).ready(function() {
});
</script>
</head>
<body>
<c:forEach var="arr" items="${lotto}">
	<c:forEach var="i" items="${arr}">
		${i}
	</c:forEach>
	<br/>
</c:forEach>
</body>
</html>




