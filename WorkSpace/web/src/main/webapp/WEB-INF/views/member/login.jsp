<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>로그인</title>
	<link rel="stylesheet" type="text/css" href="css/member.css?<%=new java.util.Date()%>">
</head>
<body>
	<h3 class="d-none">회원서비스</h3>
	<div id="container" class="ct_top">
		<div class="main_wrap">
			<div class="left_area lnb03">
				<h3 class="d-none">lnb영역</h3>
				<h3 class="lnb_title">회원서비스</h3>
				<ul id="lnb" class="lnb_list" data-code="member">
					<li id="lnb_login" class="on">
						<a href="login" target="_self">로그인</a>
					</li>
					<li id="lnb_join">
						<a href="member" target="_self">회원가입</a>
					</li>
					<li id="lnb_findpw">
						<a href="#/member/find.jsp" target="_self">비밀번호찾기</a>
					</li>
					<li id="lnb_privacy">
						<a href="#/main/page.jsp?code=privacy" target="_self">개인정보취급방침</a>
					</li>
					<li id="lnb_terms">
						<a href="#/member/page.jsp?code=clause" target="_self">이용약관</a>
					</li>
				</ul>
			</div>
			<div id="contet_area">
				<div class="path">
					<ol class='path_list'>
						<li>회원서비스</li>
						<li class="last">로그인</li>
					</ol>
				</div>
				<h4 class="content_title">로그인</h4>
				<div class="content_body">
					<div class="login_box">
						<div class="log_form">
							<h5 class="log_tt">
								<img src="img/common/login_tt.jpg" alt="아이디와 비밀번호를 입력해주세요 ">
								아이디와 비밀번호를 입력해주세요
							</h5>
							<div class="log_agea">
								<div class="log_in">
									<div class="ip_id">
										<input type="text" name="id" id="id" class="chk" placeholder="아이디">
									</div>
									<div class="pw_id">
										<input type="password" name="password" id="password" class="chk" placeholder="비밀번호">
									</div>	
								</div>
								<p class="ip_submit">
									<input type="submit" class="button gray login" value="로그인" onclick="login();">
								</p>
							</div>
						</div>	
						<div class="log_find">
							<p>처음 방문이신가요?</p>
							<input type="button" class="button gray small" onclick="location.href='member'" value="회원 가입하기">
							<p>로그인 정보를 잊으셨나요?</p>
							<input type="button" class="button gray small" onclick="location.href='member/find'" value="아이디/비밀번호 찾기">
						</div>					
					</div>
				</div>
			</div>
		</div>
	</div>
	<script src='js/member.js?<%=new java.util.Date()%>'></script>
	<script>
	$('.login').click(function(){
		login();
	});
	$('#password').keydown(function(e){
		if(e.keyCode==13) login();
	})
	function login(){
		if( emptyCheck() ){
			$.ajax({
				url: 'smartLogin',
				data: { id:$('#id').val(), pw:$('#password').val() },
				method: "POST", 
				success: function( response ){
					console.log( response )
					if( response ){
						location = '<c:url value="/"/>';
					}else{
						alert('아이디나 비밀번호가 일치하지 않습니다');
					}
				},error: function(req,text){
					alert(text+':'+req.status);
				}
			});
		}
	}
	</script>
</body>
</html>