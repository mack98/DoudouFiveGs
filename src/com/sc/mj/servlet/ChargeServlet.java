package com.sc.mj.servlet;

import java.io.IOException;
import java.io.InputStream;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.sc.mj.pojo.Record;
import com.sc.mj.service.UserService;
import com.sc.mj.service.impl.UserServiceImpl;


@WebServlet("/charge")
public class ChargeServlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	UserService us=new UserServiceImpl();
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//�����������
		req.setCharacterEncoding("utf-8");
		//������Ӧ����
		resp.setContentType("text/html;charset=utf-8");
		//��ȡ������
		String oper=(String) req.getParameter("oper");
		String num=req.getParameter("num");
		double money=Double.parseDouble(req.getParameter("money"));
		System.out.println("================"+money);
		Record r;
		if(money>0) {
			r=new Record(num,money,0,0,0,"��ֵ��"+money+"Ԫ");
		}else {
			
			r=new Record(num,money,0,0,0,"������"+money+"Ԫ");
		}
		int index=us.updataCharge(num,money,r);
		resp.sendRedirect("/DoudouFiveGs/index.jsp");
		

	}
}
