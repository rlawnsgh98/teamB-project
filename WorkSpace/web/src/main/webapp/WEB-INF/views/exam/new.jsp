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

<form action="" method="post" autocomplete="off">

<!-- 시험등록에 필요한 정보(hidden) <- 추가해야함 -->
<input type='hidden' name='lecture_name' value=''/>
<input type='hidden' name='lecture_code' value=''/>

<div class='test-container container'>

<header>
	<div>고1 수학</div>		<!-- $로 값 수정 -->
	
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
			<th>20</th>
			<th><select name='exam-type'>			<!-- 시험 구분 value => DB에 맞춰 변경 -->
				<option value='0'>모의고사</option>
				<option value='1'>쪽지시험</option>
				<option value='2'>중간평가</option>
				<option value='3'>최종평가</option>
			</select></th>
			<th>2023.01.26</th>
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

<!-- 문제 -->
<div class='exam_answer'>
	<div>2.</div>
	<textarea name='exam_content' class='exam_content input-bottom' rows="1" placeholder="문제를 입력하세요"></textarea>
</div>
<!-- 객관식 답 -->			
<ul class='exam_question'>
	<li><label><input type="radio" name="answer" value="1"><span>1&nbsp;</span></label><input type="text" name="question1" class='input-bottom' placeholder="번 답안"/></li>
	<li><label><input type="radio" name="answer" value="2"><span>2&nbsp;</span></label><input type="text" name="question2" class='input-bottom' placeholder="번 답안"/></li>
	<li><label><input type="radio" name="answer" value="3"><span>3&nbsp;</span></label><input type="text" name="question3" class='input-bottom' placeholder="번 답안"/></li>
	<li><label><input type="radio" name="answer" value="4"><span>4&nbsp;</span></label><input type="text" name="question4" class='input-bottom' placeholder="번 답안"/></li>
</ul>
<!-- 문제 확인 -->
<div>
	<a class="btn-exam-empty w-px100 question-save mr-20" onClick="answer_clear()">지우기</a>
	<a href="#" class="btn-exam-black w-px100 question-save">저장</a>
</div>

</div> <!-- test-container 끝 -->

<div class='exam-footer'>
	<!-- 이전, 다음 버튼 -->
	<ul class='exam-move'>
		<li><a href='#'><i class="fa-solid fa-caret-left"></i><span style='margin-left:5px'>이전</span></a></li>
		<li><a href='#'><span style='margin-right:5px'>다음</span><i class="fa-solid fa-caret-right"></i></a></li>
	</ul>
	
	<!-- 현재 문제/총 문제 -->
	<div class='exam-mark'>		<!-- absolute -->
		<ul>
			<li>2</li>
			<li>/</li>
			<li>2</li>
		</ul>
	</div>
</div>

<!-- 제출, 취소 버튼 -->
<div class='btn-board'>
	<a class='btn-exam-empty w-px140 cancel mr-20'>돌아가기</a>
	<a class='btn-exam-black w-px140 insert'>시험등록</a>
</div>

</form>

<script>

/* 라디오 체크해제 */
function answer_clear(){
	$('input:radio[name="answer"]').prop('checked', false);
	$('#score').val("");
	$('input:text[placeholder="번 답안"]').val("");
	$('.exam_content').val("");
}

/* textarea 자동 높이 조절 */
function adjustHeight(type) {
	if(type == 0){
		var textEle = $('.exam_content');
	}else{
		//주관식 답안 textarea
	}
	textEle.css('height', 'auto');
	var textEleHeight = textEle.prop('scrollHeight');
	textEle.css('height', textEleHeight);
};

/* textarea 키 입력 */
$('.exam_content').on('keyup', function() {
	adjustHeight(0);
	console.log("key up")
});

</script>
	
</body>
</html>