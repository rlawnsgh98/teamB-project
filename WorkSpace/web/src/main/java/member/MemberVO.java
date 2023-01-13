package member;

import java.sql.Date;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class MemberVO {
	private String id, pw, member_name, gender
			, email, birth, phone, post, address
			, type, profilepath, salt;

	private int member_code, lecture_code;
}
