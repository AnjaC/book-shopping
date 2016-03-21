package edu.ucsc.shopping.model;

import java.text.NumberFormat;
import java.util.ArrayList;

/**
 * 
 * This class holds all book attributes like book name, book code and price.
 * 
 * @author pallavidas
 *
 */
public class BookCart {
	private ArrayList<BookCartItem> bookItems;

	public BookCart() {
		bookItems = new ArrayList<>();
	}

	/**
	 * This method adds book selected by customer to the cart.
	 * 
	 * @param bookItem
	 *            - bookItem of type BookCartItem
	 * 
	 */
	public void addBook(BookCartItem bookItem) {
		bookItems.add(bookItem);
	}

	/**
	 * This method removes book from the cart.
	 * 
	 * @param index
	 *            - index value of book in the bookList.
	 */
	public void removeBook(int index) {
		bookItems.remove(index);
	}

	/**
	 * This method returns an arrayList of books of type Bo
	 * 
	 * @return - array of bookItems
	 */
	public ArrayList<BookCartItem> getBookItems() {
		return bookItems;
	}

	/**
	 * This method calculates the amount of total books in the cart.
	 * 
	 * @return - total amount
	 */
	public double getInvoiceTotal() {
		double invoiceTotal = 0;
		for (BookCartItem bookItem : this.bookItems) {
			invoiceTotal += bookItem.getTotal();
		}
		return invoiceTotal;
	}

	/**
	 * method that returns the invoice total in currency format
	 * 
	 * @return - formatted total amount
	 */
	public String getFormattedTotal() {
		NumberFormat currency = NumberFormat.getCurrencyInstance();
		return currency.format(this.getInvoiceTotal());
	}

}
