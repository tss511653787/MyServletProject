package app21b;

import java.util.List;

import javax.validation.Valid;
import javax.validation.Validation;
import javax.validation.ValidatorFactory;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ProductController_JSR303 {

	private static final Log logger = LogFactory
			.getLog(ProductController_JSR303.class);

	@RequestMapping(value = "/product_input_JSR303")
	public String inputProduct(Model model) {
		model.addAttribute("product", new Product());
		return "ProductForm_JSR303";
	}

	@RequestMapping(value = "/product_save_JSR303")
	public String saveProduct(@Valid @ModelAttribute Product product,
			BindingResult bindingResult, Model model) {

		if (bindingResult.hasErrors()) {
			// FieldError fieldError = bindingResult.getFieldError();
			// logger.info("Code:" + fieldError.getCode() + ", object:"
			// + fieldError.getObjectName() + ", field:"
			// + fieldError.getField());
			List<ObjectError> errorList = bindingResult.getAllErrors();
			for (ObjectError error : errorList) {
				System.out.println(error.getDefaultMessage());
			}
			return "ProductForm_JSR303";
		}

		// save product here

		model.addAttribute("product", product);
		return "ProductDetails";
	}

}
