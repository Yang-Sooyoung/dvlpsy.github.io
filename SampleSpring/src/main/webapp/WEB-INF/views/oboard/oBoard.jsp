<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>한줄게시판</title> <!--http://localhost:8090/SampleSpring/oBoard-->
<style type="text/css">
body {
	margin: 0px;
	font-size: 0pt;
}

.login_wrap {
	text-align: right;
	padding: 10px;
	font-size: 11pt;
}

.ob_wrap {
	width: 800px;
	margin: 0px auto;
	border: 1px solid #444444;
}

.write_area {
	height: 100px;
}

.user_info {
	display: inline-table;
	width: 100px;
	height: 100px;
	vertical-align: top;
}

.user_name {
	display: table-cell;
	width: 100px;
	height: 100px;
	vertical-align: middle;
	text-align: center;
	font-size: 12pt;
}

.write_con_wrap {
	display: inline-block;
	width: 550px;
	height: 100px;
	vertical-align: top;
}

.write_con {
	width: 540px;
	height: 90px;
	resize: none;
	margin: 2px;
}

.btn_wrap {
	display: inline-block;
	width: 150px;
	height: 100px;
	vertical-align: top;
}

.action_btn {
	width: 146px;
	height: 96px;
	margin: 2px;
}

.action2_btn {
	width: 71px;
	height: 96px;
	margin: 2px;
}

.login_req_wrap {
	display: inline-table;
	width: 800px;
	height: 100px;
}

.login_req {
	display: table-cell;
	width: 800px;
	height: 100px;
	vertical-align: middle;
	text-align: center;
	font-size: 12pt;
}

.data_req_wrap {
	display: inline-table;
	width: 800px;
	height: 100px;
	border-top : 1px solid #444444;
	margin-bottom: 5px;
}

.data_req {
	display: table-cell;
	width: 800px;
	height: 100px;
	vertical-align: middle;
	text-align: center;
	font-size: 12pt;
}

.ob_data {
	border-top : 1px solid #444444;
	margin-bottom: 5px;
}

.con_info {
	display: inline-table;
	width: 550px;
	height: 100px;
	vertical-align: top;
}

.con {
	display: table-cell;
	width: 100px;
	height: 100px;
	vertical-align: middle;
	text-align: left;
	font-size: 12pt;
}

.paging_wrap {
	margin: 5px 0px;
	padding: 5px 0px;
	border-top: 1px solid #444444;
	text-align: center;
}

.paging_wrap span {
	margin: 0px 5px;
	font-size: 12pt;
	cursor: pointer;
}

.write_area .action2_btn {
	display: none;
}
</style>
<script type="text/javascript"
		src="resources/script/jquery/jquery-1.12.4.min.js"></script>
<script type="text/javascript">
$(document).ready(function() {
	reloadList();
	
	$("body").on("click", "#loginBtn", function() {
		location.href = "memberLogin";
	});
	
	$("#logoutBtn").on("click", function() {
		location.href = "memberLogout";
	});
	
	$(".paging_wrap").on("click", "span", function() {
		$("#page").val($(this).attr("name"));
		reloadList();
	});
	
	$("#saveBtn").on("click", function() {
		if($.trim($("#obCon").val()) == "") {
			alert("내용을 입력하여 주세요.");
			$("#obCon").focus();
		} else {
			var params = $("#actionForm").serialize();
			
			$.ajax({
				type : "post",
				url : "oBoardAddAjax",
				dataType : "json",
				data : params,
				success : function(res) {
					if(res.res == "SUCCESS") {
						$("#obCon").val("");
						reloadList();
					} else {
						alert("작성중 문제가 발생하였습니다.");
					}
				},
				error : function(req, status, error) {
					console.log("code : " + req.status);
					console.log("message : " + req.responseText);
				}
			});
		}
	}); // saveBtn end
	
	$(".ob_list_wrap").on("click", "#updateBtn", function() {
		$("#obNo").val($(this).parent().parent().attr("name"));
		$("#obCon").val($(this).parent().parent().children(".con_info").children(".con").html());
		
		$(".write_area .action2_btn").show();
		$(".write_area .action_btn").hide();
	});
	
	$(".write_area #cancelBtn").on("click", function() {
		$(".write_area .action2_btn").hide();
		$(".write_area .action_btn").show();
		$("#obNo").val("");
		$("#obCon").val("");
	});
	
	$(".write_area #updateBtn").on("click", function() {
		if($.trim($("#obCon").val()) == "") {
			alert("내용을 입력하여 주세요.");
			$("#obCon").focus();
		} else {
			var params = $("#actionForm").serialize();
			
			$.ajax({
				type : "post",
				url : "oBoardUpdateAjax",
				dataType : "json",
				data : params,
				success : function(res) {
					if(res.res == "SUCCESS") {
						$(".write_area .action2_btn").hide();
						$(".write_area .action_btn").show();
						$("#obNo").val("");
						$("#obCon").val("");
						reloadList();
					} else if(res.res == "FAILED") {
						alert("잘못된 데이터를 입력하셨습니다.");
					} else {
						alert("수정중 문제가 발생하였습니다.");
					}
				},
				error : function(req, status, error) {
					console.log("code : " + req.status);
					console.log("message : " + req.responseText);
				}
			});
		}
	});
	
	$(".ob_list_wrap").on("click", "#deleteBtn", function() {
		if(confirm("삭제하실겁니까?")) {
			$("#obNo").val($(this).parent().parent().attr("name"));
			var params = $("#actionForm").serialize();
			
			$.ajax({
				type : "post",
				url : "oBoardDeleteAjax",
				dataType : "json",
				data : params,
				success : function(res) {
					if(res.res == "SUCCESS") {
						$("#obNo").val("");
						reloadList();
					} else if(res.res == "FAILED") {
						alert("잘못된 데이터를 입력하셨습니다.");
					} else {
						alert("삭제중 문제가 발생하였습니다.");
					}
				},
				error : function(req, status, error) {
					console.log("code : " + req.status);
					console.log("message : " + req.responseText);
				}
			});
		}
	});
});

function reloadList() {
	var params = $("#actionForm").serialize();
	
	$.ajax({
		type : "post",
		url : "oBoardListAjax",
		dataType : "json",
		data : params,
		success : function(res) {
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
		html += "<div class=\"data_req_wrap\">";
		html += "<div class=\"data_req\">데이터가 없습니다.</div>";
		html += "</div>";
	} else {
		for(var i = 0 ; i < list.length ; i++) {
			html += "<div class=\"ob_data\" name=\"" + list[i].OB_NO + "\">";
			html += "<div class=\"user_info\">";
			html += "<div class=\"user_name\">" + list[i].MNM + "</div>";
			html += "</div>";
			html += "<div class=\"con_info\">";
			html += "<div class=\"con\">" + list[i].OB_CON + "</div>";
			html += "</div>";
			html += "<div class=\"btn_wrap\">";
			if("${sMno}" == list[i].MNO) {
				html += "<input type=\"button\" value=\"수정\" class=\"action2_btn\" id=\"updateBtn\" />";
				html += "<input type=\"button\" value=\"삭제\" class=\"action2_btn\" id=\"deleteBtn\" />";
			}
			html += "</div>";
			html += "</div>";
		}
	}
	
	$(".ob_list_wrap").html(html);
}

function drawPaging(pb) {
var html = "";
	
	if($("#page").val() == 1) {
		html += "<span name=\"1\">이전</span> ";
	} else {
		html += "<span name=\"" + ($("#page").val() - 1) + "\">이전</span> ";
	}
	
	for(var i = pb.startPcount ; i <= pb.endPcount ; i++) {
		if($("#page").val() == i) {
			html += "<span name=\"" + i + "\"><b>" + i + "</b></span> ";
		} else {
			html += "<span name=\"" + i + "\">" + i + "</span> ";
		}
	}
	
	if($("#page").val() == pb.maxPcount) {
		html += "<span name=\"" + pb.maxPcount + "\">다음</span>";
	} else {
		html += "<span name=\"" + ($("#page").val() * 1 + 1) + "\">다음</span>";
	}
	
	$(".paging_wrap").html(html);
}
</script>
</head>
<body>
<c:import url="/loginTop"> <%--loginTop에게 test란 이름으로 Hi를 보내겠다  --%>
	<c:param name="test" value="Hi"></c:param>
</c:import>
<div class="ob_wrap">
	<!-- Write -->
	<div class="write_area">
	<form action="#" method="post" id="actionForm">
		<input type="hidden" name="page" id="page" value="1" />
		<input type="hidden" name="obNo" id="obNo" />
		<c:choose>
			<c:when test="${!empty sMno}">
				<div class="user_info">
					<div class="user_name">${sMnm}</div>
				</div>
				<div class="write_con_wrap">
					<textarea class="write_con" name="obCon" id="obCon"></textarea>
				</div>
				<div class="btn_wrap">
					<input type="button" value="저장" class="action_btn" id="saveBtn" />
					<input type="button" value="수정" class="action2_btn" id="updateBtn" />
					<input type="button" value="취소" class="action2_btn" id="cancelBtn" />
				</div>
			</c:when>
			<c:otherwise>
				<div class="login_req_wrap">
					<div class="login_req">작성 시 로그인이 필요합니다. <input type="button" value="로그인" id="loginBtn" /></div>
				</div>
			</c:otherwise>
		</c:choose>
	</form>
	</div>
	<!-- List -->
	<div class="ob_list_wrap">
	</div>
	<!-- Paging -->
	<div class="paging_wrap">
	</div>
</div>
</body>
</html>