package member;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("member")
public class MemberServiceImpl implements MemberService {
	@Autowired private MemberDAO dao;
	
	@Override
	public int member_join(MemberVO vo) {
		return dao.member_join(vo);
	}

	@Override
	public MemberVO member_login(HashMap<String, String> map) {
		return dao.member_login(map);
	}

	@Override
	public MemberVO member_myInfo(String userid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int member_idCheck(String userid) {
		return dao.member_idCheck(userid);
	}

	@Override
	public int member_myInfo_update(MemberVO vo) {
		return dao.member_myInfo_update(vo);
	}

	@Override
	public int member_delete(String userid) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<MemberVO> member_list() {
		return dao.member_list();
	}

	@Override
	public String member_salt(String userid) {
		return dao.member_salt(userid);
	}

	@Override
	public String member_userid_email(MemberVO vo) {
		return dao.member_userid_email(vo);
	}

	@Override
	public int member_password_update(MemberVO vo) {
		return dao.member_password_update(vo);
	}

}
