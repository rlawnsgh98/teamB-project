package exam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import vo.ExamVO;

@Service
public class ExamServiceImpl implements ExamService {
	@Autowired private ExamDAO dao;
	
	@Override
	public int insert_exam(ExamVO vo) {
		// TODO Auto-generated method stub
		return 0;
	}

}
