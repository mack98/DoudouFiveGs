package com.sc.mj.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sc.mj.pojo.MobileCard;
import com.sc.mj.service.UserService;
import com.sc.mj.service.impl.UserServiceImpl;



@WebServlet("/login")
public class LoginServlet extends HttpServlet{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	UserService us=new UserServiceImpl();
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		//设置响应编码
		resp.setContentType("text/html;charset=utf-8");
		//获取操作符
		String oper=(String) req.getParameter("oper");

		if("login".equals(oper)) {
			//登录验证
			LoginPack(req,resp);
		
		}
	
	
	}
//登录验证
	private void LoginPack(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		// TODO Auto-generated method stub
		String uname=req.getParameter("uname");
		String pwd=req.getParameter("password");
		
		MobileCard mc=us.checkLogin(uname,pwd);
		System.out.println("这是登录的"+mc);
		//判读是否取到对象
		if(mc!=null) {
			//取到了对象
			System.out.println("这里才是真的成功");
			//获取session对象
			HttpSession hs=req.getSession();
			hs.setAttribute("user", mc);
			
			
			//重定向
			resp.sendRedirect("/DoudouFiveGs/index.jsp");
		}else {
			//
			System.out.println("登录失败");
			req.setAttribute("flag", 0);
			req.getRequestDispatcher("/login.jsp").forward(req, resp);
		}
		
	}
}
