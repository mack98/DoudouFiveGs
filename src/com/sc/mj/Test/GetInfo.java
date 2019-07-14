package com.sc.mj.Test;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;
import com.sc.mj.pojo.MobileCard;
import com.sc.mj.pojo.Record;
import com.sc.mj.service.UserService;
import com.sc.mj.service.impl.UserServiceImpl;

@WebServlet("/info")
public class GetInfo extends HttpServlet{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
        //������������ʽ
        req.setCharacterEncoding("utf-8");
        //������Ӧ�����ʽ
        res.setContentType("text/html;charset=utf-8");
        //��ȡ������Ϣ
        HttpSession hs=req.getSession();
		MobileCard mc=(MobileCard) hs.getAttribute("user");
        //����������Ϣ
		String sel=req.getParameter("sel");
            //��ȡҵ������
        UserService us=new UserServiceImpl();
        
            //����ҵ������
         List<Record> r=us.geInfoToPrice(mc);
         for(Record rr:r) {
        	 System.out.println(rr);
         }
         if(r!=null)
 		{
 			req.setAttribute("record", r);
 			if(sel.equals("b")) {
 				System.out.println("��ת��");
 				req.getRequestDispatcher("bill2.jsp").forward(req, res);
 				
 			}
 			if(sel.equals("a")){
 				System.out.println("��ת��");
 				req.getRequestDispatcher("bill.jsp").forward(req, res);
 			}
 			return ;
 		}
        System.out.println("��ѯ���Ľ��:"+r);
        //��Ӧ������
        res.getWriter().write(new Gson().toJson(r));
		
		
	}
}
