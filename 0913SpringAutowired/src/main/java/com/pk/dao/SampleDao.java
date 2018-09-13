package com.pk.dao;

import org.springframework.stereotype.Repository;

//bean 생성을 자동으로 해주는 어노테이션
@Repository
public class SampleDao {
	
	public String test() {
		return "테스트 메소드";
	}
	
}
