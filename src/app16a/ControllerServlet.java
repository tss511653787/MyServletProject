package app16a;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ControllerServlet 阐述了MVC模式原理
 * 还没有正式涉及到Spring和SpringMVC模式
 */
// @WebServlet(name = "ControllerServlet", urlPatterns = {
// "/product_input.action", "/product_save.action" })
public class ControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ControllerServlet() {
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

	/*
	 * 整个逻辑中最重要方法
	 */
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
		// 执行action
		if (action.equals("product_input.action")) {
			// 执行input逻辑
			// 无实际逻辑

		} else if (action.equals("product_save.action")) {
			// 执行save逻辑
			// 建立Form
			ProductForm productForm = new ProductForm();
			// 执行属性
			productForm.setName(request.getParameter("name"));
			productForm.setPrice(request.getParameter("price"));
			productForm.setDescription(request.getParameter("description"));
			// 创建模型
			Product product = new Product();
			product.setName(productForm.getName());
			product.setDescription(productForm.getDescription());
			product.setPrice(Float.parseFloat(productForm.getPrice()));
			// save逻辑 存贮到数据库中 (这部分代码还没有实现)
			SaveProductAction saveproductacton = new SaveProductAction();
			saveproductacton.save(product);
			// 持久化
			request.setAttribute("product", product);
		}
		// 对视图进行转发
		String dispathurl = null;
		if (action.equals("product_input.action")) {
			dispathurl = "/ProductFrom.jsp";
		} else if (action.equals("product_save.action")) {
			dispathurl = "/ProductDetails.jsp";
		}
		if (dispathurl != null) {
			RequestDispatcher dispatcher = request
					.getRequestDispatcher(dispathurl);
			dispatcher.forward(request, response);
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
