package com.sc.mj.servlet;

import java.io.IOException;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/user")
public class UserServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//设置请求编码格式
		req.setCharacterEncoding("utf-8");
		//设置响应编码
		resp.setContentType("text/html;charset=utf-8");
		//获取操作符
		String oper=(String) req.getParameter("oper");
		
		if("login".equals(oper))
		{
			//转跳登录
			checkUserLogin(req,resp);
		}else if("reg".equals(oper)) {
			//转跳注册
			checkUserReg(req,resp);
		}else if("doudou".equals(oper)) {
			//转跳兜兜5G
			checkUserDou(req,resp);
		}else if("carge".equals(oper)) {
			//转跳充值
			checkUserCarge(req,resp);
		}else if("info".equals(oper)) {
			//转跳资费信息
			checkUserInfo(req,resp);
		}else if("esc".equals(oper)) {
			//转跳退出
			checkUserEsc(req,resp);
		}
		
	}
	//转跳退出
	private void checkUserEsc(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		// TODO Auto-generated method stub
		System.out.println("进入了退出");
		resp.sendRedirect("/DouDouFiveG/reg.jsp");
	}
	//转跳资费信息
	private void checkUserInfo(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		// TODO Auto-generated method stub
		System.out.println("进入了资费");
		resp.sendRedirect("/DouDouFiveG/reg.jsp");
	}
	//转跳充值
	private void checkUserCarge(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		// TODO Auto-generated method stub
		System.out.println("进入了充值");
		resp.sendRedirect("/DouDouFiveG/Charge.jsp");
	}
	//转跳兜兜5G
	private void checkUserDou(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		// TODO Auto-generated method stub
		System.out.println("进入了兜兜5G");
		resp.sendRedirect("/DouDouFiveG/reg.jsp");
	}
	//转跳注册
	private void checkUserReg(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		// TODO Auto-generated method stub
		System.out.println("进入了注册");
		resp.sendRedirect("/DouDouFiveG/reg.jsp");
	}
	//转跳登录
	private void checkUserLogin(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		// TODO Auto-generated method stub
		System.out.println("登录了");
		resp.sendRedirect("/DouDouFiveG/login.jsp");
		
	}
}
