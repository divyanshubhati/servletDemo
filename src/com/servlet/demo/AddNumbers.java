package com.servlet.demo;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/add")
public class AddNumbers extends HttpServlet{
	
	// need to implement service method
	public void service(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException{
		int i = Integer.parseInt( req.getParameter("num1"));
		int j = Integer.parseInt( req.getParameter("num2"));
		
		int k = i+j;
		
//		PrintWriter out = res.getWriter();
//		
//		out.println("Sum is >> " + k);
		
		// forward the request to sq servlet
//		req.setAttribute("k", k);
		
		
		
//		// sq is the mapping
//		RequestDispatcher rd = req.getRequestDispatcher("sq");
//		rd.forward(req, res);
		
		// session management URL rewriting
//		res.sendRedirect("sq?k="+k);
		
		// HttpSession | Cookie
//		HttpSession session = req.getSession();
//		session.setAttribute("k", k);
//		res.sendRedirect("sq");
		
		// Session is used to maintain the login data
		
		// Cookie
		Cookie cookie = new Cookie("k", k+"");
		res.addCookie(cookie);
		res.sendRedirect("sq");
		
	}
}
