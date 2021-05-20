<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>http://localhost:8090/SampleSpring/aBoardList</title>
<style type="text/css">
.board_table {
	border-collapse: collapse;
}

.board_table thead tr {
	border: 1px solid #444444;
	background-color: #55ACAC;
}

.board_table tbody tr {
	border: 1px solid #444444;
	cursor: pointer;
}

.board_table tbody tr:hover {
	background-color: orange;
}
</style>
<script type="text/javascript"
		src="resources/script/jquery/jquery-1.12.4.min.js"></script>
<script type="text/javascript">
$(document).ready(function() {
	if('${param.searchGbn}' != '') {
		$("#searchGbn").val('${param.searchGbn}');
	}
	
	reloadList();
	
	$("#addBtn").on("click", function() {
		location.href = "aBlogAdd";
	});
	
	$("#searchBtn").on("click", function() {
		$("#page").val("1");
		reloadList();
	});
	
	$("#paging_area").on("click", "span", function() {
		$("#page").val($(this).attr("name"));
		reloadList();
	});
	
	$(".board_table").on("click", "tr", function() {
		$("#boardNo").val($(this).attr("name"));
		
		$("#actionForm").attr("action", "aBoardDetail");
		$("#actionForm").submit();
	});
	
});


function reloadList() {
	var params = $("#actionForm").serialize();
	
	$.ajax({
		type : "post",
		url : "aBoardListAjax",
		dataType : "json", // {키:값, 키:값}
		data : params, // 보낼데이터
		success : function(res) { // 성공 시 해당 함수 실행, 결과는 result로 받겠다.
			drawList(res.list, res.cnt);
			drawPaging(res.pb);
		},
		error : function(req, status, error) { // 결과, 상태값, 에러
			console.log("code : " + req.status);
			console.log("message : " + req.responseText);
		}
	});
}
/* 이후로 추가 된 내용 */
function drawList(list, cnt) {
	var html = "";
	
	if(cnt == 0) {
		html += "<tr>";
		html += "<td colspan=\"5\">데이터가 없습니다.</td>";
		html += "</tr>";
	} else {
		for(var i = 0 ; i < list.length ; i++) {
			html += "<tr name=\"" + list[i].BOARD_NO + "\">";
			html += "<td>" + list[i].BOARD_NO + "</td>";
			html += "<td>" + list[i].BOARD_TITLE + "</td>";
			html += "<td>" + list[i].MNM + "</td>";
			html += "<td>" + list[i].BOARD_DT + "</td>";
			html += "<td>" + list[i].BOARD_HIT + "</td>";
			html += "</tr>";
		}
	}
	
	$(".board_table tbody").html(html);
}

function drawPaging(pb) {
	var html = "";
	
	if($("#page").val() == 1) {
		html += "<span name=\"1\">이전</span>";
	} else {
		html += "<span name=\"" + ($("#page").val() - 1) + "\">이전</span>";
	}
	
	for(var i = pb.startPcount ; i <= pb.endPcount ; i++) {
		if($("#page").val() == i) {
			html += "<span name=\"" + i + "\"<b>" + i + "</b></span>";
		} else {
			html += "<span name=\"" + i + "\">" + i + "</span>";
		}
	}
	
	if($("#page").val() == pb.maxPcount) {
		html += "<span name=\"" + pb.maxPcount + "\">다음</span>";
	} else {
		html += "<span name=\"" + ($("#page"). val() * 1 + 1) + "\">다음</span>";
	}
	
	$("#paging_area").html(html);
}
</script>
</head>
<body>
<!-- session을 jsp에서 취득 시 el활용 -->
<c:import url="/loginTop"></c:import>
<form action="#" method="post" id="actionForm">
<input type="hidden" name="boardNo" id="boardNo" />
<input type="hidden" name="page" id="page" value="${page}" />
<select name="searchGbn" id="searchGbn">
	<option value="0">제목</option>
	<option value="1">작성자</option>
</select>
<input type="text" name="searchTxt" value="${param.searchTxt}" />
<input type="button" value="검색" id="searchBtn" />
<c:if test="${!empty sMno}">
	<input type="button" value="추가" id="addBtn" />
</c:if>
</form>
<table class="board_table">
	<thead>
		<tr>
			<th>글번호</th>
			<th>제목</th>
			<th>작성자</th>
			<th>작성일</th>
			<th>조회수</th>
		</tr>
	</thead>
	<tbody>
	</tbody>
</table>
<div id="paging_area">
</div>
</body>
</html>