package lecture;

import java.util.HashMap;
import java.util.List;

import org.springframework.ui.Model;

import vo.AttendanceVO;
import vo.BoardVO;
import vo.ExamVO;
import vo.HomeworkVO;
import vo.LectureVO;
import vo.MemberVO;

public interface LectureService {
	List<LectureVO> lecture_list(int member_code); //학생이 수강중인 강의 리스트 조회
	List<LectureVO> teacher_lecture_list(int member_code); //강사가 강의중인 강의 리스트 조회
	
	
	MemberVO info(int lecture_code); //강의홈 화면에서 강의하는 강사정보 조회
	List<BoardVO> notice_list(int lecture_code);//강의 공지사항 리스트
	BoardVO notice_info(int board_code); //강의 공지사항 정보
	
	List<HomeworkVO> homework_list(HashMap<String, Object> map);//수강생 - 과제 리스트
	List<HomeworkVO> teach_homework_list(int lecture_code);//수강생 - 과제 리스트
	

	HomeworkVO homework_info(HashMap<String, Object> map);
	List<BoardVO> video_list(int lecture_code); //강의영상 리스트 조회
	List<ExamVO> exam_list(HashMap<String, Object> map); //시험목록 조회
	List<MemberVO> student_list(int lecture_code); //수강생 리스트 조회
	void notice_insert(BoardVO vo);//공지작성처리
	void notice_update(BoardVO vo);//공지수정처리
	void homework_insert(HomeworkVO vo); //과제작성처리
	
	
	List<AttendanceVO> attendance_list(HashMap<String, Object> map);
	void attendance_update(HashMap<String, Object> map);
}
