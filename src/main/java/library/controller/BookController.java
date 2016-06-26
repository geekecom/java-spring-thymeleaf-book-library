package library.controller;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import library.dao.BookDAO;
import library.dao.LoanDAO;
import library.model.Book;
import library.model.Loan;

@Controller
public class BookController {

	private static final Logger logger = LoggerFactory.getLogger(BookController.class);

	@ModelAttribute("book")
	public Book getBookObject() {
		return new Book();
	}

	@Autowired
	private BookDAO bookDAO;

	@Autowired
	private LoanDAO loanDAO;

	@RequestMapping(value = "/book")
	public String listBook(Model model) {
		List<Loan> loanList = this.loanDAO.listLoan();
		List<Book> bookList = this.bookDAO.listBook();

		model.addAttribute("bookList", bookList);
		
		return "book";
	}

	// For add and update book both
	@RequestMapping(value = "/book/add")
	public String addBook(@Valid Book book, BindingResult bindingResult) {

		if (bindingResult.hasErrors()) {
			logger.info("[ERROR] Book no valid: " + book.toString());
		} else {
			this.bookDAO.addBook(book);
		}
		return "redirect:/book";
	}

	@RequestMapping("book/remove/{id_book}")
	public String removeBook(@PathVariable("id_book") int id_book) {

		this.bookDAO.removeBook(id_book);
		return "redirect:/book";
	}

	@RequestMapping("book/edit/{id_book}")
	public String editBook(@PathVariable("id_book") int id_book, Model model) {
		Book book = bookDAO.getBookById(id_book);
		model.addAttribute("book", book);
		return "book-edit";
	}

	@RequestMapping("book/edit")
	public String editBook(@Valid Book book, Model model) {
		bookDAO.updateBook(book);
		return "redirect:/book";
	}

}