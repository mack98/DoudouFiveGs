package com.sc.mj.service;

import java.util.List;
import java.util.Random;

import com.sc.mj.pojo.MobileCard;
import com.sc.mj.pojo.Record;

public interface UserService {
	//用户注册
	int  userRegService(MobileCard mc);
	//登录验证
	MobileCard checkLogin(String uname, String pwd);
	//充值
	int updataCharge(String num, double money,Record r);
	//添加消费记录
	int addRecord(Record record, MobileCard mc);

	
	//获取消费记录
	List<Record> geInfoToPrice(MobileCard mc);
	
	//套餐余量展示
	MobileCard getShowService(MobileCard mc);
	
	//改套餐
	int changeService(MobileCard mc,Record r);
	//退网
	int quitService(MobileCard mc);

	

}
