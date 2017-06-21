package app09a;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.http.HttpServletRequest;

/**
 * Servlet Filter implementation class LoggingFilter
 */
//@WebFilter(filterName = "LoggingFilter", urlPatterns = { "/*" }, initParams = {
//		@WebInitParam(name = "logFileName", value = "log.txt"),
//		@WebInitParam(name = "prefix", value = "URI: ") })
public class LoggingFilter implements Filter {
	// 输出
	private PrintWriter logger;
	// 前缀
	private String prefix;

	/**
	 * Default constructor.
	 */
	public LoggingFilter() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
		System.out.println("destory filter");
		if (logger != null) {
			logger.close();
		}
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		// place your code here
		// 记录日志信息
		System.out.println("LoggingFilter.doFilter");
		HttpServletRequest hsr = (HttpServletRequest) request;
		logger.println(new Date() + " " + prefix + hsr.getRequestURI());
		logger.flush();

		/*
		 * 这里如果想实现链条就需要维持另一个filter的引用 然后调用另一个filter的dofilter方法
		 * eg：filter02.doFilter(request,response,chain);
		 */
		// pass the request along the filter chain
		chain.doFilter(request, response);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
		// 创建日志文件
		prefix = fConfig.getInitParameter("prefix");
		String logFileName = fConfig.getInitParameter("logFileName");
		String appPath = fConfig.getServletContext().getRealPath("/");
		System.out.println("logFileName" + logFileName);
		try {
			logger = new PrintWriter(new File(appPath, logFileName));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
