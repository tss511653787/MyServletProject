package app14a;

import javax.servlet.Servlet;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;
import javax.servlet.annotation.WebListener;

/**
 * Application Lifecycle Listener implementation class DynamicRegListener
 *
 */
@WebListener
public class DynamicRegListener implements ServletContextListener {

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
	}

	// use createServlet to obtain a Servlet instance that can be
	// configured prior to being added to ServletContext
	@Override
	public void contextInitialized(ServletContextEvent sce) {
		// 获取servletcontext对象
		ServletContext servletContext = sce.getServletContext();
		Servlet firstServlet = null;
		try {
			// 动态创建新的servlet对象
			firstServlet = servletContext.createServlet(FirstServlet.class);
		} catch (Exception e) {
			e.printStackTrace();
		}

		if (firstServlet != null && firstServlet instanceof FirstServlet) {
			((FirstServlet) firstServlet)
					.setName("Dynamically registered servlet");
		}

		// the servlet may not be annotated with @WebServlet
		// 注册新的servlet对象
		ServletRegistration.Dynamic dynamic = servletContext.addServlet(
				"firstServlet", firstServlet);
		// dynamic对象对动态创建的对象进行设置
		dynamic.addMapping("/dynamic");
	}
}
