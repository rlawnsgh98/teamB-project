<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    


<html>
<head>
	<style>
    /* 사이드바 */
    .sidenav {
      position: fixed;
      width: 200px;
      height: 100%;
      margin-left: 55px;
      margin-top:50px
    }

	</style>
</head>
<body>

<nav class="col-sm-3 sidenav">
      <ul class="nav nav-pills nav-stacked">
        <li><a class="scroll-link" href="/web/notice_list.le?lecture_code=${lecture_info.lecture_code }">공지사항</a></li>
        <li><a class="scroll-link" href="/web/homework_list.le?lecture_code=${lecture_info.lecture_code }&member_code=${loginInfo.member_code }">과제</a></li>
        <li><a class="scroll-link" href="/web/video_list.le?lecture_code=${lecture_info.lecture_code }">영상강의</a></li>
        <li><a class="scroll-link" href="/web/exam_list.le?lecture_code=${lecture_info.lecture_code }&member_code=${loginInfo.member_code }">시험</a></li>
        <li><a class="scroll-link" href="/web/student_list.le?lecture_code=${lecture_info.lecture_code }">학생목록</a></li>
        <li><a class="scroll-link" href="/web/attendance_manage.le?lecture_code=${lecture_info.lecture_code }">출결관리</a></li>
      </ul>
    </nav>
</body>
</html>