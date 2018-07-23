package app21a;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ProductController_Validator {
	private static final Log logger = LogFactory
			.getLog(ProductController_Validator.class);

	@RequestMapping("/product_input")
	public String inputProduct(Model model) {
		model.addAttribute("product", new Product());
		return "ProductForm_Validator";
	}

	@RequestMapping("/product_save")
	public String saveProduct(@ModelAttribute Product product,
			BindingResult bindingResult, Model model) {
		// 调用校验器
		ProductValidator productValidator = new ProductValidator();
		productValidator.validate(product, bindingResult);
		// BindingResult 存放所有绑定错误 校验器的validate方法 也是将校验的错误全部放到绑定错误结果当中
		if (bindingResult.hasErrors()) {
			FieldError fieldError = bindingResult.getFieldError();
			logger.info("code" + fieldError.getCode() + ", field"
					+ fieldError.getField());
			return "ProductForm_Validator";
		}
		// save product in DB
		// code
		model.addAttribute("product", product);
		return "ProductDetails";
	}

	/*
	 * 使用校验器的另一种方法是在Contoller中编写initBinder方法并将校验器传到WebDataBinder 并调用其validat方法
	 * 如果使用这个注解就不用在上面方法中显示调用 productValidator.validate(product, bindingResult)
	 */
	// @InitBinder
	public void initBinder(WebDataBinder binder) {
		logger.info("initBinder in ProductController");
		binder.addValidators(new ProductValidator());
		binder.initDirectFieldAccess();
		binder.setDisallowedFields("id");
		binder.setRequiredFields("name", "description", "price");
	}
}
