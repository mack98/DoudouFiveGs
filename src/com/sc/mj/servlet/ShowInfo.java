package com.sc.mj.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.google.gson.Gson;
import com.sc.mj.pojo.MobileCard;
import com.sc.mj.service.UserService;
import com.sc.mj.service.impl.UserServiceImpl;





@WebServlet("/show")
public class ShowInfo extends HttpServlet{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		UserService us=new UserServiceImpl();
        //������������ʽ
        req.setCharacterEncoding("utf-8");
        //������Ӧ�����ʽ
        res.setContentType("text/html;charset=utf-8");
        MobileCard mc=(MobileCard)req.getSession().getAttribute("user");
        MobileCard mcc=us.getShowService(mc);
        System.out.println(mcc+"************************");
        req.setAttribute("user", mcc);
        System.out.println(mcc);
        //req.setAttribute("user", mc);
        //res.getWriter().write(new Gson().toJson(mc));
        req.getRequestDispatcher("info.jsp").forward(req, res);
	}
}
