package exam;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import vo.ExamVO;

@Repository
public class ExamDAO implements ExamService {
	@Autowired @Qualifier("bteam") private SqlSession sql;
	
	@Override
	public int insert_exam(ExamVO vo) {
		// TODO Auto-generated method stub
		return 0;
	}

}
