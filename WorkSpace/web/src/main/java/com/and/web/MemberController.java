package com.and.web;

import java.util.HashMap;
import java.util.UUID;

import javax.print.DocFlavor.READER;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import common.CommonService;
import member.MemberServiceImple;
import vo.MemberVO;

@Controller
public class MemberController {
	@Autowired private MemberServiceImple service;

	//로그아웃 요청
	@RequestMapping("/logout")
	public String logout(HttpSession session) {
		//비지니스 로직 - 세션에 있는 로그인 정보를 비운다
		session.removeAttribute("loginInfo");
		//응답화면 연결
		return "redirect:/"; 
	}
	
	//로그인처리 요청
	@ResponseBody @RequestMapping("/webLogin")
	public boolean weblogin(HttpSession session) {
		
		String id = "id";
		String pw = "pw";
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("id", id);
		map.put("pw", pw);
		MemberVO vo = service.member_login(map);
		
		// 화면에 출력할 수 있도록 세션에 attribute로 담는다
		session.setAttribute("loginInfo", vo);
		return vo==null? false : true;
	}
	

	//로그인할 화면 요청
	@RequestMapping("/login")
	public String login(HttpSession session) {
		session.setAttribute("category", "login");
		return "default/member/login";
	}
}
