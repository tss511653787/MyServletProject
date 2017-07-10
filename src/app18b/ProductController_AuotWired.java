package app18b;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import app16a.Product;
import app16a.ProductForm;

@Controller
public class ProductController_AuotWired {
	private static final Log logger = LogFactory
			.getLog(ProductController_AuotWired.class);
	@Autowired
	ProductServiceImpl productService;

	@RequestMapping(value = "/product_save4", method = RequestMethod.POST)
	public String saveProduct(ProductForm productForm,
			RedirectAttributes redirectAttributes) {
		logger.info("saveProduct_AutoWired called");
		// no need to create and instantiate a ProductForm
		// create Product
		Product product = new Product();
		product.setName(productForm.getName());
		product.setDescription(productForm.getDescription());
		try {
			product.setPrice(Float.parseFloat(productForm.getPrice()));
		} catch (NumberFormatException e) {
		}

		// add product
		Product savedProduct = productService.add(product);

		redirectAttributes.addFlashAttribute("message",
				"The product was successfully added.");

		return "redirect:/product_view/" + savedProduct.getId();
	}

	@RequestMapping(value = "/product_view/{id}")
	public String viewProduct(@PathVariable Long id, Model model) {
		Product product = productService.get(id);
		model.addAttribute("product", product);
		return "ProductView";
	}
}
