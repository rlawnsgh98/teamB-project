package com.and.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import lecture.LectureServiceImple;
import vo.LectureVO;

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
	
	@RequestMapping("/info.le")
	public void info() {
		
	}
}
