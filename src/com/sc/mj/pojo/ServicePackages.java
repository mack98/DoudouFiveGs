package com.sc.mj.pojo;

public  class ServicePackages  {
	public int id;
	public String name;
	public int talkTime;
	public int smsCount;
	public int flow;
	public  double price;
	
	public ServicePackages(int id, String name, int talkTime, int smsCount, int flow, double price) {
		super();
		this.id = id;
		this.name = name;
		this.talkTime = talkTime;
		this.smsCount = smsCount;
		this.flow = flow;
		this.price = price;
	}
	public ServicePackages() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getTalkTime() {
		return talkTime;
	}
	public void setTalkTime(int talkTime) {
		this.talkTime = talkTime;
	}
	public int getSmsCount() {
		return smsCount;
	}
	public void setSmsCount(int smsCount) {
		this.smsCount = smsCount;
	}
	public int getFlow() {
		return flow;
	}
	public void setFlow(int flow) {
		this.flow = flow;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "ServicePackages [id=" + id + ", name=" + name + ", talkTime=" + talkTime + ", smsCount=" + smsCount
				+ ", flow=" + flow + ", price=" + price + "]";
	}
	
	
	
	
	
	
	

	
}
