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
	<H3>강의시청</H3>
	<iframe src="${vo.path }" width=1200 height=600 frameborder=0 allowfullscreen></iframe>
	<div class='mt-3'>
		<a class='btn-fill cancel' style='width:100%'>뒤로가기</a>
	</div>
	
	
	<script>

		$('.cancel').on('click', function(){
			history.go(-1);
		});
	</script>
</body>
</html>