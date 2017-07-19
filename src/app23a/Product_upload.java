package app23a;

import java.io.Serializable;
import java.util.List;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.web.multipart.MultipartFile;

/**
 * 编写上传文件类Product_upload
 * */
public class Product_upload implements Serializable {
	private static final long serialVersionUID = 74458L;
	@NotNull(message="*name can not be null")
	@Size(min = 1, max = 10, message = "name must be 1 to 10")
	private String name;

	private String description;
	private Float price;
	// MultipartFile 对象存放上传的文件实例
	@NotEmpty(message="*image can not be null")
	private List<MultipartFile> images;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Float getPrice() {
		return price;
	}

	public void setPrice(Float price) {
		this.price = price;
	}

	public List<MultipartFile> getImages() {
		return images;
	}

	public void setImages(List<MultipartFile> images) {
		this.images = images;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
