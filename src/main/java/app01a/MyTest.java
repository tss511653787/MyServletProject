package app01a;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

/**
 * Servlet implementation class MyTest
 */
@WebServlet(description = "My servlet Test", urlPatterns = { "/MyTest" })
public class MyTest extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private transient ServletConfig servletConfig;

	/**
	 * @see HttpServlet#HttpServlet()
	 */

	@Override
	public void init(ServletConfig servletConfig) throws ServletException {
		// TODO Auto-generated method stub
		this.servletConfig = servletConfig;
	}

	@Override
	public void service(ServletRequest req, ServletResponse res)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String servletname = servletConfig.getServletName();
		res.setContentType("text/html");
		PrintWriter out = res.getWriter();
		out.print("<html><head>Test:</head>" + "<body>Hello My Servlert from"
				+ servletname + "</body></html>");
		out.close();
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		super.destroy();
	}

	@Override
	public ServletConfig getServletConfig() {
		// TODO Auto-generated method stub
		return super.getServletConfig();
	}

	@Override
	public String getServletInfo() {
		// TODO Auto-generated method stub
		return "My Servlet";
	}

}
