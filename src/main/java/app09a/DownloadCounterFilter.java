package app09a;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

/**
 * Servlet Filter implementation class DownloadCounterFilter
 */
//@WebFilter(filterName = "DownloadCounterFilter", urlPatterns = { "/*" })
public class DownloadCounterFilter implements Filter {
	// **Executor框架
	ExecutorService executorService = Executors.newSingleThreadExecutor();
	Properties downloadLog;
	File logFile;

	/**
	 * Default constructor.
	 */
	public DownloadCounterFilter() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
		executorService.shutdown();
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		HttpServletRequest httpServletRequest = (HttpServletRequest) request;

		final String uri = httpServletRequest.getRequestURI();
		executorService.execute(new Runnable() {
			@Override
			public void run() {
				String property = downloadLog.getProperty(uri);
				if (property == null) {
					downloadLog.setProperty(uri, "1");
				} else {
					int count = 0;
					try {
						count = Integer.parseInt(property);
					} catch (NumberFormatException e) {
						// silent
					}
					count++;
					downloadLog.setProperty(uri, Integer.toString(count));
				}
				try {
					downloadLog.store(new FileWriter(logFile), "");
				} catch (IOException e) {
				}
			}
		});
		chain.doFilter(request, response);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
		System.out.println("DownloadCounterFilter");
		String appPath = fConfig.getServletContext().getRealPath("/");
		logFile = new File(appPath, "downloadLog.txt");
		if (!logFile.exists()) {
			try {
				logFile.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		downloadLog = new Properties();
		try {
			downloadLog.load(new FileReader(logFile));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
