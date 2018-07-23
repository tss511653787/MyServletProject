package app10a;

import java.io.IOException;

import javax.servlet.AsyncContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AsyncDispatchServlet
 */
@WebServlet(asyncSupported = true, urlPatterns = { "/asyncDispatch" }, name = "AsyncDispatchServlet")
public class AsyncDispatchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AsyncDispatchServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(final HttpServletRequest request,
						 HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		final AsyncContext asyncContext = request.startAsync();
		request.setAttribute("MainThreader", Thread.currentThread().getName());
		asyncContext.setTimeout(5000);

		asyncContext.start(new Runnable() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				try {
					Thread.sleep(3000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				request.setAttribute("workerThreder", Thread.currentThread()
						.getName());
				asyncContext.dispatch("/threadNames.jsp");
				//asyncContext.complete();
			}
		});
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
