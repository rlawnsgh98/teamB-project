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
	
	// 게시글 상세 정보 조회
	@RequestMapping("/info.bo")
	public String board_info(int board_code, Model model) {
		service.board_read(board_code); //조회수 증가처리
		model.addAttribute("info", service.board_info(board_code));		//BoardVO에 파일 정보도 담겨있음 -> DAO에서 setter처리
		model.addAttribute("reply", service.board_reply(board_code));	//댓글 목록
		return "board/info";
	}
	
	// 자유게시판 목록 조회	- 임시로 10개만 조회함!
	@RequestMapping("/list.bo")
	public String board_list(Model model, BoardPageVO page) {
		model.addAttribute("page", service.board_list(page));
		return "board/list";
	}
	
}
