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
   
   // 글목록 불러오기
   reloadList();
   
   $("#paging_area").on("click", "span", function() {
		$("#page").val($(this).attr("name"));

		reloadList();
	});
   $(document).on('click', '#listBtn', function() {
      $("#actionForm").attr("action", "blogMembers");
      $("#actionForm").submit();
   });
   
   // 동적인거라고는 좀 써줘
   $(document).on('click', 'tbody tr', function() {
      
      $('#blog_no').val( $(this).attr('name') ); // 값을 넣어주고 
      
      if ( $('#blog_no').val() != '' ) {
         reloadDetail();
         reloadList();
      }
      
   });
   
   $(document).on('click', '#updateBtn', function() {
      
      $("#actionForm").attr("action", "blogMUpdate");
      $("#actionForm").submit();
      
   });
   
   $(document).on("click", '#addBtn', function() {
      $("#actionForm").attr("action", "blogMAdd");
      $("#actionForm").submit();
   });
   
});
   

$(document).on("click", '#deleteBtn', function() {
	if (confirm("삭제하시겠습니까?")) {
		var params = $("#actionForm").serialize();

		$.ajax({
			type : "post",
			url : "blogDeleteAjax",
			dataType : "json", // {키:값, 키:값}
			data : params, // 보낼데이터
			success : function(res) { // 성공 시 해당 함수 실행, 결과는 result로 받겠다.
				if (res.res == "SUCCESS") {
					$("#actionForm").attr("action", "blogMDetail");
	                $("#actionForm").submit();
				} else {
					$("#alert").attr("title", "알림");
					$("#alert p").html("삭제에 실패하였습니다.");
					$("#alert").dialog({
						buttons : {
							Ok : function() {
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
});
   
function reloadList() {
   var params = $("#actionForm").serialize();
   
   $.ajax({
      type : "post",
      url : "blogMDetailAjax",
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
   
function reloadDetail() {
   var params = $("#actionForm").serialize();
   
   $.ajax({
      type : "post",
      url : "blogMDetailConAjax",
      dataType : "json", // {키:값, 키:값}
      data : params, // 보낼데이터
      success : function(res) { // 성공 시 해당 함수 실행. 결과는 result로 받겠다.
         drawDetail(res.data);
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
         html += "<td colspan=\"4\">데이터가 없습니다.</td>";
         html += "</tr>" ;
      } else {
         
         $('#blogMno').val(list[0].MNO);
         
         for(var i = 0; i < list.length; i++){
            html += "<tr name=\"" + list[i].BLOG_NO + "\">";         
            html += "<td>" + list[i].BLOG_NO + "</td>";         
            html += "<td>" + list[i].BLOG_TITLE + "</td>";         
            html += "<td>" + list[i].BLOG_HIT + "</td>";         
            html += "<td>" + list[i].BLOG_DT + "</td>";         
            html += "</tr>";
         }
      }
      $(".blog_table tbody").html(html);
      
      if ( $.trim($('.blog_Detail').html()) == '' ) {
         $($('tbody tr')[0]).trigger('click');
      }
      
   }
         
   function drawPaging(pb) {
      var html = "";

      if ($("#page").val() == 1) {
         html += "<span name=\"1\">이전</span> ";
      } else {
         html += "<span name=\"" + ($("#page").val() - 1) + "\">이전</span> ";
      }

      for (var i = pb.startPcount; i <= pb.endPcount; i++) {
         if ($("#page").val() == i) {
            html += "<span name=\"" + i + "\"><b>" + i + "</b></span> ";
         } else {
            html += "<span name=\"" + i + "\">" + i + "</span> ";
         }
      }

      if ($("#page").val() == pb.maxPcount) {
         html += "<span name=\"" + pb.maxPcount + "\">다음</span>";
      } else {
         html += "<span name=\"" + ($("#page").val() * 1 + 1)
               + "\">다음</span>";
      }
      $("#paging_area").html(html);
   }
   
   function drawDetail(data) {
      var html = "<br/>";
         html += "글번호 : " + data.BLOG_NO + "<br/>";
         html += "제목 : " + data.BLOG_TITLE + "<br/>";
         html += "내용 : " + data.BLOG_CON + "<br/>";
         html += "조회수 : " + data.BLOG_HIT + "<br/>";
         html += "작성일 : " + data.BLOG_DT + "<br/><br/>";
         if ( $('#blogMno').val() == $('#loginMno').val() ) {
            html += "<input type=\"button\" id=\"updateBtn\" name=\"updateBtn\" value=\"수정\" />&nbsp;";
            html += "<input type=\"button\" id=\"deleteBtn\" name=\"deleteBtn\" value=\"삭제\" />&nbsp;";
            html += "<input type=\"button\" id=\"addBtn\" name=\"addBtn\" value=\"추가\" />&nbsp;";
            html += "<input type=\"button\" id=\"listBtn\" name=\"listBtn\" value=\"목록\" />" + "<br/>";
         } else {
            html += "내 블로그 아님" + "<br/>";
         }
      $(".blog_Detail").html(html);
   }
         
</script>
</head>
<body>
<form action="#" method="post" id="actionForm">
      
      <input type="hidden" name="mno" id="mno" value="${param.mno}" />
      
      <input type="hidden" name="page" id="page" value="1" />
      
      <input type="hidden" name="blog_no" id="blog_no" value="" />
      
      <input type="text" name="blogMno" id="blogMno" value="" />
      <input type="text" name="loginMno" id="loginMno" value="${sessionScope.sMno}" />
   </form>
   <table class="blog_table">
   <thead>
      <tr>
         <th>번호</th>
         <th>제목</th>
         <th>조회수</th>
         <th>날짜</th>
      </tr>
   </thead>
   <tbody>
   </tbody>
</table>
<div id="paging_area"></div>
<div class="blog_Detail">

</div>
</body>
</html>