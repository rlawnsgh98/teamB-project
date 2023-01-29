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
	<div id='container py-5'>
		<div class="col-lg-7 mx-auto bg-white rounded shadow">
			<form method='post' action='exam_take'>
				<table class="table table-fixed">
				
						<tr>
							<td class='px-4 py-3'><h1>rownum + 시험문제 제목 + 문제점수</h1></td>
						</tr>
						<tr>
							<td class='px-4 py-3'><h5>문제 지문 문제 지문문제 지문문제 지문문제 지문문제 지문문제 지문문제 지문문제 지문문제 지문문제 지문문제 지문문제 지문문제 지문문제 지문문제 지문</h5></td>
						</tr>
							
						<tr>
							<td>
								 <div class="select ">
								 	객관식 일 떄
							     	<input type="radio" id="select1" name="question" value=1><label for="select1">1번지문</label>
							     	<input type="radio" id="select2" name="question" value=2><label for="select2">2번지문</label>
							     	<input type="radio" id="select3" name="question" value=3><label for="select3">3번지문</label>
							     	<input type="radio" id="select4" name="question" value=4><label for="select4">4번지문</label>
								 </div>
							</td>
						</tr>
						
						<tr>
							<td>
								주관식 일 때
								  <textarea class="form-control px-4 py-3" style="height:300px" placeholder="답안작성"></textarea>
							</td>
						</tr>
				</table>
			
			</form>
		</div>
	</div>
</body>
</html>