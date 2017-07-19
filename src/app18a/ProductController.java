package app18a;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import app16a.Product;
import app16a.ProductForm;

/*
 * 使用基于注解的控制器
 * Spring2.5后支持
 * 
 * */
@Controller
public class ProductController {
	private static final Log logger = LogFactory
			.getLog(ProductController.class);

	@RequestMapping("/product_input3")
	public String inputProduct() {
		logger.info("基于注解InputProduct called");
		return "ProductForm";
	}

	/*
	 * 针对saveProduct方法解释： saveProduct方法是怎么写出来的？
	 * springMVC会给每个请求处理方法被调用时创建一个Model实例 Model作用是给View添加属性
	 * 这个地方的ProductForm参数应该是自动注入
	 */
	@RequestMapping("/product_save3")
	public String saveProduct(@ModelAttribute ProductForm productForm,
			Model model) {
		logger.info("基于注解SaveProduct called");
		Product product = new Product();
		product.setName(productForm.getName());
		product.setDescription(productForm.getDescription());
		try {
			product.setPrice(Float.parseFloat(productForm.getPrice()));
		} catch (Exception e) {
			// TODO: handle exception
		}
		// add product to DB code
		// save in DB
		//
		model.addAttribute("product", product);
		return "ProductDetails";
	}

}
