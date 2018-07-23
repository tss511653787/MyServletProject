package app17a;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.servlet.ModelAndView;

//这里实现的Controller是SpringMVC中的Controller
public class InputProductController implements
		org.springframework.web.servlet.mvc.Controller {
	// 记录日志类
	private static final Log logger = LogFactory
			.getLog(InputProductController.class);

	@Override
	public ModelAndView handleRequest(HttpServletRequest arg0,
			HttpServletResponse arg1) throws Exception {
		// TODO Auto-generated method stub
		logger.info("InputProductController (实现SpringMVC的Controller)called");
		// 基于viewResolver写法
		return new ModelAndView("ProductForm");
	}
}
