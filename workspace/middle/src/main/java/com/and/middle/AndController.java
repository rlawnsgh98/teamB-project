package com.and.middle;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RestController;

//@Controller
@RestController
public class AndController {
	@Autowired @Qualifier("hanul") private SqlSession session;
	//@ResponseBody <= RestAPI 방식은 데이터를 return하기 위한 방식이기 때문에
	//@ResponseBody를 생략해도 똑같은 처리가 된다.
	/*
	@RequestMapping("/and")
	public String andController_test() {
		//selectOne("매퍼네임스페이스.아이디")
		//System.out.println(session.selectOne("test.test1"));
		return "test";
	}
	*/
}
