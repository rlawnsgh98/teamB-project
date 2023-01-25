package com.and.web;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import common.CommonService;
import member.MemberService;
import vo.MemberVO;

@Controller
public class MemberController {
	@Autowired
	private CommonService common;
	@Autowired
	private MemberService member;

	// 회원 가입 화면 요청
	@RequestMapping("/member.me")
	public String member(HttpSession session) {
		session.setAttribute("category", "join");
		// 응답화면연결
		return "member/join";
	}

	// 회원 가입 처리 요청
	@ResponseBody
	@RequestMapping(value = "/join.me")
	public String join(MemberVO vo, MultipartFile profile_image, HttpServletRequest request) {
		// 첨부된 프로필 파일이 있는 경우
		if (!profile_image.isEmpty()) {
			// 서버의 물리적영역에 첨부파일을 저장한 후 DB에 저장할 수 있도록 처리한다
			vo.setProfilepath(common.fileUpload("profilepath", profile_image, request));
		}
		// 화면에서 입력한 정보를 DB에 신규저장한다
		StringBuffer msg = new StringBuffer("<script>");
		if (member.member_join(vo) == 1) {
			msg.append("alert('회원가입을 축하합니다 ^^'); location='").append(request.getContextPath()).append("'; ");
		} else {
			msg.append("alert('회원가입 실패ㅠㅠ'); history.go(-1); ");
		}
		msg.append("</script>");

		// 응답화면연결
		return msg.toString();
	}

	// 로그인 화면 요청
	@RequestMapping("/login.me")
	public String login(HttpSession session) {
		session.setAttribute("category", "login");
		// 응답화면연결
		return "member/login";
	}

	// 로그인 처리 요청
	@ResponseBody
	@RequestMapping("/smartLogin.me")
	public boolean login(String id, String pw, HttpSession session) {
		// 비지니스로직 - 화면에서 입력한 아이디/비번이 일치하는 회원정보를 DB에서 조회한다
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("id", id);
		map.put("pw", pw);
		MemberVO vo = member.member_login(map);

		// 화면에 출력할 수 있도록 세션에 attribute로 담는다
		session.setAttribute("loginInfo", vo);
		return vo == null ? false : true;
	}

	// 로그아웃 처리 요청
	@RequestMapping("/logout.me")
	public String logout(HttpSession session) {
		// 비지니스로직 - 세션에 있는 로그인정보를 삭제한다
		session.removeAttribute("loginInfo");
		// 응답화면연결
		return "redirect:/";
	}

	// 아이디 중복확인 요청
	@ResponseBody
	@RequestMapping("/idCheck.me")
	public boolean idcheck(String id) {
		// 비지니스로직-화면에서 입력한 아이디가 DB에 존재하는지 확인: 0 아이디 존재X, 1 아이디 존재
		return member.member_idCheck(id) == 0 ? false : true;
	}

	// 마이 페이지 화면 요청
	@RequestMapping("/mypage.me")
	public String mypage(HttpSession session) {
		// 응답화면연결
		return "member/mypage";
	}

	// 회원 정보 수정 화면 요청 - 개인정보수정
	@RequestMapping("/modify_verify.me")
	public String modify_verify(HttpSession session) {
		// 응답화면연결
		return "member/modify_verify";
	}

	// 회원 정보 수정 화면 요청 - 비밀번호변경
	@RequestMapping("/modify_pw.me")
	public String modify_pw(HttpSession session) {
		// 응답화면연결
		return "member/modify_pw";
	}

	// 회원 정보 수정 화면 요청 - 수정 양식 작성창
	@RequestMapping("/modify_myinfo.me")
	public String modify_myinfo(HttpSession session) {
		// 응답화면연결
		return "member/modify_myinfo";
	}

	// 회원 정보 수정 화면 요청
	@RequestMapping("/enrolment_log.me")
	public String enrolment_log(HttpSession session) {
		// 응답화면연결
		return "member/enrolment_log";
	}

	// 회원 아이디/비밀번호 찾기 화면 요청
	@RequestMapping("/find.me")
	public String find(HttpSession session) {
		// 응답화면연결
		return "member/find";
	}
}
