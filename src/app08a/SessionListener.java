package app08a;

import java.util.concurrent.atomic.AtomicInteger;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionBindingListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

@WebListener
public class SessionListener implements HttpSessionListener,
		ServletContextListener, HttpSessionBindingListener {

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		// TODO Auto-generated method stub
		ServletContext sc = sce.getServletContext();
		sc.setAttribute("userConunter", new AtomicInteger());
	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		// TODO Auto-generated method stub

	}

	@Override
	public void sessionCreated(HttpSessionEvent se) {
		// TODO Auto-generated method stub
		HttpSession hs = se.getSession();
		ServletContext sc = hs.getServletContext();
		AtomicInteger userCounter = (AtomicInteger) sc
				.getAttribute("userConunter");
		// 数量加一
		int userCount = userCounter.incrementAndGet();
		System.out.println("userCount increase to:" + userCount);

	}

	@Override
	public void sessionDestroyed(HttpSessionEvent se) {
		// TODO Auto-generated method stub
		HttpSession hs = se.getSession();
		ServletContext sc = hs.getServletContext();
		AtomicInteger userCounter = (AtomicInteger) sc
				.getAttribute("userConunter");
		// 数量减一
		int userCount = userCounter.decrementAndGet();
		System.out.println("-------userCount decremented to:" + userCount);
	}

	@Override
	public void valueBound(HttpSessionBindingEvent event) {
		// TODO Auto-generated method stub
		String attributeName = event.getName();
		System.out.println(attributeName + "bind");
	}

	@Override
	public void valueUnbound(HttpSessionBindingEvent event) {
		// TODO Auto-generated method stub
		String attributeName = event.getName();
		System.out.println(attributeName + "Unbind");
	}

}
