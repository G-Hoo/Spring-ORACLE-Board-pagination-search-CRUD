<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div class="boardlist-wrapper">
	<div class="boardlist-subwrapper">
	<!-- 검색 부분 시작-->
		<form id="search">
			<div class="boardlist-search-wrapper">
			<select class="boardlist-search-selectbox" name="selectVal">
				<option value="all">전체</option>
				<option value="writer">작성자</option>
				<option value="title">제목</option>
			</select>
			<div class="boardlist-searchbtn-wrapper">
				<input id="searchtext" type="text" name="searchText" placeholder="게시물 검색">
				<button id="searchbtn" class="boardlist-searchbtn">검색</button>
			</div>
			</div>
		</form>
	<!-- 검색 부분 끝-->
	
	<!-- 게시판 리스트 부분 시작 -->
		<table class="boardlist-table" id="board_list" class="table table-hover"> 
			<tr>
				<td colspan="5">총 게시글 수 : <b>${theNumberOfRows}</b>건</td>
			</tr>
			<tr class="boardlist-table-schema">
				<td>Seq</td>
				<td>사용자 ID</td>
				<td>제목</td>
				<td>작성일</td>
				<td>카운트</td>
			</tr>
			<c:forEach var="article" items="${list}">
				<tr>
					<td><span>${article.seq}</span></td>
					<td><span>${article.id}</span></td>
					<td><span><a id="link" href="${context}/detail/${article.seq}">${article.title}</a></span></td>
					<td><span>${article.regdate}</span></td>
					<td><span>${article.hit_cnt}</span></td>
				</tr>
			</c:forEach>
		</table>
	<!-- 게시판 리스트 부분 끝 -->	
	
	<!-- 페이지네이션 부분 시작-->
			<ul class="pagination" id="pagination" class="pagination">
			    <c:if test="${prevBlock gt 0}">
				    <li id="previous">
					    <a href="${context}/search/${prevBlock}?selectVal=${selectVal}&searchText=${searchText}" aria-label="Previous">
					    	<span aria-hidden="true">&laquo;</span>
					    </a>
					</li>
				</c:if>
				
			    <c:forEach varStatus="i" begin="${startPage}" end="${endPage}" step="1">
					<c:choose>
						<c:when test="${i.index eq pageNo}">
							<li><a href="#">${i.index}</a></li>
						</c:when>
						<c:otherwise>
							<li><a id="searchListGoPage" href="${context}/search/${i.index}?selectVal=${selectVal}&searchText=${searchText}">${i.index}</a></li>
						</c:otherwise>
					</c:choose>
			    </c:forEach>
			    <c:if test="${nextBlock le theNumberOfPages}">
					<li id="next">
					    <a href="${context}/search/${nextBlock}?selectVal=${selectVal}&searchText=${searchText}" aria-label="Next">
					    	<span aria-hidden="true">&raquo;</span>
					    </a>
				   	</li>
				</c:if>
			</ul>
	<!-- 페이지네이션 부분 끝 -->
	
	<!-- 글쓰기,홈으로 버튼 부분 시작 -->

		<div class="boardlist-btn-wrapper">
			<a id="write" href="${context}/goWritePage">
				<input class="board-writebtn" type="button" value="글쓰기"/>
			</a>

			<a id="home" href="${context}">
				<input class="board-homebtn" type="button" value="홈으로"/>
			</a>
		</div>

	<!-- 글쓰기,홈으로 버튼 부분 끝 -->
	</div>
</div>
<script>
$(function(){
    $('#searchbtn').on('click',function(){
    	var form = $('#search');
    	alert('검색버튼 클릭');
    	form.attr('action','${context}/search/1');
    	form.submit();
    });
});
</script>