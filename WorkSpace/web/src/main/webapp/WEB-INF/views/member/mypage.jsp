<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>mypage</title>
	<link rel="stylesheet" type="text/css" href="css/member.css?<%=new java.util.Date()%>">
</head>
<body>
	<h3 class="d-none">회원서비스</h3>
	<div id="container" class="ct_top">
		<div class="main_wrap">
			<div class="left_area lnb03">
				<h3 class="d-none">lnb영역</h3>
				<h3 class="lnb_title">마이페이지</h3>
				<ul id="lnb" class="lnb_list" data-code="member">
					<li id="lnb_enrolment_log">
						<a href="enrolment_log.me" target="_self">수강현황</a>
					</li>
					<li id="lnb_modify_myinfo">
						<a href="modify_myinfo.me" target="_self">회원정보수정</a>
					</li>
				</ul>
			</div>
			<div id="contet_area">
				<div class="path">
					<ol class='path_list'>
						<li>마이페이지</li>
						<li class="last">메인</li>
					</ol>
				</div>
				<h4 class="content_title">마이페이지</h4>
				<div class="content_body">
					<div class="my_box">
						<div class="my_info">
							<h6>
								나의정보
								<span class="h6_sub">나의 정보를 확인하세요.</span>
							</h6>
							<ul class="my_info_in">
								<li>
									<strong>회원명</strong>
									<span class="name">김하나</span>
								</li>
								<li>
									<strong>이메일</strong>
									<span>hana@naver.com</span>
								</li>
								<li>
									<strong>전화번호</strong>
									<span>010-1001-1001</span>
								</li>
							</ul>
							<span class="btn_more">	
								<a href="modify_myinfo.me" title="정보수정" class="modify_myinfo_btn">
									정보수정
								</a>
							</span>
						</div>
							<div class="my_note">
						<h6>
							공지사항
							<span class="h6_sub">새로운 소식을 확인하세요.</span>
						</h6>
						<div class="my_notice_in">
							<ul class="list_top">
								<li>
									<a href="#list">계좌 환불 요청시 주의 사항</a>
								</li>
								<li>
									<a href="#list">입금계좌 확인하는 법</a>
								</li>
								<li>
									<a href="#list">결제 오류 및 계좌 입금 안내</a>
								</li>
								<li>
									<a href="#list">쿠폰 등록 방법</a>
								</li>
							</ul>
						</div>
					</div>
					</div>
					<div style="position: relative;">
					<h5 class="tb_title">
						수강 중인 과정
						<span style="font-size: 0.8em;">(최근 수강시작일순 10개)</span>
					</h5>
					<button type="button" class="more_enrolment_btn"
						style="position: absolute; right: 0; bottom: 15px;">
						+ 더보기
					</button>
				</div>
				<div class="tb_box type_list mypage_course_user_list">
					<table summary="수강 중인 과정 및 기간 학습율을 나타냅니다.">
						<colgroup>
							<col style="width: 10%">
							<col style="width: 60%">
							<col style="width: 27%">
							<col style="width: 13%">
						</colgroup>
						<thead>
							<tr>
								<th scope="col">구분</th>
								<th scope="col">과정명</th>
								<th scope="col">학습기간</th>
								<th scope="col">강의실</th>
							</tr>
						</thead>
						<tbody>
							<tr>
								<td class="tac" colspan="5">수강 중인 과정이 없습니다.</td>
							</tr>
						</tbody>
						
					</table>
				</div>
				<h5 class="tb_title">Q&amp;A</h5>
				<div class="tb_box type_list mypage_qna_list">
					<table summary="Q&A를 나타냅니다.">
						<colgroup>
							<col>
							<col style="width: 13%">
							<col style="width: 13%">
						</colgroup>
						<thead>
							<tr>
								<th scope="col">제목</th>
								<th scope="col">등록일</th>
								<th scope="col">답변상태</th>
							</tr>
						</thead>
						<tbody>
							<tr>
								<td colspan="3" class="tac nodata">상담내역이 없습니다.</td>
							</tr>
						</tbody>
					</table>
				</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>