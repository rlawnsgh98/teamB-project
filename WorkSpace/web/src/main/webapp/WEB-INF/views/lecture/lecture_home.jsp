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
	<div id="container">
		<h1>${lecture_info.lecture_name }</h1>
		<c:if test = '${empty lecture_info.profilepath  }'>>
			<i class="font-profile fa-regular fa-circle-user" >
		</c:if>
		<c:if test='${not empty lecture_info.profilepath }'>
				<img class='lecture_profile' src="${lecture_info.profilepath}">
		</c:if>
		<h2>${lecture_info.member_name }</h2>
		<h2>${lecture_info.email }</h2>
	</div>
	
	<%@include file="../include/sidebar.jsp" %>
</body>


</html>