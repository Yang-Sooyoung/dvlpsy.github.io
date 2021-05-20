<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table border="1">
		<tr>
			<th>ID</th>
			<th>PW</th>
			<th>Name</th>
		</tr>
		<c:forEach items="${test}" var="test">
		<tr>
			<td>${test.id }</td>
			<td>${test.password }</td>
			<td>${test.name }</td>
		</tr>
		</c:forEach>
	</table>
</body>
</html>