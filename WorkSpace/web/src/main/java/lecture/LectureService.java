package lecture;

import java.util.List;

import vo.LectureVO;

public interface LectureService {
	List<LectureVO> lecture_list(int member_code);
}
