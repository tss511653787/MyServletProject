package app22a;

import javax.validation.Valid;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import app21b.Product;

@Controller
public class ProductController_i18n {
	final static Log logger = LogFactory.getLog(ProductController_i18n.class);

	@RequestMapping("product_input_i18n")
	public String inputProduct(Model model) {
		model.addAttribute("product_i18n", new Product_i18n());
		return "ProductForm_i18n";
	}

	@RequestMapping("product_save_i18n")
	public String saveProduct(@Valid @ModelAttribute Product_i18n product,
			BindingResult bindingResult, Model model) {

		if (bindingResult.hasErrors()) {
			logger.info("bindingResult hasEorror");
			System.out.println("has Errors!");
			FieldError fieldError = bindingResult.getFieldError();
			logger.info("Code:" + fieldError.getCode() + ", object:"
					+ fieldError.getObjectName() + ", field:"
					+ fieldError.getField());
			return "ProductForm_i18n";
		}
		// save Product Code
		else {
			System.out.println("do ProductDetails");
			model.addAttribute("product_i18n", product);
			return "ProductDetails_i18n";
		}
	}

}
