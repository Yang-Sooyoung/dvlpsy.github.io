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
		
		if($.trim($("#accTitle").val()) == "") {
			alert("입출금내역을 입력해 주세요.");
			$("#accTitle").focus();
		} else if($.trim($("#accPrice").val()) == "") {
			alert("입출금금액을 입력해 주세요.");
			$("#accPrice").focus();
		} else if($.trim($("#accDate").val()) == "") {
			alert("입출금일을 입력해 주세요.");
			$("#accDate").focus();
		} else {
			var params = $("#actionForm").serialize();
			
			$.ajax({
				type : "post",
				url : "aAccAddAjax",
				dataType : "json", // {키:값, 키:값}
				data : params, // 보낼데이터
				success : function(res) { // 성공 시 해당 함수 실행, 결과는 result로 받겠다.
					if(res.res == "SUCCESS") {
						location.href = "aAccList";
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
입출금구분 <input type="radio" name="accType" value="0" checked="checked" />입금<input type="radio" name="accType" value="1" />출금<br/>
입출금내역 <input type="text" name="accTitle" id="accTitle" /><br/>
입출금금액 <input type="number" name="accPrice" id="accPrice" /><br/>
입출금일 <input type="date" name="accDate" id="accDate" /><br/>
</form>
<input type="button" value="추가" id="addBtn" />
<input type="button" value="목록" id="listBtn" />
</body>
</html>
