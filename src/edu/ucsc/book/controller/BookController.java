package edu.ucsc.book.controller;

import java.util.ArrayList;

import edu.ucsc.book.datasources.BookDB;
import edu.ucsc.book.datasources.BookDAO;
import edu.ucsc.shopping.model.Book;
import edu.ucsc.shopping.model.BookCart;
import edu.ucsc.shopping.model.BookCartItem;
import edu.ucsc.shopping.model.Customer;

/**
 * 
 * This class represents a BookController which gets data from the dataSource
 * and passes it to the view. It executes the actions on model as requested by
 * the view.
 * 
 * @author pallavidas
 *
 */
public class BookController {
	private BookDAO bookdbObj;
	private Customer customerObj = null;

	public BookController() {
		bookdbObj = BookDB.getBookdbInstance();
		customerObj = new Customer();
	}

	/**
	 * This method retrives list of books from the database
	 * 
	 * @return - arrayList of books of typr Book
	 */
	public ArrayList<Book> getAllBooks() {
		return bookdbObj.getBooks();
	}

	/**
	 * This method is used to add new book to the database
	 * 
	 * @param bookObj
	 *            - object of type Book that holds book attributes and
	 *            properties.
	 * @return - state of addition of books true - addition complete false -
	 *         addition failed
	 */
	public boolean addNewBook(Book bookObj) {
		return bookdbObj.addBook(bookObj);
	}

	/**
	 * This method is used to delete a book from the database.
	 * 
	 * @param bookObj
	 *            - object of type Book that holds book attributes and
	 *            properties.
	 * @return - state of deletion of books true - deletion complete false -
	 *         addition failed
	 */
	public boolean delBook(Book bookObj) {
		return bookdbObj.deleteBook(bookObj);
	}

	/**
	 * This method is used to add book to the cart by customer
	 * 
	 * @param bookItem
	 *            - bookItem that holds books selected and their quantities.
	 */
	public void addBookToCart(BookCartItem bookItem) {
		customerObj.getBookCart().addBook(bookItem);
	}

	/**
	 * This method is used to delete book from the cart.
	 * 
	 * @param index
	 *            - index of book in the bookCartList.
	 */
	public void removeBookFromCart(int index) {
		customerObj.getBookCart().removeBook(index);
	}

	/**
	 * This method gets all the books from the cart.
	 * 
	 * @return - arrayList of type BookCartItem
	 */
	public ArrayList<BookCartItem> getBooksFromCart() {
		return customerObj.getBookCart().getBookItems();
	}

	/**
	 * This method gets total amount for the books in the cart.
	 * 
	 * @return - total amount
	 */
	public double getBookInvoiceTotal() {
		return customerObj.getBookCart().getInvoiceTotal();
	}

	/**
	 * This method gets formatted total amount in the cart.
	 * 
	 * @return - formatted amount.
	 */
	public String getFormattedBookTotal() {
		return customerObj.getBookCart().getFormattedTotal();
	}
}
