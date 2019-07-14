package com.sc.mj.pojo;

import java.util.HashSet;

public class MobileCard {
	private String cardNumber;//�ֻ���
	private String userName;//�û���
	private	String passWord;//����
	private  int PackageId;//�ײ͵�ID
	private	ServicePackages serPackage;//�ײ�
	private double consumAmount;//���ѽ��
	private double money;//���
	private int realTalkTime;//ͨ��ʱ��
	private int realSMSCount;//��������
	private int realFlow;//����
	private HashSet<Record> record;
	public String getCardNumber() {
		return cardNumber;
	}
	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassWord() {
		return passWord;
	}
	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}
	public ServicePackages getSerPackage() {
		return serPackage;
	}
	public void setSerPackage(ServicePackages serPackage) {
		this.serPackage = serPackage;
	}
	public double getConsumAmount() {
		return consumAmount;
	}
	public void setConsumAmount(double consumAmount) {
		this.consumAmount = consumAmount;
	}
	public int getRealTalkTime() {
		return realTalkTime;
	}
	public void setRealTalkTime(int realTalkTime) {
		this.realTalkTime = realTalkTime;
	}
	public double getMoney() {
		return money;
	}
	public void setMoney(double money) {
		this.money = money;
	}
	public int getRealSMSCount() {
		return realSMSCount;
	}
	public void setRealSMSCount(int realSMSCount) {
		this.realSMSCount = realSMSCount;
	}
	public int getRealFlow() {
		return realFlow;
	}
	public void setRealFlow(int realFlow) {
		this.realFlow = realFlow;
	}

	public HashSet<Record> getRecord() {
		return record;
	}
	public void setRecord(HashSet<Record> record) {
		this.record = record;
	}
	@Override
	public String toString() {
		return "MobileCard [cardNumber=" + cardNumber + ", userName=" + userName + ", passWord=" + passWord
				+ ", PackageId=" + PackageId + ", serPackage=" + serPackage + ", consumAmount=" + consumAmount
				+ ", money=" + money + ", realTalkTime=" + realTalkTime + ", realSMSCount=" + realSMSCount
				+ ", realFlow=" + realFlow + ", record=" + record + "]";
	}
	public MobileCard() {
		super();
		// TODO Auto-generated constructor stub
	}
	public MobileCard(String cardNumber, String userName, String passWord, int packageId, ServicePackages serPackage,
			double consumAmount, double money, int realTalkTime, int realSMSCount, int realFlow) {
		super();
		this.cardNumber = cardNumber;
		this.userName = userName;
		this.passWord = passWord;
		this.PackageId = packageId;
		this.serPackage = serPackage;
		this.consumAmount = consumAmount;
		this.money = money;
		this.realTalkTime = realTalkTime;
		this.realSMSCount = realSMSCount;
		this.realFlow = realFlow;
		//this.record = record;
	}
	public int getPackageId() {
		return PackageId;
	}
	public void setPackageId(int packageId) {
		PackageId = packageId;
	}
	
	
	
	
	
}
