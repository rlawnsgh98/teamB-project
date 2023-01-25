<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>join</title>
<link href="css/bootstrap.min.css" rel="stylesheet">

<link rel="stylesheet" type="text/css"
	href="css/member.css?<%=new java.util.Date()%>">
	
<link rel="stylesheet"
	href="//code.jquery.com/ui/1.13.2/themes/base/jquery-ui.css">
</head>
<body>
	<h1 class="d-none">홈-회원서비스-회원가입</h1>
	<div id="container" class="ct_top">
		<div class="main_wrap">
			<h2 class="lnb_title text-center text-dark">회원 서비스</h2>
			<ul id="lnb" class="lnb_list">
				<li id="lnb_login"><a href="login.me"
					class="btn btn-outline-dark rounded-pill text-dark"> 로그인 </a></li>
				<li id="lnb_join"><a href="member.me"
					class="btn btn-dark rounded-pill text-white"> 회원가입 </a></li>
				<li id="lnb_find"><a href="find.me"
					class="btn btn-outline-dark rounded-pill text-dark"> 비밀번호 찾기 </a></li>
				<li id="lnb_privacy"><a href="privacy.me"
					class="btn btn-outline-dark rounded-pill text-dark"> 개인정보취급방침 </a>
				</li>
				<li id="lnb_terms"><a href="terms.me"
					class="btn btn-outline-dark rounded-pill text-dark"> 이용약관 </a></li>
			</ul>
			<div id="contet_area">
				<div class="path">
					<ol class='path_list'>
						<li>회원 서비스</li>
						<li class="last">회원가입</li>
					</ol>
				</div>
				<div class="content_body">
					<div class="join_box">
						<div class="join_box_title">
							<h5>회원가입</h5>
							<span class="must">*필수 항목입니다.</span>
						</div>
						<div class="tb_box">
							<form method='post' action='join' enctype='multipart/form-data'>
								<table class="join_table">
									<colgroup>
										<col style="width: 14%">
										<col>
									</colgroup>
									<tbody>
										<tr>
											<th class="tb_th"><label for="type"
												class="join_required">회원 구분<span class="must">*</span>
											</label></th>
											<td><label><input type="radio" name="type"
													value="STUD" checked="checked">학생</label> &nbsp; <label><input
													type="radio" name="type" value="TEACH">강사</label></td>
										</tr>
										<tr>
											<th class="tb_th"><label for="login_id"
												class="join_required">아이디<span class="must">*</span></label>
											</th>
											<td><input type='text' name='id' class='chk w200'>
												<a class="btn btn-dark text-white" id="id_ck">중복확인</a>
												<div class='valid'>아이디를 입력하세요(영문소문자,숫자만)</div></td>
										</tr>
										<tr>
											<th class="tb_th"><label for="password"
												class="join_required">비밀번호<span class="must">*</span></label>
											</th>
											<td><input type='password' name='password'
												class='chk w200'>
												<div class='valid'>비밀번호를 입력하세요(영문대/소문자,숫자 모두 포함)</div></td>
										</tr>
										<tr>
											<th class="tb_th"><label for="password_ck"
												class="join_required chk">비밀번호 확인<span class="must">*</span></label>
											</th>
											<td><input type='password' name='password_ck'
												class='chk w200'>
												<div class='valid'>비밀번호를 다시 입력하세요</div></td>
										</tr>
										<tr>
											<th class="tb_th"><label for="member_name"
												class="join_required">이름<span class="must">*</span></label></th>
											<td><input type="text" name="member_name" class="w200">
											</td>
										</tr>
										<tr>
											<th class="tb_th"><label for="gender"
												class="join_required">성별<span class="must">*</span></label></th>
											<td><label><input type="radio" name="gender"
													value="남" checked="checked">남</label> &nbsp; <label><input
													type="radio" name="gender" value="여">여</label></td>
										</tr>
										<tr>
											<th class="tb_th"><label for="email"
												class="join_required chk">이메일<span class="must">*</span></label></th>
											<td><div style="float: left;">
													<input type='text' name='email' class='chk w200'>
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
											<td><input type='text' name='phone' maxlength="13">
											</td>
										</tr>
										<tr>
											<th class="tb_th"><label for="post"
												class="join_required">주소</label></th>
											<td><input type="button" id="post" class="button gray"
												value="우편번호찾기"> <input type='text' name='post'
												class='w-px60 input_post' readonly> <input
												type='text' name='address' class='full' readonly> <input
												type='text' name='address' class='full'></td>
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
										href="join.me" class="btn btn-dark text-white">확인</a>
								</div>
							</form>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<script src='js/member.js?<%=new java.util.Date()%>'></script>
	<script src='js/common.js?<%=new java.util.Date() %>'></script>
	<script src="https://code.jquery.com/ui/1.13.2/jquery-ui.js"></script>
	
	<script
		src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
		
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.2.1/js/all.min.js"></script>
		
	<script>
		$('.join').click(function() {
			if ($.trim($('[name=member_name]').val()) == '') {
				alert('이름을 입력하세요');
				$('[name=member_name]').focus();
				$('[name=member_name]').val('');
				return;
			}
			//유효성확인
			//중복확인 했고 이미사용중인 경우 가입불가
			//중복확인하지 않은경우 가입불가
			var _id = $('[name=id]');
			if (_id.hasClass('chked')) {
				if (_id.siblings('div').hasClass('invalid')) {
					alert('회원가입 불가!\n' + member.id.unUsable.desc);
					_id.focus();
					return;
				}

			} else {
				//유효하지 않게 입력해서 회원가입불가
				if (tagIsInvalid(_id))
					return;
				else {
					//중복확인하지 않아서 회원가입불가			
					alert('회원가입 불가!\n' + member.id.valid.desc);
					_id.focus();
					return;
				}
			}
			if (tagIsInvalid($('[name=password]')))
				return;
			if (tagIsInvalid($('[name=password_ck]')))
				return;
			$('form').submit();
		});

		//유효성확인
		function tagIsInvalid(tag) {
			var status = member.tag_status(tag);
			if (status.code == 'invalid') {
				alert('회원가입 불가!\n' + status.desc);
				tag.focus();
				return true;
			} else
				return false;
		}

		//아이디 중복확인
		$('#id_ck').click(function() {
			idCheck();
		});
		function idCheck() {
			var $id = $('[name=id]');
			//이미 중복확인했다면 재확인 불필요
			if ($id.hasClass('chked'))
				return;

			var status = member.tag_status($id);
			if (status.code == 'invalid') {
				alert('아이디 중복확인 불필요!\n' + status.desc);
				$id.focus();
			} else {
				$.ajax({
					url : 'idCheck',
					data : {
						id : $id.val()
					},
					success : function(response) {
						//false: 아이디 존재X, true: 아이디 존재
						status = response ? member.id.unUsable
								: member.id.usable;
						$id.siblings('div').text(status.desc).removeClass()
								.addClass(status.code);
						//중복확인완료지정
						$id.addClass('chked');
					},
					error : function(req, text) {
						alert(text + ':' + req.status);
					}
				});
			}
		}

		$('.chk').keyup(
				function(e) {
					if ($(this).attr('name') == 'id' && e.keyCode == 13) { //아이디에서 Enter시 중복확인처리
						idCheck();
					} else {
						$(this).removeClass('chked');
						var status = member.tag_status($(this));
						$(this).siblings('div').text(status.desc).removeClass()
								.addClass(status.code);
					}
				});

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
		var endDay = new Date(today.getFullYear() - 8, today.getMonth(), today
				.getDate() - 1);
		var range = today.getFullYear() - 80 + ':' + endDay.getFullYear();
		$('.date').datepicker({
			yearRange : range,
			maxDate : endDay,
		});

		$('#post')
				.click(
						function() {
							//다음 우편번호찾기 api로 우편번호와 기본주소를 조회해온다.
							new daum.Postcode(
									{
										oncomplete : function(data) {
											console.log(data)
											$('[name=post]').val(data.zonecode);
											var address = data.userSelectedType == 'R' ? data.roadAddress
													: data.jibunAddress;
											if (data.buildingName != '')
												address += ' ('
														+ data.buildingName
														+ ')';
											$('[name=address]').eq(0).val(
													address);
										}
									}).open();
						});
	</script>
</body>
</html>