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

		//设置请求编码格式
		req.setCharacterEncoding("utf-8");
		//设置响应编码
		resp.setContentType("text/html;charset=utf-8");
		//获取操作符
		String s=(String) req.getParameter("str");
		
		//获取用户
		HttpSession hs=req.getSession();
		MobileCard mc=(MobileCard) hs.getAttribute("user");
		//随机消费数组
		Random r=new Random();
		int x= r.nextInt(100)+10;
		System.out.println(mc);
		Record record=null;
		if(s.equals("flow")) {
			if(mc.getRealFlow()-x<0) {
				int z=x-mc.getRealFlow();
				int y=(int) (z*0.2);
				record=new Record(mc.getCardNumber(), y, 0, 0, x,"上网进行冲浪，消耗了"+x+"m流量");
			}else {
				record=new Record(mc.getCardNumber(), 0, 0, 0, x,"上网进行冲浪，消耗了"+x+"m流量");
				
			}
		}else if(s.equals("sms")){
			if(mc.getRealSMSCount()-x<0) {
				int z=x-mc.getRealSMSCount();
				int y=(int) (z*0.2);
				record=new Record(mc.getCardNumber(), y, 0, x, 0,"群发了短信，消耗了"+x+"条短信");
			}else {
				record=new Record(mc.getCardNumber(), 0, 0, x, 0,"群发了短信，消耗了"+x+"条短信");
				
			}
		}else if(s.equals("talk")){
			if(mc.getRealTalkTime()-x<0) {
				int z=x-mc.getRealTalkTime();
				int y=(int) (z*0.2);
				record=new Record(mc.getCardNumber(), y, x, 0, 0,"电话煲粥，消耗了"+x+"分钟话费");
			}else {
				record=new Record(mc.getCardNumber(), 0, x, 0, 0,"电话煲粥，消耗了"+x+"分钟话费");
				
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
