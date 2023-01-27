package lecture;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import vo.AttendanceVO;
import vo.BoardVO;
import vo.ExamVO;
import vo.HomeworkVO;
import vo.LectureVO;
import vo.MemberVO;

@Service
public class LectureServiceImple  implements LectureService {

	@Autowired private LectureDAO dao;
	
	@Override
	public List<LectureVO> lecture_list(int member_code) {
		
		return dao.lecture_list(member_code);
	}

	@Override
	public MemberVO info(int lecture_code) {
		return dao.info(lecture_code);
	}

	@Override
	public List<BoardVO> notice_list(int lecture_code) {
		return dao.notice_list(lecture_code);
	}

	@Override
	public BoardVO notice_info(int board_code) {
		return dao.notice_info(board_code);
	}

	@Override
	public List<HomeworkVO> homework_list(HashMap<String, Object> map) {
		return dao.homework_list(map);
	}

	@Override
	public HomeworkVO homework_info(HashMap<String, Object> map) {
		return dao.homework_info(map);
	}

	@Override
	public List<BoardVO> video_list(int lecture_code) {
		return dao.video_list(lecture_code);
	}

	@Override
	public List<ExamVO> exam_list(HashMap<String, Object> map) {
		return dao.exam_list(map);
	}

	@Override
	public List<MemberVO> student_list(int lecture_code) {
		return dao.student_list(lecture_code);
	}

	@Override
	public void notice_insert(BoardVO vo) {
		dao.notice_insert(vo);
	}

	@Override
	public void notice_update(BoardVO vo) {
		dao.notice_update(vo);
		
	}

	@Override
	public void homework_insert(HomeworkVO vo) {
		dao.homework_insert(vo);
	}

	@Override
	public List<HomeworkVO> teach_homework_list(int lecture_code) {
		return dao.teach_homework_list(lecture_code);
	}

	@Override
	public List<LectureVO> teacher_lecture_list(int member_code) {
		return dao.teacher_lecture_list(member_code);
	}

	@Override
	public List<AttendanceVO> attendance_list(HashMap<String, Object> map) {
		return dao.attendance_list(map);
	}

	@Override
	public void attendance_update(HashMap<String, Object> map) {
		dao.attendance_update(map);
	}

}
