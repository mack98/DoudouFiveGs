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
		//设置请求编码
		req.setCharacterEncoding("utf-8");
		//设置响应编码
		resp.setContentType("text/html;charset=utf-8");
		//获取操作符
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
		if(taoc.equals("话痨套餐")) {
			System.out.println("套餐确认");
			id=1;
			money=-58;
			talk=500;
			sms=30;
			flow=0;
			System.out.println(id);
		}else if(taoc.equals("超人套餐")){
			System.out.println("套餐确认");
			id=2;
			money=-78;
			talk=200;
			sms=50;
			flow=1024;
			System.out.println(id);
		}else if(taoc.equals("网虫套餐")){
			System.out.println("套餐确认");
			id=3;
			money=-68;
			talk=0;
			sms=0;
			flow=1024;
			System.out.println(id);
		}
		else {
			System.out.println("确认失败");
		}
		if(num.equals(mc.getCardNumber())) {
			System.out.println("号码相同");
			System.out.println("最终确认id"+id);
			mc.setPackageId(id);
			mc.setMoney(mc.getMoney()+money);
			mc.setConsumAmount(mc.getConsumAmount()-money);
			mc.setRealFlow(flow);
			mc.setRealSMSCount(sms);
			mc.setRealTalkTime(talk);
			Record r=new Record(mc.getCardNumber(),money,talk,sms,flow,"跟换了套餐"+taoc);
			System.out.println(mc);
			System.out.println(r);
			int index=us.changeService(mc,r);
			
		}else {
			System.out.println("号码不同");
		}
	
	
	}
}
