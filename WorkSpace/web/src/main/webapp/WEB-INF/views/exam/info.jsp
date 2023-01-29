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

<h3 class='container text-center board-title text-dark'>시험등록</h3>

<form action="question_next.le" method="post" autocomplete="off">

<!-- 시험등록에 필요한 정보(hidden) <- 추가해야함 -->
<input type='hidden' name='cur_no' value='${no}'/>
<input type='hidden' name='total_question' value='${total_question}'/>
<input type='hidden' name='type' value="${loginInfo.type eq 'STUD' ? 1 : 2}"/>

<div class='test-container container'>

<header>
	<div class='ml-30'>${lecture.lecture_name}</div>		
	
	<table class='test-table'>
		<colgroup>
			<col width='120px'>
			<col width='120px'>
			<col width='160px'>
		</colgroup>
		
		<tr>
			<th>총 문제</th>
			<th>구분</th>
			<th>시험일</th>
		</tr>
		
		<tr>
			<th>${exam_info.total_question}</th>
			<th>
				<c:if test="${exam_info.exam_type eq 1}">모의고사</c:if>
				<c:if test="${exam_info.exam_type eq 2}">쪽지시험</c:if>
				<c:if test="${exam_info.exam_type eq 3}">중간고사</c:if>
				<c:if test="${exam_info.exam_type eq 4}">기말고사</c:if>
			</th>
			<th>${exam_info.startdate}</th>
		</tr>
	</table>
</header>

<!-- 점수, 문제유형 -->
<div class="exam_score">
<ul>
	<li>
		<c:if test="${question_info.answer_type eq 1}">객관식</c:if>
		<c:if test="${question_info.answer_type eq 2}">주관식</c:if>
	</li>
	<li>
		${question_info.score}점
	</li>
</ul>
</div>

<!-- 문제 title -->
<div class='exam-info-title'>
	<div>${no}.</div>
	<div>${question_info.exam_title}</div>
</div>
<!-- 문제 content -->
<div class='exam-info-content'>
	<div>${question_info.exam_content}</div>
</div>

<!-- 객관식 -->			
<c:if test="${question_info.answer_type eq 1}">
	<ul class='exam-question-info'>
		<li><label><input type="radio" name="answer" value="1" class='vertical-middle'><span>1&nbsp;</span></label><span>${question_info.question1}</span></li>
		<li><label><input type="radio" name="answer" value="2" class='vertical-middle'><span>2&nbsp;</span></label><span>${question_info.question2}</span></li>
		<li><label><input type="radio" name="answer" value="3" class='vertical-middle'><span>3&nbsp;</span></label><span>${question_info.question3}</span></li>
		<li><label><input type="radio" name="answer" value="4" class='vertical-middle'><span>4&nbsp;</span></label><span>${question_info.question4}</span></li>
	</ul>
</c:if>
<!-- 주관식 -->
<c:if test="${question_info.answer_type eq 2}">
	<div class='exam-question_textarea' style='margin-left:25px'>
		<textarea name='exam_answer_area' class='exam_answer_area input-bottom' rows="1" placeholder="답안 입력"></textarea>
	</div>
</c:if>

</div> <!-- test-container 끝 -->

<div class='exam-footer'>
	<!-- 이전, 다음 버튼 -->
	<ul class='exam-move'>
		<c:if test="${loginInfo.type eq 'STUD'}">
		<li><a href='question_next.le?cur_no=${no-2}&total_question=${exam_info.total_question}'><i class="fa-solid fa-caret-left"></i><span style='margin-left:5px'>이전</span></a></li>
			<c:if test="${no < total_question}">
				<li><a onClick='$("form").submit()'><span style='margin-right:5px'>다음</span><i class="fa-solid fa-caret-right"></i></a></li>
			</c:if>
		</c:if>
		<c:if test="${loginInfo.type eq 'TEACH'}">		
			<li><a href='question_next.le?cur_no=${no-2}&total_question=${exam_info.total_question}'><i class="fa-solid fa-caret-left"></i><span style='margin-left:5px'>이전</span></a></li>
			<li><a href='question_next.le?cur_no=${no}&total_question=${exam_info.total_question}'><span style='margin-right:5px'>다음</span><i class="fa-solid fa-caret-right"></i></a></li>
		</c:if>
	</ul>
	
	<!-- 현재 문제/총 문제 -->
	<div class='exam-mark'>		<!-- absolute -->
		<ul>
			<li>${no}</li>
			<li>/</li>
			<li>${exam_info.total_question}</li>
		</ul>
	</div>
</div>

<!-- 제출, 취소 버튼 -->
<div class='btn-board'>
	<c:if test="${loginInfo.type eq 'TEACH'}">
		<a class='btn-exam-empty w-px140 cancel'>돌아가기</a>
	</c:if>
	<c:if test="${loginInfo.type eq 'STUD'}">
		<a class='btn-exam-black w-px140 insert' href='exam_list.le?member_code=${loginInfo.member_code}&lecture_code=${exam_info.lecture_code}'>제출하기</a>
	</c:if>
</div>

</form>

<script>

/* textarea 자동 높이 조절 */
function adjustHeight( type ) {
	var textEle = null;
	if(type == 0){
		textEle = $('.exam_title');
	}else if(type == 1){
		textEle = $('.exam_content');
	}else if(type == 2){
		textEle = $('.exam_answer_area');
	}
	textEle.css('height', 'auto');
	var textEleHeight = textEle.prop('scrollHeight');
	textEle.css('height', textEleHeight);
};

/* textarea 키 입력 */

$('.exam_answer_area').on('keyup', function(){
	adjustHeight(2);
})

</script>
	
</body>
</html>