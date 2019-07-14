package com.sc.mj.dao;

import java.util.List;
import java.util.Random;

import com.sc.mj.pojo.MobileCard;
import com.sc.mj.pojo.Record;

public interface UserDao {

	int userRegDao(MobileCard mc);

	MobileCard userLoginDao(String uname, String pwd);

	int upChargeDao(String num, double money,Record r);



	int addRecordDao(Record r, MobileCard mc);

	List<Record> getInfoRecordDao(MobileCard mc);

	MobileCard getShowDao(MobileCard mc);

	int changeDao(MobileCard mc,Record r);

	int quitDao(MobileCard mc);

	

}
