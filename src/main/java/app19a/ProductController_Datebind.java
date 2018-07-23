package app19a;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import app16a.Product;
import app18b.ProductController_AuotWired;
import app18b.ProductServiceImpl;

@Controller
public class ProductController_Datebind {
	private static final Log logger = LogFactory
			.getLog(ProductController_AuotWired.class);
	@Autowired
	ProductServiceImpl productService;

	@RequestMapping("/product_save_bind")
	public String saveProduct(Product product, Model model) {
		logger.info("saveProduct_AutoWired called");
		// no need to create and instantiate a ProductForm
		/*
		 * 使用数据绑定 省略了表单类(productForm)
		 */
		product = new Product();
		return "";
	}
}
