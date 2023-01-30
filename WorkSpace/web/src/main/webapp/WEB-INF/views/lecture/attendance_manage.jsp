<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html>
<html>
<head>
<%-- <link rel="stylesheet" type="text/css" href="css/member.css?<%=new java.util.Date()%>"> --%>
<link rel="stylesheet"	href="//code.jquery.com/ui/1.13.2/themes/base/jquery-ui.css">
<!-- <link href="css/table.css" rel="stylesheet"> -->

<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div id="container" style="margin-top: 100px; margin-bottom: 400px; height: 1000px">
        <div class="row">

	            
            <div class="col-lg-7 mx-auto bg-white rounded shadow">
            <form method='post' id="search" action="attendance_manage.le">
             	<input type="hidden" name="list_size" value="${fn:length(list) }"/>
	            <input type="hidden" name="lecture_code" value="${lecture_info.lecture_code }">
		       <div class='my-3'>
		           날짜 선택 <input type='text' name="attendance_time" class='date' readonly value="${attendance_time }">
		           <a class='btn-fill search'>조회</a>
		       </div>
            </form>
		            
	            <form method='post' id='update' action="attendance_update.le" >
	            	 	<input type="hidden" name="list_size" value="${fn:length(attendance_list) }"/>
	           			<input type="hidden" name="lecture_code" value="${lecture_info.lecture_code }">
	            		
					<table class="table table-fixed table-hover"> 
						<thead>
							<tr>
								<th scope="col" class="col-1">사진</th>
								<th scope="col" class="col-3">이름</th>
								<th scope="col" class="col-2">출석</th>
								<th scope="col" class="col-2">결석</th>
								<th scope="col" class="col-2">조퇴</th>
							</tr>
						</thead>
				
						<tbody>
							<c:forEach items="${attendance_list}" var="vo" varStatus="i">
								<tr>
									<th scope="col" class="col-1 align-middle"><img src="img/common/default_profile_img.png" style="width:50px; height:50px;"></th>
									<td scope="col" class="col-3 align-middle">${vo.member_name } </td>
									<td scope="col" class="col-2"><input type="radio" class="btn-check" name='state${i.index }' id='attendance${i.index }' value='OK' <c:if test="${vo.state eq 'OK' }">checked</c:if> > <label class="btn btn-outline-success" for="attendance${i.index }">출석</label></td>
									<td scope="col" class="col-2"><input type="radio" class="btn-check" name='state${i.index }' id='absent${i.index }' value='NO' <c:if test="${vo.state eq 'NO' }">checked</c:if>>  <label class="btn btn-outline-danger" for="absent${i.index }">결석</label></td>
									<td scope="col" class="col-2"><input type="radio" class="btn-check" name='state${i.index }' id='leave${i.index }' value='HF' <c:if test="${vo.state eq 'HF' }">checked</c:if>> <label class="btn btn-outline-primary" for="leave${i.index }">조퇴</label> </td>
								</tr>
								<input type="hidden" name="member_code${i.index }" value="${vo.member_code}">
								<input type='hidden' name="attendance_time" value="<fmt:formatDate value="${vo.attendance_time }" pattern="yy/MM/dd" />">
								
							</c:forEach>
						</tbody>
					</table>
				</form>
				<div>
					<a class='btn-fill save'>수정완료</a>
					<a class='btn-empty cancel'>취소</a>
				</div>
				
			</div>
		</div>
	</div>
	
	<script src="https://code.jquery.com/ui/1.13.2/jquery-ui.js"></script>

	<script>

		//날짜변경시 날짜삭제 버튼 나오게
		$('.date').change(function() {
			$(this).next().css('display', 'inline');
		});
		//날짜삭제 버튼 클릭시 날짜없애고, 날짜삭제 버튼도 안나오게
		$('#delete').click(function() {
			$(this).css('display', 'none');
			$(this).siblings('.date').val('');
		});

		//생년월일 특정날짜(만8세)까지만 선택가능하도록 제한
		var today = new Date();
		var endDay = new Date(today.getFullYear(), today.getMonth(), today
				.getDate());
		var range = today.getFullYear() - 80 + ':' + endDay.getFullYear();
		
		$('.date').datepicker({
			yearRange : range,
			maxDate : endDay,
			dateFormat : 'y/mm/dd'
		});

		$('.search').on('click', function(){
			$('#search').submit();			
			
		});
		
		$('.save').on('click', function(){
			$('#update').submit();		
			alert('수정되었습니다.');
			
		});
		
		$('.cancel').on('click', function(){
			history.go(-1);
		});

	</script>
</body>
</html>