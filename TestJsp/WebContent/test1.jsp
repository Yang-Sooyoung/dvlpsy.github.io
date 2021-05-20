<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<c:forEach var="i" begin="1" end="10" step="1" varStatus="s">
<%-- <c:if test="${i % 2 == 1}">
	${i},${s.index}<br/>
</c:if> --%>
<c:choose><%-- if 시작하겠다  --%> <%-- eq는 같다, ne는 같지않다  --%>
	<c:when test="${i % 2 ne 1}"> <%-- 조건 --%>
		${i},${s.index}<br/>
	</c:when>
	<c:otherwise> <%-- else --%>
		<b>${i},${s.index}</b><br/>
	</c:otherwise>
</c:choose>
</c:forEach>

<!--  구구단 2 ~ 9단 출력 core tag와 el tag 활용 -->
<c:forEach var="i" begin="2" end="9" step="1">
	<c:forEach var="j" begin="1" end="9" step="1">
		${i}*${j}=${i * j}<br/>
	</c:forEach> 
</c:forEach> 

</body>
</html>