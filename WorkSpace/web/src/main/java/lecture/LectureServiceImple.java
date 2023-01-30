package lecture;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import vo.AttendanceVO;
import vo.BoardVO;
import vo.QuestionVO;
import vo.ExamVO;
import vo.HomeworkSubmitVO;
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
	public List<LectureVO> lecture_list_teacher(int member_code) {
		return dao.lecture_list_teacher(member_code);
	}

	@Override
	public int insert_exam(ExamVO vo) {
		return dao.insert_exam(vo);
	}

	@Override
	public LectureVO lecture_info(int lecture_code) {
		return dao.lecture_info(lecture_code);
	}

	@Override
	public int exam_total_num(int lecture_code) {
		return dao.exam_total_num(lecture_code);
	}

	@Override
	public List<QuestionVO> question_list(int exam_code) {
		return dao.question_list(exam_code);
	}

	@Override
	public ExamVO exam_info(int exam_code) {
		return dao.exam_info(exam_code);
	}

	@Override
	public QuestionVO question_info(int no) {
		return dao.question_info(no);
	}

	@Override
	public int insert_question(QuestionVO vo) {
		return dao.insert_question(vo);
	}

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

	public List<LectureVO> te_lec_list(HashMap<String, String> tempMap) {
		return dao.te_lec_list(tempMap);
	}

	@Override
	public int open_new_lecture(LectureVO lecturevo) {
		return dao.open_new_lecture(lecturevo);
	}

	@Override
	public int modify_lecture(LectureVO lecturevo) {
		return dao.modify_lecture(lecturevo);
	}

	@Override
	public void delete_lecture(int lecture_code) {
		dao.delete_lecture(lecture_code);
	}

	@Override
	public List<LectureVO> lecture_code_list(int teacher_code) {
		return dao.lecture_code_list(teacher_code);
	}


	@Override
	public HomeworkSubmitVO homework_submit_info(HashMap<String, Object> map) {
		return dao.homework_submit_info(map);
	}
}
