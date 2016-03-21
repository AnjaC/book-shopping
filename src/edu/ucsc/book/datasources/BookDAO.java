package edu.ucsc.book.datasources;

import java.util.ArrayList;

import edu.ucsc.shopping.model.Book;

/**
 * 
 * This is an interface that provides access to underlying derby database.
 * 
 * @author pallavidas
 *
 */
public interface BookDAO {
	/**
	 * This method is use to get list of books from the database.
	 * 
	 * @return - list of books of type Book.
	 */
	public ArrayList<Book> getBooks();

	/**
	 * This method is used to add new book to the database.
	 * 
	 * @param bookObj
	 *            - an object of type Book
	 * @return - status of adding process true - addition complete false -
	 *         addition failed.
	 */
	public boolean addBook(Book bookObj);

	/**
	 * This method is used to delete book from the database.
	 * 
	 * @param bookobj
	 *            - object of type Book
	 * @return - status of deletion process. true - deletion complete false -
	 *         deletion failed
	 */
	public boolean deleteBook(Book bookobj);
}
