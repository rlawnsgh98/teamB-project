<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<style>
header {
	border-bottom: 1px solid #aaa;
	align-items: center; 
	justify-content: space-between;
	padding: 0 100px;
	display: flex;
}
header nav, header ul { display: flex; }
header nav ul { font-size: 18px; font-weight: bold; }
header nav ul li:not(:first-child) { margin-left: 50px; }
header nav li a.active, header nav li a:hover { color: #0040ff; font-weight: bold; }
header div li:not(:first-child) { margin-left: 5px; }

</style> 
<header>
<nav>
	<ul>
		<li><a href='<c:url value="/"/>'><img src='images/hanul.ico'></a></li>
		<li><a href='list.cu' ${category eq 'cu' ? 'class="active"' : ''}>고객관리</a></li>
		<li><a href='list.hr' ${category eq 'hr' ? 'class="active"' : ''}>사원관리</a></li>
		<li><a href='list.no' ${category eq 'no' ? 'class="active"' : ''}>공지사항</a></li>
		<li><a>방명록</a></li>
		<li><a>공공데이터</a></li>
		<li><a>시각화</a></li>
	</ul>
</nav>
<div>
	<ul>
		<!-- 로그인 하지 않은 경우 -->
		<c:if test="${empty loginInfo }">
			<li><a class='btn-fill' href='login'>로그인</a></li>
			<li><a class='btn-fill' href='member'>회원가입</a></li>
		</c:if>
		
		<!-- 로그인 한 경우 -->
		<c:if test="${not empty loginInfo }">
			<li><img class='profile' src="${loginInfo.profile}">
			<li><strong> ${loginInfo.name }</strong></li>
			<li><a class='btn-fill' href="changePW">비밀번호변경</a></li>
			<li><a class='btn-fill' href="logout">로그아웃</a></li>
		</c:if>
	</ul>
</div>
</header>