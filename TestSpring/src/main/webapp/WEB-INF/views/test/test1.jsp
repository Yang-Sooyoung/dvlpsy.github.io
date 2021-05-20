<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>http://localhost:8090/spring/test1</title>
</head>
<body>
Hi~<br/>
msg : ${msg}<br/>
no : ${map.no} , title : ${map.title}<br/>
${list1[0]}
<select>
	<c:forEach var="data" items="${list1}" varStatus="s">
		<option value="${s.index}">${data}</option>
	</c:forEach>
</select><br/>
<table>
	<thead>
		<tr>
			<th>번호</th>
			<th>제목</th>
			<th>작성자</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach var="data" items="${list2}">
			<tr>
				<td>${data.no}</td>
				<td>${data.title}</td>
				<td>${data.writer}</td>
			</tr>
		</c:forEach>
	</tbody>
</table>
</body>
</html>