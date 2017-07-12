package app19b;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class BookServiceImpl implements BookService {
	/*
	 * 非线程安全
	 */
	private List<Category> categories;
	private List<Book> books;

	// 有一个默认的实现
	public BookServiceImpl() {
		super();
		categories = new ArrayList<Category>();
		// 四种默认的图书类
		Category cate_com = new Category(1, "computer");
		Category cate_travel = new Category(2, "Travel");
		Category cate_Health = new Category(3, "Health");
		categories.add(cate_com);
		categories.add(cate_travel);
		categories.add(cate_Health);

		// 2本默认的书籍
		books = new ArrayList<>();
		books.add(new Book(1L, "9780980839623", "Servlet & JSP: A Tutorial",
				cate_com, "Budi Kurniawan"));
		books.add(new Book(2L, "9780980839630", "C#: A Beginner's Tutorial",
				cate_com, "Jayden Ky"));

	}

	@Override
	public List<Category> getAllCategories() {
		// TODO Auto-generated method stub
		return categories;
	}

	@Override
	public Category getCategory(int id) {
		// TODO Auto-generated method stub
		for (Category c : categories) {
			if (c.getId() == id) {
				return c;
			}
		}
		return null;
	}

	@Override
	public List<Book> getAllBooks() {
		// TODO Auto-generated method stub
		return books;
	}

	@Override
	public Book save(Book book) {
		// TODO Auto-generated method stub
		book.setId(getNextId());
		books.add(book);
		return book;
	}

	@Override
	public Book update(Book book) {
		// TODO Auto-generated method stub
		int bookcount = books.size();
		// 编列books 集合 如果书的id相同就替换原来的书
		for (int i = 0; i < bookcount; i++) {
			Book savebook = books.get(i);
			if (savebook.getId() == book.getId()) {
				books.set(i, book);
				return book;
			}
		}
		return book;
	}

	@Override
	public Book get(long id) {
		// TODO Auto-generated method stub
		for (Book book : books) {
			if (id == book.getId()) {
				return book;
			}
		}
		return null;
	}

	/*
	 * 自动为图书编号
	 */
	@Override
	public long getNextId() {
		// TODO Auto-generated method stub
		Long id = 0L;
		// 找图书中编号最大值
		for (Book b : books) {
			long bookID = b.getId();
			if (bookID > id) {
				id = bookID;
			}
		}
		// 返回最大值+1为下一个编号
		return id + 1;
	}

}
