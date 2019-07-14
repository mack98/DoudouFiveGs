package com.sc.mj.service.impl;

import java.util.List;
import java.util.Random;

import com.sc.mj.dao.UserDao;
import com.sc.mj.dao.impl.UserDaoImpl;
import com.sc.mj.pojo.MobileCard;
import com.sc.mj.pojo.Record;
import com.sc.mj.service.UserService;

public class UserServiceImpl implements UserService{

	UserDao ud=new UserDaoImpl();
	public int userRegService(MobileCard mc) {
		// TODO Auto-generated method stub
		return ud.userRegDao(mc);
	}
	@Override
	public MobileCard checkLogin(String uname, String pwd) {
		// TODO Auto-generated method stub
		return ud.userLoginDao(uname,pwd);
	}
	@Override
	public int updataCharge(String num, double money,Record r) {
		// TODO Auto-generated method stub
		return ud.upChargeDao(num,money,r);
	}
	public int addRecord(Record r,MobileCard mc) {
		// TODO Auto-generated method stub
		return ud.addRecordDao(r,mc);
	}
	@Override
	public List<Record> geInfoToPrice(MobileCard mc) {
		// TODO Auto-generated method stub
		return ud.getInfoRecordDao(mc);
	}
	@Override
	public MobileCard getShowService(MobileCard mc) {
		// TODO Auto-generated method stub
		return ud.getShowDao(mc);
	}
	@Override
	public int changeService(MobileCard mc,Record r) {
		// TODO Auto-generated method stub
		return ud.changeDao(mc,r);
	}
	
	@Override
	public int quitService(MobileCard mc) {
		// TODO Auto-generated method stub
		return ud.quitDao(mc);
	}


}
