<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>modify_pw</title>
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
							<div class="grayline_tab2">
								<ul class="tab_tt">
									<li class="tab_title"><a href="modify_verify.me">개인정보수정</a></li>
									<li class="tab_title on"><a href="modify_pw.me">비밀번호변경</a></li>
								</ul>
							</div>
							<div class="modify_pw_box">
								<table>
									<colgroup>
										<col style="width: 14%">
										<col>
									</colgroup>
									<tbody>
										<form id="pw_changeForm" action="change_pw" method="post">
										<tr>
											<th class="tb_th text-center"><label>기존비밀번호</label></th>
											<td class="px-2"><input type="password" name="pw_old"
												id="password_old" class="w200"></td>
										</tr>
										<tr>
											<th class="tb_th text-center"><label>신규 비밀번호</label></th>
											<td class="px-2"><input type="password" name="pw_new"
												id="password_new" class="w200"> <span>영문대/소문자,숫자
													모두 포함(5자이상~10자이내)</span></td>
										</tr>
										<tr>
											<th class="tb_th text-center"><label>비밀번호 확인</label></th>
											<td class="px-2"><input type="password" name="pw_ck2"
												id="password_ck2" class="w200"></td>
										</tr>
										</form>
									</tbody>
								</table>
								<div class="modify_btn">
									<a href="<c:url value="/"/>"
										class="btn btn-outline-dark text-dark">취소</a> 
									<a id="pw_change_submit"
										class="btn btn-dark text-white">확인</a>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<script>
		var pw_changeForm = $('#pw_changeForm');
		$('#pw_change_submit').on("click", function(e) {
			pw_changeForm.submit();
		});
	</script>
</body>
</html>