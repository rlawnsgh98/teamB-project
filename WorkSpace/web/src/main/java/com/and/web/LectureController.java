package com.and.web;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import lecture.LectureServiceImple;
import vo.BoardVO;
import vo.ExamVO;
import vo.HomeworkVO;
import vo.LectureVO;
import vo.MemberVO;

@Controller
public class LectureController {
	@Autowired
	private LectureServiceImple service;
//	@Autowired private CommonService common;

	// 강의 목록 조회 - 강사 (주소창으로만 접근)
	@RequestMapping("/list.teacher")
	public String lecture_list_teacher(Model model, int member_code, HttpSession session) {
		
		List<LectureVO> list = service.lecture_list_teacher(member_code);
		model.addAttribute("list", list);

		return "lecture/list_teacher";
	}
	
	// 학생이 수강중인 강의 리스트 조회
	@RequestMapping("/list.le")
	public String list(Model model, int member_code, HttpSession session) {
		
		List<LectureVO> list = service.lecture_list(member_code);
		model.addAttribute("list", list);

		return "lecture/list";
	}

	// 학생이 수강중인 강의 정보
	@RequestMapping("/lecture_home.le")
	public String lecture_home(HttpSession session, int lecture_code) {
		session.removeAttribute("lecture");
		session.removeAttribute("lecture_info");
		// 강사 정보
		MemberVO lecture_info = service.info(lecture_code);
		LectureVO lecture = service.lecture_info(lecture_code);
		session.setAttribute("lecture_info", lecture_info);
		session.setAttribute("lecture", lecture);

		return "lecture/lecture_home";
	}

	// 선택한 강의의 공지사항 리스트
	@RequestMapping("/notice_list.le")
	public String notice_list(Model model, int lecture_code) {
		// 공지 리스트
		List<BoardVO> notice_list = service.notice_list(lecture_code);
		model.addAttribute("notice_list", notice_list);

		return "lecture/notice_list";
	}

	// 공지사항 세부내용
	@RequestMapping("/notice_info.le")
	public String notice_info(Model model, int board_code) {

		BoardVO vo = service.notice_info(board_code);
		model.addAttribute("notice_info", vo);

		return "lecture/notice_info";
	}

	// 학생이 수강중인 강의의 과제 리스트
	@RequestMapping("/homework_list.le")
	public String homework_list(Model model, int member_code, int lecture_code) {

		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("member_code", member_code);
		map.put("lecture_code", lecture_code);

		List<HomeworkVO> list = service.homework_list(map);
		model.addAttribute("list", list);

		return "lecture/homework_list";
	}

	// 학생이 수강중인 강의의 과제 리스트
	@RequestMapping("/homework_info.le")
	public String homework_info(Model model, int member_code, int homework_code) {

		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("member_code", member_code);
		map.put("homework_code", homework_code);

		HomeworkVO vo = service.homework_info(map);
		model.addAttribute("info", vo);

		return "lecture/homework_info";
	}

	// 수강중인 강의의 강의영상 리스트
	@RequestMapping("/video_list.le")
	public String video_list(Model model, int lecture_code) {

		List<BoardVO> list = service.video_list(lecture_code);
		model.addAttribute("video_list", list);

		return "lecture/video_list";
	}

	// 영상강의 시청
	@RequestMapping("/video_watch.le")
	public String video_watch(Model model, int board_code) {
//			
//		List<BoardVO> vo = service.video_watch(board_code);
//		model.addAttribute("video_list", vo);

		return "lecture/video_watch";
	}

	// 시험목록 조회
	@RequestMapping("/exam_list.le")
	public String exam_list(Model model, HttpSession session) {

		HashMap<String, Object> map = new HashMap<String, Object>();
		MemberVO member = (MemberVO) session.getAttribute("loginInfo");
		LectureVO lecture = (LectureVO) session.getAttribute("lecture");
		map.put("member_code", member.getMember_code());
		map.put("lecture_code", lecture.getLecture_code());

		List<ExamVO> list = service.exam_list(map);
		model.addAttribute("exam_list", list);

		return "lecture/exam_list";
	}

	@RequestMapping("/exam_take.le")
	public String exam_take() {

//		HashMap<String, Object> map = new HashMap<String, Object>();
//		map.put("member_code", member_code);
//		map.put("lecture_code", lecture_code);

//		List<ExamVO> list = service.exam_list(map);
//		model.addAttribute("exam_list", list);

		return "lecture/exam_take";
	}
	
	//과제 제출
		@RequestMapping("/homework_submit.le")
		public String homework_submit() {
				

				
			return "lecture/homework_submit";
		}
		
	//과제 수정
	@RequestMapping("/homework_modify.le")
	public String homework_modify() {
				

				
		return "lecture/homework_modify";
	}	
	
	
	
	//////////////////////////////선생//////////////////////////
	
	//공지작성
	@RequestMapping("/notice_write.le")
	public String notice_write() {
				

				
		return "lecture/notice_write";
	}
	
	//영상 등록
	@RequestMapping("/video_new.le")
	public String video_new() {
				

				
		return "lecture/video_new";
	}	
	//과제 등록
	@RequestMapping("/homework_new.le")
	public String homework_new() {
		
		
		
		return "lecture/homework_new";
	}	
	
	//시험 등록화면 요청
	@RequestMapping("/exam_new.le")
	public String exam_new() {
		return "lecture/exam_new";
	}	
	//시험 등록화면 요청
	@RequestMapping("/exam_insert.le")
	public String exam_insert(ExamVO vo) {
		
		return "redirect:exam_list.le";
	}
	
	//시험문제 추가
	@RequestMapping("/exam_question_new.le")
	public String exam_question_new() {
		
		
		
		return "lecture/exam_question_new";
	}	
	
	//학생리스트 조회
	@RequestMapping("/student_list.le")
	public String student_list(Model model, int lecture_code) {
		
		List<MemberVO> list = service.student_list(lecture_code);
		model.addAttribute("student_list", list);
		
		return "lecture/student_list";
	}	
	
	//수강생 출결 관리
	@RequestMapping("/attendance_manage.le")
	public String attendance_manage(Model model, int lecture_code) {
		
		List<MemberVO> list = service.student_list(lecture_code);
		model.addAttribute("student_list", list);
		
		return "lecture/attendance_manage";
	}
	
	
	
	
	
	
	

	// 강의 개설 화면
	@RequestMapping("/open_lecture.le")
	public String open_lecture(HttpSession session) {
		// 응답화면연결
		return "lecture/open_lecture";
	}

	// 수강 - 강의 목록 화면 - 갤러리형
	@RequestMapping("/gallery_list.le")
	public String lec_list_test(HttpSession session) {
		// 응답화면연결
		return "lecture/gallery_list";
	}

	// 수강 - 강의 목록 화면 - 리스트형
	@RequestMapping("/just_list.le")
	public String lec_list_test2(HttpSession session) {
		// 응답화면연결
		return "lecture/just_list";
	}

	// 수강 신청 버튼 클릭 시 
	@RequestMapping("/en_lec_detail.le")
	public String en_lec_detail(HttpSession session) {
		// 응답화면연결
		return "lecture/en_lec_detail";
	}

}