package com.and.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LectureController {
//	@Autowired private BoardServiceImpl service;
//	@Autowired private CommonService common;
	
	@RequestMapping("/list.le")
	public String list() {
		
		return "lecture/list";
	}
}