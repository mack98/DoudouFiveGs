package com.sc.mj.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.websocket.Session;

import com.sc.mj.pojo.MobileCard;
import com.sc.mj.pojo.Record;
import com.sc.mj.service.UserService;
import com.sc.mj.service.impl.UserServiceImpl;

@WebServlet("/change")
public class ChangeServlet extends HttpServlet{
/**
	 * 
	 */
	UserService us=new UserServiceImpl();
	private static final long serialVersionUID = 1L;

@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//�����������
		req.setCharacterEncoding("utf-8");
		//������Ӧ����
		resp.setContentType("text/html;charset=utf-8");
		//��ȡ������
		String taoc=req.getParameter("taoc");
		String num=req.getParameter("num");
		MobileCard mc=(MobileCard)req.getSession().getAttribute("user");
		System.out.println(mc);
		System.out.println(taoc+"=============="+num);
		int id = 0;
		double money=0;
		int talk=0;
		int sms=0;
		int flow=0;
		if(taoc.equals("�����ײ�")) {
			System.out.println("�ײ�ȷ��");
			id=1;
			money=-58;
			talk=500;
			sms=30;
			flow=0;
			System.out.println(id);
		}else if(taoc.equals("�����ײ�")){
			System.out.println("�ײ�ȷ��");
			id=2;
			money=-78;
			talk=200;
			sms=50;
			flow=1024;
			System.out.println(id);
		}else if(taoc.equals("�����ײ�")){
			System.out.println("�ײ�ȷ��");
			id=3;
			money=-68;
			talk=0;
			sms=0;
			flow=1024;
			System.out.println(id);
		}
		else {
			System.out.println("ȷ��ʧ��");
		}
		if(num.equals(mc.getCardNumber())) {
			System.out.println("������ͬ");
			System.out.println("����ȷ��id"+id);
			mc.setPackageId(id);
			mc.setMoney(mc.getMoney()+money);
			mc.setConsumAmount(mc.getConsumAmount()-money);
			mc.setRealFlow(flow);
			mc.setRealSMSCount(sms);
			mc.setRealTalkTime(talk);
			Record r=new Record(mc.getCardNumber(),money,talk,sms,flow,"�������ײ�"+taoc);
			System.out.println(mc);
			System.out.println(r);
			int index=us.changeService(mc,r);
			
		}else {
			System.out.println("���벻ͬ");
		}
	
	
	}
}
