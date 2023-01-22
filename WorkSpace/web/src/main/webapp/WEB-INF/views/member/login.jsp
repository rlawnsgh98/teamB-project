<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>login</title>
<link href="css/bootstrap.min.css" rel="stylesheet">
<link rel="stylesheet" type="text/css"
	href="css/member.css?<%=new java.util.Date()%>">
<!-- ctrl+shift+f : 자동 줄맞춤 -->
</head>
<body>
	<h1 class="d-none">홈-회원서비스-로그인</h1>
	<div id="container" class="ct_top">
		<div class="main_wrap">
			<h2 class="lnb_title text-center text-dark">회원 서비스</h2>
			<ul id="lnb" class="lnb_list">
				<li id="lnb_login"><a href="login.me"
					class="btn btn-dark rounded-pill text-white"> 로그인 </a></li>
				<li id="lnb_join"><a href="member.me"
					class="btn btn-outline-dark rounded-pill text-dark"> 회원가입 </a></li>
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
						<li class="last">로그인</li>
					</ol>
				</div>
				<div class="content_body">
					<div class="login_box">
						<div class="log_form">
							<div class="log_title">
								<img src="img/common/login_tt.jpg" alt="아이디와 비밀번호를 입력해주세요 ">
								<p>아이디와 비밀번호를 입력해주세요</p>
							</div>
							<div class="log_agea">
								<div class="log_in">
									<div class="id_in">
										<input type="text" name="id" id="id" class="chk"
											placeholder="아이디">
									</div>
									<div class="pw_in">
										<input type="password" name="password" id="password"
											class="chk" placeholder="비밀번호">
									</div>
								</div>
								<a id="login_btn" class="login btn btn-dark rounded text-white">로그인</a>
							</div>
						</div>
						<div class="log_find">
							<p>처음 방문이신가요?</p>
							<a href="member.me" class="btn btn-dark text-white">회원 가입하기</a>
							<p>로그인 정보를 잊으셨나요?</p>
							<a href="find.me" class="btn btn-dark text-white">아이디/비밀번호 찾기</a>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<script src='js/member.js?<%=new java.util.Date()%>'></script>
	<script>
		$('.login').click(function() {
			login();
		});
		$('#password').keydown(function(e) {
			if (e.keyCode == 13)
				login();
		})
		function login() {
			if (emptyCheck()) {
				$.ajax({
					url : 'smartLogin.me',
					data : {
						id : $('#id').val(),
						pw : $('#password').val()
					},
					method : "POST",
					success : function(response) {
						console.log(response)
						if (response) {
							location = '<c:url value="/"/>';
						} else {
							alert('아이디나 비밀번호가 일치하지 않습니다');
						}
					},
					error : function(req, text) {
						alert(text + ':' + req.status);
					}
				});
			}
		}
	</script>
</body>
</html>