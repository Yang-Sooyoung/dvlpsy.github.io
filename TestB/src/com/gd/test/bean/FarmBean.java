package com.gd.test.bean;

public class FarmBean {
	private String name;
	private int buy;
	private int grow;
	private int sell;
	
	public FarmBean() {
		
	}
	
	public FarmBean(String name, int buy, int grow, int sell) {
		setName(name);
		setBuy(buy);
		setGrow(grow);
		setSell(sell);
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

	public int getGrow() {
		return grow;
	}

	public void setGrow(int grow) {
		this.grow = grow;
	}

	public int getSell() {
		return sell;
	}

	public void setSell(int sell) {
		this.sell = sell;
	}
	
}