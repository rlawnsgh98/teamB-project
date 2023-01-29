<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>modify_verify</title>
<link href="css/bootstrap.min.css" rel="stylesheet">
<link rel="stylesheet" type="text/css"
	href="css/member.css?<%=new java.util.Date()%>">
</head>
<body>
	<div id="container" class="ct_top">
		<div class="main_wrap">
			<h2 class="lnb_title text-center text-dark">회원정보수정</h2>
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
							<div class="tb_box type_write">
								<div class="passwd_box top">
									<div class="box_sub">
										<h3 class="box_stitle">비밀번호를 입력해주세요.</h3>
										<p>회원님의 개인정보보호를 위해 회원정보를 조회/수정하기 전 비밀번호를 다시 확인받고 있습니다.</p>
										<h4 class="box_pw">
											<input type="password" name="passwd" id="passwd" class="w200">
											<a href="modify_myinfo.me" class="btn btn-dark text-white">확인</a>
										</h4>
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