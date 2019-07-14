package com.sc.mj.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sc.mj.pojo.MobileCard;
import com.sc.mj.service.UserService;
import com.sc.mj.service.impl.UserServiceImpl;
@WebServlet("/quit")
public class QuitServlet extends HttpServlet{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	UserService us=new UserServiceImpl();
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		//������������ʽ
		req.setCharacterEncoding("utf-8");
		//������Ӧ����
		resp.setContentType("text/html;charset=utf-8");
		//��ȡ������
		MobileCard mc=(MobileCard)req.getSession().getAttribute("user");
		System.out.println(mc);
		System.out.println("�����˻�");
		int index=us.quitService(mc);
		
	}
}
