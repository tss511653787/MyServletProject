package app01a;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

/**
 * Servlet implementation class ServletConfigDemoServlet
 */
// 方法1：使用注解传入
@WebServlet(name = "ServletConfigDemoServlet", urlPatterns = { "/servletConfigDemo" }, initParams = {
		@WebInitParam(name = "admin", value = "Harry Taciak"),
		@WebInitParam(name = "email", value = "admin@example.com") })
//方法2：使用部署描述符文件
public class ServletConfigDemoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private transient ServletConfig servletConfig;

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public ServletConfig getServletConfig() {
		return servletConfig;
	}

	@Override
	public void service(ServletRequest req, ServletResponse res)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		ServletConfig servletconfig = getServletConfig();
		String admin = servletconfig.getInitParameter("admin");
		String email = servletconfig.getInitParameter("email");
		res.setContentType("text/html");
		PrintWriter out = res.getWriter();
		out.print("<html><head>ServletDemo : </head><body>" + admin
				+ "<br/> Email:" + email + "</body></html>");
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		super.destroy();
	}

	@Override
	public String getServletInfo() {
		// TODO Auto-generated method stub
		return "This is a ServletCofigDemo";
	}

	@Override
	public void init(ServletConfig servletconfig) throws ServletException {
		// TODO Auto-generated method stub
		this.servletConfig = servletconfig;
	}

}
