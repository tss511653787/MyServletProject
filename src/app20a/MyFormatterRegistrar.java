package app20a;

import org.springframework.format.FormatterRegistrar;
import org.springframework.format.FormatterRegistry;

/*
 * 使用实现了FormatterRegistrar的Registrar来注册Formatter
 * */
public class MyFormatterRegistrar implements FormatterRegistrar {
	private String pattern;

	public MyFormatterRegistrar(String pattern) {
		super();
		this.pattern = pattern;
		System.out.println("Registrar 初始化");
	}

	@Override
	public void registerFormatters(FormatterRegistry registry) {
		// TODO Auto-generated method stub
		registry.addFormatter(new DateFormatter(pattern));
	}

}
