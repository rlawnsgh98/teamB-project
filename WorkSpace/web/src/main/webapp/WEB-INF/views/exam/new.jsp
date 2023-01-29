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

<form action="exam_question_new.le" method="post" autocomplete="off">

<!-- 시험등록에 필요한 정보(hidden) <- 추가해야함 -->
<input type='hidden' name='no' value='${no}'/>
<input type='hidden' name='exam_code' value='${exam_info.exam_code}'/>


<div class='test-container container'>

<header>
	<div class='ml-30'>${lecture.lecture_name}</div>		<!-- $로 값 수정 -->
	
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
			<th>${total_question}</th>
			<th>${exam_info.exam_type}</th>
			<th>${exam_info.startdate}</th>
		</tr>
	</table>
</header>

<!-- 점수, 문제유형 -->
<div class="exam_score">
<ul>
	<li>
		<label>
			<span>점수</span>
			<input type="text" name='score' id='score' maxlength="2"/>
		</label>
	</li>
	<li><select name="answer_type">
		<option value='1'>객관식</option>
		<option value='2'>주관식</option>
	</select></li>
</ul>
</div>

<!-- 문제 title -->
<div class='exam-info-title mt-90'>
	<div>${no}.</div>
	<textarea name='exam_title' class='exam_title input-bottom' rows="1" placeholder="문제 입력"></textarea>
</div>
<!-- 문제 content -->
<div class='exam-info-content'>
	<textarea name='exam_content' class='exam_content input-bottom' rows="1" placeholder="내용 입력(선택)"></textarea>
</div>
<!-- 객관식 답 -->			
<ul class='exam-question'>
	<li><label><input type="radio" name="answer" value="1"><span>1&nbsp;</span></label><input type="text" name="question1" class='input-bottom' placeholder="번 답안"/></li>
	<li><label><input type="radio" name="answer" value="2"><span>2&nbsp;</span></label><input type="text" name="question2" class='input-bottom' placeholder="번 답안"/></li>
	<li><label><input type="radio" name="answer" value="3"><span>3&nbsp;</span></label><input type="text" name="question3" class='input-bottom' placeholder="번 답안"/></li>
	<li><label><input type="radio" name="answer" value="4"><span>4&nbsp;</span></label><input type="text" name="question4" class='input-bottom' placeholder="번 답안"/></li>
</ul>
<!-- 주관식 답 -->
<div class='exam_question_textarea' style='margin-left:25px'>
	<textarea name='exam_answer_area' class='exam_answer_area input-bottom' rows="1" placeholder="답안 입력"></textarea>
</div>

<!-- 지우기, 저장 -->
<div class='btn-remove-save'>
	<a class="btn-exam-empty w-px100 question-save mr-20" onClick="answer_clear()">지우기</a>
	<a onClick="$('form').submit()" class="btn-exam-black w-px100 question-save">저장</a>
</div>

</div> <!-- test-container 끝 -->

<div class='exam-footer'>
	<!-- 이전, 다음 버튼 -->
	<ul class='exam-move'>
		<li><a href='question_next.le?cur_no=${no-2}&total_question=${exam_info.total_question}'><i class="fa-solid fa-caret-left"></i><span style='margin-left:5px'>이전</span></a></li>
		<li class='btn-exam-next'><a href='question_next.le?cur_no=${no}&total_question=${exam_info.total_question}'><span style='margin-right:5px'>다음</span><i class="fa-solid fa-caret-right"></i></a></li>
	</ul>
	
	<!-- 현재 문제/총 문제 -->
	<div class='exam-mark'>		<!-- absolute -->
		<ul>
			<li>${no}</li>
			<li>/</li>
			<li>${total_question}</li>
		</ul>
	</div>
</div>

<!-- 제출, 취소 버튼 -->
<div class='btn-board'>
	<a class='btn-exam-empty w-px140 cancel'>돌아가기</a>
<!-- 	<a class='btn-exam-black w-px140 insert'>시험등록</a> -->
</div>

</form>

<script>

/* 객관식,주관식 선택시 */
$('select[name="answer_type"]').on('change', function(){
	var type = $('select[name="answer_type"]').val();
	if(type == 1){
		//객관식
		console.log("객관식");
		$('.exam_question').css('display', 'flex');
		$('.exam_question_textarea').css('display', 'none');
	}else{
		//주관식
		console.log("주관식");
		$('.exam_question').css('display', 'none');
		$('.exam_question_textarea').css('display', 'block');
	}
})


/* 라디오 체크해제 */
function answer_clear(){
	$('input:radio[name="answer"]').prop('checked', false);
	$('#score').val("");
	$('input:text[placeholder="번 답안"]').val("");
	$('.exam_title').val("");
	$('.exam_content').val("");
}

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
$('.exam_title').on('keyup', function() {
	adjustHeight(0);
	console.log("key up")
});
$('.exam_content').on('keyup', function(){
	adjustHeight(1);
});
$('.exam_answer_area').on('keyup', function(){
	adjustHeight(2);
})

</script>
	
</body>
</html>