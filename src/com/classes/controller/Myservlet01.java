package com.classes.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.omg.CORBA.Request;

import com.classes.dao.vo.Goods;
import com.classes.dao.vo.Users;
import com.classes.service.UsersService;



public class Myservlet01 extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doPost(req, resp);
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
		String op=req.getParameter("op");
		if("logiN".equals(op)) {
			this.login(req, resp);
		}else if("indexU".equals(op)) {
			this.index(req, resp);
		}else if("addU".equals(op)) {
			this.addUser(req, resp);
		}else if("logiN1".equals(op)) {
			this.login1(req, resp);
		}else if("addU1".equals(op)) {
			this.addU1(req, resp);
		}else if("selectGoods".equals(op)) {
			this.selectGoods(req, resp);
		}
	
	}
	
	public void selectGoods(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException
	{
		String gid=req.getParameter("gid");
		int gids=Integer.parseInt(gid);
		UsersService us=new UsersService();
		PrintWriter out=resp.getWriter();
		Goods goods=new Goods();
		goods=us.selectGoods(gids);
//		out.println(goods.getGname());  到这一步已经从liebiao.jsp获取了用户点击的商品，接下来跳向商品详情页面xiangqing.jsp
		req.setAttribute("goods", goods);
		req.getRequestDispatcher("xiangqing.jsp").forward(req, resp);
		
	}
	
	public void login(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		resp.setContentType("text/html;charset=utf-8");
		
		String username=req.getParameter("username");
		String password=req.getParameter("password");
		
		System.out.println(username+"======"+password);
		Users u=new Users();
		u.setUsername(username);
		u.setPassword(password);
		
		UsersService us=new UsersService();
		Users user=us.login(u);
		PrintWriter out=resp.getWriter();
		
		if(user==null) {
			out.println("<script type=\"text/javascript\">\r\n" +"alert(\"登陆成功\");\r\n"+"location(\"MySer?op=logiN\");\r\n" + "</script>");
			req.getRequestDispatcher("login.jsp").forward(req, resp);
		}else {
			out.println("<script type=\"text/javascript\">\r\n" + "alert(\"登陆成功\");\r\n" + "location(\"MySer?op=indexU\");\r\n" + "</script>");
		}
	}
	
	public void index(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("index.jsp").forward(req, resp);
	}
	
	
	public void addUser(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		resp.setContentType("text/html;charset=utf-8");
		String username=req.getParameter("username");
		String password=req.getParameter("password");
		String repassword=req.getParameter("repassword");
		String phone=req.getParameter("tel");
		
		Users u = new Users();
		u.setUsername(username);
		if(password.equals(repassword)) {
			u.setPassword(password);
		}
		u.setPhone(phone);
		
		
		UsersService us=new UsersService();
		int i=us.addUser(u);
		PrintWriter out = resp.getWriter();
		if(i>0) {
			out.println("<script type=\"text/javascript\">\r\n" + "alert(\"注册成功\");\r\n" + "</script>");
			req.getRequestDispatcher("login.jsp").forward(req, resp);
		}else {
			out.println("<script type=\"text/javascript\">\r\n" + "alert(\"注册失败\");\r\n" + "</script>");
			req.getRequestDispatcher("register.jsp").forward(req, resp);
		}
	}
	
	public void login1(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("login.jsp").forward(req, resp);
	}
	
	public void addU1(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("register.jsp").forward(req, resp);
	}
}
