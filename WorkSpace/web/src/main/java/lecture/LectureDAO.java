package lecture;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import vo.LectureVO;

@Repository
public class LectureDAO implements LectureService {
	@Autowired @Qualifier("bteam") private SqlSession sql;
	
	@Override
	public List<LectureVO> lecture_list(int member_code) {
		
		return sql.selectList("lecture.list", member_code);
	}

}
