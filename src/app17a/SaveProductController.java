package app17a;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import app16a.Product;
import app16a.ProductForm;

public class SaveProductController implements Controller {
	private static final Log logger = LogFactory
			.getLog(SaveProductController.class);

	@Override
	public ModelAndView handleRequest(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		logger.info("SaveProductController(实现SpringMVC的Controller)called");
		ProductForm productform = new ProductForm();
		productform.setName(request.getParameter("name"));
		productform.setDescription(request.getParameter("description"));
		productform.setPrice(request.getParameter("price"));
		// 创建model
		Product product = new Product();
		product.setName(productform.getName());
		product.setDescription(productform.getDescription());
		try {
			product.setPrice(Float.parseFloat(productform.getPrice()));
		} catch (Exception e) {
			// TODO: handle exception
		}
		// 基于viewResolver写法
		return new ModelAndView("ProductDetails", "product", product);
	}

}
