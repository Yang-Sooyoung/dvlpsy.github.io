<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>http://localhost:8090/spring/test3</title>
</head>
<body>
controller : ${msg2}<br/>
test2 : ${param.msg}<br/><!-- param.키 : 전 페이지에서 넘어오는 데이터를 취득할 때 사용  -->
${log}
</body>
</html>