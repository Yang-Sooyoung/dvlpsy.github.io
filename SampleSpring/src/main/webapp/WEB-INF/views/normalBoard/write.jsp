<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="shortcut icon" href="resources/favicon/favicon.ico">
<title>Normal Board Test</title>
<style type="text/css">
textarea {
	resize: none;
}
</style>
<!-- jQuery Script -->
<script type="text/javascript" 
		src="resources/script/jquery/jquery-1.12.4.min.js"></script>
<script type="text/javascript"
		src="resources/script/ckeditor/ckeditor.js"></script>
<script type="text/javascript">
$(document).ready(function(){
	CKEDITOR.replace("contents", {
		resize_enabled : false,
		language : "ko",
		enterMode : "2"
	});
	
	$("#saveBtn").on("click", function(){
		$("#contents").val(CKEDITOR.instances['contents'].getData());
		if($.trim($("#title").val()) == "") {
			alert("제목을 입력하세요.");
			$("#title").focus();
		} else if($.trim($("#pass").val()) == "") {
			alert("비밀번호를 입력하세요.");
			$("#pass").focus();
		} else if($.trim($("#contents").val()) == "") {
			alert("내용을 입력하세요.");
			$("#contents").focus();
		} else {
			$("#saveForm").submit();
		}
	});
	
	$("#cancelBtn").on("click", function(){
		$("#actionForm").submit();
	});
});

</script>
</head>
<body>
<form action="normalList" id="actionForm" method="post">
	<input type="hidden" name="page" value="${param.page}" />
	<input type="hidden" name="searchGbn" value="${param.searchGbn}" />
	<input type="hidden" name="searchText" value="${param.searchText}" />
</form>
<form action="normalWriteS" id="saveForm" method="post">
<input type="hidden" name="page" value="${param.page}" />
<input type="hidden" name="searchGbn" value="${param.searchGbn}" />
<input type="hidden" name="searchText" value="${param.searchText}" />
<table border="1" cellspacing="0">
	<tbody>
		<tr>
			<th>제목</th>
			<td><input type="text" name="title" id="title" 
					   value="${param.title}" /></td>
		</tr>
		<tr>
			<th>작성자</th>
			<td><input type="text" name="writer" id="writer" 
					   		 value="${param.writer}"/></td>
		</tr>
		<tr>
			<th>비밀번호</th>
			<td><input type="password" name="pass" id="pass"/></td>
		</tr>
		<tr>
			<th>내용</th>
			<td><textarea name="contents" id="contents"
						  rows="10" cols="20">${param.contents}</textarea></td>
		</tr>
	</tbody>
</table>
</form>
<br/>
<input type="button" id="saveBtn" value="저장"/>
<input type="button" id="cancelBtn" value="취소"/>
</body>
</html>
















