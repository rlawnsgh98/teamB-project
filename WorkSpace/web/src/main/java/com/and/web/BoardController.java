package com.and.web;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import board.BoardServiceImpl;
import common.CommonService;
import vo.BoardFileVO;
import vo.BoardPageVO;
import vo.BoardVO;

@Controller
public class BoardController {
	@Autowired private BoardServiceImpl service;
	@Autowired private CommonService common;
	
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
	
	//신규게시글 저장처리 - 자유게시판
	@RequestMapping("/insert.bo")
	public String insert_board(BoardVO vo, MultipartFile file[], HttpServletRequest req) {
		
		if( file.length > 1) {
			attachedFile(vo, file, req);
		}
		
		service.board_insert(vo);
		
		return "redirect:list.bo";
	}
	@RequestMapping(value="/download.bo")
	public String download(int file, String url, int board_code, BoardPageVO page, Model model
						, HttpServletRequest request
						, HttpServletResponse response) throws Exception{
		//선택한 파일정보를 DB에서 조회해온다
		BoardFileVO vo = service.board_file_info(file);
		
		//다운로드: 서버시스템의 물리적위치의 파일을 복사해서 클라이언트시스템에 저장한다
		boolean download 
		= common.fileDownload(vo.getFile_name(), vo.getPath(), request, response);
		
		if( download ) {
			model.addAttribute("url", "info.bo");
			model.addAttribute("page", page);
			model.addAttribute("board_code", board_code);
			model.addAttribute("download", true);
			return "board/redirect";
		}else {
			StringBuffer msg = new StringBuffer();
			msg.append("<script>"); 
			msg.append("alert('삭제할 파일이 없습니다!'); location='")
				.append(url).append("?board_code=").append(board_code).append("'"); 
			msg.append("</script>"); 
			return msg.toString();
		}
		
//		model.addAttribute("url", "info.bo");
//		model.addAttribute("page", page);
//		model.addAttribute("board_code", board_code);
//		model.addAttribute("download", true);
//		return "board/redirect";		
	}
	//파일첨부 메소드
	private void attachedFile(BoardVO vo, MultipartFile file[], HttpServletRequest req) {
		List<BoardFileVO> files = null;
		for( MultipartFile attached : file ) {
			if( attached.isEmpty() ) continue;
			if( files==null )files = new ArrayList<BoardFileVO>();
			
			BoardFileVO fileVO = new BoardFileVO();
			fileVO.setFile_name( attached.getOriginalFilename() );
			fileVO.setPath( common.fileUpload("board", attached, req) );
			files.add(fileVO);
		}
		vo.setFileList(files);
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
	
	// 공지사항 목록 조회
	@RequestMapping("/list.no")
	public String notice_list(Model model, BoardPageVO page) {
		model.addAttribute("page", service.notice_list(page));
		return "notice/list";
	}
	
	// 자유게시판 목록 조회
	@RequestMapping("/list.bo")
	public String board_list(Model model, BoardPageVO page) {
		model.addAttribute("page", service.board_list(page));
		return "board/list";
	}
	
}
