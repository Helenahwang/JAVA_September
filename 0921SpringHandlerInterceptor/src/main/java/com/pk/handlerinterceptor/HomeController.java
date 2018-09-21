package com.pk.handlerinterceptor;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
	
	@RequestMapping(value = "interceptor", method = RequestMethod.GET)
	public String interceptor() {
		
		/*
		//시작시간 측정
		long start=System.currentTimeMillis();
		*/
		
		
		int sum=0;
		for(int i=1; i<=100000000; i++) {
			sum=sum+i;
		}
		
		/*
		//종료시간 측정
		long end=System.currentTimeMillis();
		System.out.println(end-start);
		*/
		
		return "";
	}
}
