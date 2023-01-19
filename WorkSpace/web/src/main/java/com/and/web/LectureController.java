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
	@Autowired private LectureServiceImple service;
//	@Autowired private CommonService common;
	
	//학생이 수강중인 강의 리스트 조회
	@RequestMapping("/list.le")
	public String list(Model model, int member_code) {
		List<LectureVO> list = service.lecture_list(member_code);
		
		model.addAttribute("list", list);
		
		return "lecture/list";
	}
	
	//학생이 수강중인 강의 정보
	@RequestMapping("/lecture_home.le")
	public String lecture_home(HttpSession session, int lecture_code) {
		session.removeAttribute("lecture_info");
		//강사 정보
		MemberVO lecture_info = service.info(lecture_code);
		session.setAttribute("lecture_info", lecture_info);
		
		return "lecture/lecture_home";
	}
	
	//선택한 강의의 공지사항 리스트
	@RequestMapping("/notice_list.le")
	public String notice_list(Model model, int lecture_code) {
		//공지 리스트
		List<BoardVO> notice_list = service.notice_list(lecture_code);
		model.addAttribute("notice_list", notice_list);
		
		
		return "lecture/notice_list";
	}
	
	//공지사항 세부내용
	@RequestMapping("/notice_info.le")
	public String notice_info(Model model, int board_code) {
		
		BoardVO vo = service.notice_info(board_code);
		model.addAttribute("notice_info", vo);
		
		return "lecture/notice_info";
	}
	
	//학생이 수강중인 강의의 과제 리스트
	@RequestMapping("/homework_list.le")
	public String homework_list(Model model, int member_code, int lecture_code) {
		
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("member_code", member_code);
		map.put("lecture_code", lecture_code);
			
		List<HomeworkVO> list = service.homework_list(map);
		model.addAttribute("list", list);
			
		return "lecture/homework_list";
	}
	
	
	//학생이 수강중인 강의의 과제 리스트
	@RequestMapping("/homework_info.le")
	public String homework_info(Model model, int member_code, int homework_code) {
		
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("member_code", member_code);
		map.put("homework_code", homework_code);
			
		HomeworkVO vo = service.homework_info(map);
		model.addAttribute("info", vo);
			
		return "lecture/homework_info";
	}
	
	//수강중인 강의의 강의영상 리스트
	@RequestMapping("/video_list.le")
	public String video_list(Model model, int lecture_code) {
			
		List<BoardVO> list = service.video_list(lecture_code);
		model.addAttribute("video_list", list);
			
		return "lecture/video_list";
	}
	
	//영상강의 시청
	@RequestMapping("/video_watch.le")
	public String video_watch(Model model, int board_code) {
//			
//		List<BoardVO> vo = service.video_watch(board_code);
//		model.addAttribute("video_list", vo);
			
		return "lecture/video_watch";
	}
	
	//시험목록 조회
	@RequestMapping("/exam_list.le")
	public String exam_list(Model model, int lecture_code, int member_code) {
			
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("member_code", member_code);
		map.put("lecture_code", lecture_code);
		
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
	
		
}
