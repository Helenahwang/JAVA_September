package com.pk.login;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.pk.login.service.MemberService;

@RestController
public class DataController {
	
	@Autowired
	private MemberService memberService;
	
	@RequestMapping(value = "idcheck", method = RequestMethod.GET)
	//반드시 idcheck 요청을 할 때 id의 값을 같이 넘겨주어야 한다.
	public Map<String, String> idcheck(@RequestParam("id") String id){
		System.out.println(id);
		String result = memberService.idcheck(id);
		
		Map<String, String> map = new HashMap<String, String>();
		
		//아이디가 존재하지 않을 때
		if(result == null) {
			map.put("result", "true");
			
		}else {
			map.put("result","false");
		}
		System.out.println(map);
		return map;
	}

}
