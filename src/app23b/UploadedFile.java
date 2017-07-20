package app23b;

import java.io.Serializable;

import org.springframework.web.multipart.MultipartFile;

/*
 * 构建一个HTML5 上传文件的DEMO
 * */
public class UploadedFile implements Serializable {
	// 只有一个MltipartFile 对象来进行上传文件操作
	private MultipartFile multipartFile;

	public MultipartFile getMultipartFile() {
		return multipartFile;
	}

	public void setMultipartFile(MultipartFile multipartFile) {
		this.multipartFile = multipartFile;
	}

}
