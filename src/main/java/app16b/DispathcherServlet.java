package app16b;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DispathcherServlet
 */
@WebServlet(name = "DispathcherServlet", urlPatterns = {
		"/product_input.action", "/product_save.action" })
public class DispathcherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DispathcherServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		process(request, response);
	}

	private void process(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String uri = request.getRequestURI();
		/*
		 * uri is in this form: /contextName/resourceName, for example:
		 * /app10a/product_input. However, in the event of a default context,
		 * the context name is empty, and uri has this form /resourceName, e.g.:
		 * /product_input
		 */
		// 截取最后一段string为action
		int lastIndex = uri.lastIndexOf("/");
		String action = uri.substring(lastIndex + 1);
		String dispatherURL = null;
		if (action.equals("product_input.action")) {
			InputProductController controller = new InputProductController();
			dispatherURL = controller.handleRequest(request, response);

		} else if (action.equals("product_save.action")) {
			SaveProductController controller = new SaveProductController();
			dispatherURL = controller.handleRequest(request, response);
		}
		if (dispatherURL != null) {
			// 转发返回的URL结果
			RequestDispatcher dispather = request
					.getRequestDispatcher(dispatherURL);
			dispather.forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		process(request, response);
	}

}
