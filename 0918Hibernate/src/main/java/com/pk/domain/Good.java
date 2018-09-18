package com.pk.domain;

public class Good {

	private int code;
	private String name;
	private String manufacture;
	private int price;
	
	
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getManufacture() {
		return manufacture;
	}
	public void setManufacture(String manufacture) {
		this.manufacture = manufacture;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	
	
	
	@Override
	public String toString() {
		return "Good [code=" + code + ", name=" + name + ", manufacture=" + manufacture + ", price=" + price + "]";
	}
	
	

}
