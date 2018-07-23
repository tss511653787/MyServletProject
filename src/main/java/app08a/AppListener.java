package app08a;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

//@WebListener
public class AppListener implements ServletContextListener {

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		// TODO Auto-generated method stub
		System.out.println("ServletContext Listener Start");
		ServletContext servletcontent = sce.getServletContext();
		Map<String, String> map = new HashMap<String, String>();
		map.put("bac", "kk");
		map.put("nnn", "ss");
		servletcontent.setAttribute("map", map);
	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		// TODO Auto-generated method stub
		System.out.println("Listener Stop");
	}

}
