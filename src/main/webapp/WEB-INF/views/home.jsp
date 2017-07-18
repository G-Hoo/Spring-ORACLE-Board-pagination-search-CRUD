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

<%--================================================personal readme text info========================================================================================== 
회원 게시 글쓰기

로그인 > 서버단에서 회원정보 가져옴 > 회원 게시글 작성시 jsp <input id="" value=${로그인한 회원 아이디}> 여기서 value를 뽑아와  (게시글작성:회원 아이디) 쿠키값에 저장 > 로그인 할시 로그인 아이디 (로그인:회원 아이디) 쿠키값에 저장
> 게시글작성 쿠키값 (게시글작성:회원 아이디) 와 로그인 쿠키값 (로그인:회원 아이디) 값 비교 > 일치하면 (수정/삭제) 버튼 활성화 혹은 show 불일치하면 비활성화 혹은 hide

비회원 게시 글쓰기

비회원 글작성시(비회원 글작성:비회원 글 비밀번호) 쿠키값에 저장 > 비회원 글 (수정/삭제) 버튼 클릭시 비회원 비밀번호 인증 창 > 비밀번호 인증 창 비밀번호와 (비회원 글작성:비회원 글 비밀번호) 쿠키값 비교
> 일치하면 (수정/삭제) 진행 불일치하면 (html)로 적색글 표시
==================================================================================================================================================================--%>