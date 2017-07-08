package app16b;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import app16a.Product;
import app16a.ProductForm;
import app16a.SaveProductAction;
import app16c.ProductValidator;

public class SaveProductController implements Controller {

	@Override
	public String handleRequest(HttpServletRequest request,
			HttpServletResponse response) {
		// TODO Auto-generated method stub
		ProductForm productForm = new ProductForm();
		// 执行属性
		productForm.setName(request.getParameter("name"));
		productForm.setPrice(request.getParameter("price"));
		productForm.setDescription(request.getParameter("description"));
		// 调用校验器
		ProductValidator validator = new ProductValidator();
		List<String> error = validator.validate(productForm);
		if (error.isEmpty()) {
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
			return "/ProductDetails.jsp";
		} else {
			request.setAttribute("error", error);
			request.setAttribute("form", productForm);
			return "/ProductFrom.jsp";
		}

	}

}
