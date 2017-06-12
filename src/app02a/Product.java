package app02a;

public class Product {
	private int id;
	private String name;
	private String description;
	private float price;

	public Product(int id, String name, String descriptiob, float price) {
		super();
		this.id = id;
		this.name = name;
		this.description = descriptiob;
		this.price = price;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String descriptiob) {
		this.description = descriptiob;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

}
