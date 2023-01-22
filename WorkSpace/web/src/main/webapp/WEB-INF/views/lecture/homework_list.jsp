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
	<div id='container py-5'>
		<h3>과제목록</h3>
		<div class="row">
			<div class="col-lg-7 mx-auto bg-white rounded shadow">

					<table class="table table-fixed ">
						<thead>
							<tr>
								<th scope="col" class="col-3">번호</th>
								<th scope="col" class="col-3">과제명</th>
								<th scope="col" class="col-3">제출여부</th>
								<th scope="col" class="col-3">기한</th>
							</tr>
						</thead>
						
						<tbody>
							<c:forEach items="${list}" var="vo">
								<tr>
									<th scope="row" class="col-3">${vo.rownum }</th>
									<td class="col-3">
										<a href="homework_info.le?homework_code=${vo.homework_code }&member_code=${loginInfo.member_code}">${vo.title }</a> 
										<c:set var="now" value="<%=new java.util.Date()%>" />
										<c:set var="date"><fmt:formatDate value="${now}" pattern="yyyy-MM-dd" /></c:set> 
										
										<c:if test="${vo.duedate < date }"><span class="text-danger">[마감]</span></c:if>
										
										<c:if test="${vo.duedate >= date }"><span class="text-success">[진행중]</span></c:if>
									</td>
									<td class="col-3">${vo.writedate } ~ ${vo.duedate }</td>
									<td class="col-3">
										<c:choose >
											<c:when test="${vo.state eq 0}">미제출</c:when>
											<c:when test="${vo.state eq 1}">제출완료</c:when>
										</c:choose> 
									</td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
			</div>
		</div>

	
	
	
</body>
</html>