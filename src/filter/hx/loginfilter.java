package filter.hx;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.system.UserInfo;

public class loginfilter implements Filter{

	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	public void doFilter(ServletRequest arg0, ServletResponse arg1,
			FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		HttpServletRequest req=(HttpServletRequest) arg0;
		HttpServletResponse res=(HttpServletResponse) arg1;
		//获得请求的URL
		String url=req.getRequestURL().toString();
		System.out.println(url);
		//获得session中的对象
		HttpSession session= req.getSession();
		UserInfo user=(UserInfo) session.getAttribute("user");
		//使用endsWith()判断url结尾的字符串
		if(url.endsWith("userlogin.jsp") || user!=null||url.endsWith("register.jsp")|| url.endsWith(".css") || 
		url.endsWith(".js")|| url.endsWith(".gif")|| url.endsWith(".png")|| url.endsWith(".jpg")
		|| url.endsWith("index.jsp")|| url.endsWith("WebProject/")|| url.endsWith("register")
		|| url.endsWith("login")|| url.endsWith(".jsp"))
		{
		//满足条件就继续执行
		chain.doFilter(arg0, arg1);
		}else{
		//不满足条件就跳转到其他页面
		PrintWriter out=res.getWriter();
		out.print("<script>alert('请登录！…………');</script>");
		//
		res.sendRedirect(req.getContextPath() + "/jsp/userlogin.jsp"); 
		}

	}

	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}

}
