package app19a;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import app16a.Product;
import app16a.ProductForm;
import app18b.ProductController_AuotWired;
import app18b.ProductServiceImpl;

@Controller
public class ProductController_UseModelAttribute {
	private static final Log logger = LogFactory
			.getLog(ProductController_AuotWired.class);
	@Autowired
	ProductServiceImpl productService;

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

		// add product：将每个product在重定位前加入到productService对象中
		//
		Product savedProduct = productService.add(product);

		redirectAttributes.addFlashAttribute("message",
				"The product was successfully added.");

		return "redirect:/product_view/" + savedProduct.getId();
	}

	// ModelAttribute注解表述的方法在请求方法前执行
	// 情况1 如果有返回值 则自动加入到Model对象
	@ModelAttribute
	public Product addInProductSevice(@RequestParam Long productID) {
		return productService.get(productID);
	}

	// 情况2 如果void 则需显示给一个Model参数 加入到其中
	public void addInProductService2(@RequestParam Long productID, Model model) {
		// TODO Auto-generated method stub
		model.addAttribute(productID);
	}
}
