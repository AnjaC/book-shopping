package edu.ucsc.shopping.model;

import java.text.NumberFormat;

/**
 * method that returns the invoice total in currency format
 * 
 * @author pallavidas
 *
 */
public class BookCartItem {
	private Book book;
	private int quantity;
	private double total = 0;

	public BookCartItem() {
		this.book = new Book();
		this.quantity = 0;
	}

	public BookCartItem(Book book, int quantity) {
		this.book = book;
		this.quantity = quantity;
	}

	public BookCartItem(Book book) {
		this.book = book;
	}

	/**
	 * method sets new book
	 * 
	 * @param book
	 *            - of type Book
	 */
	public void setBook(Book book) {
		this.book = book;
	}

	/**
	 * method used to current get book
	 * 
	 * @return - Book
	 */
	public Book getBook() {
		return book;
	}

	/**
	 * method used to set a quantity of book.
	 * 
	 * @param quantity
	 *            - integer type
	 */
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	/**
	 * method gets current quantity of books
	 * 
	 * @return - integer type
	 */
	public int getQuantity() {
		return quantity;
	}

	/**
	 * method sets new book total
	 * 
	 * @param total
	 *            - book total of type double
	 */
	public void setTotal(double total) {
		this.total = total;
	}

	/**
	 * method gets current total price of books
	 * 
	 * @return - total amount of books.
	 */
	public double getTotal() {
		return total;
	}

	/**
	 * method calculates price per bookname
	 * 
	 * @param quantity
	 *            - number of book per bookname
	 * @param book
	 *            - book object
	 */
	public void calculateTotal(int quantity, Book book) {
		total = quantity * book.getPrice();
	}

	/**
	 * method gets formatted price of books in the cart.
	 * 
	 * @return - formatted price
	 */
	public String getFormattedTotal() {
		calculateTotal(this.getQuantity(), this.book);
		NumberFormat currency = NumberFormat.getCurrencyInstance();
		return currency.format(total);
	}
}
