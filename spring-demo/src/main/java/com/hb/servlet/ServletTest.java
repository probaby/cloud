package com.hb.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class ServletTest implements Servlet{

	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		System.out.println("##init##");
	}
	
	public void service(ServletRequest re, ServletResponse res)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("##service");
		PrintWriter out = res.getWriter();
		out.println("hello this is servletService");
	}
	
	public void destroy() {
		// TODO Auto-generated method stub
		System.out.println("##destroy");
	}

	public ServletConfig getServletConfig() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getServletInfo() {
		// TODO Auto-generated method stub
		return null;
	}
}
