package com.and.middle;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;

import customer.CustomerVO;

@RestController
public class CustomerController {
	@Autowired @Qualifier("hanul") private SqlSession session;
	@RequestMapping(value = "/and_customer", produces ="text/html;charset=UTF-8")
	public String andController_test() {
		List<CustomerVO> list = session.selectList("test.customer_list");
		System.out.println(list.size());
		
		for(CustomerVO vo : list) {
			System.out.println(vo.getName());
		}
		//return "test";
		return new Gson().toJson(list);
	}
	
	@RequestMapping(value = "/andVo", produces ="text/html;charset=UTF-8")
	public String andVo(String data) {
		System.out.println(data);
		List<CustomerVO> list = session.selectList("test.customer_list");
		
		return new Gson().toJson(list.get(0));
	}
	
}
