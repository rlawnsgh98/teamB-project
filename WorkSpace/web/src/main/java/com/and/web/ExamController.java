package com.and.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import board.BoardServiceImpl;

@Controller
public class ExamController {

	@Autowired private BoardServiceImpl service;
	
	// 시험 등록 - 화면 연결
	@RequestMapping("/new.ex")
	public String new_exam() {
		return "exam/new";
	}
	
}
