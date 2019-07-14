package com.sc.mj.servlet;

import java.io.IOException;
import java.util.HashSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sc.mj.pojo.MobileCard;
import com.sc.mj.pojo.ServicePackages;
import com.sc.mj.service.UserService;
import com.sc.mj.service.impl.UserServiceImpl;



@WebServlet("/reg")
public class Register extends HttpServlet {
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
				String oper=(String) req.getParameter("oper");
				
				if("regsucc".equals(oper)) {
					//调用注册
					checkPack(req,resp);
				
				}
	}
//根据套餐来看资费
	private void checkPack(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		// TODO Auto-generated method stub
		System.out.println("注册成功");
		String phone=req.getParameter("num");
		String uname=req.getParameter("user");
		String pwd=req.getParameter("pwd");
		double money=Double.parseDouble(req.getParameter("money"));
		System.out.println(phone);
		String packages=req.getParameter("package");
		MobileCard mc=null;
		ServicePackages sp=new ServicePackages();
		
//		switch(packages) {
//		case "net": sp=new NetPackage();break;
//		case "talk":sp=new TalkPackage();break;
//		case "super":sp=new SuperPackage();break;
//		}
//		mc=new MobileCard(phone,uname,pwd,sp.getId(),sp,0,money,sp.getTalkTime(),sp.getSmsCount(),sp.getFlow());
		
		switch(packages) {
		case "net":sp= new ServicePackages(3,"网虫套餐",0,0,3*1024,68);break;
		case "talk":sp=new ServicePackages(1,"话痨套餐",500,30,0,58);;break;
		case "super":sp=new ServicePackages(2,"超人套餐",200,50,1*1024,78);break;
		}
//		HashSet<Record> record=new HashSet<>();
//		Record r=new Record(phone, 0, sp.getPrice(), (money-sp.getPrice()), 0,"用户注册 扣除基本套餐费用");
//		record.add(r);
		mc=new MobileCard(phone,uname,pwd,sp.getId(),sp,0,money,sp.getTalkTime(),sp.getSmsCount(),sp.getFlow());
		
		System.out.println(sp);
		System.out.println(mc);
		//调用服务层
		int index=us.userRegService(mc);
		System.out.println(index);
		if(index==0) {
			resp.sendRedirect("/DoudouFiveGs/login.jsp");
		}else {
			System.out.println("注册失败");
			resp.sendRedirect("/DoudouFiveGs/reg.jsp");
		}
		
	}
}
