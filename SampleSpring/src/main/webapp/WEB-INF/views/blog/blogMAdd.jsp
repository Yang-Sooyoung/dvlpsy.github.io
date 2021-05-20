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
$(document).ready(function(){
   $("#listBtn").on("click",function(){
      history.back();
   });
   $("#addBtn").on("click",function(){
      if($.trim($("#blog_title").val())==""){
         alert("제목을 입력해주세요.");
      }else if($.trim($("#blog_con").val())==""){
         alert("내용을 입력해주세요.");
      }else{
         var params=$("#actionForm").serialize();
         $.ajax({
            type : "post",
            url : "blogAddAjax",
            dataType : "json", // {키:값, 키:값}
            data : params, //보낼데이터
            success : function(res) { // 성공 시 해당 함수 실행. 결과는 result로받겠다.
               if(res.res=="SUCCESS"){
                  $("#actionForm").attr("action", "blogMDetail");
                  $("#actionForm").submit();
               }else{
                  $("#alert").attr("title","알림");
                  $("#alert p").html("저장에 실패하였습니다.");
                  $("#alert").dialog({
                     buttons: {
                        Ok: function(){
                           $(this).dialog("close");
                        }
                     }   
                  });
               }
            },
            error : function(req, status, error) {
               console.log("code : " + req.status);
               console.log("message : " + req.responseText);
            }
         });
      }
      
   });
      
   $("#actionForm").on("keypress","input",function(e){
      if(e.keyCode==13){
         return false;
      }
   });
});
</script>
</head>
<body>
<div id="alert" style="display:none;"><p></p></div>
<form action="#" method="post" id="actionForm">

<br/>
제목<input type="text" name="blog_title" id="blog_title"/><br/>
내용<input type="text" name="blog_con" id="blog_con"/><br/>
<input type="hidden" name="mno" id="mno" value="${sMno}"/><br/>
</form>
<input type="button" value="추가" id="addBtn"/>
<input type="button" value="목록" id="listBtn"/>
</body>
</html>