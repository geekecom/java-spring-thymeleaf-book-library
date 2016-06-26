package library.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import library.model.Book;

@Service
@Repository
@Transactional
public class BookDAO {

	private static final Logger logger = LoggerFactory.getLogger(BookDAO.class);

	@Autowired
	private SessionFactory sessionFactory;

	public void addBook(Book book) {
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(book);
		logger.info("Book saved successfully, Book Details=" + book);
	}

	public void updateBook(Book book) {
		Session session = this.sessionFactory.getCurrentSession();
			session.update(book);
		logger.info("Book updated successfully, Book Details=" + book);
	}

	@SuppressWarnings("unchecked")
	public List<Book> listBook() {
		Session session = this.sessionFactory.getCurrentSession();
		List<Book> bookList = session.createQuery("from Book").list();
		for (Book book : bookList) {
			logger.info("Book List::" + book);
		}
		return bookList;
	}

	public Book getBookById(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		Book book = (Book) session.load(Book.class, new Integer(id));
		logger.info("Book loaded successfully, Book details=" + book);
		return book;
	}

	public void removeBook(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		Book book = (Book) session.load(Book.class, new Integer(id));
		if (null != book) {
			session.delete(book);
			logger.info("Book deleted successfully, Book details=" + book);
		}
		logger.info("[ERROR] Book undeleted successfully, Book details=" + book);
	}

}
