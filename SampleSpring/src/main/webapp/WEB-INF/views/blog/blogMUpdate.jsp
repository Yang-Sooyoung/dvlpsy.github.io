<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
table {
	border-collapse: collapse;
}

tbody tr {
	border: 1px solid #444444;
	cursor: pointer;
}

tbody tr:hover {
	background-color: lavender;
}
</style>

<script type="text/javascript"
		src="resources/script/jquery/jquery-1.12.4.min.js"></script>
<script type="text/javascript">

$(document).ready(function() {
	
	$("#updateBtn").on("click", function() {
		var params = $("#actionForm").serialize();
		
		$.ajax({
			type : "post",
			url : "blogMUpdateAjax",
			dataType : "json", // {키:값, 키:값}
			data : params, // 보낼데이터
			success : function(res) { // 성공 시 해당 함수 실행. 결과는 result로 받겠다.
				
				if ( res.resultCnt == 1 ) { // 한개의 글 수정 완료
					alert('1건의 수정이 정상적으로 완료되었습니다.');
					
					history.back();
					
				} else {
					alert('데이터 오류.');
				}
				
			},
			error : function(req, status, error) {
				console.log("code : " + req.status);
				console.log("message : " + req.responseText);
				
			}
		});
	});
	
	$("#listBtn").on("click", function() {
		
		if ( confirm('수정내용이 저장되지 않습니다.\n목록으로 돌아가시겠습니까?') ) {
			history.back();
		}
		
	});
	
});
	
</script>
</head>
<body>
	<form action="#" method="post" id="actionForm">
		
		<input type="hidden" name="mno" id="mno" value="${param.mno}" />
		
		<input type="hidden" name="page" id="page" value="${param.page}" />
		
		<input type="hidden" name="blog_no" id="blog_no" value="${data.BLOG_NO}" />
		
		<br/>
		글번호 : ${data.BLOG_NO}
		<br/>
		제목 : <input type="text" id="blog_title" name="blog_title" value="${data.BLOG_TITLE}" /><!-- data.BLOG_TITLE -->
		<br/>
		내용 : <input type="text" id="blog_con" name="blog_con" value="${data.BLOG_CON}" /><!-- data.BLOG_CON -->
		<br/>
		조회수 : ${data.BLOG_HIT}
		<br/>
		작성일 : ${data.BLOG_DT}
		<br/><br/>
		<input type="button" id="listBtn" name="listBtn" value="취소" />&nbsp;
		<input type="button" id="updateBtn" name="updateBtn" value="확인" /><br/>
		
	</form>
</body>
</html>