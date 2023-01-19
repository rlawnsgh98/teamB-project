package lecture;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import vo.LectureVO;

@Service
public class LectureServiceImple  implements LectureService {

	@Autowired private LectureDAO dao;
	
	@Override
	public List<LectureVO> lecture_list(int member_code) {
		
		return dao.lecture_list(member_code);
	}

}
