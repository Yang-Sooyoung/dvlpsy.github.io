<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>AjaxBoard Test</title>
<!-- Popup CSS -->
<link rel="stylesheet" type="text/css" href="resources/css/common/popup.css" />
<!-- ajaxBoard CSS -->
<link rel="stylesheet" type="text/css" href="resources/css/ajaxBoard.css" />

<!-- jQuery -->
<script type="text/javascript" 
		src="resources/script/jquery/jquery-1.12.4.min.js"></script>
<!-- Popup Script -->
<script type="text/javascript" 
		src="resources/script/common/popup.js"></script>
<script type="text/javascript">
$(document).ready(function(){
	readContents();
	
	/* 
		Write Event
	*/
	$("#writeBtn").on("click", function(){
		var html = "";
		
		html += "<div class=\"bg_board_div\"></div>                                                        		";
		html += "<div class=\"popup_board_div\">                                                         		";
		html += "	<div class=\"close_div\">                                                            		";
		html += "		<div class=\"popup_board_title\">글쓰기</div>                                    		";
		html += "		<img class=\"close_img\" id=\"closeBoard\" alt=\"닫기\" src=\"resources/images/cross.png\">";
		html += "	</div>                                                                             			";
		html += "	<div class=\"board_contents_div\">                                                   		";
		html += "		<form id=\"boardForm\">                                                          		";
		html += "			<table>                                                                    			";
		html += "				<colgroup>                                                             			";
		html += "					<col width=\"80px\"/>                                                		";
		html += "					<col width=\"500px\"/>                                               		";
		html += "				</colgroup>                                                            			";
		html += "				<tr>                                                                   			";
		html += "					<td>제목</td>                                                      			";
		html += "					<td><input type=\"text\" size=\"78\" name=\"title\" id=\"title\" /></td>    ";
		html += "				</tr>                                                                  			";
		html += "				<tr>                                                                   			";
		html += "					<td>작성자</td>                                                    			";
		html += "					<td><input type=\"text\" size=\"78\" name=\"writer\" id=\"writer\" /></td>  ";
		html += "				</tr>                                                                  			";
		html += "				<tr>                                                                   			";
		html += "					<td>비밀번호</td>                                                  			";
		html += "					<td><input type=\"password\" size=\"78\" name=\"pass\" id=\"pass\" /></td>  ";
		html += "				</tr>                                                                  			";
		html += "				<tr>                                                                   			";
		html += "					<td colspan=\"2\">                                                   		";
		html += "						<textarea rows=\"23\" name=\"contents\" id=\"contents\"></textarea>";
		html += "					</td>                                                              			";
		html += "				</tr>                                                                  			";
		html += "			</table>                                                                  		    ";
		html += "		</form>                                                                      			";
		html += "		<div class=\"board_btn_div\"><input type=\"button\" value=\"등록\" id=\"saveBtn\"></div>";
		html += "	</div>                                                                             			";
		html += "</div>                                                                                			";
		
		$("body").prepend(html);
		
		$("#title").focus();
		
		$(".bg_board_div").hide();
		$(".popup_board_div").hide();
		$(".bg_board_div").fadeIn();
		$(".popup_board_div").fadeIn();
		
		$("#saveBtn").off("click");
		$("#saveBtn").on("click", function(){
			checkInput("I", function() {
				var params = $("#boardForm").serialize();
				console.log(params);
				$.ajax({
					type : "post",
					url : "ajaxBoardInsertResult",
					dataType : "json",
					data : params,
					success : function(result) {
						makePopup("알림", "등록에 성공했습니다.");
						closeBoardPopup();
						
						$("#page").val(1);
						
						$("#searchGbn").val(0);
						$("#searchText").val("");
						
						readContents();
					},
					error : function(result) {
						makePopup("알림", "등록에 실패했습니다.");
					}
				});
			});
		});
		
		$(".bg_board_div").off("click");
		$(".bg_board_div").on("click", function(){
			closeBoardPopup();
		});
		
		$("#closeBoard").off("click");
		$("#closeBoard").on("click", function(){
			closeBoardPopup();
		});
	});
	
	/* 
		Paging Event
	*/
	$(".paging_div").on("click", "a[name='pager']", function(){
		var tmp = $(this).attr("id").split("_");
		
		$("#page").val(tmp[1]);
		
		$("#searchGbn").val($("#lastSearchGbn").val());
		$("#searchText").val($("#lastSearchText").val());
		
		readContents();
	});
	
	/* 
		Search Event
	*/
	$("#searchBtn").on("click", function(){
		$("#page").val(1);
		$("#lastSearchGbn").val($("#searchGbn").val());
		$("#lastSearchText").val($("#searchText").val());
		
		readContents();
	});
	
	/* 
		Board Event
	*/
	$("#contentsArea").on("mouseover", ".list_contnets", function(){
		$(this).css("background-color", "#EEEEEE");
	}).on("mouseout", "tr", function(){
		$(this).css("background-color", "#FFFFFF");
	}).on("click", "tr", function(){
		$("input[name='boardNo']").val($(this).attr("id"));
		
		readDetail();
	});
});

/* 
	Board Popup Close
*/
function closeBoardPopup() {
	$(".bg_board_div").fadeOut(function(){
		$(".bg_board_div").remove();
	});
	
	$(".popup_board_div").fadeOut(function(){
		$(".popup_board_div").remove();
	});
}

/* 
	List Reload Event
*/
function readContents() {
	var params = $("#readForm").serialize();

	$.ajax({
		type : "post",
		url : "ajaxBoardReadList",
		dataType : "json",
		data : params,
		success : function(result) {
			
			if(result.message == "SUCCESS") {
				redrawList(result.list);
				redrawPaging(result.pb);
			} else {
				makePopup("알림", "데이터 취득에 실패했습니다.<br/>관리자에게 문의하세요.");
			}
		},
		error : function(result) {
			makePopup("알림", "데이터 취득에 실패했습니다.<br/>관리자에게 문의하세요.");
		}
	});
}

/* 
	List Redraw Event
*/
function redrawList(list) {
	var html = "";
	
	if(list.length == 0 && $("#page").val() == 1) {
		html += "<tr>";
		html += "<td colspan=\"5\">조회된 데이터가 없습니다.</td>";
		html += "</tr>";
	} else if(list.length == 0 && $("#page").val() != 1) {
		$("#page").val($("#page").val() - 1);
		
		readContents();
	} else {
		for(var i = 0 ; i < list.length ; i++) {
			html += "<tr class=\"list_contnets\" id=\"" + list[i].BOARD_NO + "\">";
			html += "<td>" + list[i].BOARD_NO + "</td>";
			html += "<td>" + list[i].TITLE + "</td>";
			html += "<td>" + list[i].WRITER + "</td>";
			html += "<td>" + list[i].WRITE_DATE + "</td>";
			html += "<td>" + list[i].HIT_CNT + "</td>";
			html += "</tr>";
		}
		
	}
	
	$("#contentsArea").html(html);
}

/* 
	Paging Redraw Event
*/
function redrawPaging(pb) {
	var html = "";
	if($("#page").val() == 1) {
		html += "<img src=\"resources/images/calendar/nav-left-x2.gif\" alt=\"첫페이지로\">";
	} else {
		html += "<a href=\"#\" id=\"pCount_1\" name=\"pager\" title=\"첫페이지로\"><img src=\"resources/images/calendar/nav-left-x2.gif\" alt=\"첫페이지로\"></a>";
	}
	
	if(1 >= $("#page").val()) {
		html += "<img src=\"resources/images/calendar/nav-left.gif\" alt=\"이전페이지로\">";
	} else {
		html += "<a href=\"#\" id=\"pCount_" + ($("#page").val() - 1) + "\" name=\"pager\" title=\"이전페이지로\"><img src=\"resources/images/calendar/nav-left.gif\" alt=\"이전페이지로\"></a>";
	}
	
	for(var i = pb.startPcount ; i <= pb.endPcount ; i++) {
		if(i == $("#page").val()) {
			html += "<b>" + i + "</b>&nbsp;";
		} else {
			html += "<a href=\"#\" id=\"pCount_" + i + "\" name=\"pager\" title=\"" + i + "\">" + i + "</a>&nbsp;";
		}
	}
	
	if(pb.maxPcount <= $("#page").val()) {
		html += "<img src=\"resources/images/calendar/nav-right.gif\" alt=\"다음페이지로\">";
	} else {
		html += "<a href=\"#\" id=\"pCount_" + ($("#page").val() + 1) + "\" name=\"pager\" title=\"다음페이지로\"><img src=\"resources/images/calendar/nav-right.gif\" alt=\"다음페이지로\"></a>";
	}
	
	if(pb.maxPcount == $("#page").val()) {
		html += "<img src=\"resources/images/calendar/nav-right-x2.gif\" alt=\"마지막페이지로\">";
	} else {
		html += "<a href=\"#\" id=\"pCount_" + pb.maxPcount + "\" name=\"pager\" title=\"마지막페이지로\"><img src=\"resources/images/calendar/nav-right-x2.gif\" alt=\"마지막페이지로\"></a>";
	}
	
	$(".paging_div").html(html);
}

/* 
	Detail Popup Event
*/
function readDetail() {
	var params = $("#boardNo").serialize();
	
	$.ajax({
		type : "post",
		url : "ajaxBoardReadDetail",
		dataType : "json",
		data : params,
		success : function(result) {
			var html = "";
			
			html += "<div class=\"bg_board_div\"></div>                                                        		";
			html += "<div class=\"popup_board_div\">                                                         		";
			html += "	<div class=\"close_div\">                                                            		";
			html += "		<div class=\"popup_board_title\">상세보기</div>                                    		";
			html += "		<img class=\"close_img\" id=\"closeBoard\" alt=\"닫기\" src=\"resources/images/cross.png\">";
			html += "	</div>                                                                             			";
			html += "	<div class=\"board_contents_div\">                                                   		";
			html += "		<form id=\"boardForm\">                                                          		";
			html += "			<input type=\"hidden\" name=\"boardNo\" value=\"" + result.params.BOARD_NO + "\" />	              		";
			html += "			<table>                                                                    			";
			html += "				<colgroup>                                                             			";
			html += "					<col width=\"80px\"/>                                                		";
			html += "					<col width=\"210px\"/>                                               		";
			html += "					<col width=\"80px\"/>                                               		";
			html += "					<col width=\"210px\"/>                                               		";
			html += "				</colgroup>                                                            			";
			html += "				<tr>                                                                   			";
			html += "					<td>제목</td>                                                      			";
			html += "					<td colspan=\"3\">								         			     	";
			html += "						<div id=\"updateDiv\">                    		";
			html += result.params.TITLE;
			html += "						</div>                                                        			";
			html += "					     <input type=\"text\" class=\"update_input\" size=\"78\" name=\"title\" id=\"title\" value=\"" + result.params.TITLE + "\" />";
			html += "					</td>     											    			     	";
			html += "				</tr>                                                                  			";
			html += "				<tr>                                                                   			";
			html += "					<td>작성자</td>                                                    			";
			html += "					<td colspan=\"3\">" + result.params.WRITER + "</td>           				  	";
			html += "				</tr>                                                                  			";
			html += "				<tr>                                                                   			";
			html += "					<td>작성일</td>                                                  			";
			html += "					<td>" + result.params.WRITE_DATE + "</td>     							      	";
			html += "					<td>조회수</td>                                                  			";
			html += "					<td>" + result.params.HIT_CNT + "</td>           								";
			html += "				</tr>                                                                  			";
			html += "				<tr>                                                                   			";
			html += "					<td colspan=\"4\">    						                           		";
			html += "						<div class=\"detailContents\">                   		";
			html += result.params.CONTENTS;
			html += "						</div>                                                        			";
			html += "<textarea class=\"update_input\" rows=\"23\" name=\"contents\" id=\"contents\">" + result.params.CONTENTS + "</textarea>";
			html += "					</td>                                                              			";
			html += "				</tr>                                                                  			";
			html += "			</table>                                                                  		    ";
			html += "		<div class=\"board_btn_div\" id=\"board_btn_div\">															";
			html += "			<input type=\"button\" value=\"수정\" id=\"updateBtn\">								";
			html += "			<input type=\"button\" value=\"삭제\" id=\"deleteBtn\">								";
			html += "		</div>																					";
			html += "		<div class=\"update_btn_div\" id=\"update_btn_div\">															";
			html += "			<input type=\"button\" value=\"저장\" id=\"updateResultBtn\">								";
			html += "			<input type=\"button\" value=\"취소\" id=\"updateCancelBtn\">								";
			html += "		</div>																					";
			html += "	</div>                                                                             			";
			html += "</div>                                                                                			";
			
			$("body").prepend(html);
			
			$("input[name='title']").focus();
			
			$(".bg_board_div").hide();
			$(".popup_board_div").hide();
			$(".bg_board_div").fadeIn();
			$(".popup_board_div").fadeIn();
			
			$(".bg_board_div").off("click");
			$(".bg_board_div").on("click", function(){
				closeBoardPopup();
				readContents();
			});
			
			$("#closeBoard").off("click");
			$("#closeBoard").on("click", function(){
				closeBoardPopup();
				readContents();
			});
			
			/* 
				Update Event
			*/
			$("#updateBtn").off("click");
			$("#updateBtn").on("click", function(){
				checkPass(function(result) {
					if(result == "TRUE") {
						$("#updateDiv").css("display", "none");
						$(".detailContents").css("display", "none");
						$("#board_btn_div").css("display", "none");
						$(".update_input").each(function(){
							$(this).css("display", "block");
						});
						$("#update_btn_div").css("display", "block");
					} else {
						makePopup("알림", "비밀번호가 틀렸습니다.");
					}
				});
			});
			
			/* 
				Update result Event
			*/
			$("#updateResultBtn").off("click");
			$("#updateResultBtn").on("click", function(){
				checkInput("U", function() {
					var params = $("#boardForm").serialize();
					
					$.ajax({
						type : "post",
						url : "ajaxBoardUpdateResult",
						dataType : "json",
						data : params,
						success : function(result) {
							closeBoardPopup();
							readContents();
							makePopup("알림", "수정되었습니다.");
						},
						error : function(result) {
							makePopup("알림", "수정에 실패했습니다.");
						}
					});
				});
			});
			
			/* 
				Update Cancel Event
			*/
			$("#updateCancelBtn").off("click");
			$("#updateCancelBtn").on("click", function(){
				$("#updateDiv").css("display", "block");
				$(".detailContents").css("display", "block");
				$("#board_btn_div").css("display", "block");
				$(".update_input").each(function(){
					$(this).css("display", "none");
				});
				$("#update_btn_div").css("display", "none");
			});
			
			/* 
				Delete Event
			*/
			$("#deleteBtn").off("click");
			$("#deleteBtn").on("click", function(){
				checkPass(function(result) {
					if(result == "TRUE") {
						var params = $("#boardForm").serialize();
						
						$.ajax({
							type : "post",
							url : "ajaxBoardDeleteResult",
							dataType : "json",
							data : params,
							success : function(result) {
								closeBoardPopup();
								readContents();
								makePopup("알림", "삭제되었습니다.");
							},
							error : function(result) {
								makePopup("알림", "삭제에 실패했습니다.");
							}
						});
					} else {
						makePopup("알림", "비밀번호가 틀렸습니다.");
					}
				});
			});
		},
		error : function(result) {
			makePopup("알림", "조회에 실패했습니다.");
		}
	});
}

/* 
	Input Data Check
*/
function checkInput(type, event) {
	var result = true;
	if($.trim($("#title").val()) == "") {
		makePopup("알림", "제목을 입력해 주세요");
		
		$("#title").focus();
		
		result = false;
	}
	if(type == "I" && $.trim($("#writer").val()) == "") {
		makePopup("알림", "작성자를 입력해 주세요");
		
		$("#writer").focus();
		
		result = false;
	}
	if(type == "I" && $.trim($("#pass").val()) == "") {
		makePopup("알림", "비밀번호를 입력해 주세요");
		
		$("#pass").focus();
		
		result = false;
	}
	if($.trim($("#contents").val()) == "") {
		makePopup("알림", "내용을 입력해 주세요");
		
		$("#contents").focus();
		
		result = false;
	}
	
	if(result) {
		event();
	}
}

/* 
	Contents Password Check
*/
function checkPass(event) {
	var html = "";
	
	html += "<div class=\"bg_pass_div\"></div>                                                                 ";
	html += "<div class=\"popup_pass_div\">                                                                    ";
	html += "	<div class=\"close_div\">                                                                      ";
	html += "		<div class=\"popup_pass_title\">비밀번호 확인</div>                                        ";
	html += "		<img class=\"close_img\" id=\"closePass\" alt=\"닫기\" src=\"resources/images/cross.png\"> ";
	html += "	</div>                                                                                         ";
	html += "	<div class=\"pass_contents_div\">                                                              ";
	html += "		<form action=\"#\" id=\"passCheckForm\" method=\"post\">  						          ";
	html += "			<input type=\"password\" name=\"pass\" id=\"pass\" />                                  ";
	html += "			<input type=\"hidden\" name=\"boardNo\" id=\"checkBoardNo\" />  	                 ";
	html += "		</form>                                                                                    ";
	html += "		<input type=\"button\" id=\"checkBtn\" value=\"확인\" />                                   ";
	html += "	</div>                                                                                         ";
	html += "</div>                                                                                            ";
	
	$("body").prepend(html);
	
	$("#passCheckForm #pass").focus();
	
	$(".bg_pass_div").hide();
	$(".popup_pass_div").hide();
	$(".bg_pass_div").fadeIn();
	$(".popup_pass_div").fadeIn();
	
	$(".bg_pass_div").off("click");
	$(".bg_pass_div").on("click", function(){
		closePassPopup();
	});
	
	$("#closePass").off("click");
	$("#closePass").on("click", function(){
		closePassPopup();
	});
	
	/* 
		Contents Password Check Event
	*/
	$("#checkBtn").off("click");
	$("#checkBtn").on("click", function(){
		$("#checkBoardNo").val($("#boardNo").val());
		
		var params = $("#passCheckForm").serialize();
		
		$.ajax({
			type : "post",
			url : "ajaxBoardPassCheckResult",
			dataType : "json",
			data : params,
			success : function(result) {
				event(result.result);
				closePassPopup();
			},
			error : function(result) {
				makePopup("알림", "조회에 실패했습니다.");
				closePassPopup();
			}
		});
	});
}

/* 
	Password Check Popup Close
*/
function closePassPopup() {
	$(".bg_pass_div").fadeOut(function(){
		$(".bg_pass_div").remove();
	});
	
	$(".popup_pass_div").fadeOut(function(){
		$(".popup_pass_div").remove();
	});
}
</script>
</head>
<body>
<input type="hidden" name="boardNo" id="boardNo" />
<div class="body_contents">
	<br/>
	<table class="board">
		<colgroup>
			<col width="80px;" />
			<col width="400px;" />
			<col width="100px;" />
			<col width="150px;" />
			<col width="80px;" />
		</colgroup>
		<thead id="titleArea">
			<tr>
				<td colspan="5" align="right"><input type="button" value="추가" id="writeBtn"/></td>
			</tr>
			<tr>
				<th>글번호</th>
				<th>제목</th>
				<th>작성자</th>
				<th>작성일</th>
				<th>조회수</th>
			</tr>
		</thead>
		<tbody id="contentsArea">
			<tr>
				<td colspan="5">조회된 데이터가 없습니다.</td>
			</tr>
		</tbody>
		<tfoot id="pagingArea">
			<tr>
				<td colspan="5">
				<div class="paging_div"></div>
				<div class="search_div">
					<form action="#" id="readForm" method="post">
						<input type="hidden" id="lastSearchGbn" value="0"/>
						<input type="hidden" id="lastSearchText" />
						<input type="hidden" id="page" name="page" value="1"/>
						<select id="searchGbn" name="searchGbn">
							<option value="0" selected="selected">제목</option>
							<option value="1">작성자</option>
							<option value="2">내용</option>
						</select>
						<input type="text" id="searchText" name="searchText" />
						<input type="button" value="검색" id="searchBtn" />
					</form>
				</div>
				</td>
			</tr>
		</tfoot>
	</table>
</div>
</body>
</html>