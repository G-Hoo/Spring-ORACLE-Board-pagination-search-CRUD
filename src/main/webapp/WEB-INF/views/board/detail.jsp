<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div class="boarddetail-wrapper">
	<div class="boarddetail-subwrapper">
		<h1>ARTICLE DETAIL</h1>
		<span>게시글 번호 : ${seq}</span></br>
		<input type="hidden" name="max" value="${seq}"/>
		<input type="text" name="writer" placeholder="아이디" value="${id}" readonly=readonly/>
		<input type="text" name="title" placeholder="제목"  value="${title}"/><br />
	     	<textarea rows="20" name="comment">${content}</textarea>
	    <div class="boarddetail-btnarea">
	    	<a href="${context}/list/1"><input id="boarddetail-homebtn" type="submit" value="홈으로"/></a>
	    	<input id="boarddetail-updatebtn" type="submit" value="수정"/>
	    	<input id="boarddetail-deletebtn" type="submit" value="삭제"/>
	    </div>
    </div>
</div>