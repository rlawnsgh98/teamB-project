package com.and.web;

import java.sql.Date;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import common.CommonService;
import lecture.LectureServiceImple;
import vo.AttendanceVO;
import vo.BoardVO;
import vo.ExamVO;
import vo.HomeworkSubmitVO;
import vo.HomeworkVO;
import vo.LectureVO;
import vo.MemberVO;
import vo.QuestionVO;

@Controller
public class LectureController {
	@Autowired
	private LectureServiceImple service;
	@Autowired private CommonService common;

	// 강의 목록 조회 - 강사 (주소창으로만 접근)
	@RequestMapping("/list.teacher")
	public String lecture_list_teacher(Model model, int member_code, HttpSession session) {
		
		List<LectureVO> list = service.lecture_list_teacher(member_code);
		model.addAttribute("list", list);

		return "lecture/list_teacher";
	}
	
	// 학생이 수강중인 강의 리스트 조회
	@RequestMapping("/list.le")
	public String list(HttpSession session, Model model, int member_code) {
		
		MemberVO vo = (MemberVO) session.getAttribute("loginInfo");
		
		if(vo.getType().equals("STUD")) {
			List<LectureVO> list = service.lecture_list(member_code);			
			model.addAttribute("list", list);
		}else {
			List<LectureVO> list = service.teacher_lecture_list(member_code);
			model.addAttribute("list", list);
		}

		return "lecture/list";
	}

	// 학생이 수강중인 강의 정보
	@RequestMapping("/lecture_home.le")
	public String lecture_home(HttpSession session, int lecture_code) {
		session.removeAttribute("lecture");
		session.removeAttribute("lecture_info");
		// 강사 정보
		MemberVO lecture_info = service.info(lecture_code);
		LectureVO lecture = service.lecture_info(lecture_code);
		session.setAttribute("lecture_info", lecture_info);
		session.setAttribute("lecture", lecture);

		return "lecture/lecture_home";
	}

	// 선택한 강의의 공지사항 리스트
	@RequestMapping("/notice_list.le")
	public String notice_list(Model model, int lecture_code, HttpSession session) {
		session.removeAttribute("lecture");
		session.removeAttribute("lecture_info");
		// 공지 리스트
		MemberVO lecture_info = service.info(lecture_code);
		LectureVO lecture = service.lecture_info(lecture_code);
		List<BoardVO> notice_list = service.notice_list(lecture_code);
		model.addAttribute("notice_list", notice_list);
		session.setAttribute("lecture_info", lecture_info);
		session.setAttribute("lecture", lecture);
		return "lecture/notice_list";
	}

	// 공지사항 세부내용
	@RequestMapping("/notice_info.le")
	public String notice_info(Model model, int board_code) {

		BoardVO vo = service.notice_info(board_code);
		model.addAttribute("notice_info", vo);

		return "lecture/notice_info";
	}

	// 학생이 수강중인 강의의 과제 리스트
	@RequestMapping("/homework_list.le")
	public String homework_list(HttpSession session, Model model, int member_code, int lecture_code) {
		
		MemberVO vo = (MemberVO) session.getAttribute("loginInfo");
		
		if(vo.getType().equals("STUD")) {
			HashMap<String, Object> map = new HashMap<String, Object>();
			map.put("member_code", member_code);
			map.put("lecture_code", lecture_code);
			List<HomeworkVO> list = service.homework_list(map);
			model.addAttribute("list", list);
		}else {
			List<HomeworkVO> list = service.teach_homework_list(lecture_code);
			model.addAttribute("list", list);
		}
		

		return "lecture/homework_list";
	}

	// 학생이 수강중인 강의의 과제 상세정보
	@RequestMapping("/homework_info.le")
	public String homework_info(Model model, int member_code, int homework_code) {

		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("member_code", member_code);
		map.put("homework_code", homework_code);

		HomeworkVO vo = service.homework_info(homework_code);
		model.addAttribute("info", vo);
		
		HomeworkSubmitVO vo2 = service.homework_submit_info(map);
		model.addAttribute("sub_info", vo2);
		
		return "lecture/homework_info";
	}
	
	//과제 제출
	@RequestMapping("/homework_submit.le")
		public String homework_submit(Model model, int member_code, int homework_code) {
					
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("member_code", member_code);
		map.put("homework_code", homework_code);

		HomeworkVO vo = service.homework_info(homework_code);
		model.addAttribute("info", vo);
		
		return "lecture/homework_submit";
	}
	
	//과제 제출 처리
	@RequestMapping("/homework_submit_insert.le")
	public String homework_submit_insert(HomeworkSubmitVO vo, HttpSession session,  MultipartFile file, HttpServletRequest request) {
		MemberVO logininfo = (MemberVO) session.getAttribute("loginInfo");
		
		if(!file.isEmpty()) {
			vo.setFile_name(file.getOriginalFilename());
			vo.setFile_path(common.fileUpload("homework_submit", file, request));
		}	
		
		service.homework_submit_insert(vo);
		
		return "redirect:homework_info.le?homework_code="+vo.getHomework_code() + "&member_code="+logininfo.getMember_code();
	}
	
	
	//과제제출내용 수정 화면
	@RequestMapping("/homework_modify.le")
	public String homework_modify(Model model, int member_code, int homework_code) {
				
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("member_code", member_code);
		map.put("homework_code", homework_code);
		
		HomeworkSubmitVO vo = service.homework_submit_info(map);
		model.addAttribute("sub_info", vo);
				
		return "lecture/homework_modify";
	}	
	
	//과제제출내용 수정 처리
	@RequestMapping("/homework_submit_update.le")
	public String homework_submit_update(HomeworkSubmitVO vo, HttpSession session, MultipartFile file, HttpServletRequest request) {
		MemberVO logininfo = (MemberVO) session.getAttribute("loginInfo");
		if(!file.isEmpty()) {
			vo.setFile_name(file.getOriginalFilename());
			vo.setFile_path(common.fileUpload("homework_submit", file, request));
		}		
		service.homework_submit_update(vo);
		return "redirect:homework_info.le?homework_code="+vo.getHomework_code() + "&member_code="+logininfo.getMember_code();
	}
	
	@ResponseBody @RequestMapping(value = "/download_homework.le", produces="text/html;charset=utf-8")
	public String download_homework(int homework_code , String url, 
							HttpServletRequest request, HttpServletResponse response) throws Exception {

		HomeworkVO vo = service.homework_info(homework_code);
		
		boolean download = common.fileDownload(vo.getFilename(), vo.getFilepath(),request, response);
		
		if(!download) {//첨부된 파일이 실제 물리적으로 존재하지 않는 경우
			StringBuffer msg = new StringBuffer("<script>");
			msg.append(" alert('다운로드할 파일이 없습니다!'); location=' ").append(url).append(" ' ");
			msg.append("</script>");
			return msg.toString();
		}else {
			return null;
		}
	}
	
	@ResponseBody @RequestMapping(value = "/download_homework_sub.le", produces="text/html;charset=utf-8")
	public String download_homework_sub(int member_code, int homework_code , String url, 
							HttpServletRequest request, HttpServletResponse response) throws Exception {

		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("member_code", member_code);
		map.put("homework_code", homework_code);
		
		HomeworkSubmitVO vo = service.homework_submit_info(map);
		
		boolean download = common.fileDownload(vo.getFile_name(), vo.getFile_path(),request, response);
		
		if(!download) {//첨부된 파일이 실제 물리적으로 존재하지 않는 경우
			StringBuffer msg = new StringBuffer("<script>");
			msg.append(" alert('다운로드할 파일이 없습니다!'); location=' ").append(url).append(" ' ");
			msg.append("</script>");
			return msg.toString();
		}else {
			return null;
		}
	}
	

	// 수강중인 강의의 강의영상 리스트
	@RequestMapping("/video_list.le")
	public String video_list(Model model, int lecture_code) {

		List<BoardVO> list = service.video_list(lecture_code);
		model.addAttribute("video_list", list);

		return "lecture/video_list";
	}

	// 영상강의 시청
	@RequestMapping("/video_watch.le")
	public String video_watch(Model model, int board_code) {
//			
//		List<BoardVO> vo = service.video_watch(board_code);
//		model.addAttribute("video_list", vo);

		return "lecture/video_watch";
	}

	// 시험목록 조회
	@RequestMapping("/exam_list.le")
	public String exam_list(Model model, HttpSession session, int member_code, int lecture_code) {

		HashMap<String, Object> map = new HashMap<String, Object>();
		MemberVO member = (MemberVO) session.getAttribute("loginInfo");
		
		map.put("member_code", member_code);
		map.put("type", member.getType());
		map.put("lecture_code", lecture_code);

		List<ExamVO> list = service.exam_list(map);
		
		model.addAttribute("exam_list", list);
		//시험관련 수강생 수 넘겨주기
		model.addAttribute("exam_total_num", service.exam_total_num(lecture_code));

		return "lecture/exam_list";
	}

	@RequestMapping("/exam_take.le")
	public String exam_take() {

//		HashMap<String, Object> map = new HashMap<String, Object>();
//		map.put("member_code", member_code);
//		map.put("lecture_code", lecture_code);

//		List<ExamVO> list = service.exam_list(map);
//		model.addAttribute("exam_list", list);

		return "lecture/exam_take";
	}
	
	
		

	
	
	
	//////////////////////////////선생//////////////////////////
	
	//공지작성 화면
	@RequestMapping("/notice_write.le")
	public String notice_write() {
				
		return "lecture/notice_write";
	}
	
	//공지작성 처리
	@RequestMapping("/notice_insert.le")
	public String notice_new(BoardVO vo) {

		service.notice_insert(vo);
		return "redirect:notice_list.le?lecture_code="+vo.getLecture_code() ;
	}
	
	//공지수정 화면
	@RequestMapping("/notice_modify.le")
	public String notice_modify(Model model, int board_code) {
				
		BoardVO vo = service.notice_info(board_code);
		model.addAttribute("notice_info", vo);
		
		return "lecture/notice_modify";
	}
	
	//공지수정처리
	@RequestMapping("/notice_update.le")
	public String notice_update(BoardVO vo) {

		service.notice_update(vo);
		return "redirect:notice_list.le?lecture_code="+vo.getLecture_code() ;
	}
	
	
	//영상 등록
	@RequestMapping("/video_new.le")
	public String video_new() {
					
		return "lecture/video_new";
	}	
	//과제 등록
	@RequestMapping("/homework_new.le")
	public String homework_new() {
		
		
		return "lecture/homework_new";
	}
	
	//과제 등록 처리
	@RequestMapping("/homework_insert.le")
	public String homework_insert(HomeworkVO vo, MultipartFile file, HttpServletRequest request) {
		
		if(!file.isEmpty()) {
			vo.setFilename(file.getOriginalFilename());
			vo.setFilepath(common.fileUpload("homework_info", file, request));
		}	
		
		service.homework_insert(vo);
		return "redirect:homework_list.le?member_code="+vo.getMember_code()+"&lecture_code="+vo.getLecture_code();
	}
	
	
	
	//시험 등록화면 요청
	@RequestMapping("/exam_new.le")
	public String exam_new() {
		return "lecture/exam_new";
	}	
	//시험 등록 처리
	@RequestMapping("/exam_insert.le")
	public String exam_insert(ExamVO vo) {
		
		int result = service.insert_exam(vo);
		System.out.println("시험등록 처리결과 : "+result);
		
		return "redirect:exam_list.le";
	}
	
	//시험문제 상세화면 연결 - 없으면 만드는 페이지
	@RequestMapping("/question.le")
	public String question_list(HttpSession session, Model model, int exam_code) {
		
		session.removeAttribute("exam_info");	// 필요없으면 삭제할거
		
		ExamVO vo = service.exam_info(exam_code);
		List<QuestionVO> list = service.question_list(exam_code);
		vo.setList(list);
		
		session.setAttribute("exam_info", vo);
		if(list != null) {
			model.addAttribute("no", 1);
			model.addAttribute("question_info", list.get(0));
			return "exam/info";
		}
		return "exam/new";
	}
	
	//시험문제 다음 화면 연결
	@RequestMapping("/question_next.le")
	public String question_next(Model model, int cur_no, int total_question) {
		if(cur_no == total_question) {
			model.addAttribute("no", cur_no+1);
			model.addAttribute("total_question", total_question+1);
			
			return "exam/new";
		}else {
			model.addAttribute("no", cur_no+1);
			model.addAttribute("question_info", service.question_info(cur_no+1));
			return "exam/info";
		}
	}
	
	//시험문제 저장 - 저장만
	@RequestMapping("/exam_question_new.le")
	public String exam_question_new(QuestionVO vo, Model model) {
		service.insert_question(vo);
		model.addAttribute("no", vo.getNo());
		model.addAttribute("total_question", vo.getNo()+1);
		//저장한 문제정보 바로 출력
		model.addAttribute("question_info", vo);
		return "exam/info";
	}	
	
	//학생리스트 조회
	@RequestMapping("/student_list.le")
	public String student_list(Model model, int lecture_code) {
		
		List<MemberVO> list = service.student_list(lecture_code);
		model.addAttribute("student_list", list);
		
		return "lecture/student_list";
	}	
	
	//수강생 출결 조회
	@RequestMapping("/attendance_manage.le")
	public String attendance_manage(Model model, int lecture_code, String attendance_time) {
		
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("attendance_time", attendance_time);
		map.put("lecture_code", lecture_code);
		
		List<AttendanceVO> list = service.attendance_list(map);
		model.addAttribute("attendance_list", list);
		model.addAttribute("attendance_time", attendance_time);
		return "lecture/attendance_manage";
	}
	
	//수강생 출결 수정처리
		@RequestMapping("/attendance_update.le")
		public String attendance_update( int list_size , HttpServletRequest req) {
			
			for (int i = 0; i < list_size; i++) {
//				System.out.println(req.getParameter("state"+i));
//				System.out.println(req.getParameter("lecture_code"));
//				System.out.println(req.getParameter("member_code"+i));
//				System.out.println(req.getParameter("attendance_time"));
				HashMap<String, Object> map = new HashMap<String, Object>();
				map.put("state", req.getParameter("state"+i));
				map.put("lecture_code", req.getParameter("lecture_code"));
				map.put("member_code", req.getParameter("member_code"+i));
				map.put("attendance_time", req.getParameter("attendance_time"));
				service.attendance_update(map);
				
			}
			return "redirect:attendance_manage.le?lecture_code="+req.getParameter("lecture_code")+"&attendance_time="+req.getParameter("attendance_time");
		}
	
	
	
	
	
	
	
	
	

	// 로그인한 강사 개설 강의 목록 조회 - kmj
	@RequestMapping("/open_lecture.le")
	public String open_lecture(HttpSession session, Model model, String member_code, String select_subject, String select_year) {
		HashMap<String, String> tempMap = new HashMap<String, String>();
		tempMap.put("member_code", member_code);
		tempMap.put("select_year", select_year);
		tempMap.put("select_subject", select_subject);
		
		session.setAttribute("select_year", select_year);
		session.setAttribute("select_subject", select_subject);
		
		List<LectureVO> te_lec_list = service.te_lec_list(tempMap);
		model.addAttribute("te_lec_list", te_lec_list);
		// 강의코드 목록을 조회한다
		model.addAttribute("lec_code_list", service.lecture_code_list(Integer.parseInt(member_code)));
		
		// 응답화면연결
		return "lecture/open_lecture";
	}
	
	// 로그인한 강사가 강의 개설 버튼 클릭 시 - kmj
	@RequestMapping("/open_new_lecture")
	public String open_new_lecture(LectureVO lecturevo, HttpSession session) {
		service.open_new_lecture(lecturevo);
		MemberVO vo = (MemberVO) session.getAttribute("loginInfo");
		int mem_code = vo.getMember_code();
		
		// 응답화면연결
		return "redirect:/open_lecture.le?member_code="+mem_code;
	}
	
	// 로그인한 강사가 개설 강의 수정 버튼 클릭 시 - kmj
	@RequestMapping("/modify_lecture")
	public String modify_lecture(LectureVO lecturevo, HttpSession session) {
		// 수정한다
		service.modify_lecture(lecturevo);
		// 로그인한 강사의 코드가 필요하다
		MemberVO vo = (MemberVO) session.getAttribute("loginInfo");
		int mem_code = vo.getMember_code();
		
		// 응답화면연결
		return "redirect:/open_lecture.le?member_code="+mem_code;
	}
	
	// 로그인한 강사가 개설 강의 삭제 버튼 클릭 시 - kmj
	@RequestMapping("/delete_lecture")
	public String delete_lecture(int lecture_code, HttpSession session) {
		// 삭제한다
		service.delete_lecture(lecture_code);
		
		// 로그인한 강사의 코드가 필요하다
		MemberVO vo = (MemberVO) session.getAttribute("loginInfo");
		int mem_code = vo.getMember_code();
		
		// 응답화면연결
		return "redirect:/open_lecture.le?member_code="+mem_code;
	}

	// 수강 - 강의 목록 화면 - 갤러리형 - kmj
	@RequestMapping("/gallery_list.le")
	public String lec_list_test(HttpSession session, Model model) {	
		List<LectureVO> sys_lec_list = service.sys_lec_list();
		model.addAttribute("sys_lec_list", sys_lec_list);
		
		// 응답화면연결
		return "lecture/gallery_list";
	}

	// 수강 - 강의 목록 화면 - 리스트형 - kmj
	@RequestMapping("/just_list.le")
	public String lec_list_test2(HttpSession session, Model model) {
		List<LectureVO> sys_lec_list = service.sys_lec_list();
		model.addAttribute("sys_lec_list", sys_lec_list);
		
		// 응답화면연결
		return "lecture/just_list";
	}

	// 강의 상세보기 클릭 시 - kmj
	@RequestMapping("/en_lec_detail.le")
	public String en_lec_detail(int lecture_code , Model model) {
		// 응답화면연결
		LectureVO vo = service.sys_lec_one(lecture_code);
		model.addAttribute("vo", vo);
		return "lecture/en_lec_detail";
	}
	
	@RequestMapping("/en_lec_teacher_info.le")
	public String en_lec_teacher_info(HttpSession session) {
		// 응답화면연결
		return "lecture/en_lec_teacher_info";
	}
	
	
	
}