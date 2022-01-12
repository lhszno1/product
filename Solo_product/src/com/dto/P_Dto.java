package com.dto;

public class P_Dto {
	private int code;
	private String name;
	private int price;
	private int stock;
	private String category;
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
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	
	///////////////////////////////////
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "code : " + code + "\n"
				+ "name : " + name + "\n"
				+ "price : " + price + "\n"
				+"stock : " + stock + "\n"
				+"category : " + category + "\n";
	}
}
