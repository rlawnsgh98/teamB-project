package enrolment;

import java.util.HashMap;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;


@Repository
public class EnrolmentDAO implements EnrolmentService{
	@Autowired @Qualifier("bteam") private SqlSession sql;
	
	@Override
	public int enrolment_kt(HashMap<String, String> tempMap) {
		return sql.insert("enrolment.enrolment_kt", tempMap);
	}
}
