package member;

import java.util.HashMap;
import java.util.List;

import vo.MemberVO;

public interface MemberService { 					
	MemberVO member_login(HashMap<String, String> map); //로그인처리
	MemberVO member_myInfo(String userid); 				//내정보보기:마이페이지
}

