<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>modify_myinfo</title>
<link href="css/bootstrap.min.css" rel="stylesheet">
<link rel="stylesheet" type="text/css"
	href="css/member.css?<%=new java.util.Date()%>">
</head>
<body>
	<div id="container" class="ct_top">
		<div class="main_wrap">
			<h2 class="lnb_title text-center text-dark">마이페이지</h2>
			<ul id="lnb" class="lnb_list">
				<li id="lnb_enrolment_log"><a href="enrolment_log.me"
					class="btn btn-outline-dark rounded-pill text-dark"> 수강현황 </a></li>
				<li id="lnb_modify_myinfo"><a href="modify_verify.me"
					class="btn btn-dark rounded-pill text-white"> 회원정보수정 </a></li>
			</ul>
			<div id="contet_area2">
				<div class="content_body">
					<div class="modify_myinfo_box">
						<div class="tb_top tb_top_large">
							<div class="grayline_tab">
								<ul class="tab_tt">
									<li class="tab_title on"><a href="modify_verify.me">개인정보수정</a></li>
									<li class="tab_title"><a href="modify_pw.me">비밀번호변경</a></li>
								</ul>
							</div>
							<div class="join_box">
								<div class="tb_box">
									<form method='post' action='join' enctype='multipart/form-data'>
										<table class="modify_table">
											<colgroup>
												<col style="width: 14%">
												<col>
											</colgroup>
											<tbody>
												<tr>
													<th class="tb_th"><label for="type"
														class="join_required">회원 구분 </label></th>
													<td><label><input type="radio" name="type"
															value="STUD" checked="checked">학생</label> &nbsp; <label><input
															type="radio" name="type" value="TEACH">강사</label></td>
												</tr>
												<tr>
													<th class="tb_th"><label for="login_id"
														class="join_required">아이디</label></th>
													<td><input type='text' name='id' class='chk w200'
														placeholder="${loginInfo.id}"> <a
														class="btn btn-dark text-white" id="id_ck">중복확인</a>
														<div class='valid'>아이디를 입력하세요(영문소문자,숫자만)</div></td>
												</tr>
												<tr>
													<th class="tb_th"><label for="password"
														class="join_required">비밀번호</label></th>
													<td><input type='password' name='password'
														class='chk w200'>
														<div class='valid'>비밀번호를 입력하세요(영문대/소문자,숫자 모두 포함)</div></td>
												</tr>
												<tr>
													<th class="tb_th"><label for="password_ck"
														class="join_required chk">비밀번호 확인</label></th>
													<td><input type='password' name='password_ck'
														class='chk w200'>
														<div class='valid'>비밀번호를 다시 입력하세요</div></td>
												</tr>
												<tr>
													<th class="tb_th"><label for="member_name"
														class="join_required">이름</label></th>
													<td><input type="text" name="member_name" class="w200"
														placeholder="${loginInfo.member_name}"></td>
												</tr>
												<tr>
													<th class="tb_th"><label for="gender"
														class="join_required">성별</label></th>
													<td><label><input type="radio" name="gender"
															value="남" checked="checked">남</label> &nbsp; <label><input
															type="radio" name="gender" value="여">여</label></td>
												</tr>
												<tr>
													<th class="tb_th"><label for="email"
														class="join_required chk">이메일</label></th>
													<td><div style="float: left;">
															<input type='text' name='email' class='chk w200'
																placeholder="${loginInfo.email}">
															<div class='valid'>이메일을 입력하세요</div>
														</div></td>
												</tr>
												<tr>
													<th class="tb_th"><label for="birth"
														class="join_required">생년월일</label></th>
													<td><input type='text' name='birth' class='date'
														readonly> <a id='delete' style="display: none;"><i
															class="font-r fa-regular fa-calendar-xmark"></i></a></td>
												</tr>
												<tr>
													<th class="tb_th"><label for="phone"
														class="join_required">전화번호</label></th>
													<td><input type='text' name='phone' maxlength="13"
														placeholder="01080808080"></td>
												</tr>
												<tr>
													<th class="tb_th"><label for="post"
														class="join_required">주소</label></th>
													<td><input type="button" id="post" class="button gray"
														value="우편번호찾기"> <input type='text' name='post'
														class='w-px60 input_post' readonly> <input
														type='text' name='address' class='full' readonly>
														<input type='text' name='address' class='full'></td>
												</tr>
												<tr>
													<th class="tb_th"><label for="profilepath"
														class="join_required">프로필 이미지</label></th>
													<td>
														<div class='align'>
															<label> <input type='file' id='attach-file'
																style="border: none; padding: 0" accept="image/*"
																name='profilepath' class="w200">
															</label> <span id='preview'></span> <a id='delete-file'><i
																class="font-r fa-solid fa-trash-can"></i></a>
														</div>
													</td>
												</tr>
											</tbody>
										</table>
										<div class="board_btn">
											<a href="<c:url value="/"/>"
												class="btn btn-white text-dark border-dark">취소</a> <a
												href="#modify.me" class="btn btn-dark text-white">확인</a>
										</div>
									</form>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>