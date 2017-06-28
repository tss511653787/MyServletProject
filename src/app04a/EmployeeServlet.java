package app04a;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class EmployeeServlet
 */
@WebServlet(urlPatterns = { "/employee" })
public class EmployeeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public EmployeeServlet() {
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
		Address address = new Address();
		address.setStreetName("Ren Min road");
		address.setStreetNumber("5090B");
		address.setState("que");
		address.setZipCode("sy");
		address.setZipCode("A1A");
		address.setCity("cn");

		Employee em = new Employee();
		em.setId(10);
		em.setName("tss");
		em.setAddress(address);
		request.setAttribute("employee", em);

		Map<String, String> capitals = new HashMap<String, String>();
		capitals.put("china", "beijing");
		capitals.put("USA", "HuaShengDun");
		request.setAttribute("captials", capitals);
		RequestDispatcher rd = request.getRequestDispatcher("/employee.jsp");
		rd.forward(request, response);
	}

}
