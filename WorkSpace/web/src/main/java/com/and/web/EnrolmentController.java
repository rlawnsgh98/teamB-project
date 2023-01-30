package com.and.web;

import java.util.HashMap;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import enrolment.EnrolmentServiceImpl;
import vo.LectureVO;
import vo.MemberVO;

@Controller
public class EnrolmentController {
	@Autowired private EnrolmentServiceImpl service;

	// 수강신청 버튼 클릭 시 - kmj
	/*
	@RequestMapping("/enrollment_kt")
	public String enrollment_kt(HttpSession session) {
		MemberVO membervo = (MemberVO) session.getAttribute("loginInfo");
		int member_code = membervo.getMember_code();
		
		//LectureVO lecturevo = (LectureVO) session.getAttribute("te_lec_list");
		//int lecture_code = lecturevo.getLecture_code();
		
		HashMap<String, String> tempMap = new HashMap<String, String>();
		tempMap.put("member_code", Integer.toString(member_code));
		//tempMap.put("lecture_code", Integer.toString(lecture_code));
		
		int en_kt_cnt = service.enrolment_kt(tempMap);
		
		// 응답화면연결
		return "redirect:/";
	}
	*/
	
	// 수강신청 버튼 클릭 시 - kmj
	@RequestMapping("/en_lec_insert.le")
	public String enrollment_kt(String lecture_code , String member_code) {
		HashMap<String, String> tempMap = new HashMap<String, String>();
		tempMap.put("lecture_code", lecture_code);
		tempMap.put("member_code", member_code);
		if(member_code != null) {
			service.enrolment_kt(tempMap);
			return "redirect:/en_lec_detail.le?lecture_code="+lecture_code;
		}else {
			return "redirect:/en_lec_detail.le?lecture_code="+lecture_code;
		}
	}
}
