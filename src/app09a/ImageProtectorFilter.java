package app09a;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

/**
 * Servlet Filter implementation class ImageProtectorFilter
 */
//@WebFilter(filterName = "ImageProtetorFilter", urlPatterns = { "*.png",
//		"*.jpg", "*.gif" })
public class ImageProtectorFilter implements Filter {

	/**
	 * Default constructor.
	 */
	public ImageProtectorFilter() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		// place your code here
		System.out.println("ImageProtectorFilter");
		HttpServletRequest httpServletRequest = (HttpServletRequest) request;
		String referrer = httpServletRequest.getHeader("referer");
		System.out.println("referrer:" + referrer);
		if (referrer != null) {
			chain.doFilter(request, response);
		} else {
			throw new ServletException("Image not available");
		}
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
