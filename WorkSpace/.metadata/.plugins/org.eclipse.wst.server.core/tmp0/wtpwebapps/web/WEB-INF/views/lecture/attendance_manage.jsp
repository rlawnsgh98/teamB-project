<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
	<div id="container" style="height: 1000px;">
        <div class="row">

	            
            <div class="col-lg-7 mx-auto bg-white rounded shadow">
	            <form>
		            <div class='my-3'>
		            	날짜 선택 <input type='text' name="startdate" class='date' readonly>
		            </div>
	            
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
							<c:forEach items="${student_list}" var="vo">
								<tr>
									<th scope="col" class="col-1 align-middle"><img src="img/common/default_profile_img.png" style="width:50px; height:50px;"></th>
									<td scope="col" class="col-3 align-middle">${vo.member_name }</td>
									<td scope="col" class="col-2"><input type="radio" class="btn-check" name='attendance' id='attendance'> <label class="btn btn-outline-success" for="attendance">출석</label></td>
									<td scope="col" class="col-2"><input type="radio" class="btn-check" name='attendance' id='absent'>  <label class="btn btn-outline-danger" for="absent">결석</label></td>
									<td scope="col" class="col-2"><input type="radio" class="btn-check" name='attendance' id='leave'> <label class="btn btn-outline-primary" for="leave">조퇴</label> </td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</form>
				
				
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
		});


	</script>
</body>
</html>