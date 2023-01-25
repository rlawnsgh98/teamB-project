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
	
	// delete - 자유게시판 + 공지
	@RequestMapping("/delete.bo")
	public String board_delete(int board_code) {
//		service.board_delete(board_code);
		return "board/list";
	}
	
	// update 화면연결 - 자유게시판 + 공지
	@RequestMapping("/update.bo")
	public String board_update(int board_code, Model model) {
		model.addAttribute("vo", service.board_info(board_code));
		return "board/modify";
	}
	
	// 신규 게시글 화면 요청 - 공지
	@RequestMapping("/new.bo")
	public String new_board() {
		return "board/new";
	}
	// 신규 게시글 화면 요청 - 자유게시판
	@RequestMapping("/new.no")
	public String new_notice() {
		return "notice/new";
	}
	
	// 게시글 상세 정보 조회
	@RequestMapping("/info.bo")
	public String board_info(int board_code, Model model) {
		service.board_read(board_code); //조회수 증가처리
		model.addAttribute("info", service.board_info(board_code));		//BoardVO에 파일 정보도 담겨있음 -> DAO에서 setter처리
		model.addAttribute("reply", service.board_reply(board_code));	//댓글 목록
		return "board/info";
	}
	// 게시글 상세 정보 조회
	@RequestMapping("/info.no")
	public String notice_info(int board_code, Model model) {
		service.board_read(board_code); //조회수 증가처리
		model.addAttribute("info", service.board_info(board_code));		//BoardVO에 파일 정보도 담겨있음 -> DAO에서 setter처리
		model.addAttribute("reply", service.board_reply(board_code));	//댓글 목록
		return "notice/info";
	}
	
	// 공지사항 목록 조회 - 임시 10개 조회
	@RequestMapping("/list.no")
	public String notice_list(Model model, BoardPageVO page) {
		model.addAttribute("page", service.notice_list(page));
		return "notice/list";
	}
	
	// 자유게시판 목록 조회	- 임시로 10개만 조회함!
	@RequestMapping("/list.bo")
	public String board_list(Model model, BoardPageVO page) {
		model.addAttribute("page", service.board_list(page));
		return "board/list";
	}
	
}
