package app23a;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class Product_upload_Controller {
	private static final Log logger = LogFactory
			.getLog(Product_upload_Controller.class);

	@RequestMapping("/product_input_upload")
	public String inputProduct(Model model) {
		model.addAttribute("product_upload", new Product_upload());
		return "ProductForm_upload";
	}

	@RequestMapping("/product_save_upload")
	public String saveProduct(HttpServletRequest request,
			@Valid @ModelAttribute Product_upload product_upload,
			BindingResult bindingResult, Model model) {
		// 校验器
		if (bindingResult.hasErrors()) {
			List<ObjectError> errorList = bindingResult.getAllErrors();
			for (ObjectError error : errorList) {
				System.out.println(error.getDefaultMessage());
			}
			return "ProductForm_upload";
		} else {
			// 上传图片实现
			String savePath = request.getServletContext().getRealPath("/image");
			File saveDir = new File(savePath);
			if (!saveDir.exists()) {
				saveDir.mkdir();
			}
			List<MultipartFile> files = product_upload.getImages();
			List<String> fileNames = new ArrayList<String>();
			if (files != null && files.size() > 0) {
				for (MultipartFile f : files) {
					// 获取上传文件的原始名称
					String[] arrfilename = f.getOriginalFilename().split("/");
					String filename = arrfilename[arrfilename.length - 1];
					fileNames.add(filename);
					// 在项目目录下创建Folder和上传的文件
					// File(String parent,String child) parent参数表示一个文件夹
					File imageFile = new File(saveDir, filename);
					try {
						// 保存上传文件
						// easy code
						f.transferTo(imageFile);
					} catch (IOException e) {
						// TODO: handle exception
						e.printStackTrace();
					}
				}
			}
			// Save file to DB Here
			model.addAttribute("savepath", savePath);
			model.addAttribute("product_upload", product_upload);
			return "ProductDetails_upload";
		}
	}
}
