package app10a;

import java.io.IOException;
import javax.servlet.AsyncContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import app10a.MyAsyncListener;

@WebServlet(name = "AsyncListenerServlet", urlPatterns = { "/asyncListener" }, asyncSupported = true)
public class AsyncListenerServlet extends HttpServlet {
	private static final long serialVersionUID = 62738L;

	@Override
	public void doGet(final HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		final AsyncContext asyncContext = request.startAsync();
		asyncContext.setTimeout(5000);
		// 手动 addListener方法添加一个自定义监听器
		asyncContext.addListener(new MyAsyncListener());
		asyncContext.start(new Runnable() {
			@Override
			public void run() {
				try {
					Thread.sleep(3000);
				} catch (InterruptedException e) {
				}
				String greeting = "hi from listener";
				System.out.println("wait....");
				request.setAttribute("greeting", greeting);
				asyncContext.dispatch("/test.jsp");
			}
		});
	}
	
}