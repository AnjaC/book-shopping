package edu.ucsc.shopping.model;

import java.text.NumberFormat;

/**
 * This class holds all book attributes like book name, book code and price.
 * 
 * @author pallavidas
 *
 */
public class Book {
	private String bookCode;
	private String bookName;
	private double price;

	public Book() {
		bookCode = "";
		bookName = "";
		price = 0;
	}

	public Book(String bookCode, String bookName, double price) {
		this.bookCode = bookCode;
		this.bookName = bookName;
		this.price = price;
	}

	/**
	 * This method sets the book code.
	 * 
	 * @param bookCode
	 *            - code of the book of type String
	 */
	public void setBookCode(String bookCode) {
		this.bookCode = bookCode;
	}

	/**
	 * This method returs books code
	 * 
	 * @return - bookCode
	 */
	public String getBookCode() {
		return bookCode;
	}

	/**
	 * this method sets book name
	 * 
	 * @param bookName
	 *            - book name
	 */
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	/**
	 * this metho return book name
	 * 
	 * @return - book name
	 */
	public String getBookName() {
		return bookName;
	}

	/**
	 * this method sets price
	 * 
	 * @param price
	 *            - price of each book.
	 */
	public void setPrice(double price) {
		this.price = price;
	}

	/**
	 * This method return price
	 * 
	 * @return - price value
	 */
	public double getPrice() {
		return price;
	}

	/**
	 * This methods formats price.
	 * 
	 * @return - formatted price value
	 */
	public String getFormattedPrice() {
		NumberFormat currency = NumberFormat.getCurrencyInstance();
		return currency.format(price);
	}

}
