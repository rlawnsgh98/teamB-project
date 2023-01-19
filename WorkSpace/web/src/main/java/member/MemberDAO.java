package member;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

@Repository
public class MemberDAO implements MemberService {
	@Autowired @Qualifier("bteam") private SqlSession sql;
	
	@Override
	public int member_join(MemberVO vo) {
		return sql.insert("member.join", vo);
	}

	@Override
	public MemberVO member_login(HashMap<String, String> map) {
		return sql.selectOne("member.login", map);
	}

	@Override
	public MemberVO member_myInfo(String userid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int member_idCheck(String userid) {
		return sql.selectOne("member.idCheck", userid);
	}

	@Override
	public int member_myInfo_update(MemberVO vo) {
		return sql.update("member.myInfo_update", vo);
	}

	@Override
	public int member_delete(String userid) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<MemberVO> member_list() {
		return sql.selectList("member.list");
	}

	@Override
	public String member_salt(String userid) {
		return sql.selectOne("member.salt", userid);
	}

	@Override
	public String member_userid_email(MemberVO vo) {
		return sql.selectOne("member.userid_email", vo);
	}

	@Override
	public int member_password_update(MemberVO vo) {
		return sql.update("member.password_update", vo);
	}

}