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
	<h3>문제 추가</h3>
	<div id="container py-5">
		<div class="col-lg-7 mx-auto bg-white rounded shadow" id='asd'>
		
			<form method='post' action='notice_write' enctype='multipart/form-data'>

				<input type="radio" class="btn-check" name='exam' id='multiple' checked>  <label class="btn btn-outline-danger" for="multiple">객관식</label>
				<input type="radio" class="btn-check" name='exam' id='short'>  <label class="btn btn-outline-danger" for="short">주관식</label>
				<table class="table">
					<tr>
						<th class="col-3 align-middle px-4 py-3">문제제목</th>
						<td class="align-middle"><input class='form-control' type="text"  name='title'></td>
					</tr>
					
					<tr>
						<th class="col-3 align-middle px-4 py-3">문제내용</th>
						
						<td class="align-middle">
							<textarea class="form-control px-4 py-3" style="height:100px" name='content'></textarea>
						</td>
					</tr>
					<tr class='select_mutiple'>
						<th class="col-3 align-middle px-4 py-3">1번 지문</th>
						<td>
							<textarea class="form-control px-4 py-3" style="height:100px" name='select1'></textarea>
						</td>
					</tr>
					
					<tr class='select_mutiple'>
						<th class="col-3 align-middle px-4 py-3">2번 지문</th>
						<td>
							<textarea class="form-control px-4 py-3" style="height:100px" name='select2'></textarea>
						</td>
					</tr>
					
					<tr class ='select_mutiple'>
						<th class="col-3 align-middle px-4 py-3">3번 지문</th>
						<td>
							<textarea class="form-control px-4 py-3" style="height:100px" name='select3'></textarea>
						</td>
					</tr>
					
					<tr class='select_mutiple'>
						<th class="col-3 align-middle px-4 py-3">4번 지문</th>
						<td>
							<textarea class="form-control px-4 py-3" style="height:100px" name='select4'></textarea>
						</td>
					</tr>
					<tr>
						<th class="col-3 align-middle px-4 py-3">문제점수</th>
						<td class="align-middle"  style="float:left"><input type="text"  name='score'></td>
					</tr>
				</table>
				<button type="button" class='btnAdd'>문제추가하기</button>
			</form>
		</div>
	</div>
	<script>
	$(function (){
		 
		$('input[type="radio"]').on('click', function(){
		  var chkValue = $('input[type=radio][id="multiple"]:checked').val();
		  if(chkValue){
			  $('.select_mutiple').css('display','');
		  }else{
			  $('.select_mutiple').css('display','none');     
		  }
		 
		});
		 
		});
	
	 $(function() {
	        $(".btnAdd").on("click", function() {
	            $(".table").clone().appendTo("#asd");
	        })
	    })
	</script>
</body>
</html>