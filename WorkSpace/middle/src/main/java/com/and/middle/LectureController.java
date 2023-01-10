package com.and.middle;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;

import Enrolment.EnrolmentVO;
import lecture.LectureBoardVO;
import lecture.LectureVO;
import member.MemberVO;

@RestController
public class LectureController {
	@Autowired @Qualifier("bteam") private SqlSession sql;
	
	
	@RequestMapping(value = "/stu_lecture_list.le", produces ="text/html;charset=UTF-8")
	public String stu_list(int id) {
		List<LectureVO> list = sql.selectList("lecture.stu_list", id);
	
		return new Gson().toJson(list);
	}
	
	@RequestMapping(value = "/teacher_lecture_list.le", produces ="text/html;charset=UTF-8")
	public String teach_list(int id) {
		List<LectureVO> list = sql.selectList("lecture.teach_list", id);
	
		return new Gson().toJson(list);
	}
	
	@RequestMapping(value = "/teacher_info.le", produces ="text/html;charset=UTF-8")
	public String teacher_info(int lecture_code) {
		MemberVO vo = sql.selectOne("lecture.teacher_info", lecture_code);
	
		return new Gson().toJson(vo);
	}
	
	@RequestMapping(value = "/lecture_notice.le", produces ="text/html;charset=UTF-8")
	public String lecture_notice(int lecture_code) {
		List<LectureBoardVO> list = sql.selectList("lecture.lecture_notice", lecture_code);
	
		return new Gson().toJson(list);
	}
	
	@RequestMapping(value = "/student_list.le", produces ="text/html;charset=UTF-8")
	public String student_list(int lecture_code) {
		List<MemberVO> list = sql.selectList("lecture.student_list", lecture_code);
		return new Gson().toJson(list);
	}
	
}