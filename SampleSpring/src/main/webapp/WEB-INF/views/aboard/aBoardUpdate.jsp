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
<script type="text/javascript"
		src="resources/script/ckeditor/ckeditor.js"></script>
<script type="text/javascript" 
		src="resources/script/jquery/jquery.form.js"></script>
<script type="text/javascript">
$(document).ready(function() {
	if('${board.BOARD_FILE}' != '') {
		$("#fileForm").hide();
	}
	
	
	CKEDITOR.replace("boardCon", { // bcon이라는 객체를 CKEDITOR로 변환하겠다.
		resize_enabled : false, // 크기변환 가능 : 불가능
		language : "ko", // 언어 : 한국어
		enterMode : "2", // 엔터를 줄바꿈으로 사용하겠다
		width : "600",
		height : "400"
	});
	
	$("#cancelBtn").on("click", function() {
		history.back();
	});
	
	$("#fileDelBtn").on("click", function() {
		$("#boardFile").val("");
		$("#fileDiv").remove();
		$("#fileForm").show();
	});
	
	$("#updateBtn").on("click", function() {
		// CKEDITOR객체 중 bcon의 내용을 가져오겠다.
		$("#boardCon").val(CKEDITOR.instances['boardCon'].getData());
		
		if($.trim($("#boardTitle").val()) == "") {
			alert("제목을 입력해 주세요.");
			$("#boardTitle").focus();
		} else if($.trim($("#boardCon").val()) == "") {
			alert("내용을 입력해 주세요.");
			$("#boardCon").focus();
		} else {
			if($("#fileForm").is(":visible") && $("#attFile").val() != '') {
				// 선 파일업로드 후 글저장	
				var fileForm = $("#fileForm");
			
				fileForm.ajaxForm({
					success: function(res){
							if(res.result =="SUCCESS"){
								if(res.fileName.length > 0) { // 올린 파일이 1개라도 있는 경우
								$("#boardFile").val(res.fileName[0]); // 올린 파일명 추가
							}
							updateAjax();	
						} else {
							alert("파일저장실패");
						}
					}, 
					error: function(req){
						console.log(req.responseText);
						alert("파일저장 에러"); 
					}
				});
			
				fileForm.submit(); // fileForm 실행
			} else {
				updateAjax();
			}
		}
	});
	
	$("#actionForm").on("keypress", "input", function(e) {
		if(e.keyCode == 13) {
			return false;
		}
	});
});

function updateAjax() {
	var params = $("#actionForm").serialize();
	
	$.ajax({
		type : "post",
		url : "aBoardUpdateAjax",
		dataType : "json", // {키:값, 키:값}
		data : params, // 보낼데이터
		success : function(res) { // 성공 시 해당 함수 실행, 결과는 result로 받겠다.
			if(res.res == "SUCCESS") {
				$("#actionForm").attr("action", "aBoardDetail");
				$("#actionForm").submit();
			} else {
				$("#alert").attr("title", "알림");
				$("#alert p").html("수정에 실패하였습니다.");
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

</script>
</head>
<body>
<div id="alert" style="display: none;"><p></p></div>
<form action="#" method="post" id="actionForm">
<input type="hidden" name="boardNo" value="${param.boardNo}" />
<input type="hidden" name="page" value="${param.page}" />
<input type="hidden" name="searchGbn" value="${param.searchGbn}" />
<input type="hidden" name="searchTxt" value="${param.searchTxt}" />
<input type="hidden" name="boardFile" id="boardFile" value="${board.BOARD_FILE}" />
글번호 : ${board.BOARD_NO}<br/>
제목 <input type="text" name="boardTitle" id="boardTitle" value="${board.BOARD_TITLE}" /><br/>
작성자 : ${board.MNM}<br/>
내용
<div>
	<textarea rows="20" cols="40" name="boardCon" id="boardCon">${board.BOARD_CON}</textarea>
</div>
<c:if test="${!empty board.BOARD_FILE}">
<div id=fileDiv>
첨부파일 : ${board.BOARD_FILE} <input type="button" value="첨부파일 삭제" id="fileDelBtn" />
</div>
</c:if>
</form>
<form id="fileForm" name="fileForm" action="fileUploadAjax" method="post" enctype="multipart/form-data">
첨부파일 <input type="file" name="attFile" id="attFile" />
</form>
<input type="button" value="수정" id="updateBtn" />
<input type="button" value="취소" id="cancelBtn" />
</body>
</html>