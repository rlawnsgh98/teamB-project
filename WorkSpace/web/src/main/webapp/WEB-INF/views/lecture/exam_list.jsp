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

	<div id="container py-5" class='exam-container'>
		<h3 class='board-title text-dark'>시험목록</h3>
		<c:if test="${loginInfo.type eq 'TEACH'}">
			<div class='w-px1000 flex-end'>
				<a class='btn-fill' href='exam_new.le' style='margin-right:20px'>시험등록</a>
			</div>
		</c:if>
		
        
<!--             <div class="mx-auto bg-white rounded shadow w-px1000"> -->
			<table class="table table-fixed exam-table"> 
				<colgroup>
					<col width='80px'>
					<col width='240px'>
					<col width='100px'>
					<col>
					<col width='100px'>
					<col width='120px'>
				</colgroup>
					
				<tr>
					<th>번호</th>
					<th>시험명</th>
					<th>시험구분</th>
					<th>시험기간</th>
					
					<!-- 수강생 -->
					<c:if test="${loginInfo.type eq 'STUD'}">
						<th>점수</th>
					</c:if>
					
					<!-- 강사 -->
					<c:if test="${loginInfo.type eq 'TEACH'}">
						<th>응시인원</th>
					</c:if>
					
					<th>시험</th>
				</tr>
					
			<c:if test="${exam_list ne null}">
			<c:forEach items="${exam_list}" var="list">
				<tr>
					<td>${list.rownum}</td>
					<td>${list.exam_title}</td>
					<td>
						<c:if test="${list.exam_type eq 1 ? true : false}">모의고사</c:if>
						<c:if test="${list.exam_type eq 2 ? true : false}">쪽지시험</c:if>
						<c:if test="${list.exam_type eq 3 ? true : false}">중간고사</c:if>
						<c:if test="${list.exam_type eq 4 ? true : false}">기말고사</c:if>									
					</td>
					<td>	
						<c:set var="now" value="<%=new java.util.Date()%>" />
							${list.startdate } ~ ${list.duedate }
							<c:set var="date"><fmt:formatDate value="${now}" pattern="yyyy-MM-dd"/></c:set> 
							<c:if test="${list.duedate < date }"><span class="text-danger">[마감]</span></c:if>
							<c:if test="${list.duedate >= date }"><span class="text-success">[진행중]</span></c:if>
					</td>
					<!-- 수강생 -->
					<c:if test="${loginInfo.type eq 'STUD'}">
						<td>
							${list.state eq 0 ? '미제출' : '채점중'}
						</td>
					</c:if>
					
					<!-- 강사 -->
					<c:if test="${loginInfo.type eq 'TEACH'}">
						<td>${list.num} / ${exam_total_num}</td>
					</c:if>
					
					<c:if test="${loginInfo.type eq 'STDU'}">
					<td>
						<c:if test="${list.duedate >= date }">
							<c:if test="${list.state eq 0}">
								
									<a class="btn-fill" href='question.le?exam_code=${list.exam_code}'>시험보기</a>
								
							</c:if>
						</c:if>
					</td>
					</c:if>
					<c:if test="${loginInfo.type eq 'TEACH'}">
						<td>
							<a class="btn-fill" href='question.le?exam_code=${list.exam_code}'>문제제출</a>
						</td>
					</c:if>
				</tr>
			</c:forEach>
			</c:if>
			</table>
			
<!-- 		</div> -->
	</div>
</body>
</html>