package app20a;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import org.springframework.format.Formatter;

/*
 * 定义一个实现了Formatter接口的类实现Formatter接口方法
 * 完成String--> Date的转换
 * */

public class DateFormatter implements Formatter<Date> {

	private String datePattern;
	private SimpleDateFormat simpleDateformat;

	public DateFormatter(String datePattern) {
		super();
		System.out.println("Formatter 初始化");
		this.datePattern = datePattern;
		simpleDateformat = new SimpleDateFormat(datePattern);
		simpleDateformat.setLenient(false);
	}

	/*
	 * 实现从String到T类型的转化 (反向转化)
	 */
	@Override
	public String print(Date object, Locale locale) {
		// TODO Auto-generated method stub
		return simpleDateformat.format(object);
	}

	/*
	 * 实现从T到String的转化
	 */
	@Override
	public Date parse(String text, Locale locale) throws ParseException {
		// TODO Auto-generated method stub
		try {
			return simpleDateformat.parse(text);
		} catch (Exception e) {
			// TODO: handle exception
			throw new IllegalArgumentException("(Formatter):不合法的日期输入 请使用:"
					+ datePattern + "格式 输入日期");
		}
	}
}
