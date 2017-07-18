<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div class="boarddetail-wrapper">
	<div class="boarddetail-subwrapper">
		<h1>ARTICLE DETAIL</h1>
		<span>게시글 번호 : ${seq}</span></br>
			<form id="updateForm">
				<input type="hidden" id ="seq" name="seq" value="${seq}"/>
				<input type="text" id="id" name="id" placeholder="아이디" value="${id}" readonly=readonly/>
				<input type="text" id="title" name="title" placeholder="제목"  value="${title}"/><br />
		    	<textarea rows="20" id="content" name="content">${content}</textarea>
		    </form>
		    <div class="boarddetail-btnarea">
		    	<a href="${context}/list/1"><input id="boarddetail-homebtn" type="button" value="홈으로"/></a>
		    	<input id="boarddetail-updatebtn" type="button" value="수정"/>
		    	<input id="boarddetail-deletebtn" type="button" value="삭제"/>
		    </div>
    </div>
</div>
<script>
$(function(){
	var form = $('#updateForm');
	$('#boarddetail-updatebtn').on('click',function(){
		alert('수정 버튼 클릭');
		form.attr('method','post');
		form.attr('action','${context}/updateArticle');
		form.submit();
	});
	$('#boarddetail-deletebtn').on('click',function(){
		alert('삭제 버튼 클릭');
		form.attr('method','post');
		form.attr('action','${context}/deleteArticle');
		form.submit();
	});
});
</script>