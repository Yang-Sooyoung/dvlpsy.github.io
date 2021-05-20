<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="resources/css/jquery/jquery-ui.css" />
<script type="text/javascript"
		src="resources/script/jquery/jquery-1.12.4.min.js"></script>
<script type="text/javascript"
		src="resources/script/jquery/jquery-ui.js"></script>
<script type="text/javascript">
$(document).ready(function() {
	
	$("#listBtn").on("click", function() {
		history.back();
	});
	
	$("#addBtn").on("click", function() {
		
		if($.trim($("#bookname").val()) == "") {
			alert("책제목을 입력해 주세요.");
			$("#bookname").focus();
		} else if($.trim($("#bookwriter").val()) == "") {
			alert("저자를 입력해 주세요.");
			$("#bookwriter").focus();
		} else if($.trim($("#bookpb").val()) == "") {
			alert("출판사를 입력해 주세요.");
			$("#bookpb").focus();
		} else if($.trim($("#bookpbdt").val()) == "") {
			alert("출판일을 입력해 주세요.");
			$("#bookpbdt").focus();
		} else {
			var params = $("#actionForm").serialize();
			
			$.ajax({
				type : "post",
				url : "aBookAddAjax",
				dataType : "json", // {키:값, 키:값}
				data : params, // 보낼데이터
				success : function(res) { // 성공 시 해당 함수 실행, 결과는 result로 받겠다.
					if(res.res == "SUCCESS") {
						location.href = "aBookList";
					} else {
						$("#alert").attr("title", "알림");
						$("#alert p").html("저장에 실패하였습니다.");
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
	
	$("#actionForm").on("keypress", "input", function(e) {
		if(e.keyCode == 13) {
			return false;
		}
	});
});
</script>
</head>
<body>
<div id="alert" style="display: none;"><p></p></div>
<form action="#" method="post" id="actionForm">
책제목 <input type="text" name="bookname" id="bookname" /><br/>
저자 <input type="text" name="bookwriter" id="bookwriter" /><br/>
출판사 <input type="text" name="bookpb" id="bookpb" /><br/>
출판일 <input type="date" name="bookpbdt" id="bookpbdt" /><br/>
</form>
<input type="button" value="추가" id="addBtn" />
<input type="button" value="목록" id="listBtn" />
</body>
</html>
