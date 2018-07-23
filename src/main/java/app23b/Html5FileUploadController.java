package app23b;

import java.io.File;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class Html5FileUploadController {
	private final static Log logger = LogFactory
			.getLog(Html5FileUploadController.class);

	@RequestMapping("/html5")
	public String inputProduct() {
		return "Html5";
	}

	@RequestMapping("/file_upload")
	public void saveFile(HttpServletRequest servletRequest,
			@ModelAttribute UploadedFile uploadedFile,
			BindingResult bindingResult, Model model) {
		MultipartFile multipartFile = uploadedFile.getMultipartFile();
		String fileName = multipartFile.getOriginalFilename();
		try {
			File file = new File(servletRequest.getServletContext()
					.getRealPath("/image"), fileName);
			multipartFile.transferTo(file);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}
