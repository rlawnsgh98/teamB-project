package com.and.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import board.BoardServiceImpl;
import vo.BoardPageVO;

@Controller
public class BoardController {
	@Autowired private BoardServiceImpl service;
	
	@RequestMapping("/list.bo")
	public String board_list(Model model, BoardPageVO page) {
		model.addAttribute("page", service.board_list(page));
		return "board/list";
	}
	
}
