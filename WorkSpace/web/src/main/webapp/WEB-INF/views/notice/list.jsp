<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<h3 class='container text-center board-title text-dark'>공지사항</h3>
	
<div class='btn-board-empty pointer'><a href='list.bo'>자유게시판</a></div>
	
<form method='post' action='list.no' autocomplete="off">

<!-- 검색, 글쓰기 -->	
<div class='w-px1000 board-search'>
	<!-- 검색 -->
	<div class='search'>
		<select name='search' class='w-px100'>
			<option value='all'>전체</option>
			<option value='title'>제목</option>
			<option value='content'>내용</option>
		</select>
		<input type='text' name='keyword' class='w-300' value='${page.keyword}'>
		<a class='btn-board-black'>검색</a>
	</div>
	<!-- 글쓰기 버튼 -->
	<a href='new.no' class='btn-board-black w-px120'>공지등록</a>
</div>

<!-- 게시글 목록 -->
<table class='table board-table'>
<colgroup>
	<col width='100px'>
	<col>
	<col width='120px'>
	<col width='140px'>
	<col width='70px'>
</colgroup>
<tr class='table-menu'>
	<th>번호</th>
	<th class='text-left'>제목</th>
	<th>작성자</th>
	<th>작성일</th>
	<th>조회수</th>
</tr>

<c:forEach items="${page.list}" var="vo">
	<tr>
		<td>${vo.no}</td>
		<td class='text-left pointer board-detail'><a onclick="fn_submit( ${vo.board_code} )">${vo.title}</a></td>
		<td>${vo.member_name}</td>
		<td>${vo.writedate}</td>
		<td>${vo.readcnt}</td>
	</tr>
</c:forEach>

</table>

<input name='curPage' value='1' type='hidden'>
<input name='board_code' type='hidden'>
</form>

<!-- 페이지 -->
<div class='page-list'>

<c:if test="${page.curBlock gt 1}">
	<a onclick='toPage(1)' class='pointer'><i class="fa-solid fa-angles-left"></i></a>
	<a onclick='toPage(${page.beginPage-page.blockPage})' class='pointer'><i class="fa-solid fa-chevron-left"></i></a>
</c:if>

<c:forEach var='no' begin='${page.beginPage}' end='${page.endPage}'>
	<c:if test='${page.curPage eq no}'>	<span>${no}</span> </c:if>
	<c:if test='${page.curPage ne no}'>	
		<a class='pointer' onclick='toPage(${no})'>${no}</a> 
	</c:if>
</c:forEach>

<c:if test="${page.curBlock < page.totalBlock}">
	<a onclick='toPage(${page.endPage+1})' class='pointer'><i class="fa-solid fa-chevron-right"></i></a>
	<a onclick='toPage(${page.totalPage})' class='pointer'><i class="fa-solid fa-angles-right"></i></a>
</c:if>

</div>

<script>

function toPage(no){
	$('[name=curPage]').val( no );
	$('form').submit();
}

//상세 화면
function fn_submit( board_code ){
	
	$('[name=curPage]').val( ${page.curPage} );
	$('[name=board_code]').val( board_code );
	$('form').attr('action', 'info.no');
	$('form').submit();
	
}

</script>

</body>
</html>