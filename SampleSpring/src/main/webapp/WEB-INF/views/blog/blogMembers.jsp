<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>http://localhost:8090/SampleSpring/blogMembers</title>
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
		reloadList();
		
		$(".paging_wrap").on("click", "span", function() {
			$("#page").val($(this).attr("name"));
	
			reloadList();
		});
		
		$("tbody").on("click", "tr", function(){
			$("#mno").val($(this).attr("name"));
			$("#actionForm").attr("action", "blogMDetail");
			$("#actionForm").submit();
		});
	
		
	});
	
	function reloadList() {
		var params = $("#actionForm").serialize();
		
		$.ajax({
			type : "post",
			url : "blogMembersAjax",
			dataType : "json", // {키:값, 키:값}
			data : params, // 보낼데이터
			success : function(res) { // 성공 시 해당 함수 실행. 결과는 result로 받겠다.
				drawList(res.list, res.cnt);
				drawPaging(res.pb);
			},
			error : function(req, status, error) {
				console.log("code : " + req.status);
				console.log("message : " + req.responseText);
				
			}
		});
	}
	
	function drawList(list, cnt) {
		var html = "";
		
		if(cnt == 0) {
			html += "<tr>" ;
			html += "<td colspan=\"3\">데이터가 없습니다.</td>";
			html += "</tr>" ;
		} else {
			for(var i = 0; i < list.length; i++){
				html += "<tr name=\"" + list[i].MNO + "\">";			
				html += "<td>" + list[i].MNO + "</td>";			
				html += "<td>" + list[i].MID + "</td>";			
				html += "<td>" + list[i].MNM + "</td>";			
				html += "</tr>";
			}
		}
		$(".blog_table tbody").html(html);
	}
			
	function drawPaging(pb) {
		var html = "";
		
		if($("#page").val() == 1) {
			html += "<span name=\"1\">이전</span> ";
		} else {
			html += "<span name=\"" + ($("#page").val() - 1) + "\">이전</span> ";
		}
		
		for(var i = pb.startPcount; i <= pb.endPcount; i++) {
			if($("#page").val() == i) {
				html += "<span name=\"" + i + "\"><b>" + i + "</b></span> ";
			} else {
				html += "<span name=\"" + i + "\">" + i + "</span> ";
			}
		}
		
		if($("#page").val() == pb.maxPcount) {
			html += "<span name=\"" + pb.maxPcount + "\">다음</span>" ;
		} else {
			html += "<span name=\"" + ($("#page").val() * 1 + 1) + "\">다음</span>" ;
		}
		$(".paging_wrap").html(html);
	}
	
</script>
</head>
<body>
	<c:import url="/loginTop"></c:import>
	<form action="#" method="post" id="actionForm">
		
		<input type="hidden" name="mno" id="mno" />
		
		<input type="hidden" name="page" id="page" value="${page}" />
		
	</form>
<table class="blog_table">
	<thead>
		<tr>
			<th>회원번호</th>
			<th>회원아이디</th>
			<th>회원이름</th>
		</tr>
	</thead>
	<tbody>
	</tbody>
</table>

	<div class="paging_wrap">
	</div>
</body>
</html>