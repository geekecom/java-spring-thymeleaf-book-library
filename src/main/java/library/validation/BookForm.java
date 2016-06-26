package library.validation;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class BookForm {
	@NotNull
	private int id_book;

	@NotNull
	@Size(min = 2, max = 256)
	private String title;

	@NotNull
	@Size(min = 2, max = 256)
	private String author;

	@NotNull
	@Size(min = 13, max = 13)
	private String isbn;
	

	public int getId_book() {
		return id_book;
	}

	public void setId_book(int id_book) {
		this.id_book = id_book;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	@Override
	public String toString() {
		return "Book [id_book=" + id_book + ", title=" + title + ", author=" + author + ", isbn=" + isbn + "]";
	}
}
