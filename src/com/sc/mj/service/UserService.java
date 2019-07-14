package com.sc.mj.service;

import java.util.List;
import java.util.Random;

import com.sc.mj.pojo.MobileCard;
import com.sc.mj.pojo.Record;

public interface UserService {
	//�û�ע��
	int  userRegService(MobileCard mc);
	//��¼��֤
	MobileCard checkLogin(String uname, String pwd);
	//��ֵ
	int updataCharge(String num, double money,Record r);
	//������Ѽ�¼
	int addRecord(Record record, MobileCard mc);

	
	//��ȡ���Ѽ�¼
	List<Record> geInfoToPrice(MobileCard mc);
	
	//�ײ�����չʾ
	MobileCard getShowService(MobileCard mc);
	
	//���ײ�
	int changeService(MobileCard mc,Record r);
	//����
	int quitService(MobileCard mc);

	

}
