package app20a;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.core.convert.converter.Converter;

/*
 * 实现一个不同类型的String日期转换的转化器
 * String-->java.util.Date
 * <待转换类型,转换目标类型>
 * */
public class StringToDateConverter implements Converter<String, Date> {

	// 定义日期类型
	private String datePattern;

	public StringToDateConverter(String datePattern) {
		super();
		this.datePattern = datePattern;
		System.out.println("实例化.....使用*" + datePattern + "*模式转换");
	}

	@Override
	public Date convert(String s) {
		// TODO Auto-generated method stub
		try {
			SimpleDateFormat datefomat = new SimpleDateFormat(datePattern);
			// setLenient(false)实现严格的日期转化 eg：不把1996-13-3转换为1997-1-3
			// 对1996-13-3则报错
			datefomat.setLenient(false);
			return datefomat.parse(s);
		} catch (Exception e) {
			// TODO: handle exception
			throw new IllegalArgumentException("不合法的日期输入 请使用:" + datePattern
					+ "格式 输入日期");
		}
	}

}
