<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!doctype html>
<html>
<head>
<meta charset="UTF-8" />
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<script src="${context}/resources/js/util.popup.js"></script>
<script src="${context}/resources/js/util.cookie.js"></script>
<script src="//d1p7wdleee1q2z.cloudfront.net/post/search.min.js"></script>
<link rel="stylesheet" href="${context}/resources/css/reset.css" />
<link rel="stylesheet" href="${context}/resources/css/board.css" />
<link rel="stylesheet" href="${context}/resources/css/popup.css" />
<title>Board</title>
</head>
<body>
	<div class="home-wrapper">
		<form action="${context}/list/1" id="board">
			<input class="home-goboardbtn" type="submit" value="게시판 가기"/>          
	    </form>
    </div>
</body>
<script>
$(function(){
    var board = $('#board');
	$('#board input[type=submit]').click(function() {
		board.attr('method','post');
		board.submit();
	});
});
</script>
</html>