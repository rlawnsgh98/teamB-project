<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html>
<head>
<link href="css/table.css" rel="stylesheet">
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	
	<div class='container py-5'>
	<h3>과제 정보</h3>
		<div class="col-lg-7 mx-auto bg-white rounded shadow">
			<div class=''>
				<table class="table ">
					<tr>
						<th>과제명</th>
						<td>${info.title }</td>
					</tr>
					<tr>
						<th>제출기한</th><td>${info.writedate } ~ ${info.duedate }</td>
					</tr>
					<tr>
						<th>과제내용</th><td>${info.content }</td>
					</tr>
					<tr>
						<th>참고자료</th>
						<td></td>
					</tr>
				</table>
			</div>
		</div>
		
		<h3>제출 정보</h3>
		<div class="col-lg-7 mx-auto bg-white rounded shadow">
				<table class="table">
					<tr>
						<th>제출자</th><td>${info.member_name }</td>
					</tr>
					<tr>
						<th>첨부파일</th><td></td>
					</tr>
					<tr>
						<th>제출상태</th>
						<td>
							<c:choose>
								<c:when test="${info.state eq 0}">미제출</c:when>
								<c:when test="${info.state eq 1}">제출완료</c:when>
							</c:choose> 
						</td>
					</tr>
					
					<tr>
						<th>제출일자</th><td>${info.submitdate }</td>
					</tr>
				</table>
		</div>
		
		
		<c:set var="now" value="<%=new java.util.Date()%>" />
		<c:set var="date"><fmt:formatDate value="${now}" pattern="yyyy-MM-dd" /></c:set> 
		
		<c:if test="${info.duedate >= date }">
			<div class='btnSet'>
				<c:if test="${info.state eq 0}">
					<a class='btn-fill' href=''>제출</a>
				</c:if>	
				<c:if test="${info.state eq 1}">
					<a class='btn-fill' href=''>수정</a>
				</c:if>
			</div>
		</c:if>		
	</div>
	

</body>
</html>