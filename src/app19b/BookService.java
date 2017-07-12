package app19b;

import java.util.List;

public interface BookService {
	/*
	 * BookService接口定义了 处理图书先关方法
	 */
	List<Category> getAllCategories();

	Category getCategory(int id);

	List<Book> getAllBooks();

	Book save(Book book);

	Book update(Book book);

	Book get(long id);

	long getNextId();

}
