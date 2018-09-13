package com.pk.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.pk.service.SampleService;

//Controller 클래스로 만들어주는 어노테이션
//bean 도 자동생성됨
@Controller
public class SampleController {
	@Autowired
	private SampleService sampleService;
	
	public String test() {
		return sampleService.test();
	}

}
