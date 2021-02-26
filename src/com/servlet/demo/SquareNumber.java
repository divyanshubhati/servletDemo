package com.servlet.demo;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
@WebServlet("/sq")
public class SquareNumber extends HttpServlet{
	// need to implement service method
		public void service(HttpServletRequest req, HttpServletResponse res) throws IOException{
//			int i = (int) req.getAttribute("k");
			
			// session management URL rewriting
//			int i = Integer.parseInt(req.getParameter("k"));
			
			PrintWriter out = res.getWriter();
			
			// Cookie | session
//			HttpSession session = req.getSession();
//			int i = (int)session.getAttribute("k");
//			out.println("Square is >> " + i*i);
			
			// cookie
			int i =0;
			Cookie cookies[]= req.getCookies();
			
			for(Cookie c : cookies) {
				if(c.getName().equals("k")) {
					i = Integer.parseInt(c.getValue());
				}
			}
			out.println("Square is >> " + i*i);
			
			
			// Servlet context | it is maintained acroos all the servlet
			ServletContext ctx = getServletContext();
			String str = ctx.getInitParameter("name");
			out.println(str);
			
			// Servlet config | not shared across the servlets
			ServletConfig cg = getServletConfig();
			String st = ctx.getInitParameter("name");
			String s = ctx.getInitParameter("phone");
			out.println(st);
			out.println(s);
			
		}

}
