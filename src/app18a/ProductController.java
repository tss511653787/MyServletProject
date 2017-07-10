package app18a;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

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

	@RequestMapping("/product_save3")
	public String saveProduct(ProductForm productForm, Model model) {
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
		//
		model.addAttribute("product", product);
		return "ProductDetails";
	}

}
