<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<link href="css/table.css" rel="stylesheet">
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>공지 목록</h1>
            <div class='btnSet'>
				<a class='btn-fill' href='notice_write.le'>공지작성</a>
			</div>
	<div id="container py-5">
        <div class="row">
			<%@include file="../include/sidebar.jsp" %>

            <div class="col-lg-7 mx-5 bg-white rounded">
            
				<table class="table table-fixed table-hover"> 

					<thead>
						<tr>
							<th scope="col" class="col-3">번호</th>
							<th scope="col" class="col-3">제목</th>
							<th scope="col" class="col-3">작성자</th>
							<th scope="col" class="col-3">작성일자</th>
						</tr>
					</thead>
			
					<tbody>
						<c:forEach items="${notice_list}" var="list">
							<tr>
								<th scope="row" class="col-3">${list.rownum }</th>
								<td scope="col" class="col-3"><a href="notice_info.le?board_code=${list.board_code }">${list.title }</a></td>
								<td scope="col" class="col-3">${list.member_name }</td>
								<td scope="col" class="col-3">${list.writedate }</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
	</div>

</body>
</html>