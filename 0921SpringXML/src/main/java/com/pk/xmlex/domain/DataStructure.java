package com.pk.xmlex.domain;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;



//이 클래스를 xml로 출력하기 위한 설정
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name="", propOrder= {"name", "content"})




public class DataStructure {
	private String name;
	private String content;
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
	
	
	@Override
	public String toString() {
		return "DataStructure [name=" + name + ", content=" + content + "]";
	}


}
