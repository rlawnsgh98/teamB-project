package member;

import java.sql.Date;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class MemberVO {
	private String member_code, id, pw, member_name, gender
			, email, birth, phone, post, address
			, type, profilepath, salt;

}
