package lecture;

import java.util.HashMap;
import java.util.List;

import vo.BoardVO;
import vo.ExamVO;
import vo.HomeworkVO;
import vo.LectureVO;
import vo.MemberVO;

public interface LectureService {
	List<LectureVO> lecture_list(int member_code); //학생이 수강중인 강의 리스트 조회
	MemberVO info(int lecture_code); //강의홈 화면에서 강의하는 강사정보 조회
	List<BoardVO> notice_list(int lecture_code);//강의 공지사항 리스트
	BoardVO notice_info(int board_code); //강의 공지사항 정보
	List<HomeworkVO> homework_list(HashMap<String, Object> map);//과제 리스트
	HomeworkVO homework_info(HashMap<String, Object> map);
	List<BoardVO> video_list(int lecture_code); //강의영상 리스트 조회
	List<ExamVO> exam_list(HashMap<String, Object> map); //시험목록 조회
	
	List<LectureVO> te_lec_list(HashMap<String, String> tempMap); 	//로그인한 강사의 개설 강의 목록 조회-kmj
	int open_new_lecture(LectureVO lecturevo);				     	//로그인한 강사가 강의 개설-kmj
	int modify_lecture(LectureVO lecturevo);         //로그인한 강사가 개설 강의 수정-kmj
	List<LectureVO> lecture_code_list(int teacher_code); //로그인한 강사의 개설된 강의코드 목록-kmj
	void delete_lecture(int lecture_code);         //로그인한 강사가 개설 강의 삭제-kmj
	List<LectureVO> sys_lec_list();	// sysdate에 해당 하는 강의 목록 조회-kmj
}
