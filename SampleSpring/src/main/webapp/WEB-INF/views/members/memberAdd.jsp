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
function emptyCheck(sel) {
	if($.trim($(sel).val()) == '') {
		return true;
	} else {
		return false;
	}
}

$(document).ready(function() {
	$("#addBtn").on("click", function() {
		if(emptyCheck("#mid")) {
			alert("아이디를 입력해 주세요.");
			$("#mid").focus();
		} else if(emptyCheck("#mpw")) {
			alert("비밀번호를 입력해 주세요.");
			$("#mpw").focus();
		} else if($("#mpw").val() != $("#mpwRe").val()) {
			alert("비밀번호와 비밀번호 체크가 일치하지 않습니다.");

			$("#mpw").val("");
			$("#mpwRe").val("");
			$("#mpw").focus();
		} else if(emptyCheck("#mnm")) {
			alert("이름을 입력해 주세요.");
			$("#mnm").focus();
		} else if(emptyCheck("#mbirth")) {
			alert("생년월일을 입력해 주세요.");
			$("#mbirth").focus();
		} else {
			$("#addForm").submit();
		}
	});
	
	$("#addForm").on("keypress", "input", function(e) {
		if(e.keyCode == 13) {
			return false;
		}
	});
	
	$("#cancelBtn").on("click", function() {
		history.back();
	});
});
</script>
</head>
<body>
<form action="memberAdds" method="post" id="addForm">
<table>
	<tbody>
		<tr>
			<td>아이디</td>
			<td><input type="text" name="mid" id="mid" /></td>
		</tr>
		<tr>
			<td>비밀번호</td>
			<td><input type="password" name="mpw" id="mpw" /></td>
		</tr>
		<tr>
			<td>비밀번호확인</td>
			<td><input type="password" id="mpwRe" /></td>
		</tr>
		<tr>
			<td>이름</td>
			<td><input type="text" name="mnm" id="mnm" /></td>
		</tr>
		<tr>
			<td>생년월일</td>
			<td><input type="date" name="mbirth" id="mbirth" /></td>
		</tr>
		<tr>
			<td>취미</td>
			<td><input type="text" name="mhobby" id="mhobby" /></td>
		</tr>
	</tbody>
	<tfoot>
		<tr>
			<td colspan="2">
				<input type="button" value="등록" id="addBtn" />
				<input type="button" value="취소" id="cancelBtn" />
			</td>
		</tr>
	</tfoot>
</table>
</form>
</body>
</html>




