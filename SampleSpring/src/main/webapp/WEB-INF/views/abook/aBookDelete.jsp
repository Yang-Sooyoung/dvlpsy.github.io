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
	if("${res}" == "SUCCESS") {
		location.href = "aBookList";
	} else if("${res}" == "FAILED") {
		alert("삭제에 실패하였습니다.");
		history.back();
	} else {
		var params = $("#actionForm").serialize();
		
		$.ajax({
			type : "post",
			url : "aBookDeleteAjax",
			dataType : "json", // {키:값, 키:값}
			data : params, // 보낼데이터
			success : function(res) { // 성공 시 해당 함수 실행, 결과는 result로 받겠다.
				if(res.res == "SUCCESS") {
					location.href = "aBookList";
				} else {
					$("#alert").attr("title", "알림");
					$("#alert p").html("삭제에 실패하였습니다.");
					$("#alert").dialog({
						buttons: {
							Ok: function() {
								$(this).dialog("close");
							}
						}
					});
				}
			},
			error : function(req, status, error) { // 결과, 상태값, 에러
				console.log("code : " + req.status);
				console.log("message : " + req.responseText);
			}
		});
	}
});
</script>
</head>
<body>
<div id="alert" style="display: none;"><p></p></div>
</body>
</html>