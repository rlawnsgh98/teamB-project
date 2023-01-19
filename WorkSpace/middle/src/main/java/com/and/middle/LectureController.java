package com.and.middle;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import vo.AttendanceVO;
import vo.ExamVO;
import vo.HomeworkSubmitVO;
import vo.HomeworkVO;
import vo.LectureBoardVO;
import vo.LectureVO;
import vo.MemberVO;

@RestController
public class LectureController {
	@Autowired @Qualifier("bteam") private SqlSession sql;
	
	//학생이 시간표 조회
	@RequestMapping(value = "/student_timetable", produces ="text/html;charset=UTF-8")
	public String student_timetable(String vo) {
		MemberVO member = new Gson().fromJson(vo, MemberVO.class);
		List<LectureVO> list = sql.selectList("and.student_timetable", member);
		return new GsonBuilder().setDateFormat("yyyy-MM-dd").create().toJson(list);
	}
	
	//선생이 시간표 조회
	@RequestMapping(value = "/teacher_timetable", produces ="text/html;charset=UTF-8")
	public String teacher_timetable(String vo) {
		MemberVO member = new Gson().fromJson(vo, MemberVO.class);
		List<LectureVO> list = sql.selectList("and.teacher_timetable", member);
		return new GsonBuilder().setDateFormat("yyyy-MM-dd").create().toJson(list);
	}
	
	//특정 강의 정보 조회
	@RequestMapping(value = "/lecture_info", produces ="text/html;charset=UTF-8")
	public String lecture_info(int lecture_code) {
		LectureVO vo = sql.selectOne("lecture.lecture_info", lecture_code);
		return new GsonBuilder().setDateFormat("yyyy-MM-dd").create().toJson(vo);
	}
	
	//학생 홈 -> 내강의조회 -> 학생이 수강중인 강의목록 조회
	@RequestMapping(value = "/stu_lecture_list.le", produces ="text/html;charset=UTF-8")
	public String stu_list(int id) {
		List<LectureVO> list = sql.selectList("lecture.stu_list", id);
	
		return new Gson().toJson(list);
	}
	//강사 홈 -> 내강의조회 -> 강사가 강의중인 강의목록 조회
	@RequestMapping(value = "/teacher_lecture_list.le", produces ="text/html;charset=UTF-8")
	public String teach_list(String id) {
		List<LectureVO> list = sql.selectList("lecture.teach_list", id);
	
		return new Gson().toJson(list);
	}
	//선택한 강의의 강사 정보 조회
	@RequestMapping(value = "/teacher_info.le", produces ="text/html;charset=UTF-8")
	public String teacher_info(int lecture_code) {
		MemberVO vo = sql.selectOne("lecture.teacher_info", lecture_code);
	
		return new Gson().toJson(vo);
	}

	//선택한 강의의 공지사항 조회
	@RequestMapping(value = "/lecture_notice.le", produces ="text/html;charset=UTF-8")
	public String lecture_notice(int lecture_code) {
		List<LectureBoardVO> list = sql.selectList("lecture.lecture_notice", lecture_code);

		return new GsonBuilder().setDateFormat("yyyy-MM-dd").create().toJson(list);
	}
	//선택한 강의의 학생목록 조회
	@RequestMapping(value = "/student_list.le", produces ="text/html;charset=UTF-8")
	public String student_list(int lecture_code) {
		
		List<MemberVO> list = sql.selectList("lecture.student_list", lecture_code);
		return new Gson().toJson(list);
	}
	
	//강의 선택 -> 학생선택 -> 출결조회
	@RequestMapping(value = "/student_attendance.le", produces ="text/html;charset=UTF-8")
	public String student_addtendance(int lecture_code, int member_code) {
		
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("member_code", member_code);
		map.put("lecture_code", lecture_code);
		
		AttendanceVO vo = sql.selectOne("lecture.student_attendance", map);
		return new GsonBuilder().setDateFormat("yyyy-MM-dd").create().toJson(vo);
	}
	
	//강의선택 -> 과제
	@RequestMapping(value = "/lecture_homework.le", produces ="text/html;charset=UTF-8")
	public String lecture_homework(int lecture_code) {
			
		List<HomeworkVO> list = sql.selectList("lecture.lecture_homework", lecture_code);
		return new GsonBuilder().setDateFormat("yyyy-MM-dd").create().toJson(list);
	}
	
	@RequestMapping(value = "/homework_subcnt.le", produces ="text/html;charset=UTF-8")
	public String homework_subcnt(int homework_code) {
			
		HomeworkSubmitVO vo = sql.selectOne("lecture.homework_subcnt", homework_code);
		return new GsonBuilder().setDateFormat("yyyy-MM-dd").create().toJson(vo);
	}
	
	
	//강의 선택 -> 학생선택 -> 과제
		@RequestMapping(value = "/student_homework.le", produces ="text/html;charset=UTF-8")
		public String student_homework(int lecture_code, int member_code) {
			
			HashMap<String, Object> map = new HashMap<String, Object>();
			map.put("member_code", member_code);
			map.put("lecture_code", lecture_code);
			
			List<HomeworkVO> list = sql.selectList("lecture.student_homework", map);
			return new GsonBuilder().setDateFormat("yyyy-MM-dd").create().toJson(list);
		}
		
		//강의선택->학생선택->학생의 출결 리스트 조회 ->한달 끊어서
		@RequestMapping(value = "/student_attendance_detail.le", produces ="text/html;charset=UTF-8")
		public String student_attendance_detail(int lecture_code, int member_code, String start, String end) {
			
			HashMap<String, Object> map = new HashMap<String, Object>();
			map.put("member_code", member_code);
			map.put("lecture_code", lecture_code);
			map.put("start", start);
			map.put("end", end);
			
			List<AttendanceVO> list = sql.selectList("lecture.student_attendance_detail", map);
			return new GsonBuilder().setDateFormat("yyyy-MM-dd").create().toJson(list);
		}
		
		//강의선택->학생선택->시험성적 조회
		@RequestMapping(value = "/student_exam.le", produces ="text/html;charset=UTF-8")
		public String student_exam(int lecture_code, String member_code) {
			
			HashMap<String, Object> map = new HashMap<String, Object>();
			map.put("member_code", member_code);
			map.put("lecture_code", lecture_code);
			
			List<ExamVO> list = sql.selectList("lecture.student_exam", map);
			return new GsonBuilder().setDateFormat("yyyy-MM-dd").create().toJson(list);
		}
		
		//회원 상세정보
	    @RequestMapping(value = "/member_info", produces ="text/html;charset=UTF-8")
	    public String student_info(int member_code) {
	        MemberVO vo = sql.selectOne("lecture.member_info", member_code);

	        return new Gson().toJson(vo);
	    }
	    
	    
		
}
