package app24a;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ResourceConrtroller {

	private final static Log logger = LogFactory
			.getLog(ResourceConrtroller.class);

	@RequestMapping("/index")
	public String index(@ModelAttribute Login login, Model model) {
		model.addAttribute("login", new Login());
		return "LoginForm";
	}

	@RequestMapping("/login")
	public String login(@Valid @ModelAttribute Login login,
			BindingResult bindingResult, HttpSession session, Model model) {
		// 用户表单验证
		if (bindingResult.hasErrors()) {
			List<ObjectError> errorList = bindingResult.getAllErrors();
			for (ObjectError error : errorList) {
				System.out.println(error.getDefaultMessage());
			}
			return "LoginForm";
		} else {
			// 用户身份验证
			// model.addAttribute("login", new Login());
			if ("111".equals(login.getUserName())
					&& "111".equals(login.getPassword())) {
				session.setAttribute("loginedIn", Boolean.TRUE);
				return "Main";
			} else {
				System.out.println("用户名/密码错误");
				return "LoginForm";
			}
		}
	}

	@RequestMapping("/resource_download")
	public String downloadResource(HttpSession session,
			HttpServletRequest request, HttpServletResponse response) {
		/*
		 * 没有登录
		 */
		if (session == null || session.getAttribute("loginedIn") == null) {
			return "LoginForm";
		}
		String dataDirectorty = request.getServletContext().getRealPath(
				"/image");
		/*
		 * 从/data路径下获取secret.pdf文件
		 */
		File file = new File(dataDirectorty, "Obsidian.jar");
		if (file.exists()) {
			response.setContentType("application/pdf");
			response.addHeader("Content-Disposition",
					"attachment;filename= Obsidian.jar");
			// 读取文件
			byte[] buffer = new byte[1024];
			FileInputStream fis = null;
			BufferedInputStream bis = null;
			try {
				// 流的读写
				fis = new FileInputStream(file);
				bis = new BufferedInputStream(fis);
				OutputStream os = response.getOutputStream();
				// 默认读取的是byte数组的长度(1024)
				int i = bis.read(buffer);
				while (i != -1) {
					os.write(buffer, 0, i);
					i = bis.read(buffer);
				}
			} catch (Exception e) {
				// TODO: handle exception
			} finally {
				if (bis != null) {
					try {
						bis.close();
					} catch (Exception e2) {
						// TODO: handle exception
					}
				}
				if (fis == null) {
					try {
						fis.close();
					} catch (Exception e2) {
						// TODO: handle exception
					}
				}
			}
		} else {
			// file not exists
			logger.info("文件不存在");
			return "Main";
		}
		return null;
	}
}
