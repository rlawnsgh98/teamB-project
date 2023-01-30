<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>


<html>
<head>
	<link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css" rel="stylesheet">
	<style>
		.profile-card{
  background-size: cover;
  width: 100%;
  min-height: 90px;
  border-radius: 4px;
  color: #fff;
}

.profile-card img.profile-photo{
  border: 7px solid #fff;
  float: left;
  margin-right: 20px;
  position: relative;
  top: -30px;
  height: 70px;
  width: 70px;
  border-radius: 50%;
}

.profile-card h5 a{
  font-size: 15px;
}

.profile-card a{
  font-size: 12px;
}

/*Newsfeed Links CSS*/

ul.nav-news-feed{
  padding-left: 20px;
  padding-right: 20px;
  margin: 0 0 40px 0;
    background:#fff;
}

ul.nav-news-feed li{
  list-style: none;
  display: block;
  padding: 15px 0;
}

ul.nav-news-feed li div{
  position: relative;
  margin-left: 30px;
  }

ul.nav-news-feed li div::after{
  content: "";
  width: 100%;
  height: 1px;
  border-top: 1px solid #f1f2f2;
  position: absolute;
  bottom: -15px;
  left: 0;
}

ul.nav-news-feed li a{color: #6d6e71;}

ul.nav-news-feed li i{
  font-size: 18px;
  margin-right: 15px;
  float: left;
}

ul.nav-news-feed i.icon1{color: #8dc63f;}

ul.nav-news-feed i.icon2{color: #662d91;}

ul.nav-news-feed i.icon3{color: #ee2a7b;}

ul.nav-news-fee i.icon4{color: #f7941e;}

ul.nav-news-fee i.con5{color: #1c75bc;}

ul.nav-news-feed i.icon6{color: #9e1f63;}

/*Chat Block CSS*/

#chat-block{
  margin: 0 0 40px 0;
  text-align: center;
  background:#fff;
  padding-top:20px;
}

#chat-block .title{
  background: #8dc63f;
  padding: 2px 20px;
  width: 70%;
  height: 30px;
  border-radius: 15px;
  position: relative;
  margin: 0 auto 20px;
  color: #fff;
  font-size: 14px;
  font-weight: 600;
}

ul.online-users{
  padding-left: 20px;
  padding-right: 20px;
  text-align: center;
  margin: 0;
}

ul.online-users li{
  list-style: none;
  position: relative;
  margin: 3px auto !important;
  padding-left: 2px;
  padding-right: 2px;
}

ul.online-users li span.online-dot{
  background: linear-gradient(to bottom, rgba(141,198,63, 1), rgba(0,148,68, 1));
  border: none;
  height: 12px;
  width: 12px;
  border-radius: 50%;
  position: absolute;
  bottom: -6px;
  border: 2px solid #fff;
  left: 0;
  right: 0;
  margin: auto;
}

img.profile-photo {
    height: 58px;
    width: 58px;
    border-radius: 50%;
}

ul.online-users {
    padding-left: 20px;
    padding-right: 20px;
    text-align: center;
    margin: 0;
}

.list-inline {
    padding-left: 0;
    margin-left: -5px;
    list-style: none;
}

.list-inline>li {
    display: inline-block;
    padding-right: 5px;
    padding-left: 5px;
}

.text-white {
    color: #fff;
}
	</style>
</head>
<body>
        <div class="col-1 rounded" style="position: absolute; left:200px;">
										<c:set var="now" value="<%=new java.util.Date()%>" />
										<c:set var="date" ><fmt:formatDate value="${now}" pattern="yy/MM/dd" /></c:set>
            <div class="profile-card">
	    		<ul class="nav-news-feed">
	              <li><i class="fa fa-list-alt icon1"></i><div><a href="/web/notice_list.le?lecture_code=${lecture_info.lecture_code }">강의 	공지사항</a></div></li>
	              <li><i class="fa fa-users icon2"></i><div><a href="/web/homework_list.le?lecture_code=${lecture_info.lecture_code }&member_code=${loginInfo.member_code }">과제</a></div></li>
	              <li><i class="fa fa-user icon3"></i><div><a href="/web/video_list.le?lecture_code=${lecture_info.lecture_code }">영상강의</a></div></li>
	              <li><i class="fa fa-comments icon4"></i><div><a href="/web/exam_list.le?lecture_code=${lecture_info.lecture_code }&member_code=${loginInfo.member_code }">시험</a></div></li>
	              <li><i class="fa fa-picture-o icon5"></i><div><a href="/web/student_list.le?lecture_code=${lecture_info.lecture_code }">학생목록</a></div></li>
	              <c:if test="${loginInfo.type eq 'TEACH' }">
	              	<li><i class="fa fa-video-camera icon6"></i><div><a href="/web/attendance_manage.le?lecture_code=${lecture_info.lecture_code }&attendance_time=${date}">출결관리</a></div></li>
	              </c:if>
	            </ul>
			</div>
</div>
<%-- <nav class="nav flex-column">
<div id="sidebar-wrapper">
      <ul class="nav nav-pills nav-stacked">
        <li><a class="scroll-link" href="/web/notice_list.le?lecture_code=${lecture_info.lecture_code }">공지사항</a></li>
        <li><a class="scroll-link" href="/web/homework_list.le?lecture_code=${lecture_info.lecture_code }&member_code=${loginInfo.member_code }">과제</a></li>
        <li><a class="scroll-link" href="/web/video_list.le?lecture_code=${lecture_info.lecture_code }">영상강의</a></li>
        <li><a class="scroll-link" href="/web/exam_list.le?lecture_code=${lecture_info.lecture_code }&member_code=${loginInfo.member_code }">시험</a></li>
        <li><a class="scroll-link" href="/web/student_list.le?lecture_code=${lecture_info.lecture_code }">학생목록</a></li>
        <li><a class="scroll-link" href="/web/attendance_manage.le?lecture_code=${lecture_info.lecture_code }">출결관리</a></li>
      </ul>
      </div>
    </nav> --%>
</body>
</html>