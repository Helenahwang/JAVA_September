package com.pk.fileupload.domain;

import org.springframework.web.multipart.MultipartFile;

public class Command {
	
	private String name;
	private MultipartFile report;
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public MultipartFile getReport() {
		return report;
	}
	public void setReport(MultipartFile report) {
		this.report = report;
	}
	
	
	@Override
	public String toString() {
		return "Command [name=" + name + ", report=" + report + "]";
	}
	
	

}
