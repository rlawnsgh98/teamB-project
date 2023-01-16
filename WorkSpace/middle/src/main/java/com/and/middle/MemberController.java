package com.and.middle;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;

import member.MemberVO;

@RestController
public class MemberController {
	@Autowired @Qualifier("bteam") private SqlSession sql;

	
	// http://localhost/smart/login1.mj?id=user3&pw=000aA
	// WiFi : hanul202 _ http://192.168.0.8/smart/login1.mj?id=user3&pw=000aA
	// Spring을 연 곳이 서버 _ 202호 컴퓨터 _ 192.168.0.122로 안드로이드 ip 설정
	// http://192.168.0.122/smart/login1.mj?id=user3&pw=000aA
	
	
	@RequestMapping(value = "/login", produces ="text/html;charset=UTF-8")
	public String login1(String id, String pw) {
		HashMap<String,String> map = new HashMap<String, String>();
		map.put("id", id);
		map.put("pw", pw);
		
		System.out.println("ddd");
		MemberVO member = sql.selectOne("member.login", map);
		return new Gson().toJson(member);
	}

	@RequestMapping(value = "/join.mj", produces ="text/html;charset=utf-8")
	public String join(String param) {
		System.out.println(param);
		MemberVO vo = new Gson().fromJson(param, MemberVO.class);
		int result = sql.insert("lms.join",vo);
		
		return new Gson().toJson(result + "");
	}
	
	//회원 상세정보
	@RequestMapping(value = "/member_info", produces ="text/html;charset=UTF-8")
	public String student_info(int member_code) {
		MemberVO vo = sql.selectOne("member.member_info", member_code);
	
		return new Gson().toJson(vo);
	}
	
	/*
	 * insert into member(member_code,id,pw,member_name,gender
	 * ,email,birth,phone,type) values(SEQ_MEMBER.nextval,'minju','1234A','kmj','여'
	 * ,'yd5726@naver.com','97/11/13','010.9797.1234','TEACH');
	 */
}
