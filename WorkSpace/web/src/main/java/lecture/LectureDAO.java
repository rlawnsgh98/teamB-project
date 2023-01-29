package lecture;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

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
	public List<LectureVO> sys_lec_list() {
		return sql.selectList("lecture.sys_lec_list");
	}
}
