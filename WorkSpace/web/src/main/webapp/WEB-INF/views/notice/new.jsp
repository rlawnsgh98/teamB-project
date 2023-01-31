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

<h3 class='container text-center board-title text-dark'>공지사항 등록</h3>

<form method="post" autocomplete="off" action="insert.bo" enctype='multipart/form-data'>

<table class='w-px1000 insert-table'>
<tr style='margin-bottom:10px'>
	<th class='w-px140'>제목</th>
	<td><input type='text' name='title' class='ck in-title' title='제목'></td>
</tr>
<tr>
	<th>내용</th>
	<td><textarea name='content' class='in-content ck resize-none' title='내용'></textarea></td>
</tr>
<tr>
	<th>첨부파일</th>
	<td class='text-left' style='height:46px; border:none'>
	<div class='atta align-center'>
		<label style='margin-right:5px'>
			<input type='file' name='file' class='attach-file' >
			<a class='pointer'><i class="font-b fa-solid fa-file-arrow-up"></i></a>
		</label>
		<span class='file-name' style='margin-right:5px'></span>
		<span class='preview'></span>
		<a class='delete-file'><i class="fa-solid fa-square-minus"></i></a>
	</div>
	</td>
</tr>
</table>
<input type='hidden' name='writer' value='${loginInfo.id}'>

</form>

<div class='btn-board'>
	<a class='btn-board-black w-px80 save mr-10'>저장</a>
	<a class='btn-board-empty w-px80 cancel'>취소</a>
</div>

<script>
$('.save').on('click', function(){
// 	if( emptyCheck() ) 
		$('form').submit();
});
$('.cancel').on('click', function(){
	history.go(-1);
})

</script>
</body>
</html>