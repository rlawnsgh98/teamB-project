package lecture;

import java.util.HashMap;

import java.util.List;

import org.springframework.ui.Model;

import vo.AttendanceVO;
import vo.BoardVO;
import vo.QuestionVO;
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
	
	//시험등록
	int insert_exam(ExamVO vo);
	//문제등록
	int insert_question(QuestionVO vo);
	//특정 강의정보 조회 - lecture table
	LectureVO lecture_info(int lecture_code);
	//특정 강의 총 인원수 조회
	int exam_total_num(int lecture_code);
	//등록한 시험 문제 목록 조회 - exam_question table
	List<QuestionVO> question_list(int exam_code);
	//특정 시험 문제 조회
	QuestionVO question_info(int no);
	//특정 시험 정보 조회 - exam table
	ExamVO exam_info(int exam_code);
	void notice_insert(BoardVO vo);//공지작성처리
	void notice_update(BoardVO vo);//공지수정처리
	void homework_insert(HomeworkVO vo); //과제작성처리
	
	
	List<AttendanceVO> attendance_list(HashMap<String, Object> map);
	void attendance_update(HashMap<String, Object> map);
	
	List<LectureVO> te_lec_list(HashMap<String, String> tempMap); 	//로그인한 강사의 개설 강의 목록 조회-kmj
	int open_new_lecture(LectureVO lecturevo);				     	//로그인한 강사가 강의 개설-kmj
	int modify_lecture(LectureVO lecturevo);         //로그인한 강사가 개설 강의 수정-kmj
	List<LectureVO> lecture_code_list(int teacher_code); //로그인한 강사의 개설된 강의코드 목록-kmj
	void delete_lecture(int lecture_code);         //로그인한 강사가 개설 강의 삭제-kmj
}
