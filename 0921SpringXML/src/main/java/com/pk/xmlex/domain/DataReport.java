package com.pk.xmlex.domain;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;


@XmlAccessorType(XmlAccessType.FIELD)

//최상위 태그 이름 만들기
@XmlRootElement(name="DataReport")

public class DataReport {
	//각각의 객체를 표현하는 태그
	@XmlElement(name="DataStructure")
	private List<DataStructure> list;

	public List<DataStructure> getList() {
		return list;
	}
	

	public void setList(List<DataStructure> list) {
		this.list = list;
	}

	
	@Override
	public String toString() {
		return "DataReport [list=" + list + "]";
	}
	
	

}
