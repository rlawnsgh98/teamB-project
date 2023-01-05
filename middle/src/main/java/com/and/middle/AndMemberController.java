package com.and.middle;
import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartRequest;

import com.google.gson.Gson;

import and_member.AndMemberVO;
import common.CommonService;

@RestController
public class AndMemberController {
	@Autowired @Qualifier("hanul") private SqlSession session;
	@RequestMapping(value = "/login.me", produces ="text/html;charset=UTF-8")	
	public String login_me(AndMemberVO vo) {
		AndMemberVO temp_vo = session.selectOne("me.login", vo);
		
		if(temp_vo != null) {
			System.out.println(temp_vo.getEmail());
		}else {
			System.out.println("로그인 실패");
		}
		return new Gson().toJson(temp_vo);
	}
	
	@RequestMapping(value = "/social.me", produces ="text/html;charset=UTF-8")	
	public String social_me(String email) {
		System.out.println(email);
		return new Gson().toJson("");
	}
	
	@Autowired CommonService common;
	
	@RequestMapping(value = "/join.me" , produces = "text/html;charset=utf-8")
	public String join(String param , HttpServletRequest req) {
		AndMemberVO vo = new Gson().fromJson(param, AndMemberVO.class);
		MultipartRequest mReq = (MultipartRequest) req;
		MultipartFile file = mReq.getFile("file");
		String imgPath = null;
		if(file !=null) {
			System.out.println(file.getOriginalFilename());
			System.out.println(file.getName());
			imgPath = common.fileUpload("and", file, req);
			vo.setFile_path(imgPath);
			System.out.println(imgPath);
		}
		int result = session.insert("me.join" , vo );
		return new Gson().toJson(result + "");
	}
}
