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
	<div id="container py-5">
        <div class="row">
        	<%@include file="../include/sidebar.jsp" %>
            <div class="col-lg-9 mx-auto bg-white rounded shadow">
            <h1>학생 목록</h1>
				<table class="table table-fixed table-hover"> 

					<thead>
						<tr>
							<th scope="col" class="col-3">사진</th>
							<th scope="col" class="col-3">이름</th>
							<th scope="col" class="col-3">성별</th>
							<th scope="col" class="col-3">전화번호</th>
						</tr>
					</thead>
			
					<tbody>
						<c:forEach items="${student_list}" var="vo">
							<tr>
								<th scope="col" class="col-3"> <img src="${vo.profilepath }"></th>
								<td scope="col" class="col-3">${vo.member_name }</td>
								<td scope="col" class="col-3">${vo.gender }</td>
								<td scope="col" class="col-3">${vo.phone }</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
	</div>
</body>
</html>