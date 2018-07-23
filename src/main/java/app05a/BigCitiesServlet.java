package app05a;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class BigCitiesServlet
 */
@WebServlet("/BigCitiesServlet")
public class BigCitiesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public BigCitiesServlet() {
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

		Map<String, String> capitals = new HashMap<String, String>();
		capitals.put("Indonesia", "Jakarta");
		capitals.put("Malaysia", "Kuala Lumpur");
		capitals.put("Thailand", "Bangkok");
		request.setAttribute("capitals", capitals);

		Map<String, String[]> bigCities = new HashMap<String, String[]>();
		bigCities.put("Australia", new String[] { "Sydney", "Melbourne",
				"Perth" });
		bigCities.put("New Zealand", new String[] { "Auckland", "Christchurch",
				"Wellington" });
		bigCities.put("Indonesia", new String[] { "Jakarta", "Surabaya",
				"Medan" });

		request.setAttribute("capitals", capitals);
		request.setAttribute("bigCities", bigCities);
		RequestDispatcher rd = request.getRequestDispatcher("/bigCities.jsp");
		rd.forward(request, response);
	}

}
