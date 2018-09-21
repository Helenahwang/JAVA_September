package com.pk.diffviews;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class HomeController {
	
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		
		return "home";
	}
	
	//excel.xml 요청을 처리하는 메소드
	@RequestMapping(value = "excel.xls", method = RequestMethod.GET)
	public String excel(Model model) {
		
		List<String> list = new ArrayList<>();
		
		list.add("Java");
		list.add("JavaScript");
		list.add("C");
		list.add("C++");
		list.add("Python");
		list.add("C#");
		list.add("R");
		list.add("Ruby");
		list.add("Scala");
		list.add("Swift");
		
		model.addAttribute("list",list);
		
		return "programming언어";
	}
	
	
	//data.pdf 요청을 처리하는 메소드
		@RequestMapping(value = "data.pdf", method = RequestMethod.GET)
		public String pdf(Model model) {
			List<String> list = new ArrayList<>();
			list.add("Oracle-RDBMS");
			list.add("MS-SQL-RDBMS");
			list.add("MySQL(MariaDB)-RDBMS");
			list.add("ACCESS-RDBMS");
			list.add("Sqlite-RDBMS");
			list.add("MongoDB-NoSQL");
			list.add("Cassandra-NoSQL");
			
			//db라는 이름으로 list를 저장
			model.addAttribute("db",list);
	
			//출력하는 뷰 이름으로 db로 설정
			return "db";
		}
		
		@RequestMapping(value="jsonview.json", method=RequestMethod.GET)
		public String jsonview(Model model) {
			
			List<Map<String, String>> list = new ArrayList<Map<String, String>>();
			Map<String, String>map = new HashMap<String, String>();
			
			map.put("name", "유관순");
			map.put("phone", "01033479999");
			list.add(map);
			
			map=new HashMap<String, String>();
			map.put("name", "김좌진");
			map.put("phone", "01012345678");
			list.add(map);
			
			map=new HashMap<String, String>();
			map.put("name", "안중근");
			map.put("phone", "01087654321");
			list.add(map);
			
			model.addAttribute("list",list);
			
			return "json통해보기";
		}
		
		
		
		
		
		
}







