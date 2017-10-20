package com.zhku.jsj144.zk.web;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zhku.jsj144.zk.domain.User;
import com.zhku.jsj144.zk.service.UserService;
//web层
public class UserServlet extends HttpServlet {

	UserService userService=new UserService();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");//设置编码
		
		//封装数据
		User user=new User();
		String name=req.getParameter("name");
		String password=req.getParameter("password");
		user.setName(name);
		user.setPassword(password);
		
		User userLogin = null;
		try {
			userLogin = userService.login(user);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		//登录判断
		if(userLogin!=null){
//			req.setAttribute("user", userLogin);//登录成功对象
//			req.getRequestDispatcher("/success.jsp").forward(req, resp);//请求转发到成功页面
			
			req.getSession().setAttribute("user",userLogin);//保存到session域对象中，然后重定向
//			resp.sendRedirect(req.getContextPath()+"/success.jsp");
			resp.sendRedirect("/test/success.jsp");
			
		}
		else{
			req.setAttribute("msg", "对不起，登录失败，请重新输入账号密码");//登录失败信息
			req.getRequestDispatcher("/index.jsp").forward(req, resp);//请求转发到成功页面

		}
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doGet(req, resp);
	}
}
