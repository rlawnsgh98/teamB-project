<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>find</title>
<link href="css/bootstrap.min.css" rel="stylesheet">
<link rel="stylesheet" type="text/css"
	href="css/member.css?<%=new java.util.Date()%>">
<link rel="stylesheet"
	href="//code.jquery.com/ui/1.13.2/themes/base/jquery-ui.css">
</head>
<body>
	<div id="container">
		<div class="main_wrap">
			<div id="contet_area">
				<h3>아이디/비밀번호 찾기</h3>
				<div class="content_body">
					<div class="find_box1">
						<div class="find_title">아이디 찾기</div>
						<div class="find_content">
							<ul class="tab_tt">
								<li class="tab_title1"><a>이메일 인증</a></li>
								<li class="tab_title2"><a>SMS 인증</a></li>
							</ul>
							<div class="tab_con_wrap">
								<div class="tab_con">
									<div class="find_box">
										<ul class="find_id">
											<li><strong>이름</strong>
												<div class="input_size">
													<input type="text">
												</div></li>
											<li><strong>이메일</strong>
												<div class="input_size">
													<input type="text">
												</div></li>
											<li class="find_btn"><a href="#"
												class="btn btn-dark text-white">아이디 찾기</a></li>
										</ul>
									</div>
								</div>
							</div>
						</div>
					</div>
					<div class="find_box1">
						<div class="find_title">비밀번호 찾기</div>
						<div class="find_content">
							<ul class="tab_tt">
								<li class="tab_title1"><a>이메일 인증</a></li>
								<li class="tab_title2"><a>SMS 인증</a></li>
							</ul>
							<div class="tab_con_wrap">
								<div class="tab_con">
									<div class="find_box">
										<ul class="find_id">
											<li><strong>아이디</strong>
												<div class="input_size">
													<input type="text">
												</div></li>
											<li><strong>이메일</strong>
												<div class="input_size">
													<input type="text">
												</div></li>
											<li class="find_btn"><a href="#"
												class="btn btn-dark text-white">비밀번호 찾기</a></li>
										</ul>
									</div>
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