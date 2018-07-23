package app18b;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.stereotype.Service;

import app16a.Product;

@Service
public class ProductServiceImpl implements ProductService {
	private Map<Long, Product> map = new HashMap<Long, Product>();
	private AtomicLong generator = new AtomicLong();

	// 有默认的实现
	public ProductServiceImpl() {
		super();
		Product product = new Product();
		product.setName("LP");
		product.setDescription("A neu Stu");
		product.setPrice(15);
		add(product);
	}

	@Override
	public Product add(Product product) {
		// TODO Auto-generated method stub
		// id 自增
		long newID = generator.incrementAndGet();
		product.setId(newID);
		map.put(newID, product);
		return product;
	}

	@Override
	public Product get(long id) {
		// TODO Auto-generated method stub
		return map.get(id);
	}

}
