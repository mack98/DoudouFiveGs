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
		//������Ӧ����
		resp.setContentType("text/html;charset=utf-8");
		//��ȡ������
		String oper=(String) req.getParameter("oper");

		if("login".equals(oper)) {
			//��¼��֤
			LoginPack(req,resp);
		
		}
	
	
	}
//��¼��֤
	private void LoginPack(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		// TODO Auto-generated method stub
		String uname=req.getParameter("uname");
		String pwd=req.getParameter("password");
		
		MobileCard mc=us.checkLogin(uname,pwd);
		System.out.println("���ǵ�¼��"+mc);
		//�ж��Ƿ�ȡ������
		if(mc!=null) {
			//ȡ���˶���
			System.out.println("���������ĳɹ�");
			//��ȡsession����
			HttpSession hs=req.getSession();
			hs.setAttribute("user", mc);
			
			
			//�ض���
			resp.sendRedirect("/DoudouFiveGs/index.jsp");
		}else {
			//
			System.out.println("��¼ʧ��");
			req.setAttribute("flag", 0);
			req.getRequestDispatcher("/login.jsp").forward(req, resp);
		}
		
	}
}
