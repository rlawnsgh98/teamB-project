package lecture;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import vo.AttendanceVO;
import vo.BoardVO;
import vo.QuestionVO;
import vo.ExamVO;
import vo.HomeworkSubmitVO;
import vo.HomeworkVO;
import vo.LectureVO;
import vo.MemberVO;

@Repository
public class LectureDAO implements LectureService {
	@Autowired @Qualifier("bteam") private SqlSession sql;
	
	@Override
	public List<LectureVO> lecture_list(int member_code) {
		
		return sql.selectList("lecture.list", member_code);
	}

	@Override
	public MemberVO info(int lecture_code) {
		return sql.selectOne("lecture.info",lecture_code);
	}

	@Override
	public List<BoardVO> notice_list(int lecture_code) {
		return sql.selectList("lecture.notice_list", lecture_code);
	}

	@Override
	public BoardVO notice_info(int board_code) {
		return sql.selectOne("lecture.notice_info", board_code);
	}

	@Override
	public List<HomeworkVO> homework_list(HashMap<String, Object> map) {
		return sql.selectList("lecture.homework_list", map);
	}

	@Override
	public HomeworkVO homework_info(HashMap<String, Object> map) {
		return sql.selectOne("lecture.homework_info",map);
	}

	@Override
	public List<BoardVO> video_list(int lecture_code) {
		return sql.selectList("lecture.video_list", lecture_code);
	}

	@Override
	public List<ExamVO> exam_list(HashMap<String, Object> map) {
		List<ExamVO> list = null;
		if(map.get("type").equals("STUD")) list = sql.selectList("lecture.exam_list", map);
		else {
			list = sql.selectList("lecture.exam_list_teacher", map);
		}
		return list;
	}

	@Override
	public List<MemberVO> student_list(int lecture_code) {
		return sql.selectList("student_list", lecture_code);	//mapper name 넣어야할듯
	}

	@Override
	public List<LectureVO> lecture_list_teacher(int member_code) {
		return sql.selectList("lecture.lecture_list_teacher", member_code);
	}

	@Override
	public int insert_exam(ExamVO vo) {
		return sql.insert("lecture.insert_exam", vo);
	}

	@Override
	public LectureVO lecture_info(int lecture_code) {
		return sql.selectOne("lecture.lecture_info", lecture_code);
	}

	@Override
	public int exam_total_num(int lecture_code) {
		return sql.selectOne("lecture.exam_total_num", lecture_code);
	}

	@Override
	public List<QuestionVO> question_list(int exam_code) {
		return sql.selectList("lecture.question_list", exam_code);
	}

	@Override
	public ExamVO exam_info(int exam_code) {
		return sql.selectOne("lecture.exam_info", exam_code);
	}

	@Override
	public QuestionVO question_info(int no) {
		return sql.selectOne("lecture.question_info", no);
	}

	@Override
	public int insert_question(QuestionVO vo) {
		return sql.insert("lecture.insert_question", vo);
	}

	@Override
	public void notice_insert(BoardVO vo) {
		sql.insert("notice_insert", vo);
	}

	@Override
	public void notice_update(BoardVO vo) {
		sql.update("notice_update", vo);
	}

	@Override
	public void homework_insert(HomeworkVO vo) {
		sql.insert("homework_insert", vo);
	}

	@Override
	public List<HomeworkVO> teach_homework_list(int lecture_code) {
		return sql.selectList("teach_homework_list", lecture_code);
	}

	@Override
	public List<LectureVO> teacher_lecture_list(int member_code) {
		return sql.selectList("teach_lecture_list", member_code);
	}

	@Override
	public List<AttendanceVO> attendance_list(HashMap<String, Object> map) {
		return sql.selectList("attendance_list", map);
	}

	@Override
	public void attendance_update(HashMap<String, Object> map) {
		sql.update("attendance_update", map);
	}

	public List<LectureVO> te_lec_list(HashMap<String, String> tempMap) {
		return sql.selectList("lecture.te_lec_list", tempMap);
	}

	@Override
	public int open_new_lecture(LectureVO lecturevo) {
		return sql.insert("lecture.open_new_lecture", lecturevo);
	}

	@Override
	public int modify_lecture(LectureVO lecturevo) {
		return sql.update("lecture.modify_lecture", lecturevo);
	}

	@Override
	public void delete_lecture(int lecture_code) {
		sql.delete("lecture.delete_lecture", lecture_code);
		
	}

	@Override
	public List<LectureVO> lecture_code_list(int teacher_code) {
		return sql.selectList("lecture.lecture_code_list",teacher_code);
	}


	@Override
	public HomeworkSubmitVO homework_submit_info(HashMap<String, Object> map) {
		return sql.selectOne("homework_submit_info", map);
	}
}
