<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<h2 class='container text-center board-title text-dark'>자유게시판</h2>

<table class='table board-table'>
<colgroup>
	<col width='120px'>
	<col>
	<col width='80px'>
	<col width='160px'>
	<col width='80px'>
	<col width='60px'>
</colgroup>

<tr>
	<th>제목</th>
	<td colspan='5' class='text-left'>${info.title}</td>
</tr>
<tr>
	<th>작성자</th>
	<td class='text-left'>${info.member_name}</td>
	<th>작성일</th>
	<td>${info.writedate}</td>
	<th>조회수</th>
	<td>${info.readcnt}</td>
</tr>
<!-- 파일처리 - 있으면 -->
<tr>
	<th>첨부파일</th>
	<td colspan='5' class='text-left'>
		<c:if test="${info.fileList != null}">
			<ul style='padding:0; margin:0' class='board-files'>
			<c:forEach items='${info.fileList}' var='file'>
				<li class='pointer' onClick='fn_download(${file.boardfile_code})'><span style='margin-right:10px'>${file.file_name}</span><i class="fa-solid fa-download"></i></li>
			</c:forEach>
			</ul>
		</c:if>
	</td>
</tr>
<tr>
	<td class='board-info-content text-left' colspan='6'>${fn: replace(info.content, crlf, '<br>')}</td>
</tr>
</table>

<!-- 댓글 작성칸 -->
<form>
<div class='reply_input w-px1000'>
	<c:if test="${! empty loginInfo}">
		<img class='profile' src='${loginInfo.profile}'>
	</c:if>
	<c:if test="${empty loginInfo}">
		<img class='profile' src='img/member/user1.png'>
	</c:if>
	<ul>
		<li><input type='text' name='reply_content' placeholder='댓글 추가...' id='my_reply'/></li>
		<li>
			<ul style='gap:10px'>
				<li class='reply-controll reply-cancel'>취소</li>
				<li class='reply-controll reply-send'>댓글</li>
			</ul>
		</li>
	</ul>
</div>
</form>

<!-- 댓글 목록 -->
<c:if test="${! empty reply}">
<c:forEach items='${reply}' var='vo'>
<div class='replies w-px1000'>
	<!-- 댓글 작성자 프로필 사진 -->
	<c:if test="${! empty loginInfo}">
		<img class='profile' src='${loginInfo.profile}'>
	</c:if>
	<c:if test="${empty loginInfo}">
		<img class='profile' src='img/member/user1.png'>
	</c:if>
	<!-- 댓글 내용 -->
	<div class='reply_inside'>
		<ul>
			<li>${vo.member_name}</li>
			<li>${vo.writedate}</li>
		</ul>
		<div class='text-left'>
			${vo.content}	<!-- 댓글 줄내림 처리 해줘야함 -->
		</div>
	</div>
</div>
</c:forEach>
</c:if>

<!-- 여백 -->
<div style='height:50px'></div>

<script>

function fn_download(file_code){
	console.log("파일 다운로드 처리 " + file_code);
}

</script>
</body>
</html>