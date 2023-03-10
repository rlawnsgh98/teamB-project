package com.and.middle;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import vo.BoardVO;
import vo.LectureVO;

@RestController
public class BoardController {
	@Autowired @Qualifier("bteam") private SqlSession sql;
	
	@RequestMapping(value = "/notice_list.bo", produces ="text/html;charset=UTF-8")
	public String list() {
		List<BoardVO> list = sql.selectList("board.notice_list");
		
		return new GsonBuilder().setDateFormat("yyyy-MM-dd").create().toJson(list);
	}
	
}
