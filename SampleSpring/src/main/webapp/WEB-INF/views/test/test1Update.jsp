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
$(document).ready(function () {
	$("#cancelBtn").on("click", function() {
		history.back();
	});

	$("#updateBtn").on("click", function() {
		if($.trim($("#memname").val()) == "") {
			alert("이름을 입력해 주세요.");
			$("#memname").focus();
		} else if($.trim($("#membirth").val()) == "") {
			alert("생년월일을 입력해 주세요.");
			$("#membirth").focus();
		} else if($.trim($("#memphone").val()) == "") {
			alert("휴대폰을 입력해 주세요.");
			$("#memphone").focus();
		} else {
			$("#actionForm").submit();
		}
	});
	
	$("#actionForm").on("keypress", "input", function(e){
		if(e.keyCode == 13) {
			return false;
		}
	}); 
});
</script>
</head>
<body>
<form action="test1Updates" method="post" id="actionForm">
<input type="hidden" name="memno" value="${data.MEMNO}" />
<input type="hidden" name="searchGbn" value="${param.searchGbn}" />
<input type="hidden" name="searchTxt" value="${param.searchTxt}" />
<input type="hidden" name="page" value="${param.page}" />
이름 <input type="text" name="memname" id="memname" value="${data.MEMNAME}" /> <br/>
생년월일 <input type="date" name="membirth" id="membirth" value="${data.MEMBIRTH}" /> <br/>
휴대폰 <input type="text" name="memphone" id="memphone" maxlength="13" value="${data.MEMPHONE}" /> <br/>
</form>
<input type="button" value="수정" id="updateBtn" />
<input type="button" value="취소" id="cancelBtn" />
</body>
</html>