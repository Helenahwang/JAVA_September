package com.pk.diffviews;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DataController {
	
	
	// csv를 만들어서 리턴하는 메소드
	@RequestMapping(value = "data.csv", method = RequestMethod.GET)
	public String dataCsv() {
		return "Jenny, female, 01022224444";
	}


	// json를 만들어서 리턴하는 메소드
	@RequestMapping(value = "data.json", method = RequestMethod.GET)
	public List<Map<String, Object>> datajson() {
		
		List<Map<String, Object>> list = new ArrayList<>();
		
		Map<String, Object> map = new HashMap<>();
		map.put("name", "아이린");
		map.put("group", "레드벨벳");
		list.add(map);
		
		map = new HashMap<>();
		map.put("name", "수지");
		map.put("group", "솔로");
		list.add(map);
		
		return list;
	}
	
	
}