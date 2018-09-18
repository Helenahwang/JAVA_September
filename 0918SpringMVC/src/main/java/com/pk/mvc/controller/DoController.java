package com.pk.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

//Controller 클래스를 만들고 Bean을 자동생성하는 어노테이션

@Controller
public class DoController {
	
	//사용자의 요청을 처리하는 메소드
	@RequestMapping("hello.do")
	public String hello(Model model) {
		model.addAttribute("data","Spring MVC");
		return "views/hello.jsp";
		// "views/hello.jsp"를 들고, dispatcher-servlet.xml으로 복귀한다 
		// 복귀 후 viewresolver를 찾고 없으면, "views/hello.jsp"로 가서 출력한다.
	}
	
	//URL의 가장 마지막 부분을 분할해서 사용해야한다. 
	@RequestMapping("/archives/{num}")
	public String archive(@PathVariable int num, Model model) {
		model.addAttribute("data", num);
		// 인덱스에서 설정한 /bloter/archieves를 제거하여 webapp까지 가기 위해 ../../를 추가
		//왜냐면 views는 webapp 폴더 안에 있기 때문이다. 
		
		return "../../views/archives.jsp";
	}
}
	


