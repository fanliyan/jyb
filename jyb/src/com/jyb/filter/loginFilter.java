package com.jyb.filter;

import java.io.IOException;
import java.util.Map;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class loginFilter implements Filter {
		
	@Override
	public void destroy() {
		

	}

	@Override
	public void doFilter(ServletRequest arg0, ServletResponse arg1,
			FilterChain arg2) throws IOException, ServletException {
		// TODO Auto-generated method stub
		HttpServletRequest req = (HttpServletRequest) arg0;
		HttpServletResponse reps = (HttpServletResponse) arg1;
		Map map = (Map)req.getSession().getAttribute("loginList");
		String status = (String)map.get("status");
		if(status == "2" || status == "3" || req.getRequestURI().contains("jyb/admin/")){
			arg2.doFilter(arg0, arg1);
		}else{
			reps.sendRedirect("/jyb/index.jsp");
		}
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub

	}

}
