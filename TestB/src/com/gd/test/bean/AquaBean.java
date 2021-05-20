package com.gd.test.bean;

public class AquaBean { //age? 성장? 수족관
	private String name;
	private int buy;
	private int sell;
	private int grow;
	
	public AquaBean() {
		//기본 생성자
	}
	
	public AquaBean (String name, int buy, int sell, int grow) {
		setName(name);
		setBuy(buy);
		setSell(sell);
		setGrow(grow);
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getBuy() {
		return buy;
	}
	public void setBuy(int buy) {
		this.buy = buy;
	}
	public int getSell() {
		return sell;
	}
	public void setSell(int sell) {
		this.sell = sell;
	}
	public int getGrow() {
		return grow;
	}
	public void setGrow(int grow) {
		this.grow = grow;
	}
}