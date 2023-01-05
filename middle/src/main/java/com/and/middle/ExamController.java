package com.and.middle;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;

import customer.CustomerVO;

//@Controller : 대부분 요청을 받아서 페이지 전환을 하기 위한 것(Ajax 비동기 처리 또는 데이터만 필요할 때)
//@RestController : 데이터만 필요한 경우 사용하는 컨트롤러(@RequestBody 생락 가능)  
@RestController
public class ExamController {
	
	// 크롬 => 톰캣 => 컨트롤러
	@RequestMapping(value = "/test1", produces="text/html;charset=UTF-8")
	public void test1() {
		System.out.println("Spring Console - 요청 받음1");
	}
	
	@RequestMapping(value = "/test2", produces="text/html;charset=UTF-8")
	public void test2(String id, String pw, String email) {
		System.out.println("Spring Console - 요청 받음2");
		// 요청할 때 요청하는 쪽에서 보내주는 데이터 출력
		System.out.println(id);
		System.out.println(pw);
		System.out.println(email);
	}
	
	@RequestMapping(value = "/test3", produces="text/html;charset=UTF-8")
	public String test3() {
		System.out.println("Spring Console - 요청 받음3");
		return "kmj"; //@RestController!!!
	}
	
	@RequestMapping(value = "/test4", produces="text/html;charset=UTF-8")
	public String test4() {
		System.out.println("Spring Console - 요청 받음4");
		TestVO vo = new TestVO();
		vo.setiVal(0);
		vo.setdVal(1.3);
		vo.setsVal("str");
		return new Gson().toJson(vo);
	}
	
	@RequestMapping(value = "/test5", produces="text/html;charset=UTF-8")
	public String test5(TestVO vo) {
		System.out.println("Spring Console - 요청 받음5");
		ArrayList<TestVO> list = new ArrayList<TestVO>();
		//list.add(new TestVO());
		/*
		for (int i = 0; i < 10; i++) {
			TestVO vo2 = new TestVO();
			vo2.setiVal(0);
			vo2.setdVal(1.3);
			vo2.setsVal("str");
			list.add(vo2);
		}
		*/
		for (int i = 0; i < 10; i++) {
			list.add(new TestVO(0,"str",1.3));
		}
		
		return new Gson().toJson(list);
	}
	
	// 필드
	@Autowired @Qualifier("hanul") private SqlSession sql;
	// 매핑 메소드
	@RequestMapping(value = "/select.cu", produces ="text/html;charset=UTF-8")
	public String customer() {
		List<CustomerVO> list = sql.selectList("cu.select");
		System.out.println("list.size() : " + list.size());
		System.out.println("sql.selectList(\"cu.select\").size() : "
				+ sql.selectList("cu.select").size());
		
		return new Gson().toJson(list);
	}
	
	@RequestMapping(value = "/delete.cu", produces ="text/html;charset=UTF-8")
	public String delete(int id) {
		int result = sql.delete("cu.delete",id);
		System.out.println(result);	//1 : OK , 0 : NO
		return "";
	}
}
