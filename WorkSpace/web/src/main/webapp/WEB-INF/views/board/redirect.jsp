<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form method='post' action='${url}'>
<input type='hidden' name='id' value="${board_code}">
<input type='hidden' name='curPage' value='${page.curPage}'>
<input type='hidden' name='search' value='${page.search}'>
<input type='hidden' name='keyword' value='${page.keyword}'>
<input type='hidden' name='viewType' value='${page.viewType}'>
<input type='hidden' name='pageList' value='${page.pageList}'>
<input type='hidden' name='download' value="${download}">
</form>

<script>

if( ${download} ){
	alert('다운로드할 파일 없음!');
}
$('form').submit();

</script>

</body>
</html>