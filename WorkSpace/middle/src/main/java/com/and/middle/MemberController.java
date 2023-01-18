package com.and.middle;

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

import common.CommonService;
import vo.BoardVO;
import vo.EnrolmentVO;
import vo.MemberVO;

@RestController
public class MemberController {
	@Autowired @Qualifier("bteam") private SqlSession sql;

	
	// http://localhost/smart/login1.mj?id=user3&pw=000aA
	// WiFi : hanul202 _ http://192.168.0.8/smart/login1.mj?id=user3&pw=000aA
	// Spring을 연 곳이 서버 _ 202호 컴퓨터 _ 192.168.0.122로 안드로이드 ip 설정
	// http://192.168.0.122/smart/login1.mj?id=user3&pw=000aA
	
	@Autowired @Qualifier("bteam") private SqlSession session;
	@Autowired CommonService common;
	// Spring을 연 곳이 서버 _ 202호 컴퓨터 _ 192.168.0.122로 안드로이드 ip 설정
	// http://192.168.0.122/smart/login.mj?id=user3&pw=000aA
	// 로그인
	@RequestMapping(value = "/login.mj", produces ="text/html;charset=UTF-8")
	public String login(String id, String pw) {
		HashMap<String,String> map = new HashMap<String, String>();
		map.put("id", id);
		map.put("pw", pw);
		
		MemberVO member = session.selectOne("member.login", map);
		if(member != null) {
			System.out.println("==로그인 성공==");
			System.out.println("id:" + member.getId());
			System.out.println("type:" + member.getType());
			System.out.println("name:" + member.getMember_name());
			System.out.println("email:" + member.getEmail());
		}else {
			System.out.println("==로그인 실패==");
		}		
		
		return new GsonBuilder().setDateFormat("yyyy-MM-dd").create().toJson(member);
	}
	
	// 회원가입
	@RequestMapping(value = "/join.mj", produces ="text/html;charset=utf-8")
	public String join(String member) {
		MemberVO vo = new GsonBuilder().setDateFormat("yyyy-MM-dd").create().fromJson(member,MemberVO.class);
		session.insert("member.join",vo);
		
		if(vo != null) {
			System.out.println("==회원가입 성공==");
			System.out.println("id:" + vo.getId());
			System.out.println("type:" + vo.getType());
			System.out.println("name:" + vo.getMember_name());
			System.out.println("email:" + vo.getEmail());
		}else {
			System.out.println("==회원가입 실패==");
		}	
		
		return new GsonBuilder().setDateFormat("yyyy-MM-dd").create().toJson(vo);
	}
	
	// 특정 강사인 회원의 일주일 시간표
	@RequestMapping(value = "/ttlist.mj", produces ="text/html;charset=utf-8")
	public String ttlist(int teacher_code) {
		List<EnrolmentVO> ttlist = session.selectList("lecture.list",teacher_code);
		
		return new Gson().toJson(ttlist);
	}
	
	// board 날짜별 정보 조회
	@RequestMapping(value = "/aclist.mj", produces ="text/html;charset=utf-8")
	public String aclist(String writedate) {
		List<BoardVO> aclist = session.selectList("board.list",writedate);
		
		return new GsonBuilder().setDateFormat("yyyy-MM-dd").create().toJson(aclist);
	}
	
	// 특정 학생인 회원의 일주일 시간표
	@RequestMapping(value = "/st_ttlist.mj", produces ="text/html;charset=utf-8")
	public String st_ttlist(int member_code) {
		List<EnrolmentVO> st_ttlist = session.selectList("lecture.st_list",member_code);
		
		return new Gson().toJson(st_ttlist);
	}
	
	// idcnt = 아이디 중복 확인(존재x = 0, 존재o = 1)
	// idCheck = 사용가능 5 / 사용불가능 -1  
	@RequestMapping(value = "/idCheck.mj", produces ="text/html;charset=utf-8")
	public String idCheck(String id) {
		int idcnt = session.selectOne("member.idCheck", id);
		System.out.println("idcnt = " + idcnt);
		int idCheck;
		if(idcnt == 0) {
			idCheck = 5;
			return new Gson().toJson(idCheck);
		}else if(idcnt >= 1) {
			idCheck = -1;
			return new Gson().toJson(idCheck);
		}else {
			idCheck = -1;
			return new Gson().toJson(idCheck);
		}
	}
	
	//나의 정보 조회
	@RequestMapping(value = "/my_info.mj", produces ="text/html;charset=utf-8")
	public String my_info(String id) {
		MemberVO member = session.selectOne("member.my_info", id);

		return new GsonBuilder().setDateFormat("yyyy-MM-dd").create().toJson(member);
	}
	
	//내 정보 조회
	@RequestMapping(value = "/my_info_code", produces ="text/html;charset=utf-8")
	public String my_info(int member_code) {
		MemberVO member = session.selectOne("member.my_info_code", member_code);
		return new GsonBuilder().setDateFormat("yyyy-MM-dd").create().toJson(member);
	}
	
	//나의 정보 수정
	@RequestMapping(value = "/modify_my_info.mj", produces ="text/html;charset=utf-8")
	public String modify_my_info(String param, HttpServletRequest reqest) {
		MemberVO modify_member = new Gson().fromJson(param, MemberVO.class);
		MultipartRequest mReq = (MultipartRequest) reqest;
		MultipartFile file = mReq.getFile("file");
		String imgPath = null;
		if(file !=null) {
			System.out.println(file.getOriginalFilename());
			System.out.println(file.getName());
			imgPath = common.fileUpload("and", file, reqest);
			modify_member.setProfilepath(imgPath);
			System.out.println(imgPath);
		}
		int result = session.update("member.modify_my_info",modify_member);
		
		if(result > 0) {
			System.out.println("==회원 정보 수정 성공==");

		}else {
			System.out.println("==회원 정보 수정 실패==");
		}
	
		return new Gson().toJson(modify_member);
	}
	
}
