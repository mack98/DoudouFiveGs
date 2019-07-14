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
		
        //设置请求编码格式
        req.setCharacterEncoding("utf-8");
        //设置响应编码格式
        res.setContentType("text/html;charset=utf-8");
        //获取请求信息
        HttpSession hs=req.getSession();
		MobileCard mc=(MobileCard) hs.getAttribute("user");
        //处理请求信息
		String sel=req.getParameter("sel");
            //获取业务层对象
        UserService us=new UserServiceImpl();
        
            //处理业务层对象
         List<Record> r=us.geInfoToPrice(mc);
         for(Record rr:r) {
        	 System.out.println(rr);
         }
         if(r!=null)
 		{
 			req.setAttribute("record", r);
 			if(sel.equals("b")) {
 				System.out.println("跳转了");
 				req.getRequestDispatcher("bill2.jsp").forward(req, res);
 				
 			}
 			if(sel.equals("a")){
 				System.out.println("跳转了");
 				req.getRequestDispatcher("bill.jsp").forward(req, res);
 			}
 			return ;
 		}
        System.out.println("查询到的结果:"+r);
        //响应处理结果
        res.getWriter().write(new Gson().toJson(r));
		
		
	}
}
