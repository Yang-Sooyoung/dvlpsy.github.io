<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Popup Sample</title>
<!-- Popup CSS -->
<link rel="stylesheet" type="text/css" href="resources/css/common/popup.css" />

<!-- jQuery Script -->
<script type="text/javascript" 
		src="resources/script/jquery/jquery-1.12.4.min.js"></script>
<script type="text/javascript" 
		src="resources/script/common/popup.js"></script>

<script type="text/javascript">
$(document).ready(function(){
	$("#popupBtn").on("click", function(){
		makePopup("Test", "테스트중입니다.");
	});
});
</script>
</head>
<body>
	<input type="button" value="팝업" id="popupBtn"/>
</body>
</html>













