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
			$("#actionForm").submit();
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
<form action="accAdds" method="post" id="actionForm">
입출금구분 <input type="radio" name="accType" value="0" checked="checked" />입금<input type="radio" name="accType" value="1" />출금<br/>
입출금내역 <input type="text" name="accTitle" id="accTitle" /><br/>
입출금금액 <input type="number" name="accPrice" id="accPrice" /><br/>
입출금일 <input type="date" name="accDate" id="accDate" /><br/>
</form>
<input type="button" value="추가" id="addBtn" />
<input type="button" value="목록" id="listBtn" />
</body>
</html>









