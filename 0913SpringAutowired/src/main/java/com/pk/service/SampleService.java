package com.pk.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pk.dao.SampleDao;


//bean을 자동 생성해주는 어노테이션
@Service
public class SampleService {
	
	//동일한 자료형의 bean이 있으면 자동으로 연결해주는 어노테이션
	//setter 메소드도 자동생성해 준다. 
	
	@Autowired
	private SampleDao sampleDao;
	
	public String test() {
		return sampleDao.test();
	}

}
