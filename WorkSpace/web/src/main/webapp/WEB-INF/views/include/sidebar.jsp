<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    


<html>

<body>
	<nav id="aside">
 
    <ul class="list-unstyled menu-elements">
        <li class="active">
            <a class="scroll-link" href="/web/notice_list.le?lecture_code=${lecture_info.lecture_code }">공지사항</a>
        </li>
        <li>
            <a class="scroll-link" href="/web/homework_list.le?lecture_code=${lecture_info.lecture_code }&member_code=${loginInfo.member_code }">과제</a>
        </li>
        <li>
            <a class="scroll-link" href="/web/video_list.le?lecture_code=${lecture_info.lecture_code }">영상강의</a>
        </li>
        <li>
            <a class="scroll-link" href="/web/exam_list.le?lecture_code=${lecture_info.lecture_code }&member_code=${loginInfo.member_code }">시험</a>
        </li>
        <li>
            <a class="scroll-link" href="/web/student_list.le?lecture_code=${lecture_info.lecture_code }">학생목록</a>
        </li>
    </ul>
 
</nav>
</body>
</html>