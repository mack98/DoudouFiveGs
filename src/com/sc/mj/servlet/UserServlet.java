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
		//������������ʽ
		req.setCharacterEncoding("utf-8");
		//������Ӧ����
		resp.setContentType("text/html;charset=utf-8");
		//��ȡ������
		String oper=(String) req.getParameter("oper");
		
		if("login".equals(oper))
		{
			//ת����¼
			checkUserLogin(req,resp);
		}else if("reg".equals(oper)) {
			//ת��ע��
			checkUserReg(req,resp);
		}else if("doudou".equals(oper)) {
			//ת������5G
			checkUserDou(req,resp);
		}else if("carge".equals(oper)) {
			//ת����ֵ
			checkUserCarge(req,resp);
		}else if("info".equals(oper)) {
			//ת���ʷ���Ϣ
			checkUserInfo(req,resp);
		}else if("esc".equals(oper)) {
			//ת���˳�
			checkUserEsc(req,resp);
		}
		
	}
	//ת���˳�
	private void checkUserEsc(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		// TODO Auto-generated method stub
		System.out.println("�������˳�");
		resp.sendRedirect("/DouDouFiveG/reg.jsp");
	}
	//ת���ʷ���Ϣ
	private void checkUserInfo(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		// TODO Auto-generated method stub
		System.out.println("�������ʷ�");
		resp.sendRedirect("/DouDouFiveG/reg.jsp");
	}
	//ת����ֵ
	private void checkUserCarge(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		// TODO Auto-generated method stub
		System.out.println("�����˳�ֵ");
		resp.sendRedirect("/DouDouFiveG/Charge.jsp");
	}
	//ת������5G
	private void checkUserDou(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		// TODO Auto-generated method stub
		System.out.println("�����˶���5G");
		resp.sendRedirect("/DouDouFiveG/reg.jsp");
	}
	//ת��ע��
	private void checkUserReg(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		// TODO Auto-generated method stub
		System.out.println("������ע��");
		resp.sendRedirect("/DouDouFiveG/reg.jsp");
	}
	//ת����¼
	private void checkUserLogin(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		// TODO Auto-generated method stub
		System.out.println("��¼��");
		resp.sendRedirect("/DouDouFiveG/login.jsp");
		
	}
}
