package lecture;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import vo.AttendanceVO;
import vo.BoardVO;
import vo.ExamVO;
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
		return sql.selectList("lecture.exam_list", map);
	}

	@Override
	public List<MemberVO> student_list(int lecture_code) {
		return sql.selectList("student_list", lecture_code);
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

}
