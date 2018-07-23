package app21a;

import java.util.Date;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

/*
 * 实现Spring自带的Validator类
 * 校验器不需要显示注册(在Controlller中直接调用即可)
 * 在某个属性文件中获取错误信息则需声明
 * */
public class ProductValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		// 判断验证器是否可以处理指定的clazz对象
		return Product.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		// TODO Auto-generated method stub
		Product product = (Product) target;
		/*
		 * 使用ValidationUtils工具进行验证对象的feild
		 */
		/*
		 * Product对象的三个属性验证知否为空使用ValidationUtils工具类的rejectIfEmpty方法 对属性进行判空验证
		 * 如果为空则传入错误码
		 */
		ValidationUtils.rejectIfEmpty(errors, "name", "prductname.required");
		ValidationUtils.rejectIfEmpty(errors, "price", "price.required");
		ValidationUtils.rejectIfEmpty(errors, "productionDate",
				"productiondate.required");
		/*
		 * 对price和productionDate属性进行代码手动验证 如果有不符合规范则向errors中传入错误码
		 */
		// 价格不能是负值
		Float price = product.getPrice();
		if (price != null && price < 0) {
			errors.rejectValue("price", "price.negative");
		}
		// 日期不能晚于当前日期
		Date productionDate = product.getProductionDate();
		if (productionDate != null) {
			if (productionDate.after(new Date())) {
				System.out.println("please input a last Date!");
				errors.rejectValue("productionDate", "productiondate.invalid");
			}
		}
	}
}
