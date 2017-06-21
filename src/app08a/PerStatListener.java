package app08a;

import javax.servlet.ServletContext;
import javax.servlet.ServletRequest;
import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpServletRequest;

/*
 * 计算一次http请求的时间
 * */
//@WebListener
public class PerStatListener implements ServletRequestListener {

	@Override
	public void requestDestroyed(ServletRequestEvent sre) {
		// TODO Auto-generated method stub
		ServletRequest sr = sre.getServletRequest();
		Long start = (Long) sr.getAttribute("start");
		Long end = System.nanoTime();
		HttpServletRequest httpsr = (HttpServletRequest) sr;
		String uri = httpsr.getRequestURI();
		System.out.println("time token to execute:" + uri + ":"
				+ ((end - start) / 1000) + "  microsecnds");
	}

	@Override
	public void requestInitialized(ServletRequestEvent sre) {
		// TODO Auto-generated method stub
		ServletRequest sr = sre.getServletRequest();
		sr.setAttribute("start", System.nanoTime());
	}

}
