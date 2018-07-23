package app01a;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;

/**
 * Servlet implementation class GenericServletDemo
 */
@WebServlet(name = "GenericServletDemo", urlPatterns = { "/GenericServletDemo" }, initParams = {
		@WebInitParam(name = "admin", value = "Harry Taciak"),
		@WebInitParam(name = "email", value = "admin@example.com") })
public class GenericServletDemo extends GenericServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see GenericServlet#GenericServlet()
	 */
	public GenericServletDemo() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see Servlet#service(ServletRequest request, ServletResponse response)
	 */
	public void service(ServletRequest request, ServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		ServletConfig servletconfig = getServletConfig();
		String admin = servletconfig.getInitParameter("admin");
		String email = servletconfig.getInitParameter("email");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.print("<html><head>ServletDemo : </head><body>" + admin
				+ "<br/> Email:" + email + "</body></html>");
	}

}
