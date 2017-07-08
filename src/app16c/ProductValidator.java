package app16c;

import java.util.ArrayList;
import java.util.List;

import app16a.ProductForm;

/*
 * 校验类 用于对app16b用户输入表单校验
 * */
public class ProductValidator {
	public List<String> validate(ProductForm productForm) {
		List<String> errors = new ArrayList<String>();
		String name = productForm.getName();
		if (name == null || name.trim().isEmpty()) {
			errors.add("Product must has a name");
		}
		String price = productForm.getPrice();
		if (price == null || price.trim().isEmpty()) {
			errors.add("Product must has a price");
		}
		try {
			Float.parseFloat(price);
		} catch (Exception e) {
			// TODO: handle exception
			errors.add("Invalid price!");
		}
		// 如果返回是一个空列表则表示输入合法
		return errors;
	}
}
