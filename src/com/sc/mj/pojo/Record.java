package com.sc.mj.pojo;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Record {
	private Integer xid;
	private String card;
	private double cost;
	private int talktime;
	private int sms;
	private int flow;
	private String mess;
	private String date;
	private MobileCard mc;
	
	
	
	public int getFlow() {
		return flow;
	}
	public void setFlow(int flow) {
		this.flow = flow;
	}
	public Integer getXid() {
		return xid;
	}
	public void setXid(Integer xid) {
		this.xid = xid;
	}
	public String getCard() {
		return card;
	}
	public void setCard(String card) {
		this.card = card;
	}
	public int getTalktime() {
		return talktime;
	}
	public void setTalktime(int talktime) {
		this.talktime = talktime;
	}
	public int getSms() {
		return sms;
	}
	public void setSms(int sms) {
		this.sms = sms;
	}
	public String getMess() {
		return mess;
	}
	public void setMess(String mess) {
		this.mess = mess;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	private String Times() {
		// TODO Auto-generated method stub
		Date d=new Date();
		String nowTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(d);
		return nowTime;
	}

	public double getCost() {
		return cost;
	}
	public void setCost(double cost) {
		this.cost = cost;
	}

	public MobileCard getMc() {
		return mc;
	}
	public void setMc(MobileCard mc) {
		this.mc = mc;
	}
	public Record( String card,double cost, int talktime,   int sms,int flow, String mess) 
	{
		super();
		this.card = card;
		this.talktime = talktime;
		this.cost = cost;
		this.sms = sms;
		this.flow=flow;
		this.mess = mess;
		this.date=Times();
	}
	public Record() {
		super();
		this.date=Times();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Record [xid=" + xid + ", card=" + card + ", cost=" + cost + ", talktime=" + talktime + ", sms=" + sms
				+ ", flow=" + flow + ", mess=" + mess + ", date=" + date + ", mc=" + mc + "]";
	}

	 
	
	
	
	
	
	
}
