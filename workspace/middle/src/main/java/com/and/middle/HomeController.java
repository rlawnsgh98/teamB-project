package com.and.middle;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;

@Controller
public class HomeController {
	// request = 요청
	// request = 응답
	@ResponseBody // <= res.getWriter().println("")
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(HttpServletResponse res) {
		// Android 직접 DB에 접속을 할수가없음. (예외 mysql)
		// Android => Spring, (Eclipse servlet) ... 미들웨어 => 오라클
		
		// 
		/*
		try {
			res.getWriter().println("home");
		}catch(IOException e) {
			e.printStackTrace();
		}
		*/
		return "home";	// <= 응담을 바로 x, forward (페이지) home.jsp
	}
	
	@ResponseBody	// 응답을 컨트롤러가 직접하겠다.
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login(String id, String pw) {
		if(id.equals("admin") && pw.equals("admin1234")) {
			return "로그인";
		}
		
		return "실패";	// 포워드(기본)
	}
	
	// JSON : 데이터 교환 표준  
	// [] : 배열
	// {} : 객체
	
	@ResponseBody
	@RequestMapping(value = "/jsontest", method = RequestMethod.GET)
	public String joinTest() {
		TempDTO dto = new TempDTO("data123","123","234");
		List<TempDTO> list = new ArrayList<HomeController.TempDTO>();
		list.add(dto);
		list.add(new TempDTO("1","2","3"));
		//String data = "KMJ";
		Gson gson = new Gson();
		//return gson.toJson(data);
		//return gson.toJson(dto);
		return gson.toJson(list);
	}
	
	public class TempDTO {
		String data ,id, pw;
		public TempDTO(String data, String id, String pw) {
			this.data = data;
			this.id = id;
			this.pw = pw;
		}
	}
	
	// REST API : Representational State Transfer
	
	@ResponseBody
	@RequestMapping(value = "/andTest")
	public String andTest(String id, String pw) { // 안드로이드가 post 방식으로 요청할 때 파라메터로 보내준 것
		System.out.println(id);
		return "KMJ";
	}
	
}
