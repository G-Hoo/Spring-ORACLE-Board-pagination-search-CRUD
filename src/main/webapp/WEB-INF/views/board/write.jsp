<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<div class="boardwrite-wrapper">
	<div class="boardwrite-subwrapper">
	<form id="writeForm">
		<ul>
  			<li>
  				<input id="title" name="title" type="text" placeholder="제목"/>
  				<input id="id" name="id" type="text" placeholder="아이디"/>
  			</li>
  			<li>
  				<textarea name="content" id="content" cols="40" rows="10" placeholder="내용"></textarea>
  			</li>
  			<li class="boardwrite-btnwrapper">
	  			<input id="boardwrite-write" type="button" value="글쓰기"/>
	  			<a href="${context}"><input id="boardwrite-cancel" type="button" value="취소"/></a>
  			</li>
		</ul>
	</form>
	</div>
</div>
<script>
$(function(){
	   var form = $('#writeForm');
	   $('#boardwrite-write').on('click',function(){
		   alert('글쓰기 버튼 클릭');
	       var title = $('#title').val();
	       var content = $('#content').val();
	       var id = $('#id').val();
	       if(title=='' || content==''|| id==''){
		   alert('필수 항목이 빠져 있습니다.');
	       } else {
	    	form.attr('method','post');
		   	form.attr('action','${context}/write');
		   	form.submit();
	       }
	   });
	});
</script>