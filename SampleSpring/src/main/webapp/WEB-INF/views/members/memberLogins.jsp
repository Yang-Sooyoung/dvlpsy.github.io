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
if('${res}' == '0') {
	alert("아이디가 없습니다.");
} else if('${res}' == '1') {
	alert("비밀번호가 틀렸습니다.");
}

history.back();
</script>
</head>
<body>

</body>
</html>