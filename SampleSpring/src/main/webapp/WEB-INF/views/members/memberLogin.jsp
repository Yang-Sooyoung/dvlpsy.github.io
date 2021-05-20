<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>http://localhost:8090/SampleSpring/memberLogin</title>
<script type="text/javascript"
	    src="resources/script/jquery/jquery-1.12.4.min.js"></script>
<script type="text/javascript">
function emptyCheck(sel) {
	if($.trim($(sel).val()) == '') {
		return true;
	} else {
		return false;
	}
}

$(document).ready(function() {
	$("#loginBtn").on("click", function() {
		if(emptyCheck("#mid")) {
			alert("아이디를 입력해주세요.");
			$("#mid").focus();
		} else if(emptyCheck("#mpw")) {
			alert("비밀번호를 입력해 주세요.");
			$("#mpw").focus();
		} else {
			var params = $("#loginForm").serialize();
			console.log(params);
			
			$.ajax({
				type : "post",
				url : "memberLoginAjax",
				dataType : "json", // {키:값, 키:값}
				data : params, // 보낼데이터
				success : function(res) { // 성공 시 해당 함수 실행, 결과는 result로 받겠다.
					if(res.res == "0") {
						alert("아이디가 없습니다.");
					} else if(res.res == "1") {
						alert("비밀번호가 틀립니다.");
					} else {
						location.href = "blogMembers";
					}
				},
				error : function(req, status, error) { // 결과, 상태값, 에러
					console.log("code : " + req.status);
					console.log("message : " + req.responseText);
					console.log("error : " + error);
				}
			});
		}
	});
	
	$("#loginForm").on("keypress", "input", function(e) {
		if(e.keyCode == 13) {
			return false;
		}
	});
});
</script>
</head>
<body>
로그인
<form action="#" method="post" id="loginForm">
아이디<input type="text" name="mid" id="mid" /><br/>
비밀번호<input type="password" name="mpw" id="mpw" />
</form>
<input type="button" value="로그인" id="loginBtn" />
</body>
</html>