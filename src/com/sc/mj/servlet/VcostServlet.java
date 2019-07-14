package com.sc.mj.servlet;

import java.io.IOException;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sc.mj.pojo.MobileCard;
import com.sc.mj.pojo.Record;
import com.sc.mj.service.UserService;
import com.sc.mj.service.impl.UserServiceImpl;

@WebServlet("/cost")
public class VcostServlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	UserService us=new UserServiceImpl();
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		//������������ʽ
		req.setCharacterEncoding("utf-8");
		//������Ӧ����
		resp.setContentType("text/html;charset=utf-8");
		//��ȡ������
		String s=(String) req.getParameter("str");
		
		//��ȡ�û�
		HttpSession hs=req.getSession();
		MobileCard mc=(MobileCard) hs.getAttribute("user");
		//�����������
		Random r=new Random();
		int x= r.nextInt(100)+10;
		System.out.println(mc);
		Record record=null;
		if(s.equals("flow")) {
			if(mc.getRealFlow()-x<0) {
				int z=x-mc.getRealFlow();
				int y=(int) (z*0.2);
				record=new Record(mc.getCardNumber(), y, 0, 0, x,"�������г��ˣ�������"+x+"m����");
			}else {
				record=new Record(mc.getCardNumber(), 0, 0, 0, x,"�������г��ˣ�������"+x+"m����");
				
			}
		}else if(s.equals("sms")){
			if(mc.getRealSMSCount()-x<0) {
				int z=x-mc.getRealSMSCount();
				int y=(int) (z*0.2);
				record=new Record(mc.getCardNumber(), y, 0, x, 0,"Ⱥ���˶��ţ�������"+x+"������");
			}else {
				record=new Record(mc.getCardNumber(), 0, 0, x, 0,"Ⱥ���˶��ţ�������"+x+"������");
				
			}
		}else if(s.equals("talk")){
			if(mc.getRealTalkTime()-x<0) {
				int z=x-mc.getRealTalkTime();
				int y=(int) (z*0.2);
				record=new Record(mc.getCardNumber(), y, x, 0, 0,"�绰���࣬������"+x+"���ӻ���");
			}else {
				record=new Record(mc.getCardNumber(), 0, x, 0, 0,"�绰���࣬������"+x+"���ӻ���");
				
			}
		}
		
		mc.setMoney(mc.getMoney()-record.getCost());
		mc.setRealFlow(mc.getRealFlow()-record.getFlow());
		mc.setRealTalkTime(mc.getRealTalkTime()-record.getTalktime());
		mc.setRealSMSCount(mc.getRealSMSCount()-record.getSms());
		mc.setConsumAmount(mc.getConsumAmount()+record.getCost());
		int index=us.addRecord(record,mc);
		
//		HttpSession hs1=req.getSession();
//		hs1.setAttribute("record",r);
		
	}

}
