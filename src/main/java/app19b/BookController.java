package app19b;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/*
 * BookController类 响应请求
 * 处理请求方法
 * */
@Controller
public class BookController {
	/*
	 * 依赖注入一个bookService接口的实例 这里面就是bookServiceImpl
	 */
	@Autowired
	private BookService bookService;

	private static final Log logger = LogFactory.getLog(BookController.class);

	// 响应添加图书请求
	@RequestMapping("/book_input")
	public String inputBook(Model model) {
		logger.info("book input");
		List<Category> categories = bookService.getAllCategories();
		model.addAttribute("categories", categories);
		model.addAttribute("book", new Book());
		return "BookAddForm";
	}

	// 响应编辑图书请求
	@RequestMapping("/book_edit/{id}")
	public String editBook(Model model, @PathVariable long id) {
		logger.info("book edit");
		List<Category> categories = bookService.getAllCategories();
		model.addAttribute("categories", categories);
		Book book = bookService.get(id);
		model.addAttribute("book", book);
		return "BookEditForm";
	}

	// 响应存贮图书请求
	@RequestMapping("/book_save")
	public String saveBook(@ModelAttribute Book book) {
		// @ModelAttribute Book book 自动创建book对象添加到Model中
		// 获取要存储图书的类别
		logger.info("book save");
		Category category = bookService.getCategory(book.getCategory().getId());
		book.setCategory(category);
		bookService.save(book);
		return "redirect:/book_list";
	}

	// 响应更新图书请求
	@RequestMapping("/book_edit/book_update")
	public String updateBook(@ModelAttribute Book book) {
		logger.info("book update");
		Category category = bookService.getCategory(book.getCategory().getId());
		book.setCategory(category);
		bookService.update(book);
		return "redirect:/book_list";
	}

	// 响应显示图书请求
	@RequestMapping("/book_list")
	public String listBooks(Model model) {
		logger.info("Book_list");
		List<Book> boolList = bookService.getAllBooks();
		model.addAttribute("books", boolList);
		return "BookList";
	}
}
