package app18b;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import app16a.Product;

/*
 * 复习一下基于构造器和基于setter的依赖注入
 * */

public class XmlNewObj {
	public static void main(String[] args) {
		String[] paths = { "app18b/ConstructAndSetter.xml" };
		@SuppressWarnings("resource")
		// ClassPathXmlApplicationContext尝试在类加载路径中加载
		ApplicationContext context = new ClassPathXmlApplicationContext(paths);
		// constructor
		Product pro_contrs = context.getBean("Product_constr", Product.class);
		// setter
		Product pro_setter = context.getBean("Product2_setter", Product.class);
		System.out.println(pro_contrs + " " + pro_setter);
	}

}
