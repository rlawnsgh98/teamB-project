package com.and.middle;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartRequest;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import common.CommonService;
import vo.BoardFileVO;
import vo.BoardVO;
import vo.ReplyVO;

@RestController		// 안되면 spring-framework 버전 확인 (낮으면 안됨)
public class AndController {
	@Autowired @Qualifier("bteam") SqlSession sql;
	@Autowired @Qualifier("common") CommonService common;
	
	//new TypeToken<ArrayList<String>>(){}.getType()

	//신규 게시글(+첨부파일) 저장
	@RequestMapping(value="/insert.fi", produces = "text/html;charset=utf-8")
	public String insert_file(String param, HttpServletRequest req) {
		
		BoardVO vo = new Gson().fromJson(param, BoardVO.class);
		
		MultipartRequest mReq = (MultipartRequest) req;
		List<MultipartFile> fileList = mReq.getFiles("file");
		String imgPath = null;
		ArrayList<BoardFileVO> list = new ArrayList<>();
		
		for(int i = 0; i < fileList.size(); i++) {
			BoardFileVO f_vo = new BoardFileVO();
			MultipartFile file=  fileList.get(i); // getFiles 또는 getFileMap활용.
			System.out.println(file.getOriginalFilename());
			System.out.println(file.getName());
			f_vo.setFile_name(file.getOriginalFilename());
			imgPath = common.fileUpload("and", file, req);
			f_vo.setPath(imgPath);
			list.add(f_vo);
			
		}	
		vo.setFileList(list);
		
		int result = sql.insert("and.board_insert", vo);
		if(list.size() > 0) {
		
			sql.insert("and.file_insert", vo);
		}
		
		return result+"";
	}
//	//신규게시글 저장 
//	@RequestMapping(value="/insert.bo", produces = "text/html;charset=utf-8")
//	public int insert_board(String param) {
//		BoardVO vo = new Gson().fromJson(param, BoardVO.class);
//		int result = sql.insert("and.board_insert", vo);
//		return result;
//	}
	
	//파일첨부 메소드 - 참고
	public void attachedFile(BoardVO vo, MultipartFile file[], HttpServletRequest req) {
		ArrayList<BoardFileVO> files = null;
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
	
	// 강의영상 uri 조회
	@RequestMapping(value="/selectVideo", produces = "text/html;charset=utf-8")
	public String selectVideo(int board_code) {
		
		return sql.selectOne("and.selectVideo", board_code);
		
	}
	
	// 강의영상 insert	==> 웹
	
	// 강의영상 수정 ==> 웹
	
	// 강의영상 삭제
	@RequestMapping(value="/delete.vi", produces = "text/html;charset=utf-8")
	public int delete_video(int board_code) {
		int result = sql.delete("and.delete_video", board_code);
		return result;
	}
	
	// 특정 강의영상 정보 조회
	@RequestMapping(value="/info.vi", produces = "text/html;charset=utf-8")
	public String info_video(int board_code) {
		//조회수 증가처리
		sql.update("and.readcnt", board_code);
		return new GsonBuilder().setDateFormat("yyyy-MM-dd").create().toJson(sql.selectList("and.video_list", board_code));
	}
	
	// 강의영상 목록조회 -- 특정 강의 카테고리
	@RequestMapping(value="/list.vi", produces = "text/html;charset=utf-8")
	public String videoList(BoardVO vo) {	// cnt, category 묶으려고 BoardVO로 받음 -> 안드에서 담아서 보내기
		
		return new GsonBuilder().setDateFormat("yyyy-MM-dd").create().toJson(sql.selectList("and.video_list", vo));
	}
	
	// 댓글 삭제
	@RequestMapping("/delete.re")
	public int delete_reply(ReplyVO vo) {
		int result = sql.update("and.reply_delete", vo);
		return result;
	}
	
	// 댓글 수정
	@RequestMapping(value="/update.re", produces = "text/html;charset=utf-8")
	public int update_reply(ReplyVO vo) {
		int result = sql.update("and.reply_update", vo);
		return result;
	}
	
	// 댓글 insert
	@RequestMapping(value="/insert.re", produces = "text/html;charset=utf-8")
	public int insert_reply(ReplyVO vo) {
		int result = sql.insert("and.reply_insert", vo);
		return result;
	}
	
	// 댓글 조회
	@RequestMapping(value="/list.re", produces = "text/html;charset=utf-8")
	public String reply_list(int board_code, int cnt) {
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		map.put("board_code", board_code);
		map.put("cnt", cnt);
		return new GsonBuilder().setDateFormat("yyyy-MM-dd").create().toJson(sql.selectList("and.reply_list", map));
	}
	
	// 특정 게시판 조회
	@RequestMapping(value="/info.bo", produces = "text/html;charset=utf-8")
	public String board_info(int board_code) {
		
		sql.update("and.readcnt", board_code); //조회수 증가
		
		//특정 게시판 조회
		BoardVO vo = sql.selectOne("and.board_info", board_code);
		
		//해당 게시판의 파일정보 조회
		vo.setFileList( sql.selectList("and.file_info", board_code) ) ;
		
		return new GsonBuilder().setDateFormat("yyyy-MM-dd").create().toJson(vo);
	}
	
	// 자유게시판 검색
	@RequestMapping(value="/search.bo", produces = "text/html;charset=utf-8")
	public String search_board(String column, String search) {
		HashMap<String, String> map = new HashMap<>();
		map.put("column", column);
		map.put("search", search);
		
		List<BoardVO> list = sql.selectList("and.search_board", map);
		
		return new GsonBuilder().setDateFormat("yyyy-MM-dd").create().toJson(list);
	}
	
	// 자유게시판 update
	@RequestMapping(value="/update.bo", produces = "text/html;charset=utf-8")
	public int board_update(BoardVO vo) {
		int result = sql.update("and.board_update", vo);
		return result;
	}
	
	// 자유게시판 삭제
	@RequestMapping(value="/delete.bo", produces = "text/html;charset=utf-8")
	public int board_delete(int board_code) {
		int result = sql.delete("and.board_delete", board_code);
		return result;
	}
	
	// 자유게시판 신규 등록
	@RequestMapping(value="/insert.bo", produces = "text/html;charset=utf-8")
	public int board_insert(BoardVO vo) {
		int result = sql.insert("and.board_insert", vo);
		return result;
	}
	
	// 자유게시판 목록 조회
	@RequestMapping(value="/list.bo", produces = "text/html;charset=utf-8")
	public String and(int cnt) {
		
		return new GsonBuilder().setDateFormat("yyyy-MM-dd").create().toJson(sql.selectList("and.board_list", cnt));
	}
	
	// 자유게시판 남은 게시글 수 반환
	@RequestMapping(value="cal.bo", produces="text/html;charset=utf-8")
	public String cal_board(int cnt) {
		
		int boardCount = sql.selectOne("and.cal_board");
		
		return ( boardCount - (cnt*10) ) + "";
	}
	
	// 특정 게시글의 남은 댓글 수
	@RequestMapping(value="cal.re", produces="text/html;charset=utf-8")
	public String cal_reply(int cnt, int board_code) {
		
		int boardCount = sql.selectOne("and.cal_reply", board_code);
		
		return ( boardCount - (cnt*10) ) + "";
	}
	
	// 강의영상 남은 게시글 수 반환
	@RequestMapping(value="cal.vi", produces="text/html;charset=utf-8")
	public String cal_video(int cnt, String category) {
		
		int boardCount = sql.selectOne("and.cal_video", category);
		
		return ( boardCount - (cnt*10) ) + "";
	}
	
	
	
	
	
	@RequestMapping(value="/andVO", produces = "text/html;charset=utf-8")
	public String andVo() {
		System.out.println("ddd");
//		List<CustomerVO> list = sql.selectList("and.list");
		
		
		return "lastTest";
	}
	
}
